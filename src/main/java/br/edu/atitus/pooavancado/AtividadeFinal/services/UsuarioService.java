package br.edu.atitus.pooavancado.AtividadeFinal.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetailsService;

import br.edu.atitus.pooavancado.AtividadeFinal.Entities.Usuario;

public interface UsuarioService extends GenericService<Usuario>, UserDetailsService{
	
	void alteraStatus(long id) throws Exception;

	Page<Usuario> findByNome(Pageable pageable, String nome);
}
