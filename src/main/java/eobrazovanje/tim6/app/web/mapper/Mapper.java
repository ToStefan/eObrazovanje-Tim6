package eobrazovanje.tim6.app.web.mapper;

import java.util.Set;

public interface Mapper<E, DTO> {
	DTO toDTO(E e);
	E toEntity(DTO dto);
	Set<DTO> toDTO(Set<E> es);
	Set<E> toEntity(Set<DTO> dtos);
}
