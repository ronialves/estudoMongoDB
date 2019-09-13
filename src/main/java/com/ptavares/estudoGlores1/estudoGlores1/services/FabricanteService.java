package com.ptavares.estudoGlores1.estudoGlores1.services;

import java.util.List;

import com.ptavares.estudoGlores1.estudoGlores1.model.Fabricante;

public interface FabricanteService {
	
	public void create(Fabricante fabricante);
	
	public void update(Fabricante fabricante);
	
	public void delete(Fabricante fabricante);
	
	public void deleteById(String id);
	
	public void deleteAll();
	
	public List<Fabricante> findAll();
	
	public Fabricante findById(String id);
	
	public List<Fabricante> findByNome(String nome);
	
	public List<Fabricante> buscaGenerica(String text);
	
	public List<Fabricante> buscaEmail(String email);
	
}
