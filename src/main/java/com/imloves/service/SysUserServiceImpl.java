package com.imloves.service;

import com.imloves.model.SysUser;
import com.imloves.repository.SysUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by wujianchuan
 * 2017/9/9 18:16
 */
@Service
public class SysUserServiceImpl implements SysUserService {

    private final SysUserRepository repository;

    @Autowired
    public SysUserServiceImpl(SysUserRepository repository) {
        this.repository = repository;
    }

    @Override
    @CachePut(value = "love", key = "#result.id")
    @Transactional(propagation = Propagation.REQUIRED)
    public SysUser save(SysUser sysUser) {

        return repository.save(sysUser);
    }

    @Override
    @Cacheable(value = "love", key = "#result.id")
    public SysUser findByPhone(String phone) {

        return repository.findByPhone(phone);
    }
}
