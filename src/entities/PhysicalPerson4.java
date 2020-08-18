package entities;

public class PhysicalPerson4 extends TaxPayer4 {
	
	private Double health;
	
	public PhysicalPerson4() {
		super();
	}

	public PhysicalPerson4(String name, Double annualIncome, Double health) {
		super(name, annualIncome);
		this.health = health;
	}

	public Double getHealth() {
		return health;
	}

	public void setHealth(Double health) {
		this.health = health;
	}

	@Override
	public Double taxPaid() {
		if(getAnnualIncome() > 20000.00 || health != 0) {
			return getAnnualIncome() * 0.25 - (health * 0.50);
		}
		else
			return getAnnualIncome() * 0.15;
			
		
	}
	
	public String toString() {
		return getName() + ": $ " 
				+ String.format("%.2f",taxPaid());
	}
	

}
