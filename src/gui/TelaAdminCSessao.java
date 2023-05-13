package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.LocalTime;

import javax.swing.AbstractListModel;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import classesBasicasCinema.Sessao;
import classesBasicasPessoa.Administrador;
import negocio.Fachada;
import negocio.IFachada;
import javax.swing.JTextField;
import java.awt.Toolkit;

public class TelaAdminCSessao extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3497933519474041758L;
	private JPanel contentPane;
	private JFormattedTextField vHora;
	private JFormattedTextField vData;
	private JTextField textSala;

	public TelaAdminCSessao(Administrador adm) {
		setTitle("Cinemars");
		setIconImage(Toolkit.getDefaultToolkit().getImage("Imagens\\film.png"));
		IFachada fachada = Fachada.getInstance();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1025, 682);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblSala = new JLabel("Sala:");
		lblSala.setForeground(Color.YELLOW);
		lblSala.setFont(new Font("OCR A Extended", Font.BOLD, 18));
		lblSala.setBounds(602, 53, 60, 31);
		contentPane.add(lblSala);

		textSala = new JTextField();
		textSala.setBounds(672, 55, 55, 30);
		contentPane.add(textSala);
		textSala.setColumns(10);

		JList listFilmes = new JList();
		listFilmes.setForeground(Color.BLACK);
		listFilmes.setBackground(Color.WHITE);
		listFilmes.setBounds(368, 162, 313, 297);
		contentPane.add(listFilmes);

		listFilmes.setModel(new AbstractListModel() {

			String[] filmes = fachada.retornaFilmes();

			public Object getElementAt(int index) {
				return filmes[index];
			}

			public int getSize() {
				return filmes.length;
			}

		});

		JLabel labelFilmes = new JLabel("Filmes Dispon\u00EDveis");
		labelFilmes.setBackground(Color.WHITE);
		labelFilmes.setForeground(Color.YELLOW);
		labelFilmes.setFont(new Font("OCR A Extended", Font.BOLD, 18));
		labelFilmes.setBounds(425, 122, 216, 31);
		contentPane.add(labelFilmes);

		JLabel labelData = new JLabel("Data:");
		labelData.setForeground(Color.YELLOW);
		labelData.setFont(new Font("OCR A Extended", Font.BOLD, 18));
		labelData.setBounds(730, 188, 60, 31);
		contentPane.add(labelData);

		vData = new JFormattedTextField();
		try {
			vData = new JFormattedTextField(new MaskFormatter("##/##/####"));
			vData.setFont(new Font("SansSerif", Font.BOLD, 12));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		vData.setValue(null);
		vData.setColumns(6);
		vData.setBounds(790, 188, 123, 30);
		contentPane.add(vData);

		JLabel lblHora = new JLabel("Hora:");
		lblHora.setForeground(Color.YELLOW);
		lblHora.setFont(new Font("OCR A Extended", Font.BOLD, 18));
		lblHora.setBounds(730, 352, 60, 31);
		contentPane.add(lblHora);

		vHora = new JFormattedTextField();
		try {
			vHora = new JFormattedTextField(new MaskFormatter("##:##"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		vHora.setFont(new Font("SansSerif", Font.BOLD, 12));
		vHora.setValue(null);
		vHora.setColumns(4);
		vHora.setBounds(790, 352, 123, 30);
		contentPane.add(vHora);

		JButton btnConfirmar = new JButton("Adicionar Sess\u00E3o");
		btnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int ano, mes, dia;
				ano = Integer.parseInt(vData.getText().substring(6, 10));
				mes = Integer.parseInt(vData.getText().substring(3, 5));
				dia = Integer.parseInt(vData.getText().substring(0, 2));
				int hora, minuto;
				hora = Integer.parseInt(vHora.getText().substring(0, 2));
				minuto = Integer.parseInt(vHora.getText().substring(3, 5));
				int aux = 0;
				if (Integer.parseInt(textSala.getText()) > 0
						&& Integer.parseInt(textSala.getText()) <= adm.getCinema().getSalas().size()) {
					aux = Integer.parseInt(textSala.getText());
				}

				if (aux > 0 && aux < 11) {
					if (LocalDate.of(ano, mes, dia).isAfter(LocalDate.now())) {
						adm.getCinema()
								.addSessao(new Sessao(aux,
										fachada.procurarFilmeNome((String) listFilmes.getModel()
												.getElementAt(listFilmes.getSelectedIndex())),
								LocalDate.of(ano, mes, dia), LocalTime.of(hora, minuto)));
						System.out.println(adm.getCinema().getSessoes());
						dispose();
						TelaMenuAdmin tela = new TelaMenuAdmin(adm);
						tela.setVisible(true);
						tela.setLocationRelativeTo(null);
						tela.setResizable(false);
					} else {
						JOptionPane.showMessageDialog(null, "Data/Horario Invalidos");
					}
				} else {
					System.out.println("NUmero da Sala Invalido");
				}
			}
		});
		btnConfirmar.setIcon(new ImageIcon("Imagens//ConfirmarIconAdmin.png"));
		btnConfirmar.setBounds(546, 523, 181, 28);
		contentPane.add(btnConfirmar);

		JButton btnVoltar = new JButton("");
		btnVoltar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0) {
				dispose();
				TelaMenuAdmin menuInicial = new TelaMenuAdmin(adm);
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

		JLabel lblFundoCSessao = new JLabel("");
		lblFundoCSessao.setBounds(0, 0, 1009, 644);
		lblFundoCSessao.setIcon(new ImageIcon("Imagens//cinemaCSessao1.png"));
		contentPane.add(lblFundoCSessao);

	}
}
