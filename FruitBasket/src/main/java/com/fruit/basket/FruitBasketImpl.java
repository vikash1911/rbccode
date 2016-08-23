package main.java.com.fruit.basket;

import java.util.LinkedHashMap;
import java.util.Map;

public class FruitBasketImpl implements FruitBasket {

	private Map<FruitEnum, Integer> fruitRequirement = new LinkedHashMap<>();

	@Override
	public Double calculateFruitPrice(Map<FruitEnum, Integer> fruitRequirement)
			throws InvalidException {

		if (fruitRequirement == null || fruitRequirement.isEmpty()) {
			throw new InvalidException("Fruit Not Available in Basket");
		}
		Double price = 0.0;
		for (Map.Entry<FruitEnum, Integer> fruitRequired : fruitRequirement.entrySet()) {
			price = price + (fruitRequired.getKey().getFruitPrice() * fruitRequired.getValue());
		}
		return price;

	}

	@Override
	public Map<FruitEnum, Integer> addFruit(String fruitName, Integer quantity) {
		FruitEnum fruit = null;
		switch (fruitName.toUpperCase()) {
		case "BANANA":
			fruit = FruitEnum.BANANA;
			fruitRequirement.put(fruit, quantity);
			break;
		case "ORANGE":
			fruit = FruitEnum.ORANGE;
			fruitRequirement.put(fruit, quantity);
			break;
		case "PEACH":
			fruit = FruitEnum.PEACH;
			fruitRequirement.put(fruit, quantity);
			break;
		case "APPLE":
			fruit = FruitEnum.APPLE;
			fruitRequirement.put(fruit, quantity);
			break;
		default:
			fruitRequirement = null;
			break;
		}
		return fruitRequirement;
	}


}
