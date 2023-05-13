package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.AbstractListModel;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import classesBasicasPessoa.Usuario;
import negocio.Fachada;
import negocio.IFachada;

public class TelaMenuUsuario extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2559242801063207805L;
	private JPanel contentPane;

	public TelaMenuUsuario(Usuario u) {
		setIconImage(Toolkit.getDefaultToolkit().getImage("Imagens\\film.png"));
		IFachada f = Fachada.getInstance();
		setTitle("Cinemars");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1025, 682);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnVoltar = new JButton("");
		btnVoltar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0) {
				dispose();
				MenuInicial menuInicial = new MenuInicial();
				menuInicial.setVisible(true);
				menuInicial.setResizable(false);
				menuInicial.setLocationRelativeTo(null);
			}
		});
		btnVoltar.setIcon(new ImageIcon("Imagens//VoltarIcon.png"));
		btnVoltar.setBounds(0, 570, 69, 74);
		btnVoltar.setBorder(BorderFactory.createEmptyBorder());
		btnVoltar.setFocusPainted(false);
		btnVoltar.setContentAreaFilled(false);
		contentPane.add(btnVoltar);

		JList listFilme = new JList();
		listFilme.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		JButton btnReservarCadeiras = new JButton("Reservar Cadeiras");

		btnReservarCadeiras.setFont(new Font("OCR A Extended", Font.PLAIN, 13));
		btnReservarCadeiras.setIcon(new ImageIcon("Imagens//film.png"));
		btnReservarCadeiras.setBounds(404, 546, 200, 34);
		contentPane.add(btnReservarCadeiras);

		JLabel lblSesses = new JLabel("Sess\u00F5es");
		lblSesses.setHorizontalAlignment(SwingConstants.CENTER);
		lblSesses.setForeground(Color.BLACK);
		lblSesses.setFont(new Font("OCR A Extended", Font.ITALIC, 18));
		lblSesses.setBounds(394, 157, 220, 45);
		contentPane.add(lblSesses);

		JLabel lblCinemas = new JLabel("Cinemas");
		lblCinemas.setHorizontalAlignment(SwingConstants.CENTER);
		lblCinemas.setForeground(Color.BLACK);
		lblCinemas.setFont(new Font("OCR A Extended", Font.ITALIC, 18));
		lblCinemas.setBounds(87, 157, 220, 45);
		contentPane.add(lblCinemas);

		JLabel lblListaFilmes = new JLabel("Filmes");
		lblListaFilmes.setHorizontalAlignment(SwingConstants.CENTER);
		lblListaFilmes.setIcon(new ImageIcon("Imagens//Movie-Studio-icon.png"));
		lblListaFilmes.setForeground(Color.BLACK);
		lblListaFilmes.setFont(new Font("OCR A Extended", Font.ITALIC, 18));
		lblListaFilmes.setBounds(701, 157, 220, 45);
		contentPane.add(lblListaFilmes);
		listFilme.setBounds(687, 213, 280, 279);
		contentPane.add(listFilme);

		JList listSessao = new JList();
		listSessao.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listSessao.setBounds(364, 289, 280, 282);
		JScrollPane scroll = new JScrollPane();
		scroll.setViewportView(listSessao);
		scroll.setBounds(371, 213, 280, 282);
		contentPane.add(scroll);

		JList listCinema = new JList();
		listCinema.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listCinema.setFont(new Font("Tahoma", Font.PLAIN, 11));
		listCinema.setForeground(Color.BLACK);
		listCinema.setBackground(Color.WHITE);
		listCinema.setModel(new AbstractListModel() {

			String[] cinemas = f.retornaTudo();

			public Object getElementAt(int index) {
				return cinemas[index];
			}

			public int getSize() {
				return cinemas.length;
			}

		});

		listCinema.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				if (e.getClickCount() == 2) {

					String nomeDoCinema = (String) listCinema.getModel().getElementAt(listCinema.getSelectedIndex());
					listSessao.setModel(new AbstractListModel() {

						String[] sessoes = f.procurarCinema(nomeDoCinema).getNomeSessoes();

						public Object getElementAt(int index) {
							return sessoes[index];
						}

						public int getSize() {
							return sessoes.length;
						}

					});

					listFilme.setModel(new AbstractListModel() {

						String[] filmes = f.procurarCinema(nomeDoCinema).getNomeFilmes();

						public Object getElementAt(int index) {
							return filmes[index];
						}

						public int getSize() {
							return filmes.length;
						}

					});

				}
			}
		});

		listFilme.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseReleased(MouseEvent e) {
				if (e.getClickCount() == 2) {

					TelaFilme telaF = new TelaFilme(f.procurarFilmeNome(
							(String) listFilme.getModel().getElementAt(listFilme.getSelectedIndex())), u);
					dispose();
					telaF.setVisible(true);
					telaF.setLocationRelativeTo(null);
					telaF.setResizable(false);
				}
			}
		});
		listCinema.setBounds(43, 213, 280, 282);
		contentPane.add(listCinema);

		btnReservarCadeiras.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0) {
				int idade = (Integer) u.getIdade();
				if (idade >= f
						.procurarCinema((String) listCinema.getModel().getElementAt(listCinema.getSelectedIndex()))
						.getSessoes().get(listSessao.getSelectedIndex()).getFilme().getClassificacaoIndicativa()) {
					dispose();
					int numSala = f
							.procurarCinema((String) listCinema.getModel().getElementAt(listCinema.getSelectedIndex()))
							.getSessoes().get(listSessao.getSelectedIndex()).getnSala();
					TelaSala sala = new TelaSala(
							f.procurarCinema((String) listCinema.getModel().getElementAt(listCinema.getSelectedIndex()))
									.getSalas().get(numSala),
							f.procurarCinema(
									(String) listCinema.getModel().getElementAt(listCinema.getSelectedIndex())),
							u,
							f.procurarCinema((String) listCinema.getModel().getElementAt(listCinema.getSelectedIndex()))
									.getSessoes().get(listSessao.getSelectedIndex()));

					sala.setVisible(true);
					sala.setLocationRelativeTo(null);
					sala.setResizable(false);
				} else {
					JOptionPane.showMessageDialog(null, "Esse filme não é indicado para alguém da sua idade!");
				}
			}
		});

		JLabel lblMenuAdmin = new JLabel("");
		lblMenuAdmin.setIcon(new ImageIcon("Imagens//TelaCAdmin.jpg"));
		lblMenuAdmin.setBounds(0, 0, 1020, 655);
		contentPane.add(lblMenuAdmin);
	}
}