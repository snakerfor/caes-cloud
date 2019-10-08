package com.ruoyi.caes.controller;

import com.ruoyi.caes.domain.TestRecord;
import com.ruoyi.caes.service.ITestRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ruoyi.common.core.domain.R;
import com.ruoyi.common.core.controller.BaseController;

/**
 * 测评记录 提供者
 * 
 * @author snakerfor
 * @date 2019-10-06
 */
@RestController
@RequestMapping("record")
public class TestRecordController extends BaseController
{
	
	@Autowired
	private ITestRecordService testRecordService;
	
	/**
	 * 查询${tableComment}
	 */
	@GetMapping("get/{testNo}")
	public TestRecord get(@PathVariable("testNo") String testNo)
	{
		return testRecordService.selectTestRecordById(testNo);
		
	}
	
	/**
	 * 查询测评记录列表
	 */
	@GetMapping("list")
	public R list(TestRecord testRecord)
	{
		startPage();
        return result(testRecordService.selectTestRecordList(testRecord));
	}
	
	
	/**
	 * 新增保存测评记录
	 */
	@PostMapping("save")
	public R addSave(@RequestBody TestRecord testRecord)
	{		
		return toAjax(testRecordService.insertTestRecord(testRecord));
	}

	/**
	 * 修改保存测评记录
	 */
	@PostMapping("update")
	public R editSave(@RequestBody TestRecord testRecord)
	{		
		return toAjax(testRecordService.updateTestRecord(testRecord));
	}
	
	/**
	 * 删除${tableComment}
	 */
	@PostMapping("remove")
	public R remove(String ids)
	{		
		return toAjax(testRecordService.deleteTestRecordByIds(ids));
	}
	
}
