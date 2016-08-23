package com.fruit.basket;


import java.util.LinkedHashMap;
import java.util.Map;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import main.java.com.fruit.basket.FruitBasket;
import main.java.com.fruit.basket.FruitBasketImpl;
import main.java.com.fruit.basket.FruitEnum;
import main.java.com.fruit.basket.InvalidException;

public class FruitBasketTest {
	private FruitBasket fruitBasket;
	private int quantity;
	private Map<FruitEnum, Integer> fruitRequirement;
	private Double fruitPrice;
	

	@Before
	public void setUp() throws Exception {
		fruitBasket = new FruitBasketImpl();
		quantity = 1;
		fruitPrice = 0.0;
		fruitRequirement = new LinkedHashMap<>();
		fruitRequirement.put(FruitEnum.BANANA, quantity);
		fruitRequirement.put(FruitEnum.ORANGE, quantity);
		fruitRequirement.put(FruitEnum.PEACH, quantity);
		fruitRequirement.put(FruitEnum.APPLE, quantity);
		
	}

	
	@Test
	public void testcalculateFruitPriceAll() throws InvalidException {
		Double fruitPrice = 0.0;
		fruitPrice = fruitBasket.calculateFruitPrice(fruitRequirement);
		Assert.assertEquals("calulatedPrice", new Double(250), fruitPrice);
	}
	
	@Test
	public void testcalculateFruitPriceBananaOrange() throws InvalidException {
		fruitRequirement.clear();
		fruitRequirement.put(FruitEnum.BANANA, quantity);
		fruitRequirement.put(FruitEnum.ORANGE, quantity);
		fruitPrice = fruitBasket.calculateFruitPrice(fruitRequirement);
		Assert.assertEquals("calulatedPrice", new Double(75), fruitPrice);
	}
	
	@Test
	public void testcalculateFruitPriceOrangePeach() throws InvalidException {
		fruitRequirement.clear();
		fruitRequirement.put(FruitEnum.ORANGE, quantity);
		fruitRequirement.put(FruitEnum.PEACH, quantity);
		fruitPrice = fruitBasket.calculateFruitPrice(fruitRequirement);
		Assert.assertEquals("calulatedPrice", new Double(125), fruitPrice);
	}
	
	@Test
	public void testcalculateFruitPricePeachApple() throws InvalidException {
		fruitRequirement.clear();
		fruitRequirement.put(FruitEnum.PEACH, quantity);
		fruitRequirement.put(FruitEnum.APPLE, quantity);
		fruitPrice = fruitBasket.calculateFruitPrice(fruitRequirement);
		Assert.assertEquals("calulatedPrice", new Double(175), fruitPrice);
	}
	
	@Test(expected=InvalidException.class)
	public void testWhenNoFruitinBasket() throws InvalidException {
		fruitRequirement = null;
		fruitPrice = fruitBasket.calculateFruitPrice(fruitRequirement);
		Assert.assertEquals("Fruit Not Available in Basket", new Double(0.0), fruitPrice);
		
	}
}
