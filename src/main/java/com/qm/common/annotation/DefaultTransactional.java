package com.qm.common.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * 业务方法默认的事务注解
 * 创建日期：2015年5月18日
 * @author niezhegang
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Transactional(rollbackFor=Exception.class,propagation = Propagation.REQUIRES_NEW)
public @interface DefaultTransactional {
}
