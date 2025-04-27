package presentacion;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import entidades.ReporteCorrRed;
import entidades.CliSocial;
import entidades.CliCorreo;
import interfaces.ICliCorreo;
import interfaces.ICliSocial;
import interfaces.IReporteCorrRed;
import logica.LCliCorreo;
import logica.LCliSocial;
import logica.LReporteCorrRed;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.sql.SQLException;
import java.util.List;

public class FCliAsigMedia extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtidc;
	private JTextField txtcorreoc;
	private JTextField txtprovc;
	private JTextField txtidclic;
	private JTextField txtidr;
	private JTextField txtuserr;
	private JTextField txtprovr;
	private JTextField txtidclir;
	private JTable grilla_SocialCorreo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FCliAsigMedia frame = new FCliAsigMedia();
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
	public FCliAsigMedia() {
		setTitle("Mantenimiento Correos y Redes Sociales");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblIdCliC = new JLabel("Cliente");
		lblIdCliC.setFont(new Font("Iosevka", Font.PLAIN, 14));
		lblIdCliC.setBounds(78, 124, 54, 16);
		contentPane.add(lblIdCliC);
		
		JLabel lblIdC = new JLabel("Id");
		lblIdC.setFont(new Font("Iosevka", Font.PLAIN, 14));
		lblIdC.setBounds(78, 40, 54, 16);
		contentPane.add(lblIdC);
		
		JLabel lblCorreo = new JLabel("Correo");
		lblCorreo.setFont(new Font("Iosevka", Font.PLAIN, 14));
		lblCorreo.setBounds(78, 68, 54, 16);
		contentPane.add(lblCorreo);
		
		JLabel lblProvC = new JLabel("Proveedor");
		lblProvC.setFont(new Font("Iosevka", Font.PLAIN, 14));
		lblProvC.setBounds(78, 96, 54, 16);
		contentPane.add(lblProvC);
		
		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setFont(new Font("Iosevka", Font.PLAIN, 14));
		lblUsuario.setBounds(401, 68, 54, 16);
		contentPane.add(lblUsuario);
		
		JLabel lblIdR = new JLabel("Id");
		lblIdR.setFont(new Font("Iosevka", Font.PLAIN, 14));
		lblIdR.setBounds(401, 40, 54, 16);
		contentPane.add(lblIdR);
		
		JLabel lblIdCliR = new JLabel("Cliente");
		lblIdCliR.setFont(new Font("Iosevka", Font.PLAIN, 14));
		lblIdCliR.setBounds(401, 124, 54, 16);
		contentPane.add(lblIdCliR);
		
		JLabel lblProvR = new JLabel("Proveedor");
		lblProvR.setFont(new Font("Iosevka", Font.PLAIN, 14));
		lblProvR.setBounds(401, 96, 54, 16);
		contentPane.add(lblProvR);
		
		JLabel lblAsignarCorreos = new JLabel("Asignar Correos");
		lblAsignarCorreos.setBounds(78, 12, 150, 16);
		contentPane.add(lblAsignarCorreos);
		
		JLabel lblAsignarRedesSociales = new JLabel("Asignar Redes Sociales");
		lblAsignarRedesSociales.setBounds(401, 12, 150, 16);
		contentPane.add(lblAsignarRedesSociales);
		
		txtidc = new JTextField();
		txtidc.setBounds(150, 38, 125, 20);
		contentPane.add(txtidc);
		txtidc.setColumns(10);
		
		txtcorreoc = new JTextField();
		txtcorreoc.setColumns(10);
		txtcorreoc.setBounds(150, 66, 125, 20);
		contentPane.add(txtcorreoc);
		
		txtprovc = new JTextField();
		txtprovc.setColumns(10);
		txtprovc.setBounds(150, 94, 125, 20);
		contentPane.add(txtprovc);
		
		txtidclic = new JTextField();
		txtidclic.setColumns(10);
		txtidclic.setBounds(150, 122, 125, 20);
		contentPane.add(txtidclic);
		
		txtidr = new JTextField();
		txtidr.setColumns(10);
		txtidr.setBounds(473, 38, 125, 20);
		contentPane.add(txtidr);
		
		txtuserr = new JTextField();
		txtuserr.setColumns(10);
		txtuserr.setBounds(473, 66, 125, 20);
		contentPane.add(txtuserr);
		
		txtprovr = new JTextField();
		txtprovr.setColumns(10);
		txtprovr.setBounds(473, 94, 125, 20);
		contentPane.add(txtprovr);
		
		txtidclir = new JTextField();
		txtidclir.setColumns(10);
		txtidclir.setBounds(473, 122, 125, 20);
		contentPane.add(txtidclir);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 194, 676, 256);
		contentPane.add(scrollPane);
		
		grilla_SocialCorreo = new JTable();
		scrollPane.setViewportView(grilla_SocialCorreo);
		
		JButton btnGuardarC = new JButton("Guardar");
		btnGuardarC.setFont(new Font("Iosevka", Font.PLAIN, 14));
		btnGuardarC.setBounds(12, 156, 94, 26);
		contentPane.add(btnGuardarC);
		btnGuardarC.addActionListener(e -> {
			try {
				guardarCliCorreo();
				cargarCliCorreoRedes();
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		});
		
		JButton btnModificarC = new JButton("Modificar");
		btnModificarC.setFont(new Font("Iosevka", Font.PLAIN, 14));
		btnModificarC.setBounds(118, 156, 94, 26);
		contentPane.add(btnModificarC);
		btnModificarC.addActionListener(e -> {
			try {
				modificarCliCorreo();
				cargarCliCorreoRedes();
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		});
		
		JButton btnEliminarC = new JButton("Eliminar");
		btnEliminarC.setFont(new Font("Iosevka", Font.PLAIN, 14));
		btnEliminarC.setBounds(224, 156, 94, 26);
		contentPane.add(btnEliminarC);
		btnEliminarC.addActionListener(e -> {
			try {
				eliminarCliCorreo();
				cargarCliCorreoRedes();
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		});
		
		JButton btnAtras = new JButton("Atras");
		btnAtras.setFont(new Font("Iosevka", Font.PLAIN, 14));
		btnAtras.setBounds(594, 462, 94, 26);
		contentPane.add(btnAtras);
		
		JButton btnEliminarR = new JButton("Eliminar");
		btnEliminarR.setFont(new Font("Iosevka", Font.PLAIN, 14));
		btnEliminarR.setBounds(594, 156, 94, 26);
		contentPane.add(btnEliminarR);
		btnEliminarR.addActionListener(e -> {
			try {
				eliminarCliRed();
				cargarCliCorreoRedes();
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		});
		
		JButton btnModificarR = new JButton("Modificar");
		btnModificarR.setFont(new Font("Iosevka", Font.PLAIN, 14));
		btnModificarR.setBounds(488, 156, 94, 26);
		contentPane.add(btnModificarR);
		btnModificarR.addActionListener(e -> {
			try {
				modificarCliRed();
				cargarCliCorreoRedes();
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		});
		
		JButton btnGuardarR = new JButton("Guardar");
		btnGuardarR.setFont(new Font("Iosevka", Font.PLAIN, 14));
		btnGuardarR.setBounds(382, 156, 94, 26);
		contentPane.add(btnGuardarR);
		btnGuardarC.addActionListener(e -> {
			try {
				guardarCliRed();
				cargarCliCorreoRedes();
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		});
		
		// initialization load table
		try {
			cargarCliCorreoRedes();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	private void guardarCliRed() throws SQLException {
		// TODO Auto-generated method stub
		CliSocial clisocial = new CliSocial(0,
				txtidr.getText(),
				txtuserr.getText(),
				txtprovr.getText(),
				txtidclir.getText()
				);
		ICliSocial log = new LCliSocial();
		log.guardar(clisocial);
		JOptionPane.showMessageDialog(null, "Datos guardados");
	}

	private void modificarCliRed() throws SQLException {
		// TODO Auto-generated method stub
		CliSocial clisocial = new CliSocial(0,
				txtidr.getText(),
				txtuserr.getText(),
				txtprovr.getText(),
				txtidclir.getText()
				);
		ICliSocial log = new LCliSocial();
		log.modificar(clisocial);
		JOptionPane.showMessageDialog(null, "Datos modificados");
	}

	private void eliminarCliRed() throws SQLException {
		// TODO Auto-generated method stub
		String id = txtidr.getText();
		if (id.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Seleccione para eliminar.");
			return;
		}
		ICliSocial log = new LCliSocial();
		log.eliminar(id);
		JOptionPane.showMessageDialog(null, "Eliminado");
	}

	private void eliminarCliCorreo() throws SQLException {
		// TODO Auto-generated method stub
		String id = txtidc.getText();
		if (id.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Seleccione para eliminar.");
			return;
		}
		ICliCorreo log = new LCliCorreo();
		log.eliminar(id);
		JOptionPane.showMessageDialog(null, "Eliminado");
	}

	private void modificarCliCorreo() throws SQLException {
		// TODO Auto-generated method stub
		CliCorreo clicorreo = new CliCorreo(0,
				txtidc.getText(),
				txtcorreoc.getText(),
				txtprovc.getText(),
				txtidclic.getText()
				);
		ICliCorreo log = new LCliCorreo();
		log.modificar(clicorreo);
		JOptionPane.showMessageDialog(null, "Modificado");
	}

	private void guardarCliCorreo() throws SQLException {
		// TODO Auto-generated method stub
		CliCorreo clicorreo = new CliCorreo(0,
				txtidc.getText(),
				txtcorreoc.getText(),
				txtprovc.getText(),
				txtidclic.getText()
				);
		ICliCorreo log = new LCliCorreo();
		log.guardar(clicorreo);
		JOptionPane.showMessageDialog(null, "Guardado");
	}

	private void cargarCliCorreoRedes() throws SQLException {
		// TODO Auto-generated method stub
		DefaultTableModel model = new DefaultTableModel(null,
				new String[]{"ID", "CLIENTE", "CORREOS", "REDES SOCIALES"});
		IReporteCorrRed log = new LReporteCorrRed();
		List<ReporteCorrRed> reportecoreds = log.cargar();
		for (ReporteCorrRed reportecored : reportecoreds) {
			model.addRow(new Object[]{
					reportecored.getId_cli(),
					reportecored.getCliente(),
					reportecored.getCorreos(),
					reportecored.getRedes()
			});
		}
		grilla_SocialCorreo.setModel(model);
	}
}
