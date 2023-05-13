package gui;

import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import classesBasicasCinema.Filme;
import classesBasicasPessoa.Usuario;
import negocio.Fachada;
import negocio.IFachada;
import javax.swing.JScrollBar;

public class TelaFilme extends JFrame {

	private JPanel contentPane;
	private Usuario u;
	IFachada f = Fachada.getInstance();

	public TelaFilme(String nome, Usuario u) {
		TelaFilme filme = new TelaFilme(f.procurarFilmeNome(nome), u);
	}

	/**
	 * @wbp.parser.constructor
	 */
	public TelaFilme(Filme filme, Usuario u) {
		setTitle("Cinemars");
		setIconImage(Toolkit.getDefaultToolkit().getImage("Imagens\\film.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1015, 682);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(618, 63, 343, 490);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblTituloDoFilme = new JLabel(filme.getNome());
		lblTituloDoFilme.setBounds(6, 6, 331, 16);
		panel_1.add(lblTituloDoFilme);

		JLabel lblDiretor = new JLabel("Diretor: ");
		lblDiretor.setBounds(6, 34, 55, 16);
		panel_1.add(lblDiretor);

		JLabel lblNomeDoDiretor = new JLabel(filme.getDiretor());
		lblNomeDoDiretor.setBounds(73, 34, 264, 16);
		panel_1.add(lblNomeDoDiretor);

		JLabel lblAtores = new JLabel("Atores:");
		lblAtores.setBounds(6, 62, 55, 16);
		panel_1.add(lblAtores);

		JLabel lblNomeDosAtores = new JLabel(filme.getAtores());
		lblNomeDosAtores.setVerticalAlignment(SwingConstants.TOP);
		lblNomeDosAtores.setBounds(73, 62, 264, 27);
		panel_1.add(lblNomeDosAtores);

		JLabel lblGenero = new JLabel("Genero: ");
		lblGenero.setBounds(6, 122, 55, 16);
		panel_1.add(lblGenero);

		JLabel lblEstiloDoGenero = new JLabel(filme.getGenero());
		lblEstiloDoGenero.setBounds(73, 122, 264, 16);
		panel_1.add(lblEstiloDoGenero);

		JLabel lblSinopse = new JLabel("Sinopse: ");
		lblSinopse.setBounds(6, 145, 55, 16);
		panel_1.add(lblSinopse);

		JLabel lblClassificaoIndicativa = new JLabel("Classifica\u00E7\u00E3o Indicativa: ");
		lblClassificaoIndicativa.setBounds(6, 90, 144, 16);
		panel_1.add(lblClassificaoIndicativa);

		JLabel lblNewLabel = new JLabel("CI");
		lblNewLabel.setBounds(162, 90, 55, 16);
		panel_1.add(lblNewLabel);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(6, 173, 331, 311);
		panel_1.add(scrollPane_1);

		JTextPane textPane = new JTextPane();
		textPane.setText(filme.getSinopse());
		textPane.setFont(new Font("SansSerif", Font.PLAIN, 12));
		textPane.setEditable(false);
		scrollPane_1.setViewportView(textPane);

		JButton btnVoltar = new JButton("");
		btnVoltar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0) {
				dispose();
				TelaMenuUsuario menu = new TelaMenuUsuario(u);
				menu.setVisible(true);
				menu.setLocationRelativeTo(null);
				menu.setResizable(false);
			}
		});

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(174, 58, 360, 501);
		contentPane.add(scrollPane);
		JLabel lblPoster = new JLabel("");
		lblPoster.setIcon(new ImageIcon(filme.getPoster().getAbsolutePath()));
		scrollPane.setViewportView(lblPoster);

		btnVoltar.setIcon(new ImageIcon("Imagens//VoltarIcon.png"));
		btnVoltar.setBounds(0, 570, 69, 74);
		btnVoltar.setBorder(BorderFactory.createEmptyBorder());
		btnVoltar.setFocusPainted(false);
		btnVoltar.setContentAreaFilled(false);
		contentPane.add(btnVoltar);

		JLabel lblFundo = new JLabel("Fundo");
		lblFundo.setIcon(new ImageIcon("Imagens\\Poster cinema.jpg"));
		lblFundo.setBounds(0, 0, 999, 644);
		contentPane.add(lblFundo);
	}
}
