package eobrazovanje.tim6.app.web.controller;

import eobrazovanje.tim6.app.entity.Staff;
import eobrazovanje.tim6.app.web.dto.StaffDTO;
import eobrazovanje.tim6.app.web.mapper.StaffMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import eobrazovanje.tim6.app.service.impl.StaffService;


import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping(value = "api/staff")
public class StaffController {
	
	@Autowired
	private StaffService staffService;

	@Autowired
	private StaffMapper staffMapper;

	@GetMapping
	public ResponseEntity<Set<StaffDTO>> getStaff(Pageable pageable) {
		try {
			Page<Staff> staff = staffService.findAll(pageable);
			return new ResponseEntity<Set<StaffDTO>>(staffMapper.toDTO(staff), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<StaffDTO> getOneStaff(@PathVariable("id") Long id) {
		return new ResponseEntity<StaffDTO>(staffMapper.toDTO(staffService.findOne(id)), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<StaffDTO> addStaff(@RequestBody StaffDTO staffDTO){
		Staff staff = staffMapper.toEntity(staffDTO);
		try {
			staff=staffService.save(staff);
			return new ResponseEntity<StaffDTO>(staffMapper.toDTO(staff), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<StaffDTO>(HttpStatus.BAD_REQUEST);
		}

	}

	@PutMapping
	public  ResponseEntity<StaffDTO> updateStaff (@RequestBody StaffDTO staffDTO) {
		try {
			Staff staff = staffService.findOne(staffDTO.getId());
			if (staff==null) {
				return new ResponseEntity<StaffDTO>(HttpStatus.NOT_FOUND);
			}
			staff = staffMapper.toEntity(staffDTO);
			staff = staffService.save(staff);
			return new ResponseEntity<StaffDTO>(staffMapper.toDTO(staff), HttpStatus.OK);
		}catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<StaffDTO>(HttpStatus.BAD_REQUEST);
		}
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> deleteStaff(@PathVariable("id") Long id) {
		try {
			Staff staff = staffService.findOne(id);
			staff.setDeleted(true);
			return new ResponseEntity<Void>(HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
	}
	
}
