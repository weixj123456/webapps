package com.cy.ssm.beans;

import org.apache.log4j.Logger;

public class Idcard {
	
//	private static final Logger log = Logger.getLogger(Idcard.class);
	Logger	log	= Logger.getLogger(Idcard.class);
    private int id;

    private String idno;

    private int num;
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIdno() {
        return idno;
    }

    public void setIdno(String idno) {
        this.idno = idno;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }
}