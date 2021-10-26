package com.example.nicttaplication.DTO;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;

@Data
public class OrderDTO {
    @ApiModelProperty(allowEmptyValue = true)
    private Long id;
    @NotEmpty(message = "Enter address please")
    @Email(message = "Enter address please")
    @Size(min = 3, max = 10, message = "Address length must be at least 3 and no more than 10 characters")
    private String email;
    private List<Long> productIdList;

}
