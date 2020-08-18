package entities;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import entities.enums.WorkerLevel;

public class Worker {

	private String name;
	private WorkerLevel level; // chamando o Enums
	private Double baseSalary;
	// composicao de objetos. //Ligacao entre Worker,Departamento e HourContract. Trabalhador pertence a 1 departamento e a vários contratos
	private Department department; 
	private List<HourContract> contracts = new ArrayList<>();// gerar uma lista para o HourContract, pois um
																// trabalhador tem muitos contratos

	public Worker() { //construtor vazio

	}

	public Worker(String name, WorkerLevel level, Double baseSalary, Department department) {
		this.name = name;
		this.level = level;
		this.baseSalary = baseSalary;
		this.department = department;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public WorkerLevel getLevel() {
		return level;
	}

	public void setLevel(WorkerLevel level) {
		this.level = level;
	}

	public Double getBaseSalary() {
		return baseSalary;
	}

	public void setBaseSalary(Double baseSalary) {
		this.baseSalary = baseSalary;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public List<HourContract> getContracts() {
		return contracts;
	}

	// Métodos responsáveis por remover ou adicionar a associacao do contrato com o
	// trabalhador
	public void addContract(HourContract contract) { // pegar a lista de contratos e adicionar esse contrato que está
														// passado como argumento
		contracts.add(contract);
	}

	public void removeContract(HourContract contract) {
		contracts.remove(contract);
	}

	public Double income(int year, int month) {
		Double sum = baseSalary;
		Calendar cal = Calendar.getInstance(); // classe calendario
		for (HourContract c : contracts) { // Lê-se como para cada contrato C na lista contract
			cal.setTime(c.getDate()); // Pegar a data do contrato e definir essa data como sendo a data do calendario
			int c_year = cal.get(Calendar.YEAR);
			int c_month = 1 + cal.get(Calendar.MONTH); // Calendario coma 1 porque janeiro é mês 0
			if (year == c_year && month == c_month) {// validacao se o ano e o mês informados sao os mesmos
				sum = c.totalValue();
			}
		}
		return sum;
	}
}
