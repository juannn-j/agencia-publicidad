package presentacion;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FMenu extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FMenu frame = new FMenu();
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
	public FMenu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 690, 396);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnSalir = new JButton("SIGN OUT");
		btnSalir.setBounds(537, 11, 89, 23);
		contentPane.add(btnSalir);
		
		JButton btnMantCliente = new JButton("MANTENIMIETO DE CLIENTES");
		btnMantCliente.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {

				FManCliente fmancliente = new FManCliente();
				fmancliente.setVisible(true);
				dispose();
			}
		});
		btnMantCliente.setBounds(45, 45, 213, 54);
		contentPane.add(btnMantCliente);
		
		JButton btnMantCliSocial = new JButton("ADMINISTRAR RED SOCIAL");
		btnMantCliSocial.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FManCliSocialMedia cliente=new FManCliSocialMedia();
				cliente.setVisible(true);
				dispose();
			}
		});
		btnMantCliSocial.setBounds(45, 110, 213, 54);
		contentPane.add(btnMantCliSocial);
		
		JButton btnMantPublicidad = new JButton("ADMINISTRAR PUBLICIDAD");
		btnMantPublicidad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FManPublicidad publicidad = new FManPublicidad();
				publicidad.setVisible(true);
				dispose();
			}
		});
		btnMantPublicidad.setBounds(45, 191, 213, 54);
		contentPane.add(btnMantPublicidad);
		
		JButton btnMantReporte = new JButton("GENERAR REPORTE");
		btnMantReporte.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FReportesClientes repo = new FReportesClientes();
				repo.setVisible(true);
				dispose();
			}
		});
		btnMantReporte.setBounds(402, 222, 146, 54);
		contentPane.add(btnMantReporte);
	}
}
