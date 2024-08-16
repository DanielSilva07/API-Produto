package com.grove.cadastro1.controller;
import com.grove.cadastro1.model.ClienteModel;
import com.grove.cadastro1.service.ClienteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
public class ClienteController {

    @Autowired
    private ClienteService clienteService;
    @Autowired
    private PasswordEncoder encoder;

    @PostMapping("/salvar")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<ClienteModel> salvar(@RequestBody @Valid ClienteModel clienteModel){
        clienteModel.setLocalDateTime(LocalDateTime.now());
//        clienteModel.setSenha(encoder.encode(clienteModel.getSenha()));
        return ResponseEntity.status(201).body(clienteService.cadastrar(clienteModel));
    }

//    @PostMapping("/create")
//    @ResponseStatus(HttpStatus.CREATED)
//    public ResponseEntity<ClienteModel> createNew(@RequestBody @Valid ClienteRequest clienteRequest){
//
//        ClienteModel clienteModel = new ClienteModel();
//        clienteModel.setNome(clienteRequest.getNome());
//        clienteModel.setEmail(clienteRequest.getEmail());
//        clienteModel.setLocalDateTime(LocalDateTime.now());
//       return ResponseEntity.status(201).body(this.clienteService.cadastrar(clienteModel));
//    }

    @GetMapping("/getAll")
    @ResponseStatus(HttpStatus.OK)
    public List<ClienteModel> getAllClientes(){
        return clienteService.findAll();
    }

    @GetMapping("/cliente/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<ClienteModel> findClienteById (@PathVariable (value = "id") String id){
        return clienteService.findById(id);
    }

    @DeleteMapping("/cliente/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Object> deleteClienteById(@PathVariable(value = "id")String id){
        return clienteService.deleteClienteById(id);

    }

}
