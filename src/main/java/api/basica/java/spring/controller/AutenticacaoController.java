package api.basica.java.spring.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import api.basica.java.spring.dto.UsuarioAutenticacaoDTO;
import api.basica.java.spring.model.Usuario;
import api.basica.java.spring.service.UsuarioService;

@RestController
@RequestMapping("auth")
public class AutenticacaoController {

	@Autowired
	private UsuarioService service;

	@PostMapping("login")
	public ResponseEntity<?> login(@Valid @RequestBody UsuarioAutenticacaoDTO autenticacaoDTO) {

		Usuario usuarioPesquisado = service.buscaUsuarioPorLoginAndSenha(autenticacaoDTO);

		if (usuarioPesquisado != null) {

			return ResponseEntity.ok(usuarioPesquisado);

		} else {

			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Nenhum usuário encontrado");
		}
	}
}
