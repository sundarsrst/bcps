package com.training.module;

import java.util.Random;


public class TrainSvm {
    static int iteration=500;
	static int passes=0;
	static double resulti;
	static double resultj;
	static double[] alphai=new double[200];
	static double[] alphaj=new double[200];
	static double b=0;
	static double ita;
	//static double iter=1;
	public void enterSvm(int[][] x, int i, int[] y) {
		// TODO Auto-generated method stub
		CalculateE obj=new CalculateE();
		//System.out.println("number of iteration= ");
		//Scanner scd=new Scanner(System.in);
		//iteration=scd.nextInt();
		System.out.println("Training data...");
		while(passes<iteration){
			
			int num_changed_alpha=0;
			for (int i1=0; i1<i; i1++){
				resulti=obj.calcE(x,getXonly(i1,x),y,b,alphai,i1,i); //it calculates E
				 //System.out.println("resulti="+resulti);
				if((y[i1]*resulti<-0.1) && alphai[i1]<1 || (y[i1]*resulti>0.1 && alphai[i1]>0)){
					//System.out.println("yeah11");
				Random rand = new Random();
				int j=rand.nextInt(i-1) + 0;
				while(j==i1){
                j = rand.nextInt(i-1) + 0;
				}
                
//                if(j==i1){                       // random j so j not equals to i condition
//                    j = rand.nextInt(i-1) + 0;
//                  }
//                if(j==i1){                       // random j so j not equals to i condition
//                    j = rand.nextInt(i-1) + 0;
//                  }
//                if(j==i1){                       // random j so j not equals to i condition
//                    j = rand.nextInt(i-1) + 0;
//                  }
//                if(j==i1){                       // random j so j not equals to i condition
//                    j = rand.nextInt(i-1) + 0;
//                  }
                double alpi=0.0; double alpj=0.0;
            	resultj=obj.calcE(x,getXonly(j,x),y,b,alphai,j,i-1);
            	alpi=alphai[i1];
                alpj=alphaj[j];
                //System.out.println("yeah");
            	double[] temp=computeLH(alpi,alpj,i1,j,y);
//            	System.out.println("alphai= "+alpi);
//            	System.out.println("alphaj= "+alpj);
//            	System.out.println("temp0= "+temp[0]);
//            	System.out.println("temp1= "+temp[1]);
            	if(temp[0]==temp[1]){
            		//System.out.println("temp= "+temp[1]);
            		
            		continue;
            }
            	ita=2*kernel(i1,j,x)-kernel(i1,i1,x)-kernel(j,j,x);
            	//System.out.println("ita= "+ita);
            	if(ita>=0){
                	continue;
                }
            	 alphaj[j]=alpj-(y[j]*(resulti-resultj))/ita;
            	 if(alphaj[j]>temp[1]){
                 	alphaj[j]=temp[1];
                 }
                 else if(temp[0]<=alphaj[j] && alphaj[j]<=temp[1]){
                 	alphaj[j]=alphaj[j];
                 }
                 else if(alphaj[j]<temp[0]){
                 	alphaj[j]=temp[0];
                 }
            	 if(Math.abs(alphaj[j]-alpj)<0.0001){
                 	continue;
                 }
            	 alphai[i1]=alphai[i1]+y[i1]*y[j]*(alpj-alphaj[j]);
                 double b1; double b2;
                 b1=b-resulti-y[i1]*(alphai[i1]-alpi)*kernel(i1,i1,x)-y[j]*(alphaj[j]-alpj)*kernel(i1,j,x);
                 //System.out.println("bias= "+b1);
                 b2=b-resultj-y[i1]*(alphai[i1]-alpi)*kernel(i1,j,x)-y[j]*(alphaj[j]-alpj)*kernel(j,j,x);
                 if((0<alphai[i1]) && (alphai[i1]<0.1)){
                 	b=b1;
                 }
                 if((0<alphaj[j]) && (alphaj[j]<0.1)){
                 	b=b2;
                 }
                 else {
                 	b=(b1+b2)/2;
                 }
                 num_changed_alpha=num_changed_alpha+1;
			}
			
			}
			
		if(num_changed_alpha == 0){
			passes=passes+1;
		}
		else {
			passes=0;
		}
		//iter++;
		//System.out.println(iter+"/t"+passes+"/t"+b);
		
		}
		double[] ress=new double[9];
		for (int i1=0; i1<9; i1++){
			for( int j=0; j<i; j++){
			ress[i1]+=alphai[j]*y[j]*x[j][i1];
			}
		}
		try
		{
		    Thread.sleep(900000);
		}
		catch(InterruptedException ex)
		{
		    Thread.currentThread().interrupt();
		}
		for (int i1=0; i1<9; i1++){
			System.out.println("w"+i+" = "+ress[i1]);
		}
		
		//System.out.println("b= "+b);
		Connection bb=new Connection();
		bb.updateBW(b,ress);
		
		
		
	}
	private double kernel(int i, int j,int [][]x) {
		// TODO Auto-generated method stub
		int res=0;
		for(int j1=0; j1<9;j1++){
			res+=x[i][j1]*x[j][j1];
		}
		return Math.pow(res,2);
	}
	private double[] computeLH(double alpi, double alpj, int i, int j,int[] y) {
		// TODO Auto-generated method stub
		 double L;
		    double H;
			if(y[i]!=y[j]){
				 L=Math.max(0,alpj-alpi);
				 H=Math.min(1,1+alpj+alpi);
			}
			else{
				 L=Math.max(0, alpi+alpj-1);
				 H=Math.min(0, alpi+alpj);
			}
			double [] p=new double[2];
			p[0]=L;
			p[1]=H;
			return p;
	}
	private int[] getXonly(int i1, int[][] x) {
		// TODO Auto-generated method stub
		int[] oneda=new int[9];
		for(int j = 0; j<9;j++){
			oneda[j]= x[i1][j];	
			//System.out.println(oneda[j]);
		}
		return oneda;
	
	}

	
}
