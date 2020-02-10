package com.ruoyi.competition.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ruoyi.common.core.domain.R;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.competition.domain.competition;
import com.ruoyi.competition.service.IcompetitionService;

import java.util.UUID;

/**
 * 大赛作品申报提交 提供者
 * 
 * @author Random-pro
 * @date 2020-02-03
 */
@RestController
@RequestMapping("competitionSubmit")
public class competitionController extends BaseController
{
	@Autowired
	private IcompetitionService competitionService;
	
	/**
	 * 查询${tableComment}
	 */
	@GetMapping("get/{productionId}")
	public competition get(@PathVariable("productionId") String productionId)
	{
		return competitionService.selectcompetitionById(productionId);
	}
	
	/**
	 * 查询大赛作品申报提交列表
	 */
	@GetMapping("list")
	public R list(competition competition)
	{
		startPage();
        return result(competitionService.selectcompetitionList(competition));
	}
	
	
	/**
	 * 新增保存大赛作品申报提交
	 */
	@PostMapping("save")
	public R addSave(@RequestBody competition competition)
	{
		// 补充字段信息
		// 生成UUID作为主键ID
		String productionId = UUID.randomUUID().toString().replaceAll("-","");
		competition.setProductionId(productionId);
		// 创建者
		competition.setCreateUser(getLoginName());

		return toAjax(competitionService.insertcompetition(competition));
	}

	/**
	 * 教师 修改审核学生作品申报
	 */
	@PostMapping("review")
	//@GetMapping("review")
	public R teacherReview(@RequestBody competition competition)
	//public R teacherReview(competition competition)
	{
		// 更新修改者
		competition.setEditUser(getLoginName());
		return toAjax(competitionService.reviewcompetition(competition));
	}
	
	/**
	 * 删除${tableComment}
	 */
	@PostMapping("remove")
	public R remove(String ids)
	{		
		return toAjax(competitionService.deletecompetitionByIds(ids));
	}
	
}
