package com.example.nicttaplication.DTO;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;

@Data
public class OrderDTO {
    private Long id;
    @NotEmpty(message = "Enter address please")
    @Email(message = "Enter correct address please")
    @Size(min = 3, max = 50, message = "Address length must be at least 3 and no more than 50 characters")
    private String email;

    @NotEmpty(message = "no product selected, please select a product")
    private List<Long> productIdList;

}
