package com.splasher;
import com.login.sys.Loginn;
import com.splasher.Screen;;

public class Splasher {
	
	public static void main(String[] args) {
		Screen obr = new Screen();
		//Loginn obj=new Loginn();
		obr.setVisible(true);
		int i;
		
		try {
			for(i=0;i<=100;i++) {
				Thread.sleep(35);
				//obr.label.setText(Integer.toString(i)+"%");
				obr.progressBar_1.setValue(i);
				if (i==100) {
					
					obr.setVisible(false);
					Loginn window = new Loginn();
					window.frmBreastCancerPrediction.setVisible(true);
					//obj.setVisible(true);
					
					
				}
				}
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}


}

