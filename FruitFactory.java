package main.java.com.fruit.basket;

import java.util.ArrayList;
import java.util.List;

public class FruitFactory extends AbstractFruit {

	private List<Fruit> fruitsRequired = new ArrayList<Fruit>();

	@Override
	public Double getFruitPrice(String fruitName, Integer quantity) {
		
		Fruit fruit = null;
			      
	      if(fruitName.equalsIgnoreCase("Orange")){
	    	  fruit = new Orange();
	    	  addFruit(fruit, quantity);
	    	  
	      }else if(fruitName.equalsIgnoreCase("Banana")){
	    	  fruit = new Banana();
	    	  addFruit(fruit, quantity);
	         
	      }else if(fruitName.equalsIgnoreCase("Peach")){
	    	  fruit = new Peach();
	    	  addFruit(fruit, quantity);
	      }else{
	    	  System.out.println( " I don't have this fruit" + fruitName);
	      }
	      
	      return costOfFruits(this.fruitsRequired);
	}
	
	private void addFruit(Fruit fruit, Integer quantity){
		for(int i=1; i<=quantity;i++){
  		  this.fruitsRequired.add(fruit);
  	  }
	}
	
	private Double costOfFruits(List<Fruit> fruits){
		Double sum = 0.0;
		for(Fruit f : fruits){
			sum = sum + f.getPrice();
  	  }
		return sum;
	}
}
