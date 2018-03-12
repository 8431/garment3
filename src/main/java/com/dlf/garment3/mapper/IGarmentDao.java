package com.dlf.garment3.mapper;


import com.baomidou.mybatisplus.plugins.Page;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * Created by dlf on 2018/2/26 0026.
 * Email 1429264916@qq.com
 */
public interface IGarmentDao {
    /**
     * 获取列名和注释
     * @param tableName
     * @return
     * @throws
     */
     @Select(" select  column_name columnName, column_comment columnComment  from information_schema.columns  where table_schema ='chatdemo'  and table_name =#{0}")
    List<Map<String,Object>> getColumn(String tableName);

    /**
     * <p>
     * 查询 : 根据state状态查询用户列表，分页显示
     * </p>
     *
     * @param page
     *            翻页对象，可以作为 xml 参数直接使用，传递参数 Page 即自动分页
     *            状态
     * @return
     */
     @Select("${sql}")
    List<Map> queryPage(Page<Map> page, Map param);

    /**
     * 批量新增
     * @param mp
     * @return
     */
    int baseInsert(Map<String, Object> mp);

    /**
     * 根据主键批量删除
     * @param mp
     * @return
     */
    int baseDelete(Map<String, Object> mp);
    int baseUpdate(Map<String, Object> mp);
}
