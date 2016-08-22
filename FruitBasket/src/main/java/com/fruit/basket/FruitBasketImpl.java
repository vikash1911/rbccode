package main.java.com.fruit.basket;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

 public class FruitBasketImpl implements FruitBasket {

	private List<FruitEnum> fruitsRequired = new ArrayList<FruitEnum>();
	private Map<FruitEnum, Integer> fruitRequirements = new LinkedHashMap<>();

	@Override
	public Double calculateFruitPrice(String fruitName, Integer quantity)
			throws InvalidException {

		if (fruitName == null || fruitName.trim().equals("")) {
			throw new InvalidException("Fruit Not Available in Basket");
		}
		FruitEnum fruit = null;
		switch (fruitName) {
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
		return costOfFruits(this.fruitsRequired);

	}

	private void addFruit(FruitEnum fruit, Integer quantity)
			throws InvalidException {
		if (fruit == null) {
			throw new InvalidException("Fruit Not Available in Basket");
		}
		fruitRequirements.put(fruit, quantity);
		for (int i = 1; i <= quantity; i++) {
			this.fruitsRequired.add(fruit);
		}
	}

	private Double costOfFruits(List<FruitEnum> fruits) throws InvalidException {
		if (fruits == null || fruits.isEmpty()) {
			throw new InvalidException("Fruit Not Available in Basket");
		}
		Double sum = 0.0;
		for (FruitEnum f : fruits) {
			sum = sum + f.getFruitPrice();
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
