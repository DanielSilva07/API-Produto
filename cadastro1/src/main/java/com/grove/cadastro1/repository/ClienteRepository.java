package com.grove.cadastro1.repository;

import com.grove.cadastro1.model.ClienteModel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ClienteRepository extends MongoRepository<ClienteModel, String> {


}
