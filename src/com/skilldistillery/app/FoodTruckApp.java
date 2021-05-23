package com.skilldistillery.app;

import java.util.Scanner;

public class FoodTruckApp {

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);

		FoodTruck[] foodTrucks = new FoodTruck[5];
		FoodTruckApp appHelp = new FoodTruckApp();

		int selection;

		// User prompted to create new food trucks
		for (int i = 0; i < 5; i++) {
			System.out.print("Please enter a food truck name: ");
			String name = kb.nextLine();
			if (name.equalsIgnoreCase("quit")) {
				break; // Continues to Menu Selection
			}
			System.out.print("Please enter the truck's food type: ");
			String foodType = kb.nextLine();
			System.out.print("What rating would you give their food (1 - 5): ");
			int rating = kb.nextInt();
			kb.nextLine(); // Clear buffer

			foodTrucks[i] = new FoodTruck(name, foodType, rating);
			System.out.println();
		}

		// Menu Selection
		do {
			appHelp.printMenu();
			selection = kb.nextInt();
			kb.nextLine(); // Clear buffer

			switch (selection) {
			case 1:
				appHelp.printFoodTrucks(foodTrucks);
				break;
			case 2:
				System.out.printf("Average Food Truck Rating: %.2f \n", appHelp.avgRating(foodTrucks));
				System.out.println();
				break;
			case 3:
				appHelp.highestRating(foodTrucks);
				break;
			case 4:
				System.out.println("Thank You for your ratings! Goodbye.");
				break;
			default:
				System.err.println("Invalid Input! Try Again!");
				break;
			}

		} while (selection != 4);

		kb.close();
	}

	public void printMenu() {
		System.out.println("------- Menu -------");
		System.out.println("1. List out food trucks");
		System.out.println("2. Display the average rating of food trucks");
		System.out.println("3. Display the highest rated food truck");
		System.out.println("4. Quit");
		System.out.println();
	}

	public void printFoodTrucks(FoodTruck[] truckArr) {
		for (int i = 0; i < truckArr.length; i++) {
			if (truckArr[i] != null) {
				System.out.println(truckArr[i]);
			}
		}
		System.out.println();
	}

	public double avgRating(FoodTruck[] truckArr) {
		double avg = 0.0;
		int count = 0;

		for (int i = 0; i < truckArr.length; i++) {
			if (truckArr[i] != null) {
				avg += truckArr[i].getRating();
				count++;
			}
		}

		avg /= count;
		return avg;
	}

	public void highestRating(FoodTruck[] truckArr) {
		int highestRating = truckArr[0].getRating();
		int index = 0;

		for (int i = 0; i < truckArr.length; i++) {
			if (truckArr[i] != null) {
				if (highestRating < truckArr[i].getRating()) {
					highestRating = truckArr[i].getRating();
					index = i;
				}
			}
		}

		System.out.println("Highest Rated Food Truck!");
		System.out.println(truckArr[index]);
		System.out.println();
	}
}
