package eobrazovanje.tim6.app.web.mapper;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import eobrazovanje.tim6.app.entity.AcademicRole;
import eobrazovanje.tim6.app.web.dto.AcademicRoleDTO;

@Component
public class AcademicRoleMapper implements Mapper<AcademicRole, AcademicRoleDTO> {

    @Override
    public AcademicRoleDTO toDTO(AcademicRole entity) {

        AcademicRoleDTO ardto = new AcademicRoleDTO();
        ardto.setId(entity.getId());
        ardto.setName(entity.getName());
        ardto.setDeleted(entity.getDeleted());
        ardto.setVersion(entity.getVersion());
        //TODO POStaviti i setove staff i engagement
        return ardto;
    }

    @Override
    public AcademicRole toEntity(AcademicRoleDTO dto) {
        AcademicRole ar = new AcademicRole();
        ar.setId(dto.getId());
        ar.setName(dto.getName());
        ar.setDeleted(dto.getDeleted());
        ar.setVersion(dto.getVersion());
        //TODO postaviti setove staff i engagement
        return ar;
    }

    @Override
    public Set<AcademicRoleDTO> toDTO(Collection<AcademicRole> entities) {
        return entities
                .stream()
                .map(ar -> toDTO(ar))
                .collect(Collectors.toSet());
    }

    @Override
    public Set<AcademicRole> toEntity(Collection<AcademicRoleDTO> dtos) {
        return dtos
                .stream()
                .map(arDTO -> toEntity(arDTO))
                .collect(Collectors.toSet());

    }

}
