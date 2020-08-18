package entities;

public class Product1 {   //super classe

	private String name;
	private Double price;
	
	
	public Product1() { //construtor vazio
	}


	public Product1(String name, Double price) {
		this.name = name;
		this.price = price;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public Double getPrice() {
		return price;
	}


	public void setPrice(Double price) {
		this.price = price;
	}
	
	public String priceTag() { //mesma coisa que o toString
		return name
				+ " $ " 
				+ String.format("%.2f", price);
	}
	
}
