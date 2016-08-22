package main.java.com.fruit.basket;

public enum FruitEnum {
	BANANA(25.00),
	ORANGE(50.00),
	PEACH(75.00), 
	APPLE(100.00);
	
	private final double fruitPrice;

	FruitEnum(double fruitPrice) {
        this.fruitPrice = fruitPrice;
    }
    
    public double getFruitPrice() {
        return this.fruitPrice;
    }
	

}
