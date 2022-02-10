// Maria Eduarda de Sousa, Maria Eduarda Krutzsch, Victor do Amaral
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JSeparator;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.awt.event.ActionEvent;
import javax.swing.JFormattedTextField;

public class Apresentacao {

	private JFrame frame;
	private JTextField tfNomeUsuarioRes;
	private JTextField tfEndInstalacaoRes;
	private JTextField tfDataInstalacaoRes;
	private JTextField tfTelefoneRes;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField tfNomeUsuarioCom;
	private JTextField tfEndInstalacaoCom;
	private JTextField tfDataInstalacaoCom;
	private JTextField tfTelefoneCom;
	private JTextField tfRamoAtividadeCom;
	private JTextField tfNomeUsuarioEsp;
	private JTextField tfEnderecoInstalacaoEsp;
	private JTextField tfDataInstalacaoEsp;
	private JTextField tfTelefoneEsp;
	private JTextField tfQtdeOcorrenciasEsp;
	private HashMap<String, TelefoneResidencial> telefonesResidenciais = new HashMap<>();
	private HashMap<String, TelefoneComercial> telefonesComerciais = new HashMap<>();
	private HashMap<String, TelefoneEspecializado> telefonesEspecializados = new HashMap<>();
	private DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	private JTextField tfTelefoneConsulta;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Apresentacao window = new Apresentacao();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Apresentacao() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 529, 340);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		MaskFormatter telefoneMask = null;
		MaskFormatter dataMask = null;

		try {
			telefoneMask = new MaskFormatter("(##) #####-####");
			dataMask = new MaskFormatter("##/##/####");
		} catch (ParseException e) {
			JOptionPane.showMessageDialog(null, "Erro!");
		}

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBackground(new Color(240, 248, 255));
		tabbedPane.setBounds(0, 0, 513, 301);
		frame.getContentPane().add(tabbedPane);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 240));
		tabbedPane.addTab("Telefone Residencial", null, panel_1, null);
		panel_1.setLayout(null);

		JLabel lblNewLabel_3 = new JLabel("Nome de usu\u00E1rio:");
		lblNewLabel_3.setBounds(69, 53, 114, 14);
		panel_1.add(lblNewLabel_3);

		tfNomeUsuarioRes = new JTextField();
		tfNomeUsuarioRes.setBounds(242, 50, 183, 20);
		panel_1.add(tfNomeUsuarioRes);
		tfNomeUsuarioRes.setColumns(10);

		JLabel lblNewLabel_4 = new JLabel("Endere\u00E7o de Instala\u00E7\u00E3o:");
		lblNewLabel_4.setBounds(69, 91, 151, 14);
		panel_1.add(lblNewLabel_4);

		tfEndInstalacaoRes = new JTextField();
		tfEndInstalacaoRes.setBounds(242, 88, 183, 20);
		panel_1.add(tfEndInstalacaoRes);
		tfEndInstalacaoRes.setColumns(10);

		JLabel lblNewLabel_5 = new JLabel("Data de instala\u00E7\u00E3o:");
		lblNewLabel_5.setBounds(69, 128, 114, 14);
		panel_1.add(lblNewLabel_5);

		tfDataInstalacaoRes = new JFormattedTextField(dataMask);
		tfDataInstalacaoRes.setBounds(242, 125, 183, 20);
		panel_1.add(tfDataInstalacaoRes);
		tfDataInstalacaoRes.setColumns(10);

		JLabel lblNewLabel_6 = new JLabel("Telefone:");
		lblNewLabel_6.setBounds(69, 163, 77, 14);
		panel_1.add(lblNewLabel_6);

		tfTelefoneRes = new JFormattedTextField(telefoneMask);
		tfTelefoneRes.setBounds(242, 160, 183, 20);
		panel_1.add(tfTelefoneRes);
		tfTelefoneRes.setColumns(10);

		JLabel lblNewLabel_7 = new JLabel("Possui conex\u00E3o \u00E0 internet?");
		lblNewLabel_7.setBounds(69, 202, 162, 14);
		panel_1.add(lblNewLabel_7);

		JSeparator separator = new JSeparator();
		separator.setBounds(10, 29, 483, 2);
		panel_1.add(separator);

		JLabel lblNewLabel = new JLabel("Cadastro");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblNewLabel.setBounds(25, 4, 97, 20);
		panel_1.add(lblNewLabel);

		JRadioButton rdbtnNewRadioButton = new JRadioButton("Sim");
		buttonGroup.add(rdbtnNewRadioButton);
		rdbtnNewRadioButton.setBackground(new Color(255, 215, 0));
		rdbtnNewRadioButton.setBounds(242, 198, 53, 23);
		panel_1.add(rdbtnNewRadioButton);

		rdbtnNewRadioButton.setActionCommand("True");

		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("N\u00E3o");
		buttonGroup.add(rdbtnNewRadioButton_1);
		rdbtnNewRadioButton_1.setBackground(new Color(255, 215, 0));
		rdbtnNewRadioButton_1.setBounds(311, 198, 53, 23);
		panel_1.add(rdbtnNewRadioButton_1);

		rdbtnNewRadioButton_1.setActionCommand("False");

		JButton btnCadastrarTelResidencial = new JButton("Registrar");
		btnCadastrarTelResidencial.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				TelefoneResidencial telefoneResidencial = new TelefoneResidencial();
				LocalDate data = LocalDate.parse(tfDataInstalacaoRes.getText(), formatador);

				telefoneResidencial.setNomeUsuario(tfNomeUsuarioRes.getText());
				telefoneResidencial.setEnderecoInstalacao(tfEndInstalacaoRes.getText());
				telefoneResidencial.setDataInstalacao(data);
				telefoneResidencial.setNumero(tfTelefoneRes.getText());
				String botao = buttonGroup.getSelection().getActionCommand();
				if (botao == "True") {
					telefoneResidencial.setConexaoInternetTrue();
				} else {
					telefoneResidencial.setConexaoInternetFalse();
				}

				telefonesResidenciais.put(telefoneResidencial.getNumero(), telefoneResidencial);

				tfDataInstalacaoRes.setText("");
				tfNomeUsuarioRes.setText("");
				tfEndInstalacaoRes.setText("");
				tfTelefoneRes.setText("");
				
				JOptionPane.showMessageDialog(null, "Cadastrado com sucesso!");

			}
		});

		btnCadastrarTelResidencial.setBounds(191, 239, 89, 23);
		panel_1.add(btnCadastrarTelResidencial);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(240, 255, 255));
		tabbedPane.addTab("Telefone Comercial", null, panel, null);
		panel.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("Cadastro");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblNewLabel_1.setBounds(25, 4, 97, 20);
		panel.add(lblNewLabel_1);

		JLabel lblNewLabel_3_1 = new JLabel("Nome de usu\u00E1rio:");
		lblNewLabel_3_1.setBounds(92, 49, 114, 14);
		panel.add(lblNewLabel_3_1);

		tfNomeUsuarioCom = new JTextField();
		tfNomeUsuarioCom.setColumns(10);
		tfNomeUsuarioCom.setBounds(265, 46, 183, 20);
		panel.add(tfNomeUsuarioCom);

		JLabel lblNewLabel_4_1 = new JLabel("Endere\u00E7o de Instala\u00E7\u00E3o:");
		lblNewLabel_4_1.setBounds(92, 87, 151, 14);
		panel.add(lblNewLabel_4_1);

		tfEndInstalacaoCom = new JTextField();
		tfEndInstalacaoCom.setColumns(10);
		tfEndInstalacaoCom.setBounds(265, 84, 183, 20);
		panel.add(tfEndInstalacaoCom);

		JLabel lblNewLabel_5_1 = new JLabel("Data de instala\u00E7\u00E3o:");
		lblNewLabel_5_1.setBounds(92, 124, 114, 14);
		panel.add(lblNewLabel_5_1);

		tfDataInstalacaoCom = new JFormattedTextField(dataMask);
		tfDataInstalacaoCom.setColumns(10);
		tfDataInstalacaoCom.setBounds(265, 121, 183, 20);
		panel.add(tfDataInstalacaoCom);

		JLabel lblNewLabel_6_1 = new JLabel("Telefone:");
		lblNewLabel_6_1.setBounds(92, 159, 77, 14);
		panel.add(lblNewLabel_6_1);

		tfTelefoneCom = new JFormattedTextField(telefoneMask);
		tfTelefoneCom.setColumns(10);
		tfTelefoneCom.setBounds(265, 156, 183, 20);
		panel.add(tfTelefoneCom);

		JLabel lblNewLabel_7_1 = new JLabel("Ramo de atividade:");
		lblNewLabel_7_1.setBounds(92, 198, 162, 14);
		panel.add(lblNewLabel_7_1);

		tfRamoAtividadeCom = new JTextField();
		tfRamoAtividadeCom.setColumns(10);
		tfRamoAtividadeCom.setBounds(265, 195, 183, 20);
		panel.add(tfRamoAtividadeCom);

		JButton btnCadastrarComercial = new JButton("Registrar");
		btnCadastrarComercial.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				TelefoneComercial telefoneComercial = new TelefoneComercial();
				LocalDate data = LocalDate.parse(tfDataInstalacaoCom.getText(), formatador);

				telefoneComercial.setNomeUsuario(tfNomeUsuarioCom.getText());
				telefoneComercial.setEnderecoInstalacao(tfEndInstalacaoCom.getText());
				telefoneComercial.setDataInstalacao(data);
				telefoneComercial.setNumero(tfTelefoneCom.getText());
				telefoneComercial.setRamoAtividade(tfRamoAtividadeCom.getText());
				telefoneComercial.setValorAPagar();

				telefonesComerciais.put(telefoneComercial.getNumero(), telefoneComercial);

				tfDataInstalacaoCom.setText("");
				tfNomeUsuarioCom.setText("");
				tfEndInstalacaoCom.setText("");
				tfTelefoneCom.setText("");
				tfRamoAtividadeCom.setText("");

				JOptionPane.showMessageDialog(null, "Cadastrado com sucesso!");
			}
		});
		btnCadastrarComercial.setBounds(214, 235, 89, 23);
		panel.add(btnCadastrarComercial);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 31, 488, 2);
		panel.add(separator_1);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(248, 248, 255));
		tabbedPane.addTab("Telefone Especializado", null, panel_2, null);
		panel_2.setLayout(null);

		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(10, 35, 483, 2);
		panel_2.add(separator_2);

		JLabel lblNewLabel_2 = new JLabel("Cadastro");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblNewLabel_2.setBounds(25, 4, 97, 20);
		panel_2.add(lblNewLabel_2);

		JLabel lblNewLabel_3_2 = new JLabel("Nome de usu\u00E1rio:");
		lblNewLabel_3_2.setBounds(69, 49, 114, 14);
		panel_2.add(lblNewLabel_3_2);

		tfNomeUsuarioEsp = new JTextField();
		tfNomeUsuarioEsp.setColumns(10);
		tfNomeUsuarioEsp.setBounds(242, 46, 183, 20);
		panel_2.add(tfNomeUsuarioEsp);

		JLabel lblNewLabel_4_2 = new JLabel("Endere\u00E7o de Instala\u00E7\u00E3o:");
		lblNewLabel_4_2.setBounds(69, 87, 151, 14);
		panel_2.add(lblNewLabel_4_2);

		tfEnderecoInstalacaoEsp = new JTextField();
		tfEnderecoInstalacaoEsp.setColumns(10);
		tfEnderecoInstalacaoEsp.setBounds(242, 84, 183, 20);
		panel_2.add(tfEnderecoInstalacaoEsp);

		JLabel lblNewLabel_5_2 = new JLabel("Data de instala\u00E7\u00E3o:");
		lblNewLabel_5_2.setBounds(69, 124, 114, 14);
		panel_2.add(lblNewLabel_5_2);

		tfDataInstalacaoEsp = new JFormattedTextField(dataMask);
		tfDataInstalacaoEsp.setColumns(10);
		tfDataInstalacaoEsp.setBounds(242, 121, 183, 20);
		panel_2.add(tfDataInstalacaoEsp);

		JLabel lblNewLabel_6_2 = new JLabel("Telefone:");
		lblNewLabel_6_2.setBounds(69, 159, 77, 14);
		panel_2.add(lblNewLabel_6_2);

		tfTelefoneEsp = new JFormattedTextField(telefoneMask);
		tfTelefoneEsp.setColumns(10);
		tfTelefoneEsp.setBounds(242, 156, 183, 20);
		panel_2.add(tfTelefoneEsp);

		JLabel lblNewLabel_7_2 = new JLabel("Quantidade de ocorr\u00EAncias:");
		lblNewLabel_7_2.setBounds(69, 198, 162, 14);
		panel_2.add(lblNewLabel_7_2);

		tfQtdeOcorrenciasEsp = new JTextField();
		tfQtdeOcorrenciasEsp.setColumns(10);
		tfQtdeOcorrenciasEsp.setBounds(242, 195, 183, 20);
		panel_2.add(tfQtdeOcorrenciasEsp);

		JButton btnCadastrarTelComercial = new JButton("Registrar");
		btnCadastrarTelComercial.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				TelefoneEspecializado telefoneEspecializado = new TelefoneEspecializado();
				LocalDate data = LocalDate.parse(tfDataInstalacaoEsp.getText(), formatador);

				telefoneEspecializado.setNomeUsuario(tfNomeUsuarioEsp.getText());
				telefoneEspecializado.setEnderecoInstalacao(tfEnderecoInstalacaoEsp.getText());
				telefoneEspecializado.setDataInstalacao(data);
				telefoneEspecializado.setNumero(tfTelefoneEsp.getText());
				telefoneEspecializado.setQtdeOcorrencias(Integer.parseInt(tfQtdeOcorrenciasEsp.getText()));
				telefoneEspecializado.setValorAPagar();

				telefonesEspecializados.put(telefoneEspecializado.getNumero(), telefoneEspecializado);

				tfDataInstalacaoEsp.setText("");
				tfNomeUsuarioEsp.setText("");
				tfEnderecoInstalacaoEsp.setText("");
				tfTelefoneEsp.setText("");
				tfQtdeOcorrenciasEsp.setText("");

				JOptionPane.showMessageDialog(null, "Cadastrado com sucesso!");
			}
		});
		btnCadastrarTelComercial.setBounds(191, 235, 89, 23);
		panel_2.add(btnCadastrarTelComercial);

		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(240, 248, 255));
		tabbedPane.addTab("Busca", null, panel_3, null);
		panel_3.setLayout(null);

		JLabel lblNewLabel_8 = new JLabel("N\u00FAmero de telefone \u00E0 consultar:");
		lblNewLabel_8.setBounds(47, 81, 181, 14);
		panel_3.add(lblNewLabel_8);

		JSeparator separator_3 = new JSeparator();
		separator_3.setBounds(10, 34, 488, 2);
		panel_3.add(separator_3);

		JLabel lblNewLabel_9 = new JLabel("Dados para consulta");
		lblNewLabel_9.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblNewLabel_9.setBounds(25, 4, 181, 25);
		panel_3.add(lblNewLabel_9);

		JButton btnConsultarTelefoneDados = new JButton("Consultar");
		btnConsultarTelefoneDados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String mensagem = "";
				for (TelefoneResidencial telefone : telefonesResidenciais.values()) {
					if (telefone.getNumero().equals(tfTelefoneConsulta.getText())) {

						mensagem = "Nome do usuário: " + telefone.getNomeUsuario() + "\nEndereço de instalação: "
								+ telefone.getEnderecoInstalacao() + "\nData de instalação: "
								+ telefone.getDataInstalacao() + "\nNúmero de telefone: " + telefone.getNumero();

						String temConexaoInternet = telefone.isConexaoInternet() ? "Sim" : "Não";

						mensagem += "\nPossui conexão à internet? " + temConexaoInternet;
						mensagem += "\nValor a pagar: " + telefone.getValorAPagar();
					}
				}
				for (TelefoneComercial telefone : telefonesComerciais.values()) {
					if (telefone.getNumero().equals(tfTelefoneConsulta.getText())) {
						mensagem = "Nome do usuário: " + telefone.getNomeUsuario() + "\nEndereço de instalação: "
								+ telefone.getEnderecoInstalacao() + "\nData de instalação: "
								+ telefone.getDataInstalacao() + "\nNúmero de telefone: " + telefone.getNumero()
								+ "\nRamo de atividade: " + telefone.getRamoAtividade() + "\nValor a pagar: "
								+ telefone.getValorAPagar();

					}
				}
				for (TelefoneEspecializado telefone : telefonesEspecializados.values()) {
					if (telefone.getNumero().equals(tfTelefoneConsulta.getText())) {
						mensagem = "Nome do usuário: " + telefone.getNomeUsuario() + "\nEndereço de instalação: "
								+ telefone.getEnderecoInstalacao() + "\nData de instalação: "
								+ telefone.getDataInstalacao() + "\nNúmero de telefone: " + telefone.getNumero()
								+ "\nQuantidade de ocorrências: " + telefone.getQtdeOcorrencias() + "\nValor a pagar: "
								+ telefone.getValorAPagar();
					}
				}
				JOptionPane.showMessageDialog(null, mensagem);
			}
		});
		btnConsultarTelefoneDados.setBounds(374, 77, 89, 23);
		panel_3.add(btnConsultarTelefoneDados);

		JLabel lblNewLabel_10 = new JLabel("Verificar potencial de faturamento");
		lblNewLabel_10.setBounds(47, 142, 181, 14);
		panel_3.add(lblNewLabel_10);

		JButton btnVerificarFaturamento = new JButton("Consultar");
		btnVerificarFaturamento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				double potencialFaturamento = 0;
				for (int contador = 1; contador <= telefonesResidenciais.size(); contador++) {
					potencialFaturamento += 15.00;
				}

				for (TelefoneComercial telefone : telefonesComerciais.values()) {
					potencialFaturamento += telefone.getValorAPagar();
				}
				for (TelefoneEspecializado telefone : telefonesEspecializados.values()) {
					potencialFaturamento += telefone.getValorAPagar();
				}
				JOptionPane.showMessageDialog(null, "Potencial de faturamento: " + potencialFaturamento);
			}
		});
		btnVerificarFaturamento.setBounds(238, 138, 89, 23);
		panel_3.add(btnVerificarFaturamento);

		tfTelefoneConsulta = new JFormattedTextField(telefoneMask);
		tfTelefoneConsulta.setBounds(224, 78, 103, 20);
		panel_3.add(tfTelefoneConsulta);
		tfTelefoneConsulta.setColumns(10);

	}
}