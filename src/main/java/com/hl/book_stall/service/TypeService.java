package com.hl.book_stall.service;

import com.hl.book_stall.dao.TypesDao;
import com.hl.book_stall.entity.Types;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author hl
 * @date 2025/2/19
 */
@Service    // 注解为service层spring管理bean
@Transactional    // 注解此类所有方法加入spring事务, 具体设置默认
@RequiredArgsConstructor
public class TypeService {

    private final TypesDao typeDao;


    /**
     * 获取列表
     * @return
     */
    public List<Types> getList(){
        return typeDao.getList();
    }

    /**
     * 通过id查询
     * @param id
     * @return
     */
    public Types get(int id) {
        return typeDao.selectById(id);
    }

    /**
     * 添加
     * @param type
     * @return
     */
    public Integer add(Types type) {
        return typeDao.insert(type);
    }

    /**
     * 更新
     * @param type
     */
    public boolean update(Types type) {
        return typeDao.updateById(type) > 0;
    }

    /**
     * 删除
     * @param type
     */
    public boolean delete(Types type) {
        return typeDao.deleteById(type.getId()) > 0;
    }

}

