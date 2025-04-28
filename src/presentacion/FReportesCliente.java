package presentacion;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JScrollPane;

public class FReportesCliente extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JLabel lblPublicidadesXCliente;
	private JLabel lblEmpleadosXCliente;
	private JTextField textField_1;
	private JLabel lblBuscarPublicidad;
	private JScrollPane scrollPane;
	private JScrollPane scrollPane_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FReportesCliente frame = new FReportesCliente();
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
	public FReportesCliente() {
		setTitle("Reportes");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblBuscarEmpleados = new JLabel("Buscar empleados");
		lblBuscarEmpleados.setBounds(84, 40, 130, 16);
		contentPane.add(lblBuscarEmpleados);
		
		textField = new JTextField();
		textField.setBounds(232, 38, 101, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		lblPublicidadesXCliente = new JLabel("Publicidades x Cliente");
		lblPublicidadesXCliente.setBounds(394, 12, 150, 16);
		contentPane.add(lblPublicidadesXCliente);
		
		lblEmpleadosXCliente = new JLabel("Empleados x Cliente");
		lblEmpleadosXCliente.setBounds(84, 12, 150, 16);
		contentPane.add(lblEmpleadosXCliente);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(542, 38, 101, 20);
		contentPane.add(textField_1);
		
		lblBuscarPublicidad = new JLabel("Buscar Publicidad");
		lblBuscarPublicidad.setBounds(394, 40, 130, 16);
		contentPane.add(lblBuscarPublicidad);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 68, 332, 420);
		contentPane.add(scrollPane);
		
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(356, 68, 332, 420);
		contentPane.add(scrollPane_1);
		setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{contentPane, lblBuscarEmpleados, textField, lblPublicidadesXCliente, lblEmpleadosXCliente, textField_1, lblBuscarPublicidad, scrollPane, scrollPane_1}));
	}

}
