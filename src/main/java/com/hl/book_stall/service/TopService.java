package com.hl.book_stall.service;

import com.hl.book_stall.dao.TopsDao;
import com.hl.book_stall.entity.Tops;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

/**
 * @author hl
 * @date 2025/2/19
 */
@Service    // 注解为service层spring管理bean
@Transactional    // 注解此类所有方法加入spring事务, 具体设置默认
@RequiredArgsConstructor
public class TopService {


    private final TopsDao topDao;

    /**
     * 获取列表
     * @return
     */
    public List<Tops> getList(byte type, int page, int size){
        List<Tops> topList = topDao.getList(type, (page-1)*size, size);
    //     for(Tops top : topList) {
    //         top.setGood(goodService.get(top.getGoodId()));
    //     }
        return topList;
    }

    /**
     * 获取总数
     * @param type
     * @return
     */
    public long getTotal(byte type) {
        return topDao.getTotal(type);
    }

    /**
     * 获取列表
     * @return
     */
    public List<Tops> getListByGoodid(int goodid){
        return topDao.getListByGoodid(goodid);
    }

    /**
     * 通过id查询
     * @param id
     * @return
     */
    public Tops get(int id) {
        return topDao.selectById(id);
    }

    /**
     * 添加
     * @param top
     * @return
     */
    public Integer add(Tops top) {
        return topDao.insert(top);
    }

    /**
     * 更新
     * @param top
     */
    public boolean update(Tops top) {
        return topDao.updateById(top) > 0;
    }

    /**
     * 删除
     * @param top
     */
    public boolean delete(Tops top) {
        return (Objects.nonNull(top.getId())) ? (topDao.deleteById(top.getId()) > 0) :
                topDao.deleteByGoodidAndType(top.getGoodId(), top.getType());
    }

    /**
     * 按商品删除
     * @param goodid
     * @return
     */
    public boolean deleteByGoodid(int goodid) {
        return topDao.deleteByGoodid(goodid);
    }

}
