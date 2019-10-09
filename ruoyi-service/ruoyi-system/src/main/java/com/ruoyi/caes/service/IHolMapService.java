package com.ruoyi.caes.service;

import com.ruoyi.caes.domain.HolMap;
import java.util.List;

/**
 * 霍兰德对照Service接口
 * 
 * @author snakerfor
 * @date 2019-10-08
 */
public interface IHolMapService 
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
     * 批量删除霍兰德对照
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteHolMapByIds(String ids);

    /**
     * 删除霍兰德对照信息
     * 
     * @param holRes 霍兰德对照ID
     * @return 结果
     */
    public int deleteHolMapById(String holRes);
}
