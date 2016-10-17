package com.sharing.action;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
import com.sharing.entities.JoinDetail;
import com.sharing.entities.dto.JoinDetailDto;
import com.sharing.service.JoinDetailService;

@Controller("joinDetailAction")
public class JoinDetailAction extends ActionSupport {
	private static final long serialVersionUID = 5678167733418349371L;

	@Autowired
	private JoinDetailService joinDetailService;
	private int id;
	private int userId;
	private JoinDetailDto joinDetailDto;
	private JoinDetail joinDetail;
	private List<JoinDetailDto> list = new ArrayList<JoinDetailDto>();

	public String addJoinDetail() {
		System.out.println(joinDetailDto.getUserId());
		// 判断输入信息输入正确
		int res = joinDetailService.saveJoinDetail(joinDetailDto);
		if (res > 0) {
			System.out.println("添加参与信息成功");
			userId = joinDetailDto.getUserId();
			return SUCCESS;
		} else {
			System.out.println("添加参与信息失败");
			return INPUT;
		}

	}

	public String deleteJoinDetail() {
		int res = joinDetailService.deleteJoinDetail(id);
		if (res > 0) {
			System.out.println("删除信息成功");
			return SUCCESS;
		} else {
			System.out.println("删除信息失败");
			return INPUT;
		}
	}

	public String changeJoinDetail() {
		System.out.println("改变参与信息成功");
		return SUCCESS;
	}

	public String selectJoinDetail() {
		list = joinDetailService.selectJoinDetailById(joinDetailDto.getUserId());
		for (JoinDetailDto l : list) {
			System.out.println("action detailadd" + l.getTerminalPoint());
		}
		System.out.println("当前用户" + joinDetailDto.getUserId() + "有" + list.size() + "个地址");
		return SUCCESS;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public List<JoinDetailDto> getList() {
		return list;
	}

	public void setList(List<JoinDetailDto> list) {
		this.list = list;
	}

	public JoinDetailDto getJoinDetailDto() {
		return joinDetailDto;
	}

	public void setJoinDetailDto(JoinDetailDto joinDetailDto) {
		this.joinDetailDto = joinDetailDto;
	}

	public JoinDetail getJoinDetail() {
		return joinDetail;
	}

	public void setJoinDetail(JoinDetail joinDetail) {
		this.joinDetail = joinDetail;
	}

}
