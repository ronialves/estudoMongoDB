package com.ptavares.estudoGlores1.estudoGlores1.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ptavares.estudoGlores1.estudoGlores1.model.Fabricante;
import com.ptavares.estudoGlores1.estudoGlores1.repository.FabricanteRepository;
import com.ptavares.estudoGlores1.estudoGlores1.services.exception.ObjectNotFoundException;

@Service
public class FabricanteServiceImpl implements FabricanteService {

	@Autowired
	FabricanteRepository fabricanteRepo;

	@Override
	public void create(Fabricante fabricante) {
		fabricanteRepo.insert(fabricante);
	}

	@Override
	public void update(Fabricante fabricante) {
		fabricanteRepo.save(fabricante);
	}

	@Override
	public void delete(Fabricante fabricante) {
		fabricanteRepo.delete(fabricante);
	}

	@Override
	public void deleteAll() {
		fabricanteRepo.deleteAll();
	}

	@Override
	public List<Fabricante> findAll() {
		return fabricanteRepo.findAll();
	}

	@Override
	public Fabricante findById(String id) {
		Optional<Fabricante> fabr = fabricanteRepo.findById(id);
		return fabr.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}

	@Override
	public List<Fabricante> findByNome(String nome) {
		return fabricanteRepo.findByNomeContainingIgnoreCase(nome);
	}

	@Override
	public List<Fabricante> buscaGenerica(String text) {
		return fabricanteRepo.buscaGenerica(text);
	}

	@Override
	public List<Fabricante> buscaEmail(String email) {
		return fabricanteRepo.findByEmailContainingIgnoreCase(email);
	}

	@Override
	public void deleteById(String id) {
		fabricanteRepo.deleteById(id);
	}
	
	

}
