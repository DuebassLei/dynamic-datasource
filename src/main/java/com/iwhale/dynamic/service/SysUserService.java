package com.iwhale.dynamic.service;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.iwhale.dynamic.mapper.SysUserMapper;
import com.iwhale.dynamic.model.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @author DuebassLei
 * @version 1.0
 * @date 2021/6/10 15:21
 */
@Service
@DS("slave")
public class SysUserService {

    @Autowired
    private SysUserMapper sysUserMapper;

    /**
     * 分页查询用户信息
     * */
    public IPage<SysUser> queryUserList(Page<SysUser> page){
        Map<String,Object> param = new HashMap<>(16);
        param.put("param1","param");
        return sysUserMapper.selectSysUserPage(page,param);
    }
    /**
     * 根据用户编码查询用户信息
     * */
    public SysUser queryUserByName(String userCode){
        return sysUserMapper.queryUserByName(userCode);
    }


}
