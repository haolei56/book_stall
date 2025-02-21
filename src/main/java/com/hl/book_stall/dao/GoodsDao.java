package com.hl.book_stall.dao;

import com.hl.book_stall.entity.Goods;

import java.util.List;

/**
 * @author hl
 * @date 2025/2/19
 */
public interface GoodsDao {
    int deleteById(Integer id);

    int insert(Goods record);

    int insertSelective(Goods record);

    Goods selectById(Integer id);

    int updateByIdSelective(Goods record);

    int updateById(Goods record);

    /**
     * 获取列表
     * @param begin
     * @param size
     * @return
     */
    List<Goods> getList(int begin, int size);

    /**
     * 获取总数
     * @return
     */
     long getTotal();

    /**
     * 通过类型获取列表
     * @param typeid
     * @param begin
     * @param size
     * @return
     */
     List<Goods> getListByType(int typeid, int begin, int size);

    /**
     * 通过类型获取总数
     * @param typeid
     * @return
     */
    long getTotalByType(int typeid);

    /**
     * 通过名称获取列表
     * @param name
     * @param begin
     * @param size
     * @return
     */
     List<Goods> getListByName(String name,int begin, int size);

    /**
     * 通过名称获取总数
     * @param name
     * @return
     */
    long getTotalByName(String name);
}
