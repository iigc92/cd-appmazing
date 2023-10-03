package com.campusdual.appmazing.model;


import com.campusdual.appmazing.model.dto.CategoryDto;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity  //es el modelo , persistente
@Table(name = "PRODUCTS") //asociamos la tabla producto a la clase, en mayuscula porque esta asi en la bd
public class Product {

    @Id //es clave primaria
    @GeneratedValue(strategy = GenerationType.IDENTITY) //como genera los numeros, incrementa
    private int id; // las variables por convencion son en minusculas
    @Column
    private String name;
    @Column
    private int stock;
    @Column
    private BigDecimal price; //sistema de decimales, corta en dos decimales, no hay mas pequeño que 1cent
    @Column
    private boolean active;
    @Column
    private Date date_added;

    @ManyToOne
    @JoinColumn(name="category") //Es calve foranea, nombre de la columna
    private Category category;

    //get y set utilizados para el autowired

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

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Date getDate_added() {
        return date_added;
    }

    public void setDate_added(Date date_added) {
        this.date_added = date_added;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
