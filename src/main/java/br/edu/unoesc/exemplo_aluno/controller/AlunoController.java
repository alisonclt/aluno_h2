package br.edu.unoesc.exemplo_aluno.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.edu.unoesc.exemplo_aluno.model.Aluno;
import br.edu.unoesc.exemplo_aluno.repository.AlunoRepository;

@RestController
@RequestMapping("/api/aluno")
public class AlunoController {
	@Autowired
	private AlunoRepository repositorio;
	
	@GetMapping("/find")
	List<Aluno> listarComFiltro(@RequestParam("filtro") String filtro) {
		return repositorio.findByAutorContainingIgnoreCase(filtro);
	}
	
	@GetMapping
	public Iterable<Aluno> listarTudo() {
		return repositorio.findAll();
	}
}
