package com.grove.cadastro1.model;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


import java.time.LocalDateTime;


@Data
@Document("Clientes")
public class ClienteModel {

    @Id
    private String id;

    @NotBlank
    @Size(min = 1, max = 50)
    private String nome;

    @Email
    @NotBlank
    private String email;

//    private String login;
//
//    private String senha;

    private LocalDateTime localDateTime;

    public ClienteModel() {

    }
}
