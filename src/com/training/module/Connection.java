package com.training.module;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Connection {

	PreparedStatement ps=null;
	java.sql.Connection con=null;
	ResultSet rs=null;
	public int[][] getdata(int x1, int x2) {
		// TODO Auto-generated method stub
		int [][] z=new int[200][10];
		int i=0;
		con=DBConnection.getconnection();
	    try {
			ps=con.prepareStatement("select * from patientdata");
			rs=ps.executeQuery();
			while(rs.next()){
				if(rs.getInt("id")>=x1 && rs.getInt("id")<=x2){
					int j=0;
					
					z[i][j]=rs.getInt("ct");
					j++;
					z[i][j]=rs.getInt("ucsi");
					j++;
					z[i][j]=rs.getInt("ucsh");
					j++;
					z[i][j]=rs.getInt("ma");
					j++;
					z[i][j]=rs.getInt("secs");
					j++;
					z[i][j]=rs.getInt("bn");
					j++;
					z[i][j]=rs.getInt("bc");
					j++;
					z[i][j]=rs.getInt("nn");
					j++;
					z[i][j]=rs.getInt("mitoses");
					j++; 
					z[i][j]=rs.getInt("class");
					i++;
					
				}
			}
			ps.close();
			con.close();
			rs=null;
			return z;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
	public void updateBW(double b, double[] ress) {
		// TODO Auto-generated method stub
		//int [][] z=new int[200][10];
		//int i=0;
		int rs1=0;
		con=DBConnection.getconnection();
		try {
			ps=con.prepareStatement("insert into databsewb (id,w1,w2,w3,w4,w5,w6,w7,w8,w9,b) values (4,?,?,?,?,?,?,?,?,?,?)");
			 ps.setDouble(1, ress[0]);
			    ps.setDouble(2, ress[1]);
			    ps.setDouble(3, ress[2]);
			    ps.setDouble(4, ress[3]);
			    ps.setDouble(5, ress[4]);
			    ps.setDouble(6, ress[5]);
			    ps.setDouble(7, ress[6]);
			    ps.setDouble(8, ress[7]);
			    ps.setDouble(9, ress[8]);
			    ps.setDouble(10, b);
				rs1=ps.executeUpdate();
			    if(rs1>0){
			    	System.out.println("databse is updated..");
			    }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
