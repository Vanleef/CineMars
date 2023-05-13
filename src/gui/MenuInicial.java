package gui;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.border.EmptyBorder;

import classesBasicasCinema.Filme;
import negocio.Fachada;
import negocio.IFachada;
import java.awt.Toolkit;

public class MenuInicial extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {

			public void run() {

				try {

					for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
						if ("Nimbus".equals(info.getName())) {
							UIManager.setLookAndFeel(info.getClassName());
							break;
						}
					}

					MenuInicial frame = new MenuInicial();
					frame.setLocationRelativeTo(null);
					frame.setResizable(false);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MenuInicial() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("Imagens\\film.png"));
		IFachada fachada = Fachada.getInstance();
		Filme fauno = new Filme("O Labirinto do Fauno", "Fantasia/Drama",
				"Espanha, 1944. Oficialmente a Guerra Civil j� terminou, mas um grupo de rebeldes ainda luta nas montanhas ao norte de Navarra. Ofelia (Ivana Baquero), de 10 anos, muda-se para a regi�o com sua m�e, Carmen (Ariadna Gil). L� as espera seu novo padrasto, um oficial fascista que luta para exterminar os guerrilheiros da localidade. Solit�ria, a menina logo descobre a amizade de Mercedes (Maribel Verd�), jovem cozinheira da casa, que serve de contato secreto dos rebeldes. Al�m disso, em seus passeios pelo jardim da imensa mans�o em que moram, Ofelia descobre um labirinto que faz com que todo um mundo de fantasias se abra, trazendo consequ�ncias para todos � sua volta.",
				"Guilhermo del Toro", " Ivana Baquero, Sergi L�pez, Doug Jones...", 118, 16,
				new File("Imagens\\O Labirinto do Fauno.jpg"));
		Filme cadaver = new Filme("A Noiva Cadaver", "Anima��o/Fantasia",
				"Em um vilarejo europeu do s�culo XIX vive Victor Van Dorst (Johnny Depp), um jovem que est� prestes a se casar com Victoria Everglot (Emily Watson). Por�m acidentalmente Victor se casa com a Noiva-Cad�ver (Helena Bonham Carter), que o leva para conhecer a Terra dos Mortos. Desejando desfazer o ocorrido para poder enfim se casar com Victoria, aos poucos Victor percebe que a Terra dos Mortos � bem mais animada do que o meio vitoriano em que nasceu e cresceu.",
				"Mike Johnson", "Johnny Depp, Helena Bonham Carter, Emily Watson", 115, 0,
				new File("Imagens\\Noiva Cadaver.jpg"));
		Filme interestelar = new Filme("Interlestelar", "Fic��o Cientifica/Drama",
				"Ap�s ver a Terra consumindo boa parte de suas reservas naturais, um grupo de astronautas recebe a miss�o de verificar poss�veis planetas para receberem a popula��o mundial, possibilitando a continua��o da esp�cie. Cooper (Matthew McConaughey) � chamado para liderar o grupo e aceita a miss�o sabendo que pode nunca mais ver os filhos. Ao lado de Brand (Anne Hathaway), Jenkins (Marlon Sanders) e Doyle (Wes Bentley), ele seguir� em busca de uma nova casa. Com o passar dos anos, sua filha Murph (Mackenzie Foy e Jessica Chastain) investir� numa pr�pria jornada para tamb�m tentar salvar a popula��o do planeta.",
				"Christopher Nolan", "Matthew McConaughey, Anne Hathaway, Michael Caine", 169, 12,
				new File("Imagens\\Interestelar.jpg"));
		Filme spawn = new Filme("Spawn, O Soldado do Inferno", "Fantasia",
				"Al Simmons (Michael Jai White), o mais profissional agente de uma organiza��o americana, � tra�do e morto por Jason Wynn (Martin Sheen), seu maquiav�lico chefe, e Jessica Priest (Mindy Clarke), uma ambiciosa agente. Ap�s cinco anos Al faz um pacto com Malebolgia, um dos dem�nios que comandam o inferno, para voltar � Terra para ver Wanda (Theresa Randle), sua esposa, que agora est� casada com Terry Fitzgerald (D.B. Sweeney), um antigo colega de Al. Em troca Al ir� liderar como Spawn os ex�rcitos encarregados da destrui��o da ra�a humana. Na Terra Al � ajudado pelo Palha�o (John Leguizamo), um ser demon�aco que tem a miss�o de auxiliar Al em sua nova realidade e estimul�-lo a destruir Wynn e comandar os ex�rcitos do inferno. Entretanto, paralelamente Palha�o fez tamb�m um acordo com Wynn, que sonha comandar a Terra e tem em seu poder o Heat-16, o mais mortal v�rus j� criado, que se utilizado dar� in�cio ao apocalipse, permitindo ent�o que o Inferno ataque o Para�so. Assim Spawn tem de decidir logo entre o Bem e o Mal em sua nova jornada na Terra.",
				"Mark A.Z. Dippe", "Michael Jai White, Martin Sheen, John Leguizamo", 115, 18,
				new File("Imagens\\Spawn.jpg"));
		fachada.cadastrarFilme(fauno);
		fachada.cadastrarFilme(cadaver);
		fachada.cadastrarFilme(interestelar);
		fachada.cadastrarFilme(spawn);
		fachada.salvarCinema();
		fachada.salvarFilme();
		fachada.salvarUsuario();
		fachada.salvarAdmin();
		fachada.salvarIngresso();
		setTitle("Cinemars");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1025, 682);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnMenutelainicial = new JMenu("Menu");
		menuBar.add(mnMenutelainicial);

		JMenuItem mntmCriarUsuario = new JMenuItem("Criar Usuario");
		mnMenutelainicial.add(mntmCriarUsuario);

		JMenuItem mntmCriarAdministrador = new JMenuItem("Criar Administrador");
		mnMenutelainicial.add(mntmCriarAdministrador);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton adminRegistrarButton = new JButton("");
		adminRegistrarButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				dispose();
				TelaCAdmin telaCAdmin = new TelaCAdmin();
				telaCAdmin.setResizable(false);
				telaCAdmin.setLocationRelativeTo(null);
				telaCAdmin.setVisible(true);
			}
		});

		adminRegistrarButton.setIcon(new ImageIcon("Imagens\\AdminButton.png"));
		adminRegistrarButton.setFont(new Font("Lucida Console", adminRegistrarButton.getFont().getStyle(), 22));
		adminRegistrarButton.setBorder(BorderFactory.createEmptyBorder());
		adminRegistrarButton.setFocusPainted(false);
		adminRegistrarButton.setContentAreaFilled(false);
		adminRegistrarButton.setBounds(281, 177, 144, 145);
		contentPane.add(adminRegistrarButton);

		JButton usuarioRegistrarButton = new JButton("");
		usuarioRegistrarButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0) {
				dispose();
				TelaCUsuario telaCUsuario = new TelaCUsuario();
				telaCUsuario.setVisible(true);
				telaCUsuario.setResizable(false);
				telaCUsuario.setLocationRelativeTo(null);
			}
		});

		usuarioRegistrarButton.setIcon(new ImageIcon("Imagens\\Novo Usuario Button.png"));
		usuarioRegistrarButton.setBounds(660, 162, 155, 160);
		usuarioRegistrarButton.setBorder(BorderFactory.createEmptyBorder());
		usuarioRegistrarButton.setFocusPainted(false);
		usuarioRegistrarButton.setContentAreaFilled(false);
		contentPane.add(usuarioRegistrarButton);
		usuarioRegistrarButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});

		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.setIcon(new ImageIcon("Imagens\\film.png"));
		btnEntrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0) {
				dispose();
				TelaLogin telaLogin = new TelaLogin();
				telaLogin.setResizable(false);
				telaLogin.setLocationRelativeTo(null);
				telaLogin.setVisible(true);
			}
		});
		btnEntrar.setBounds(494, 399, 102, 31);
		contentPane.add(btnEntrar);

		JLabel usuarioImage = new JLabel("Usuario");
		usuarioImage.setIcon(new ImageIcon("Imagens\\UserLogin1.png"));
		usuarioImage.setBounds(505, 291, 118, 123);
		contentPane.add(usuarioImage);

		JLabel lblFundo = new JLabel("New label");
		lblFundo.setIcon(new ImageIcon("Imagens\\TelaInicial.png"));
		lblFundo.setBounds(0, 0, 1025, 682);
		contentPane.add(lblFundo);
	}
}
