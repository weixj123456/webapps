package cn.temptation.domain;

import org.slf4j.LoggerFactory;

public class Apple {
    static String name="666";
//        Logger logger=(Logger) LoggerFactory.getLogger(Apple.class);
    
    org.slf4j.Logger logger= LoggerFactory.getLogger(Apple.class);
    public Apple() {
		super();
		// TODO Auto-generated constructor stub
		logger.info("12345初始化苹果类。。。");
		
	}     
     
     
	public void setName(String name) {
		Apple.name = name;
	}

	public String getName() {
 //   	logger.info("12345S");
		logger.info("12345S");
    	return name;
    }
	
	public static void main(String[] args) {
		Apple a=new Apple();
		a.getName();
	}
	
}
