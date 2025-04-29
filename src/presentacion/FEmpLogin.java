package presentacion;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logica.LEmpleado;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;

public class FEmpLogin extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtuser;
	private JTextField txtpass;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FEmpLogin frame = new FEmpLogin();
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
	public FEmpLogin() {
		setTitle("Inicio de Sesion");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setBounds(126, 103, 100, 16);
		contentPane.add(lblUsuario);
		
		JLabel lblContrase = new JLabel("Contraseña");
		lblContrase.setBounds(126, 131, 100, 16);
		contentPane.add(lblContrase);
		
		txtuser = new JTextField();
		txtuser.setBounds(214, 101, 94, 20);
		contentPane.add(txtuser);
		txtuser.setColumns(10);
		
		txtpass = new JPasswordField();
		txtpass.setBounds(214, 129, 94, 20);
		contentPane.add(txtpass);
		txtpass.setColumns(10);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setBounds(214, 159, 94, 26);
		contentPane.add(btnSubmit);
		btnSubmit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String usuario = txtuser.getText();
				String passwd = new String(((JPasswordField) txtpass).getPassword());


				LEmpleado logicaEmpleado = new LEmpleado();
				try {
					boolean loginExitoso = logicaEmpleado.validar(usuario, passwd);
					if (loginExitoso) {
						JOptionPane.showMessageDialog(null, "Login correcto");
						FMenu menu = new FMenu();
						menu.setVisible(true);
					} else {
						JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrectos");
					}
				} catch (SQLException ex) {
					ex.printStackTrace();
				}
			}
		});
		
	}
	
}
