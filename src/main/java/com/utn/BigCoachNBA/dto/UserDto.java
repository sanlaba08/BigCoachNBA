package com.utn.BigCoachNBA.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    String firstName;
    String lastName;
    String dni;
    String pwd;

}
