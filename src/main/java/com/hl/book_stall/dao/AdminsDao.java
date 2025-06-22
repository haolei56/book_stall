package com.hl.book_stall.dao;

import com.hl.book_stall.entity.Admins;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author hl
 * @date 2025/2/19
 */
@Mapper
public interface AdminsDao {
    int deleteById(Integer id);

    int insert(Admins record);

    int insertSelective(Admins record);

    Admins selectById(Integer id);

    int updateByIdSelective(Admins record);

    int updateById(Admins record);


    /**
     * 通过用户名查找
     * @param username
     * @return
     */
    Admins getByUsername(String username);

    /**
     * 通过用户名和密码查找
     * @param username
     * @param password
     * @return 无记录返回null
     */
    public Admins getByUsernameAndPassword(String username, String password);

    /**
     * 获取列表
     * @param begin
     * @param size
     * @return 无记录返回空集合
     */
    public List<Admins> getList(int begin, int size);

    /**
     * 总数
     * @return
     */
    public long getTotal();
}
