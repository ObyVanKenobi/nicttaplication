package com.example.nicttaplication.apiDTO;

import lombok.Data;

import java.util.List;

@Data
public class OrderApiDTO {
    private String email;
    private List<Long> productIdList;
}
