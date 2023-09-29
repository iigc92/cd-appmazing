package com.campusdual.appmazing.model.dao;

import com.campusdual.appmazing.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryDao extends JpaRepository<Category,Integer> {
    // extiende JpaRep que contrendrá el modelo y la pk que es Integer
}
