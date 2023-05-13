package dados;

import classesBasicasPessoa.Usuario;

public interface IRepositorioUsuario {

	void salvar();

	void cadastrar(Usuario u);

	Usuario procurar(String login);

	void remover(String login);

	boolean existe(String login);
	
	void printar(Usuario u);

}