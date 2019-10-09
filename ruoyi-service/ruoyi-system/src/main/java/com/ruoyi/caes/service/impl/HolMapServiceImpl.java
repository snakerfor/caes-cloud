package com.ruoyi.caes.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.caes.mapper.HolMapMapper;
import com.ruoyi.caes.domain.HolMap;
import com.ruoyi.caes.service.IHolMapService;
import com.ruoyi.common.core.text.Convert;

/**
 * 霍兰德对照Service业务层处理
 * 
 * @author snakerfor
 * @date 2019-10-08
 */
@Service
public class HolMapServiceImpl implements IHolMapService 
{
    @Autowired
    private HolMapMapper holMapMapper;

    /**
     * 查询霍兰德对照
     * 
     * @param holRes 霍兰德对照ID
     * @return 霍兰德对照
     */
    @Override
    public HolMap selectHolMapById(String holRes)
    {
        return holMapMapper.selectHolMapById(holRes);
    }

    /**
     * 查询霍兰德对照列表
     * 
     * @param holMap 霍兰德对照
     * @return 霍兰德对照
     */
    @Override
    public List<HolMap> selectHolMapList(HolMap holMap)
    {
        return holMapMapper.selectHolMapList(holMap);
    }

    /**
     * 新增霍兰德对照
     * 
     * @param holMap 霍兰德对照
     * @return 结果
     */
    @Override
    public int insertHolMap(HolMap holMap)
    {
        return holMapMapper.insertHolMap(holMap);
    }

    /**
     * 修改霍兰德对照
     * 
     * @param holMap 霍兰德对照
     * @return 结果
     */
    @Override
    public int updateHolMap(HolMap holMap)
    {
        return holMapMapper.updateHolMap(holMap);
    }

    /**
     * 删除霍兰德对照对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteHolMapByIds(String ids)
    {
        return holMapMapper.deleteHolMapByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除霍兰德对照信息
     * 
     * @param holRes 霍兰德对照ID
     * @return 结果
     */
    public int deleteHolMapById(String holRes)
    {
        return holMapMapper.deleteHolMapById(holRes);
    }
}
