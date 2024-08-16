package com.danielsilva.Produto.service;
import com.danielsilva.Produto.model.ProdutoModel;
import com.danielsilva.Produto.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.List;


@Service
public class ProdutoService {

    @Autowired
    private  ProdutoRepository repository;


    public ProdutoModel cadastrar(@RequestBody ProdutoModel produtoModel){
        return repository.save(produtoModel);
    }

    public ResponseEntity <List<ProdutoModel>> getAll(){
       return ResponseEntity.ok().body(repository.findAll());
    }

    public ResponseEntity<ProdutoModel> getById(String id){
        return repository.findById(id)
                .map(produtoModel -> ResponseEntity.ok().body(produtoModel))
                .orElse(ResponseEntity.notFound().build());
    }

    public ResponseEntity<Object>deleteProdById(String id){
        return repository.findById(id).map(deleteById -> {
            repository.deleteById(id);
            return ResponseEntity.noContent().build();
        }).orElse(ResponseEntity.notFound().build());

    }
}
