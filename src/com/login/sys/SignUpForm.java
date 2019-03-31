package com.login.sys;
import java.sql.*;


import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.sun.glass.ui.Window.Level;
import com.sun.istack.internal.logging.Logger;

import java.awt.Color;
import java.awt.Button;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import com.login.sys.Loginn;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class SignUpForm extends JFrame {

	private JPanel contentPane;
	private JTextField txtUname;
	private JPasswordField txtPwd;
	private JPasswordField txtRPwd;
	PreparedStatement ps;
	Connection con;
	private JComboBox txtcombobox;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SignUpForm frame = new SignUpForm();
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
	public SignUpForm() {
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 200, 730, 463);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		panel.setBounds(0, 0, 325, 424);
		contentPane.add(panel);
		
		JComboBox<String> txtcombobox = new JComboBox<String>();
		//txtcombobox.setModel(new DefaultComboBoxModel(new String[] {"Doctor\t", "Itofficer"}));
		txtcombobox.addItem("Itofficer");
		txtcombobox.addItem("Doctor");
		txtcombobox.setBounds(613, 306, 75, 20);
		contentPane.add(txtcombobox);
		
		Button button = new Button("Sign Up");
		button.setFont(new Font("Dialog", Font.PLAIN, 16));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String username =txtUname.getText();
				String password = String.valueOf(txtPwd.getText());
				String rpassword = String.valueOf(txtRPwd.getText());
				//String value = txtcombobox.getSelectedItem().toString();
				//	String value= String.valueOf(txtcombobox.getSelectedItem());
					//String value = String.valueOf(txtcombobox.getSelectedItem());
				//String opt= String.valueOf(txtcombobox.getSelectedItem());
				//String value = txtcombobox.getSelectedItem().toString();	
				//String value = (String) txtcombobox.getSelectedItem();
				String value = (String) txtcombobox.getSelectedItem();
				System.out.println("value = "+value);
				
				if(username.equals("")) {
					JOptionPane.showMessageDialog(null, "Add A Username");
				}
				else if(password.equals("")) {
					JOptionPane.showMessageDialog(null, "Add A Password");
				}
//				else if(!rpassword.equals("rpassword")) {
//					JOptionPane.showMessageDialog(null, "Retype the Password");
//				}
				else {
				try {
					//String query= "INSERT INTO `itofficerlogin`(`uname`, `pwd`, `rpwd`, 'options') VALUES (?,?,?)";
					String query= "INSERT INTO `syslogin`(`uname`, `pwd`, `rpwd`, `options`) VALUES (?,?,?,?)";
					ps = Connectionz.getConnection().prepareStatement(query);
					ps.setString(1, username);
					ps.setString(2, password); 
					ps.setString(3, rpassword);
					ps.setString(4, value);
					
					if(ps.executeUpdate() > 0) 
					{
						JOptionPane.showMessageDialog(null, "New User added");
					}
					
					
					
					
				} catch (Exception e) {
					java.util.logging.Logger.getLogger(SignUpForm.class.getName(),null).log(java.util.logging.Level.SEVERE, null, e);
						
				}
				}
			}
		});
		button.setForeground(Color.WHITE);
		button.setBackground(new Color(241,57,83));
		button.setBounds(384, 347, 280, 35);
		contentPane.add(button);
		
		txtUname = new JTextField();
		txtUname.setBounds(384, 67, 280, 35);
		contentPane.add(txtUname);
		txtUname.setColumns(10);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblUsername.setBounds(384, 29, 117, 27);
		contentPane.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPassword.setBounds(384, 124, 117, 27);
		contentPane.add(lblPassword);
		
		JLabel lblReenterPassword = new JLabel("Re-enter Password");
		lblReenterPassword.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblReenterPassword.setBounds(384, 208, 162, 27);
		contentPane.add(lblReenterPassword);
		
		txtPwd = new JPasswordField();
		txtPwd.setBounds(384, 162, 280, 35);
		contentPane.add(txtPwd);
		
		txtRPwd = new JPasswordField();
		txtRPwd.setBounds(384, 246, 280, 35);
		contentPane.add(txtRPwd);
		
		JLabel lblAlreadyHaveAn = new JLabel("Already have an account? Log in here.");
		lblAlreadyHaveAn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Loginn window = new Loginn();
				window.frmBreastCancerPrediction.setVisible(true);
				dispose();
			}
		});
		lblAlreadyHaveAn.setFont(new Font("Tahoma", Font.ITALIC, 14));
		lblAlreadyHaveAn.setBounds(407, 388, 246, 14);
		contentPane.add(lblAlreadyHaveAn);
		
		JLabel lblOptions = new JLabel("Options");
		lblOptions.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblOptions.setBounds(384, 301, 82, 27);
		contentPane.add(lblOptions);
		
		
	}
}
