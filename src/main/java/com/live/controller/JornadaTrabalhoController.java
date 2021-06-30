package com.live.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.live.model.JornadaTrabalho;
import com.live.service.JornadaTrabalhoService;

@RestController
@RequestMapping("/jornada")
public class JornadaTrabalhoController {

	@Autowired
	private JornadaTrabalhoService jornadaTrabalhoService;
	
	@PostMapping
	public ResponseEntity<JornadaTrabalho> createJornada(@RequestBody JornadaTrabalho jornadaTrabalho) {
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").
		buildAndExpand(jornadaTrabalho.getId()).toUri();
		return ResponseEntity.created(uri).body(jornadaTrabalhoService.save(jornadaTrabalho));
	}
		
	@GetMapping
	public ResponseEntity<List<JornadaTrabalho>> getJornadaList(){
		return ResponseEntity.ok().body(jornadaTrabalhoService.findAll());
	}
		
	@GetMapping("/{id}")
	public ResponseEntity<JornadaTrabalho> getJornadaId(@PathVariable Long id) throws Exception {
		return ResponseEntity.ok(jornadaTrabalhoService.getById(id));
	}
	
	@PutMapping
	public ResponseEntity<JornadaTrabalho> updateJornada( @RequestBody JornadaTrabalho jornadaTrabalho) {
		JornadaTrabalho obj = jornadaTrabalhoService.updateJornada(jornadaTrabalho);
		return ResponseEntity.ok().body(obj);
	}	
	
	@DeleteMapping(value="/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) throws Exception {
		jornadaTrabalhoService.deleteJornada(id);
		return ResponseEntity.noContent().build();
	}
		

	

	

	
	
	
}



