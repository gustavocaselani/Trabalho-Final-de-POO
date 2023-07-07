package br.edu.atitus.pooavancado.AtividadeFinal.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import br.edu.atitus.pooavancado.AtividadeFinal.Entities.GenericEntity;

@NoRepositoryBean
public interface GenericRepository<TEntidade extends GenericEntity> 
	extends JpaRepository<TEntidade, Long> {
	
}
