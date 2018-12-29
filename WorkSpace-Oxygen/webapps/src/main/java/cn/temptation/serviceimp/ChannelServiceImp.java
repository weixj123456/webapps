package cn.temptation.serviceimp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import cn.temptation.dao.ChannelMapper;
import cn.temptation.domain.Channel;
import cn.temptation.service.ChannelService;

public class ChannelServiceImp implements ChannelService {
	@Autowired
    private ChannelMapper channelMapper;
 
    //查询用户service接口实现
    @Override
    public List<Channel> selectChannel() throws Exception {
        return channelMapper.selectChannel();
        // TODO Auto-generated method stub
 
    }
 
}
