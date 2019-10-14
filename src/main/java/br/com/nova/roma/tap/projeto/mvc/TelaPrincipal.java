package br.com.nova.roma.tap.projeto.mvc;



import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JProgressBar;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import br.com.nova.roma.tap.projeto.controlador.ControladorCaixa;
import br.com.nova.roma.tap.projeto.controlador.ControladorDaLoterica;
import br.com.nova.roma.tap.projeto.entity.Cliente;

public class TelaPrincipal extends JFrame {
	private JPanel contentPane;
	public static JTextField nomeCliente;
	public static JTextField caixaUm;
	public static JProgressBar progressBar;
	public static JTextField modeloClientesApostas;
	public static JTextField mecanicoMotor;
	public static JProgressBar progressBarMotor;
	private JTextArea textArea;
	private JButton btnFecharLoterica;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {

			public void run() {
				try {
					TelaPrincipal frame = new TelaPrincipal();
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
	public TelaPrincipal() {
		final ControladorDaLoterica control = new ControladorDaLoterica();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 562, 447);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton start = new JButton("Abrir Loterica");
		start.setFont(new Font("Arial Black", Font.PLAIN, 11));
		start.setBackground(Color.BLUE);
		start.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String escolhas = "";
				
			
				Cliente c1 = new Cliente("Ricardo", new Random().nextInt(80), new Random().nextInt(4));
				
				Cliente c2 = new Cliente("Luna", new Random().nextInt(80), new Random().nextInt(4));
				
				Cliente c3 = new Cliente("Anderson", new Random().nextInt(80), new Random().nextInt(4));
				
				Cliente c4 = new Cliente("Matheus", new Random().nextInt(80), new Random().nextInt(4));
				if(c1.getIdadeDoCliente() >= 70) {
					c1.setPrioridadeCliente(5);
				}
				try {
					ControladorCaixa c = new ControladorCaixa(c1,c2,c3,c4, control);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				for(int i = 0; i<c1.escolha.length; i++) {
					 escolhas += ","+c1.escolha[i];
					
				}
				
				modeloClientesApostas.setText(escolhas);
			}
		});

		start.setBounds(96, 32, 132, 32);
		contentPane.add(start);

		this.progressBar = new JProgressBar();
		this.progressBar.setBackground(Color.CYAN);
		this.progressBar.setBounds(182, 106, 351, 34);
		this.progressBar.setStringPainted(true);
		contentPane.add(progressBar);

		nomeCliente = new JTextField();
		nomeCliente.setForeground(Color.WHITE);
		nomeCliente.setBackground(Color.LIGHT_GRAY);
		nomeCliente.setFont(new Font("Arial Black", Font.PLAIN, 11));
		nomeCliente.setBounds(10, 106, 76, 32);
		contentPane.add(nomeCliente);
		nomeCliente.setColumns(10);

		caixaUm = new JTextField();
		caixaUm.setForeground(Color.WHITE);
		caixaUm.setBackground(Color.LIGHT_GRAY);
		caixaUm.setFont(new Font("Arial Black", Font.PLAIN, 11));
		caixaUm.setBounds(96, 106, 76, 32);
		contentPane.add(caixaUm);
		caixaUm.setColumns(10);

		JTextArea txtCaixa = new JTextArea();
		txtCaixa.setBackground(Color.GRAY);
		txtCaixa.setText("Cliente");
		txtCaixa.setBounds(21, 76, 65, 22);
		contentPane.add(txtCaixa);

		JTextArea txtCliente = new JTextArea();
		txtCliente.setBackground(Color.GRAY);
		txtCliente.setText("Caixa");
		txtCliente.setBounds(96, 76, 76, 22);
		contentPane.add(txtCliente);

		modeloClientesApostas = new JTextField();
		modeloClientesApostas.setForeground(Color.WHITE);
		modeloClientesApostas.setFont(new Font("Arial Black", Font.PLAIN, 11));
		modeloClientesApostas.setBackground(Color.LIGHT_GRAY);
		modeloClientesApostas.setBounds(10, 183, 206, 32);

		contentPane.add(modeloClientesApostas);
		modeloClientesApostas.setColumns(10);

		JTextArea txtApostando = new JTextArea();
		txtApostando.setFont(new Font("Arial Black", Font.PLAIN, 13));
		txtApostando.setBackground(Color.GRAY);
		txtApostando.setText("Apostando");
		txtApostando.setBounds(236, 75, 107, 22);
		contentPane.add(txtApostando);



		textArea = new JTextArea();
		textArea.setText("Escolhas");
		textArea.setBackground(Color.GRAY);
		textArea.setBounds(20, 153, 65, 22);
		contentPane.add(textArea);



		btnFecharLoterica = new JButton("Fechar Loterica");
		btnFecharLoterica.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				

				JOptionPane.showMessageDialog(null, "Fechando Loterica");
				control.fecharLoterica();
			}
		});
		btnFecharLoterica.setBackground(Color.GRAY);
		btnFecharLoterica.setFont(new Font("Arial Black", Font.PLAIN, 11));
		btnFecharLoterica.setBounds(358, 33, 145, 32);
		contentPane.add(btnFecharLoterica);
	}

	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}

			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}

			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}
