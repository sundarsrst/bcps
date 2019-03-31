package com.training.module;

public class First {
    static int[][] x=null;
	static int x1=0;
	static int x2=0;
    static int[] tmp=new int[175];
    static int[] y=new int[175];
    
    
	public First(int x1, int x2){
		System.out.println(+x1+ " "+x2);
		//why connection here to get values for x1 and x2 ??
		Connection obj=new Connection();
		
		//yo x ka use bha chha?
		
		x=obj.getdata(x1,x2);
		
		for(int i=0;i<(x2-x1); i++){
			for (int j=0;j<10;j++){
				if(j==9){
					tmp[i]=x[i][j];
				}
			}
		}
		//converts result type 4 or 2 into the svm formula notation -1 or 1 respectively
		for (int i=0;i<(x2-x1); i++){
			if (tmp[i]==4){
				y[i]=-1;
			}
			else {
				y[i]=1;
			}
			//System.out.println(i);
		}
		//System.out.println(y[9]);
		TrainSvm o=new TrainSvm();
		o.enterSvm(x,(x2-x1+1),y);
	}

}
