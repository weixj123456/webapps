package org.com.tools.dbtool;

import java.sql.SQLException;



import org.apache.commons.dbutils.QueryRunner;





public class QueryRunnerCRUD1 {
    /*
     *测试表
    CREATE TABLE `users` (
        `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
        `account` VARCHAR(50) NULL DEFAULT NULL,
        `user_id` BIGINT(20) NOT NULL,
        PRIMARY KEY (`id`)
    )
    COMMENT='user表'
    COLLATE='latin1_swedish_ci'
    ENGINE=InnoDB
    ;
String sql = "INSERT INTO `cmis`.`users` (`id`,`account`, `user_id`) VALUES (?,?,?)";

     */
 
    public static void add() throws SQLException {
        //将数据源传递给QueryRunner，QueryRunner内部通过数据源获取数据库连接
        QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
        String sql = "INSERT INTO `cmis`.`users` (`id`,`account`, `user_id`) VALUES (?,?, ?);";
        Object params[] = {"10","hello world",2323};
        qr.update(sql, params);
    }
   
    public static  void delete() throws SQLException {
        QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
        String sql = "delete from users where id=?";
        qr.update(sql, 1);

    }
  
    public static void update(int updatenum,int id) throws SQLException {
    	
        QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
        //更新模板
      //  String sql = "update users set account=? where id=?";
        String sql = "update idcard set num=? where id=?";
        Object params[] = { updatenum, id};
        qr.update(sql, params); 
    }


	public  static String findIdno(int idnum) throws SQLException {
//        QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
//        String sql = "select * from idcard where id=?";
//        Object params[] = {idnum};
        String idno=null;
        //User user = (User) qr.query(sql, params, new BeanHandler(User.class));       
//		Idcard idcard=(Idcard) qr.query(sql, params, new BeanHandler<Object>(Idcard.class));
//        idno=idcard.getIdno();
        //System.out.println(idcard.getIdno());
        //qr.update(sql, params);
        return idno;
    }
    
    public static void getAll2(String tablename,Object Idcard) throws SQLException {
        
         
    }

        public  static int getAll(int num1) throws SQLException {
//    	QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
    	//Idcard u = new Idcard();
 //   	int keynum=0;
//         String idno=null;
         int num=0;
 //   	String sql = "select * from idcard";       
//        List<Idcard> list = (List<Idcard>) qr.query(sql, new BeanListHandler(Idcard.class));
 /**       for(Idcard u : list){
//             System.out.print(u.getId()+"  ");
//             System.out.print(u.getIdno()+"  ");
//             System.out.println(u.getNum()+"  ");
        	 keynum=u.getId();
        	 idno=u.getIdno();
        	 num=u.getNum();       	
        	if(num>num1) {
        		System.out.println("当前传入参数num数较小"); 
        		//update(num, num);
        	}else if(num==num1) {
        		System.out.println("当前传入参数num数与执行次数相等，无法更新");
        	}else if(num<num1) {
        		while(num<num1) {
            		num++;
            	}
        		System.out.println("当前传入参数num数可进行更新"+num);
        		update(num,keynum);
        		System.out.println();
        		//break;
        	}      	
        }  */
      return num;
    }
     
//    public static void main(String[] args) throws Exception {
//        QueryRunnerCRUD t=new QueryRunnerCRUD();
//        System.out.println(t.findIdno(20));
//        t.getAll(7);
//    }
}