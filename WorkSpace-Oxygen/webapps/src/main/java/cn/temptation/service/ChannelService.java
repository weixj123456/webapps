package cn.temptation.service;

import java.util.List;

import cn.temptation.domain.Channel;

public interface ChannelService {
	public List<Channel> selectChannel() throws Exception;
}
