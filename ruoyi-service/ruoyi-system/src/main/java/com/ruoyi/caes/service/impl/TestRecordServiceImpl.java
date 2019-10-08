package com.ruoyi.caes.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.caes.mapper.TestRecordMapper;
import com.ruoyi.caes.domain.TestRecord;
import com.ruoyi.caes.service.ITestRecordService;
import com.ruoyi.common.core.text.Convert;

/**
 * 测评记录Service业务层处理
 * 
 * @author snakerfor
 * @date 2019-10-06
 */
@Service
public class TestRecordServiceImpl implements ITestRecordService 
{
    @Autowired
    private TestRecordMapper testRecordMapper;

    /**
     * 查询测评记录
     * 
     * @param testNo 测评记录ID
     * @return 测评记录
     */
    @Override
    public TestRecord selectTestRecordById(String testNo)
    {
        return testRecordMapper.selectTestRecordById(testNo);
    }

    /**
     * 查询测评记录列表
     * 
     * @param testRecord 测评记录
     * @return 测评记录
     */
    @Override
    public List<TestRecord> selectTestRecordList(TestRecord testRecord)
    {
        return testRecordMapper.selectTestRecordList(testRecord);
    }

    /**
     * 新增测评记录
     * 
     * @param testRecord 测评记录
     * @return 结果
     */
    @Override
    public int insertTestRecord(TestRecord testRecord)
    {
        testRecord.setCreateTime(DateUtils.getNowDate());
        return testRecordMapper.insertTestRecord(testRecord);
    }

    /**
     * 修改测评记录
     * 
     * @param testRecord 测评记录
     * @return 结果
     */
    @Override
    public int updateTestRecord(TestRecord testRecord)
    {
        testRecord.setUpdateTime(DateUtils.getNowDate());
        return testRecordMapper.updateTestRecord(testRecord);
    }

    /**
     * 删除测评记录对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteTestRecordByIds(String ids)
    {
        return testRecordMapper.deleteTestRecordByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除测评记录信息
     * 
     * @param testNo 测评记录ID
     * @return 结果
     */
    public int deleteTestRecordById(String testNo)
    {
        return testRecordMapper.deleteTestRecordById(testNo);
    }
}
