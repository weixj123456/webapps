package cn.temptation.dao;

import java.util.List;

import cn.temptation.domain.Channel;


public interface ChannelMapper {
    int deleteByPrimaryKey(Integer id);
    int insert(Channel record);
    int insertSelective(Channel record);
    Channel selectByPrimaryKey(Integer id);
    int updateByPrimaryKeySelective(Channel record);
    int updateByPrimaryKey(Channel record);   
    public List<Channel> selectChannel() throws Exception;
    
    public Channel findChannelById(int id) throws Exception ;
    public List<Channel> findAllChannels() throws Exception;
    public void insertChannel(Channel channel) throws Exception;
    public void deleteChannelById(int id) throws Exception;
    public void updateChannel(Channel channel) throws Exception;
    public void updateChannel(int id) throws Exception;
    
}