package com.exercise.userapi.model;

import com.exercise.userapi.dto.UserRequest;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User {

    @Id
    private String id = UUID.randomUUID().toString();
    @Column
    private String name;
    @Column
    private String cpf;
    @Column
    private String email;
    @Column
    private String password;
    @Column
    private String phoneNumber;

    //todo: verificar se mantem cascade
    @OneToMany(mappedBy = "users", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<OrderId> orderIds;

    @OneToMany(mappedBy = "users", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<FinishedOrderId> finishedOrderIds;

    public User (UserRequest usuarioRequest) {
        cpf = usuarioRequest.getCpf();
        name = usuarioRequest.getName();
        email = usuarioRequest.getEmail();
        password = usuarioRequest.getPassword();
        phoneNumber = usuarioRequest.getPhoneNumber();
    }
}
