package com.danielsilva.Produto.model;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@Document("Produtos")
public class ProdutoModel {

    @Id
    private String id;
    @NotBlank
    private String nome;
    @NotBlank
    private String codigo;
    @NotBlank
    private Double price;

    private LocalDateTime localDateTime;


}
