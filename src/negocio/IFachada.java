package negocio;

import java.util.ArrayList;
import java.util.List;

import classesBasicasCinema.Cinema;
import classesBasicasCinema.Filme;
import classesBasicasCinema.Ingresso;
import classesBasicasPessoa.Administrador;
import classesBasicasPessoa.Pessoa;
import classesBasicasPessoa.Usuario;

public interface IFachada {

	public abstract void cadastrarCinema(Cinema c);

	public abstract void salvarCinema();

	public abstract boolean existeCinema(String nome, int telefone);

	public abstract Cinema procurarCinema(String nome);

	public abstract void removerCinema(String nome, int telefone);

	public String[] retornaTudo();

	public abstract void cadastrarFilme(Filme f);

	public abstract void salvarFilme();

	public abstract boolean existeFilme(String iD);

	public abstract Filme procurarFilmeID(String iD);

	public abstract Filme procurarFilmeNome(String nome);

	public abstract void removerFilme(String iD);

	public String[] retornaFilmes();

	public abstract boolean cadastrarUsuario(Usuario u);

	public abstract Object checkType(String Login);

	public abstract void salvarUsuario();

	public abstract Usuario procurarUsuario(String login);

	public abstract boolean existeUsuario(String login);

	public abstract void removerUsuario(String login);

	public abstract boolean loginUsuario(String login, String senha);

	public abstract void printarUsuario(Usuario u);

	public boolean cadastrarAdmin(Administrador a);

	public Administrador procurarAdminLogin(String login);

	public Administrador procurarAdminSenha(String senha);

	public boolean existeAdmin(String login);

	public void removerAdmin(String login);

	public boolean loginAdmin(String login, String senha);

	public void salvarAdmin();

	public void cadastrarIngresso(Ingresso i);

	public boolean existeIngresso(String codigo);

	public Ingresso procurarIngresso(String codigo);

	public void removerIngresso(String codigo);

	public void salvarIngresso();
}
