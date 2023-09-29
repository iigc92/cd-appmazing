package com.campusdual.appmazing.controller;

import com.campusdual.appmazing.api.IContactoService;
import com.campusdual.appmazing.model.dto.ContactoDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.lang.model.element.Name;
import java.util.List;

@RestController
@RequestMapping("/contactos") //controlador de esta clase
public class ContactoController {

    @Autowired
    private IContactoService contactoService;

    @GetMapping
    public String testController(){
        return "Contacto controller works";
    }

    @PostMapping
    public String testController(@RequestBody String name){
        return "Contacto controller works, " + name + "!";
    }

    @GetMapping(value = "/testMethod")
    public String testControllerMethod(){
        return "Contacto controller method works";
    }

    @PostMapping(value="/get")
    public ContactoDto QueryContacto(@RequestBody ContactoDto contacto){
        return this.contactoService.queryContacto(contacto);
    }

    @GetMapping(value="/getAll")
    public List<ContactoDto> queryAllContactos(){
        return this.contactoService.queryAllContactos();
    }

    @PostMapping(value="/add")
    public int insertContacto(@RequestBody ContactoDto contacto){
        return this.contactoService.insertContacto(contacto);
    }

    @PutMapping(value = "/update")
    public int updateContacto(@RequestBody ContactoDto contacto){
        return this.contactoService.updateContacto(contacto);
    }

    @DeleteMapping(value = "/delete")
    public int deleteContacto(@RequestBody ContactoDto contacto){
        return this.contactoService.deleteContacto(contacto);
    }
}