package com.example.demo.batch.tasklet;

import java.util.Calendar;
import java.util.Date;

import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.dto.ListEntityExample;
import com.example.demo.entity.ListEntity;
import com.example.demo.repository.EraseMapper;
import com.example.demo.repository.ListEntityMapper;

@Component
public class EraseTasklet implements Tasklet{
	@Autowired
	EraseMapper eraseMapper;
	@Autowired
	ListEntityMapper listEntityMapper;
	
	@Override
	public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
		//処理
		deleteOldListBeforDays(0);
		eraseUnabledAllBeforDate(new Date());		
		return RepeatStatus.FINISHED;
	}
	
	//古くなった（指定された日付より一定日数過ぎた）Listの削除（Deleteは有効根はないものにするの意味）
	private void deleteOldListBeforDays(int days) {
		//タイムスタンプ作成
		Calendar beforDate = Calendar.getInstance();
		beforDate.setTime(new Date());
		beforDate.add(Calendar.DAY_OF_YEAR, -days);
		
		//データセット
		ListEntity entity = new ListEntity();
		entity.setIsEnabled(false);
		entity.setUpdateTimestamp(beforDate.getTime());
		
		//SQL作成
		ListEntityExample updateDto = new ListEntityExample();
		updateDto.or()
			.andListDateLessThan(beforDate.getTime());
		
		//処理
		listEntityMapper.updateByExampleSelective(entity, updateDto);
	}
	
	//タイムスタンプから一定期間たっているあらゆるものを消去（データを完全に消す）
	private void eraseUnabledAllBeforDate(Date date) {
		eraseMapper.eraseUnenabledUser();
		eraseMapper.eraseUnenabledSpace(date);
		eraseMapper.eraseUnenabledList(date);
		eraseMapper.eraseUnenabledContent(date);
	}
}
