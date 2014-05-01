package domain;

public class Point {
	private double conversionRateGold;
	private double conversionRateSilver;
	private double conversionRateBronze;
	private double balance;

	public double getConversionRateGold() {
		return this.conversionRateGold;
	}

	public void setConversionRateGold(double conversionRateGold) {
		this.conversionRateGold = conversionRateGold;
	}

	public double getConversionRateSilver() {
		return this.conversionRateSilver;
	}

	public void setConversionRateSilver(double conversionRateSilver) {
		this.conversionRateSilver = conversionRateSilver;
	}

	public double getConversionRateBronze() {
		return this.conversionRateBronze;
	}

	public void setConversionRateBronze(double conversionRateBronze) {
		this.conversionRateBronze = conversionRateBronze;
	}

	public double getBalance() {
		return this.balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}
}