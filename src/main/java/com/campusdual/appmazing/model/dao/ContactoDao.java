package com.campusdual.appmazing.model.dao;

import com.campusdual.appmazing.model.Contacto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactoDao extends JpaRepository<Contacto, Integer> {
}
