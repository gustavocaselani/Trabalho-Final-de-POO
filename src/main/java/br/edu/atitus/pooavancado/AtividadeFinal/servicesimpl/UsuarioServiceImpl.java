package br.edu.atitus.pooavancado.AtividadeFinal.servicesimpl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.edu.atitus.pooavancado.AtividadeFinal.Entities.Usuario;
import br.edu.atitus.pooavancado.AtividadeFinal.repositories.GenericRepository;
import br.edu.atitus.pooavancado.AtividadeFinal.repositories.UsuarioRepository;
import br.edu.atitus.pooavancado.AtividadeFinal.services.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService{
	
	final UsuarioRepository usuarioRepository;
	public UsuarioServiceImpl(UsuarioRepository usuarioRepository) {
		super();
		this.usuarioRepository = usuarioRepository;
	}
	
	@Override
	public GenericRepository<Usuario> getRepository() {
		return usuarioRepository;
	}

	@Override
	public void alteraStatus(long id) throws Exception {
		if (!usuarioRepository.existsById(id))
			throw new Exception("Não existe registro com este Id");
		usuarioRepository.alteraStatusById(id);
	}

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Usuario usuario = this.usuarioRepository.findByEmail(email)
				.orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado com o e-mail: " + email));
		return usuario;
	}
	
	public Page<Usuario> findByNome(Pageable pageable, String nome){
		return ((UsuarioRepository) getRepository()).findByNomeContainingIgnoreCase(pageable, nome);
	}

	@Override
	public void validarSave(Usuario objeto) throws Exception {
		if (objeto.getPassword() == null || objeto.getPassword().isEmpty())
			throw new Exception("Deve ser informada uma Senha.");
		if (objeto.getEmail() == null || objeto.getEmail().isEmpty())
			throw new Exception("Deve ser informado um E-mail.");
		if (objeto.getNome() == null || objeto.getNome().isEmpty())
			throw new Exception("Deve ser informado um Nome.");
	}
}
