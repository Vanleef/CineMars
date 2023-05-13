package negocio;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import classesBasicasCinema.Cinema;
import dados.IRepositorioCinema;
import dados.RepositorioCinemasArray;

public class CadastroCinema implements ICadastroCinema, Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5719088007146989091L;
	private IRepositorioCinema repositorio;

	public CadastroCinema() {
		this.repositorio = RepositorioCinemasArray.getInstance();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see negocio.ICadastroCinema#cadastrar(classesBasicasCinema.Cinema)
	 */
	@Override
	public void cadastrar(Cinema c) {
		if (c == null) {
			JOptionPane.showMessageDialog(null, "PARAMETRO INVALIDO");
		} else {
			if (!this.existe(c.getNome(), c.getTelefone())) {
				this.repositorio.cadastrar(c);
			} else {
				JOptionPane.showMessageDialog(null, "ERRO! CINEMA JÁ CADASTRADO!");
			}
		}
	}

	public void salvar() {
		repositorio.salvar();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see negocio.ICadastroCinema#existe(java.lang.String, int)
	 */
	@Override
	public boolean existe(String nome, int telefone) {
		return this.repositorio.existe(nome, telefone);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see negocio.ICadastroCinema#procurar(java.lang.String)
	 */
	@Override
	public Cinema procurar(String nome) {
		return this.repositorio.procurar(nome);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see negocio.ICadastroCinema#remover(java.lang.String, int)
	 */
	@Override
	public void remover(String nome, int telefone) {
		this.repositorio.remover(nome, telefone);
	}

	public String[] retornaTudo() {
		return this.repositorio.retornaTudo();
	}

}
