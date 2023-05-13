package classesBasicasCinema;

import java.util.Random;

import classesBasicasPessoa.Usuario;

public class Ingresso {

	private Usuario usuario;
	private Sessao sessao;
	private Cinema cinema;
	private String codigo;
	private int preco;

	public Ingresso(Usuario usuario, Sessao sessao, Cinema cinema, int preco) {

		this.cinema = cinema;
		this.sessao = sessao;
		this.usuario = usuario;
		this.preco = preco;

		Random rand = new Random();
		for (int i = 0; i < 8; i++) {
			int x = 33 + rand.nextInt(93);
			if (i > 0) {
				codigo += Character.toString((char) x);
			} else {
				codigo = Character.toString((char) x);
			}
		}
		this.setCodigo(codigo);
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public Sessao getSessao() {
		return sessao;
	}

	public void setSessao(Sessao sessao) {
		this.sessao = sessao;
	}

	public Cinema getCinema() {
		return cinema;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public void setCinema(Cinema cinema) {
		this.cinema = cinema;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public void setPreco(int preco) {
		this.preco = preco;
	}

	public String getCodigo() {
		return codigo;
	}

	public int getPreco() {
		return preco;
	}

}
