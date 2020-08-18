package entities;

public abstract class TaxPayer4 {
	
	private String name;
	private Double annualIncome;
	
	public TaxPayer4() {
		
	}
		
	public TaxPayer4(String name, Double annualIncome) {
		this.name = name;
		this.annualIncome = annualIncome;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getAnnualIncome() {
		return annualIncome;
	}
	public void setAnnualIncome(Double annualIncome) {
		this.annualIncome = annualIncome;
	}
	
	public abstract Double taxPaid();  //método área abstrato vazio
	
	
}
