package com.webrtc.auto.common;

/**
 * 自动总机反馈信息的组成（下标）
 * @author yck
 */
public interface AnswerCompo {
	public static final int HEAD = 0; //头部：普通文本
	public static final int BODY = 1; //身部：分组列表、邮箱列表
	public static final int FOOTER = 2; //尾部：页码、返回上级、返回首页
}