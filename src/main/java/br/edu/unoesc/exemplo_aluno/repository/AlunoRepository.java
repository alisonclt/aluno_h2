package br.edu.unoesc.exemplo_aluno.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import br.edu.unoesc.exemplo_aluno.model.Aluno;

public interface AlunoRepository extends CrudRepository<Aluno, Integer> {
	public List<Aluno> findByAutorContainingIgnoreCase(String nome);
	
	@Query("Select l from aluno l where l.salario >= :salario")
	public List<Aluno> porQtdPaginas(@Param("paginas") BigDecimal salario);
	
	@Query("Select l from aluno l where upper(l.salario) like upper(concat('%', :filtro, '%')) order by nome")
	public List<Aluno> findByFiltro(@Param("filtro") String filtro);
}
