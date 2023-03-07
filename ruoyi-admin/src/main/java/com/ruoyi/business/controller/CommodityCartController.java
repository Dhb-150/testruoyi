package com.ruoyi.business.controller;

import com.ruoyi.business.controller.extend.CommodityCartExtendController;
import com.ruoyi.business.domain.CommodityCart;
import com.ruoyi.business.domain.page.CommodityCartPage;
import com.ruoyi.business.service.ICommodityCartService;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 购物车信息Controller
 *
 * @author zebra
 * @date 2021-01-09
 */
@Controller
@RequestMapping("/bussiness/commoditycart")
public class CommodityCartController extends CommodityCartExtendController {
    private String prefix = "bussiness/commoditycart";

    @Autowired
    private ICommodityCartService commodityCartService;

    //@RequiresPermissions("bussiness:commoditycart:view")
    @GetMapping()
    public String commoditycart(ModelMap mmap) {
        super.merchantAuth(mmap);
        return prefix + "/commoditycart";
    }

    /**
     * 查询购物车信息列表
     */
    //@RequiresPermissions("bussiness:commoditycart:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(CommodityCart commodityCart) {
        startPage();
        List<CommodityCart> list = commodityCartService.selectCommodityCartList(commodityCart);
        return getDataTable(super.getCommodityCartPage(list));
    }

    /**
     * 导出购物车信息列表
     */
    //@RequiresPermissions("bussiness:commoditycart:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(CommodityCart commodityCart) {
        List<CommodityCart> list = commodityCartService.selectCommodityCartList(commodityCart);
        ExcelUtil<CommodityCartPage> util = new ExcelUtil<CommodityCartPage>(CommodityCartPage.class);
        return util.exportExcel(super.getCommodityCartPage(list), "购物车信息");
    }

    /**
     * 新增购物车信息
     */
    @GetMapping("/add")
    public String add() {
        return prefix + "/add";
    }

    /**
     * 新增保存购物车信息
     */
    //@RequiresPermissions("bussiness:commoditycart:add")
    @Log(title = "购物车信息", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(CommodityCart commodityCart) {
        return toAjax(commodityCartService.insertCommodityCart(commodityCart));
    }

    /**
     * 修改购物车信息
     */
    @GetMapping("/edit/{cartId}")
    public String edit(@PathVariable("cartId") String cartId, ModelMap mmap) {
        CommodityCart commodityCart = commodityCartService.selectCommodityCartById(cartId);
        mmap.put("commodityCart", commodityCart);
        return prefix + "/edit";
    }

    /**
     * 修改保存购物车信息
     */
    //@RequiresPermissions("bussiness:commoditycart:edit")
    @Log(title = "购物车信息", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(CommodityCart commodityCart) {
        return toAjax(commodityCartService.updateCommodityCart(commodityCart));
    }

    /**
     * 删除购物车信息
     */
    //@RequiresPermissions("bussiness:commoditycart:remove")
    @Log(title = "购物车信息", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(commodityCartService.deleteCommodityCartByIds(ids));
    }
}
