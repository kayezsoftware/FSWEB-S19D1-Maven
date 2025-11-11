package com.workintech.s18d2.controller;

import com.workintech.s18d2.dto.SuccessResponse;
import com.workintech.s18d2.entity.Fruit;
import com.workintech.s18d2.services.FruitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// README: /workintech/fruits
// FruitController'ı baz alarak "/fruit" kullanıyorum

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

    @PostMapping
// DÖNÜŞ TİPİ GÜNCELLENDİ (Fruit -> SuccessResponse)
    public SuccessResponse save(@RequestBody Fruit fruit) {
        Fruit savedFruit = fruitService.save(fruit);

        // GÖREV 4: Obje ve mesaj birlikte dönülüyor
        return new SuccessResponse(savedFruit, "Fruit saved successfully.");
    }

    // README: [DELETE]/workintech/fruits/{id}
    // Test: [DELETE] /fruit/{id}
    @DeleteMapping("/{id}")
    public Fruit delete(@PathVariable long id) {
        return fruitService.delete(id);
    }
}
