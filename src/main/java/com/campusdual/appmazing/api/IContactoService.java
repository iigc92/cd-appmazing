package com.campusdual.appmazing.api;

import com.campusdual.appmazing.model.dto.ContactoDto;
import com.campusdual.appmazing.model.dto.ProductDto;

import java.util.List;

public interface IContactoService {

    public ContactoDto queryContacto(ContactoDto contacto); //le pasamos el dto un name p.ej y el nos da toda la info
    List<ContactoDto> queryAllContactos();  //metodo que consulta todoo

    int insertContacto(ContactoDto contacto);

    int updateContacto(ContactoDto contacto);

    int deleteContacto(ContactoDto contacto);

}
