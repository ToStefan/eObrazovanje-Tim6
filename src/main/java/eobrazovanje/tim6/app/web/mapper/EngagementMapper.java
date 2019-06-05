package eobrazovanje.tim6.app.web.mapper;


import eobrazovanje.tim6.app.entity.Engagement;
import eobrazovanje.tim6.app.web.dto.EngagementDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class EngagementMapper implements Mapper<Engagement, EngagementDTO> {

    @Autowired
    StaffMapper staffMapper;

    @Autowired
    CourseMapper courseMapper;

    @Autowired
    AcademicRoleMapper academicRoleMapper;

    @Override
    public EngagementDTO toDTO(Engagement engagement) {
        EngagementDTO eDTO = new EngagementDTO();
        eDTO.setId(engagement.getId());
        eDTO.setAcademicRoleDTO(academicRoleMapper.toDTO(engagement.getAcademicRole()));
        eDTO.setCourseDTO(courseMapper.toDTO(engagement.getCourse()));
        eDTO.setStaffDTO(staffMapper.toDTO(engagement.getStaff()));
        eDTO.setDeleted(engagement.getDeleted());
        eDTO.setVersion(engagement.getVersion());
        return eDTO;
    }

    @Override
    public Set<EngagementDTO> toDTO(Collection<Engagement> entities) {
        return entities.stream().map(engagement -> toDTO(engagement)).collect(Collectors.toSet());
    }

    public Set<EngagementDTO> toDTO(Page<Engagement> engagementPage) {
        return engagementPage.stream().map(engagement -> toDTO(engagement)).collect(Collectors.toSet());
    }

    @Override
    public Engagement toEntity(EngagementDTO engagementDTO) {

        Engagement engagement = new Engagement();
        engagement.setVersion(engagementDTO.getVersion());
        engagement.setDeleted(engagementDTO.getDeleted());

        return engagement;

    }

    @Override
    public Set<Engagement> toEntity(Collection<EngagementDTO> dtos) {
        return dtos.stream().map(dto -> toEntity(dto)).collect(Collectors.toSet());
    }


}
