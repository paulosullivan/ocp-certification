package pos.ocp.lambdas;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Car {

	private String make;

	private String model;

	private String color;

	private int year;

	public Car() {
	}

	public Car(String make, String model, String color, int year) {
		this.make = make;
		this.model = model;
		this.color = color;
		this.year = year;
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	@Override
	public String toString() {
		return "Car [make=" + make + ", model=" + model + ", color=" + color + ", year=" + year + "]";
	}

	public static void main(String[] args) {
		// int compare(T o1, T o2);

		Car car1 = new Car("Skoda", "Jetty", "black", 2017);
		Car car2 = new Car("Mazda", "3", "red", 2016);
		Car car3 = new Car("Audi", "A3", "white", 2015);
		List<Car> cars = new ArrayList<>();
		cars.add(car1);
		cars.add(car2);
		cars.add(car3);

		// Car Comparator Options

		// Option 1 : Implement Comparator interface
		// Using an anonymous inner class
		Comparator<Car> yearComparator = new Comparator<Car>() {
			@Override
			public int compare(Car o1, Car o2) {
				return car1.getYear() - car2.getYear();
			}
		};
		Collections.sort(cars, yearComparator);

		// Option 2 : Exploit Comparator's functional interface properties
		// We start with the most verbose use of the syntax and then simplify it.
		Collections.sort(cars, (Car o1, Car o2) -> {
			return o1.getYear() - o2.getYear();
		});
		Collections.sort(cars, (o1, o2) -> {
			return o1.getYear() - o2.getYear();
		});
		Collections.sort(cars, (o1, o2) -> o1.getYear() - o2.getYear());

		// Option 2.1 : Still using functional interfaces, but also want to show method references
		Comparator<Car> yearComparator2 = ComplexCarComparator::compare;
		Collections.sort(cars, yearComparator2);

		// NB The next line is not valid. Could be due to the fact that method references return a functional interface,
		// and hence we are trying to nest one functional interface inside another functional interface.
		// Collections.sort(cars, (o1, o2) -> ComplexCarComparator::compare);

	}

	private static class ComplexCarComparator {
		public static int compare(Car car1, Car car2) {
			return car1.getYear() - car2.getYear();
		}
	}
}
