package com.ruoyi.caes.mapper;

import com.ruoyi.caes.domain.TestSumbit;
import java.util.List;
import java.util.Map;

/**
 * 测评提交Mapper接口
 * 
 * @author snakerfor
 * @date 2019-10-06
 */
public interface TestSumbitMapper 
{
    /**
     * 查询测评提交
     * 
     * @param sumbitId 测评提交ID
     * @return 测评提交
     */
    public TestSumbit selectTestSumbitById(Long sumbitId);

    /**
     * 查询测评提交列表
     * 
     * @param testSumbit 测评提交
     * @return 测评提交集合
     */
    public List<TestSumbit> selectTestSumbitList(TestSumbit testSumbit);

    /**
     * 新增测评提交
     * 
     * @param testSumbit 测评提交
     * @return 结果
     */
    public int insertTestSumbit(TestSumbit testSumbit);

    /**
     * 修改测评提交
     * 
     * @param testSumbit 测评提交
     * @return 结果
     */
    public int updateTestSumbit(TestSumbit testSumbit);

    /**
     * 删除测评提交
     * 
     * @param sumbitId 测评提交ID
     * @return 结果
     */
    public int deleteTestSumbitById(Long sumbitId);

    /**
     * 批量删除测评提交
     * 
     * @param sumbitIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteTestSumbitByIds(String[] sumbitIds);

    public List<Map<String,Object>> selectCalcScore(String testNo);

    public Map<String,Object> selectCreateScore(String testNo);
}
