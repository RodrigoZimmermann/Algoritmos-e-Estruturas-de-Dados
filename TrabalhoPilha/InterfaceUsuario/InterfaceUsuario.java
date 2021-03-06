import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class InterfaceUsuario extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InterfaceUsuario frame = new InterfaceUsuario();
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
	public InterfaceUsuario() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 415, 257);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		textField = new JTextField();
		textField.setBounds(36, 47, 335, 20);
		contentPane.add(textField);
		textField.setColumns(10);

		JLabel lblNewLabel = new JLabel("Express\u00E3o em formato P\u00F3s-fixa");
		lblNewLabel.setBounds(36, 23, 172, 14);
		contentPane.add(lblNewLabel);

		JRadioButton rdbtnPilhaVetor = new JRadioButton("Usar Pilha Vetor");
		rdbtnPilhaVetor.setBounds(186, 107, 166, 23);
		contentPane.add(rdbtnPilhaVetor);

		JRadioButton rdbtnPilhaLista = new JRadioButton("Usar Pilha Lista");
		rdbtnPilhaLista.setBounds(186, 140, 166, 23);
		contentPane.add(rdbtnPilhaLista);

		JButton btnNewButton = new JButton("Calcular");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (rdbtnPilhaVetor.isSelected() && rdbtnPilhaLista.isSelected()) {
					JOptionPane.showMessageDialog(null, "Escolha somente uma tipo de pilha.Obrigado!", "Informação",
							JOptionPane.WARNING_MESSAGE);
				} else if (rdbtnPilhaVetor.isCursorSet()) {

				} else {

				}
			}
		});
		btnNewButton.setBounds(36, 107, 89, 23);
		contentPane.add(btnNewButton);

	}
}
