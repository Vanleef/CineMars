package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
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
import javax.swing.JTextPane;
import javax.swing.JToggleButton;
import javax.swing.border.EmptyBorder;

import classesBasicasCinema.Cinema;
import classesBasicasCinema.Ingresso;
import classesBasicasCinema.Sessao;
import classesBasicasPessoa.Usuario;
import negocio.Fachada;
import negocio.IFachada;

public class TelaBilhete extends JFrame {

	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public TelaBilhete(Usuario u, Sessao s, Cinema c) {
		IFachada f = Fachada.getInstance();
		setResizable(false);
		setTitle("Cinemars");
		setIconImage(Toolkit.getDefaultToolkit().getImage("Imagens\\film.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1004, 683);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnComprar = new JButton("Comprar");
		btnComprar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				JPasswordField password = new JPasswordField(10);
				password.setEchoChar('*');
				JLabel rotulo = new JLabel("Entre com a senha:");
				JPanel entUsuario = new JPanel();
				entUsuario.add(rotulo);
				entUsuario.add(password);
				JOptionPane.showMessageDialog(null, entUsuario, "Acesso restrito", JOptionPane.PLAIN_MESSAGE);
				String senha = null;
				for (int i = 0; i < password.getPassword().length; i++) {
					if (i > 0) {
						senha += Character.toString(password.getPassword()[i]);
					} else {
						senha = Character.toString(password.getPassword()[i]);
					}
				}
				f.cadastrarIngresso(new Ingresso(u, s, c, 10));
				JOptionPane.showMessageDialog(null, "Obrigado pela preferencia, volte sempre. Bom filme!");
				dispose();
				TelaMenuUsuario menuInicial = new TelaMenuUsuario(u);
				menuInicial.setVisible(true);
				menuInicial.setResizable(false);
				menuInicial.setLocationRelativeTo(null);
			}
		});
		btnComprar.setBounds(396, 386, 238, 86);
		contentPane.add(btnComprar);

		JButton btnVisa = new JButton("Visa");
		btnVisa.setIcon(new ImageIcon("Imagens\\Visa3.png"));
		btnVisa.setBounds(475, 171, 63, 41);
		contentPane.add(btnVisa);
		btnVisa.setBorder(BorderFactory.createEmptyBorder());
		btnVisa.setContentAreaFilled(false);

		JToggleButton btnMastercard = new JToggleButton("MasterCard");
		btnMastercard.setIcon(new ImageIcon("Imagens\\Mastercard.png"));
		btnMastercard.setBounds(647, 171, 63, 48);
		contentPane.add(btnMastercard);
		btnMastercard.setBorder(BorderFactory.createEmptyBorder());
		btnMastercard.setContentAreaFilled(false);

		JToggleButton btnAmericanExpress = new JToggleButton("");
		btnAmericanExpress.setIcon(new ImageIcon("Imagens\\American-express.png"));
		btnAmericanExpress.setBounds(110, 175, 72, 41);
		contentPane.add(btnAmericanExpress);
		btnAmericanExpress.setBorder(BorderFactory.createEmptyBorder());
		btnAmericanExpress.setContentAreaFilled(false);

		JToggleButton btnHipercard = new JToggleButton("HiperCard");
		btnHipercard.setIcon(new ImageIcon("Imagens\\Hipercard.png"));
		btnHipercard.setBounds(292, 175, 72, 41);
		contentPane.add(btnHipercard);
		btnHipercard.setBorder(BorderFactory.createEmptyBorder());
		btnHipercard.setContentAreaFilled(false);

		JToggleButton btnDinnersClub = new JToggleButton("Diners Club");
		btnDinnersClub.setIcon(new ImageIcon("Imagens\\Diners.png"));
		btnDinnersClub.setBounds(820, 171, 63, 48);
		contentPane.add(btnDinnersClub);
		btnDinnersClub.setBorder(BorderFactory.createEmptyBorder());
		btnDinnersClub.setContentAreaFilled(false);

		JTextPane txtpnSelecioneOCarto = new JTextPane();
		txtpnSelecioneOCarto.setEditable(false);
		txtpnSelecioneOCarto.setFont(new Font("OCR A Extended", Font.BOLD, 14));
		txtpnSelecioneOCarto.setForeground(Color.GRAY);
		txtpnSelecioneOCarto.setText("Selecione o cart\u00E3o que deseja escolher para efetuar o pagamento: ");
		txtpnSelecioneOCarto.setBounds(290, 79, 417, 41);
		contentPane.add(txtpnSelecioneOCarto);

		JButton btnVoltar = new JButton("");
		btnVoltar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0) {
				dispose();
				TelaMenuUsuario menuInicial = new TelaMenuUsuario(u);
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

		JLabel lblFundo = new JLabel("");
		lblFundo.setIcon(new ImageIcon("Imagens\\TelaBilheteria.jpg"));
		lblFundo.setBounds(0, 0, 1013, 655);
		contentPane.add(lblFundo);
	}
}
