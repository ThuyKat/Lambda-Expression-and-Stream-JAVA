package Lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class PredicateDemo {
	
	//SPECIFIC IMPLEMNTATION OF TEST ABSTRACT METHOD OF PREDICATE CLASS
	static class MyPredicateEven implements Predicate<Integer>{
		public boolean test(Integer x) {
			return (x % 2 == 0);
		}
	}
		
public static void main(String[] args) {
	List<Integer> al = new ArrayList<>(Arrays.asList(10,5,20,7,30));
	MyPredicateEven p = new MyPredicateEven();
	
	for(Integer x : al) {
		if (p.test(x)) {
			System.out.println(x+" ");
		}
	}
	
	//OTHER OPTION: turn MYyPredicateEven into an ANONYMOUS CLASS
	
	Predicate<Integer> p1 = new Predicate<Integer>() {
		public boolean test(Integer x) {
			return (x % 2 == 0);
		}
	};
	
	// OTHER OPTION: lambda expression
	// lambda expression must be used in the location that expect Functional Interface type. This case is value assigned to functional interface instance
	// Other case can be passing an argument of a Functional Interface type
	// In this example, we can define a method that takes an instance of Predicate and an instance of Collection as its argument and return even elements of that collection
	Predicate<Integer> p2 = x -> x%2 == 0;
	
	for(Integer x:al) {
		if(p2.test(x)) {
			System.out.println(x+" ");
		}
	}
}
}
