package com.ptavares.estudoGlores1.estudoGlores1.services;

import java.util.List;

import com.ptavares.estudoGlores1.estudoGlores1.model.Produto;

public interface ProdutoService {

	public void create(Produto produto);

	public void update(Produto produto);

	public void delete(Produto produto);

	public void deleteById(String id);

	public void deleteAll();

	public List<Produto> findAll();

	public Produto findById(String id);

}
