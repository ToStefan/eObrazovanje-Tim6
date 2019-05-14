package eobrazovanje.tim6.app.web.mapper;

import java.util.Collection;
import java.util.Set;

public interface Mapper<E, DTO> {
	DTO toDTO(E entity);
	E toEntity(DTO dto);
	Set<DTO> toDTO(Collection<E> entities);
	Set<E> toEntity(Collection<DTO> dtos);
}
