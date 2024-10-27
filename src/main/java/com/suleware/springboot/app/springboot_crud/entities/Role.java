package com.suleware.springboot.app.springboot_crud.entities;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(exclude = "users")
@Entity
@Table(name = "roles")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    @Column(unique = true)
    private String name;

    @JsonIgnoreProperties({ "roles", "handler", "hibernateLazyInitializer" })
    @ManyToMany(mappedBy = "roles")
    private List<User> users;

    public Role() {
        this.users = new ArrayList<>();
    }

    public Role(@NotBlank String name) {
        this.name = name;

    }

}
