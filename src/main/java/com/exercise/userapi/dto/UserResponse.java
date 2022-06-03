package com.exercise.userapi.dto;

import com.exercise.userapi.model.User;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserResponse {

    private String id;
    private String name;
    private String cpf;
    private String phoneNumber;
    private String email;

    public UserResponse(User user) {
        id = user.getId();
        name = user.getName();
        cpf = user.getCpf();
        phoneNumber = user.getPhoneNumber();
        email = user.getEmail();
    }
}
