package dados;

import classesBasicasCinema.Ingresso;

public interface IRepositorioIngresso {

	void salvar();

	void cadastrar(Ingresso i);

	Ingresso procurar(String codigo);

	void remover(String codigo);

	boolean existe(String codigo);
}
