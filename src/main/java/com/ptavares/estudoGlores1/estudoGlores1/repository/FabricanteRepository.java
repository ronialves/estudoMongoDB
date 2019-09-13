package com.ptavares.estudoGlores1.estudoGlores1.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.ptavares.estudoGlores1.estudoGlores1.model.Fabricante;

@Repository
public interface FabricanteRepository extends MongoRepository<Fabricante, String>{
	
	List<Fabricante> findByNomeContainingIgnoreCase(String text);
	
	List<Fabricante> findByEmailContainingIgnoreCase(String email);
	
	@Query("{ $or: [ {'nome': { $regex: ?0, $options: 'i' }  }, { 'cidade': { $regex: ?0, $options: 'i' } },{ 'estado': { $regex: ?0, $options: 'i' } }, { 'endereco': { $regex: ?0, $options: 'i' } }, { 'email': { $regex: ?0, $options: 'i' } }  ] }")
	List<Fabricante> buscaGenerica(String text);
	
}
