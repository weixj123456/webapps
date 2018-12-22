package org.com.tools.cards;



public class maintest {
       public static void main(String[] args) {
		//String string=
				String str="621485121383006";
				String str1="622848003105670421";

				if(str.length()==15 && str1.length()==18) {
				new Card16();
				Card16.card016(str);
				new Card19();
				Card19.card019(str1);
				}else if (str.length()>15) {
					System.out.println("str���뿨�ų��������������룬��ǰ���ȣ�"+(str.length()+1));
				}else if(str.length()<15) {
					System.out.println("str���뿨��С��16λ���������룬��ǰ���ȣ�"+(str.length()+1));
				}else if (str1.length()>18) {
					System.out.println("str1���뿨�ų��������������룬��ǰ���ȣ�"+(str1.length()));
				}else if (str1.length()<18) {
					System.out.println("str1���뿨�Ź��̣����������룬��ǰ���ȣ�"+(str1.length()));
				}
	}
}
