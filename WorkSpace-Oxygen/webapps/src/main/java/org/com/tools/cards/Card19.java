package org.com.tools.cards;

public class Card19 {
			private static  int m=0;
			private  static int n=0;
		  //private  static int nn=0;
			private  static int x=0;
			private  static int num=0;
		  //private  static int mm=0;
			private  static int num3=0;
		 //String str0="622848003105670421";
public static String card019(String str1) {
			String str=str1;
			//Character.getNumericValue(numChar)
	//=================================================	
    //=================================================
											
			   for (int i=17;i>=0;i--)
			    {   
			//	 if(i==17 || i%2==1)
				 if(i%2==1) 
				 {
					char c = str.charAt(i);
				    String s=String.valueOf(c);
				    n=Integer.parseInt(s);
//				    System.out.print("n"+"("+i+")="+n+"     ");						
						m=n*2;						
//				     System.out.print("m"+"("+i+")="+m+"     ");
					 x=m/10+m%10;
//					 System.out.print("x"+"("+i+")="+x+"     ");
					 num=num+x;
//					 System.out.print("num="+num+" ");
//					 System.out.println("num "+"+"+"x "+x+"="+num);
					}
//                    System.out.println("  ");
                    
                    
				}
//				System.out.println(" ===================  ");
			 //  */
//				System.out.println("num=  "+num);
			//}				
	         int nn=0;
	         int mm=0;
             for (int i=0;i<18;i++)
				{   
					if(i%2==0) {
					char cc = str.charAt(i);
				    String ss=String.valueOf(cc);
				    nn=Integer.parseInt(ss);
//				    System.out.print("nn"+"("+i+")="+nn+"     ");						
						mm=nn+mm;						
//					System.out.print("mm"+"("+i+")="+mm+"     ");
					
				}
//                 System.out.println("   ");
                 
				}
               num=num+mm;
//                System.out.println("num "+num);
//				System.out.println(" ===================  ");
			 //  */
//				System.out.println("num   ="+num);				
				if(num%10==0)
				{
					num3=0;
				}else {
					num3=10-num%10;
				}
//				System.out.println("num3= "+num3);
				String cardnum2=str+num3;
				System.out.println("cardnum2   ="+cardnum2);
				return cardnum2;
		    
			//	System.out.println("������Ŀ��Ų���ȷ");
	}
}
