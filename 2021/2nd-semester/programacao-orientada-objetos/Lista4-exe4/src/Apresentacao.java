
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.swing.JOptionPane;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class Apresentacao extends javax.swing.JFrame {

	public Apresentacao() {
		initComponents();
	}

	@SuppressWarnings("unchecked")

	private void initComponents() {

		camara = new Camara();
		formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		jLabel7 = new javax.swing.JLabel();
		jTabbedPane1 = new javax.swing.JTabbedPane();
		jPanel1 = new javax.swing.JPanel();
		jLabel1 = new javax.swing.JLabel();
		jLabel2 = new javax.swing.JLabel();
		jtfNumPartido = new javax.swing.JTextField();
		jtfNomePartido = new javax.swing.JTextField();
		jbCadastrarPartido = new javax.swing.JButton();
		jPanel2 = new javax.swing.JPanel();
		jLabel3 = new javax.swing.JLabel();
		jLabel4 = new javax.swing.JLabel();
		jtfNomeVereador = new javax.swing.JTextField();
		jtfNumPartidoVereador = new javax.swing.JTextField();
		jtfNumPartidoVereador.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) {
			}
		});
		jbCadastrarVereador = new javax.swing.JButton();
		jPanel3 = new javax.swing.JPanel();
		jbMenorDesempenho = new javax.swing.JButton();
		jbMenorDesempenho.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		jbMaisProjetos = new javax.swing.JButton();
		jbMaisProjetos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		jLabel9 = new javax.swing.JLabel();
		jTextField7 = new javax.swing.JTextField();
		jbEstatisticas = new javax.swing.JButton();
		jbEstatisticas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

			}
		});
		jSeparator1 = new javax.swing.JSeparator();
		jbTotalProjetos = new javax.swing.JButton();
		jbVereadoresAcimaMedia = new javax.swing.JButton();

		jLabel7.setText("jLabel7");

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setTitle("Lista 3 - Exercício 5");

		jLabel1.setText("Número:");

		jLabel2.setText("Nome:");

		jbCadastrarPartido.setText("Cadastrar");
		jbCadastrarPartido.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton1ActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
		jPanel1Layout.setHorizontalGroup(
			jPanel1Layout.createParallelGroup(Alignment.LEADING)
				.addGroup(jPanel1Layout.createSequentialGroup()
					.addContainerGap()
					.addGroup(jPanel1Layout.createParallelGroup(Alignment.TRAILING)
						.addComponent(jbCadastrarPartido)
						.addGroup(jPanel1Layout.createSequentialGroup()
							.addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING)
								.addGroup(jPanel1Layout.createSequentialGroup()
									.addComponent(jLabel1)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(jtfNumPartido, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE))
								.addGroup(jPanel1Layout.createSequentialGroup()
									.addComponent(jLabel2)
									.addGap(18)
									.addComponent(jtfNomePartido, GroupLayout.PREFERRED_SIZE, 177, GroupLayout.PREFERRED_SIZE)))
							.addPreferredGap(ComponentPlacement.RELATED)))
					.addContainerGap(382, Short.MAX_VALUE))
		);
		jPanel1Layout.setVerticalGroup(
			jPanel1Layout.createParallelGroup(Alignment.LEADING)
				.addGroup(jPanel1Layout.createSequentialGroup()
					.addContainerGap()
					.addGroup(jPanel1Layout.createParallelGroup(Alignment.BASELINE)
						.addComponent(jLabel1)
						.addComponent(jtfNumPartido, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(jPanel1Layout.createParallelGroup(Alignment.BASELINE)
						.addComponent(jLabel2)
						.addComponent(jtfNomePartido, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(28)
					.addComponent(jbCadastrarPartido)
					.addContainerGap(283, Short.MAX_VALUE))
		);
		jPanel1.setLayout(jPanel1Layout);

		jTabbedPane1.addTab("Partido", jPanel1);

		jLabel3.setText("Nome: ");

		jLabel4.setText("Número do partido:");

		jbCadastrarVereador.setText("Cadastrar");
		jbCadastrarVereador.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton2ActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
		jPanel2Layout.setHorizontalGroup(
			jPanel2Layout.createParallelGroup(Alignment.TRAILING)
				.addGroup(jPanel2Layout.createSequentialGroup()
					.addContainerGap()
					.addGroup(jPanel2Layout.createParallelGroup(Alignment.LEADING)
						.addGroup(jPanel2Layout.createSequentialGroup()
							.addComponent(jLabel4)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(jtfNumPartidoVereador, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
						.addGroup(jPanel2Layout.createSequentialGroup()
							.addGroup(jPanel2Layout.createParallelGroup(Alignment.TRAILING)
								.addComponent(jbCadastrarVereador)
								.addGroup(jPanel2Layout.createSequentialGroup()
									.addComponent(jLabel3)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(jtfNomeVereador, GroupLayout.PREFERRED_SIZE, 206, GroupLayout.PREFERRED_SIZE)))
							.addGap(58)))
					.addContainerGap(306, Short.MAX_VALUE))
		);
		jPanel2Layout.setVerticalGroup(
			jPanel2Layout.createParallelGroup(Alignment.LEADING)
				.addGroup(jPanel2Layout.createSequentialGroup()
					.addGap(19)
					.addGroup(jPanel2Layout.createParallelGroup(Alignment.BASELINE)
						.addComponent(jLabel3)
						.addComponent(jtfNomeVereador, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(jPanel2Layout.createParallelGroup(Alignment.LEADING)
						.addComponent(jLabel4)
						.addComponent(jtfNumPartidoVereador, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(31)
					.addComponent(jbCadastrarVereador)
					.addContainerGap(279, Short.MAX_VALUE))
		);
		jPanel2.setLayout(jPanel2Layout);

		jTabbedPane1.addTab("Vereador", jPanel2);

		jbMenorDesempenho.setText("Vereador menor desempenho");

		jbMaisProjetos.setText("Vereador com mais proj. aprovados");

		jLabel9.setText("Número do partido:");

		jbEstatisticas.setText("Estatísticas do partido");

		jbTotalProjetos.setText("Total de projetos da Câmara");
		jbTotalProjetos.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton6ActionPerformed(evt);
			}
		});

		jbVereadoresAcimaMedia.setText("Vereadores acima da média");
		jbVereadoresAcimaMedia.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton7ActionPerformed(evt);
			}
		});
		
		JTextArea taVereadores = new JTextArea();
		
		JButton btnNewButton = new JButton("Mostrar todos os vereadores");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				taVereadores.setText("Listagem dos Vereadores:");
				
				for (Partido part : camara.getPartidos().values())
				{
					for (Vereador v : part.getVereadores())
					{
						taVereadores.append("\n\nNome: " + v.getNome());
						taVereadores.append("\nPartido: " + v.getPartido().getNumero() + " - " + v.getPartido().getNome());
						taVereadores.append("\nDesempenho: " + v.getDesempenho());
						taVereadores.append("\n\nProjetos: ");
						
						for (ProjetoDeLei p : v.getProjetosDeLei())
							taVereadores.append("\n\n" + p.mostrar());
					}
				}
			}
		});
		

		javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
		jPanel3Layout.setHorizontalGroup(
			jPanel3Layout.createParallelGroup(Alignment.LEADING)
				.addGroup(jPanel3Layout.createSequentialGroup()
					.addGroup(jPanel3Layout.createParallelGroup(Alignment.LEADING)
						.addGroup(jPanel3Layout.createSequentialGroup()
							.addGroup(jPanel3Layout.createParallelGroup(Alignment.LEADING)
								.addComponent(jbVereadoresAcimaMedia)
								.addComponent(jbTotalProjetos)
								.addComponent(jbMenorDesempenho)
								.addComponent(jbMaisProjetos)
								.addGroup(jPanel3Layout.createSequentialGroup()
									.addGap(22)
									.addComponent(btnNewButton)))
							.addPreferredGap(ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
							.addComponent(taVereadores, GroupLayout.PREFERRED_SIZE, 371, GroupLayout.PREFERRED_SIZE))
						.addGroup(jPanel3Layout.createSequentialGroup()
							.addContainerGap()
							.addGroup(jPanel3Layout.createParallelGroup(Alignment.LEADING)
								.addComponent(jSeparator1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addGroup(jPanel3Layout.createSequentialGroup()
									.addComponent(jLabel9)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(jTextField7, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(jbEstatisticas)))))
					.addContainerGap())
		);
		jPanel3Layout.setVerticalGroup(
			jPanel3Layout.createParallelGroup(Alignment.LEADING)
				.addGroup(jPanel3Layout.createSequentialGroup()
					.addContainerGap()
					.addGroup(jPanel3Layout.createParallelGroup(Alignment.BASELINE)
						.addComponent(jLabel9)
						.addComponent(jTextField7, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(jbEstatisticas))
					.addGroup(jPanel3Layout.createParallelGroup(Alignment.LEADING)
						.addGroup(jPanel3Layout.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(taVereadores, GroupLayout.DEFAULT_SIZE, 352, Short.MAX_VALUE))
						.addGroup(jPanel3Layout.createSequentialGroup()
							.addGap(13)
							.addComponent(jSeparator1, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(jbMenorDesempenho)
							.addGap(18)
							.addComponent(jbMaisProjetos)
							.addGap(18)
							.addComponent(jbTotalProjetos)
							.addGap(18)
							.addComponent(jbVereadoresAcimaMedia)
							.addGap(70)
							.addComponent(btnNewButton)))
					.addContainerGap())
		);
		jPanel3.setLayout(jPanel3Layout);

		jTabbedPane1.addTab("Consultas", jPanel3);

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(
				layout.createSequentialGroup().addContainerGap().addComponent(jTabbedPane1).addContainerGap()));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(
				layout.createSequentialGroup().addContainerGap().addComponent(jTabbedPane1).addGap(28, 28, 28)));
		
		JPanel panel = new JPanel();
		jTabbedPane1.addTab("Projetos", null, panel, null);
		panel.setLayout(null);
		
		cbVereador = new JComboBox();
		cbVereador.setBounds(85, 11, 178, 24);
		panel.add(cbVereador);
		
		JComboBox cbTipo = new JComboBox();
		cbTipo.setModel(new DefaultComboBoxModel(new String[] {"Projeto de Lei", "Projeto de Lei Complementar"}));
		cbTipo.setBounds(85, 54, 178, 24);
		panel.add(cbTipo);
		
		cbTipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	if (cbTipo.getSelectedIndex() == 0)
            	{
            		tfArtigoLO.setEnabled(false);
            		tfQtdVotosFavoraveis.setEnabled(false);
            	}
            	else
            	{
            		tfArtigoLO.setEnabled(true);
            		tfQtdVotosFavoraveis.setEnabled(true);
            	}            	
            }
        });
		
		tfTitulo = new JTextField();
		tfTitulo.setBounds(116, 94, 147, 24);
		panel.add(tfTitulo);
		tfTitulo.setColumns(10);
		
		tfDataApresentacao = new JTextField();
		tfDataApresentacao.setBounds(116, 129, 147, 24);
		panel.add(tfDataApresentacao);
		tfDataApresentacao.setColumns(10);
		
		tfDataAprovacao = new JTextField();
		tfDataAprovacao.setBounds(116, 164, 147, 24);
		panel.add(tfDataAprovacao);
		tfDataAprovacao.setColumns(10);
		
		tfNumeroProjeto = new JTextField();
		tfNumeroProjeto.setBounds(451, 94, 122, 24);
		panel.add(tfNumeroProjeto);
		tfNumeroProjeto.setColumns(10);
		
		tfArtigoLO = new JTextField();
		tfArtigoLO.setEnabled(false);
		tfArtigoLO.setBounds(451, 129, 122, 24);
		panel.add(tfArtigoLO);
		tfArtigoLO.setColumns(10);
		
		tfQtdVotosFavoraveis = new JTextField();
		tfQtdVotosFavoraveis.setEnabled(false);
		tfQtdVotosFavoraveis.setBounds(451, 164, 122, 24);
		panel.add(tfQtdVotosFavoraveis);
		tfQtdVotosFavoraveis.setColumns(10);
		
		JButton btnCadastrarProjeto = new JButton("Cadastrar");
		btnCadastrarProjeto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{
					if (cbVereador.getSelectedIndex() == -1)
					{
						String s = "É necessário escolher um vereador para o cadastro.";
						JOptionPane.showMessageDialog(null, s);
						return;
					}

					Vereador vAux = (Vereador) cbVereador.getSelectedItem();
					
					ProjetoDeLei projetoDeLei;
					
					switch (cbTipo.getSelectedIndex()) {
					case 0:
						projetoDeLei = new ProjetoDeLei(tfTitulo.getText(), LocalDate.parse(tfDataApresentacao.getText(), formatter), tfDataAprovacao.getText(), Integer.parseInt(tfNumeroProjeto.getText()));
						break;
					case 1:
						projetoDeLei = new ProjetoDeLeiComplementar(tfTitulo.getText(), LocalDate.parse(tfDataApresentacao.getText(), formatter), tfDataAprovacao.getText(), Integer.parseInt(tfNumeroProjeto.getText()), Integer.parseInt(tfArtigoLO.getText()), Integer.parseInt(tfQtdVotosFavoraveis.getText()));
						break;
						
					default:
						String s = "É necessário escolher um tipo de projeto para o cadastro.";
						JOptionPane.showMessageDialog(null, s);
						return;
					}
					
					vAux.addProjetoDeLei(projetoDeLei);
				} 
				catch (IllegalArgumentException iae) 
				{
					JOptionPane.showMessageDialog(null, iae.getMessage());
				}
				catch (DateTimeParseException dte)
				{
					JOptionPane.showMessageDialog(null, "Data inválida.");
				}
			}
		});
		btnCadastrarProjeto.setBounds(257, 260, 89, 23);
		panel.add(btnCadastrarProjeto);
		
		JLabel lblNewLabel = new JLabel("Vereador: ");
		lblNewLabel.setBounds(10, 16, 65, 14);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Tipo:");
		lblNewLabel_1.setBounds(10, 64, 46, 14);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("T\u00EDtulo:");
		lblNewLabel_2.setBounds(10, 97, 46, 14);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Data Apresenta\u00E7\u00E3o:");
		lblNewLabel_3.setBounds(10, 134, 128, 14);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Data Aprova\u00E7\u00E3o:");
		lblNewLabel_4.setBounds(10, 169, 96, 14);
		panel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("N\u00FAmero:");
		lblNewLabel_5.setBounds(342, 99, 99, 14);
		panel.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Artigo LO:");
		lblNewLabel_6.setBounds(342, 134, 82, 14);
		panel.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Votos Favor\u00E1veis");
		lblNewLabel_7.setBounds(342, 169, 99, 14);
		panel.add(lblNewLabel_7);

		pack();
	}

	private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
		try
		{
			Partido p = new Partido(jtfNomePartido.getText(), Integer.parseInt(jtfNumPartido.getText()));
			
			if (camara.addPartido(p) == false)
			{
				JOptionPane.showMessageDialog(this, "Partido já cadastrado.");
				return;
			}
		} 
		catch (IllegalArgumentException iae) 
		{
			JOptionPane.showMessageDialog(this, iae.getMessage());
		}
	}

	private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
		try
		{
			if (camara.getPartidos().containsKey(Integer.parseInt(jtfNumPartidoVereador.getText())) == false)
			{
				JOptionPane.showMessageDialog(this, "Partido válido deve ser informado.");
				return;
			}
			
			Partido p = camara.getPartidos().get(Integer.parseInt(jtfNumPartidoVereador.getText()));
		
			Vereador v = new Vereador(jtfNomeVereador.getText(), p);
		
			p.addVereador(v);
			cbVereador.addItem(v);
		} 
		catch (IllegalArgumentException iae) 
		{
			JOptionPane.showMessageDialog(this, iae.getMessage());
		}
	}

	private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {
	}

	private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {
	}

	/**
	 * @param args the command line arguments
	 */
	public static void main(String args[]) {
		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(Apresentacao.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(Apresentacao.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(Apresentacao.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(Apresentacao.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);
		}

		/* Create and display the form */
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new Apresentacao().setVisible(true);
			}
		});
	}

	// Variables declaration
	private javax.swing.JButton jbCadastrarPartido;
	private javax.swing.JButton jbCadastrarVereador;
	private javax.swing.JButton jbMenorDesempenho;
	private javax.swing.JButton jbMaisProjetos;
	private javax.swing.JButton jbEstatisticas;
	private javax.swing.JButton jbTotalProjetos;
	private javax.swing.JButton jbVereadoresAcimaMedia;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel jLabel4;
	private javax.swing.JLabel jLabel7;
	private javax.swing.JLabel jLabel9;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JPanel jPanel2;
	private javax.swing.JPanel jPanel3;
	private javax.swing.JSeparator jSeparator1;
	private javax.swing.JTabbedPane jTabbedPane1;
	private javax.swing.JTextField jtfNumPartido;
	private javax.swing.JTextField jtfNomePartido;
	private javax.swing.JTextField jtfNomeVereador;
	private javax.swing.JTextField jtfNumPartidoVereador;
	private javax.swing.JTextField jTextField7;
	private Camara camara;
	private JTextField tfTitulo;
	private JTextField tfDataApresentacao;
	private JTextField tfDataAprovacao;
	private JTextField tfNumeroProjeto;
	private JTextField tfArtigoLO;
	private JTextField tfQtdVotosFavoraveis;
	private JComboBox<Vereador> cbVereador;
	private DateTimeFormatter formatter;
}