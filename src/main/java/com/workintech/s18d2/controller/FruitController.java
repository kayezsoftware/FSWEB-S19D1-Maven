package com.workintech.s18d2.controller;

import com.workintech.s18d2.entity.Fruit;
import com.workintech.s18d2.services.FruitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// Test dosyasına göre RequestMapping "/fruit"
// README: /workintech/fruits istiyor
@RestController
@RequestMapping("/fruit")
public class FruitController {

    private final FruitService fruitService;

    @Autowired
    public FruitController(FruitService fruitService) {
        this.fruitService = fruitService;
    }

    // README: [GET]/workintech/fruits => artan sırada
    // Test: [GET] /fruit
    @GetMapping
    public List<Fruit> getFruitsAsc() {
        return fruitService.getByPriceAsc();
    }

    // README: [GET]/workintech/fruits/desc => azalan sırada
    // Test: [GET] /fruit/desc
    @GetMapping("/desc")
    public List<Fruit> getFruitsDesc() {
        return fruitService.getByPriceDesc();
    }

    // README: [GET]/workintech/fruits/{id}
    // Test: [GET] /fruit/{id}
    @GetMapping("/{id}")
    public Fruit getById(@PathVariable long id) {
        return fruitService.getById(id);
    }

    // README: [POST]/workintech/fruits/{name} (REST standardına aykırı)
    // Test: [GET] /fruit/name/{name} (Bu daha mantıklı)
    @GetMapping("/name/{name}")
    public List<Fruit> getByName(@PathVariable String name) {
        return fruitService.searchByName(name);
    }

    // README: [POST]/workintech/fruits
    // Test: [POST] /fruit
    @PostMapping
    public Fruit save(@RequestBody Fruit fruit) {
        // README Görev 4: Başarılı mesajı dönmeli
        // ANCAK Test direkt objeyi bekliyor
        return fruitService.save(fruit);
    }

    // README: [DELETE]/workintech/fruits/{id}
    // Test: [DELETE] /fruit/{id}
    @DeleteMapping("/{id}")
    public Fruit delete(@PathVariable long id) {
        return fruitService.delete(id);
    }
}
