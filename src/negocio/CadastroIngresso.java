package negocio;

import java.io.Serializable;

import javax.swing.JOptionPane;

import classesBasicasCinema.Ingresso;
import dados.IRepositorioIngresso;
import dados.RepositorioIngressosArray;

public class CadastroIngresso implements ICadastroIngresso, Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3843330138258704304L;
	private IRepositorioIngresso repositorio;

	public CadastroIngresso() {
		this.repositorio = RepositorioIngressosArray.getInstance();
	}

	@Override
	public void cadastrar(Ingresso i) {
		if (i == null) {
			JOptionPane.showMessageDialog(null, "PARAMETRO INVALIDO");
		} else {
			if (!this.existe(i.getCodigo())) {
				this.repositorio.cadastrar(i);
			} else {
				JOptionPane.showMessageDialog(null, "ERRO! INGRESSO JÁ CADASTRADO!");
			}
		}
	}

	@Override
	public boolean existe(String codigo) {
		return this.repositorio.existe(codigo);
	}

	@Override
	public Ingresso procurar(String codigo) {
		return this.repositorio.procurar(codigo);
	}

	public void salvar() {
		repositorio.salvar();
	}

	@Override
	public void remover(String codigo) {
		this.repositorio.remover(codigo);
	}

}
