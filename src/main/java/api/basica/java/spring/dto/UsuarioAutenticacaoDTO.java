package api.basica.java.spring.dto;

public final class UsuarioAutenticacaoDTO {

	private String username;
	private String senha;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
}