package negocio;

import java.io.Serializable;

import javax.swing.JOptionPane;

import classesBasicasPessoa.Pessoa;
import classesBasicasPessoa.Usuario;
import dados.IRepositorioUsuario;
import dados.RepositorioUsuariosArray;

public class CadastroUsuario implements ICadastroUsuario, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2890454419732913371L;
	private IRepositorioUsuario repositorio;

	public CadastroUsuario() {
		this.repositorio = RepositorioUsuariosArray.getInstance();
	}

	public boolean cadastrar(Usuario u) {
		boolean resposta = false;
		if (u == null) {
			JOptionPane.showMessageDialog(null, "PARAMETRO INVALIDO");
		} else {
			if (!(this.existe(u.getLogin()))) {
				this.repositorio.cadastrar(u);

				resposta = true;
			} else {
				JOptionPane.showMessageDialog(null, "ERRO! LOGIN JÁ CADASTRADO! (USUARIO)");
			}
		}
		return resposta;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see negocio.ICadastroUsuario#procurar(java.lang.String)
	 */
	@Override
	public Usuario procurar(String login) {
		return this.repositorio.procurar(login);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see negocio.ICadastroUsuario#existe(java.lang.String)
	 */
	@Override
	public boolean existe(String login) {
		return this.repositorio.existe(login);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see negocio.ICadastroUsuario#remover(java.lang.String)
	 */
	@Override
	public void remover(String login) {
		Usuario u = this.procurar(login);
		boolean x = false;
		while (x == false) {
			String senha = u.getSenha();
			Pessoa aux = (Pessoa) procurar(login);
			if (senha == aux.getSenha()) {
				this.repositorio.remover(login);
				x = true;
			} else {
				JOptionPane.showMessageDialog(null, "ERRO AO USUARIO SER REMOVIDO");
			}
		}

	}

	public void printar(Usuario u) {
		repositorio.printar(u);
	}

	public void salvar() {
		repositorio.salvar();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see negocio.ICadastroUsuario#login(java.lang.String, int)
	 */
	@Override
	public boolean login(String login, String senha) {
		boolean logado = false;
		if (repositorio.existe(login) && repositorio.procurar(login).getSenha().equals(senha)) {
			logado = true;
			JOptionPane.showMessageDialog(null, "LOGIN REALIZADO COM SUCESSO");
		} else {
			JOptionPane.showMessageDialog(null, "LOGIN NÃO REALIZADO");
		}
		return logado;
	}

}
