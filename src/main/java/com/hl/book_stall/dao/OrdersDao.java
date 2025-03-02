package com.hl.book_stall.dao;

import com.hl.book_stall.entity.Orders;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author hl
 * @date 2025/2/19
 */
public interface OrdersDao {
    int deleteById(Integer id);

    int insert(Orders record);

    int insertSelective(Orders record);

    Orders selectById(Integer id);

    int updateByIdSelective(Orders record);

    int updateById(Orders record);


    /**
     * 获取列表
     * @param size
     * @param begin
     */
    @Select("select * from orders order by id desc limit #{begin}, #{size}")
    public List<Orders> getList(@Param("begin")int begin, @Param("size")int size);

    /**
     * 获取总数
     * @return
     */
    @Select("select count(*) from orders")
    public long getTotal();

    /**
     * 获取列表
     * @param status
     * @param size
     * @param begin
     */
    @Select("select * from orders where status=#{status} order by id desc limit #{begin}, #{size}")
    public List<Orders> getListByStatus(@Param("status")byte status, @Param("begin")int begin, @Param("size")int size);

    /**
     * 获取总数
     * @param status
     * @return
     */
    @Select("select count(*) from orders where status=#{status}")
    public long getTotalByStatus(@Param("status")byte status);

    /**
     * 通过用户获取列表
     * @param userid
     */
    @Select("select * from orders where user_id=#{userid} order by id desc")
    public List<Orders> getListByUserid(@Param("userid")int userid);

}
