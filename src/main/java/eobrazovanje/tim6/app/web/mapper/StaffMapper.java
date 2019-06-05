package eobrazovanje.tim6.app.web.mapper;

import eobrazovanje.tim6.app.entity.Staff;
import eobrazovanje.tim6.app.web.dto.StaffDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class StaffMapper implements Mapper<Staff, StaffDTO> {

    @Autowired
    AcademicRoleMapper academicRoleMapper;

    @Autowired
    EngagementMapper engagementMapper;

    @Override
    public StaffDTO toDTO(Staff staff) {
        StaffDTO staffDTO = new StaffDTO();
        staffDTO.setId(staff.getId());
        staffDTO.setFirstName(staff.getFirstName());
        staffDTO.setLastName(staff.getLastName());
        staffDTO.setDeleted(staff.getDeleted());
        staffDTO.setVersion(staff.getVersion());
        staffDTO.setArDTO(academicRoleMapper.toDTO(staff.getAcademicRole()));
        //staffDTO.setEngagementsDTO(engagementMapper.toDTO(staff.getEngagements()));
        //staffDTO.setUserDTO();
        return staffDTO;
    }

    @Override
    public Staff toEntity(StaffDTO staffDTO) {
        Staff staff = new Staff();

        staff.setFirstName(staffDTO.getFirstName());
        staff.setLastName(staffDTO.getLastName());
        staff.setVersion(staffDTO.getVersion());
        staff.setDeleted(staffDTO.getDeleted());
        staff.setAcademicRole(academicRoleMapper.toEntity(staffDTO.getArDTO()));
        staff.setEngagements(engagementMapper.toEntity(staffDTO.getEngagementsDTO()));

        //user

        return staff;
    }

    @Override
    public Set<StaffDTO> toDTO(Collection<Staff> entities) {
        return entities.stream().map(staff -> toDTO(staff)).collect(Collectors.toSet());
    }

    public Set<StaffDTO> toDTO(Page<Staff> staffPage) {
        return staffPage
                .stream()
                .map(staff -> toDTO(staff))
                .collect(Collectors.toSet());
    }

    @Override
    public  Set<Staff> toEntity(Collection<StaffDTO> dtos) {
        return dtos.stream().map(sDTO -> toEntity(sDTO)).collect(Collectors.toSet());
    }



}
