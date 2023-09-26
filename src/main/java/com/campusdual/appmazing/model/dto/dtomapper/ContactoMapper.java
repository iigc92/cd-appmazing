package com.campusdual.appmazing.model.dto.dtomapper;

import com.campusdual.appmazing.model.Contacto;
import com.campusdual.appmazing.model.dto.ContactoDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper //indica que mapestruct la libreria lo va ejecutar
public interface ContactoMapper {
    ContactoMapper INSTANCE = Mappers.getMapper(ContactoMapper.class);
    //necesita 3 metodos
    ContactoDto toDTO(Contacto contacto);
    List<ContactoDto> toDTOList(List<Contacto> contactos);
    Contacto toEntity(ContactoDto contactoDto);
}