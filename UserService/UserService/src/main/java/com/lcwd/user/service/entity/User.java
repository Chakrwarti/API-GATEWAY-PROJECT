package com.lcwd.user.service.entity;
;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "microUser")
public class User {
    @Id
    @Column(name = "ID")
    private String userId;
    @Column(name = "NAME", length = 20)
    private String name;
    @Column(name = "EMAIL", length = 50)
    private String email;
    @Column(name = "ABOUT", length = 100)
    private String about;

    @Transient
    private List<Rating> ratings = new ArrayList<>();

}
