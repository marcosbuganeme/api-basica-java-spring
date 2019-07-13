package api.basica.java.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import api.basica.java.spring.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

	/**
	 * Pesquisa isso no google, Documentação do spring data jpa
	 * 
	 * Em resumo, é basicamente um projeto interno do framework spring que te ajuda
	 * a escrever SQL Sem usar SQL, apenas escrevendo a nonemclatura deles.
	 * 
	 * A ideia é usar o nome dos atributos e operadores como : LIKE, AND, OR,
	 * FindBy, Distinct, Between, Before, After, GreatherThan, LessThan ...
	 */

	Usuario findByLoginOrEmail(String login, String email);

	Usuario findByLoginAndSenha(String login, String senha);
}