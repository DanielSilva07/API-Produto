package com.danielsilva.Produto.dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProdutoDto {

    private String id;
    private String nome;
    private String codigo;
    private Double price;
    private LocalDateTime localDateTime;
}
