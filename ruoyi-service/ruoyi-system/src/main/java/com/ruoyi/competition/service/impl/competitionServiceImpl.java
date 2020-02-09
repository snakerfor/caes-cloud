package com.ruoyi.competition.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.competition.mapper.competitionMapper;
import com.ruoyi.competition.domain.competition;
import com.ruoyi.competition.service.IcompetitionService;
import com.ruoyi.common.core.text.Convert;

/**
 * 大赛作品申报提交Service业务层处理
 * 
 * @author Random-pro
 * @date 2020-02-03
 */
@Service
public class competitionServiceImpl implements IcompetitionService 
{
    @Autowired
    private competitionMapper competitionMapper;

    /**
     * 查询大赛作品申报提交
     * 
     * @param productionId 大赛作品申报提交ID
     * @return 大赛作品申报提交
     */
    @Override
    public competition selectcompetitionById(String productionId)
    {
        return competitionMapper.selectcompetitionById(productionId);
    }

    /**
     * 查询大赛作品申报提交列表
     * 
     * @param competition 大赛作品申报提交
     * @return 大赛作品申报提交
     */
    @Override
    public List<competition> selectcompetitionList(competition competition)
    {
        return competitionMapper.selectcompetitionList(competition);
    }

    /**
     * 新增大赛作品申报提交
     * 
     * @param competition 大赛作品申报提交
     * @return 结果
     */
    @Override
    public int insertcompetition(competition competition)
    {
        competition.setCreateTime(DateUtils.getNowDate());
        return competitionMapper.insertcompetition(competition);
    }

    /**
     * 教师审核大赛作品申报
     * 
     * @param competition 大赛作品申报提交
     * @return 结果
     */
    @Override
    public int reviewcompetition(competition competition)
    {
        competition.setUpdateTime(DateUtils.getNowDate());
        return competitionMapper.reviewcompetition(competition);
    }

    /**
     * 删除大赛作品申报提交对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deletecompetitionByIds(String ids)
    {
        return competitionMapper.deletecompetitionByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除大赛作品申报提交信息
     * 
     * @param productionId 大赛作品申报提交ID
     * @return 结果
     */
    public int deletecompetitionById(String productionId)
    {
        return competitionMapper.deletecompetitionById(productionId);
    }
}
