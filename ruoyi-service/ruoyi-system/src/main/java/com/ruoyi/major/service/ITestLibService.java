package com.ruoyi.major.service;

import com.ruoyi.major.domain.TestLib;
import java.util.List;

/**
 * 评测试题Service接口
 * 
 * @author snakerfor
 * @date 2019-09-10
 */
public interface ITestLibService 
{
    /**
     * 查询评测试题
     * 
     * @param quesId 评测试题ID
     * @return 评测试题
     */
    public TestLib selectTestLibById(Integer quesId);

    /**
     * 查询评测试题列表
     * 
     * @param testLib 评测试题
     * @return 评测试题集合
     */
    public List<TestLib> selectTestLibList(TestLib testLib);

    /**
     * 新增评测试题
     * 
     * @param testLib 评测试题
     * @return 结果
     */
    public int insertTestLib(TestLib testLib);

    /**
     * 修改评测试题
     * 
     * @param testLib 评测试题
     * @return 结果
     */
    public int updateTestLib(TestLib testLib);

    /**
     * 批量删除评测试题
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteTestLibByIds(String ids);

    /**
     * 删除评测试题信息
     * 
     * @param quesId 评测试题ID
     * @return 结果
     */
    public int deleteTestLibById(Integer quesId);
}
