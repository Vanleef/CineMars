package negocio;

import classesBasicasPessoa.Usuario;

public interface ICadastroUsuario {

	public abstract boolean cadastrar(Usuario u);

	public abstract Usuario procurar(String login);

	public abstract boolean existe(String login);

	public abstract void remover(String login);

	public abstract boolean login(String login, String senha);
	
	public abstract void salvar();
	
	public abstract void printar(Usuario u);

}