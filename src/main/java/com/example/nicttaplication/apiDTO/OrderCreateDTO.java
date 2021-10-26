package com.example.nicttaplication.apiDTO;

import lombok.Data;

import java.util.List;

@Data
public class OrderCreateDTO {
    private String email;
    private List<Long> productIdList;
}
