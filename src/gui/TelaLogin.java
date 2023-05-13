package gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
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
import classesBasicasPessoa.Pessoa;
import classesBasicasPessoa.Usuario;
import negocio.Fachada;
import negocio.IFachada;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class TelaLogin extends JFrame {

	private JPanel contentPane;
	private JTextField textLogin;
	private JPasswordField passwordField;

	/**
	 * Create the frame.
	 */
	public TelaLogin() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("Imagens\\film.png"));
		IFachada f = Fachada.getInstance();
		setTitle("Cinemars");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 680, 420);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		textLogin = new JTextField();
		textLogin.setBounds(436, 119, 218, 28);
		contentPane.add(textLogin);
		textLogin.setColumns(10);

		JLabel lbLogin = new JLabel("Login");
		lbLogin.setFont(new Font("Tahoma", Font.BOLD, 14));
		lbLogin.setForeground(Color.WHITE);
		lbLogin.setBounds(394, 119, 38, 24);
		contentPane.add(lbLogin);

		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setForeground(Color.WHITE);
		lblSenha.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblSenha.setBounds(390, 192, 46, 16);
		contentPane.add(lblSenha);

		JButton btnLogar = new JButton("Logar");
		btnLogar.setIcon(new ImageIcon("Imagens\\LoginIcon.png"));
		btnLogar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				Pessoa p = (Pessoa) f.checkType(textLogin.getText());
				String senha = null;
				for (int i = 0; i < passwordField.getPassword().length; i++) {
					if (i > 0) {
						senha += Character.toString(passwordField.getPassword()[i]);
					} else {
						senha = Character.toString(passwordField.getPassword()[i]);
					}

				}
				if (p instanceof Administrador) {
					if (f.loginAdmin(textLogin.getText(), senha)) {
						dispose();
						TelaMenuAdmin telaMenuAdmin = new TelaMenuAdmin((Administrador) p);
						telaMenuAdmin.setResizable(false);
						telaMenuAdmin.setLocationRelativeTo(null);
						telaMenuAdmin.setVisible(true);
					}
				} else if (p instanceof Usuario) {
					if (f.loginUsuario(textLogin.getText(), senha)) {
						dispose();
						TelaMenuUsuario telaMenuU = new TelaMenuUsuario((Usuario) p);
						telaMenuU.setVisible(true);
						telaMenuU.setLocationRelativeTo(null);
						telaMenuU.setResizable(false);
					}
				} else {
					JOptionPane.showMessageDialog(null, "LOGIN INVÁLIDO!");
				}
			}
		});
		btnLogar.setBounds(494, 228, 101, 37);
		contentPane.add(btnLogar);

		passwordField = new JPasswordField();
		passwordField.setBounds(436, 188, 218, 28);
		contentPane.add(passwordField);

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
		btnVoltar.setBounds(0, 307, 69, 74);
		contentPane.add(btnVoltar);

		JLabel label = new JLabel(" ");
		label.setIcon(new ImageIcon("Imagens//PipocaLogin.png"));
		label.setBounds(0, 0, 674, 393);
		contentPane.add(label);
	}
}
