package org.com.mybatis.servicetest;

import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;
import org.com.tools.common.MyDate;
import org.com.tools.task.MyTask;
import org.junit.Test;

import cn.temptation.dao.ChannelMapper;
import cn.temptation.domain.Channel;



public class Test1 {
	Logger	log	= Logger.getLogger(Test1.class);
   @Test
    public void findChannelByID() throws Exception{
        String resource = "SqlMapConfig.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession session = factory.openSession();
        //---------------
        ChannelMapper ChannelMapper = session.getMapper(ChannelMapper.class);
        Channel Channel = ChannelMapper.findChannelById(2);
        System.out.println(Channel);
        //--------------
        session.close();
    }
    @Test
    public void findAll() throws Exception{
        String resource = "SqlMapConfig.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession session = factory.openSession();
        //---------------------
        ChannelMapper mapper = session.getMapper(ChannelMapper.class);
        List<Channel> Channel = mapper.findAllChannels();
        for (Channel Channel2 : Channel) {           
            System.out.println(Channel2);
        }
        //----------------------
        session.close();
    }
    @Test
    public void insertTest() throws Exception{
    	
        String resource = "SqlMapConfig.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession session = factory.openSession();
        //---------------------
        Channel channel = new Channel();
        channel.setId(26);
        channel.setName("测试渠道");
        channel.setChannelid("2222");
        SimpleDateFormat aDate=new SimpleDateFormat("yyyy-mm-dd HH:mm:ss");
//      SimpleDateFormat bDate=new SimpleDateFormat("yyyy-mmmmmm-dddddd");
        long now=System.currentTimeMillis();
        System.out.println("aDate:"+aDate.format(now));
//        System.out.println("bDate:"+bDate.format(now));
         String time=MyDate.getTimeStr();
		channel.setLasttimestamp(time);
        

        ChannelMapper mapper = session.getMapper(ChannelMapper.class);
        mapper.insertChannel(channel);
//          ChannelMapper mapper1=session.getMapper(ChannelMapper.class);
          session.commit();
        //----------------------
        session.close();
        System.out.println("插入测试成功！！！");
    }
    @Test
    public void deleteChannelById() throws Exception{
        String resource = "SqlMapConfig.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession session = factory.openSession();
        //---------------------
        ChannelMapper mapper = session.getMapper(ChannelMapper.class);
        mapper.deleteChannelById(24);
        session.commit();
        //----------------------
        session.close();
    }
  
}

