package com.dlf.garment3.controller;


import com.baomidou.mybatisplus.plugins.Page;
import com.dlf.garment3.service.IGarmentDaoService;
import com.dlf.garment3.util.CustomPage;
import com.dlf.garment3.util.FrontPage;
import com.dlf.garment3.util.JSONResult;
import com.dlf.garment3.util.SimpleCode;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.validation.Validator;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/v1/api")
@Api("用户操作接口")
public class BaseController {
    @Autowired
    IGarmentDaoService ibasedaoservice;
    @Autowired
    Validator validator;
    ///////////////////////////////////////////////////////by dlf 对单表统一的动态增删改查 for 2018-02-26/////////////////////////////////////////////////////////////////
    @GetMapping(value = "/getColumn")
    @ApiOperation("查询表列和注释")
    public JSONResult<List> getColumn(@ApiParam(value = "表名", required = true) @RequestParam String table) {
        JSONResult<List> result = null;
        List<Map<String, Object>> result2 = new ArrayList<>();

        if (StringUtils.isEmpty(table)) {
            return result = new JSONResult(SimpleCode.ERROR, "table不能为空");
        }
//        if (StringUtils.isEmpty(tableName)) {
//            return result = new JSONResult(SimpleCode.ERROR, "该table编号不存在");
//        }
        result2 = ibasedaoservice.getColumn(table);
        result = new JSONResult<List>(SimpleCode.SUCCESS, result2);
        return result;
    }
    @PostMapping(value = "/queryPage")
    @ApiOperation("分页查询")
    public JSONResult<CustomPage<Map>> queryPage(@RequestBody(required = false) FrontPage<Map> frontPage) {
        JSONResult<CustomPage<Map>> result = null;
        CustomPage<Map> customPage = new CustomPage<Map>();
        Page<Map> pageList = null;
        //参数校验
        pageList = ibasedaoservice.queryPage(frontPage.getPagePlus(), frontPage.getParam());
        customPage = new CustomPage<Map>(pageList);
        result = new JSONResult<CustomPage<Map>>(SimpleCode.SUCCESS, customPage);
        return result;
    }
    @PostMapping(value = "/insert")
    @ApiOperation("批量新增")
    public JSONResult<String> insert(@RequestBody(required = false) Map insertParam) {
        JSONResult<String> result = null;
        Page<Map> pageList = null;
        //表名参数校验start--
//        result = checkTableName(insertParam);
//        if (result != null) {
//            return result;
//        }
        //表名参数校验end
        //逻辑参数校验（包括值的校验以及数据类型转换）------------------start-------------------------------
        List<Map<String, Object>> param = (List<Map<String, Object>>) insertParam.get("data");
        if (param == null || param.size() < 1) {
            return result = new JSONResult(SimpleCode.ERROR, "data不能为空");
        }
//        result= checkValue(insertParam);
//        if (result != null) {
//            return result;
//        }
        //逻辑参数校验------------------end-------------------------------
        int insertRe=ibasedaoservice.insert(insertParam);
        result = new JSONResult(SimpleCode.SUCCESS, insertRe);
        return result;
    }
    @PostMapping(value = "/delete")
    @ApiOperation("批量删除")
    public JSONResult<String> delete(@RequestBody(required = false) Map insertParam) {
        JSONResult<String> result = null;

        List<Map<String, Object>> param = (List<Map<String, Object>>) insertParam.get("data");
        if (param == null || param.size() < 1) {
            return result = new JSONResult(SimpleCode.ERROR, "data不能为空");
        }
        //逻辑参数校验------------------end-------------------------------
        int insertRe=ibasedaoservice.delete(insertParam);
        result = new JSONResult(SimpleCode.SUCCESS, insertRe);
        return result;
    }
    @PostMapping(value = "/update")
    @ApiOperation("更新")
    public JSONResult<String> update(@RequestBody(required = false) Map insertParam) {
        JSONResult<String> result = null;

        List<Map<String, Object>> param = (List<Map<String, Object>>) insertParam.get("data");
        if (param == null || param.size() < 1) {
            return result = new JSONResult(SimpleCode.ERROR, "data不能为空");
        }
        //逻辑参数校验------------------end-------------------------------
        int insertRe=ibasedaoservice.update(insertParam);
        result = new JSONResult(SimpleCode.SUCCESS, insertRe);
        return result;
    }

}
