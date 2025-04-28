package presentacion;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JButton;

public class FManPublicidad extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FManPublicidad frame = new FManPublicidad();
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
	public FManPublicidad() {
		setTitle("Asignacion Publicidad");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAsignarPublicidad = new JLabel("Asignar Publicidad");
		lblAsignarPublicidad.setBounds(12, 12, 148, 16);
		contentPane.add(lblAsignarPublicidad);
		
		JLabel lblNewLabel = new JLabel("Id");
		lblNewLabel.setBounds(12, 40, 54, 16);
		contentPane.add(lblNewLabel);
		
		JLabel lblFecha = new JLabel("Fecha");
		lblFecha.setBounds(12, 68, 54, 16);
		contentPane.add(lblFecha);
		
		JLabel lblEmpleado = new JLabel("Empleado");
		lblEmpleado.setBounds(12, 96, 54, 16);
		contentPane.add(lblEmpleado);
		
		JLabel lblCliente = new JLabel("Cliente");
		lblCliente.setBounds(12, 124, 54, 16);
		contentPane.add(lblCliente);
		
		JLabel lblPublicidad = new JLabel("Publicidad");
		lblPublicidad.setBounds(12, 152, 54, 16);
		contentPane.add(lblPublicidad);
		
		textField = new JTextField();
		textField.setBounds(84, 40, 64, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(84, 66, 64, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(84, 94, 64, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(84, 122, 64, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(84, 150, 64, 20);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblClientes = new JLabel("Clientes");
		lblClientes.setBounds(182, 12, 148, 16);
		contentPane.add(lblClientes);
		
		JLabel lblPublicidades = new JLabel("Publicidades");
		lblPublicidades.setBounds(448, 12, 148, 16);
		contentPane.add(lblPublicidades);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(182, 40, 240, 130);
		contentPane.add(scrollPane);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(448, 40, 240, 130);
		contentPane.add(scrollPane_1);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(12, 218, 676, 232);
		contentPane.add(scrollPane_2);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.setBounds(12, 180, 94, 26);
		contentPane.add(btnGuardar);
		
		JButton btnModificar = new JButton("Modificar");
		btnModificar.setBounds(118, 180, 94, 26);
		contentPane.add(btnModificar);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(224, 180, 94, 26);
		contentPane.add(btnEliminar);
		
		JButton btnAtras = new JButton("Atras");
		btnAtras.setBounds(594, 462, 94, 26);
		contentPane.add(btnAtras);
	}
}
