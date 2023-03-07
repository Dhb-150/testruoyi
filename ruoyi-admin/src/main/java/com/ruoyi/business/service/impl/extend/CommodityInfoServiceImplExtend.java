package com.ruoyi.business.service.impl.extend;


import com.ruoyi.business.domain.CommodityCategory;
import com.ruoyi.business.domain.SpecsType;
import com.ruoyi.business.mapper.CommodityCategoryMapper;
import com.ruoyi.business.mapper.SpecsTypeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

public class CommodityInfoServiceImplExtend extends BaseServiceImplExtend {
    @Autowired
    private CommodityCategoryMapper commodityCategoryMapper;
    @Autowired
    private SpecsTypeMapper specsTypeMapper;

    protected String getCategoryName(String categoryId) {
        CommodityCategory commodityCategory = commodityCategoryMapper.selectByPrimaryKey(categoryId);
        if (commodityCategory != null)
            return commodityCategory.getCategoryName();
        return null;
    }

    protected List<SpecsType> getSpecsTypeList() {
        Example example = new Example(SpecsType.class);
        example.setOrderByClause(" zebra_order asc");
        return specsTypeMapper.selectByExample(example);
    }
}
