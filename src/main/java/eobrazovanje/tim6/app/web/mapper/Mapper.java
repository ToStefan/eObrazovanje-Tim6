package eobrazovanje.tim6.app.web.mapper;

import java.util.Collection;

public interface Mapper<E, DTO> {
	DTO toDTO(E entity);
	E toEntity(DTO dto);
	Collection<DTO> toDTO(Collection<E> entities);
	Collection<E> toEntity(Collection<DTO> dtos);
}
