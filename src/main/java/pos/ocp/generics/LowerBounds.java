package pos.ocp.generics;

import java.util.ArrayList;
import java.util.List;

public class LowerBounds {

	/*
	 * Write a method that can accept List<Object> and List<String>, and a string to each list.
	 */
	public static void main(String[] args) {
		List<Object> objects = new ArrayList<>();
		List<String> strings = new ArrayList<>();

		addStringToObjectList(objects, "Test");
		// The next line won't compile. List<Object> is not the same type as List<String>.
		// addStringToObjectList(strings, "Test");

		System.out.println(objects);
		System.out.println(strings);

		// The next line won't compile. List<Object> is not the same type as List<String>.
		// addStringToStringList(objects, "Test");
		addStringToStringList(strings, "Test");

		System.out.println(objects);
		System.out.println(strings);

		addStringToLowerBoundedWildCardList(objects, "Test");
		addStringToLowerBoundedWildCardList(strings, "Test");

		System.out.println(objects);
		System.out.println(strings);

		// Summary
		// Fails
		// List<String> failedObjectList = new ArrayList<Object>();
		// List<Integer> failedObjectList2 = new ArrayList<Number>();
		// Succeeds
		List<? super String> objectList = new ArrayList<Object>();
		List<? super Integer> objectList2 = new ArrayList<Number>();
	}

	public static void addStringToObjectList(List<Object> list, String appendString) {
		list.add(appendString);
	}

	public static void addStringToStringList(List<String> list, String appendString) {
		list.add(appendString);
	}

	public static void addStringToWildCardList(List<?> list, String appendString) {
		// The next line won't compile. Unbounded wild card lists are logically immutable.
		// In other words. Java doesn't know if we are dealing with a list of Objects, Strings, etc.
		// list.add(appendString);
	}

	public static void addStringToUpperBoundedWildCardList(List<? extends Object> list, String appendString) {
		// The next line won't compile. Unbounded wild card lists are logically immutable.
		// In other words. Java doesn't know if we are dealing with a list of Objects, Strings, etc.
		// list.add(appendString);
	}

	public static void addStringToLowerBoundedWildCardList(List<? super String> list, String appendString) {
		// Lower bounds are not immutable.
		// Java knows to expect either a list of Strings or a list of objects that are a superclass of String.
		list.add(appendString);
	}

}
