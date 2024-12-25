package com.example.asyncdemo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@SpringBootApplication
@EnableScheduling
public class AsyncdemoApplication implements CommandLineRunner {

	private int counter = 0;
	private boolean taskCompleted = false;

	public static void main(String[] args) {
		SpringApplication.run(AsyncdemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Програма запущена...");
	}

	// Метод для збільшення лічильника
	@Scheduled(fixedRate = 2000)
	public void incrementCounter() {
		if (!taskCompleted) {
			counter++;
			System.out.println("Лічильник: " + counter);
			if (counter == 10) {
				System.out.println("Завершення збільшення лічильника.");
				taskCompleted = true;
			}
		}
	}

	// Метод для виведення поточного часу
	@Scheduled(fixedRate = 5000)
	public void printCurrentTime() {
		if (!taskCompleted) {
			System.out.println("Поточний час: " + java.time.LocalTime.now());
		}
	}
}
