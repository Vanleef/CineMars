package gui;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.border.EmptyBorder;

import classesBasicasPessoa.Usuario;
import negocio.Fachada;
import negocio.IFachada;
import java.awt.Toolkit;

public class TelaCUsuario extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5172160195587822169L;
	private JPanel contentPane;
	private JTextField textNome;
	private JTextField textEmail;
	private JTextField textLogin;
	private JLabel senhaCUsuario;
	private JLabel idadeCUsuario;
	private JPasswordField passwordField;
	private String senha;

	/**
	 * Create the frame.
	 */
	public TelaCUsuario() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("Imagens\\film.png"));
		IFachada f = Fachada.getInstance();
		setTitle("Cinemars");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1015, 682);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel nomeCUsuario = new JLabel("Nome");
		nomeCUsuario.setFont(nomeCUsuario.getFont().deriveFont(nomeCUsuario.getFont().getStyle() | Font.BOLD));
		nomeCUsuario.setBounds(566, 155, 33, 16);
		contentPane.add(nomeCUsuario);

		JLabel emailCUsuario = new JLabel("Email");
		emailCUsuario.setFont(emailCUsuario.getFont().deriveFont(emailCUsuario.getFont().getStyle() | Font.BOLD));
		emailCUsuario.setBounds(566, 195, 33, 16);
		contentPane.add(emailCUsuario);

		JLabel loginCUsuario = new JLabel("Login");
		loginCUsuario.setFont(loginCUsuario.getFont().deriveFont(loginCUsuario.getFont().getStyle() | Font.BOLD));
		loginCUsuario.setBounds(567, 235, 33, 16);
		contentPane.add(loginCUsuario);

		senhaCUsuario = new JLabel("Senha");
		senhaCUsuario.setFont(senhaCUsuario.getFont().deriveFont(senhaCUsuario.getFont().getStyle() | Font.BOLD));
		senhaCUsuario.setBounds(563, 275, 36, 16);
		contentPane.add(senhaCUsuario);

		idadeCUsuario = new JLabel("Idade");
		idadeCUsuario.setFont(idadeCUsuario.getFont().deriveFont(idadeCUsuario.getFont().getStyle() | Font.BOLD));
		idadeCUsuario.setBounds(563, 314, 36, 16);
		contentPane.add(idadeCUsuario);

		JSpinner spinIdade = new JSpinner();
		spinIdade.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), new Integer(100), new Integer(1)));
		spinIdade.setBounds(603, 308, 54, 28);
		contentPane.add(spinIdade);

		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setIcon(new ImageIcon("Imagens\\Sign.png"));
		btnCadastrar.setBounds(727, 406, 109, 28);
		contentPane.add(btnCadastrar);

		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				if (textNome.getText().length() > 0) {
					if (textEmail.getText().length() > 0) {
						if (textLogin.getText().length() > 0) {
							if (passwordField.getPassword().length > 0) {
								char[] codigo = passwordField.getPassword();
								for (int i = 0; i < codigo.length; i++) {
									if (i > 0) {
										senha += Character.toString(codigo[i]);
									} else {
										senha = Character.toString(codigo[i]);
									}
								}
								if (senha != null) {

									Usuario u = new Usuario(textNome.getText(), textEmail.getText(),
											textLogin.getText(), senha, spinIdade.getValue());
									if (f.cadastrarUsuario(u)) {
										f.printarUsuario(u);
										dispose();
										MenuInicial menu = new MenuInicial();
										menu.setVisible(true);
										menu.setLocationRelativeTo(null);
										menu.setResizable(false);
									} else {
										JOptionPane.showMessageDialog(null,
												"Ocorreu um erro no teu cadastro, por favor, verifique o que esta errado e tente novamente.");
									}
								}

							} else {
								JOptionPane.showMessageDialog(null, "ERRO, SENHA INVALIDA");
							}
						} else {
							JOptionPane.showMessageDialog(null, "ERRO, LOGIN INVALIDO");
						}
					} else {
						JOptionPane.showMessageDialog(null, "ERRO, EMAIL INVALIDO");
					}
				} else {
					JOptionPane.showMessageDialog(null, "ERRO, NOME INVALIDO");
				}

			}
		});

		passwordField = new JPasswordField();
		passwordField.setBounds(603, 269, 380, 28);
		contentPane.add(passwordField);

		textEmail = new JTextField();
		textEmail.setColumns(10);
		textEmail.setBounds(603, 189, 380, 28);
		contentPane.add(textEmail);

		textNome = new JTextField();
		textNome.setBounds(603, 149, 380, 28);
		contentPane.add(textNome);
		textNome.setColumns(10);

		textLogin = new JTextField();
		textLogin.setColumns(10);
		textLogin.setBounds(604, 229, 380, 28);
		contentPane.add(textLogin);

		JButton btnVoltar = new JButton("Voltar");
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
		btnVoltar.setFocusPainted(false);
		btnVoltar.setContentAreaFilled(false);
		btnVoltar.setBorder(BorderFactory.createEmptyBorder());
		btnVoltar.setBounds(0, 570, 69, 74);
		contentPane.add(btnVoltar);

		JLabel lblLabelUsuario = new JLabel("New label");
		lblLabelUsuario.setIcon(new ImageIcon("Imagens\\TelaCUsuario1.jpg"));
		lblLabelUsuario.setBounds(0, -10, 1009, 664);
		contentPane.add(lblLabelUsuario);
	}
}
