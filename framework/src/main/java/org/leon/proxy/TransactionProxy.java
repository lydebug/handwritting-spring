package org.leon.proxy;

/**
 * @Author: liyang27
 * @Date: 2020/8/10 21:42
 * @Description:
 */

import org.leon.annotation.Transactional;
import org.leon.helper.DatabaseHelper;

import java.lang.reflect.Method;

/**
 * 事务代理
 */
public class TransactionProxy implements Proxy {

//    private static final Logger LOGGER = LoggerFactory.getLogger(TransactionProxy.class);

    @Override
    public Object doProxy(ProxyChain proxyChain) throws Throwable {
        Object result;
        Method method = proxyChain.getTargetMethod();
        //加了@Transactional注解的方法要做事务处理
        if (method.isAnnotationPresent(Transactional.class)) {
            try {
                DatabaseHelper.beginTransaction();
//                LOGGER.debug("begin transaction");
                result = proxyChain.doProxyChain();
                DatabaseHelper.commitTransaction();
//                LOGGER.debug("commit transaction");
            } catch (Exception e) {
                DatabaseHelper.rollbackTransaction();
//                LOGGER.debug("rollback transaction");
                throw e;
            }
        } else {
            result = proxyChain.doProxyChain();
        }
        return result;
    }
}
