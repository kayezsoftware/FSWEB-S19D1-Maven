package com.workintech.s18d2.dao;

import com.workintech.s18d2.entity.Fruit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

// README: dao paketinde olmalı
// MainTest: FruitRepository adında olmalı
public interface FruitRepository extends JpaRepository<Fruit, Long> {

    // README: ücrete göre azalan sırada
    // MainTest: getByPriceDesc()
    @Query("SELECT f FROM Fruit f ORDER BY f.price DESC")
    List<Fruit> getByPriceDesc();

    // README: ücrete göre artan sırada
    // MainTest: getByPriceAsc()
    @Query("SELECT f FROM Fruit f ORDER BY f.price ASC")
    List<Fruit> getByPriceAsc();

    // README: yollanan bir parametre name içerisinde geçiyorsa
    // MainTest: searchByName(String name)
    @Query("SELECT f FROM Fruit f WHERE f.name ILIKE %:name%")
    List<Fruit> searchByName(@Param("name") String name);
}
