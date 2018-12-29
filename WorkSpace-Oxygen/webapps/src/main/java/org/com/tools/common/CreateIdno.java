package org.com.tools.common;

import java.sql.SQLException;

import org.apache.log4j.Logger;
import org.com.tools.dbtool.QueryRunnerCRUD1;

public class CreateIdno {
	
	   Logger	log	= Logger.getLogger(CreateIdno.class);
	
       public static String returnIdno(int listnum,int id) throws SQLException {
    	String idno=QueryRunnerCRUD1.findIdno(id);   
    	QueryRunnerCRUD1.update(listnum, id);  
		return idno;
    	   
       }
}
