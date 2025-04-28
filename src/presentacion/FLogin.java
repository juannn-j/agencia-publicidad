package presentacion;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import datos.DB;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FLogin extends JFrame {
	
	Connection cn;
	PreparedStatement ps;
	ResultSet rs;
	DB db;

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtusuario;
	private JPasswordField pwdcont;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FLogin frame = new FLogin();
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
	public FLogin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 603, 421);
		setTitle("Sistema de Agencia de Publicidad");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbliniciarsesion = new JLabel("INICIAR SESIÓN");
		lbliniciarsesion.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lbliniciarsesion.setBounds(238, 11, 123, 39);
		contentPane.add(lbliniciarsesion);
		
		txtusuario = new JTextField();
		txtusuario.setBounds(256, 128, 86, 20);
		contentPane.add(txtusuario);
		txtusuario.setColumns(10);
		
		pwdcont = new JPasswordField();
		pwdcont.setBounds(256, 189, 86, 20);
		contentPane.add(pwdcont);
		
		JLabel lblusuario = new JLabel("Usuario");
		lblusuario.setBounds(196, 98, 46, 14);
		contentPane.add(lblusuario);
		
		JLabel lblcont = new JLabel("Contraseña");
		lblcont.setBounds(196, 164, 46, 14);
		contentPane.add(lblcont);
		
		JButton btningresar = new JButton("Ingresar");
		btningresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				validarUsuario();
			}
		});
		btningresar.setBounds(253, 264, 89, 23);
		contentPane.add(btningresar);
	}
	
	private void validarUsuario() {
		String usuario = txtusuario.getText().trim();
		String contrasena = new String(pwdcont.getPassword());
		
		if (usuario.isEmpty() || contrasena.isEmpty()) {
			JOptionPane.showMessageDialog(this, "Credenciales obligatorias", "Error", JOptionPane.ERROR_MESSAGE);
			return;
		}
		
		try {
			cn = db.conectar();
			String sql = "SELECT id_emp, nombre FROM empleado WHERE usuario = ? AND passwd = ?";
			ps = cn.prepareStatement(sql);
			ps.setString(1, usuario);
			ps.setString(2, contrasena);
			rs = ps.executeQuery();
			
			if (rs.next()) {
				int idEmpleado = rs.getInt("id_emp");
				String nombreEmpleado = rs.getString("nombre");
				//Cerrar Login
				this.dispose();
				//Abrir Menú
				FMenu menu = new FMenu(idEmpleado, nombreEmpleado);
				menu.setVisible(true);
			} else {
				JOptionPane.showMessageDialog(this, "Usuario o contraseña incorrectos", "Error", JOptionPane.ERROR_MESSAGE);
			}
		} catch (SQLException e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(this, "Error al conectar con la DB" + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) rs.close();
				if(ps != null) rs.close();
				if(cn != null) rs.close();
			} catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
	}
}
