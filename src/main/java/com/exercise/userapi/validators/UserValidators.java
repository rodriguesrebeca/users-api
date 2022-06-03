package com.exercise.userapi.validators;

import com.exercise.userapi.model.User;
import com.exercise.userapi.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserValidators {

    private final UserRepository userRepository;

    public List<String> validate(User user){

        List<String> validationErrors = new ArrayList<>();

        if (!StringUtils.hasText(user.getCpf())) {
            validationErrors.add("Cpf obrigatório");
        }

        if(!StringUtils.hasLength(String.valueOf(11))) {
            validationErrors.add(("cpf deve conter 11 digitos"));
        }

        if (!StringUtils.hasText(user.getEmail())) {
            validationErrors.add("Email obrigatório");
        }

        if (!StringUtils.hasText(user.getPassword())) {
            validationErrors.add("Senha obrigatória");
        }

        if (!StringUtils.hasText(user.getName())) {
            validationErrors.add("Nome obrigatório");
        }

       if (userRepository.findById(user.getId()) == null) {
            validationErrors.add("usuário não existe");
        }

        return validationErrors;
    }
}
