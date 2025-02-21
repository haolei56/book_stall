package com.hl.book_stall.dao;

import com.hl.book_stall.entity.Types;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author hl
 * @date 2025/2/19
 */
public interface TypesDao {
    int deleteById(Integer id);

    int insert(Types record);

    int insertSelective(Types record);

    Types selectById(Integer id);

    int updateByIdSelective(Types record);

    int updateById(Types record);


    /**
     * 获取列表
     * @return
     */
    @Select("select * from types order by id desc")
    public List<Types> getList();

}
