package com.itwill.ilhajob.user.service;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.NamingConventions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.itwill.ilhajob.user.dto.UserDto;
import com.itwill.ilhajob.user.entity.User;
import com.itwill.ilhajob.user.exception.ExistedUserException;
import com.itwill.ilhajob.user.exception.PasswordMismatchException;
import com.itwill.ilhajob.user.exception.UserNotFoundException;
import com.itwill.ilhajob.user.repository.UserRepository;

@Service
@Transactional
public class UserServiceImpl implements UserService{
	
	private final UserRepository userRepository;
	private final ModelMapper modelMapper;
	
	@Autowired
	public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper) {
		this.userRepository = userRepository;
		this.modelMapper = modelMapper;
	}
	
	@Override
	public UserDto create(UserDto userDto) throws Exception {
		Optional<User> found = userRepository.findByUserEmail(userDto.getUserEmail());
        if (found.isPresent()) {
        	//아이디중복
			ExistedUserException exception=
					new ExistedUserException(userDto.getUserEmail()+" 는 이미 존재하는아이디입니다.");
			exception.setData(userDto);
			throw exception;
        }
        User user = modelMapper.map(userDto, User.class);
        user = userRepository.save(user);
        return modelMapper.map(user, UserDto.class);
	}

	@Override
	public UserDto login(String userEmail, String userPassword) throws Exception {
		User user = userRepository.findByUserEmail(userEmail).orElseThrow(() 
				-> new UserNotFoundException(userEmail+"와 일치하는 email이 존재하지 않습니다."));
        if (!user.getUserPassword().equals(userPassword)) {
        	//패쓰워드불일치
			PasswordMismatchException exception=
				new PasswordMismatchException("패쓰워드가 일치하지않습니다.");
			throw exception;
        }
        return modelMapper.map(user, UserDto.class);
	}
	
	@Override
	public UserDto findUser(String userEmail) throws Exception {
		Optional<User> optionalUser = userRepository.findByUserEmail(userEmail);
		User findUser = optionalUser.get();
		return modelMapper.map(findUser, UserDto.class);
	}

	@Override
	@Transactional
	public UserDto update(Long id, UserDto userDto) throws Exception {
        User user = userRepository.findById(id).orElseThrow(() 
        		-> new UserNotFoundException("존재하지 않습니다."));
        userDto.setId(id);
        userDto.setUserEmail(user.getUserEmail());
        userDto.setUserPassword(user.getUserPassword());
        modelMapper.map(userDto, user);
        user = userRepository.save(user);
        return modelMapper.map(user, UserDto.class);
	}

	@Override
	public void remove(Long id) throws Exception {
		User user = userRepository.findById(id).orElseThrow(() 
				-> new UserNotFoundException("User not found for id : " + id));
        userRepository.delete(user);
	}

	@Override
	public boolean isDuplicateEmail(String userEmail) throws Exception {
		return userRepository.existsByUserEmail(userEmail);
	}

}
