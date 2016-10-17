package com.sharing.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.sharing.dao.JoinDetailDao;
import com.sharing.entities.JoinDetail;
import com.sharing.entities.dto.JoinDetailDto;
import com.sharing.service.JoinDetailService;

public class JoinDetailServiceImpl implements JoinDetailService {

	@Autowired
	private JoinDetailDao joinDetailDao;
	@Autowired
	private JoinDetail joinDetail;
	@Autowired
	private JoinDetailDto joinDetailDto;

	@Override
	public int saveJoinDetail(JoinDetailDto joinDetailDto) {
		System.out.println("service joinDetail : "+joinDetail);
		// 将数据传说对象转换成Bean 对象
		System.out.println("joinDetailDto id :" +joinDetailDto.getUserId());
		joinDetail.setUserId(joinDetailDto.getUserId());
		System.out.println("joinDetail id :" +joinDetail.getUserId());
		joinDetail.setStartingPoint(joinDetailDto.getStartingPoint());
		joinDetail.setTerminalPoint(joinDetailDto.getTerminalPoint());
		joinDetail.setGoOff_first(joinDetailDto.getGoOff_first());
		joinDetail.setGoOff_second(joinDetailDto.getGoOff_second());
		joinDetail.setArrivalTime_first(joinDetailDto.getArrivalTime_first());
		joinDetail.setArrivalTime_second(joinDetailDto.getArrivalTime_second());
		joinDetail.setParticipateTime_first(joinDetailDto.getParticipateTime_first());
		joinDetail.setParticipateTime_second(joinDetailDto.getParticipateTime_second());
		int res = joinDetailDao.saveJoinDetail(joinDetail);
		return res;
	}

	@Override
	public int deleteJoinDetail(int id) {

		int joinId = joinDetailDao.selectJoinDetailId(id);
		System.out.println("当前请求信息的id : " + joinId);
		if (joinId <= 0) {
			System.out.println("当前信息不存在");
			return -1;
		}
		int res = joinDetailDao.deleteJoinDetail(id);
		return res;
	}

	@Override
	public int updateJoinDetail(JoinDetailDto joinDetailDto) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<JoinDetailDto> selectJoinDetailById(int userId) {
		List<JoinDetail> list = joinDetailDao.selectJoinDetailById(userId);
		List<JoinDetailDto> listJ = new ArrayList<JoinDetailDto>();
		for (JoinDetail join : list) {
			joinDetailDto = new JoinDetailDto();
			joinDetailDto.setId(join.getId());
			joinDetailDto.setUserId(join.getUserId());
			joinDetailDto.setStartingPoint(join.getStartingPoint());
			joinDetailDto.setTerminalPoint(join.getTerminalPoint());
			joinDetailDto.setGoOff_first(join.getGoOff_first());
			joinDetailDto.setGoOff_second(join.getGoOff_second());
			joinDetailDto.setArrivalTime_first(join.getArrivalTime_first());
			joinDetailDto.setArrivalTime_second(join.getArrivalTime_second());
			joinDetailDto.setParticipateTime_first(join.getParticipateTime_first());
			joinDetailDto.setParticipateTime_second(join.getParticipateTime_second());
			listJ.add(joinDetailDto);
		}
		return listJ;
	}

	@Override
	public boolean matchJoinDetail(int userId, int userId2) {
		boolean isMatched = false;
		List<JoinDetailDto> jlist = selectJoinDetailById(userId);
		List<JoinDetailDto> jlistM =selectJoinDetailById(userId2);
		for (JoinDetailDto j : jlist) {
			for (JoinDetailDto jM : jlistM) {
				// 出发和终到地址前九位相同切参与时间一致
				if (j.getStartingPoint().substring(0, 8).equals(jM.getStartingPoint().substring(0, 9))
						&&j.getTerminalPoint().substring(0, 9).equals(jM.getTerminalPoint().substring(0, 9))
						&&j.getParticipateTime_first().equals(jM.getParticipateTime_first())
						&&j.getParticipateTime_second().equals(jM.getParticipateTime_second())) {
					System.out.println("匹配成功1");
					isMatched = true;
				} else {
					System.out.println("地址不匹配");
				}
			}
		}
		return isMatched;
	}
}
