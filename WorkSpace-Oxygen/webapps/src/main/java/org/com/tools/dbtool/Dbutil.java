package org.com.tools.dbtool;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.log4j.Logger;

public class Dbutil {
	
	
	Logger	log	= Logger.getLogger(Dbutil.class);
	
	public Object insertGetId(String sql, Object... params) throws Exception {  
        Connection conn = null;  
        PreparedStatement prepare = null;  
        ResultSet rs = null;  
        try {  
            conn=Dbtool.getConnection();  
            prepare = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);  
            setParams(prepare, params);  
            prepare.executeUpdate();  
            rs = prepare.getGeneratedKeys();  
              
            Object retId = null;  
            if (rs.next())  
                retId = rs.getObject(1);  
            else  
                throw new Exception("insert or generate keys failed..");  
            return retId;  
              
        } catch (Exception e) {  
            throw e;  
        } finally {  
            close(rs);  
            close(prepare);  
            close(conn);  
        }  
  
    }

	public static void executeUpdate(Statement stmt, String sql) {
		try {
			if(stmt != null) {
				stmt.executeUpdate(sql);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void close(Connection conn) {
		try {
			if(conn != null) {
				conn.close();
				conn = null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void close(Statement stmt) {
		try {
			if(stmt != null) {
				stmt.close();
				stmt = null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void close(ResultSet rs) {
		try {
			if(rs != null) {
				rs.close();
				rs = null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	

	private void setParams(PreparedStatement prepare, Object[] params) {
		// TODO Auto-generated method stub
		
	}
}
