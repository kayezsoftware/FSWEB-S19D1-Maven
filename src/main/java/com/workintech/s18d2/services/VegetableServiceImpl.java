package com.workintech.s18d2.services;

import com.workintech.s18d2.dao.VegetableRepository;
import com.workintech.s18d2.entity.Vegetable;
import com.workintech.s18d2.exceptions.PlantException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VegetableServiceImpl implements VegetableService {

    private final VegetableRepository vegetableRepository;

    @Autowired
    public VegetableServiceImpl(VegetableRepository vegetableRepository) {
        this.vegetableRepository = vegetableRepository;
    }

    @Override
    public Vegetable getById(long id) {
        if (id <= 0) {
            throw new PlantException("Invalid ID: " + id, HttpStatus.BAD_REQUEST);
        }
        Optional<Vegetable> optionalVegetable = vegetableRepository.findById(id);
        return optionalVegetable.orElseThrow(() -> new PlantException("Vegetable not found with id: " + id, HttpStatus.NOT_FOUND));
    }

    @Override
    public List<Vegetable> getByPriceAsc() {
        return vegetableRepository.getByPriceAsc();
    }

    @Override
    public List<Vegetable> getByPriceDesc() {
        return vegetableRepository.getByPriceDesc();
    }

    @Override
    public Vegetable save(Vegetable vegetable) {
        if (vegetable.getName() == null || vegetable.getName().isEmpty() || vegetable.getPrice() == null) {
            throw new PlantException("Vegetable data is incomplete", HttpStatus.BAD_REQUEST);
        }
        return vegetableRepository.save(vegetable);
    }

    @Override
    public Vegetable delete(long id) {
        Vegetable vegetableToDelete = getById(id);
        vegetableRepository.delete(vegetableToDelete);
        return vegetableToDelete;
    }

    @Override
    public List<Vegetable> searchByName(String name) {
        return vegetableRepository.searchByName(name);
    }
}


