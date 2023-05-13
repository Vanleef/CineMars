package dados;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import classesBasicasPessoa.Usuario;

public class RepositorioUsuariosArray implements IRepositorioUsuario, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2609575047771280596L;
	private static IRepositorioUsuario instanceUser;
	private ArrayList<Usuario> usuarios;
	private int next;

	public RepositorioUsuariosArray(int tamanho) {
		this.usuarios = new ArrayList<Usuario>(tamanho);
		this.next = 0;
	}

	public static synchronized IRepositorioUsuario getInstance() {
		if (instanceUser == null) {
			if (ler() == null) {
				instanceUser = new RepositorioUsuariosArray(100);
			} else {
				instanceUser = (IRepositorioUsuario) ler();
			}
		}
		return instanceUser;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see dados.IRepositorioUsuario#salvar()
	 */
	@Override
	public void salvar() {
		try {
			File f = new File("Usuarios\\RepositorioUsuariosArray.db");
			FileOutputStream fos = new FileOutputStream(f);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(instanceUser);
			oos.close();
			System.out.println("Objeto serializado com sucesso");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static IRepositorioUsuario ler() {
		IRepositorioUsuario repo = null;
		try {
			File f = new File("Usuarios\\RepositorioUsuariosArray.db");

			FileInputStream fis = new FileInputStream(f);
			ObjectInputStream ois = new ObjectInputStream(fis);
			Object o = ois.readObject();
			if (o != null) {
				repo = (RepositorioUsuariosArray) o;
				System.out.println("agora ele foi des-serializado com sucesso");
			}
			ois.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return repo;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see dados.IRepositorioUsuario#cadastrar(classesBasicasPessoa.Usuario)
	 */
	/*
	 * (non-Javadoc)
	 * 
	 * @see dados.IRepositorioUsuario#cadastrar(classesBasicasPessoa.Usuario)
	 */

	public void cadastrar(Usuario u) {
		if (u != null) {
			usuarios.add(u);
			this.next = next + 1;

			System.out.println("Usuário Cadastrado!");
		}
		this.salvar();
	}

	private int procurarIndice(String login) {
		int indice = 0;
		boolean found = false;
		while (found != true && indice < this.next) {
			if (login.equals(this.usuarios.get(indice).getLogin())) {
				found = true;
			} else {
				indice = indice + 1;
			}
		}
		return indice;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see dados.IRepositorioUsuario#procurar(java.lang.String)
	 */
	/*
	 * (non-Javadoc)
	 * 
	 * @see dados.IRepositorioUsuario#procurar(java.lang.String)
	 */

	public Usuario procurar(String login) {
		int i = this.procurarIndice(login);
		Usuario saida = null;
		if (i != this.next) {
			saida = this.usuarios.get(i);
		} else {
			System.out.println("O USUARIO NÃO FOI ENCONTRADO!");
		}

		return saida;
	}

	public void remover(String login) {
		if (existe(login)) {
			Usuario u = procurar(login);
			this.usuarios.remove(u);
			System.out.println("Usuario foi removido!");
		} else {
			System.out.println("Houve um problema! Usuario não pode ser removido.");
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see dados.IRepositorioUsuario#existe(java.lang.String)
	 */
	/*
	 * (non-Javadoc)
	 * 
	 * @see dados.IRepositorioUsuario#existe(java.lang.String)
	 */

	@Override
	public boolean existe(String login) {
		boolean existe = false;
		Usuario u = this.procurar(login);
		if (u != null) {
			existe = true;
			System.out.println("Usuario existe!");
		} else {
			System.out.println("Usuario não existe!");
		}
		return existe;
	}

	public void printar(Usuario u) {
		try {
			JOptionPane.showMessageDialog(null, u.toString());
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
