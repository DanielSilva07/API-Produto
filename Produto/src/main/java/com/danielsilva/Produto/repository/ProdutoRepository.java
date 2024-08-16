package com.danielsilva.Produto.repository;

import com.danielsilva.Produto.model.ProdutoModel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProdutoRepository extends MongoRepository<ProdutoModel ,String> {

}
