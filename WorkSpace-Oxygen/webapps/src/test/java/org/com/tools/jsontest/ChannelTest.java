package org.com.tools.jsontest;

import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;

import cn.temptation.domain.Channel;

public class ChannelTest {
	public ModelAndView login(Channel model, HttpSession session) {
		return null;
//        Channel user = ChannelMapper.findByUsername(model.getUsername());
//		Channel user = ChannelMapper
//        if (user == null || !user.getPassword().equals(model.getPassword())) {
//            return new ModelAndView("redirect:/login.jsp");
//        } else {
//            session.setAttribute("user", user);
//            ModelAndView mav = new ModelAndView();
//            mav.setViewName("index");
//            return mav;
//        }
    }
}
