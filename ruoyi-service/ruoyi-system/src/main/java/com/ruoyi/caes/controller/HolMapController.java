package com.ruoyi.caes.controller;

import com.ruoyi.caes.domain.HolMap;
import com.ruoyi.caes.service.IHolMapService;
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
 * 霍兰德对照 提供者
 * 
 * @author snakerfor
 * @date 2019-10-08
 */
@RestController
@RequestMapping("holmap")
public class HolMapController extends BaseController
{
	
	@Autowired
	private IHolMapService holMapService;
	
	/**
	 * 查询${tableComment}
	 */
	@GetMapping("get/{holRes}")
	public HolMap get(@PathVariable("holRes") String holRes)
	{
		return holMapService.selectHolMapById(holRes);
		
	}
	
	/**
	 * 查询霍兰德对照列表
	 */
	@GetMapping("list")
	public R list(HolMap holMap)
	{
		startPage();
        return result(holMapService.selectHolMapList(holMap));
	}
	
	
	/**
	 * 新增保存霍兰德对照
	 */
	@PostMapping("save")
	public R addSave(@RequestBody HolMap holMap)
	{		
		return toAjax(holMapService.insertHolMap(holMap));
	}

	/**
	 * 修改保存霍兰德对照
	 */
	@PostMapping("update")
	public R editSave(@RequestBody HolMap holMap)
	{		
		return toAjax(holMapService.updateHolMap(holMap));
	}
	
	/**
	 * 删除${tableComment}
	 */
	@PostMapping("remove")
	public R remove(String ids)
	{		
		return toAjax(holMapService.deleteHolMapByIds(ids));
	}
	
}
