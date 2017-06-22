package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.task.configuration.EnableTask;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableTask
public class SpringcloudTaskApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringcloudTaskApplication.class, args);
	}
	
	@Bean
	public TollProcessingTask tollProcessingTask() {
		return new TollProcessingTask();
	}
	
	public class TollProcessingTask implements CommandLineRunner {

		@Override
		public void run(String... strings) throws Exception {
			
			//parameters stationid, license plate, timestamp
			if (null != strings) {
				System.out.println("parameter length is " + strings.length);
				
				String stationId = strings[1];
				String licensePlace  = strings[2];
				String timestamp = strings[3];
				
				System.out.println("Station ID is " + stationId + ", plate is " + licensePlace + ", timestamp is " + timestamp);
			}
			
			System.out.println("Task completed.");
			
		}
	}
}
