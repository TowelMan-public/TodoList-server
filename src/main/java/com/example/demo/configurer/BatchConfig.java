package com.example.demo.configurer;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.demo.batch.tasklet.EraseTasklet;

@EnableBatchProcessing
@Configuration
public class BatchConfig {
	private final JobBuilderFactory jobBuilderFactory;

    private final StepBuilderFactory stepBuilderFactory;

    private final EraseTasklet eraseTasklet;

    public BatchConfig(JobBuilderFactory jobBuilderFactory,
                       StepBuilderFactory stepBuilderFactory,
                       EraseTasklet helloWorldTasklet) {
        this.jobBuilderFactory = jobBuilderFactory;
        this.stepBuilderFactory = stepBuilderFactory;
        this.eraseTasklet = helloWorldTasklet;
    }

    @Bean
    public Job eraseJob(Step eraseStep) {
        return jobBuilderFactory.get("eraseJob") //Job名を指定
                .flow(eraseStep) //実行するStepを指定
                .end()
                .build();
    }

    @Bean
    public Step eraseStep() {
        return stepBuilderFactory.get("eraseStep") //Step名を指定
                .tasklet(eraseTasklet) //実行するTaskletを指定
                .build();
    }
}
