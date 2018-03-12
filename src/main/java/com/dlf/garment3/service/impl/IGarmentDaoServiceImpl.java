package com.dlf.garment3.service.impl;


import com.baomidou.mybatisplus.plugins.Page;
import com.dlf.garment3.mapper.IGarmentDao;
import com.dlf.garment3.service.IGarmentDaoService;
import com.dlf.garment3.util.CommonException;
import com.dlf.garment3.util.PropertyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.*;

/**
 * Created by dlf on 2018/3/9 0009.
 * Email 1429264916@qq.com
 */
@Service
public class IGarmentDaoServiceImpl implements IGarmentDaoService {
//    public static final Map<String, Object> TABLENAME;
//
//    static {
//        String tableName = PropertyUtil.getPropery("tableName");
//        Gson gn = new Gson();
//        TABLENAME = gn.fromJson(tableName, Map.class);
//    }

    @Autowired
    IGarmentDao igarmentdao;

    @Override
    public Page<Map> queryPage(Page<Map> page, Map param) throws CommonException {
        //通过表名分页查询，自定义sql查询，默认执行该表的全表查询
        // page.setSearchCount(false);
        String tableName = (String) param.get("table");
        String sql = PropertyUtil.getPropery("QUERY_" + tableName.toUpperCase());
        if (StringUtils.isEmpty(sql)) {
            sql = "select * from " + tableName;
        }
        param.put("table", tableName);
        param.put("sql", sql);
        return page.setRecords(igarmentdao.queryPage(page, param));
    }

    @Override
    public int insert(Map<String, Object> insertParam) throws CommonException {

        Map<String, Object> param = new HashMap<>();
        List<Map<String, Object>> paramData = (List<Map<String, Object>>) insertParam.get("data");
        List<String> InsertMapkey = new ArrayList<>();
        Map<String, Object> mpKey = paramData.get(0);
        Set<String> key = mpKey.keySet();
        Iterator it = key.iterator();
        while (it.hasNext()) {
            InsertMapkey.add((String) it.next());
        }
        param.put("InsertMap", InsertMapkey);
        param.put("InsertMapVal", paramData);
        param.put("table", insertParam.get("table"));
        return igarmentdao.baseInsert(param);
    }

    @Override
    public List<Map<String, Object>> getColumn(String table) {
        return igarmentdao.getColumn(table);
    }


    @Override
    public int update(Map<String, Object> updateParam) throws CommonException {

        Map<String, Object> param = new HashMap<>();
        Map<String, Object> paramData = (Map<String, Object>) updateParam.get("data");
        String table = (String) updateParam.get("table");
        String id = (String) paramData.get("id");
        if (StringUtils.isEmpty(id)||StringUtils.isEmpty(table)) {
            throw new CommonException("id或者table不能为空！");
        }
        param.put("updateMap", paramData);
        param.put("table", updateParam.get("table"));
        param.put("id", id);
        return igarmentdao.baseUpdate(param);

    }

    @Override
    public int delete(Map<String, Object> deleteParam) throws CommonException {
        Map<String, Object> param = new HashMap<>();
        List paramData = (List<Map<String, Object>>) deleteParam.get("data");
        param.put("deleteMap", paramData);
        param.put("table", deleteParam.get("table"));
        return igarmentdao.baseDelete(param);
    }


    public static void main(String[] args) {
        StringBuffer sb = new StringBuffer("1,2,3,");
        sb.replace(sb.lastIndexOf(","), sb.lastIndexOf(",") + 1, "");
        System.out.println(sb.toString());

    }

}
