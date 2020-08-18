package entities;

public class OutsourcedEmployee extends Employee{  //Sub classe da classe Employee - Heran�a
	
	private Double addicionalCharge;
	
	public OutsourcedEmployee() {
		super();
	}
	//construtor realizando heran�a da super classe Employee
	public OutsourcedEmployee(String name, Integer hours, Double valuePerHour, Double addicionalCharge) { 
		super(name, hours, valuePerHour);
		this.addicionalCharge = addicionalCharge;
	}
	public Double getAddicionalCharge() {
		return addicionalCharge;
	}
	public void setAddicionalCharge(Double addicionalCharge) {
		this.addicionalCharge = addicionalCharge;
	}
	
	//Sobre escrever o m�todo de pagamento para reaproveitar o m�todo 
	@Override
	public Double payment() {  //valor do pagamento
		return super.payment() + addicionalCharge * 1.1;// Pagamento normal + 110* do addicionalCharge
		
	}
	

}
