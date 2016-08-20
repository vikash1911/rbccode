package main.java.com.fruit.basket;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class FruitBasket {
	
	public static void main(String[] args) {
		Scanner fruit = new Scanner(System.in);
		 
		System.out.println("How many fruits you want :");
		int num = Integer.valueOf(fruit.nextLine());
		Map<String, Integer> fruitRequirements = new HashMap<>();
		
		for(int i=1; i <= num ; i++){
			  
			System.out.println("Please Enter the Fruit You Want : ");
			String fruitName = fruit.nextLine();
			System.out.println("Please Enter " +fruitName+"'s You Want : ");
			Integer fruitQuantity = Integer.valueOf(fruit.nextLine());
			fruitRequirements.put(fruitName, fruitQuantity);
			
		}
		FruitBasket fb = new FruitBasket();
		
		System.out.println(" final price is : " +fb.finalCost(fruitRequirements));
		
	}
	
	public Double finalCost(Map<String, Integer> fruitRequirements){
		FruitFactory fruitFactory = new FruitFactory();
		Double finalCost = 0.0 ;
		for(Map.Entry<String, Integer> fruitRequired : fruitRequirements.entrySet()){
			finalCost = fruitFactory.getFruitPrice(fruitRequired.getKey(), fruitRequired.getValue());
		}
		for(Map.Entry<String, Integer> fruitRequired : fruitRequirements.entrySet()){
			System.out.println("Fruit : " +fruitRequired.getKey() + " Price :" + fruitRequired.getValue());
		}
		return finalCost;
	}

}
