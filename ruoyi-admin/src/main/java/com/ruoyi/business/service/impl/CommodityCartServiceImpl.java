package com.ruoyi.business.service.impl;

import com.ruoyi.business.domain.CommodityCart;
import com.ruoyi.business.mapper.CommodityCartMapper;
import com.ruoyi.business.service.ICommodityCartService;
import com.ruoyi.common.core.text.Convert;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 购物车信息Service业务层处理
 * 
 * @author zebra
 * @date 2021-01-09
 */
@Service
public class CommodityCartServiceImpl implements ICommodityCartService {
    @Autowired
    private CommodityCartMapper commodityCartMapper;



    /**
     * 查询购物车信息
     * 
     * @param cartId 购物车信息ID
     * @return 购物车信息
     */
    @Override
    public CommodityCart selectCommodityCartById(String cartId)
    {

        return commodityCartMapper.selectCommodityCartById(cartId);
    }

    /**
     * 查询购物车信息列表
     * 
     * @param commodityCart 购物车信息
     * @return 购物车信息
     */
    @Override
    public List<CommodityCart> selectCommodityCartList(CommodityCart commodityCart)
    {
        return commodityCartMapper.selectCommodityCartList(commodityCart);
    }

    /**
     * 新增购物车信息
     * 
     * @param commodityCart 购物车信息
     * @return 结果
     */
    @Override
    public int insertCommodityCart(CommodityCart commodityCart)
    {
        commodityCart.setCreateTime(DateUtils.getNowDate());
        commodityCart.setUpdateTime(DateUtils.getNowDate());
        commodityCart.setUpdateBy(SecurityUtils.getUsername());
        return commodityCartMapper.insertCommodityCart(commodityCart);
    }

    /**
     * 修改购物车信息
     * 
     * @param commodityCart 购物车信息
     * @return 结果
     */
    @Override
    public int updateCommodityCart(CommodityCart commodityCart)
    {
        commodityCart.setUpdateTime(DateUtils.getNowDate());
        commodityCart.setUpdateBy(SecurityUtils.getUsername());
        return commodityCartMapper.updateCommodityCart(commodityCart);
    }

    /**
     * 删除购物车信息对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteCommodityCartByIds(String ids)
    {
        return commodityCartMapper.deleteCommodityCartByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除购物车信息信息
     * 
     * @param cartId 购物车信息ID
     * @return 结果
     */
    @Override
    public int deleteCommodityCartById(String cartId)
    {
        return commodityCartMapper.deleteCommodityCartById(cartId);
    }
}
