package cn.temptation.web;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.temptation.domain.Channel;
import cn.temptation.service.ChannelService;

@Controller
public class ChannelController {
     
	@SuppressWarnings("unused")
	private static final Logger log = Logger.getLogger(ChannelController.class);
	
	@Autowired
    private ChannelService channelService;
 
    @RequestMapping("/queryChannel.do")
    public String  queryUser(Model model) throws Exception{
        List<Channel> channellist = channelService.selectChannel();
		model.addAttribute("channellist",channellist);
        return "/user/staff";
         
    }
}

