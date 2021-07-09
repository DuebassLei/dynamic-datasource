package com.iwhale.dynamic.util;

/**
 * 缓存key 管理
 * @author liyg
 *
 */
public interface CacheKeyConst {
	
	/**
	 * 模块名+name+userid
	 * 用户菜单缓存的可以
	 * 在对菜单时需要清空用户菜单缓存
	 */
	String SYS_USER_MENU = "SYS_USER_MENU";
	
	/**
	 * 后台方法和角色的关系
	 * 在对资源授权时操作时需要清空方法和角色的缓存
	 */
	String SYS_METHOD_ROLE_AUTH = "SYS_METHOD_ROLE_AUTH";
	
	/**
	 * 系统日志配置的缓存key 是否开始保存日志
	 * SYS_LOGS_SETTING_STATUS + 微服务名称
	 */
	
	String SYS_LOGS_SETTING_STATUS = "SYS_LOGS_SETTING_STATUS";
	
	/**
	 * 系统日志配置的缓存key  保留天数
	 * SYS_LOGS_SETTING_SAVE_DAY + 微服务名称
	 */
	
	String SYS_LOGS_SETTING_SAVE_DAY = "SYS_LOGS_SETTING_SAVE_DAY";
	
	/**
	 * 国际化资源语种
	 */
	String I18N_MESSAGE_TYPE = "I18N_MESSAGE_TYPE";
	
	/**
	 * 数据权限设置前缀
	 * 
	 * DATA_PERMISSION + roleAlias + requestUri
	 */
	String DATA_PERMISSION = "DATA_PERMISSION";
	
}
