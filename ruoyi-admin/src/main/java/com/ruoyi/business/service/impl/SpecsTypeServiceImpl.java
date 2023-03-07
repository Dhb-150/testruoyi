package com.ruoyi.business.service.impl;

import com.ruoyi.business.domain.SpecsType;
import com.ruoyi.business.mapper.SpecsTypeMapper;
import com.ruoyi.business.service.ISpecsTypeService;
import com.ruoyi.business.service.impl.extend.BaseServiceImplExtend;
import com.ruoyi.common.core.text.Convert;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 规格类型Service业务层处理
 *
 * @author zebra
 * @date 2020-09-15
 */
@Service
public class SpecsTypeServiceImpl extends BaseServiceImplExtend implements ISpecsTypeService {
    @Autowired
    private SpecsTypeMapper specsTypeMapper;

    /**
     * 查询规格类型
     *
     * @param specsTypeId 规格类型ID
     * @return 规格类型
     */
    @Override
    public SpecsType selectSpecsTypeById(String specsTypeId) {
        return specsTypeMapper.selectSpecsTypeById(specsTypeId);
    }

    /**
     * 查询规格类型列表
     *
     * @param specsType 规格类型
     * @return 规格类型
     */
    @Override
    public List<SpecsType> selectSpecsTypeList(SpecsType specsType) {
        return specsTypeMapper.selectSpecsTypeList(specsType);
    }

    /**
     * 新增规格类型
     *
     * @param specsType 规格类型
     * @return 结果
     */
    @Override
    public int insertSpecsType(SpecsType specsType) {
        specsType.setSpecsTypeId(super.getUid());
        specsType.setCreateTime(DateUtils.getNowDate());
        specsType.setUpdateTime(DateUtils.getNowDate());
        specsType.setUpdateBy(SecurityUtils.getUsername());
        return specsTypeMapper.insertSpecsType(specsType);
    }

    /**
     * 修改规格类型
     *
     * @param specsType 规格类型
     * @return 结果
     */
    @Override
    public int updateSpecsType(SpecsType specsType) {
        specsType.setUpdateTime(DateUtils.getNowDate());
        specsType.setUpdateBy(SecurityUtils.getUsername());
        return specsTypeMapper.updateSpecsType(specsType);
    }

    /**
     * 删除规格类型对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteSpecsTypeByIds(String ids) {
        return specsTypeMapper.deleteSpecsTypeByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除规格类型信息
     *
     * @param specsTypeId 规格类型ID
     * @return 结果
     */
    @Override
    public int deleteSpecsTypeById(String specsTypeId) {
        return specsTypeMapper.deleteSpecsTypeById(specsTypeId);
    }
}
