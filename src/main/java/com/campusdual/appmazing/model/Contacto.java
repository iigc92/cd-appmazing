package com.campusdual.appmazing.model;

import javax.persistence.*;

@Entity
@Table(name = "CONTACTOS")
public class Contacto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //como genera los numeros, incrementa
    private int id;
    @Column
    private String name;
    @Column
    private String apellido_1;
    @Column
    private String apellido_2;
    @Column
    private String email;
    @Column
    private String telefono;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getApellido_1() {
        return apellido_1;
    }

    public void setApellido_1(String apellido_1) {
        this.apellido_1 = apellido_1;
    }

    public String getApellido_2() {
        return apellido_2;
    }

    public void setApellido_2(String apellido_2) {
        this.apellido_2 = apellido_2;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}
