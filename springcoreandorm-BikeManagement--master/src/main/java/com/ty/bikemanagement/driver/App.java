package com.ty.bikemanagement.driver;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ty.bikemanagement.config.AppConfig;
import com.ty.bikemanagement.model.Hero;
import com.ty.bikemanagement.model.Honda;
import com.ty.bikemanagement.repoistary.BikeRepoistary;
import com.ty.bikemanagement.services.BikeService;

/**
 * Hello world!
 */
public class App {
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("------Welcome To BikeManagement------");
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
		BikeService bikeservice = applicationContext.getBean(BikeService.class);
		boolean flag = true;

		while (flag) {
			System.out.println("user enter 1 to save");
			System.out.println("user enter 2 to find all the hero bikes");
			System.out.println("user enter 3 to find all the honda bikes");
			System.out.println("user enter 4 to update bike");
			System.out.println("user enter 5 to delete bike");
			System.out.println("user enter 6 to exit");
			int choice = scanner.nextInt();
			switch (choice) {
			case 1:
				bikeservice.saveBike();

				break;
			case 2:
				bikeservice.getHeroBikes();
				break;
			case 3:
				bikeservice.getHondaBikes();
				break;
			case 4:
				bikeservice.updateBike();
				break;
			case 5:
				bikeservice.delete();
				break;
			case 6:
				flag = false;
				break;
			default:
				System.out.println("invaild choice");
				break;
			}
		}

	}
}
