package com.itwill.ilhajob.recruit;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itwill.ilhajob.corp.Corp;

@Service
public class RecruitServiceImpl implements RecruitService {
	
	@Autowired
	private RecruitDao recruitDao; 
	
	public RecruitServiceImpl(RecruitDao recruitDao) {
		this.recruitDao = recruitDao;
	}
	
	@Override
	public int saveRecruit(Recruit recruit) throws Exception {
		return recruitDao.insertRecruit(recruit);
	}

	@Override
	public int updateRecruit(Recruit recruit) throws Exception {
		return recruitDao.updateBySeq(recruit);
	}

	@Override
	public int removeRecruit(Map<String, Object> map) throws Exception {
		return recruitDao.deleteBySeq(map);
	}

	@Override
	public List<Recruit> findRecruitListAllWithCorp() throws Exception {
		return recruitDao.findAllWithCorp();
	}
	
	@Override
	public List<Recruit> findRecruitListByCorpId(Corp corp) throws Exception {
		return recruitDao.findByCorpId(corp);
	}

	@Override
	public List<Recruit> findRecruitListByJob(String job) throws Exception {
		return recruitDao.findByJob(job);
	}

	@Override
	public Recruit findRecruit(int rcSeq) throws Exception {
		return recruitDao.findBySeq(rcSeq);
	}
	
	//마감일 됐는지 여부 확인
//	@Override
//	public boolean isDeadLine(Date rcDeadline) throws Exception {
//		Date now=new Date();
//		return now.after(rcDeadline);
//	}
	
//	//마감일 설정
//	@Override
//	public Date addDay(Date date, int day) throws Exception {
//		long time=date.getTime();
//		time+=day*24*60*60*1000;
//		return new Date(time);
//	}
	
	
	
	//마감일 
	@Override
	public String getStatus(Date rcDeadLine) throws Exception {
		//현재 시간으로 초기화
		LocalDate today=LocalDate.now();
		LocalDate deadLineLocalDate=rcDeadLine.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		long daysUntilDeadLine=ChronoUnit.DAYS.between(today, deadLineLocalDate);
		
		if (daysUntilDeadLine < 0) {
            return "마감";
        } else if (daysUntilDeadLine == 0) {
            return "마감 예정";
        } else {
            return "D-" + daysUntilDeadLine;
        }
	}
	
	
	
}
