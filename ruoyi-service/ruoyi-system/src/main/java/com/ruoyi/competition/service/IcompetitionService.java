package com.ruoyi.competition.service;

import com.ruoyi.competition.domain.competition;
import java.util.List;

/**
 * 大赛作品申报提交Service接口
 * 
 * @author Random-pro
 * @date 2020-02-03
 */
public interface IcompetitionService 
{
    /**
     * 查询大赛作品申报提交
     * 
     * @param productionId 大赛作品申报提交ID
     * @return 大赛作品申报提交
     */
    public competition selectcompetitionById(String productionId);

    /**
     * 查询大赛作品申报提交列表
     * 
     * @param competition 大赛作品申报提交
     * @return 大赛作品申报提交集合
     */
    public List<competition> selectcompetitionList(competition competition);

    /**
     * 新增大赛作品申报提交
     * 
     * @param competition 大赛作品申报提交
     * @return 结果
     */
    public int insertcompetition(competition competition);

    /**
     * 修改大赛作品申报提交
     * 
     * @param competition 大赛作品申报提交
     * @return 结果
     */
    public int updatecompetition(competition competition);

    /**
     * 批量删除大赛作品申报提交
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deletecompetitionByIds(String ids);

    /**
     * 删除大赛作品申报提交信息
     * 
     * @param productionId 大赛作品申报提交ID
     * @return 结果
     */
    public int deletecompetitionById(String productionId);
}
