package com.training.module;

public class CalculateE {

	public double calcE(int[][] x, int[] is, int[] y, double b, double[] alphai, int i1,int m) {
		// TODO Auto-generated method stub
		
		int i=0;
		//int j=0;
		double r=0;
		//int[][] temp=null;
		//System.out.println(m);
		/** calculate f(x) first**/
		for (i=0;i<m;i++){
			//System.out.println("upper");
			r+=alphai[i]*y[i]*kernel(x,is,i);
			//System.out.println("ll");
		}
		double f=r+b;
		double e=f-y[i1];
		//System.out.println("the value of E is" +e);
		return e;
	}
	private int kernel(int[][] x, int[] is, int i) {
		// TODO Auto-generated method stub
		/** to change 2d array x to 1d for dot product**/
		//System.out.println("after");
		int res=0;
		//System.out.println("ll");
		for(int j=0; j<9;j++){
			res+=x[i][j]*is[j];
		}
		//System.out.println("khkh"+res);
		return res;
	}
	}

	

