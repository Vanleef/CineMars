package classesBasicasPessoa;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import classesBasicasCinema.Cinema;

public class Administrador extends Pessoa implements Serializable {
	
	private Cinema cinema;
	
	private static final long serialVersionUID = -8441289941209738977L;

	public Administrador(String nome, String email, String login, String senha, Cinema cinema) {
		super(nome, email, login, senha);
		this.cinema = cinema;
	}

	public Cinema getCinema() {
		return cinema;
	}

	public void setCinema(Cinema cinema) {
		this.cinema = cinema;
	}
	
	
}
