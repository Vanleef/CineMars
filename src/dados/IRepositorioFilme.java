package dados;

import classesBasicasCinema.Filme;

public interface IRepositorioFilme {

	void salvar();

	void cadastrar(Filme f);

	Filme procurarID(String ID);

	Filme procurarNome(String nome);

	void remover(String ID);

	boolean existe(String ID);

	public String[] retornaFilmes();

}