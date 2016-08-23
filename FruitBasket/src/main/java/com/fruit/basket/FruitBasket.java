package main.java.com.fruit.basket;

import java.util.Map;

public interface FruitBasket {
	Double calculateFruitPrice(Map<FruitEnum, Integer> fruitRequirement) throws InvalidException;
	Map<FruitEnum, Integer> addFruit(String fruitName, Integer quantity);

}
