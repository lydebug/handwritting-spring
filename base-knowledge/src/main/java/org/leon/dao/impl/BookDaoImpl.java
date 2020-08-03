package org.leon.dao.impl;

import org.leon.dao.IBookDao;
import org.springframework.stereotype.Repository;

/**
 * @Author: liyang27
 * @Date: 2020/8/3 21:44
 * @Description:
 */
@Repository("bookDao")
public class BookDaoImpl implements IBookDao {
    public void insert() {
        System.out.println("add book");
    }
}
