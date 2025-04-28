package presentacion;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JTable;

public class FManPublicidad extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtid;
	private JTextField txtfecha;
	private JTextField txtemp;
	private JTextField txtcli;
	private JTextField txtpub;
	private JTable grilla_asigpubs;
	private JTable grilla_clientes;
	private JTable grilla_publicidades;

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
		
		txtid = new JTextField();
		txtid.setBounds(84, 40, 64, 20);
		contentPane.add(txtid);
		txtid.setColumns(10);
		
		txtfecha = new JTextField();
		txtfecha.setBounds(84, 66, 64, 20);
		contentPane.add(txtfecha);
		txtfecha.setColumns(10);
		
		txtemp = new JTextField();
		txtemp.setBounds(84, 94, 64, 20);
		contentPane.add(txtemp);
		txtemp.setColumns(10);
		
		txtcli = new JTextField();
		txtcli.setBounds(84, 122, 64, 20);
		contentPane.add(txtcli);
		txtcli.setColumns(10);
		
		txtpub = new JTextField();
		txtpub.setBounds(84, 150, 64, 20);
		contentPane.add(txtpub);
		txtpub.setColumns(10);
		
		JLabel lblClientes = new JLabel("Clientes");
		lblClientes.setBounds(182, 12, 148, 16);
		contentPane.add(lblClientes);
		
		JLabel lblPublicidades = new JLabel("Publicidades");
		lblPublicidades.setBounds(448, 12, 148, 16);
		contentPane.add(lblPublicidades);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(182, 40, 240, 130);
		contentPane.add(scrollPane);
		
		grilla_clientes = new JTable();
		scrollPane.setViewportView(grilla_clientes);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(448, 40, 240, 130);
		contentPane.add(scrollPane_1);
		
		grilla_publicidades = new JTable();
		scrollPane_1.setViewportView(grilla_publicidades);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(12, 218, 676, 232);
		contentPane.add(scrollPane_2);
		
		grilla_asigpubs = new JTable();
		scrollPane_2.setViewportView(grilla_asigpubs);
		
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
