package com.example.demo.logic;

import org.apache.ibatis.javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.example.demo.dto.UserEntityExample;
import com.example.demo.entity.UserEntity;
import com.example.demo.exception.AlreadyUsedException;
import com.example.demo.repository.UserEntityMapper;

@Component
public class UserLogicSharedService {
	@Autowired
	private UserEntityMapper userMapper;
	
	public void updateUserByPrimaryKeySelective(UserEntity entity) {
		userMapper.updateByPrimaryKeySelective(entity);
	}
	
	//ユーザーの削除（is_enableを0に設定）
	public void deleteUser(int userId) {
		UserEntity record = new UserEntity();
		record.setUserId(userId);
		record.setIsEnabled(0);
		userMapper.updateByExampleSelective(record, new UserEntityExample());
	}
	
	//ユーザー名から取得
	public UserEntity getUserByUsername(String username) throws UsernameNotFoundException{
		try {
			var entityList = userMapper.selectByExample(makeSelectByUsernameSql(username));
			return entityList.get(0);
		}
		catch(IndexOutOfBoundsException e) {
			throw new UsernameNotFoundException("Username is not found.");
		}
	}
	
	//ユーザー名が存在してるかを検証する
	public void verificationExistsUsername(String username) throws NotFoundException{
		//検証
		if(userMapper.countByExample(makeSelectByUsernameSql(username)) == 0)
			throw new NotFoundException("Username is not found.");
	}
	
	//ユーザー名が使われていないかを検証する
	public void verificationNotUsedUsername(String username) throws AlreadyUsedException{
		//検証
		if(userMapper.countByExample(makeSelectByUsernameSql(username)) == 0)
			throw new AlreadyUsedException("Username have already used.");
	}
	
	//ユーザー名を指定しての検索のSQL作成
	private UserEntityExample makeSelectByUsernameSql(String username) {
		UserEntityExample selectDto = new UserEntityExample();
		selectDto
			.or()
			.andUsernameEqualTo(username)
			.andIsEnabledEqualTo(1);
		return selectDto;
	}

	public void insertUser(UserEntity entity) {
		userMapper.insertSelective(entity);
	}
}
