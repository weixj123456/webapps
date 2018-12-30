package com.cy.ssm.beans;

import org.apache.log4j.Logger;

public class Countno {
	
//	private static final Logger log = Logger.getLogger(Countno.class);
	Logger	log	= Logger.getLogger(Countno.class);
      int id;
      int num;
      public Countno() {
    	  super();
      }
      public Countno(int id,int num) {
    	  super();
    	  this.id=id;
    	  this.num=num;
      }  
      public void setId(int id) {
          this.id = id;
      }

      public int getId() {
          return id;
      }

      public void setNum(int num) {
          this.num = num;
      }

      public int getNum() {
          return num;
      }  
}
