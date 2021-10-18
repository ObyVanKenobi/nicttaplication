package com.example.nicttaplication.DTO;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
public class OrderDTO {

    private Long id;
    @NotEmpty(message = "Enter address please")
    @Email(message = "Enter address please")
    @Size(min = 3, max = 10,message = "Address length must be at least 3 and no more than 10 characters")
    private String email;
    @Min(value = 1L, message = "min 1")
    private Integer countOfProduct;
    private Long productId;

}
