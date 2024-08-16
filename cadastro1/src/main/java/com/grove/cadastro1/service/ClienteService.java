package com.grove.cadastro1.service;
import com.grove.cadastro1.model.ClienteModel;
import com.grove.cadastro1.repository.ClienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public ClienteModel cadastrar(ClienteModel clienteModel){
        return clienteRepository.save(clienteModel);
    }

    public List<ClienteModel> findAll() {
        return clienteRepository.findAll();
    }

    public ResponseEntity<ClienteModel> findById(String id) {
        return clienteRepository.findById(id)
                .map(clienteModel -> ResponseEntity.ok().body(clienteModel))
                .orElse(ResponseEntity.notFound().build());
    }

    public ResponseEntity<Object> deleteClienteById(String id) {
        return clienteRepository.findById(id)
                .map(clienteModelToDelete ->{
                    clienteRepository.deleteById(id);
                    return ResponseEntity.noContent().build();
                }).orElse(ResponseEntity.notFound().build());
    }
}
