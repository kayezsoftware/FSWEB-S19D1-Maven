package com.workintech.s18d2.services;

import com.workintech.s18d2.entity.Vegetable;
import java.util.List;

public interface VegetableService {
    Vegetable getById(long id);
    List<Vegetable> getByPriceAsc();
    List<Vegetable> getByPriceDesc();
    Vegetable save(Vegetable vegetable);
    Vegetable delete(long id);
    List<Vegetable> searchByName(String name);
}
