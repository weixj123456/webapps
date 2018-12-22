package org.com.tools.dbtool;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class DbfindID {	
		//@Test
public static void queryMaxid(String tablename) throws SQLException{
	        String tablename1=tablename;
			int id = 0;
		 //加载驱动
		 //Class.forName("com.mysql.jdbc.Driver");
		 //建立连接
		// Connection conn = DriverManager.getConnection("jdbc:mysql://" +"localhost/cmis?user=root&password=123456");
			try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 
		    Connection conn=null;
			try {
				conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/cmis","root","123456");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 
		   Statement stmt=null;
		try {
			stmt = conn.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		   String sql="select MAX(id) from"+" "+tablename1;  //autoface
		//   String sql="select id,name,age from teacher";
		    ResultSet rs=stmt.executeQuery(sql);
		             while(rs.next())
//		             {
		                id=rs.getInt(1);
//		               String name=rs.getString("name");          
//		               int age=rs.getInt("age");
//		               
//		             out.println("<td>"+"id"+"<td>"+" "+id+"<td>"+" name"+"<td>"+" "+name+"age"+"<td>"+"<td>"+"<td>"+"<td>"+" "+age);
//		             
//		             
//		             }
		// Statement stat = null;
		// ResultSet rs=null;
		// stat=conn.createStatement();//创建语句
		// rs=stat.executeQuery(strsql);//执行语句，得到结果
		// rs.next();//使结果集光标向前移动一行
		//输出结果结果中的第一个元素
		 System.out.println(id);
		 //关闭连接
		 rs.close();
		 stmt.close();
		 conn.close();
		} 

     public static void main(String[] args) throws SQLException {
		DbfindID.queryMaxid("users");
	}
}
