package com.ruoyi.business.domain.page;

import com.ruoyi.business.domain.CommodityOrderDeputy;
import com.ruoyi.common.annotation.Excel;
import lombok.Getter;
import lombok.Setter;

/**
 * @author yanshuangbin
 * @date 2021-01-09 18:07
 */
@Setter
@Getter
public class CommodityOrderDeputyPage extends CommodityOrderDeputy {
    /**
     * 产品名称
     */
    @Excel(name = "产品名称")
    private String commodityName;
}
