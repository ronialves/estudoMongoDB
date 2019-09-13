package com.ptavares.estudoGlores1.estudoGlores1.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ptavares.estudoGlores1.estudoGlores1.model.Produto;
import com.ptavares.estudoGlores1.estudoGlores1.services.ProdutoService;

@Controller
@RequestMapping(value = "/produto")
public class ProdutoResource {

	@Autowired
	private ProdutoService service;
	
	@RequestMapping(value="/", method=RequestMethod.GET) 
	public ResponseEntity<List<Produto>> findAll() {
		List <Produto> listProd = service.findAll();
		return ResponseEntity.ok().body(listProd);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<Produto> findById(@PathVariable String id) {
		Produto produto = service.findById(id);
		return ResponseEntity.ok().body(produto);
	}
	
}
