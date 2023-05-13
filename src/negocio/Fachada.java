package negocio;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import classesBasicasCinema.Cinema;
import classesBasicasCinema.Filme;
import classesBasicasCinema.Ingresso;
import classesBasicasPessoa.Administrador;
import classesBasicasPessoa.Pessoa;
import classesBasicasPessoa.Usuario;

public class Fachada implements IFachada, Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7208831605966568731L;
	private ICadastroUsuario cadastroUsuario;
	private ICadastroFilme cadastroFilme;
	private ICadastroCinema cadastroCinema;
	private ICadastroAdmin cadastroAdmin;
	private ICadastroIngresso cadastroIngresso;

	private static IFachada instance;

	public Fachada() {
		this.cadastroCinema = new CadastroCinema();
		this.cadastroFilme = new CadastroFilme();
		this.cadastroUsuario = new CadastroUsuario();
		this.cadastroAdmin = new CadastroAdmin();
		this.cadastroIngresso = new CadastroIngresso();
	}

	public static IFachada getInstance() {
		if (instance == null) {
			instance = new Fachada();
		}
		return instance;
	}

	@Override
	public void cadastrarCinema(Cinema c) {
		cadastroCinema.cadastrar(c);
	}

	public void salvarCinema() {
		cadastroCinema.salvar();
	}

	@Override
	public boolean existeCinema(String nome, int telefone) {
		return cadastroCinema.existe(nome, telefone);
	}

	@Override
	public Cinema procurarCinema(String nome) {
		return cadastroCinema.procurar(nome);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see negocio.IFachada#removerCinema(java.lang.String, int)
	 */
	@Override
	public void removerCinema(String nome, int telefone) {
		cadastroCinema.remover(nome, telefone);
	}

	public String[] retornaTudo() {
		return this.cadastroCinema.retornaTudo();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see negocio.IFachada#cadastrarFilme(classesBasicasCinema.Filme)
	 */
	@Override
	public void cadastrarFilme(Filme f) {
		cadastroFilme.cadastrar(f);
	}

	public void salvarFilme() {
		cadastroFilme.salvar();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see negocio.IFachada#existeFilme(java.lang.String)
	 */
	@Override
	public boolean existeFilme(String iD) {
		return cadastroFilme.existe(iD);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see negocio.IFachada#procurarFilme(java.lang.String)
	 */
	@Override
	public Filme procurarFilmeID(String iD) {
		return cadastroFilme.procurarID(iD);
	}

	@Override
	public Filme procurarFilmeNome(String nome) {
		return cadastroFilme.procurarNome(nome);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see negocio.IFachada#removerFilme(java.lang.String)
	 */
	@Override
	public void removerFilme(String iD) {
		cadastroFilme.remover(iD);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see negocio.IFachada#cadastrarUsuario(classesBasicasPessoa.Usuario)
	 */
	@Override
	public boolean cadastrarUsuario(Usuario u) {
		return cadastroUsuario.cadastrar(u);
	}

	public void salvarUsuario() {
		cadastroUsuario.salvar();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * =======
	 * 
	 * 
	 * @see negocio.IFachada#procurarUsuario(java.lang.String)
	 */
	@Override
	public Usuario procurarUsuario(String login) {
		return cadastroUsuario.procurar(login);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see negocio.IFachada#existeUsuario(java.lang.String)
	 */
	@Override
	public boolean existeUsuario(String login) {
		return cadastroUsuario.existe(login);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * =======
	 * 
	 * 
	 * 
	 * /* (non-Javadoc) >>>>>>> branch 'master' of
	 * https://github.com/Brunosimoesorlandelli/CineMars.git
	 * 
	 * @see negocio.IFachada#removerUsuario(java.lang.String)
	 */
	@Override
	public void removerUsuario(String login) {
		cadastroUsuario.remover(login);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see negocio.IFachada#loginUsuario(java.lang.String, int)
	 */
	@Override
	public boolean loginUsuario(String login, String senha) {
		return cadastroUsuario.login(login, senha);
	}

	public Object checkType(String login) {
		Pessoa p = this.procurarUsuario(login);
		if (p != null) {
		} else {
			p = this.procurarAdminLogin(login);
			if (p != null) {
			} else {
				JOptionPane.showMessageDialog(null, "PESSOA NÃO ENCONTRADA!");
			}

		}

		return p;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see negocio.IFachada#printarUsuario(java.lang.String)
	 */
	@Override

	public void printarUsuario(Usuario u) {

		cadastroUsuario.printar(u);
	}

	public boolean cadastrarAdmin(Administrador a) {
		boolean cadastro = false;
		if (cadastroUsuario.procurar(a.getLogin()) == null) {
			cadastro = cadastroAdmin.cadastrar(a);
		}
		return cadastro;
	}

	public Administrador procurarAdminLogin(String login) {
		return cadastroAdmin.procurarAdminLogin(login);
	}

	public Administrador procurarAdminSenha(String senha) {
		return cadastroAdmin.procurarAdminSenha(senha);
	}

	public boolean existeAdmin(String login) {
		return cadastroAdmin.existe(login);
	}

	public void removerAdmin(String login) {
		cadastroAdmin.remover(login);
	}

	public boolean loginAdmin(String login, String senha) {
		return cadastroAdmin.login(login, senha);
	}

	public void salvarAdmin() {
		cadastroAdmin.salvar();
	}

	public String[] retornaFilmes() {
		return cadastroFilme.retornaFilmes();

	}

	public void cadastrarIngresso(Ingresso i) {
		cadastroIngresso.cadastrar(i);
	}

	public boolean existeIngresso(String codigo) {
		return cadastroIngresso.existe(codigo);
	}

	public Ingresso procurarIngresso(String codigo) {
		return cadastroIngresso.procurar(codigo);
	}

	public void removerIngresso(String codigo) {
		cadastroIngresso.remover(codigo);
	}

	public void salvarIngresso() {
		cadastroIngresso.salvar();
	}
}
