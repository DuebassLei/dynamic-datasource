package com.iwhale.dynamic.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import lombok.Data;

/**
 * SYS_USER
 * @author 
 */
@ApiModel(value="com.iwhale.dynamic.model.SysUser系统用户表")
@Data
public class SysUser implements Serializable {
    /**
     * 用户ID
     */
    @ApiModelProperty(value="用户ID")
    private BigDecimal userId;

    /**
     * 用户名
     */
    @ApiModelProperty(value="用户名")
    private String userName;


    /**
     * 密码
     */
    @ApiModelProperty(value="密码")
    private String password;



    /**
     * 员工编号
     */
    @ApiModelProperty(value="员工编号")
    private BigDecimal employeeId;

    /**
     * 盐值
     */
    @ApiModelProperty(value="盐值")
    private BigDecimal userSalt;

    /**
     * 用户头像
     */
    @ApiModelProperty(value="用户头像")
    private String userAvatar;

    /**
     * 有效（1），无效（0）
     */
    @ApiModelProperty(value="有效（1），无效（0）")
    private Short enabled;

    private Date createDate;

    private Date updateDate;

    /**
     * 备注
     */
    @ApiModelProperty(value="备注")
    private String note;

    /**
     * 邮箱
     */
    @ApiModelProperty(value="邮箱")
    private String email;

    /**
     * 电话
     */
    @ApiModelProperty(value="电话")
    private BigDecimal userPhone;

    /**
     * 用户地址
     */
    @ApiModelProperty(value="用户地址")
    private String userAddress;

    /**
     * 用户编码
     */
    @ApiModelProperty(value="用户编码")
    private String userCode;

    private static final long serialVersionUID = 1L;

}