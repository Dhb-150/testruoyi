package com.ruoyi.business.service.impl;

import com.ruoyi.business.annotation.AuthMerchantAnnotaion;
import com.ruoyi.business.domain.CommodityInfo;
import com.ruoyi.business.mapper.CommodityInfoMapper;
import com.ruoyi.business.service.ICommodityInfoService;
import com.ruoyi.common.core.text.Convert;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 产品信息Service业务层处理
 *
 * @author zebra
 * @date 2020-06-05
 */
@Service
public class CommodityInfoServiceImpl implements ICommodityInfoService {
    @Autowired
    private CommodityInfoMapper commodityInfoMapper;

    /**
     * 查询产品信息
     *
     * @param commodityId 产品信息ID
     * @return 产品信息
     */
    @Override
    public CommodityInfo selectCommodityInfoById(String commodityId) {
        return commodityInfoMapper.selectCommodityInfoById(commodityId);
    }

    /**
     * 查询产品信息列表
     *
     * @param commodityInfo 产品信息
     * @return 产品信息
     */
    @Override
    @AuthMerchantAnnotaion
    public List<CommodityInfo> selectCommodityInfoList(CommodityInfo commodityInfo) {
        return commodityInfoMapper.selectCommodityInfoList(commodityInfo);
    }

    /**
     * 新增产品信息
     *
     * @param commodityInfo 产品信息
     * @return 结果
     */
    @Override
    public int insertCommodityInfo(CommodityInfo commodityInfo) {
        commodityInfo.setCreateTime(DateUtils.getNowDate());
        commodityInfo.setUpdateTime(DateUtils.getNowDate());
        commodityInfo.setUpdateBy(SecurityUtils.getUsername());
        commodityInfo.setDataVerFlag(1l);
        return commodityInfoMapper.insertCommodityInfo(commodityInfo);
    }

    /**
     * 修改产品信息
     *
     * @param commodityInfo 产品信息
     * @return 结果
     */
    @Override
    public int updateCommodityInfo(CommodityInfo commodityInfo) {
        commodityInfo.setUpdateTime(DateUtils.getNowDate());
        commodityInfo.setUpdateBy(SecurityUtils.getUsername());
        return commodityInfoMapper.updateCommodityInfo(commodityInfo);
    }

    /**
     * 删除产品信息对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteCommodityInfoByIds(String ids) {
        return commodityInfoMapper.deleteCommodityInfoByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除产品信息信息
     *
     * @param commodityId 产品信息ID
     * @return 结果
     */
    @Override
    public int deleteCommodityInfoById(String commodityId) {
        return commodityInfoMapper.deleteCommodityInfoById(commodityId);
    }
}
