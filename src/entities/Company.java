package entities;

public class Company extends TaxPayer{
	
	private int numberOfEmplyees;
	
	public Company() {
	}
	
	public Company(String name, Double anualIncome, int numberOfEmplyees) {
		super(name, anualIncome);
		this.numberOfEmplyees = numberOfEmplyees;
	}

	public int getNumberOfEmplyees() {
		return numberOfEmplyees;
	}

	public void setNumberOfEmplyees(int numberOfEmplyees) {
		this.numberOfEmplyees = numberOfEmplyees;
	}

	@Override
	public double tax() {
		Double taxPaid;
		
		if(getNumberOfEmplyees() <= 10) {
			taxPaid = getAnualIncome() * 0.16;
		} else {
			taxPaid = getAnualIncome() * 0.14;
		}
		return taxPaid;
	}
	
	@Override
	public String toString(){
		StringBuilder sb = new StringBuilder();
		sb.append(getName());
		sb.append(": ");
		sb.append(String.format("%.2f", tax()));
		return sb.toString();
	}
}
