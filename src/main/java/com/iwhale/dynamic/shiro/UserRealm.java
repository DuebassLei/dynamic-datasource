package com.iwhale.dynamic.shiro;

import com.iwhale.dynamic.model.SysUser;
import com.iwhale.dynamic.service.SysUserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.Set;

/**
 * @author DuebassLei
 * @version 1.0
 * @date 2021/6/10 17:25
 *
 *  UserRealm  自定义Realm
 */
@Slf4j
public class UserRealm  extends AuthorizingRealm {
    @Autowired
    private SysUserService sysUserService;
    /**
     * 授权方法
     * 授权（查询数据库进行授权）  角色的权限信息集合，授权时使用
     * */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        log.info("执行授权-->doGetAuthorizationInfo");
        //获取由认证（getPrincipal()）传来的授权标识
        Subject subject = SecurityUtils.getSubject();
        SysUser currentUser = (SysUser)subject.getPrincipal();

        //设置角色
        Set<String> roles = new HashSet<>();
        //todo 获取用户角色
        roles.add("");
        //设置角色权限
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo(roles);

        //都有add权限
        info.addStringPermission("add");
        //设置update权限
        info.addStringPermission("update");
        return info;
    }

    //认证方法
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {

        log.info("执行认证-->doGetAuthenticationInfo");
        //用户传入的用户名和密码封装在Token中
        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) authenticationToken;
        //根据用户输入到 数据库中查询用户信息
        SysUser user = sysUserService.queryUserByName(usernamePasswordToken.getUsername());
        if(user==null){
            //Controller层会抛出UnknownAccountException异常
            return null;
        }
        //根据用户输入的用户名查到的数据库中用户信息不为null，下面认证密码
        //密码认证（Shiro自动做认证）(在第一个参数中将权限标识传给授权)
        return new SimpleAuthenticationInfo(user,user.getPassword(),"");

    }
}
