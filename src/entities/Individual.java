package entities;

public class Individual extends TaxPayer{

	private Double healthExpenditures;

	public Individual() {
		
	}
	
	public Individual(String name, Double anualIncome, Double healthExpenditures) {
		super(name, anualIncome);
		this.healthExpenditures = healthExpenditures;
	}

	public Double getHealthExpenditures() {
		return healthExpenditures;
	}

	public void setHealthExpenditures(Double healthExpenditures) {
		this.healthExpenditures = healthExpenditures;
	}

	@Override
	public double tax() {
		Double taxPaid;
		
		if(getAnualIncome() < 20000.00) {
			taxPaid = getAnualIncome() * 0.15;
		} else {
			taxPaid = getAnualIncome() * 0.25;
		}
		
		if(getHealthExpenditures() > 0) {
			taxPaid -= getHealthExpenditures() * 0.50;
			if(taxPaid < 0) {
				taxPaid = 0.0;
			}
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
