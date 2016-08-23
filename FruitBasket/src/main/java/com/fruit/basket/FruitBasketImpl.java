package main.java.com.fruit.basket;

import java.util.LinkedHashMap;
import java.util.Map;

public class FruitBasketImpl implements FruitBasket {

	private Map<FruitEnum, Integer> fruitRequirements = new LinkedHashMap<>();

	@Override
	public Double calculateFruitPrice(String fruitName, Integer quantity)
			throws InvalidException {

		if (fruitName == null || fruitName.trim().equals("")) {
			throw new InvalidException("Fruit Not Available in Basket");
		}
		FruitEnum fruit = null;
		switch (fruitName.toUpperCase()) {
		case "BANANA":
			fruit = FruitEnum.BANANA;
			addFruit(fruit, quantity);
			break;
		case "ORANGE":
			fruit = FruitEnum.ORANGE;
			addFruit(fruit, quantity);
			break;
		case "PEACH":
			fruit = FruitEnum.PEACH;
			addFruit(fruit, quantity);
			break;
		case "APPLE":
			fruit = FruitEnum.APPLE;
			addFruit(fruit, quantity);
			break;
		default:
			fruit = null;
		}
		return costOfFruits(this.fruitRequirements);

	}

	private void addFruit(FruitEnum fruit, Integer quantity)
			throws InvalidException {
		if (fruit == null) {
			throw new InvalidException("Fruit Not Available in Basket");
		}
		fruitRequirements.put(fruit, quantity);
	}

	private Double costOfFruits(Map<FruitEnum, Integer> fruitRequirement)
			throws InvalidException {
		if (fruitRequirement == null || fruitRequirement.isEmpty()) {
			throw new InvalidException("Fruit Not Available in Basket");
		}
		Double sum = 0.0;
		for (Map.Entry<FruitEnum, Integer> fruitRequired : fruitRequirement
				.entrySet()) {
			sum = sum + fruitRequired.getKey().getFruitPrice()
					* fruitRequired.getValue();

		}

		return sum;
	}

	public Double finalCost(Map<String, Integer> fruitRequirements)
			throws InvalidException {
		FruitBasket fruit = new FruitBasketImpl();
		;
		Double finalCost = 0.0;
		for (Map.Entry<String, Integer> fruitRequired : fruitRequirements
				.entrySet()) {
			finalCost = fruit.calculateFruitPrice(fruitRequired.getKey(),
					fruitRequired.getValue());
		}
		for (Map.Entry<String, Integer> fruitRequired : fruitRequirements
				.entrySet()) {
			fruitRequired.getKey();
			fruitRequired.getValue();
		}
		return finalCost;
	}

}
