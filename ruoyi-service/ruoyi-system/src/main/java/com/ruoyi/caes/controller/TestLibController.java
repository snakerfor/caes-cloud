package com.ruoyi.caes.controller;

import com.ruoyi.caes.domain.TestLib;
import com.ruoyi.caes.service.ITestLibService;
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
 * 评测试题 提供者
 * 
 * @author snakerfor
 * @date 2019-09-10
 */
@RestController
@RequestMapping("ques")
public class TestLibController extends BaseController
{
	
	@Autowired
	private ITestLibService testLibService;
	
	/**
	 * 查询${tableComment}
	 */
	@GetMapping("get/{quesId}")
	public TestLib get(@PathVariable("quesId") Integer quesId)
	{
		return testLibService.selectTestLibById(quesId);
		
	}

	/**
	 * 查询${tableComment}
	 */
	@GetMapping("getByTypeId/{typeId}")
	public R getByTypeId(@PathVariable("typeId") Integer typeId)
	{
		TestLib testLib = new TestLib();
		testLib.setTypeId(typeId);
		return R.ok().put("rows",testLibService.selectTestLibList(testLib));

	}
	
	/**
	 * 查询评测试题列表
	 */
	@GetMapping("list")
	public R list(TestLib testLib)
	{
		startPage();
        return result(testLibService.selectTestLibList(testLib));
	}
	
	
	/**
	 * 新增保存评测试题
	 */
	@PostMapping("save")
	public R addSave(@RequestBody TestLib testLib)
	{		
		return toAjax(testLibService.insertTestLib(testLib));
	}

	/**
	 * 修改保存评测试题
	 */
	@PostMapping("update")
	public R editSave(@RequestBody TestLib testLib)
	{		
		return toAjax(testLibService.updateTestLib(testLib));
	}
	
	/**
	 * 删除${tableComment}
	 */
	@PostMapping("remove")
	public R remove(String ids)
	{		
		return toAjax(testLibService.deleteTestLibByIds(ids));
	}
	
}
