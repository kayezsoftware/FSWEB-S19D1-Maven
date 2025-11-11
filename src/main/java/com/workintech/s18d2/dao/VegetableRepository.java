package com.workintech.s18d2.dao;

import com.workintech.s18d2.entity.Vegetable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface VegetableRepository extends JpaRepository<Vegetable, Long> {

    // README: ücrete göre azalan sırada
    @Query("SELECT v FROM Vegetable v ORDER BY v.price DESC")
    List<Vegetable> getByPriceDesc();

    // README: ücrete göre artan sırada
    @Query("SELECT v FROM Vegetable v ORDER BY v.price ASC")
    List<Vegetable> getByPriceAsc();

    // README: yollanan bir parametre name içerisinde geçiyorsa
    @Query("SELECT v FROM Vegetable v WHERE v.name ILIKE %:name%")
    List<Vegetable> searchByName(@Param("name") String name);
}
