package com.iwhale.dynamic.model;


import java.util.List;
/**
 * 树结构对象，用于将列表数据转换成树结构。
 *
 * @author  DuebassLei
 * @version 1.0
 * @date    2021/6/11
 *
 */
public interface Tree {
	
	/**
	 * 主键ID
	 * @return
	 */
	String getId();
	
	/**
	 * 父ID
	 * @return
	 */
	String getParentId();
	
	/**
	 * 显示的值。
	 * @return
	 */
	String getText();
	
	/**
	 * 子对象。
	 * @return
	 */
	List<Tree> getChildren();
	
	/**
	 * 设置子对象。
	 * @param list
	 */
	void setChildren(List<Tree> list);
	
	/**
	 * 是否父节点
	 * @param isParent
	 */
	public void setIsParent(String isParent);
}