package com.campusdual.appmazing.model;

import javax.persistence.*;

@Entity //indica que es un modelo o entidad
@Table(name = "CATEGORIES") //indica a que tabla hace referencia
public class Category {

    @Id //indica cual es la columna pk
    @GeneratedValue(strategy = GenerationType.IDENTITY) //indica que es un autoincremental
    private int id;

    @Column //indica que es una columna
    private String name;

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
}
