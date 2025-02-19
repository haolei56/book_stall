package com.hl.book_stall.dao;

import com.hl.book_stall.entity.Users;

import java.util.List;

/**
 * @author hl
 * @date 2025/2/19
 */
public interface UsersDao {
    int deleteById(Integer id);

    int insert(Users record);

    int insertSelective(Users record);

    Users selectById(Integer id);

    int updateByIdSelective(Users record);

    int updateById(Users record);

    /**
     * 通过用户名查找用户
     * @return 无记录返回null
     */
    @Select("select * from users where username=#{username}")
    public Users getByUsername(String username);

    /**
     * 通过用户名和密码查找
     * @param username
     * @param password
     * @return 无记录返回null
     */
    @Select("select * from users where username=#{username} and password=#{password}")
    public Users getByUsernameAndPassword(@Param("username")String username, @Param("password")String password);

    /**
     * 获取列表
     * @param page
     * @param rows
     * @return 无记录返回空集合
     */
    @Select("select * from users order by id desc limit #{begin}, #{size}")
    public List<Users> getList(@Param("begin")int begin, @Param("size")int size);

    /**
     * 总数
     * @return
     */
    @Select("select count(*) from users")
    public long getTotal();


}
