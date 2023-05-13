package negocio;

import java.io.Serializable;
import java.util.Scanner;

import javax.swing.JOptionPane;

import classesBasicasPessoa.Administrador;
import classesBasicasPessoa.Pessoa;
import dados.IRepositorioAdmin;
import dados.RepositorioAdminArray;

public class CadastroAdmin implements ICadastroAdmin, Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4738714696075798068L;
	private IRepositorioAdmin repositorio;

	public CadastroAdmin() {
		this.repositorio = RepositorioAdminArray.getInstance();
	}

	public boolean cadastrar(Administrador a) {
		boolean resposta = false;
		if (a == null) {
			JOptionPane.showMessageDialog(null, "PARAMETRO INVALIDO");
		} else {
			if (!(this.existe(a.getLogin()))) {
				this.repositorio.cadastrar(a);

				resposta = true;
			} else {
				JOptionPane.showMessageDialog(null, "ERRO! LOGIN JÁ CADASTRADO! (ADMINISTRADOR)");
			}
		}
		return resposta;
	}

	@Override
	public Administrador procurarAdminLogin(String login) {
		return this.repositorio.procurarAdminLogin(login);
	}

	public Administrador procurarAdminSenha(String senha) {
		return this.repositorio.procurarAdminSenha(senha);
	}

	@Override
	public boolean existe(String login) {
		return this.repositorio.existe(login);
	}

	@Override
	public void remover(String login) {
		boolean x = false;
		while (x == false) {
			String s = JOptionPane.showInputDialog(null, "DIGITE SUA SENHA: ");
			Pessoa aux = (Pessoa) procurarAdminLogin(login);
			if (s == aux.getSenha()) {
				this.repositorio.remover(login);
				x = true;
			} else {
				JOptionPane.showMessageDialog(null, "SENHA ERRADA, DIGITE NOVAMENTE");
			}
		}

	}

	public void salvar() {
		repositorio.salvar();
	}

	public boolean login(String login, String senha) {
		boolean logado = false;
		if (repositorio.existe(login) && repositorio.procurarAdminLogin(login).getSenha().equals(senha)) {
			logado = true;
			JOptionPane.showMessageDialog(null, "LOGIN REALIZADO COM SUCESSO");
			repositorio.procurarAdminLogin(login).toString();
		} else {
			JOptionPane.showMessageDialog(null, "LOGIN NÃO REALIZADO");
		}
		return logado;
	}

}
