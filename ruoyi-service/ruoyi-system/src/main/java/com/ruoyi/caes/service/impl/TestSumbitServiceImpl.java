package com.ruoyi.caes.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.caes.mapper.TestSumbitMapper;
import com.ruoyi.caes.domain.TestSumbit;
import com.ruoyi.caes.service.ITestSumbitService;
import com.ruoyi.common.core.text.Convert;

/**
 * 测评提交Service业务层处理
 * 
 * @author snakerfor
 * @date 2019-10-06
 */
@Service
public class TestSumbitServiceImpl implements ITestSumbitService 
{
    @Autowired
    private TestSumbitMapper testSumbitMapper;

    /**
     * 查询测评提交
     * 
     * @param sumbitId 测评提交ID
     * @return 测评提交
     */
    @Override
    public TestSumbit selectTestSumbitById(Long sumbitId)
    {
        return testSumbitMapper.selectTestSumbitById(sumbitId);
    }

    /**
     * 查询测评提交列表
     * 
     * @param testSumbit 测评提交
     * @return 测评提交
     */
    @Override
    public List<TestSumbit> selectTestSumbitList(TestSumbit testSumbit)
    {
        return testSumbitMapper.selectTestSumbitList(testSumbit);
    }

    /**
     * 新增测评提交
     * 
     * @param testSumbit 测评提交
     * @return 结果
     */
    @Override
    public int insertTestSumbit(TestSumbit testSumbit)
    {
        return testSumbitMapper.insertTestSumbit(testSumbit);
    }

    /**
     * 修改测评提交
     * 
     * @param testSumbit 测评提交
     * @return 结果
     */
    @Override
    public int updateTestSumbit(TestSumbit testSumbit)
    {
        return testSumbitMapper.updateTestSumbit(testSumbit);
    }

    /**
     * 删除测评提交对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteTestSumbitByIds(String ids)
    {
        return testSumbitMapper.deleteTestSumbitByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除测评提交信息
     * 
     * @param sumbitId 测评提交ID
     * @return 结果
     */
    @Override
    public int deleteTestSumbitById(Long sumbitId)
    {
        return testSumbitMapper.deleteTestSumbitById(sumbitId);
    }

    @Override
    public List<Map<String, Object>> selectCalcScore(String testNo) {
        return testSumbitMapper.selectCalcScore(testNo);
    }


}
