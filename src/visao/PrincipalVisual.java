package visao;

import java.awt.EventQueue;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;

public class PrincipalVisual {

	private JFrame frame;
	private JTextField textMes;
	private JTextField textAno;
	
	JButton btnAbrirArquivo = new JButton("Abrir Arquivo");
	JButton btnOk = new JButton("OK");
	JLabel nomeArquivoLabel = new JLabel("");
	JCheckBox chckbxItemVendido = new JCheckBox("Mostrar item mais vendido");
	
	String nomeArquivo;
	String calcMes;
	String calcAno;
	private JButton btnItemMais;
	
	public String getNomeArquivo() {
		return nomeArquivo;
	}
	
	public String getCalcMes() {
		return calcMes;
	}
	
	public String getCalcAno() {
		return calcAno;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PrincipalVisual window = new PrincipalVisual();
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
	public PrincipalVisual() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 500, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
//		JButton btnAbrirArquivo = new JButton("Abrir Arquivo");
		btnAbrirArquivo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFileChooser chooser = new JFileChooser();
				chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
				chooser.setDialogTitle("Escolha o arquivo de acessos:");
				int ret = chooser.showOpenDialog(null);
				if (ret==JFileChooser.APPROVE_OPTION) {
					nomeArquivo = chooser.getSelectedFile().getAbsolutePath();
					nomeArquivoLabel.setText("Arquivo: " + nomeArquivo);	
					System.out.println("");
				}
				btnAbrirArquivo.setEnabled(false);
				textMes.setEnabled(true);
				textAno.setEnabled(true);
				btnOk.setEnabled(true);
			}
		});
		btnAbrirArquivo.setBounds(10, 11, 145, 23);
		frame.getContentPane().add(btnAbrirArquivo);
		
		JLabel lblMs = new JLabel("M\u00EAs:");
		lblMs.setBounds(10, 56, 46, 14);
		frame.getContentPane().add(lblMs);
		
		JLabel lblAno = new JLabel("Ano:");
		lblAno.setBounds(10, 81, 46, 14);
		frame.getContentPane().add(lblAno);
		
		textMes = new JTextField();
		textMes.setEnabled(false);
		textMes.setBounds(50, 53, 86, 20);
		frame.getContentPane().add(textMes);
		textMes.setColumns(10);
		
		textAno = new JTextField();
		textAno.setEnabled(false);
		textAno.setBounds(50, 78, 86, 20);
		frame.getContentPane().add(textAno);
		textAno.setColumns(10);
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				calcMes = textMes.getText();
				calcAno = textAno.getText();
				
				btnOk.setEnabled(false);
				textMes.setEnabled(false);
				textAno.setEnabled(false);
			}
		});
		btnOk.setEnabled(false);
		
//		JButton btnOk = new JButton("OK");
		btnOk.setBounds(50, 142, 89, 23);
		frame.getContentPane().add(btnOk);
		
		btnItemMais = new JButton("Ver item mais vendido");
		btnItemMais.setEnabled(false);
		btnItemMais.setBounds(227, 81, 158, 50);
		frame.getContentPane().add(btnItemMais);
		
//		JLabel NomeArquivo = new JLabel("");
		nomeArquivoLabel.setBounds(195, 15, 293, 14);
		frame.getContentPane().add(nomeArquivoLabel);
		
//		JCheckBox chckbxItemVendido = new JCheckBox("Mostrar item mais vendido");
		chckbxItemVendido.setEnabled(false);
		chckbxItemVendido.setBounds(10, 112, 158, 23);
		frame.getContentPane().add(chckbxItemVendido);
	}
}
