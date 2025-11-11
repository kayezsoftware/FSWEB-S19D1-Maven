package com.workintech.s18d2.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // Bu annotation setGrownOnTree() ve isGrownOnTree() metotlarını oluşturur
@NoArgsConstructor
@Entity
@Table(name = "vegetable", schema = "fsweb")
public class Vegetable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private Double price;

    @Column(name = "is_grown_on_tree")
    private boolean isGrownOnTree;
}
