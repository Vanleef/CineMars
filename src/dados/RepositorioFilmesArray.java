package dados;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import classesBasicasCinema.Filme;

public class RepositorioFilmesArray implements IRepositorioFilme, Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 487418379305138416L;
	private static IRepositorioFilme instanceFilm;
	private ArrayList<Filme> filmes;
	private int next;

	public RepositorioFilmesArray(int tamanho) {

		this.filmes = new ArrayList<Filme>(tamanho);
		this.next = 0;
	}

	public static synchronized IRepositorioFilme getInstance() {
		if (instanceFilm == null) {
			if (ler() == null) {
				instanceFilm = new RepositorioFilmesArray(100);
			} else {
				instanceFilm = (RepositorioFilmesArray) ler();
			}
		}
		return instanceFilm;
	}

	public void salvar() {
		try {
			File f = new File("Filmes\\RepositorioFilmesArray.db");
			FileOutputStream fos = new FileOutputStream(f);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(instanceFilm);
			oos.close();
			System.out.println("Objeto serializado com sucesso");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static IRepositorioFilme ler() {
		IRepositorioFilme repo = null;
		try {
			File f = new File("Filmes\\RepositorioFilmesArray.db");

			FileInputStream fis = new FileInputStream(f);
			ObjectInputStream ois = new ObjectInputStream(fis);
			Object o = ois.readObject();
			if (o != null) {
				repo = (RepositorioFilmesArray) o;
				System.out.println("agora ele foi des-serializado com sucesso");
			}
			ois.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return repo;
	}

	public void cadastrar(Filme f) {
		if (f != null) {
			this.filmes.add(f);
			this.next = next + 1;
			System.out.println("Filme Cadastrado!");
		}
		this.salvar();
	}

	private int procurarIndiceID(String ID) {
		int indice = 0;
		boolean found = false;
		while (found != true && indice < this.next) {
			if (ID.equals(this.filmes.get(indice).getID())) {
				found = true;
			} else {
				indice = indice + 1;
			}
		}
		return indice;
	}

	private int procurarIndiceNome(String nome) {
		int indice = 0;
		boolean found = false;
		while (found != true && indice < this.next) {
			if (nome.equals(this.filmes.get(indice).getNome())) {
				found = true;
			} else {
				indice = indice + 1;
			}
		}
		return indice;
	}

	public Filme procurarID(String ID) {
		int i = this.procurarIndiceID(ID);
		Filme saida = null;
		if (i != this.next) {
			saida = this.filmes.get(i);
		} else {
			System.out.println("Filme não encontrado!");
		}

		return saida;
	}

	public Filme procurarNome(String nome) {
		int i = this.procurarIndiceNome(nome);
		Filme saida = null;
		if (i != this.next) {
			saida = this.filmes.get(i);
		} else {
			System.out.println("Filme não encontrado!");
		}

		return saida;
	}

	public void remover(String ID) {
		if (existe(ID)) {
			Filme f = procurarID(ID);
			this.filmes.remove(f);
			System.out.println("Filme foi removido!");
		} else {
			System.out.println("Houve um problema! Filme não pode ser removido.");
		}
		this.salvar();
	}

	public boolean existe(String ID) {
		boolean existe = false;
		Filme f = procurarID(ID);
		if (f != null) {
			existe = true;
			System.out.println("Filme existe!");
		} else {
			System.out.println("Filme não existe!");
		}
		return existe;
	}

	public String[] retornaFilmes() {
		List<String> listaNegra = new ArrayList<String>();
		String[] lista = new String[filmes.size()];
		for (int i = 0; i < filmes.size(); i++) {
			for (int j = 0; j < filmes.size(); j++) {
				if (!listaNegra.contains(filmes.get(i).getNome())) {
					lista[i] = filmes.get(i).getNome();
					listaNegra.add(filmes.get(i).getNome());
				}
			}
		}
		return lista;
	}
}
