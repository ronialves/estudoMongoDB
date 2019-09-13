package com.ptavares.estudoGlores1.estudoGlores1.resource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ptavares.estudoGlores1.estudoGlores1.dto.FabricanteDTO;
import com.ptavares.estudoGlores1.estudoGlores1.model.Fabricante;
import com.ptavares.estudoGlores1.estudoGlores1.model.Produto;
import com.ptavares.estudoGlores1.estudoGlores1.resource.util.URL;
import com.ptavares.estudoGlores1.estudoGlores1.services.FabricanteService;

@Controller
//@RequestMapping(value = "/fabricante")
public class FabricanteResource {

	@Autowired
	private FabricanteService service;

//	@RequestMapping(value="/fabricantes", method=RequestMethod.GET) 
//	public ResponseEntity<List<FabricanteDTO>> findAll() {
//		List <Fabricante> listFabr = service.findAll();
//		List <FabricanteDTO> listDTO = listFabr.stream().map(x -> new FabricanteDTO(x)).collect(Collectors.toList());
//		return ResponseEntity.ok().body(listDTO);
//	}
	
	@RequestMapping(value="/fabricantes", method=RequestMethod.GET)
	public String listarFabricantes(Model model) {
		List <Fabricante> listFabr = service.findAll();
		List <FabricanteDTO> listDTO = listFabr.stream().map(x -> new FabricanteDTO(x)).collect(Collectors.toList());
		model.addAttribute("fabricantes", listDTO);
		return "listFabricantes";
	}
	
	@RequestMapping(value="/fabricantes1", method=RequestMethod.GET) 
	public ResponseEntity<List<Fabricante>> findAll1() {
		List <Fabricante> listFabr = service.findAll();
		return ResponseEntity.ok().body(listFabr);
	}
	
//	@RequestMapping(value="/fabricantes/{id}", method=RequestMethod.GET)
// 	public ResponseEntity<Fabricante> findById(@PathVariable String id) {
//		Fabricante obj = service.findById(id);
//		return ResponseEntity.ok().body((obj));
//	}
	
	@RequestMapping(value="/fabricantes/{id}", method=RequestMethod.GET)
 	public String findById(@PathVariable String id, Model model) {
		Fabricante obj = service.findById(id);
		Produto produto = new Produto();
		model.addAttribute("fabricante", obj);
		model.addAttribute("produtos", produto);
		return "detalheFabricante";
	}
	
	@RequestMapping(value="fabricantes/{id}/produtos", method=RequestMethod.GET)
 	public String findProdutos(@PathVariable String id, Model model) {
		Fabricante obj = service.findById(id);
		model.addAttribute("produtos", obj.getProdutos());
		model.addAttribute("fabricante", obj);
		return "detalheFabricante";
	}
	
//	@RequestMapping(value="fabricantes/{id}/produtos", method=RequestMethod.GET)
// 	public ResponseEntity<List<Produto>> findPosts(@PathVariable String id) {
//		Fabricante obj = service.findById(id);
//		return ResponseEntity.ok().body(obj.getProdutos());
//	}
	
	@RequestMapping(value="/fabricantes/busca", method=RequestMethod.GET)
	public ResponseEntity<List<FabricanteDTO>> buscaGenerica(
			@RequestParam(value="text", defaultValue="") String text) {
		
		if(URL.verificaBusca(text)) {
			List<Fabricante> listFabr = service.buscaGenerica(text);
			List <FabricanteDTO> listDTO = listFabr.stream().map(x -> new FabricanteDTO(x)).collect(Collectors.toList());
			return ResponseEntity.ok().body((listDTO));
		}
		else { 
			List<FabricanteDTO> listDTO = new ArrayList<>();
			return ResponseEntity.ok().body((listDTO));
		}
	}
	
	@RequestMapping(value="/fabricantes/nome/{nome}", method=RequestMethod.GET)
	public ResponseEntity<List<Fabricante>> buscaNome(@PathVariable String nome) {
		List <Fabricante> fabricantes = service.findByNome(nome);
		return ResponseEntity.ok().body((fabricantes));
	}
	
	@RequestMapping(value="/fabricantes/email/{email}", method=RequestMethod.GET)
	public ResponseEntity<List<Fabricante>> buscaEmail(@PathVariable String email) {
		List <Fabricante> fabricantes = service.buscaEmail(email);
		return ResponseEntity.ok().body((fabricantes));
	}
	
	@RequestMapping(value="/fabricantes/deletarTodos", method=RequestMethod.GET)
	public String deletarTodos() {
		service.deleteAll();
		return "/fabricantes";
	}
	
	@RequestMapping(value="/fabricantes/deletarId/{id}", method=RequestMethod.GET) 
	public String deletarId(@PathVariable String id) {
		service.deleteById(id);
		return "/fabricantes";
	}
	
	@RequestMapping(value="/fabricantes/addFabricante", method=RequestMethod.GET) 
	public String mostrarAddFabricante(Model model) {
		Fabricante fabricante = new Fabricante();
		model.addAttribute("fabricante", fabricante);
		return "addFabricante";
	}
	
	@RequestMapping(value="/fabricantes/salvarFabricante", method=RequestMethod.POST) 
	public String salvarFabricante(Model model, //
            @ModelAttribute("fabricante") Fabricante fabricante) {
		
		service.create(fabricante);
		
		return "redirect:/fabricantes";
	}
	
}
