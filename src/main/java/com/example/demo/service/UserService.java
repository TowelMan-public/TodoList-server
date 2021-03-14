package com.example.demo.service;

import org.apache.ibatis.javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.UserDetailsImp;
import com.example.demo.entity.UserEntity;
import com.example.demo.exception.AlreadyUsedException;
import com.example.demo.logic.UserLogicSharedService;

@Service
public class UserService {
	@Autowired
	UserLogicSharedService userLogicSharedService;
	
	@Transactional(rollbackForClassName = "Exception")
	public void deleteUser(int userId,String username) throws NotFoundException{
		userLogicSharedService.verificationExistsUsername(username);
		userLogicSharedService.deleteUser(userId);
	}
	
	//UserDetailsImpからUserEntityに変換することで実現
	public UserEntity getUser(UserDetailsImp user) {
		UserEntity entity = new UserEntity();
		entity.setIsEnabled(user.isEnabled()?1:0);
		entity.setUserId(user.getUserId());
		entity.setUsername(user.getUsername());
		return entity;
	}
	
	@Transactional(rollbackForClassName = "Exception")
	public void updateUsername(int userId,String oldUsername,String newUsername) throws NotFoundException,AlreadyUsedException{
		//更新するデータをセット
		UserEntity entity = new UserEntity();
		entity.setUserId(userId);
		entity.setUsername(newUsername);
		
		//検証
		userLogicSharedService.verificationExistsUsername(oldUsername);
		userLogicSharedService.verificationNotUsedUsername(newUsername);
		//処理
		userLogicSharedService.updateUserSelective(entity);
	}
	
	@Transactional(rollbackForClassName = "Exception")
	public void updatePassword(int userId,String username,String newPassword) throws NotFoundException{
		//更新するデータをセット
		UserEntity entity = new UserEntity();
		entity.setUserId(userId);
		entity.setPassword(newPassword);
		
		//検証
		userLogicSharedService.verificationExistsUsername(username);
		//処理
		userLogicSharedService.updateUserSelective(entity);
	}
}
