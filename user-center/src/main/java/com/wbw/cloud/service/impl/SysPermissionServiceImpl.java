package com.wbw.cloud.service.impl;

import com.wbw.cloud.dao.SysPermissionDao;
import com.wbw.cloud.dao.SysRolePermissionDao;
import com.wbw.cloud.model.Page;
import com.wbw.cloud.model.user.SysPermission;
import com.wbw.cloud.service.SysPermissionService;
import com.wbw.cloud.utils.PageUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * @author wbw
 * @date 2022-6-26 12:19
 */
@Slf4j
@Service
public class SysPermissionServiceImpl implements SysPermissionService {
    @Autowired
    private SysPermissionDao sysPermissionDao;
    @Autowired
    private SysRolePermissionDao rolePermissionDao;
    @Override
    public Set<SysPermission> findByRoleIds(Set<Long> roleIds) {
        return rolePermissionDao.findPermissionsByRoleIds(roleIds);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void save(SysPermission sysPermission) {
        SysPermission permission = sysPermissionDao.queryByPermission(sysPermission.getPermission());
        if (permission != null) {
            throw new IllegalArgumentException("权限标识已存在");
        }
        sysPermission.setCreateTime(new Date());
        sysPermission.setUpdateTime(sysPermission.getCreateTime());

        sysPermissionDao.insert(sysPermission);
        log.info("保存权限标识：{}", sysPermission);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void update(SysPermission sysPermission) {
        sysPermission.setUpdateTime(new Date());
        sysPermissionDao.update(sysPermission);
        log.info("修改权限标识：{}", sysPermission);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void delete(Long id) {
        SysPermission permission = sysPermissionDao.queryById(id);
        if (permission == null) {
            throw new IllegalArgumentException("权限标识不存在");
        }

        sysPermissionDao.deleteById(id);
        rolePermissionDao.deleteById(null, id);
        log.info("删除权限标识：{}", permission);
    }

    @Override
    public Page<SysPermission> findPermissions(Map<String, Object> params) {
        int total = sysPermissionDao.count(params);
        List<SysPermission> list = Collections.emptyList();
        if (total > 0) {
            PageUtil.pageParamConver(params, false);
            list = sysPermissionDao.queryAllByLimit(params);
        }
        return new Page<>(total, list);
    }
}
