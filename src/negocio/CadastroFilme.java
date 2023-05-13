package negocio;

import java.io.Serializable;

import javax.swing.JOptionPane;

import classesBasicasCinema.Filme;
import dados.IRepositorioFilme;
import dados.RepositorioFilmesArray;

public class CadastroFilme implements ICadastroFilme, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3249574711866813942L;
	private IRepositorioFilme repositorio;

	public CadastroFilme() {
		this.repositorio = RepositorioFilmesArray.getInstance();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see negocio.ICadastroFilme#cadastrar(classesBasicasCinema.Filme)
	 */
	@Override
	public void cadastrar(Filme f) {
		if (f == null) {
			JOptionPane.showMessageDialog(null, "PARAMETRO INVALIDO");
		} else {
			if (!this.existe(f.getID())) {
				this.repositorio.cadastrar(f);
			} else {
				JOptionPane.showMessageDialog(null, "ERRO! FILME JÁ CADASTRADO!");
			}
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see negocio.ICadastroFilme#existe(java.lang.String)
	 */
	@Override
	public boolean existe(String iD) {
		return this.repositorio.existe(iD);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see negocio.ICadastroFilme#procurar(java.lang.String)
	 */
	@Override
	public Filme procurarID(String iD) {
		return this.repositorio.procurarID(iD);
	}

	@Override
	public Filme procurarNome(String nome) {
		return this.repositorio.procurarNome(nome);
	}

	public void salvar() {
		repositorio.salvar();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see negocio.ICadastroFilme#remover(java.lang.String)
	 */
	@Override
	public void remover(String iD) {
		this.repositorio.remover(iD);
	}

	public String[] retornaFilmes() {
		return this.repositorio.retornaFilmes();
	}

}
