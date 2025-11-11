package com.workintech.s18d2.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "fruit", schema = "fsweb") // README: fsweb şeması
public class Fruit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // README: name, price, FruitType fieldları
    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private Double price;

    @Column(name = "fruit_type")
    @Enumerated(EnumType.STRING)
    private FruitType fruitType;
}
