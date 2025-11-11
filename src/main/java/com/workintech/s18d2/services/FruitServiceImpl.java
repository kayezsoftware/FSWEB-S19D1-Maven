package com.workintech.s18d2.services;

import com.workintech.s18d2.dao.FruitRepository;
import com.workintech.s18d2.entity.Fruit;
import com.workintech.s18d2.exceptions.PlantException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FruitServiceImpl implements FruitService {

    private final FruitRepository fruitRepository; // README: dao paketi

    @Autowired
    public FruitServiceImpl(FruitRepository fruitRepository) {
        this.fruitRepository = fruitRepository;
    }

    @Override
    public Fruit getById(long id) {
        // README: id 0'dan küçükse hata döndürmeli
        if (id <= 0) {
            throw new PlantException("Invalid ID: " + id, HttpStatus.BAD_REQUEST);
        }
        Optional<Fruit> optionalFruit = fruitRepository.findById(id);
        // README: id veritabanında yoksa hata döndürmeli
        return optionalFruit.orElseThrow(() -> new PlantException("Fruit not found with id: " + id, HttpStatus.NOT_FOUND));
    }

    @Override
    public List<Fruit> getByPriceAsc() {
        return fruitRepository.getByPriceAsc(); //
    }

    @Override
    public List<Fruit> getByPriceDesc() {
        return fruitRepository.getByPriceDesc(); //
    }

    @Override
    public Fruit save(Fruit fruit) {
        // README: Insert/Update eksik data yollanırsa hata
        if (fruit.getName() == null || fruit.getName().isEmpty() || fruit.getPrice() == null || fruit.getFruitType() == null) {
            throw new PlantException("Fruit data is incomplete", HttpStatus.BAD_REQUEST);
        }
        return fruitRepository.save(fruit); //
    }

    @Override
    public Fruit delete(long id) {
        Fruit fruitToDelete = getById(id); // getById, bulunamazsa zaten hata fırlatır
        fruitRepository.delete(fruitToDelete);
        return fruitToDelete; //
    }

    @Override
    public List<Fruit> searchByName(String name) {
        return fruitRepository.searchByName(name); //
    }
}