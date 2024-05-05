public class Car implements Comparable<Car> {
	private String vin;
	private String name;
	private String dob;

	public Car(String vin, String name, String dob) {
		this.vin = vin;
		this.name = name;
		this.dob = dob;
	}

	// public Car(String name) {
	//     this.name = name;
	// }

	public String getVin() {
		return vin;
	}

	public String getName() {
		return name;
	}

	public String getDob() {
		return dob;
	}

	@Override
	public int compareTo(Car otherCar) {
		return this.name.compareTo(otherCar.getName());
	}
}
