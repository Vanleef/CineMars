package dados;

import java.util.ArrayList;
import java.util.List;

import classesBasicasCinema.Cinema;

public interface IRepositorioCinema {

	void salvar();

	void cadastrar(Cinema c);

	Cinema procurar(String nome);

	void remover(String nome, int telefone);

	boolean existe(String nome, int telefone);

	public String[] retornaTudo();
}