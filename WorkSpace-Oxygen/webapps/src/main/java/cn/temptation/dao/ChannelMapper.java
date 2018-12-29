package cn.temptation.dao;

import java.util.List;

import cn.temptation.domain.Channel;

public interface ChannelMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Channel record);

    int insertSelective(Channel record);

    Channel selectByPrimaryKey(Integer id);
    
    public List<Channel> selectChannel() throws Exception;

    int updateByPrimaryKeySelective(Channel record);

    int updateByPrimaryKey(Channel record);
}