package com.ptavares.estudoGlores1.estudoGlores1.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ptavares.estudoGlores1.estudoGlores1.model.Produto;
import com.ptavares.estudoGlores1.estudoGlores1.repository.ProdutoRepository;
import com.ptavares.estudoGlores1.estudoGlores1.services.exception.ObjectNotFoundException;

@Service
public class ProdutoServiceImpl implements ProdutoService {

	@Autowired
	ProdutoRepository repo;

	@Override
	public void create(Produto produto) {
		repo.insert(produto);
	}

	@Override
	public void update(Produto produto) {
		repo.save(produto);
	}

	@Override
	public void delete(Produto produto) {
		repo.delete(produto);
	}

	@Override
	public void deleteById(String id) {
		repo.deleteById(id);
	}

	@Override
	public void deleteAll() {
		repo.deleteAll();
	}

	@Override
	public List<Produto> findAll() {
		return repo.findAll();
	}

	@Override
	public Produto findById(String id) {
		Optional<Produto> fabr = repo.findById(id);
		return fabr.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}

}
