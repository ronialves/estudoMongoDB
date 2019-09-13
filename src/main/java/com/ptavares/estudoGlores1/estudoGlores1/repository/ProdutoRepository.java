package com.ptavares.estudoGlores1.estudoGlores1.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.ptavares.estudoGlores1.estudoGlores1.model.Produto;

public interface ProdutoRepository extends MongoRepository<Produto, String> {

}
