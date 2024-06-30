package Lambda;

import java.util.Arrays;

public class LambdaDemo {

	public static void main(String[] args) {
		Point arr[] = {new Point(10,20), new Point(5,30), new Point(30,40)};
		
		// ARRAY.SORT() takes Comparator as one of its argument.Comparator is a functional interface
		Arrays.sort(arr,(p1,p2) -> p1.x - p2.x);
		for (int i =0; i<arr.length; i++) {
			System.out.println(arr[i].x + " " + arr[i].y);
		}
	}
}
