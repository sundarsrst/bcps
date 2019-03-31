package com.login.sys;
//import Login_Sys.*;


import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import com.breast.diagnosis.*;
import java.awt.Toolkit;
public class Doctor extends JFrame {

	private JPanel contentPane;
	private JTextField txtPatientId;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Doctor frame = new Doctor();
					frame.setVisible(true);
					//frame.dispose();
					//System.exit(0);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Doctor() {
		setTitle("Diagnosis page");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Doctor.class.getResource("/com/splasher/bcps.jpg")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 200, 450, 575);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblPatientId = new JLabel("Patient ID");
		lblPatientId.setBounds(86, 32, 73, 25);
		contentPane.add(lblPatientId);
		
		txtPatientId = new JTextField();
		txtPatientId.setBounds(169, 34, 73, 20);
		contentPane.add(txtPatientId);
		txtPatientId.setColumns(10);
		
		JLabel lblClumpThickness = new JLabel("Clump thickness");
		lblClumpThickness.setBounds(29, 83, 101, 25);
		contentPane.add(lblClumpThickness);
		
		JLabel lblUniformityOfCell = new JLabel("Uniformity of cell size");
		lblUniformityOfCell.setBounds(29, 119, 130, 14);
		contentPane.add(lblUniformityOfCell);
		
		JLabel lblUniformityOfCell_1 = new JLabel("Uniformity of cell shape");
		lblUniformityOfCell_1.setBounds(29, 154, 130, 14);
		contentPane.add(lblUniformityOfCell_1);
		
		JLabel lblMarginalAdhesion = new JLabel("Marginal Adhesion");
		lblMarginalAdhesion.setBounds(29, 195, 130, 14);
		contentPane.add(lblMarginalAdhesion);
		
		JLabel lblSingleEpithelialCell = new JLabel("Single Epithelial cell size");
		lblSingleEpithelialCell.setBounds(29, 237, 130, 14);
		contentPane.add(lblSingleEpithelialCell);
		
		JLabel lblBareNuclei = new JLabel("Bare Nuclei");
		lblBareNuclei.setBounds(29, 279, 112, 14);
		contentPane.add(lblBareNuclei);
		
		JLabel lblBlandChromatin = new JLabel("Bland Chromatin");
		lblBlandChromatin.setBounds(29, 310, 130, 14);
		contentPane.add(lblBlandChromatin);
		
		JLabel lblNormalNuclei = new JLabel("Normal Nuclei");
		lblNormalNuclei.setBounds(29, 347, 130, 14);
		contentPane.add(lblNormalNuclei);
		
		JLabel lblMitoses = new JLabel("Mitoses");
		lblMitoses.setBounds(29, 372, 130, 30);
		contentPane.add(lblMitoses);
		
		JComboBox comboBox = new JComboBox();
		comboBox.addItem(1);
		comboBox.addItem(2);
		comboBox.addItem(3);
		comboBox.addItem(4);
		comboBox.addItem(5);
		comboBox.addItem(6);
		comboBox.addItem(7);
		comboBox.addItem(8);
		comboBox.addItem(9);
		comboBox.addItem(10);
		comboBox.setToolTipText("");
		comboBox.setBounds(316, 75, 86, 20);
		contentPane.add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.addItem(1);
		comboBox_1.addItem(2);
		comboBox_1.addItem(3);
		comboBox_1.addItem(4);
		comboBox_1.addItem(5);
		comboBox_1.addItem(6);
		comboBox_1.addItem(7);
		comboBox_1.addItem(8);
		comboBox_1.addItem(9);
		comboBox_1.addItem(10);
		comboBox.setToolTipText("");
		comboBox_1.setBounds(316, 116, 86, 20);
		contentPane.add(comboBox_1);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.addItem(1);
		comboBox_2.addItem(2);
		comboBox_2.addItem(3);
		comboBox_2.addItem(4);
		comboBox_2.addItem(5);
		comboBox_2.addItem(6);
		comboBox_2.addItem(7);
		comboBox_2.addItem(8);
		comboBox_2.addItem(9);
		comboBox_2.addItem(10);
		comboBox_2.setBounds(316, 151, 86, 20);
		contentPane.add(comboBox_2);
		
		JComboBox comboBox_3 = new JComboBox();
		comboBox_3.addItem(1);
		comboBox_3.addItem(2);
		comboBox_3.addItem(3);
		comboBox_3.addItem(4);
		comboBox_3.addItem(5);
		comboBox_3.addItem(6);
		comboBox_3.addItem(7);
		comboBox_3.addItem(8);
		comboBox_3.addItem(9);
		comboBox_3.addItem(10);
		comboBox_3.setBounds(316, 192, 86, 20);
		contentPane.add(comboBox_3);
		
		JComboBox comboBox_4 = new JComboBox();
		comboBox_4.addItem(1);
		comboBox_4.addItem(2);
		comboBox_4.addItem(3);
		comboBox_4.addItem(4);
		comboBox_4.addItem(5);
		comboBox_4.addItem(6);
		comboBox_4.addItem(7);
		comboBox_4.addItem(8);
		comboBox_4.addItem(9);
		comboBox_4.addItem(10);
		comboBox_4.setBounds(316, 234, 86, 20);
		contentPane.add(comboBox_4);
		
		JComboBox comboBox_5 = new JComboBox();
		comboBox_5.addItem(1);
		comboBox_5.addItem(2);
		comboBox_5.addItem(3);
		comboBox_5.addItem(4);
		comboBox_5.addItem(5);
		comboBox_5.addItem(6);
		comboBox_5.addItem(7);
		comboBox_5.addItem(8);
		comboBox_5.addItem(9);
		comboBox_5.addItem(10);
		comboBox_5.setBounds(316, 276, 86, 20);
		contentPane.add(comboBox_5);
		
		JComboBox comboBox_6 = new JComboBox();
		comboBox_6.addItem(1);
		comboBox_6.addItem(2);
		comboBox_6.addItem(3);
		comboBox_6.addItem(4);
		comboBox_6.addItem(5);
		comboBox_6.addItem(6);
		comboBox_6.addItem(7);
		comboBox_6.addItem(8);
		comboBox_6.addItem(9);
		comboBox_6.addItem(10);
		comboBox_6.setBounds(316, 307, 86, 20);
		contentPane.add(comboBox_6);
		
		JComboBox comboBox_7 = new JComboBox();
		comboBox_7.addItem(1);
		comboBox_7.addItem(2);
		comboBox_7.addItem(3);
		comboBox_7.addItem(4);
		comboBox_7.addItem(5);
		comboBox_7.addItem(6);
		comboBox_7.addItem(7);
		comboBox_7.addItem(8);
		comboBox_7.addItem(9);
		comboBox_7.addItem(10);
		comboBox_7.setBounds(316, 347, 86, 20);
		contentPane.add(comboBox_7);
		
		JComboBox comboBox_8 = new JComboBox();
		comboBox_8.addItem(1);
		comboBox_8.addItem(2);
		comboBox_8.addItem(3);
		comboBox_8.addItem(4);
		comboBox_8.addItem(5);
		comboBox_8.addItem(6);
		comboBox_8.addItem(7);
		comboBox_8.addItem(8);
		comboBox_8.addItem(9);
		comboBox_8.addItem(10);
		comboBox_8.setBounds(316, 380, 86, 20);
		contentPane.add(comboBox_8);
		
		JButton btnDiagnosis = new JButton("Diagnosis");
		btnDiagnosis.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				//int ct1 = (int) comboBox.getSelectedItem();
				//System.out.println("ct ="+ct);
				int ct= (int) comboBox.getSelectedItem();
				
				
				int ucsi = (int) comboBox_1.getSelectedItem();
				//System.out.println("ucsi = "+ucsi);
				
				int ucsh =  (int) comboBox_2.getSelectedItem();
				//System.out.println("ucsh ="+ucsh);
				
				int ma = (int) comboBox_3.getSelectedItem();
				//System.out.println("ma="+ma);
				
				int secs= (int) comboBox_4.getSelectedItem();
				//System.out.println("secs="+secs);
				
				int bn=(int) comboBox_5.getSelectedItem();
				//System.out.println("bn="+bn);
				int bc=(int) comboBox_6.getSelectedItem();
				//System.out.println("bc="+bc);
			
				int nn=(int) comboBox_7.getSelectedItem();
				//System.out.println("nn="+nn);
				int mitoses= (int) comboBox_8.getSelectedItem();
				//System.out.println("mitosis="+mitoses);
				Diagnosis obj = new Diagnosis();
				double result = obj.diagnose(ct, ucsi, ucsh, ma, secs, bn, bc, nn, mitoses);
				
				// create a jframe
			    JFrame frame = new JFrame("JOptionPane showMessageDialog example");
			    
			    // show a joptionpane dialog using showMessageDialog
			    if(result<0) {
			    	JOptionPane.showMessageDialog(frame,
			    			"The result is Malignant");
			    }
			    else {
			    	JOptionPane.showMessageDialog(frame,
			    			"The result is Benign");
			    }
			    //System.exit(0);
		//send this above result in another interface
				//DoctorResultDisplay resdisplay=new DoctorResultDisplay();
				//resdisplay.setVisible(true);
				
			/**	try { 
				if(result.next()) {
					DoctorResultDisplay resdisplay=new DoctorResultDisplay();
					resdisplay.setVisible(true);
					}
				
				else
					JOptionPane.showMessageDialog(null, "incorrect username and the password.");
				//con.close();
				}
				catch(Exception e) {
					System.out.println(e);
				} 
				**/
				
				
			}
		});
		btnDiagnosis.setBounds(29, 488, 89, 23);
		contentPane.add(btnDiagnosis);
		
		JButton btnSignOut = new JButton("Sign Out");
		btnSignOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Loginn window = new Loginn();
				window.frmBreastCancerPrediction.setVisible(true);
				dispose();
				
		
				
			}
		});
		btnSignOut.setBounds(313, 488, 89, 23);
		contentPane.add(btnSignOut);
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				comboBox.setSelectedIndex(-1);
				comboBox_1.setSelectedIndex(-1);
				comboBox_2.setSelectedIndex(-1);
				comboBox_3.setSelectedIndex(-1);
				comboBox_4.setSelectedIndex(-1);
				comboBox_5.setSelectedIndex(-1);
				comboBox_6.setSelectedIndex(-1);
				comboBox_7.setSelectedIndex(-1);
				comboBox_8.setSelectedIndex(-1);
			}
		});
		btnReset.setBounds(179, 488, 89, 23);
		contentPane.add(btnReset);
	}
}
