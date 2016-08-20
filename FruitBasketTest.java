package com.fruit.basket;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import main.java.com.fruit.basket.FruitBasket;

public class FruitBasketTest {

	private Map<String, Integer> fruitRequirements = new HashMap<>();


	@Before
	public void setUp() throws Exception {
		fruitRequirements.put("Orange", 10);
		fruitRequirements.put("Banana", 10);
		fruitRequirements.put("Peach", 10);
	}

	@Test
	public void test() {
		FruitBasket fb = new FruitBasket();
		Double finalPrice = fb.finalCost(fruitRequirements);
		Assert.assertEquals("Final Price not matches ", new Double(2250), finalPrice);
	}

}
