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
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.border.EmptyBorder;

import classesBasicasPessoa.Administrador;
import negocio.Fachada;
import negocio.IFachada;
import java.awt.Toolkit;

public class TelaCAdmin extends JFrame {

	private JPanel contentPane;
	private static final long serialVersionUID = 5172160195587822169L;
	private JTextField textNome;
	private JTextField textEmail;
	private JTextField textLogin;
	private JLabel senhaCUsuario;
	private JPasswordField passwordField;
	private String senha;

	/**
	 * Create the frame.
	 */
	public TelaCAdmin() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("Imagens\\film.png"));
		setResizable(false);
		IFachada f = Fachada.getInstance();
		setTitle("Cinemars");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1025, 682);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel nomeCUsuario = new JLabel("Nome");
		nomeCUsuario.setFont(nomeCUsuario.getFont().deriveFont(nomeCUsuario.getFont().getStyle() | Font.BOLD));
		nomeCUsuario.setBounds(565, 201, 33, 16);
		contentPane.add(nomeCUsuario);

		JLabel emailCUsuario = new JLabel("Email");
		emailCUsuario.setFont(emailCUsuario.getFont().deriveFont(emailCUsuario.getFont().getStyle() | Font.BOLD));
		emailCUsuario.setBounds(565, 241, 33, 16);
		contentPane.add(emailCUsuario);

		JLabel loginCUsuario = new JLabel("Login");
		loginCUsuario.setFont(loginCUsuario.getFont().deriveFont(loginCUsuario.getFont().getStyle() | Font.BOLD));
		loginCUsuario.setBounds(566, 281, 33, 16);
		contentPane.add(loginCUsuario);

		senhaCUsuario = new JLabel("Senha");
		senhaCUsuario.setFont(senhaCUsuario.getFont().deriveFont(senhaCUsuario.getFont().getStyle() | Font.BOLD));
		senhaCUsuario.setBounds(562, 321, 36, 16);
		contentPane.add(senhaCUsuario);

		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setIcon(new ImageIcon("Imagens\\Sign.png"));
		btnCadastrar.setBounds(745, 399, 116, 28);
		contentPane.add(btnCadastrar);

		passwordField = new JPasswordField();
		passwordField.setBounds(602, 315, 380, 28);
		contentPane.add(passwordField);

		textEmail = new JTextField();
		textEmail.setColumns(10);
		textEmail.setBounds(602, 235, 380, 28);
		contentPane.add(textEmail);

		textNome = new JTextField();
		textNome.setBounds(602, 195, 380, 28);
		contentPane.add(textNome);
		textNome.setColumns(10);

		textLogin = new JTextField();
		textLogin.setColumns(10);
		textLogin.setBounds(603, 275, 380, 28);
		contentPane.add(textLogin);

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
								Administrador adm = new Administrador(textNome.getText(), textEmail.getText(),
										textLogin.getText(), senha, null);
								if (f.cadastrarAdmin(adm)) {
									dispose();
									MenuInicial menu = new MenuInicial();
									menu.setVisible(true);
									menu.setLocationRelativeTo(null);
									menu.setResizable(false);
								} else {
									JOptionPane.showMessageDialog(null,
											"Ocorreu um erro no teu cadastro, por favor, verifique o que esta errado e tente novamente.");
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
		btnVoltar.setBounds(0, 580, 69, 74);
		contentPane.add(btnVoltar);

		JLabel lblLabelUsuario = new JLabel("New label");
		lblLabelUsuario.setIcon(new ImageIcon("Imagens\\TelaCUsuario1.jpg"));
		lblLabelUsuario.setBounds(0, 0, 1019, 654);
		contentPane.add(lblLabelUsuario);
	}

}
