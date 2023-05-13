package classesBasicasPessoa;

import java.io.Serializable;

public class Usuario extends Pessoa implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5049389043160337615L;
	private Object idade;

	public Usuario(String nome, String email, String login, String senha, Object idade) {
		super(nome, email, login, senha);
		this.setIdade(idade);
	}

	public Object getIdade() {
		return idade;
	}

	public void setIdade(Object idade) {
		if ((int) idade == 0 || (int) idade >= 100) {

		} else {
			this.idade = idade;
		}

	}

	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append(super.toString());
		sb.append("\nIdade: ");
		sb.append(this.idade);
		return sb.toString() + "\n";
	}

}
