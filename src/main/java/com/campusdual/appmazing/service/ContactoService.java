package com.campusdual.appmazing.service;

import com.campusdual.appmazing.api.IContactoService;
import com.campusdual.appmazing.model.Contacto;
import com.campusdual.appmazing.model.dao.ContactoDao;
import com.campusdual.appmazing.model.dto.ContactoDto;
import com.campusdual.appmazing.model.dto.dtomapper.ContactoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("ContactoService")  //indica que la clase es un service
@Lazy
public class ContactoService implements IContactoService {

    @Autowired
    private ContactoDao contactoDao;
    @Override
    public ContactoDto queryContacto(ContactoDto contactoDto) {
        Contacto contacto = ContactoMapper.INSTANCE.toEntity(contactoDto);
        Contacto contactoFinal = this.contactoDao.getReferenceById(contacto.getId());
        ContactoDto dto = ContactoMapper.INSTANCE.toDto(contactoFinal);
        return dto;
    }

    @Override
    public List<ContactoDto> queryAllContactos() {
        return ContactoMapper.INSTANCE.toDtoList(this.contactoDao.findAll());
    }

    @Override
    public int insertContacto(ContactoDto contactoDto) { //pasa todos los datos menos el id
        Contacto contacto = ContactoMapper.INSTANCE.toEntity(contactoDto);
        Contacto contacto1 = this.contactoDao.saveAndFlush(contacto);
        return contacto1.getId();
    }

    @Override
    public int updateContacto(ContactoDto contactoDto) { // devuelve todoo con el id
        return this.insertContacto(contactoDto);
    }

    @Override
    public int deleteContacto(ContactoDto contactoDto) {
        int id = contactoDto.getId();
        Contacto contacto = ContactoMapper.INSTANCE.toEntity(contactoDto);
        this.contactoDao.delete(contacto);
        return id;
    }
}
