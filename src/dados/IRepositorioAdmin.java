package dados;

import java.util.ArrayList;

import classesBasicasCinema.Cinema;
import classesBasicasPessoa.Administrador;

public interface IRepositorioAdmin {

	void salvar();

	void cadastrar(Administrador a);

	Administrador procurarAdminLogin(String login);

	Administrador procurarAdminSenha(String Senha);

	void remover(String login);

	boolean existe(String login);

}
