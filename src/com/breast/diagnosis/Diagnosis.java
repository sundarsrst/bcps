package com.breast.diagnosis;
/** 1 create constructor and pass all 9 values **/
public class Diagnosis {

	
	public double diagnose(int a,int b,int c, int d,int e,int f,int g,int h,int i) {
		int[] x=new int[9];
		x[0] = a;
		x[1] = b;
		x[2] = c;
		x[3] = d;
		x[4] = e;
		x[5] = f;
		x[6] = g;
		x[7] = h;
		x[8] = i;
		
		/** to get the values of the w and b**/
		GetWB obj = new GetWB();
		double[] w=new double[9];
		w = obj.getwb();
		double valueB = w[9];
		
		double result = predictbc(x, valueB, w);
		//System.out.println("result = "+result);
		/** if(result<0){
			System.out.println("The result is malignant.");
		}
		else {
			System.out.println("The result is benign.");
		} 
		**/
		return result;
	}
	
	private double predictbc(int[] x2, double b2, double[] w2) {
		// TODO Auto-generated method stub
		double result=0;
		result=(kernel(w2,x2)+b2);
		return result;
	}
	private double kernel(double[] w2, int[] x2) {
		// TODO Auto-generated method stub
		double rs=0;
		for (int i=0; i<9; i++){
			rs+=w2[i]*x2[i];
			//System.out.println("kernel= "+rs);
		}
		return rs;
	}
}
