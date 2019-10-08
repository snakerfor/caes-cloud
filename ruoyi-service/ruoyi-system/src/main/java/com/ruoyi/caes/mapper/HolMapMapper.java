package com.ruoyi.caes.mapper;

import com.ruoyi.caes.domain.HolMap;
import java.util.List;

/**
 * 霍兰德对照Mapper接口
 * 
 * @author snakerfor
 * @date 2019-10-08
 */
public interface HolMapMapper 
{
    /**
     * 查询霍兰德对照
     * 
     * @param holRes 霍兰德对照ID
     * @return 霍兰德对照
     */
    public HolMap selectHolMapById(String holRes);

    /**
     * 查询霍兰德对照列表
     * 
     * @param holMap 霍兰德对照
     * @return 霍兰德对照集合
     */
    public List<HolMap> selectHolMapList(HolMap holMap);

    /**
     * 新增霍兰德对照
     * 
     * @param holMap 霍兰德对照
     * @return 结果
     */
    public int insertHolMap(HolMap holMap);

    /**
     * 修改霍兰德对照
     * 
     * @param holMap 霍兰德对照
     * @return 结果
     */
    public int updateHolMap(HolMap holMap);

    /**
     * 删除霍兰德对照
     * 
     * @param holRes 霍兰德对照ID
     * @return 结果
     */
    public int deleteHolMapById(String holRes);

    /**
     * 批量删除霍兰德对照
     * 
     * @param holRess 需要删除的数据ID
     * @return 结果
     */
    public int deleteHolMapByIds(String[] holRess);
}
