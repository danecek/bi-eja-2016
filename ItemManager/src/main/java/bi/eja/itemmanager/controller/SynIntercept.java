/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bi.eja.itemmanager.controller;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Logger;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

@Interceptor
@SynInterceptorBinding
public class SynIntercept {

    private static final Logger LOG = Logger.getLogger(SynIntercept.class.getName());

    @AroundInvoke
    public Object sync(InvocationContext ic) throws Exception {
        System.out.println(ic.getMethod().getName() + " begin");
        LOG.info(ic.getMethod().getName() + " begin");
        Lock lock = new ReentrantLock();
        Object result;
        try {
            lock.lock();
            result = ic.proceed();
        } finally {
            lock.unlock();
        }
        LOG.info(ic.getMethod().getName() + " end");
        return result;
    }

}
