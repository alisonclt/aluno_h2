package br.edu.unoesc.exemplo_aluno;

import java.util.Optional;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import br.edu.unoesc.exemplo_aluno.model.Aluno;
import br.edu.unoesc.exemplo_aluno.repository.AlunoRepository;

@SpringBootApplication
public class ExemploAlunoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExemploAlunoApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(AlunoRepository repositorio) {
		return args -> {
			Aluno l = new Aluno(null, "O Senhor dos pastéis", 666, "Tolkien");
			l = repositorio.save(l);
			System.out.println(l);
			
			repositorio.save(new Aluno(null, "O hobbit", 42, "J.R.R.Tolkien"));
			
			Optional<Aluno> p = repositorio.findById(2);
			if (p.isEmpty()) {
				System.out.println("Registro não encontrado!");
			} else {
				System.out.println(p.get());				
			}
			
//			Livro antigo = repositorio.findById(3).get();
//			antigo.setTitulo("Título nada a ver");
//			antigo.setPaginas(100);
//			antigo.setAutor("Fulano da Silva");
//			repositorio.save(antigo);
			
			System.out.println(repositorio.findAll());
			
			for (var livro: repositorio.findByAutorContainingIgnoreCase("j")) {
				System.out.println(livro);
			}
			
			for (var livro: repositorio.porQtdPaginas(300)) {
				System.out.println(livro);
			}
			
			for (var livro: repositorio.findByFiltro("senhor")) {
				System.out.println(livro);
			}
		};
	}
}

