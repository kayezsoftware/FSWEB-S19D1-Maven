package com.workintech.s18d2.controller;

import com.workintech.s18d2.dto.SuccessResponse;
import com.workintech.s18d2.entity.Vegetable;
import com.workintech.s18d2.services.VegetableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// README: /workintech/vegetables
// FruitController'ı baz alarak "/vegetable" kullanıyorum
@RestController
@RequestMapping("/vegetable")
public class VegetableController {

    private final VegetableService vegetableService;

    @Autowired
    public VegetableController(VegetableService vegetableService) {
        this.vegetableService = vegetableService;
    }

    // README: [GET]/workintech/vegetables => artan sırada
    @GetMapping
    public List<Vegetable> getVegetablesAsc() {
        return vegetableService.getByPriceAsc();
    }

    // README: [GET]/workintech/vegetables/desc => azalan sırada
    @GetMapping("/desc")
    public List<Vegetable> getVegetablesDesc() {
        return vegetableService.getByPriceDesc();
    }

    // README: [GET]/workintech/vegetables/{id}
    @GetMapping("/{id}")
    public Vegetable getById(@PathVariable long id) {
        return vegetableService.getById(id);
    }

    // README: [POST]/workintech/vegetables/{name} (GET olarak düzeltildi)
    @GetMapping("/name/{name}")
    public List<Vegetable> getByName(@PathVariable String name) {
        return vegetableService.searchByName(name);
    }

    // README: [POST]/workintech/vegetables
    // README: [POST]/workintech/vegetables
    @PostMapping
// DÖNÜŞ TİPİ GÜNCELLENDİ (Vegetable -> SuccessResponse)
    public SuccessResponse save(@RequestBody Vegetable vegetable) {
        Vegetable savedVegetable = vegetableService.save(vegetable);

        // GÖREV 4: Obje ve mesaj birlikte dönülüyor
        return new SuccessResponse(savedVegetable, "Vegetable saved successfully.");
    }

    // README: [DELETE]/workintech/vegetables/{id}
    @DeleteMapping("/{id}")
    public Vegetable delete(@PathVariable long id) {
        return vegetableService.delete(id);
    }
}
