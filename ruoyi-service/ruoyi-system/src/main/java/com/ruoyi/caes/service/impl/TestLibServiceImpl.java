package com.ruoyi.caes.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.caes.domain.TestLib;
import com.ruoyi.caes.mapper.TestLibMapper;
import com.ruoyi.caes.service.ITestLibService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.common.core.text.Convert;

/**
 * 评测试题Service业务层处理
 * 
 * @author snakerfor
 * @date 2019-09-10
 */
@Service
public class TestLibServiceImpl implements ITestLibService
{
    @Autowired
    private TestLibMapper testLibMapper;

    /**
     * 查询评测试题
     * 
     * @param quesId 评测试题ID
     * @return 评测试题
     */
    @Override
    public TestLib selectTestLibById(Integer quesId)
    {
        return testLibMapper.selectTestLibById(quesId);
    }

    /**
     * 查询评测试题列表
     * 
     * @param testLib 评测试题
     * @return 评测试题
     */
    @Override
    public List<TestLib> selectTestLibList(TestLib testLib)
    {
        return testLibMapper.selectTestLibList(testLib);
    }

    /**
     * 新增评测试题
     * 
     * @param testLib 评测试题
     * @return 结果
     */
    @Override
    public int insertTestLib(TestLib testLib)
    {
        testLib.setCreateTime(DateUtils.getNowDate());
        return testLibMapper.insertTestLib(testLib);
    }

    /**
     * 修改评测试题
     * 
     * @param testLib 评测试题
     * @return 结果
     */
    @Override
    public int updateTestLib(TestLib testLib)
    {
        testLib.setUpdateTime(DateUtils.getNowDate());
        return testLibMapper.updateTestLib(testLib);
    }

    /**
     * 删除评测试题对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteTestLibByIds(String ids)
    {
        return testLibMapper.deleteTestLibByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除评测试题信息
     * 
     * @param quesId 评测试题ID
     * @return 结果
     */
    public int deleteTestLibById(Integer quesId)
    {
        return testLibMapper.deleteTestLibById(quesId);
    }
}
