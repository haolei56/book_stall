package com.hl.book_stall.dao;

import com.hl.book_stall.entity.Items;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author hl
 * @date 2025/2/19
 */
public interface ItemsDao {
    int deleteById(Integer id);

    int insert(Items record);

    int insertSelective(Items record);

    Items selectById(Integer id);

    int updateByIdSelective(Items record);

    int updateById(Items record);

    /**
     * 订单项列表
     * @param orderid
     * @return
     */
    @Select("select * from items where order_id=#{orderid}")
    public List<Items> getItemList(int orderid);
}
