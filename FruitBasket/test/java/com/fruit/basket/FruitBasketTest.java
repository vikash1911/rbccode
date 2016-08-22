package com.fruit.basket;


import java.util.LinkedHashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

import main.java.com.fruit.basket.FruitBasket;
import main.java.com.fruit.basket.InvalidException;

public class FruitBasketTest {

	private Map<String, Integer> fruitRequirements = new LinkedHashMap<>();


	
	private void setAllFruit(){
		fruitRequirements.put("BANANA", 10);
		fruitRequirements.put("ORANGE", 10);
		fruitRequirements.put("PEACH", 10);
		fruitRequirements.put("APPLE", 10);
	}

	private void setBananaOrange(){
		fruitRequirements.put("BANANA", 10);
		fruitRequirements.put("ORANGE", 10);
		
	}
	
	private void setPeachApple(){
		fruitRequirements.put("PEACH", 10);
		fruitRequirements.put("APPLE", 10);
		
	}
	@Test
	public void testAllPersent() throws InvalidException {
		FruitBasket fb = new FruitBasket();
		setAllFruit();
		Double finalPrice = fb.finalCost(fruitRequirements);
		Assert.assertEquals("Final Price not matches ", new Double(2500), finalPrice);
	}
	
	@Test
	public void testBananaOrange() throws InvalidException {
		FruitBasket fb = new FruitBasket();
		setBananaOrange();
		Double finalPrice = fb.finalCost(fruitRequirements);
		Assert.assertEquals("Final Price not matches ", new Double(750), finalPrice);
	}
	
	@Test
	public void testPeachApple() throws InvalidException {
		FruitBasket fb = new FruitBasket();
		setPeachApple();
		Double finalPrice = fb.finalCost(fruitRequirements);
		Assert.assertEquals("Final Price not matches ", new Double(1750), finalPrice);
	}
	
	@Test
	public void testOrangeApple() throws InvalidException {
		FruitBasket fb = new FruitBasket();
		setOrangeApple();
		Double finalPrice = fb.finalCost(fruitRequirements);
		Assert.assertEquals("Final Price not matches ", new Double(1500), finalPrice);
	}

	private void setOrangeApple() {
		fruitRequirements.put("ORANGE", 10);
		fruitRequirements.put("APPLE", 10);
		
	}


}
