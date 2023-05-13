package dados;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import classesBasicasPessoa.Administrador;

public class RepositorioAdminArray implements IRepositorioAdmin, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1393671799742873229L;
	private static IRepositorioAdmin instanceAdmin;
	private ArrayList<Administrador> administradores;
	private int next;

	public RepositorioAdminArray(int tamanho) {
		this.administradores = new ArrayList<Administrador>(tamanho);
		this.next = 0;
	}

	public static synchronized IRepositorioAdmin getInstance() {
		if (instanceAdmin == null) {
			if (ler() == null) {
				instanceAdmin = new RepositorioAdminArray(100);
			} else {
				instanceAdmin = (IRepositorioAdmin) ler();
			}
		}
		return instanceAdmin;
	}

	@Override
	public void salvar() {
		try {
			File f = new File("Administradores\\RepositorioAdminArray.db");
			FileOutputStream fos = new FileOutputStream(f);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(instanceAdmin);
			oos.close();
			System.out.println("Objeto serializado com sucesso");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static IRepositorioAdmin ler() {
		IRepositorioAdmin repo = null;
		try {
			File f = new File("Administradores\\RepositorioAdminArray.db");

			FileInputStream fis = new FileInputStream(f);
			ObjectInputStream ois = new ObjectInputStream(fis);
			Object o = ois.readObject();
			if (o != null) {
				repo = (RepositorioAdminArray) o;
				System.out.println("agora ele foi des-serializado com sucesso");
			}
			ois.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return repo;
	}

	public void cadastrar(Administrador a) {
		if (a != null) {
			administradores.add(a);
			this.next = next + 1;

			JOptionPane.showMessageDialog(null, "Administrador Cadastrado!");
		}
		this.salvar();
	}

	private int procurarIndiceLogin(String login) {
		int indice = 0;
		boolean found = false;
		while (found != true && indice < this.next) {
			if (login.equals(this.administradores.get(indice).getLogin())) {
				found = true;
			} else {
				indice = indice + 1;
			}
		}
		return indice;
	}

	private int procurarIndiceSenha(String senha) {
		int indice = 0;
		boolean found = false;
		while (found != true && indice < this.next) {
			if (senha.equals(this.administradores.get(indice).getSenha())) {
				found = true;
			} else {
				indice = indice + 1;
			}
		}
		return indice;
	}

	public Administrador procurarAdminLogin(String login) {
		int i = this.procurarIndiceLogin(login);
		Administrador saida = null;
		if (i != this.next) {
			saida = this.administradores.get(i);
		} else {
			JOptionPane.showMessageDialog(null, "O ADMINISTRADOR NÃO FOI ENCONTRADO!");
		}

		return saida;
	}

	public Administrador procurarAdminSenha(String senha) {
		int i = this.procurarIndiceSenha(senha);
		Administrador saida = null;
		if (i != this.next) {
			saida = this.administradores.get(i);
		} else {
			JOptionPane.showMessageDialog(null, "O ADMINISTRADOR NÃO FOI ENCONTRADO!");
		}

		return saida;
	}

	public void remover(String login) {
		int i = this.procurarIndiceLogin(login);
		if (i != this.next) {
			this.administradores.remove(i);
			System.out.println("Administrador foi removido!");
		} else {
			System.out.println("Houve um problema! Administrador não pode ser removido.");
		}

	}

	@Override
	public boolean existe(String login) {
		boolean existe = false;
		int i = this.procurarIndiceLogin(login);
		if (i != next) {
			existe = true;
			System.out.println("Administrador existe!");
		} else {
			System.out.println("Administrador não existe!");
		}
		return existe;
	}

}
