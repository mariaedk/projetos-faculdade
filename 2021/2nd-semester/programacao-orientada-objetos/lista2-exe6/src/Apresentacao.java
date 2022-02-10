import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;

public class Apresentacao {

	private JFrame frame;
	private JTextField tfTamanho;
	private JTextField tfValor;
	private JTextField tfPosicao;
	private VetorDeReais meuVetorObj,
						 outroVetorObj;

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
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Qual o tamanho do vetor de reais?");
		lblNewLabel.setBounds(21, 11, 185, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnCriar = new JButton("Criar vetor");
		btnCriar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
			}
		});
		btnCriar.setBounds(335, 7, 89, 23);
		frame.getContentPane().add(btnCriar);
		
		tfTamanho = new JTextField();
		tfTamanho.setBounds(216, 8, 69, 20);
		frame.getContentPane().add(tfTamanho);
		tfTamanho.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Valor");
		lblNewLabel_1.setBounds(21, 63, 24, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		tfValor = new JTextField();
		tfValor.setBounds(55, 60, 86, 20);
		frame.getContentPane().add(tfValor);
		tfValor.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Posi\u00E7\u00E3o");
		lblNewLabel_2.setBounds(167, 63, 69, 14);
		frame.getContentPane().add(lblNewLabel_2);
		
		tfPosicao = new JTextField();
		tfPosicao.setBounds(216, 60, 86, 20);
		frame.getContentPane().add(tfPosicao);
		tfPosicao.setColumns(10);
		
		JButton btnOK = new JButton("Ok");
		btnOK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				meuVetorObj.setValor(Double.parseDouble(tfValor.getText()), Integer.parseInt(tfPosicao.getText()));
			}
		});
		btnOK.setBounds(335, 59, 89, 23);
		frame.getContentPane().add(btnOK);
		
		JButton btnNewButton = new JButton("Quantos pares");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(frame, "Quantidade de pares é : " + meuVetorObj.quantosPares());
			}
		});
		btnNewButton.setBounds(50, 122, 110, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnGuardar = new JButton("Guardar Vetor");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				outroVetorObj = meuVetorObj;
				JOptionPane.showMessageDialog(frame, "Vetor foi guardado.");
				
			}
		});
		btnGuardar.setBounds(170, 122, 101, 23);
		frame.getContentPane().add(btnGuardar);
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(131, 212, 185, 22);
		frame.getContentPane().add(scrollPane);
		JTextArea textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		
		JButton btnDividir = new JButton("Dividir");
		btnDividir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VetorDeReais resultDivisao = meuVetorObj.divide(outroVetorObj);
				textArea.setText("Divisão entre os objetos de VetorDeReais \n");
				textArea.append("\nVetor A:" + meuVetorObj.exibir());
				textArea.append("\nVetor B:" + outroVetorObj.exibir());
				textArea.append("\nResultado:" + resultDivisao.exibir());
			}
		});
		btnDividir.setBounds(71, 156, 89, 23);
		frame.getContentPane().add(btnDividir);
		
		JButton btnMultiplicar = new JButton("Multiplicar");
		btnMultiplicar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double resultado = meuVetorObj.multiplica(outroVetorObj);
				textArea.setText("Multiplicação entre os objetos de VetorDeReais \n");
				textArea.append("\nVetor A:" + meuVetorObj.exibir());
				textArea.append("\nVetor B:" + outroVetorObj.exibir());
				textArea.append("\nM:" +resultado);
			}
		});
		btnMultiplicar.setBounds(167, 156, 89, 23);
		frame.getContentPane().add(btnMultiplicar);


	}
}
