package com.ruoyi.caes.service.impl;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.ruoyi.caes.domain.HolMap;
import com.ruoyi.caes.domain.TestRecord;
import com.ruoyi.caes.mapper.HolMapMapper;
import com.ruoyi.caes.mapper.TestRecordMapper;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.utils.StringTool;
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
    @Autowired
    private TestRecordMapper testRecordMapper;
    @Autowired
    private HolMapMapper holMapMapper;

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

    @Override
    public Map<String, Object> getMajorTest(List<TestSumbit> testSumbits, Long userId, String userName){
        Map<String, Object> remap = new HashMap<>();
        TestRecord testRecord = new TestRecord();
        testRecord.setUserId(userId);
        //专业报考测评 类型
        testRecord.setTypeId(1);
        testRecord.setCreateBy(userName);
        testRecordMapper.insertTestRecord(testRecord);
        for (TestSumbit testSumbit : testSumbits) {
            testSumbit.setTestNo(testRecord.getTestNo());
            testSumbit.setUserId(userId);
            testSumbitMapper.insertTestSumbit(testSumbit);
        }
        List<Map<String, Object>> calcResult =  testSumbitMapper.selectCalcScore(testRecord.getTestNo());
        Map<String, Integer> calcScore = new LinkedHashMap<String, Integer>();
        for (Map<String, Object> map : calcResult) {
            calcScore.put((String) map.get("quesSort"),Integer.parseInt(map.get("score").toString()));
        }
        Map<String,Integer> calcOrder = StringTool.sortByValue(calcScore);
        int count = 0;
        StringBuffer st = new StringBuffer();
        StringBuffer rt = new StringBuffer();
        for (Map.Entry<String, Integer> entry : calcOrder.entrySet()) {
            System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
            st.append(entry.getKey()+"="+entry.getValue()+",");
            if(count < 3){
                rt.append(entry.getKey());
                count++;
            }
        }
        testRecord.setTestScore(st.substring(0,st.length()-1));
        testRecord.setTestResult(rt.toString());
        testRecordMapper.updateTestRecord(testRecord);
        remap.put("holSort",st);
        remap.put("holResult",rt);
        HolMap holMap = holMapMapper.selectHolMapById(testRecord.getTestResult());
        if(holMap == null || StringUtils.isEmpty(holMap.getMajor())){
            remap.put("advMajors","旅游管理、旅游管理、连锁经营管理、酒店管理");
        }else {
            remap.put("advMajors",holMap.getMajor());
        }
        return remap;
    }
    @Override
    public Map<String, Object> getCreateTest(List<TestSumbit> testSumbits, Long userId, String userName){
        Map<String,Object> remap = new HashMap<String,Object>();
        TestRecord testRecord = new TestRecord();
        testRecord.setUserId(userId);
        //专业报考测评 类型
        testRecord.setTypeId(2);
        testRecord.setCreateBy(userName);
        testRecordMapper.insertTestRecord(testRecord);
        for (TestSumbit testSumbit : testSumbits) {
            testSumbit.setTestNo(testRecord.getTestNo());
            testSumbit.setUserId(userId);
            testSumbitMapper.insertTestSumbit(testSumbit);
        }
        Map<String, Object> objectMap = testSumbitMapper.selectCreateScore(testRecord.getTestNo());
        Integer score = Integer.parseInt(objectMap.get("score").toString());
        remap.put("score",score);
        if(score < 10){
            remap.put("result","创新创业能力较弱");
        }else if (score >= 10 && score < 15 ){
            remap.put("result","创新创业能力良好");
        }else {
            remap.put("result","创新创业能力较强");
        }
        return remap;
    }

}
