package com.ruoyi.business.domain.page;

import com.ruoyi.business.domain.UserAccount;
import com.ruoyi.common.annotation.Excel;
import lombok.Getter;
import lombok.Setter;

/**
 * @author yanshuangbin
 * @date 2021-01-25 10:28
 */
@Setter
@Getter
public class UserAccountPage extends UserAccount {
    @Excel(name = "用户信息")
    private String userName;
}
