package cn.temptation.dao;

import cn.temptation.domain.Testcase;

public interface TestcaseMapper {
	
	
	
    int deleteByPrimaryKey(String id);

    int insert(Testcase record);

    int insertSelective(Testcase record);

    Testcase selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Testcase record);

    int updateByPrimaryKeyWithBLOBs(Testcase record);

    int updateByPrimaryKey(Testcase record);
}