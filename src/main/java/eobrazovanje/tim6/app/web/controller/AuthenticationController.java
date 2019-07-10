package eobrazovanje.tim6.app.web.controller;

import java.security.Principal;
import java.util.ArrayList;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import eobrazovanje.tim6.app.entity.Role;
import eobrazovanje.tim6.app.entity.User;
import eobrazovanje.tim6.app.exception.UsernameNotAvailibleException;
import eobrazovanje.tim6.app.repository.RoleRepository;
import eobrazovanje.tim6.app.security.JwtAuthenticationResponse;
import eobrazovanje.tim6.app.security.JwtTokenProvider;
import eobrazovanje.tim6.app.service.impl.StaffService;
import eobrazovanje.tim6.app.service.impl.StudentService;
import eobrazovanje.tim6.app.service.impl.UserService;
import eobrazovanje.tim6.app.web.dto.LoginDTO;
import eobrazovanje.tim6.app.web.dto.MeDTO;
import eobrazovanje.tim6.app.web.dto.RegisterDTO;
import eobrazovanje.tim6.app.web.dto.UserDTO;
import eobrazovanje.tim6.app.web.mapper.StaffMapper;
import eobrazovanje.tim6.app.web.mapper.StudentMapper;
import eobrazovanje.tim6.app.web.mapper.UserMapper;



@RestController
@RequestMapping("/api/auth")
public class AuthenticationController {
	
	@Autowired
	AuthenticationManager authenticationManager;
	
	@Autowired
    UserService userService;
	
	@Autowired
	StudentService studentService;
	
	@Autowired
	StaffService staffService;
	
    @Autowired
    RoleRepository roleRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    JwtTokenProvider tokenProvider;
    
    @Autowired
    UserMapper userMapper;
    
    @Autowired
    StudentMapper studentMapper;
    
    @Autowired
    StaffMapper staffMapper;
    
    
    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginDTO loginDto) {
    	
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginDto.getUsername(),
                        loginDto.getPassword()
                )
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwt = tokenProvider.generateToken(authentication);
        return ResponseEntity.ok(new JwtAuthenticationResponse(jwt));
    }
    
    
    
   
    @PostMapping("/signup")
    public ResponseEntity<UserDTO> registerNewUser(@RequestBody RegisterDTO registerDTO) throws Exception {
        if (userService.usernameExists(registerDTO.getUsername())) {
            throw new UsernameNotAvailibleException("There is an account with that username");
        }
        User newUser =  userService.save(userMapper.registerDTOtoEntity(registerDTO));
        return new ResponseEntity<UserDTO>(userMapper.toDTO(newUser), HttpStatus.CREATED);
    }
    
    
    @GetMapping("/me")
    public ResponseEntity<?> getMe(Principal principal){
    	User user = userService.findByUserName(principal.getName());
    	ArrayList<Object> userTypes = new ArrayList<Object>();
    	for(Role r : user.getRoles()) {
    		if(r.getName().name().equals("ROLE_STUDENT")) {
    			MeDTO meDTO = new MeDTO();
    			meDTO.setUserType("student");
    			meDTO.setUserData(studentMapper.toDTO(studentService.findByUserId(user.getId())));
    			userTypes.add(meDTO);
    		}
    		
    		if(r.getName().name().equals("ROLE_PROFESOR")) {
    			MeDTO meDTO = new MeDTO();
    			meDTO.setUserType("staff");
    			meDTO.setUserData(staffMapper.toDTO(staffService.findByUserId(user.getId())));
    			userTypes.add(meDTO);
    		}
    	}
    	return new ResponseEntity<Object>(userTypes, HttpStatus.CREATED);
    }

}
