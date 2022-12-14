package com.ruoyi.eeas.mapper;

import java.util.List;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ruoyi.eeas.domain.NumberChange;

/**
 * 病例变化数据Mapper接口
 * 
 * @author zhouxinxing
 * @date 2022-09-29
 */
public interface NumberChangeMapper extends BaseMapper<NumberChange>
{
    /**
     * 查询病例变化数据
     * 
     * @param id 病例变化数据主键
     * @return 病例变化数据
     */
    NumberChange selectNumberChangeById(Long id);

    /**
     * 查询病例变化数据列表
     * 
     * @param numberChange 病例变化数据
     * @return 病例变化数据集合
     */
    List<NumberChange> selectNumberChangeList(NumberChange numberChange);

    /**
     * 新增病例变化数据
     * 
     * @param numberChange 病例变化数据
     * @return 结果
     */
    int insertNumberChange(NumberChange numberChange);

    /**
     * 修改病例变化数据
     * 
     * @param numberChange 病例变化数据
     * @return 结果
     */
    int updateNumberChange(NumberChange numberChange);

    /**
     * 删除病例变化数据
     * 
     * @param id 病例变化数据主键
     * @return 结果
     */
    int deleteNumberChangeById(Long id);

    /**
     * 批量删除病例变化数据
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    int deleteNumberChangeByIds(Long[] ids);
}
