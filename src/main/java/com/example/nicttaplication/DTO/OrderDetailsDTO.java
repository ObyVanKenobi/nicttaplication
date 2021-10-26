package com.example.nicttaplication.DTO;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class OrderDetailsDTO {

    private Long id;
    private Integer countOfProduct;

}
