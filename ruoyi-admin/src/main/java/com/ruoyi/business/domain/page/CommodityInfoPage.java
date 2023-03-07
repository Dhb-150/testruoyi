package com.ruoyi.business.domain.page;

import com.ruoyi.business.domain.CommodityInfo;
import com.ruoyi.common.annotation.Excel;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CommodityInfoPage extends CommodityInfo {
    private static final long serialVersionUID = 1L;

    @Excel(name = "所属商户")
    private String merchantName;

    @Excel(name = "类别名称")
    private String categoryName;
}
