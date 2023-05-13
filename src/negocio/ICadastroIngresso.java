package negocio;

import classesBasicasCinema.Ingresso;

public interface ICadastroIngresso {

	public abstract void cadastrar(Ingresso i);

	public abstract boolean existe(String codigo);

	public abstract Ingresso procurar(String codigo);

	public abstract void remover(String codigo);

	public abstract void salvar();

}
