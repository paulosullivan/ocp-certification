package pos.ocp.generics;

import java.util.ArrayList;
import java.util.List;

public class Bounds {

	static class Bird {
	}

	static class Sparrow extends Bird {
	}

	void printList(List<? extends Bird> birds) {
		for (Bird bird : birds) {
			System.out.println(bird);
		}
	}

	public static void main(String[] args) {
		List<Sparrow> birds = new ArrayList<>();
		birds.add(new Sparrow());

		List<Integer> ints = new ArrayList<Integer>();
		ints.add(new Integer(1));
	}

}
