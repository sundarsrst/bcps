package com.splasher;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JProgressBar;
import java.awt.Font;
import java.awt.Color;

public class Screen extends JFrame {

	public JPanel contentPane;
	public javax.swing.JProgressBar progressBar;
	public JProgressBar progressBar_1;
	public javax.swing.JLabel label;

	
	//public javax.swing.JLabel
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Screen frame = new Screen();
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
	public Screen() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 480);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 668, 480);
		contentPane.add(panel);
		panel.setLayout(null);
		
		progressBar_1 = new JProgressBar();
		progressBar_1.setBounds(39, 83, 531, 9);
		panel.add(progressBar_1);
		
		JLabel lblLoading = new JLabel("Loading...");
		lblLoading.setForeground(Color.ORANGE);
		lblLoading.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 17));
		lblLoading.setBounds(239, 11, 162, 56);
		panel.add(lblLoading);
		
		JLabel label = new JLabel("");
		label.setBounds(0, 0, 668, 480);
		label.setIcon(new ImageIcon(Screen.class.getResource("/com/splasher/bcps2.jpg")));
		panel.add(label);
	}
}
