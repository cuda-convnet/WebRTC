package com.webrtc.netty.dao;

import java.io.Serializable;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


/**
 * The persistent class for the room database table.
 * 
 */
@Entity
@Table(name="room")
public class Room implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="roomid", unique=true, nullable=false)
	private String roomid;

	@Column(name="confid", nullable=true)
	private String confid;

	@Column(name="creator", nullable=true)
	private String creator;
	
	@Column(name="member_num",nullable=false)
	private int memberNum;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="create_at")
	private Date createAt;

	@Column(name="description", nullable=true)
	private String description;

	@Column(name="type", nullable=true)
	private int type;
	
	@Column(name="duration", nullable=true)
	private int duration;
	
	@Column(name="theme", nullable=true)
	private String theme;

	@OneToMany
	@JoinColumn(name="id")
	private Set<ConfMember> confmember = new HashSet<ConfMember>();   
	

	public String getConfid() {
		return confid;
	}

	public void setConfid(String confid) {
		this.confid = confid;
	}

	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	public int getMemberNum() {
		return memberNum;
	}

	public void setMemberNum(int memberNum) {
		this.memberNum = memberNum;
	}

	public Date getCreateAt() {
		return createAt;
	}

	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public String getTheme() {
		return theme;
	}

	public void setTheme(String theme) {
		this.theme = theme;
	}

	public Set<ConfMember> getConfmember() {
		return confmember;
	}

	public void setConfmember(Set<ConfMember> confmember) {
		this.confmember = confmember;
	}

	public String getRoomid() {
		return roomid;
	}

	public void setRoomid(String roomid) {
		this.roomid = roomid;
	}


}