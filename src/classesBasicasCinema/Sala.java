package classesBasicasCinema;

public class Sala {

	private int linha;
	private int coluna;
	private int numero;
	private String cadeiras[][];
	char letra;

	public Sala(int numero, int linha, int coluna) {

		this.cadeiras = new String[linha][coluna];
		this.coluna = coluna;
		this.linha = linha;
		this.numero = numero;
		this.letra = 'a';

		for (int l = 0; l < this.linha; l++) {
			for (int c = 0; c < this.coluna; c++) {
				String a = String.valueOf(letra).toUpperCase();
				cadeiras[l][c] = a + c;
			}
			letra++;
		}

	}

	public int getNumero() {
		return numero;
	}

	public int getLinha() {
		return linha;
	}

	public int getColuna() {
		return coluna;
	}

	public void setLinha(int linha) {
		this.linha = linha;
	}

	public void setColuna(int coluna) {
		this.coluna = coluna;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String reservaCadeira(String num) {
		String result = null;
		for (int l = 0; l < this.linha; l++) {
			for (int c = 0; c < this.coluna; c++) {
				if (cadeiras[l][c].equals(num)) {
					result = cadeiras[l][c];
					if (!cadeiras[l][c].equals("X")) {
						cadeiras[l][c] = "X";
						mostraCadeiras();
					}
				}

			}
		}
		return result;
	}

	public void mostraCadeiras() {
		for (int l = 0; l < linha; l++) {
			System.out.print(" " + (l + 1) + "   =>");
			for (int c = 0; c < coluna; c++) {
				System.out.print(" " + cadeiras[l][c] + " |");
			}
			System.out.print(" \n");
		}
		System.out.println(" \n");
	}

}
