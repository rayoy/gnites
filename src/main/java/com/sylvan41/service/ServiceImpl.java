/**
 * 
 */
package com.sylvan41.service;

import org.springframework.stereotype.Service;

import com.sylvan41.dao.DaoImpl;
import com.sylvan41.model.BaseEntity;

/**
 * 服务实现类
 * 
 * @author asimple41@qq.com
 * 
 */
@Service
public class ServiceImpl<T extends BaseEntity> extends DaoImpl<T> implements IService<T> {

}
