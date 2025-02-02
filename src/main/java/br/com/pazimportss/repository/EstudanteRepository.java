package br.com.pazimportss.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.pazimportss.model.Estudante;

@Repository
public interface EstudanteRepository extends JpaRepository<Estudante, Integer> {
	
	@Query("select e from Estudante e where e.nome=:nome")
	Estudante buscarPorNome(@Param("nome") Estudante estudante);
	
	
}
