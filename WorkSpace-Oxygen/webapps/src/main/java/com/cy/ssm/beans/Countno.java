package com.cy.ssm.beans;

public class Countno {
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
