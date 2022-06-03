package com.exercise.userapi.service;

import com.exercise.userapi.dto.UserRequest;
import com.exercise.userapi.dto.UserResponse;
import com.exercise.userapi.exceptions.ValidationException;
import com.exercise.userapi.model.User;
import com.exercise.userapi.repository.UserRepository;
import com.exercise.userapi.validators.UserValidators;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final UserValidators userValidators;

    public User getById(String id) {
        return userRepository.findById(id).orElseThrow();
    }

    public UserResponse create(UserRequest userRequest) {

        User user1 = new User(userRequest);
        val validationErrors = userValidators.validate(user1);

        if(!validationErrors.isEmpty()) {
            throw new ValidationException(validationErrors);
        }

        String cpf = userRequest.getCpf();
        User user = userRepository.findByCpf(cpf);

        if(user != null){
            return new UserResponse(user);
        }

        UserResponse userResponse = new UserResponse(userRepository.save(user1));
        return userResponse;
    }

    public List<User> getAll(){
        return userRepository.findAll();
    }

    public void delete(String id) {
        userRepository.deleteById(id);
    }

    public UserResponse update(UserRequest userRequest, String id) {
        User user = userRepository.findById(id).orElseThrow();
        user.setName(userRequest.getName());
        user.setPassword(userRequest.getPassword());
        user.setEmail(userRequest.getEmail());
        val validationErrors = userValidators.validate(user);

        if(!validationErrors.isEmpty()) {
            throw new ValidationException(validationErrors);
        }
        return new UserResponse(userRepository.save(user));
    }

}
