package presentacion;

import java.awt.EventQueue;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import entidades.ReporteEmpCli;
import entidades.ReportePubCli;
import interfaces.IReporteEmpCli;
import interfaces.IReportePubCli;
import logica.LReporteEmpCli;
import logica.LReportePubCli;

import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;

public class FReportesClientes extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtempclinom;
	private JTextField txtpubclinom;
	private JTable grilla_empcli;
	private JTable grilla_pubcli;

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
		scrollPane.setBounds(12, 68, 332, 373);
		contentPane.add(scrollPane);
		
		grilla_empcli = new JTable();
		scrollPane.setViewportView(grilla_empcli);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(356, 68, 332, 373);
		contentPane.add(scrollPane_1);
		
		grilla_pubcli = new JTable();
		scrollPane_1.setViewportView(grilla_pubcli);
		
		txtempclinom = new JTextField();
		txtempclinom.setBounds(12, 36, 64, 20);
		contentPane.add(txtempclinom);
		txtempclinom.setColumns(10);
		
		JButton btnselectemp = new JButton("Select");
		btnselectemp.setBounds(88, 30, 94, 26);
		contentPane.add(btnselectemp);
		
		txtpubclinom = new JTextField();
		txtpubclinom.setBounds(356, 36, 64, 20);
		contentPane.add(txtpubclinom);
		txtpubclinom.setColumns(10);
		
		JButton btnselectpub = new JButton("Select");
		btnselectpub.setBounds(432, 30, 94, 26);
		contentPane.add(btnselectpub);
		
		JButton btnAtras = new JButton("Atras");
		btnAtras.setBounds(594, 462, 94, 26);
		contentPane.add(btnAtras);
		
		try { CargarPubCli(); CargarEmpCli(); CargarPubCli(); } 
		catch (SQLException e) { e.printStackTrace(); }
	}
	
	private void CargarEmpCli() throws SQLException {
		// TODO Auto-generated method stub
		DefaultTableModel model = new DefaultTableModel(null,
				new String[] { "EMP ID", "EMPLEADO", "CLIENTE ID", "CLIENTE", "FECHA" });
		IReporteEmpCli log = new LReporteEmpCli();
		List<ReporteEmpCli> repempclis = log.cargar();
		for (ReporteEmpCli repemcli : repempclis) {
			model.addRow(new Object[] {
					repemcli.getId_emp(),
					repemcli.getNombre_emp(),
					repemcli.getId_cli(),
					repemcli.getNombre_cli(),
					repemcli.getFecha(),
					
			});
		}
		grilla_empcli.setModel(model);
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
		grilla_pubcli.setModel(model);
		
	}
}
