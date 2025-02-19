package com.hl.book_stall.dao;

import com.hl.book_stall.entity.Tops;

import java.util.List;

/**
 * @author hl
 * @date 2025/2/19
 */
public interface TopsDao {
    int deleteById(Integer id);

    int insert(Tops record);

    int insertSelective(Tops record);

    Tops selectById(Integer id);

    int updateByIdSelective(Tops record);

    int updateById(Tops record);



    /**
     * 获取列表
     * @return
     */
    @Select("select * from tops where type=#{type} order by id desc limit #{begin}, #{size}")
    public List<Tops> getList(@Param("type")byte type, @Param("begin")int begin, @Param("size")int size);
    /**
     * 获取总数
     * @param type
     * @return
     */
    @Select("select count(*) from tops where type=#{type}")
    public long getTotal(byte type);

    /**
     * 通过商品id获取
     * @param goodid
     * @return
     */
    @Select("select * from tops where good_id=#{goodid}")
    public List<Tops> getListByGoodid(int goodid);

    /**
     * 通过商品id和类型删除
     * @param goodid
     * @param type
     * @return
     */
    @Delete("delete from tops where good_id=#{goodid} and type=#{type}")
    public boolean deleteByGoodidAndType(@Param("goodid")int goodid, @Param("type")byte type);

    /**
     * 通过goodid删除
     * @param goodid
     * @return
     */
    @Delete("delete from tops where good_id=#{goodid}")
    public boolean deleteByGoodid(@Param("goodid")int goodid);
}