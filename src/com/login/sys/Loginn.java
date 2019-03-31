package com.login.sys;

import java.sql.*;
import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Color;
import javax.swing.JSeparator;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Toolkit;
import javax.swing.LayoutStyle.ComponentPlacement;

import com.sun.javafx.embed.swing.Disposer;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Loginn {

	public JFrame frmBreastCancerPrediction;
	private JTextField txtUsername;
	private JPasswordField txtPassword;
	Connection con;
	PreparedStatement pst;
	ResultSet rs;	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Loginn window = new Loginn();
					window.frmBreastCancerPrediction.setVisible(true);
					
					
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Loginn() {
		
		initialize();
		
	
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmBreastCancerPrediction = new JFrame();
		frmBreastCancerPrediction.setIconImage(Toolkit.getDefaultToolkit().getImage(Loginn.class.getResource("/com/splasher/bcps.jpg")));
		frmBreastCancerPrediction.setTitle("Breast Cancer Prediction System");
		frmBreastCancerPrediction.getContentPane().setForeground(Color.BLUE);
		frmBreastCancerPrediction.setBounds(450, 180, 500, 460);
		
		
		frmBreastCancerPrediction.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setLocationRelativeTo(null);
		
		
		JLabel lblLoginPage = new JLabel("Login to continue");
		lblLoginPage.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 27));
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setFont(new Font("Tahoma", Font.BOLD, 17));
		
		txtUsername = new JTextField();
		txtUsername.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 17));
		
		txtPassword = new JPasswordField();
		
		JLabel lblOptions = new JLabel("Options");
		lblOptions.setFont(new Font("Tahoma", Font.BOLD, 17));
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 17));
		comboBox.addItem("select");
		comboBox.addItem("doctor");
		comboBox.addItem("itofficer");
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			private Component rootPane;

			public void actionPerformed(ActionEvent arg0) {
				String usrname = txtUsername.getText();
				String pword = txtPassword.getText();
				String option= comboBox.getSelectedItem().toString();
				if(usrname.equals("")||pword.equals("")||option.equals("select")) {
					JOptionPane.showMessageDialog(rootPane, "some fields are empty", "error", 1);
					
				}else {
					
					try {
						con = Connectionz.getConnection();
						pst=con.prepareStatement("select * from syslogin where uname=? and pwd=?");
						pst.setString(1, usrname);
						pst.setString(2, pword);
						rs=pst.executeQuery();
						
						if(rs.next()) {
							String s1 = rs.getString("options");
							String un=rs.getString("uname");
							if(option.equalsIgnoreCase("Doctor") && s1.equalsIgnoreCase("doctor")) {
								Doctor doc= new Doctor();
								doc.setVisible(true);
							
							}
							if(option.equalsIgnoreCase("Itofficer") && s1.equalsIgnoreCase("itofficer")) {
								ItOfficer itoff=new ItOfficer();
								itoff.setVisible(true);
							
							}
							frmBreastCancerPrediction.dispose();
							
						}
						else {
							JOptionPane.showMessageDialog(rootPane, "user name or password error", "login error", 1);
							
						}
						
					} catch (Exception ex) {
						System.out.println(""+ex);
						
					}
					
					
				}
				
				
				
			}
		});
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtPassword.setText(null);
				txtUsername.setText(null);
			}
		});
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		JSeparator separator = new JSeparator();
		
		JSeparator separator_1 = new JSeparator();
		
		JLabel lblSignUpTo = new JLabel("Sign Up to a new account");
		lblSignUpTo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				SignUpForm sgn = new SignUpForm();
				sgn.setVisible(true);
				frmBreastCancerPrediction.dispose();
			
				//this.window.dispose();
				//System.exit(0);
				//dispose();
			//	frame.dispose();
			}
		});
		GroupLayout groupLayout = new GroupLayout(frmBreastCancerPrediction.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(121)
							.addComponent(lblLoginPage, GroupLayout.PREFERRED_SIZE, 248, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(26)
							.addComponent(separator_1, GroupLayout.PREFERRED_SIZE, 398, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(56)
							.addComponent(lblUsername, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(56)
							.addComponent(txtUsername, GroupLayout.PREFERRED_SIZE, 206, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(56)
							.addComponent(lblPassword, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(56)
							.addComponent(txtPassword, GroupLayout.PREFERRED_SIZE, 206, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(56)
							.addComponent(lblOptions, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(56)
							.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 118, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(26)
							.addComponent(separator, GroupLayout.PREFERRED_SIZE, 398, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(60, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(56)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblSignUpTo)
							.addContainerGap())
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btnLogin, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 61, Short.MAX_VALUE)
							.addComponent(btnReset, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
							.addGap(49)
							.addComponent(btnExit, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
							.addGap(51))))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(12)
					.addComponent(lblLoginPage, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
					.addGap(14)
					.addComponent(separator_1, GroupLayout.PREFERRED_SIZE, 8, GroupLayout.PREFERRED_SIZE)
					.addGap(32)
					.addComponent(lblUsername, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE)
					.addGap(11)
					.addComponent(txtUsername, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(31)
					.addComponent(lblPassword, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
					.addGap(11)
					.addComponent(txtPassword, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(11)
					.addComponent(lblOptions, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
					.addGap(11)
					.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
					.addGap(11)
					.addComponent(separator, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE)
					.addGap(31)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(btnLogin)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(btnExit)
							.addComponent(btnReset)))
					.addGap(18)
					.addComponent(lblSignUpTo)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		frmBreastCancerPrediction.getContentPane().setLayout(groupLayout);
	}

	public void setvisible(boolean b) {
		// TODO Auto-generated method stub
		
	}

	

	
}
