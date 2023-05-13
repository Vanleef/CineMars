package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.AbstractListModel;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import classesBasicasPessoa.Administrador;
import negocio.Fachada;
import negocio.IFachada;
import java.awt.Toolkit;

public class TelaMenuAdmin extends JFrame {

	/**
	 * 
	 */
	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public TelaMenuAdmin(Administrador adm) {
		setIconImage(Toolkit.getDefaultToolkit().getImage("Imagens\\film.png"));
		IFachada f = Fachada.getInstance();
		setTitle("CineMars");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1025, 682);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		if (adm.getCinema() != null) {
			JLabel lblAdcionarSessao = new JLabel("Adicionar Sess\u00E3o");
			lblAdcionarSessao.setForeground(Color.LIGHT_GRAY);
			lblAdcionarSessao.setFont(new Font("OCR A Extended", Font.ITALIC, 15));
			lblAdcionarSessao.setBounds(639, 291, 156, 65);
			contentPane.add(lblAdcionarSessao);
			JButton btnAdicionarSessao = new JButton("");
			btnAdicionarSessao.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseReleased(MouseEvent arg0) {
					dispose();
					TelaAdminCSessao telaSessao = new TelaAdminCSessao(adm);
					telaSessao.setResizable(false);
					telaSessao.setLocationRelativeTo(null);
					telaSessao.setVisible(true);

				}
			});
			btnAdicionarSessao.setIcon(new ImageIcon("Imagens//addCinema.png"));
			btnAdicionarSessao.setBounds(648, 170, 131, 140);
			btnAdicionarSessao.setBorder(BorderFactory.createEmptyBorder());
			btnAdicionarSessao.setFocusPainted(false);
			btnAdicionarSessao.setContentAreaFilled(false);
			contentPane.add(btnAdicionarSessao);
		}

		if (adm.getCinema() == null) {
			JLabel lblCadastrarCinema = new JLabel("Cadastrar Cinema");
			lblCadastrarCinema.setFont(new Font("OCR A Extended", Font.PLAIN, 12));
			lblCadastrarCinema.setBounds(648, 493, 130, 14);
			contentPane.add(lblCadastrarCinema);

			JButton cadastrarCineButton = new JButton("");
			cadastrarCineButton.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseReleased(MouseEvent e) {
					dispose();
					TelaAdminCCinema tela = new TelaAdminCCinema(adm);
					tela.setVisible(true);
					tela.setLocationRelativeTo(null);
					tela.setResizable(false);
				}
			});
			cadastrarCineButton.setIcon(new ImageIcon("Imagens//UpdateFinalIcon.png"));
			cadastrarCineButton.setBounds(648, 384, 131, 116);
			cadastrarCineButton.setBorder(BorderFactory.createEmptyBorder());
			cadastrarCineButton.setContentAreaFilled(false);
			cadastrarCineButton.setFocusPainted(false);
			contentPane.add(cadastrarCineButton);
		}
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

		if (adm.getCinema() == null) {
			JScrollPane pane = new JScrollPane();
			JList list = new JList();
			pane.setViewportView(list);
			list.setModel(new AbstractListModel() {
				String[] values = new String[] {};

				public int getSize() {
					return values.length;
				}

				public Object getElementAt(int index) {
					return values[index];
				}
			});

			pane.setBounds(96, 291, 280, 279);
			contentPane.add(pane);
		} else {
			JScrollPane pane = new JScrollPane();
			JList list = new JList();
			pane.setViewportView(list);
			list.setModel(new AbstractListModel() {
				String[] values = adm.getCinema().getNomeSessoes();

				public int getSize() {
					return values.length;
				}

				public Object getElementAt(int index) {
					return values[index];
				}
			});
			pane.setBounds(96, 291, 280, 279);
			contentPane.add(pane);
		}

		JLabel lblListadeCinemasSeus = new JLabel("Suas Sess\u00F5es");
		lblListadeCinemasSeus.setIcon(new ImageIcon("Imagens//Movie-Studio-icon.png"));
		lblListadeCinemasSeus.setForeground(new Color(255, 255, 0));
		lblListadeCinemasSeus.setFont(new Font("OCR A Extended", Font.ITALIC, 18));
		lblListadeCinemasSeus.setBounds(135, 244, 220, 45);
		contentPane.add(lblListadeCinemasSeus);

		JLabel lblBemvindo = new JLabel("");
		lblBemvindo.setForeground(SystemColor.textHighlight);
		lblBemvindo.setFont(new Font("Twentieth Century Medium", Font.BOLD, 26));
		lblBemvindo.setBounds(269, 50, 438, 45);
		contentPane.add(lblBemvindo);

		JLabel lblMenuAdmin = new JLabel("");
		lblMenuAdmin.setIcon(new ImageIcon("Imagens//TelaCAdmin.jpg"));
		lblMenuAdmin.setBounds(0, 0, 1020, 655);
		contentPane.add(lblMenuAdmin);
	}
}