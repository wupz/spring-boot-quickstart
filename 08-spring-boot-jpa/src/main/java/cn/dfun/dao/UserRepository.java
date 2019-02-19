package cn.dfun.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import cn.dfun.pojo.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
