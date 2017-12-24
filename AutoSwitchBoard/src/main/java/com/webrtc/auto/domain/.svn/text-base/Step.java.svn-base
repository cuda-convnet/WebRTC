package com.webrtc.auto.domain;

/**
 * 存储请求自动总机服务的用户 当前的步骤状态：进行到第几个菜单、第几页、总页数
 * 
 * @author Chicken
 *
 */
public class Step {

	private int curMenu = 0; // 当前进行到的菜单级数
	private int curLfz = 0; // 当前分组号
	private String curLfzmc = ""; // 当前分组名称
	private int curPage = 1;// 当前级数下 ---当前所在页
	private int totalPage = 1;// 当前级数下 ---最大页数
	private String message = "";// 进入时传入的查询串

	public Step(int curMenu, int curLfz, String curLfzmc, int curPage, int totalPage) {
		this.curMenu = curMenu;
		this.curLfz = curLfz;
		this.curLfzmc = curLfzmc;
		this.curPage = curPage;
		this.totalPage = totalPage;
	}

	public Step(int curMenu, int curLfz, int curPage, int totalPage, String message) {
		this.curMenu = curMenu;
		this.curLfz = curLfz;
		this.curPage = curPage;
		this.totalPage = totalPage;
		this.message = message;
	}

	public int getCurLfz() {
		return curLfz;
	}

	public void setCurLfz(int curLfz) {
		this.curLfz = curLfz;
	}

	public int getCurMenu() {
		return curMenu;
	}

	public void setCurMenu(int curMenu) {
		this.curMenu = curMenu;
	}

	public int getCurPage() {
		return curPage;
	}

	public void setCurPage(int curPage) {
		this.curPage = curPage;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getCurLfzmc() {
		return curLfzmc;
	}

	public void setCurLfzmc(String curLfzmc) {
		this.curLfzmc = curLfzmc;
	}
}
