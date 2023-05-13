package dados;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

import classesBasicasCinema.Filme;
import classesBasicasCinema.Ingresso;

public class RepositorioIngressosArray implements IRepositorioIngresso, Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8844845848861865729L;
	private static IRepositorioIngresso instanceIngresso;
	private ArrayList<Ingresso> ingressos;
	private int next;

	public RepositorioIngressosArray(int tamanho) {

		this.ingressos = new ArrayList<Ingresso>(tamanho);
		this.next = 0;
	}

	public static synchronized IRepositorioIngresso getInstance() {
		if (instanceIngresso == null) {
			if (ler() == null) {
				instanceIngresso = new RepositorioIngressosArray(100);
			} else {
				instanceIngresso = (RepositorioIngressosArray) ler();
			}
		}
		return instanceIngresso;
	}

	public void salvar() {
		try {
			File f = new File("Ingressos\\RepositorioIngressosArray.db");
			FileOutputStream fos = new FileOutputStream(f);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(instanceIngresso);
			oos.close();
			System.out.println("Objeto serializado com sucesso");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static IRepositorioIngresso ler() {
		IRepositorioIngresso repo = null;
		try {
			File f = new File("Ingressos\\RepositorioIngressosArray.db");

			FileInputStream fis = new FileInputStream(f);
			ObjectInputStream ois = new ObjectInputStream(fis);
			Object o = ois.readObject();
			if (o != null) {
				repo = (RepositorioIngressosArray) o;
				System.out.println("agora ele foi des-serializado com sucesso");
			}
			ois.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return repo;
	}

	public void cadastrar(Ingresso i) {
		if (i != null) {
			ingressos.add(i);
			this.next = next + 1;
			System.out.println("Ingresso Cadastrado!");
		}

	}

	private int procurarIndice(String codigo) {
		int indice = 0;
		boolean found = false;
		while (found != true && indice < this.next) {
			if (codigo.equals(this.ingressos.get(indice).getCodigo())) {
				found = true;
			} else {
				indice = indice + 1;
			}
		}
		return indice;
	}

	public Ingresso procurar(String codigo) {
		int i = this.procurarIndice(codigo);
		Ingresso saida = null;
		if (i != this.next) {
			saida = this.ingressos.get(i);
		} else {
			System.out.println("Ingresso não encontrado!");
		}

		return saida;
	}

	public void remover(String codigo) {
		if (existe(codigo)) {
			Ingresso i = procurar(codigo);
			this.ingressos.remove(i);
			System.out.println("Ingresso foi removido!");
		} else {
			System.out.println("Houve um problema! Ingresso não pode ser removido.");
		}

	}

	public boolean existe(String codigo) {
		boolean existe = false;
		Ingresso i = this.procurar(codigo);
		if (i != null) {
			existe = true;
			System.out.println("Ingresso existe!");
		} else {
			System.out.println("Ingresso não existe!");
		}
		return existe;
	}
}