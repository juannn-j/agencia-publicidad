package presentacion;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.Date;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;

import entidades.Cliente;
import interfaces.ICliente;
import logica.LCliente;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JTable;

public class FManCliente extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtid;
	private JTextField txtnombres;
	private JTextField txtapellidos;
	private JDateChooser dcbirthdate;
	private JTextField txttelefono;
	private JTextField txtdirec;
	private JTextField txtdni;
	private JTextField txtsexo;
	private JTextField txtgusto;
	private JTable grilla_clientes;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FManCliente frame = new FManCliente();
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
	public FManCliente() {
		setTitle("Mantenimiento de Clientes");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblID = new JLabel("ID");
		lblID.setFont(new Font("Iosevka", Font.PLAIN, 14));
		lblID.setBounds(10, 12, 54, 16);
		contentPane.add(lblID);
		
		JLabel lblNom = new JLabel("Nombres");
		lblNom.setFont(new Font("Iosevka", Font.PLAIN, 14));
		lblNom.setBounds(10, 40, 70, 16);
		contentPane.add(lblNom);
		
		JLabel lblSurN = new JLabel("Apellidos");
		lblSurN.setFont(new Font("Iosevka", Font.PLAIN, 14));
		lblSurN.setBounds(10, 68, 70, 16);
		contentPane.add(lblSurN);
		
		JLabel lblBirth = new JLabel("Fecha de nacimiento");
		lblBirth.setFont(new Font("Iosevka", Font.PLAIN, 14));
		lblBirth.setBounds(250, 14, 70, 16);
		contentPane.add(lblBirth);
		
		JLabel lblTel = new JLabel("Telefono");
		lblTel.setFont(new Font("Iosevka", Font.PLAIN, 14));
		lblTel.setBounds(250, 42, 70, 16);
		contentPane.add(lblTel);
		
		JLabel lblDirec = new JLabel("Direccion");
		lblDirec.setFont(new Font("Iosevka", Font.PLAIN, 14));
		lblDirec.setBounds(250, 72, 70, 16);
		contentPane.add(lblDirec);
		
		JLabel lblDni = new JLabel("Dni");
		lblDni.setFont(new Font("Iosevka", Font.PLAIN, 14));
		lblDni.setBounds(491, 14, 54, 16);
		contentPane.add(lblDni);
		
		JLabel lblSexo = new JLabel("Sexo");
		lblSexo.setFont(new Font("Iosevka", Font.PLAIN, 14));
		lblSexo.setBounds(491, 42, 54, 16);
		contentPane.add(lblSexo);
		
		JLabel lblGusto = new JLabel("Gusto");
		lblGusto.setFont(new Font("Iosevka", Font.PLAIN, 14));
		lblGusto.setBounds(491, 70, 54, 16);
		contentPane.add(lblGusto);
		
		txtid = new JTextField();
		txtid.setBounds(82, 10, 125, 20);
		contentPane.add(txtid);
		txtid.setColumns(10);
		
		txtnombres = new JTextField();
		txtnombres.setColumns(10);
		txtnombres.setBounds(82, 38, 125, 20);
		contentPane.add(txtnombres);
		
		txtapellidos = new JTextField();
		txtapellidos.setColumns(10);
		txtapellidos.setBounds(82, 66, 125, 20);
		contentPane.add(txtapellidos);
		
		dcbirthdate = new JDateChooser();
		dcbirthdate.setBounds(322, 8, 125, 20);
		dcbirthdate.setDateFormatString("yyyy-MM-dd");
		contentPane.add(dcbirthdate);
		
		txttelefono = new JTextField();
		txttelefono.setColumns(10);
		txttelefono.setBounds(322, 40, 125, 20);
		contentPane.add(txttelefono);
		
		txtdirec = new JTextField();
		txtdirec.setColumns(10);
		txtdirec.setBounds(322, 70, 125, 20);
		contentPane.add(txtdirec);
		
		txtdni = new JTextField();
		txtdni.setColumns(10);
		txtdni.setBounds(563, 12, 125, 20);
		contentPane.add(txtdni);
		
		txtsexo = new JTextField();
		txtsexo.setColumns(10);
		txtsexo.setBounds(563, 40, 125, 20);
		contentPane.add(txtsexo);
		
		txtgusto = new JTextField();
		txtgusto.setColumns(10);
		txtgusto.setBounds(563, 68, 125, 20);
		contentPane.add(txtgusto);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 125, 678, 325);
		contentPane.add(scrollPane);
		
		// create a table and selection listener
		/*grilla_clientes = new JTable();
		scrollPane.setViewportView(grilla_clientes);
		grilla_clientes.getSelectionModel().addListSelectionListener(e -> {
			if (!e.getValueIsAdjusting() && grilla_clientes.getSelectedRow() != -1) {
				int fila = grilla_clientes.getSelectedRow();
				txtid.setText(grilla_clientes.getValueAt(fila, 0).toString());
				txtnombres.setText(grilla_clientes.getValueAt(fila, 1).toString());
				txtapellidos.setText(grilla_clientes.getValueAt(fila, 2).toString());
				dcbirthdate.setText(grilla_clientes.getValueAt(fila, 3).toString());
				txttelefono.setText(grilla_clientes.getValueAt(fila, 4).toString());
				txtdirec.setText(grilla_clientes.getValueAt(fila, 5).toString());
				txtdni.setText(grilla_clientes.getValueAt(fila, 6).toString());
				txtsexo.setText(grilla_clientes.getValueAt(fila, 7).toString());
				txtgusto.setText(grilla_clientes.getValueAt(fila, 8).toString());
			}
		});
		*/
		
		grilla_clientes = new JTable();
		scrollPane.setViewportView(grilla_clientes);

		grilla_clientes.getSelectionModel().addListSelectionListener(e -> {
		    if (!e.getValueIsAdjusting() && grilla_clientes.getSelectedRow() != -1) {
		        int fila = grilla_clientes.getSelectedRow();
		        cargarDatosFila(fila);
		    }
		});
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.setFont(new Font("Iosevka", Font.PLAIN, 14));
		btnGuardar.setBounds(12, 462, 94, 26);
		contentPane.add(btnGuardar);
		btnGuardar.addActionListener(e -> {
			try {
				guardarCliente();
				cargarClientes();
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		});
		
		JButton btnModificar = new JButton("Modificar");
		btnModificar.setFont(new Font("Iosevka", Font.PLAIN, 14));
		btnModificar.setBounds(118, 462, 94, 26);
		contentPane.add(btnModificar);
		btnModificar.addActionListener(e -> {
			try {
				modificarCliente();
				cargarClientes();
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		});
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.setFont(new Font("Iosevka", Font.PLAIN, 14));
		btnEliminar.setBounds(224, 462, 94, 26);
		contentPane.add(btnEliminar);
		btnEliminar.addActionListener(e -> {
			try {
				eliminarCliente();
				cargarClientes();
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		});
		
		JButton btnAtras = new JButton("Atras");
		btnAtras.setFont(new Font("Iosevka", Font.PLAIN, 14));
		btnAtras.setBounds(594, 462, 94, 26);
		contentPane.add(btnAtras);
		btnAtras.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				FMenu fmenu = new FMenu();
				fmenu.setVisible(true);
				dispose();
			}
		});
		
		// initialization load table
		try {
			cargarClientes();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	private void cargarDatosFila(int fila) {
	    txtid.setText(grilla_clientes.getValueAt(fila, 0).toString());
	    txtnombres.setText(grilla_clientes.getValueAt(fila, 1).toString());
	    txtapellidos.setText(grilla_clientes.getValueAt(fila, 2).toString());

	    // Conversión segura de la fecha
	    String fechaTexto = grilla_clientes.getValueAt(fila, 3).toString();
	    try {
	        java.util.Date fecha = new SimpleDateFormat("yyyy-MM-dd").parse(fechaTexto);
	        dcbirthdate.setDate(fecha);
	    } catch (ParseException ex) {
	        ex.printStackTrace(); // Log de error. También podrías notificar al usuario.
	    }

	    txttelefono.setText(grilla_clientes.getValueAt(fila, 4).toString());
	    txtdirec.setText(grilla_clientes.getValueAt(fila, 5).toString());
	    txtdni.setText(grilla_clientes.getValueAt(fila, 6).toString());
	    txtsexo.setText(grilla_clientes.getValueAt(fila, 7).toString());
	    txtgusto.setText(grilla_clientes.getValueAt(fila, 8).toString());
	}

	private void guardarCliente() throws SQLException {
		Cliente cli = new Cliente();
		// obligar no poner el campo con un valor para el id
		if (!txtid.getText().trim().isEmpty()) {
			JOptionPane.showMessageDialog(null,
				"El campo ID se autogenera. Déjalo vacío.",
				"Aviso",
				JOptionPane.INFORMATION_MESSAGE);
			txtid.setText(""); // Limpiar el campo si es necesario
		}
		cli.setNombre(txtnombres.getText());
		cli.setApellido(txtapellidos.getText());
		cli.setBirthDate(dcbirthdate.getDate());
		cli.setTelefono(txttelefono.getText());
		cli.setDireccion(txtdirec.getText());
		cli.setDni(txtdni.getText());
		cli.setSexo(txtsexo.getText());
		cli.setGusto(txtgusto.getText());
		
		ICliente logica = new LCliente();
		logica.guardar(cli);
		JOptionPane.showMessageDialog(this, "Cliente guardado exitosamente.");
	}


	private void modificarCliente() throws SQLException {
		Cliente cli = new Cliente();
		cli.setNombre(txtnombres.getText());
		cli.setApellido(txtapellidos.getText());
		cli.setBirthDate(dcbirthdate.getDate());
		cli.setTelefono(txttelefono.getText());
		cli.setDireccion(txtdirec.getText());
		cli.setDni(txtdni.getText());
		cli.setSexo(txtsexo.getText());
		cli.setGusto(txtgusto.getText());
		ICliente log = new LCliente();
		log.modificar(cli);
		JOptionPane.showMessageDialog(null, "Datos modificados");
	}

	private void eliminarCliente() throws SQLException {
		String id = txtid.getText();
		if (id.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Seleccione un cliente para eliminar.");
			return;
		}
		ICliente log = new LCliente();
		log.eliminar(id);
		JOptionPane.showMessageDialog(null, "Cliente eliminado");
	}

	private void cargarClientes() throws SQLException {
		ICliente logica = new LCliente();
		List<Cliente> lista = logica.cargar();

		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("ID");
		model.addColumn("Nombre");
		model.addColumn("Apellido");
		model.addColumn("Nacimiento");
		model.addColumn("Teléfono");
		model.addColumn("Dirección");
		model.addColumn("DNI");
		model.addColumn("Sexo");
		model.addColumn("Gusto");

		for (Cliente cli : lista) {
			model.addRow(new Object[]{
				cli.getId_cli(),
				cli.getNombre(),
				cli.getApellido(),
				cli.getBirthDate(),
				cli.getTelefono(),
				cli.getDireccion(),
				cli.getDni(),
				cli.getSexo(),
				cli.getGusto()
			});
		}
		grilla_clientes.setModel(model);
	}

}
