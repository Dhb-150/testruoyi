package com.ruoyi.business.domain.page;

import com.ruoyi.business.domain.CommodityOrder;
import com.ruoyi.common.annotation.Excel;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CommodityOrderPage extends CommodityOrder {
    private static final long serialVersionUID = 1L;

    @Excel(name = "所属商户")
    private String merchantName;

}
