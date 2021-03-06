package com.bdqn.service;

import java.util.List;

import com.bdqn.common.PageBean;
import com.bdqn.entity.User;

public interface UserService extends BaseService<User>{

	User findByUserName(String username);

	User findByUserCode(String code);

	PageBean<User> findByPage(Integer page);

}
