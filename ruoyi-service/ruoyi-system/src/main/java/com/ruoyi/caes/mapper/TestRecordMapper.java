package com.ruoyi.caes.mapper;

import com.ruoyi.caes.domain.TestRecord;
import java.util.List;

/**
 * 测评记录Mapper接口
 * 
 * @author snakerfor
 * @date 2019-10-06
 */
public interface TestRecordMapper 
{
    /**
     * 查询测评记录
     * 
     * @param testNo 测评记录ID
     * @return 测评记录
     */
    public TestRecord selectTestRecordById(String testNo);

    /**
     * 查询测评记录列表
     * 
     * @param testRecord 测评记录
     * @return 测评记录集合
     */
    public List<TestRecord> selectTestRecordList(TestRecord testRecord);

    /**
     * 新增测评记录
     * 
     * @param testRecord 测评记录
     * @return 结果
     */
    public int insertTestRecord(TestRecord testRecord);

    /**
     * 修改测评记录
     * 
     * @param testRecord 测评记录
     * @return 结果
     */
    public int updateTestRecord(TestRecord testRecord);

    /**
     * 删除测评记录
     * 
     * @param testNo 测评记录ID
     * @return 结果
     */
    public int deleteTestRecordById(String testNo);

    /**
     * 批量删除测评记录
     * 
     * @param testNos 需要删除的数据ID
     * @return 结果
     */
    public int deleteTestRecordByIds(String[] testNos);
}
