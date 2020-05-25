package com.ruoyi.competition.controller;

import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.competition.domain.Essay;
import com.ruoyi.competition.domain.EssayAttachment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ruoyi.common.core.domain.R;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.competition.domain.EssayPublish;
import com.ruoyi.competition.service.IEssayPublishService;
import com.ruoyi.competition.service.IEssayAttachmentService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 文章发布 提供者
 * 
 * @author Random-pro
 * @date 2020-05-15
 */
@RestController
@RequestMapping("publish")
public class EssayPublishController extends BaseController
{
	@Autowired
	private IEssayPublishService essayPublishService;
	@Autowired
	private IEssayAttachmentService essayAttachmentService;

	/**
	 * 文章详情查询${tableComment}
	 */
	@GetMapping("get/{essayId}")
	public EssayPublish get(@PathVariable("essayId") Integer essayId)
	{
		EssayPublish publish = essayPublishService.selectEssayPublishById(essayId);
		publish.setViewCount(publish.getViewCount() + 1);
		essayPublishService.updateEssayPublish(publish);
		return publish;
	}
	
	/**
	 * essayType essayTitle essayContent条件取得文章发布列表
	 */
	@GetMapping("list")
	public R list(EssayPublish essayPublish)
	{
		startPage();
        return result(essayPublishService.selectEssayPublishList(essayPublish));
	}

	/**
	 * 新增保存文章发布
	 */
	@PostMapping("save")
	public R addSave(@RequestBody Essay essay)
	{
		Integer attachmentId = essay.attachment.size() > 0 ? (int) System.currentTimeMillis() : null;// 时间戳做attachmentId
		// 遍历插入附件id
		for(EssayAttachment attachment : essay.attachment)
		{
			attachment.setAttachmentId(attachmentId);
			essayAttachmentService.insertEssayAttachment(attachment);
		}
		// 插入文章记录
		essay.publish.setViewCount(0);
		essay.publish.setAttachmentId(attachmentId);
		essay.publish.setCreateBy(getLoginName());// 从gateway访问携带loginname
		essay.publish.setCreateTime(DateUtils.getNowDate());
		return toAjax(essayPublishService.insertEssayPublish(essay.publish));
	}

	/**
	 * 修改保存文章发布
	 */
	@PostMapping("update")
	public R editSave(@RequestBody Essay essay)
	{
		// 提交的两种特殊状态 附件的新增及删除
		boolean addAttachment = false;
		boolean deleteAttachment = false;
		Integer attachmentId = (int) System.currentTimeMillis();

		EssayPublish publish = essayPublishService.selectEssayPublishById(essay.publish.getEssayId());
		// 附件新增：文章对应的attachmentId=null && 提交过来的attachment非空
		addAttachment = (publish.getFileIds() == null && !essay.attachment.isEmpty());
		// 附件删除：文章对应的attachmentId!=null && 提交过来的attachment为空
		deleteAttachment = (publish.getFileIds() != null && essay.attachment.isEmpty());

		if(!addAttachment)
		essayAttachmentService.deleteEssayAttachmentById(publish.getAttachmentId());

		if(!deleteAttachment)
		for(EssayAttachment attachment : essay.attachment)
		{
			attachment.setAttachmentId(addAttachment ? attachmentId : publish.getAttachmentId());
			essayAttachmentService.insertEssayAttachment(attachment);
		}
		essay.publish.setUpdateBy(getLoginName());
		essay.publish.setUpdateTime(DateUtils.getNowDate());

		if(deleteAttachment)
			essay.publish.setAttachmentId(null);
		else if(addAttachment)
			essay.publish.setAttachmentId(attachmentId);
		else
			essay.publish.setAttachmentId(publish.getAttachmentId());
		return toAjax(essayPublishService.updateEssayPublish(essay.publish));
	}
	
	/**
	 * 删除${tableComment}
	 */
	@PostMapping("remove")
	public R remove(int essayId)
	{
		EssayPublish publish = essayPublishService.selectEssayPublishById(essayId);
		essayAttachmentService.deleteEssayAttachmentById(publish.getAttachmentId());
		return toAjax(essayPublishService.deleteEssayPublishById(essayId));
	}
	
}
