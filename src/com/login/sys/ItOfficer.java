package com.login.sys;
import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.xml.bind.ParseConversionEvent;

import com.training.module.*;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JWindow;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class ItOfficer extends JFrame {

	private JPanel contentPane;
	private JTextField txtStartNumber;
	private JTextField txtEndNumber;
	int part1, part2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ItOfficer frame = new ItOfficer();
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
	public ItOfficer() {
		setTitle("Train data");
		setIconImage(Toolkit.getDefaultToolkit().getImage(ItOfficer.class.getResource("/com/splasher/bcps.jpg")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 200, 500, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblStartNumber = new JLabel("start number");
		lblStartNumber.setBounds(104, 33, 89, 14);
		contentPane.add(lblStartNumber);
		
		JLabel lblEndNumber = new JLabel("end number");
		lblEndNumber.setBounds(104, 75, 89, 14);
		contentPane.add(lblEndNumber);
		
		txtStartNumber = new JTextField();
		txtStartNumber.setBounds(257, 30, 129, 20);
		contentPane.add(txtStartNumber);
		txtStartNumber.setColumns(10);
		
		txtEndNumber = new JTextField();
		txtEndNumber.setBounds(257, 72, 129, 20);
		contentPane.add(txtEndNumber);
		txtEndNumber.setColumns(10);
		
		JButton btnGo = new JButton("Start training");
		btnGo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//String firsttext = txtStartNumber.getText();
				//String secondtext = txtEndNumber.getText();
				//System.out.println("firt="+firsttext);
				//int firstnum = Integer.parseInt(firsttext);
				int firstnum = Integer.parseInt(txtStartNumber.getText());
				//System.out.println("first after integer converted="+firstnum);
				//int secondnum = Integer.parseInt(secondtext);
				int secondnum = Integer.parseInt(txtEndNumber.getText());
				
				/** train the svm **/
				First fst = new First(firstnum, secondnum);		
				
				

			}
		});
		btnGo.setBounds(248, 122, 138, 23);
		contentPane.add(btnGo);
		
		JButton btnSignOut = new JButton("Sign out");
		btnSignOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Loginn window = new Loginn();
				window.frmBreastCancerPrediction.setVisible(true);
				dispose();
			}
		});
		btnSignOut.setBounds(254, 193, 89, 23);
		contentPane.add(btnSignOut);
		
		JButton btnNewButton = new JButton("Reset");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtStartNumber.setText(null);
				txtEndNumber.setText(null);
			}
		});
		btnNewButton.setBounds(104, 193, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnExit.setBounds(385, 193, 89, 23);
		contentPane.add(btnExit);
	}
}
