package com.example.nicttaplication.apiDTO;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
public class OrderUpdateDTO {
    private Long id;

    @NotEmpty(message = "Enter address please")
    @Email(message = "Enter correct address please")
    @Size(min = 3, max = 50, message = "Address length must be at least 3 and no more than 50 characters")
    private String email;
}
