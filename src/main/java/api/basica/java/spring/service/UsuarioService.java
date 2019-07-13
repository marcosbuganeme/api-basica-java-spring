package api.basica.java.spring.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import api.basica.java.spring.dto.UsuarioAutenticacaoDTO;
import api.basica.java.spring.model.Usuario;
import api.basica.java.spring.repository.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository repository;

	@Transactional
	public Usuario salvar(Usuario usuario) {

		aplicaRegrasAntesDeSalvar(usuario);

		return repository.save(usuario);
	}

	public Usuario buscaUsuarioPorId(Long id) {
		return repository.findById(id).orElse(null);
	}

	public Usuario buscaUsuarioPorLoginAndSenha(UsuarioAutenticacaoDTO autenticacaoDTO) {
		String senha = autenticacaoDTO.getSenha();
		String login = autenticacaoDTO.getUsername();

		return repository.findByLoginAndSenha(login, senha);
	}

	public List<Usuario> buscaTodosUsuarios() {
		return repository.findAll();
	}

	public Page<Usuario> buscaTodosUsuariosDeFormaPaginada(Pageable pageable) {
		return repository.findAll(pageable);
	}

	private void aplicaRegrasAntesDeSalvar(Usuario usuario) {

		Usuario dadosPesquisados = repository.findByLoginOrEmail(usuario.getLogin(), usuario.getEmail());
		lancaExcecaoSeLoginOuEmailJaExistirem(dadosPesquisados);
	}

	private void lancaExcecaoSeLoginOuEmailJaExistirem(Usuario dadosPesquisados) {

		if (dadosPesquisados != null) {
			throw new IllegalArgumentException("Login e/ou E-mail já estão em uso!");
		}
	}
}