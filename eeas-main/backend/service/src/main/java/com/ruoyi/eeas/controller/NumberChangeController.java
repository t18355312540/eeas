package com.ruoyi.eeas.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.eeas.domain.NumberChange;
import com.ruoyi.eeas.service.INumberChangeService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 病例变化数据Controller
 * 
 * @author zhouxinxing
 * @date 2022-09-29
 */
@RestController
@RequestMapping("/data/change")
public class NumberChangeController extends BaseController
{
    @Autowired
    private INumberChangeService numberChangeService;

    /**
     * 查询病例变化数据列表
     */
    @PreAuthorize("@ss.hasPermi('data:change:list')")
    @GetMapping("/list")
    public TableDataInfo list(NumberChange numberChange)
    {
        startPage();
        List<NumberChange> list = numberChangeService.selectNumberChangeList(numberChange);
        return getDataTable(list);
    }

    /**
     * 导出病例变化数据列表
     */
    @PreAuthorize("@ss.hasPermi('data:change:export')")
    @Log(title = "病例变化数据", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, NumberChange numberChange)
    {
        List<NumberChange> list = numberChangeService.selectNumberChangeList(numberChange);
        ExcelUtil<NumberChange> util = new ExcelUtil<NumberChange>(NumberChange.class);
        util.exportExcel(response, list, "病例变化数据数据");
    }

    /**
     * 获取病例变化数据详细信息
     */
    @PreAuthorize("@ss.hasPermi('data:change:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(numberChangeService.selectNumberChangeById(id));
    }

    /**
     * 新增病例变化数据
     */
    @PreAuthorize("@ss.hasPermi('data:change:add')")
    @Log(title = "病例变化数据", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody NumberChange numberChange)
    {
        return toAjax(numberChangeService.insertNumberChange(numberChange));
    }

    /**
     * 修改病例变化数据
     */
    @PreAuthorize("@ss.hasPermi('data:change:edit')")
    @Log(title = "病例变化数据", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody NumberChange numberChange)
    {
        return toAjax(numberChangeService.updateNumberChange(numberChange));
    }

    /**
     * 删除病例变化数据
     */
    @PreAuthorize("@ss.hasPermi('data:change:remove')")
    @Log(title = "病例变化数据", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(numberChangeService.deleteNumberChangeByIds(ids));
    }
}
