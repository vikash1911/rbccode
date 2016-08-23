package com.fruit.basket;

import java.util.LinkedHashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import main.java.com.fruit.basket.FruitBasketImpl;
import main.java.com.fruit.basket.InvalidException;

public class FruitBasketTest {
	private Map<String, Integer> fruitRequirements = new LinkedHashMap<>();
	private FruitBasketImpl fruitBasket;
	private String[] fruitName;
	private int quantity;

	@Before
	public void setUp() throws Exception {
		fruitBasket = new FruitBasketImpl();
		fruitRequirements.put("BANANA", 10);
		fruitRequirements.put("ORANGE", 10);
		fruitRequirements.put("PEACH", 10);
		fruitRequirements.put("APPLE", 10);
		fruitName = new String[] { "BANANA", "ORANGE", "PEACH", "APPLE" };
		quantity = 1;
	}

	@Rule
	public ExpectedException thrown = ExpectedException.none();

	@Test
	public void testAllPersent() {
		try {
			Double finalPrice = fruitBasket.finalCost(fruitRequirements);
			Assert.assertEquals("Final Price not matches ", new Double(2500),
					finalPrice);
		} catch (InvalidException e) {
			Assert.assertEquals(e.getMessage(), "Fruit Not Available in Basket");
		}

	}

	@Test
	public void testBananaOrange() {
		try {
			fruitRequirements.clear();
			fruitRequirements.put("BANANA", 10);
			fruitRequirements.put("ORANGE", 10);
			Double finalPrice = fruitBasket.finalCost(fruitRequirements);
			Assert.assertEquals("Final Price not matches ", new Double(750),
					finalPrice);
		} catch (InvalidException e) {
			Assert.assertEquals(e.getMessage(), "Fruit Not Available in Basket");
		}
	}

	@Test
	public void testPeachApple() {
		try {
			fruitRequirements.clear();
			fruitRequirements.put("PEACH", 10);
			fruitRequirements.put("APPLE", 10);
			Double finalPrice = fruitBasket.finalCost(fruitRequirements);
			Assert.assertEquals("Final Price not matches ", new Double(1750),
					finalPrice);
		} catch (InvalidException e) {
			Assert.assertEquals(e.getMessage(), "Fruit Not Available in Basket");
		}
	}

	@Test
	public void testOrangeApple() {

		try {
			fruitRequirements.clear();
			fruitRequirements.put("ORANGE", 10);
			fruitRequirements.put("APPLE", 10);
			Double finalPrice = fruitBasket.finalCost(fruitRequirements);
			Assert.assertEquals("Final Price not matches ", new Double(1500),
					finalPrice);
		} catch (InvalidException e) {
			Assert.assertEquals(e.getMessage(), "Fruit Not Available in Basket");
		}
	}

	@Test
	public void testcalculateFruitPrice() {
		Double finalPrice = 0.0;
		try {
			for (String fruit : fruitName) {
				finalPrice = fruitBasket.calculateFruitPrice(fruit, quantity);
			}
			Assert.assertEquals("calulatedPrice ", new Double(250), finalPrice);
		} catch (InvalidException e) {
			e.printStackTrace();
		}
	}
}
