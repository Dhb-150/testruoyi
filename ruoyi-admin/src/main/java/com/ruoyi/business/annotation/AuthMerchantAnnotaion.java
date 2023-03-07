package com.ruoyi.business.annotation;

import com.ruoyi.business.constant.Constants;
import java.lang.annotation.*;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface AuthMerchantAnnotaion {
	/**
	 * 表的别名
	 */
	public String tableAlias() default "";

	/**
	 * 权限字段
	 */
	public String fieldAlias() default Constants.AUTH_FILED;

}
