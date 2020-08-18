package entities;

public class LegalEntity4 extends TaxPayer4 {

	private Integer employees; // numero de funcionarios

	public LegalEntity4() {
		super();
	}

	public LegalEntity4(String name, Double annualIncome, Integer employees) {
		super(name, annualIncome);
		this.employees = employees;
	}

	public Integer getEmployees() {
		return employees;
	}

	public void setEmployees(Integer employees) {
		this.employees = employees;
	}

	@Override
	public Double taxPaid() { // polimorfismo
		if (employees > 10) {
			return getAnnualIncome() * 0.14;
		} 
		else {
			return getAnnualIncome() * 0.16;
		}
	}


	public String toString() {
		return getName() + ": $ " 
				+ String.format("%.2f",taxPaid());
	}
}
