package org.com.tools.dbtool;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;

import cn.hutool.db.handler.BeanHandler;
import cn.hutool.db.handler.BeanListHandler;
import cn.temptation.domain.User;


public class Db {
	 public  static void add(String insersql,Object params[]) throws SQLException {
		     String sql=insersql;
	        //将数据源传递给QueryRunner，QueryRunner内部通过数据源获取数据库连接
	        QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
	      //  String sql = "INSERT INTO `cmis`.`"+tablename+"` (`id`,`account`, `user_id`) VALUES (?,?,?);";
	       // Object params1[] = {"10","hello world",2323};  
	        qr.update(sql, params);
	    }
	     
	 
	   public  static void delete(String sql,Object params1[]) throws SQLException {
	   //public  static void delete(String tablename,String whereid) throws SQLException {
	        QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
	       // String sql = "delete from "+tablename+" where "+whereid+"=?";
	        qr.update(sql, 1);
	    }
    
	    public static void update(String sql,Object params[]) throws SQLException {
	   // public void update(String tablename,String setname,String whereid) throws SQLException {
	        QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
	       // String sql = "update "+tablename+" set "+ setname+"=? +where "+whereid+"=?";
	        //Object params[] = { "ddd", 2};
	        qr.update(sql, params);
	    }
	    
	    public static void find(String tablename,String whereid) throws SQLException {
	        QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
	        String sql = "select * from "+tablename+ " where "+whereid+"=?";
	        Object params[] = {2};
//	        User user = (User) qr.query(sql, params, new BeanHandler(User.class));
	//       System.out.println(user.getId());
	    }

	    
	    public static void getAll() throws SQLException {
	        QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
	        String sql = "select * from users";
//	        List<User> list = (List<User>) qr.query(sql, new BeanListHandler(User.class));
//	        for(User u : list){
//	             System.out.print(u.getUserid()+"   ");
	   //          System.out.print(u.getAccount()+"   ");
	   //          System.out.println(u.getId()+"   ");
	//        }	       
	    }
	    
	    
	    public  static void testBatch() throws SQLException {
	        QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
	        String sql = "INSERT INTO `cmis`.`users` (`id`,`account`, `user_id`) VALUES (?,?,?)";
	        Object params[][] = new Object[10][];
	        for (int i = 12; i < 20; i++) {
	            params[i] = new Object[] {"123"+i, i};
	        }
	        qr.batch(sql, params);
	    }
	    
	    
	    public static void main(String[] args) throws Exception {
	        //QueryRunnerCRUDTest t=new QueryRunnerCRUDTest();
//	    	Object params[] = {"54","hello54world",5454}; 
//	    	String insersql="INSERT INTO `cmis`.`users` (`id`,`account`, `user_id`) VALUES (?,?,?)";
//	         Db.add(insersql, params);
	         
	   //      String sql="update users set account=? where id=?";
	    //     Db.update(sql, params);
	         Db.getAll();
	    }
}
	    