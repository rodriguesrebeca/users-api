package com.exercise.userapi.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserRequest {
    private String name;
    private String cpf;
    private String password;
    private String phoneNumber;
    private String email;

}
