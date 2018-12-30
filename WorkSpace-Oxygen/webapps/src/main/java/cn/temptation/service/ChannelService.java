package cn.temptation.service;

import java.util.List;

import cn.temptation.domain.Channel;

public interface ChannelService {
	public List<Channel> selectChannel() throws Exception;
	
	public Channel selectByPrimaryKey(Integer id);
	
	int deleteByPrimaryKey(Integer id);

    int insert(Channel record);

    int insertSelective(Channel record);

    int updateByPrimaryKeySelective(Channel record);

    int updateByPrimaryKey(Channel record);
    

}
