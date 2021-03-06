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
	 * 新增保存测评提交(专业报考测评)
	 */
	@PostMapping("saveMajor")
	public R saveMajor(@RequestBody List<TestSumbit> testSumbits)
	{
		return toAjax(1).put("data",testSumbitService.getMajorTest(testSumbits,getCurrentUserId(),getLoginName()));
	}

	/**
	 * 新增保存测评提交（创新创业能力）
	 */
	@PostMapping("saveCreate")
	public R saveCreate(@RequestBody List<TestSumbit> testSumbits)
	{
		return toAjax(1).put("data",testSumbitService.getCreateTest(testSumbits,getCurrentUserId(),getLoginName()));
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

}
