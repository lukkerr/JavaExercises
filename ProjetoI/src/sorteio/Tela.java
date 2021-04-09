package sorteio;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Tela {
	private JFrame frame;
	private JLabel label;
	private JLabel label_1;
	private JLabel label_2;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JLabel label_3;
	private JButton button;

	private Sorteio sorteio;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tela window = new Tela();
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
	public Tela() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Sorteio de n\u00FAmeros");
		frame.setBounds(100, 100, 388, 216);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		label = new JLabel("Quantidade:");
		label.setBounds(10, 26, 70, 14);
		frame.getContentPane().add(label);

		label_1 = new JLabel("Minimo:");
		label_1.setBounds(10, 61, 70, 14);
		frame.getContentPane().add(label_1);

		label_2 = new JLabel("Maximo");
		label_2.setBounds(10, 93, 70, 14);
		frame.getContentPane().add(label_2);

		textField = new JTextField();
		textField.setBounds(90, 23, 86, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setBounds(90, 58, 86, 20);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);

		textField_2 = new JTextField();
		textField_2.setBounds(90, 90, 86, 20);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);

		label_3 = new JLabel("Resultado:");
		label_3.setBounds(10, 137, 352, 14);
		frame.getContentPane().add(label_3);

		button = new JButton("Gerar Numeros");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if(textField.getText().isEmpty() || textField_1.getText().isEmpty() || textField_2.getText().isEmpty()) {
					label_3.setText("campo vazio");
					return;
				}
				
				try {
					sorteio = new Sorteio(Integer.parseInt(textField.getText()),
							Integer.parseInt(textField_1.getText()),
							Integer.parseInt(textField_2.getText()) 	);
					sorteio.gerarNumeros();
					label_3.setText("Resultado:" + sorteio.resultado("/"));
				}
				catch(Exception e1) {
					label_3.setText(e1.getMessage());
				}
				
			}
		});
		button.setBounds(211, 57, 129, 23);
		frame.getContentPane().add(button);
	}
}