package classesBasicasPessoa;

import java.io.Serializable;

public class Pessoa implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4507014796378150023L;
	private String nome;
	private String email;
	private String login;
	private String senha;
	
	public Pessoa(String nome, String email, String login, String senha){
		this.email = email;
		this.nome = nome;
		this.senha = senha;
		this.login = login;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}
	
	public String toString(){
		StringBuffer sb = new StringBuffer();
		sb.append("Nome: ");
		sb.append(this.nome);
		sb.append("\nEmail: ");
		sb.append(this.email);
		sb.append("\nLogin: ");
		sb.append(this.login);
		sb.append("\nSenha: ");
		sb.append(this.senha);
		
		return sb.toString();
		
	}
	
	
}
