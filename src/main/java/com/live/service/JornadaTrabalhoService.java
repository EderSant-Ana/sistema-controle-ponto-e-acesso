package com.live.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.live.model.JornadaTrabalho;
import com.live.repository.JornadaTrabalhoRepository;

@Service
public class JornadaTrabalhoService {
	
	@Autowired
	private JornadaTrabalhoRepository jornadaTrabalhoRepository;
	
	public JornadaTrabalho save(JornadaTrabalho jornadaTrabalho) {
		return jornadaTrabalhoRepository.save(jornadaTrabalho);
	}

	public List<JornadaTrabalho> findAll() {
		return jornadaTrabalhoRepository.findAll();
	}

	public JornadaTrabalho getById(Long id) throws RuntimeException {
		Optional<JornadaTrabalho> obj = jornadaTrabalhoRepository.findById(id);
		return obj.orElseThrow(() -> new RuntimeException("jornada não encontrada"));
	}

	public JornadaTrabalho updateJornada(JornadaTrabalho jornadaTrabalho) throws RuntimeException {
		JornadaTrabalho entity = jornadaTrabalhoRepository.getById(jornadaTrabalho.getId());
		try {
			entity.setDescricao(jornadaTrabalho.getDescricao());
			return jornadaTrabalhoRepository.save(entity);
		} catch(Exception e) {
			throw new RuntimeException("Recurso não encontrado " + jornadaTrabalho.getId());
		}
	}

	public void deleteJornada(Long id) throws Exception {
		try {
			jornadaTrabalhoRepository.deleteById(id);			
		} catch (Exception e) {
			throw new Exception("Recurso não encontrado no banco de dados: ");
		}
	}
	
}
