package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.SimpleTodoListEntity;
import com.example.demo.form.SimpleTodoForm;
import com.example.demo.logic.SimpleTodoLogicSharedService;
import com.example.demo.logic.UserLogicSharedService;
import com.example.demo.utility.DateUtilitySharedService;

@Service
public class SimpleTodoService {
	@Autowired
	SimpleTodoLogicSharedService simpleTodoLogicSharedService;
	@Autowired
	UserLogicSharedService userLogicSharedService;
	@Autowired
	DateUtilitySharedService utilitySharedService;
	
	@Transactional(rollbackForClassName = "Exception")
	public void insertSimpleTodoList(SimpleTodoForm form,int userId){
		//登録する内容をセットする
		SimpleTodoListEntity entity = new SimpleTodoListEntity();
		entity.setListName(form.getListName());
		entity.setUserId(userId);
		entity.setListDate(utilitySharedService.mergeDate(form.getListDate(), form.getListTime()));
		
		//処理
		simpleTodoLogicSharedService.insert(entity);
	}
	
	public List<SimpleTodoListEntity> getSimpleTodoLists(int userId){
		return simpleTodoLogicSharedService.get(userId);
	}
}
