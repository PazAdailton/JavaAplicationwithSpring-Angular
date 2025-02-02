package br.com.pazimportss.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.pazimportss.model.Estudante;
import br.com.pazimportss.repository.EstudanteRepository;

@Service
public class EstudanteService {
	
	@Autowired
	private EstudanteRepository estudanteRepository;
	
	public Estudante salvar(Estudante estudante) {
	return	estudanteRepository.save(estudante);
	}
	
	public List<Estudante> buscarTodos(){
	return	estudanteRepository.findAll();
	}
	
	public void Excluir(Integer id) {
		estudanteRepository.deleteById(id);
	}
	
	public Optional<Estudante> buscarPorId(Integer id) {
	return	estudanteRepository.findById(id);
	}
	
	public Estudante alterar(Estudante estudante) {
		return estudanteRepository.save(estudante);
	}
	
	public Estudante buscarPorNome(Estudante estudante) {
		return estudanteRepository.buscarPorNome(estudante);
	}
	
	
}
