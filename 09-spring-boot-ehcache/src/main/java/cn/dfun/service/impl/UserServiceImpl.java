package cn.dfun.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import cn.dfun.dao.UserRepository;
import cn.dfun.pojo.User;
import cn.dfun.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository userRepository;

	@Override
	@Cacheable(value="user")
	public User findById(Integer id) {
		User user = userRepository.findOne(id);
		return user;
	}
}
