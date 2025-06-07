package com.ty.bikemanagement.services;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ty.bikemanagement.model.Bike;
import com.ty.bikemanagement.model.Hero;
import com.ty.bikemanagement.model.Honda;
import com.ty.bikemanagement.repoistary.BikeRepoistary;

@Service
public class BikeService {
	@Autowired
	private BikeRepoistary bikeRepoistary;
	private Scanner scanner = new Scanner(System.in);
	@Autowired
	private Hero hero;
	@Autowired
	private Honda honda;
	public void saveBike() {
		System.out.println("user\nenter 1 to save\nhero \nenter 2 to save \nhonda");
		int choice = scanner.nextInt();
		if (choice == 1)
			bikeRepoistary.saveBike(enterBikeDetails(hero));
		else if (choice == 2)
			bikeRepoistary.saveBike(enterBikeDetails(honda));
		else
			System.out.println("invaild choice");

	}

	public void updateBike() {
		System.out.println("user enter 1 to update hero bikes price or 2 to update honda bikes");
		int choice=choice();
		Bike bike = null;
		try {
		if (choice == 1) {
			List<Hero> heros = getHeroBikes();
			System.out.println("user enter index to select hero bike to update");
			bike = heros.get(scanner.nextInt());
		} else if (choice == 2) {
			List<Honda> hondas = getHondaBikes();
			System.out.println("user enter index to select honda bike to update");
			bike = hondas.get(scanner.nextInt());
		} else {
			System.out.println("invalid choice");
			return;
		}
		
		System.out.println("user enter new price");
		bike.setPrice(scanner.nextDouble());
		bikeRepoistary.updateBike(bike);
		}catch(IndexOutOfBoundsException | InputMismatchException e) {
			e.printStackTrace();
		}

	}

	public List<Hero> getHeroBikes() {
		List<Hero> heros = bikeRepoistary.getHeros();
		System.out.println("----------------------------------");
		int index=0;
		for (Hero hero : heros)
			System.out.println("index is ->"+index++ +"-"+hero);

		return heros;

	}

	public List<Honda> getHondaBikes() {
		List<Honda> hondas = bikeRepoistary.getHondas();
		System.out.println("----------------------------------");
		int index = 0;
		for (Honda honda : hondas)
			System.out.println("index is ->"+index++ +"-" + honda);

		return hondas;

	}

	public void delete() {
		System.out.println("user\nenter 1 to delete\nhero \nenter 2 to delete \nhonda");
		int choice = choice();
		try {
		if (choice == 1) {

			List<Hero> heros = getHeroBikes();
			System.out.println("user enter select index to delete");
			bikeRepoistary.deleteBike(heros.get(scanner.nextInt()));

		} else if (choice == 2) {
			List<Honda> hondas = getHondaBikes();
			System.out.println("user enter select index to delete");
			bikeRepoistary.deleteBike(hondas.get(scanner.nextInt()));
		} else
			System.out.println("invalid choice");
		}catch(InputMismatchException | IndexOutOfBoundsException e)
		{
			e.printStackTrace();
		}
	}

	private Bike enterBikeDetails(Bike b) {
		
		System.out.println("user enter bike id");
		b.setId(scanner.nextInt());
		scanner.nextLine();
		System.out.println("user enter bike model");
		b.setModel(scanner.nextLine());
		System.out.println("user enter no of gears");
		b.setNo_of_gears(scanner.nextInt());
		System.out.println("user enter bike price");
		b.setPrice(scanner.nextDouble());
		return b;
	}
	public int choice() {
		int choice=scanner.nextInt();
		return choice;
	}
}
