package presentacion;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JButton;

public class FReportesClientes extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FReportesClientes frame = new FReportesClientes();
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
	public FReportesClientes() {
		setTitle("Reportes x Cliente");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblEmpladosXCliente = new JLabel("Emplados x Cliente");
		lblEmpladosXCliente.setBounds(12, 12, 150, 16);
		contentPane.add(lblEmpladosXCliente);
		
		JLabel lblPublicidadesXCliente = new JLabel("Publicidades x Cliente");
		lblPublicidadesXCliente.setBounds(356, 12, 132, 16);
		contentPane.add(lblPublicidadesXCliente);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 68, 332, 420);
		contentPane.add(scrollPane);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(356, 68, 332, 420);
		contentPane.add(scrollPane_1);
		
		textField = new JTextField();
		textField.setBounds(12, 36, 64, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(88, 30, 94, 26);
		contentPane.add(btnNewButton);
		
		textField_1 = new JTextField();
		textField_1.setBounds(356, 36, 64, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("New button");
		btnNewButton_1.setBounds(432, 30, 94, 26);
		contentPane.add(btnNewButton_1);
	}

}
