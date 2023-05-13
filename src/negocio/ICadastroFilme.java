package negocio;

import classesBasicasCinema.Filme;

public interface ICadastroFilme {

	public abstract void cadastrar(Filme f);

	public abstract boolean existe(String iD);

	public abstract Filme procurarID(String iD);

	public abstract Filme procurarNome(String nome);

	public abstract void remover(String iD);

	public abstract void salvar();

	public String[] retornaFilmes();

}