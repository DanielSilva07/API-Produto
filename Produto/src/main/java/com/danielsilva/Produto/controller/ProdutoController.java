package com.danielsilva.Produto.controller;
import com.danielsilva.Produto.model.ProdutoModel;
import com.danielsilva.Produto.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;
import java.util.List;


@RestController
@RequestMapping("/api/produto")
public class ProdutoController {

    @Autowired
    private ProdutoService service;


    @PostMapping("/salvar")
    public ResponseEntity<ProdutoModel>salvar(@RequestBody ProdutoModel produtoModel){
        produtoModel.setLocalDateTime(LocalDateTime.now());
        return ResponseEntity.status(201).body(service.cadastrar(produtoModel));
    }

    @GetMapping("/getall")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity <List<ProdutoModel>> getAll(){
        return service.getAll();

    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<ProdutoModel> getById(@PathVariable (value = "id") String id){
        return service.getById(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Object> delete(@PathVariable (value = "id") String id){
        return service.deleteProdById(id);

    }



}
