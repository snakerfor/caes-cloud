package com.ruoyi.competition.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.competition.mapper.EssayPublishMapper;
import com.ruoyi.competition.domain.EssayPublish;
import com.ruoyi.competition.service.IEssayPublishService;
import com.ruoyi.common.core.text.Convert;

/**
 * 文章发布Service业务层处理
 * 
 * @author Random-pro
 * @date 2020-05-15
 */
@Service
public class EssayPublishServiceImpl implements IEssayPublishService
{
    @Autowired
    private EssayPublishMapper essayPublishMapper;

    /**
     * 查询文章发布
     * 
     * @param essayId 文章发布ID
     * @return 文章发布
     */
    @Override
    public EssayPublish selectEssayPublishById(Integer essayId)
    {
        return essayPublishMapper.selectEssayPublishById(essayId);
    }

    /**
     * 查询文章发布列表
     * 
     * @param essayPublish 文章发布
     * @return 文章发布
     */
    @Override
    public List<EssayPublish> selectEssayPublishList(EssayPublish essayPublish)
    {
        return essayPublishMapper.selectEssayPublishList(essayPublish);
    }

    /**
     * 新增文章发布
     * 
     * @param essayPublish 文章发布
     * @return 结果
     */
    @Override
    public int insertEssayPublish(EssayPublish essayPublish)
    {
        essayPublish.setCreateTime(DateUtils.getNowDate());
        return essayPublishMapper.insertEssayPublish(essayPublish);
    }

    /**
     * 修改文章发布
     * 
     * @param essayPublish 文章发布
     * @return 结果
     */
    @Override
    public int updateEssayPublish(EssayPublish essayPublish)
    {
        essayPublish.setUpdateTime(DateUtils.getNowDate());
        return essayPublishMapper.updateEssayPublish(essayPublish);
    }

    /**
     * 删除文章发布对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteEssayPublishByIds(String ids)
    {
        return essayPublishMapper.deleteEssayPublishByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除文章发布信息
     * 
     * @param essayId 文章发布ID
     * @return 结果
     */
    public int deleteEssayPublishById(Integer essayId)
    {
        return essayPublishMapper.deleteEssayPublishById(essayId);
    }
}
