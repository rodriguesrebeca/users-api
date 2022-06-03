package com.exercise.userapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class FinishedOrderId {

    @Id
    private String id;

    @ManyToOne
    @JoinColumn(name = "users_id", referencedColumnName = "id")
    private User users;
}
