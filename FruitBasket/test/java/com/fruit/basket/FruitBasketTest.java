package com.fruit.basket;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import main.java.com.fruit.basket.FruitBasketImpl;
import main.java.com.fruit.basket.InvalidException;

public class FruitBasketTest {
	private FruitBasketImpl fruitBasket;
	private String[] fruitName;
	private int quantity;

	@Before
	public void setUp() throws Exception {
		fruitBasket = new FruitBasketImpl();
		fruitName = new String[] { "BANANA", "ORANGE", "PEACH", "APPLE" };
		quantity = 1;
	}

	
	@Test(expected=InvalidException.class)
	public void testcalculateFruitPrice() throws InvalidException {
		Double finalPrice = 0.0;
			for (String fruit : fruitName) {
				finalPrice = fruitBasket.calculateFruitPrice(fruit, quantity);
			}
			Assert.assertEquals("calulatedPrice ", new Double(250), finalPrice);
	}
}
