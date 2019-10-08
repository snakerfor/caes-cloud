package com.ruoyi.caes.controller;

import com.ruoyi.caes.domain.HolMap;
import com.ruoyi.caes.domain.TestRecord;
import com.ruoyi.caes.domain.TestSumbit;
import com.ruoyi.caes.service.IHolMapService;
import com.ruoyi.caes.service.ITestRecordService;
import com.ruoyi.caes.service.ITestSumbitService;
import com.ruoyi.common.utils.StringUtils;
import org.apache.poi.hssf.record.crypto.Biff8EncryptionKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ruoyi.common.core.domain.R;
import com.ruoyi.common.core.controller.BaseController;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * 测评提交 提供者
 * 
 * @author snakerfor
 * @date 2019-10-06
 */
@RestController
@RequestMapping("sumbit")
public class TestSumbitController extends BaseController
{
	
	@Autowired
	private ITestSumbitService testSumbitService;

	@Autowired
	private ITestRecordService testRecordService;

	@Autowired
	private IHolMapService holMapService;



	/**
	 * 查询${tableComment}
	 */
	@GetMapping("get/{sumbitId}")
	public TestSumbit get(@PathVariable("sumbitId") Long sumbitId)
	{
		return testSumbitService.selectTestSumbitById(sumbitId);
	}
	
	/**
	 * 查询测评提交列表
	 */
	@GetMapping("list")
	public R list(TestSumbit testSumbit)
	{
		startPage();
        return result(testSumbitService.selectTestSumbitList(testSumbit));
	}
	
	
	/**
	 * 新增保存测评提交
	 */
	@PostMapping("save")
	public R addSave(@RequestBody List<TestSumbit> testSumbits)
	{
		TestRecord testRecord = new TestRecord();
		testRecord.setUserId(getCurrentUserId());
		//专业报考测评 类型
		testRecord.setTypeId(1);
		testRecord.setCreateBy(getLoginName());
		testRecordService.insertTestRecord(testRecord);
		for (TestSumbit testSumbit : testSumbits) {
			testSumbit.setTestNo(testRecord.getTestNo());
			logger.debug(testRecord.getTestNo());
			testSumbit.setUserId(getCurrentUserId());
			testSumbitService.insertTestSumbit(testSumbit);
		}
		List<Map<String, Object>> calcResult =  testSumbitService.selectCalcScore(testRecord.getTestNo());
		Map<String, Integer> calcScore = new LinkedHashMap<String, Integer>();
		for (Map<String, Object> map : calcResult) {
			calcScore.put((String) map.get("quesSort"),Integer.parseInt(map.get("score").toString()));
		}
		Map<String,Integer> calcOrder = sortByValue(calcScore);
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
		testRecordService.updateTestRecord(testRecord);
//		return toAjax(testSumbitService.insertTestSumbit(testSumbit));
		HolMap holMap = holMapService.selectHolMapById(testRecord.getTestResult());
		if(holMap == null){
			holMap = new HolMap();
		}
		if(StringUtils.isEmpty(holMap.getMajor())){
			holMap.setMajor("旅游管理、旅游管理、连锁经营管理、酒店管理");
		}
		return toAjax(1).put("data",holMap);
	}

	/**
	 * 修改保存测评提交
	 */
	@PostMapping("update")
	public R editSave(@RequestBody TestSumbit testSumbit)
	{		
		return toAjax(testSumbitService.updateTestSumbit(testSumbit));
	}
	
	/**
	 * 删除${tableComment}
	 */
	@PostMapping("remove")
	public R remove(String ids)
	{		
		return toAjax(testSumbitService.deleteTestSumbitByIds(ids));
	}


	public <K, V extends Comparable<? super V>> Map<K, V> sortByValue(Map<K, V> map) {
		Map<K, V> result = new LinkedHashMap<>();

		map.entrySet().stream()
				.sorted(Map.Entry.<K, V>comparingByValue()
						.reversed()).forEachOrdered(e -> result.put(e.getKey(), e.getValue()));
		return result;
	}
}
