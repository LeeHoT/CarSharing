package com.sharing.entities.dto;

import java.io.Serializable;

import org.springframework.stereotype.Repository;

@Repository(value="joinDetailDto")
public class JoinDetailDto implements Serializable{
	private static final long serialVersionUID = 5437811005669019876L;
	private Integer id;
	private Integer userId;// 用户id
	private String startingPoint;// 起点
	private String terminalPoint;// 终点
	private String goOff_first;// 出发时间1
	private String goOff_second;// 出发时间2
	private String arrivalTime_first;// 到达时间1
	private String arrivalTime_second;// 到达时间2
	private String participateTime_first;// 参与时间1
	private String participateTime_second;// 参与时间2

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getStartingPoint() {
		return startingPoint;
	}

	public void setStartingPoint(String startingPoint) {
		this.startingPoint = startingPoint;
	}

	public String getTerminalPoint() {
		return terminalPoint;
	}

	public void setTerminalPoint(String terminalPoint) {
		this.terminalPoint = terminalPoint;
	}

	public String getGoOff_first() {
		return goOff_first;
	}

	public void setGoOff_first(String goOff_first) {
		this.goOff_first = goOff_first;
	}

	public String getGoOff_second() {
		return goOff_second;
	}

	public void setGoOff_second(String goOff_second) {
		this.goOff_second = goOff_second;
	}

	public String getArrivalTime_first() {
		return arrivalTime_first;
	}

	public void setArrivalTime_first(String arrivalTime_first) {
		this.arrivalTime_first = arrivalTime_first;
	}

	public String getArrivalTime_second() {
		return arrivalTime_second;
	}

	public void setArrivalTime_second(String arrivalTime_second) {
		this.arrivalTime_second = arrivalTime_second;
	}

	public String getParticipateTime_first() {
		return participateTime_first;
	}

	public void setParticipateTime_first(String participateTime_first) {
		this.participateTime_first = participateTime_first;
	}

	public String getParticipateTime_second() {
		return participateTime_second;
	}

	public void setParticipateTime_second(String participateTime_second) {
		this.participateTime_second = participateTime_second;
	}

}
