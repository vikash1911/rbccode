package main.java.com.fruit.basket;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class FruitBasket {
	
	public static void main(String[] args) throws InvalidException {
		Scanner fruit = new Scanner(System.in);
		 
		System.out.println("How many fruits you want :");
		int num = Integer.valueOf(fruit.nextLine());
		Map<String, Integer> fruitRequirements = new LinkedHashMap<>();
		
		for(int i=1; i <= num ; i++){
			  
			System.out.println("Please Enter the Fruit You Want : ");
			String fruitName = fruit.nextLine().toUpperCase();
			System.out.println("Please Enter " +fruitName+"'s You Want : ");
			Integer fruitQuantity = Integer.valueOf(fruit.nextLine());
			fruitRequirements.put(fruitName, fruitQuantity);
			
		}
		FruitBasket fb = new FruitBasket();
		
		System.out.println(" final price is : " +fb.finalCost(fruitRequirements));
		
	}
	
	public Double finalCost(Map<String, Integer> fruitRequirements) throws InvalidException{
		Fruit fruit = new FruitImpl();;
		Double finalCost = 0.0 ;
		for(Map.Entry<String, Integer> fruitRequired : fruitRequirements.entrySet()){
			finalCost = fruit.calculateFruitPrice(fruitRequired.getKey(), fruitRequired.getValue());
		}
		for(Map.Entry<String, Integer> fruitRequired : fruitRequirements.entrySet()){
			System.out.println("Fruit : " +fruitRequired.getKey() + " Price :" + fruitRequired.getValue());
		}
		return finalCost;
	}

}
