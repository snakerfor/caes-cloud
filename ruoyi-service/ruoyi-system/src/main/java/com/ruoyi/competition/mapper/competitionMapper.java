package com.ruoyi.competition.mapper;

import com.ruoyi.competition.domain.competition;
import java.util.List;

/**
 * 大赛作品申报提交Mapper接口
 * 
 * @author Random-pro
 * @date 2020-02-03
 */
public interface competitionMapper 
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
     * 删除大赛作品申报提交
     * 
     * @param productionId 大赛作品申报提交ID
     * @return 结果
     */
    public int deletecompetitionById(String productionId);

    /**
     * 批量删除大赛作品申报提交
     * 
     * @param productionIds 需要删除的数据ID
     * @return 结果
     */
    public int deletecompetitionByIds(String[] productionIds);
}
