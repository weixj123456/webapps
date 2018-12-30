package cn.temptation.dao;

import cn.temptation.domain.Idcard;

public interface IdcardMapper {
	
//	Logger	log	= Logger.getLogger(Idcard.class);
	
    int deleteByPrimaryKey(Integer id);

    int insert(Idcard record);

    int insertSelective(Idcard record);

    Idcard selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Idcard record);

    int updateByPrimaryKey(Idcard record);
}