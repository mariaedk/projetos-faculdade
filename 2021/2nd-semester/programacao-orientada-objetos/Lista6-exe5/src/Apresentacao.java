import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JOptionPane;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 *
 * @author marcel
 */
public class Apresentacao extends javax.swing.JFrame {

	private static final String NOME_ARQUIVO = "ObjetosExerc2-Lista4.dat";
	private ArrayList<Aluno> matriculados = new ArrayList<>();
	private HashMap<String, Curso> cursos = new HashMap<>();
	private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

	/** Creates new form Apresentacao */
	public Apresentacao() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {
				matriculados = null;
				System.gc(); // chamando o garbage collector para forçar a destruição dos objetos, perdidos
								// na linha anterior
				JOptionPane.showMessageDialog(null, "Olhe a console para acompanhar a destruição dos objetos");
			}
		});

		try {
			FileInputStream fis = new FileInputStream(NOME_ARQUIVO);
			ObjectInputStream ois = new ObjectInputStream(fis);
			cursos = (HashMap<String, Curso>) ois.readObject();
			matriculados = (ArrayList<Aluno>) ois.readObject();
			ois.close();
			
		} catch (FileNotFoundException e) {
			// ao invés de criar uma funcionalidade na interface com usuário para cadastrar
			// os cursos,
			// estou criando meia dúzia de cursos para facilitar
			Curso c = new Curso("BCC", "Ciência da Computação");
			cursos.put(c.getSigla(), c);
			c = new Curso("ADM", "Administração");
			cursos.put(c.getSigla(), c);
			c = new Curso("SIS", "Sistemas de Informação");
			cursos.put(c.getSigla(), c);
			c = new Curso("PED", "Pedagogia");
			cursos.put(c.getSigla(), c);
			c = new Curso("CSO", "Ciências Sociais");
			cursos.put(c.getSigla(), c);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		initComponents();
	}

	private void initComponents() {

		jLabel1 = new javax.swing.JLabel();
		jtfNomeAluno = new javax.swing.JTextField();
		jLabel2 = new javax.swing.JLabel();
		jtfDataNascimento = new javax.swing.JTextField();
		jcbTipoAluno = new javax.swing.JComboBox();
		jLabel3 = new javax.swing.JLabel();
		jcbAno = new javax.swing.JComboBox();
		jcbIngresso = new JComboBox<String>();
		jcbIngresso.setModel(new DefaultComboBoxModel(
				new String[] { "Vestibular", "ENEM", "Sele\u00E7\u00E3o FURB", "Transf.Externa", "Interna-Transf." }));
		jLabel4 = new javax.swing.JLabel();
		jtfSigla = new javax.swing.JTextField();
		jbCadastrar = new javax.swing.JButton();
		jSeparator1 = new javax.swing.JSeparator();
		jbListar = new javax.swing.JButton();
		jScrollPane1 = new javax.swing.JScrollPane();
		jTextArea1 = new javax.swing.JTextArea();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setTitle("Lista 4 - Exercício 2");

		jLabel1.setText("Nome do aluno:");

		jLabel2.setText("Data Nascimento:");

		jcbTipoAluno.setModel(new DefaultComboBoxModel(new String[] { "Universit\u00E1rio", "Ensino M\u00E9dio" }));
		jcbTipoAluno.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jComboBox1ActionPerformed(evt);
			}
		});

		jLabel3.setText("Ano:");
		jLabel3.setEnabled(false);

		jcbAno.setModel(new DefaultComboBoxModel(new String[] { "1", "2", "3" }));
		jcbAno.setEnabled(false);

		jLabel4.setText("Sigla do curso:");

		jbCadastrar.setText("Cadastrar aluno");
		jbCadastrar.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton1ActionPerformed(evt);
			}
		});

		jbListar.setText("Listar alunos");
		jbListar.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton2ActionPerformed(evt);
			}
		});

		jTextArea1.setColumns(20);
		jTextArea1.setRows(5);
		jScrollPane1.setViewportView(jTextArea1);

		jLabel5 = new JLabel("Ingresso por:");

		JButton btnSalvar = new JButton("Salvar alunos");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					FileOutputStream fos = new FileOutputStream(NOME_ARQUIVO);
					ObjectOutputStream oos = new ObjectOutputStream(fos);
					oos.writeObject(cursos);
					oos.writeObject(matriculados);
					oos.close();
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		layout.setHorizontalGroup(layout.createParallelGroup(Alignment.LEADING).addGroup(layout.createSequentialGroup()
				.addGroup(layout.createParallelGroup(Alignment.LEADING).addGroup(layout.createSequentialGroup()
						.addContainerGap()
						.addGroup(layout.createParallelGroup(Alignment.LEADING)
								.addComponent(jScrollPane1, GroupLayout.DEFAULT_SIZE, 793, Short.MAX_VALUE)
								.addComponent(jSeparator1, GroupLayout.PREFERRED_SIZE, 518, GroupLayout.PREFERRED_SIZE)
								.addGroup(layout.createSequentialGroup().addComponent(jbListar)
										.addPreferredGap(ComponentPlacement.RELATED).addComponent(btnSalvar,
												GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE))))
						.addGroup(layout.createSequentialGroup().addGap(22).addGroup(layout
								.createParallelGroup(Alignment.LEADING)
								.addComponent(jcbTipoAluno, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE)
								.addGroup(layout.createParallelGroup(Alignment.LEADING, false)
										.addGroup(layout.createSequentialGroup().addComponent(jLabel2)
												.addPreferredGap(ComponentPlacement.RELATED)
												.addComponent(jtfDataNascimento))
										.addGroup(layout.createSequentialGroup().addComponent(jLabel1)
												.addPreferredGap(ComponentPlacement.RELATED).addComponent(jtfNomeAluno,
														GroupLayout.PREFERRED_SIZE, 159, GroupLayout.PREFERRED_SIZE)))
								.addGroup(layout.createSequentialGroup().addComponent(jLabel3)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(jcbAno, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE)
										.addGap(45).addGroup(
												layout.createParallelGroup(Alignment.LEADING).addComponent(jbCadastrar)
														.addGroup(layout.createSequentialGroup().addComponent(jLabel4)
																.addGap(18)
																.addComponent(jtfSigla, GroupLayout.PREFERRED_SIZE, 45,
																		GroupLayout.PREFERRED_SIZE)
																.addPreferredGap(ComponentPlacement.UNRELATED)
																.addComponent(jLabel5)
																.addPreferredGap(ComponentPlacement.UNRELATED)
																.addComponent(jcbIngresso, GroupLayout.PREFERRED_SIZE,
																		GroupLayout.DEFAULT_SIZE,
																		GroupLayout.PREFERRED_SIZE)))))
								.addGap(174)))
				.addContainerGap()));
		layout.setVerticalGroup(layout.createParallelGroup(Alignment.LEADING).addGroup(layout.createSequentialGroup()
				.addContainerGap()
				.addGroup(layout.createParallelGroup(Alignment.BASELINE).addComponent(jLabel1).addComponent(
						jtfNomeAluno, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(ComponentPlacement.RELATED)
				.addGroup(layout
						.createParallelGroup(Alignment.BASELINE).addComponent(jLabel2).addComponent(jtfDataNascimento,
								GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(ComponentPlacement.UNRELATED)
				.addComponent(jcbTipoAluno, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
						GroupLayout.PREFERRED_SIZE)
				.addGap(18)
				.addGroup(layout.createParallelGroup(Alignment.BASELINE).addComponent(jLabel3)
						.addComponent(jcbAno, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(jLabel4)
						.addComponent(jtfSigla, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(jLabel5).addComponent(jcbIngresso, GroupLayout.PREFERRED_SIZE,
								GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(jbCadastrar)
				.addPreferredGap(ComponentPlacement.RELATED)
				.addComponent(jSeparator1, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(ComponentPlacement.RELATED)
				.addGroup(layout.createParallelGroup(Alignment.BASELINE).addComponent(jbListar).addComponent(btnSalvar))
				.addGap(18).addComponent(jScrollPane1, GroupLayout.DEFAULT_SIZE, 253, Short.MAX_VALUE)
				.addContainerGap()));
		getContentPane().setLayout(layout);
		pack();
	}

	private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
		try {
			Aluno aluno;
			String nomeAluno = jtfNomeAluno.getText();
			LocalDate data = LocalDate.parse(jtfDataNascimento.getText(), formatter);

			if (jcbTipoAluno.getSelectedIndex() == 0) { // Universidade
				char ingresso = jcbIngresso.getSelectedItem().toString().charAt(0);
				Curso curso = cursos.get(jtfSigla.getText());
				aluno = new AlunoUniversitario(nomeAluno, data, ingresso, curso);
			} else {
				int ano = Integer.parseInt(jcbAno.getSelectedItem().toString());
				aluno = new AlunoEnsinoMedio(nomeAluno, data, ano);
			}
			matriculados.add(aluno);
			JOptionPane.showMessageDialog(this, "Aluno cadastrado");
		} catch (DateTimeParseException dte) {
			JOptionPane.showMessageDialog(this, "Data de nascimento inválida");
		} catch (IllegalArgumentException iae) {
			JOptionPane.showMessageDialog(this, iae.getMessage());
		}
	}

	private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
		jTextArea1.setText("Listagem dos alunos\n");
		matriculados.sort(null);
		for (Aluno a : matriculados) {
			jTextArea1.append("\n" + a.mostra()); // polimorfismo
		}
	}

	private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {
		// manipulação da interface com usuário
		if (jcbTipoAluno.getSelectedIndex() == 0) { // Universidade
			jLabel3.setEnabled(false);
			jcbAno.setEnabled(false);
			jLabel4.setEnabled(true);
			jtfSigla.setEnabled(true);
			jLabel5.setEnabled(true);
			jcbIngresso.setEnabled(true);
		} else {
			jLabel3.setEnabled(true);
			jcbAno.setEnabled(true);
			jLabel4.setEnabled(false);
			jtfSigla.setEnabled(false);
			jLabel5.setEnabled(false);
			jcbIngresso.setEnabled(false);
		}
	}

	/**
	 * @param args the command line arguments
	 */
	public static void main(String args[]) {
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new Apresentacao().setVisible(true);
			}
		});
	}

	// Variables declaration
	private javax.swing.JButton jbCadastrar;
	private javax.swing.JButton jbListar;
	private javax.swing.JComboBox<String> jcbTipoAluno;
	private javax.swing.JComboBox<String> jcbAno;
	private javax.swing.JComboBox<String> jcbIngresso;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel jLabel4;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JSeparator jSeparator1;
	private javax.swing.JTextArea jTextArea1;
	private javax.swing.JTextField jtfNomeAluno;
	private javax.swing.JTextField jtfDataNascimento;
	private javax.swing.JTextField jtfSigla;
	private JLabel jLabel5;
}