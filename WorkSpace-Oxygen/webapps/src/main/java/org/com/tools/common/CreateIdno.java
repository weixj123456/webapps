package org.com.tools.common;

import java.sql.SQLException;

import org.com.tools.dbtool.QueryRunnerCRUD;

public class CreateIdno {
       public static String returnIdno(int listnum,int id) throws SQLException {
    	String idno=QueryRunnerCRUD.findIdno(id);   
    	QueryRunnerCRUD.update(listnum, id);  
		return idno;
    	   
       }
}
