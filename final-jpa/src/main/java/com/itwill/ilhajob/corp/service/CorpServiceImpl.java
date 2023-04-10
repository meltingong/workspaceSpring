package com.itwill.ilhajob.corp.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.itwill.ilhajob.corp.dto.CorpDto;
import com.itwill.ilhajob.corp.entity.Corp;
import com.itwill.ilhajob.corp.exception.CorpNotFoundException;
import com.itwill.ilhajob.corp.exception.ExistedCorpException;
import com.itwill.ilhajob.corp.repository.CorpRepository;
import com.itwill.ilhajob.user.exception.PasswordMismatchException;



@Service
@Transactional
public class CorpServiceImpl implements CorpService{
	
	private final CorpRepository corpRepository;
	private final ModelMapper modelMapper;
	
	@Autowired
	public CorpServiceImpl(CorpRepository corpRepository, ModelMapper modelMapper) {
		this.corpRepository = corpRepository;
		this.modelMapper = modelMapper;
	}
	
	@Override
	public CorpDto create(CorpDto corpDto) throws ExistedCorpException, Exception {
		//1.아이디중복체크
		Optional<Corp> found = corpRepository.findByCorpLoginId(corpDto.getCorpLoginId());
        if (found.isPresent()) {
        	//아이디중복
			ExistedCorpException exception=
					new ExistedCorpException(corpDto.getCorpLoginId()+" 는 이미 존재하는아이디입니다.");
			exception.setData(corpDto);
			throw exception;
        }
		
		if(corpRepository.existsByCorpLoginId(corpDto.getCorpLoginId())) {
			//아이디중복
			throw new ExistedCorpException(corpDto.getCorpLoginId()+" 는 이미 존재하는 아이디입니다.");
		}
		//아이디안중복
		//2.회원가입
		Corp corp = modelMapper.map(corpDto, Corp.class);
		corp = corpRepository.save(corp);
		return modelMapper.map(corp, CorpDto.class);
	}

	@Override
	public CorpDto login(String corpLoginId, String corpPassword) throws Exception {
		Corp corp = corpRepository.findByCorpLoginId(corpLoginId).orElseThrow(() 
				-> new CorpNotFoundException(corpLoginId+"가 존재하지 않습니다."));
		if(!corp.getCorpPassword().equals(corpPassword)) {
			//패쓰워드불일치
			PasswordMismatchException exception=
				new PasswordMismatchException("패쓰워드가 일치하지않습니다.");
			throw exception;
		}
		return modelMapper.map(corp, CorpDto.class);
	}

	@Override
	@Transactional
	public CorpDto findCorp(String corpLoginId) throws Exception {
		Optional<Corp> optionalCorp = corpRepository.findByCorpLoginId(corpLoginId);
		Corp findCorp = optionalCorp.get();
		return modelMapper.map(findCorp, CorpDto.class);
	}

	@Override
	public CorpDto update(Long id,CorpDto corpDto) throws Exception {
		Corp corp = corpRepository.findById(id).orElseThrow(() 
				-> new CorpNotFoundException(corpDto.getCorpLoginId()+"가 존재하지않습니다."));
		corpDto.setId(id);
		corpDto.setCorpLoginId(corp.getCorpLoginId());
		corpDto.setCorpPassword(corp.getCorpPassword());
		modelMapper.map(corpDto, corp);
		corp = corpRepository.save(corp);
		return modelMapper.map(corp, CorpDto.class);
	}

	@Override
	public void remove(String corpLoginId) throws Exception {
		Corp corp = corpRepository.findByCorpLoginId(corpLoginId).orElseThrow(() 
				-> new CorpNotFoundException(corpLoginId+"가 존재하지않습니다."));
		corpRepository.delete(corp);
	}

	@Override
	public CorpDto findCorpWithimagesAndManagers(String corpLoginId) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CorpDto findCorpWithOrdersWithProduct(String corpLoginId) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CorpDto findCorpWithRecruits(String corpLoginId) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CorpDto findCorpWithReviews(String corpLoginId) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CorpDto> findCorpAll() throws Exception {
		List<Corp> corpList = corpRepository.findAll();
		return corpList.stream()
				.map(corp -> modelMapper.map(corp, CorpDto.class))
				.collect(Collectors.toList());
	}

	@Override
	public boolean isDuplicateId(String corpLoginId) throws Exception {
		return corpRepository.existsByCorpLoginId(corpLoginId);
	}
	

	
}
