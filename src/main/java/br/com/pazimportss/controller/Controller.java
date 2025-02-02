package br.com.pazimportss.controller;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.pazimportss.model.Estudante;
import br.com.pazimportss.service.EstudanteService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(value="/api/estudantes")
public class Controller {
	
	@Autowired 
	private EstudanteService estudanteService;
	
	
	@PostMapping("/salvarestudante")
	public ResponseEntity<Estudante> cadastrar(@RequestBody Estudante estudante ){
		Estudante estudanteCadastrado = estudanteService.salvar(estudante);
		if(estudanteCadastrado.getId() != null) {
		return new ResponseEntity<Estudante>(estudanteCadastrado, HttpStatus.CREATED);
		}else {
			return new ResponseEntity<Estudante>(estudanteCadastrado, HttpStatus.BAD_REQUEST);
		}
		}
	
	@GetMapping("/listaestudante")
	public ResponseEntity<Collection<Estudante>> buscarTodos(){
		 Collection<Estudante> estudanteBuscados =   estudanteService.buscarTodos();
		if(!estudanteBuscados.isEmpty()) {
		return new ResponseEntity<>(estudanteBuscados, HttpStatus.OK);
		}else {
			return new ResponseEntity<>(estudanteBuscados, HttpStatus.NOT_FOUND);
		}
		}
	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Estudante> excluir(@PathVariable Integer id){
		
		Optional<Estudante> estudanteBuscado = estudanteService.buscarPorId(id);
		if(estudanteBuscado == null) {
			return new ResponseEntity<Estudante>(HttpStatus.NOT_FOUND);
		}
		estudanteService.Excluir(id);
		return new ResponseEntity<Estudante>(HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Estudante> buscarPorId(@PathVariable Integer id){
		
	Optional<Estudante> estudanteBuscadoPorID =	estudanteService.buscarPorId(id);
		
		if(estudanteBuscadoPorID.isPresent()) {
		return ResponseEntity.ok(estudanteBuscadoPorID.get());
		}else {
		return new ResponseEntity<Estudante>(HttpStatus.NOT_FOUND);
		}
		}
	
	@PutMapping("/{id}")
	public ResponseEntity<Estudante> alterarEstudante(@PathVariable Integer id, @RequestBody Estudante estudante){
		
		if(!id.equals(estudante.getId())) {
			return new ResponseEntity<Estudante>(HttpStatus.NOT_FOUND);
		}
		
		Optional<Estudante> buscarPorID = estudanteService.buscarPorId(id);
		
		if(buscarPorID.isPresent()) {
			Estudante estudanteAlterado = estudanteService.alterar(estudante);
			return new ResponseEntity<Estudante>(estudanteAlterado, HttpStatus.OK);
		}else {
			return new ResponseEntity<Estudante>(HttpStatus.NOT_FOUND);
		}
	}
	
	
	
	
}
