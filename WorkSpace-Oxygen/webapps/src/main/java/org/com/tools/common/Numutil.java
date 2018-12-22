package org.com.tools.common;

public class Numutil {
	static String code;
	static int num;
	public Numutil(String code, int num) {
		this.code=code;
		this.num=num;
	}
	/**
     * 不够位数的在前面补0，保留num的长度位数字
     * @param code
     * @return
     */
    public static String autoGenericCode() {
        String result = "";
        // 保留num的位数
        // 0 代表前面补充0     
        // num 代表长度为4     
        // d 代表参数为正数型 
        result = String.format("%0" + num + "d", Integer.parseInt(code) + 1);
        return result;
    }
    
//    public static void main(String[] args) {
//    	String num=new Numutil("5",3).autoGenericCode();
//    	
//    	System.out.println(num);
//	}
}
