package com.iwhale.dynamic.mapper;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.iwhale.dynamic.model.SysUser;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.Map;

/**
 * @author DuebassLei
 * @version 1.0
 * @date 2021/6/10 15:10
 * MP 支持不需要 UserMapper.xml 这个模块演示内置 CRUD 咱们就不要 XML 部分了
 */
@Repository
public interface SysUserMapper extends BaseMapper {
    /**
     * 查询所有用户
     * */
    IPage<SysUser> selectSysUserPage(Page<?> page, Map<String,Object> param);

    SysUser queryUserByName(@Param("userCode") String userCode);

}
