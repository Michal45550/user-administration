package com.demo.checkpoint.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "`users`")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "`id`")
    private long id;

    @NotNull
    @Size(max = 40)
    @Column(name = "`first name`", length = 40, nullable = false)
    private String firstName;

    @NotNull
    @Size(max = 40)
    @Column(name = "`last name`", length = 40, nullable = false)
    private String lastName;

    @NotNull
    @Size(max = 40)
    @Column(name = "`email address`", length = 40, nullable = false)
    private String emailAddress;

    @NotNull
    @Size(max = 40)
    @Column(name = "`password`", length = 40, nullable = false)
    private String password;

}
