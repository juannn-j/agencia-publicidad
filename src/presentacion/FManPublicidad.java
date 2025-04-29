package presentacion;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import entidades.Cliente2;
import entidades.PubCliente;
import entidades.Publicidad;
import entidades.ReportePubCli;
import interfaces.ICliente2;
import interfaces.IPubCliente;
import interfaces.IPublicidad;
import interfaces.IReportePubCli;
import logica.LCliente2;
import logica.LPubCliente;
import logica.LPublicidad;
import logica.LReportePubCli;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JTable;

import com.toedter.calendar.JDateChooser;
import java.text.SimpleDateFormat;

public class FManPublicidad extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtid;
	private JDateChooser dcfecha;
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
		txtid.setBounds(84, 40, 76, 20);
		contentPane.add(txtid);
		txtid.setColumns(10);
		
		dcfecha = new JDateChooser();
		dcfecha.setBounds(84, 66, 76, 20); // tamaño más amplio y legible
		dcfecha.setDateFormatString("yyyy-MM-dd"); // formato compatible con SQL
		contentPane.add(dcfecha);

		
		txtemp = new JTextField();
		txtemp.setBounds(84, 94, 76, 20);
		contentPane.add(txtemp);
		txtemp.setColumns(10);
		
		txtcli = new JTextField();
		txtcli.setBounds(84, 122, 76, 20);
		contentPane.add(txtcli);
		txtcli.setColumns(10);
		
		txtpub = new JTextField();
		txtpub.setBounds(84, 150, 76, 20);
		contentPane.add(txtpub);
		txtpub.setColumns(10);
		
		JLabel lblClientes = new JLabel("Clientes");
		lblClientes.setBounds(182, 12, 148, 16);
		contentPane.add(lblClientes);
		
		JLabel lblPublicidades = new JLabel("Publicidades");
		lblPublicidades.setBounds(369, 12, 148, 16);
		contentPane.add(lblPublicidades);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(182, 40, 175, 130);
		contentPane.add(scrollPane);
		
		grilla_clientes = new JTable();
		scrollPane.setViewportView(grilla_clientes);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(369, 40, 319, 130);
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
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try { guardarPubEmpCli();  CargarPubCli(); }
				catch (SQLException e1) { e1.printStackTrace();}
			}

			private void guardarPubEmpCli() throws SQLException {
				// TODO Auto-generated method stub
				String fechaStr = new SimpleDateFormat("yyyy-MM-dd").format(dcfecha.getDate());
				PubCliente pubcliente = new PubCliente(0, fechaStr, 0, 0, 0);
				IPubCliente log = new LPubCliente();
				log.guardar(pubcliente);
				JOptionPane.showMessageDialog(null, "Datos guardados");
			}
		});
		
		JButton btnModificar = new JButton("Modificar");
		btnModificar.setBounds(118, 180, 94, 26);
		contentPane.add(btnModificar);
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try { modificarPubEmpCli();  CargarPubCli(); }
				catch (SQLException e1) { e1.printStackTrace();}
			}

			private void modificarPubEmpCli() throws SQLException {
				// TODO Auto-generated method stub
				String fechaStr = new SimpleDateFormat("yyyy-MM-dd").format(dcfecha.getDate());
				PubCliente pubcliente = new PubCliente(0, fechaStr, 0, 0, 0);
				IPubCliente log = new LPubCliente();
				log.guardar(pubcliente);
				JOptionPane.showMessageDialog(null, "Datos modificados");
			}
		});
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(224, 180, 94, 26);
		contentPane.add(btnEliminar);
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try { eliminarPubEmpCli(); CargarPubCli();; }
				catch (SQLException e1) { e1.printStackTrace();}
			}

			private void eliminarPubEmpCli() throws SQLException {
				// TODO Auto-generated method stub
				String id = txtid.getText();
				if (id.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Seleccione para eliminar.");
					return;
				}
				IPubCliente log = new LPubCliente();
				log.eliminar(id);
				JOptionPane.showMessageDialog(null, "Eliminado");

			}
		});
		
		JButton btnAtras = new JButton("Atras");
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
		
		try { CargarPubCli(); CargarClientes2(); CargarPublicidades(); } 
		catch (SQLException e) { e.printStackTrace(); }
	}
	
	private void CargarPubCli() throws SQLException {
		DefaultTableModel model = new DefaultTableModel(null,
				new String[] { "CLIENTE ID", "CLIENTE", "PUB ID", "DESCRIPCION", "TIPO", "FECHA" });
		IReportePubCli log = new LReportePubCli();
		List<ReportePubCli> reppubclis = log.cargar();
		for (ReportePubCli reppbcs : reppubclis) {
			model.addRow(new Object[] {
					reppbcs.getId_cli(),
					reppbcs.getNombre_cli(),
					reppbcs.getId_pub(),
					reppbcs.getDesc_pub(),
					reppbcs.getTipo_pub(),
					reppbcs.getFecha(),
			});
		}
		grilla_asigpubs.setModel(model);
		
	}
	
	private void CargarClientes2() throws SQLException {
		DefaultTableModel model = new DefaultTableModel(null,
				new String[] { "ID", "NOMBRE", "PREFERENCIAS" });
		ICliente2 log = new LCliente2();
		List<Cliente2> clientes2 = log.cargar();
		for (Cliente2 cli2 : clientes2) {
			model.addRow(new Object[] {
					cli2.getId_cli(),
					cli2.getNombre(),
					cli2.getGusto()
			});
		}
		grilla_clientes.setModel(model);
		
	}
	
	private void CargarPublicidades() throws SQLException {
		DefaultTableModel model = new DefaultTableModel(null,
				new String[] { "ID", "DESC", "TIPO", "TELEFONO", "IMAGEN" });
		IPublicidad log = new LPublicidad();
		List<Publicidad> publicidades = log.cargar();
		for (Publicidad pbss : publicidades) {
			model.addRow(new Object[] {
				pbss.getId_pub(),
				pbss.getDesc_pub(),
				pbss.getTipo_pub(),
				pbss.getTelefono(),
				pbss.getImage_pub()
			});
		}
		grilla_publicidades.setModel(model);
		
	}
}
