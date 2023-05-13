package negocio;

import classesBasicasPessoa.Administrador;

public interface ICadastroAdmin {

	public abstract boolean cadastrar(Administrador a);

	public abstract Administrador procurarAdminLogin(String login);
	
	public abstract Administrador procurarAdminSenha(String Senha);

	public abstract boolean existe(String login);

	public abstract void remover(String login);

	public abstract boolean login(String login, String senha);

	public abstract void salvar();

}
