package com.iwhale.dynamic.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.iwhale.dynamic.model.SysUser;
import com.iwhale.dynamic.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author DuebassLei
 * @version 1.0
 * @date 2021/6/10 14:56
 */
@Controller
@RequestMapping("sysUser")
public class SysUserController {

   @Autowired
   private SysUserService sysUserService;

   @PostMapping("/List")
   @ResponseBody
   public IPage<SysUser> sysUserList(Page<SysUser> page){
       return  sysUserService.queryUserList(page);
   }

}
