package entities;

public class ImportedProduct1 extends Product1{
	
	private Double customsFee;
	
	public ImportedProduct1() {
		super();
	}

	public ImportedProduct1(String name, Double price, Double customsFee) {  //construtor com argumentos, herdando da classe product1
		super(name, price);
		this.customsFee = customsFee;
	}

	public Double getCustomsFee() {
		return customsFee;
	}

	public void setCustomsFee(Double customsFee) {
		this.customsFee = customsFee;
	}
	
	@Override
	public String priceTag() {
		return getName()
				+ " $ " 
				+ String.format("%.2f", totalPrice())
				+ " (Customs fee: $ " 
				+ String.format("%.2f", customsFee)
				+ ")";
	}
	public Double totalPrice() {
		return getPrice() + customsFee; 
	}
}
