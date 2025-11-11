package com.workintech.s18d2.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SuccessResponse {

    // Dönen asıl veri (Fruit, Vegetable, vb.)
    private Object data;

    // README Görev 4'ün istediği mesaj
    private String message;
}
