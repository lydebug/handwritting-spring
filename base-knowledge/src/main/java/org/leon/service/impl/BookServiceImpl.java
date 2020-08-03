package org.leon.service.impl;

import org.leon.dao.IBookDao;
import org.leon.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

/**
 * @Author: liyang27
 * @Date: 2020/8/3 21:46
 * @Description:
 */
@Service("bookService")
@Scope("singleton")
public class BookServiceImpl implements IBookService {
    @Autowired
    @Qualifier(value = "bookDao")
    private IBookDao bookDao;

    public void addBook() {
        this.bookDao.insert();
    }
}
