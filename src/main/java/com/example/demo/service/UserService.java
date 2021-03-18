package com.example.demo.service;

import org.apache.ibatis.javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.UserDetailsImp;
import com.example.demo.entity.UserEntity;
import com.example.demo.exception.AlreadyUsedException;
import com.example.demo.form.UserForm;
import com.example.demo.logic.SimpleTodoLogicSharedService;
import com.example.demo.logic.SpacePrimaryLogicSharedService;
import com.example.demo.logic.UserLogicSharedService;

@Service
public class UserService {
	@Autowired
	UserLogicSharedService userLogicSharedService;
	@Autowired
	SimpleTodoLogicSharedService simpleTodoLogicSharedService;
	@Autowired
	SpacePrimaryLogicSharedService spacePrimaryLogicSharedService;
	@Autowired
	PasswordEncoder encoder;
	
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
		userLogicSharedService.updateUserByPrimaryKeySelective(entity);
	}
	
	@Transactional(rollbackForClassName = "Exception")
	public void updatePassword(int userId,String username,String newPassword) throws NotFoundException{
		//更新するデータをセット
		UserEntity entity = new UserEntity();
		entity.setUserId(userId);
		entity.setPassword( passwordEncod(newPassword) );
		
		//検証
		userLogicSharedService.verificationExistsUsername(username);
		//処理
		userLogicSharedService.updateUserByPrimaryKeySelective(entity);
	}

	@Transactional(rollbackForClassName = "Exception")
	public void insertUser(UserForm form) throws AlreadyUsedException {
		//検証
		userLogicSharedService.verificationNotUsedUsername(form.getUsername());
		
		//データセット
		UserEntity entity = new UserEntity();
		entity.setPassword( passwordEncod(form.getPassword() ));
		entity.setUsername(form.getUsername());
		
		//処理
		userLogicSharedService.insertUser(entity);
		
		//必要データ作成（シンプルToDoを作成しておく）
		int userId = userLogicSharedService.getUserByUsername(entity.getUsername()).getUserId();
		int spaceId = spacePrimaryLogicSharedService.insertSpacePrimary().getSpaceId();
		simpleTodoLogicSharedService.createNewSimpleTodoListSpace(spaceId,userId);
	}
	
	//パスワードを暗号化する
	private String passwordEncod(String password) {
		return encoder.encode(password);
	}
}
