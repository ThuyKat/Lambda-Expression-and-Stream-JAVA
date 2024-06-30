package Lambda;


import java.util.Arrays;
import java.util.List;

public class MethodReferenceDemo {
	public static void main(String[] args) {
		List<String> strings = Arrays.asList("apple","banana","cherry");
		
		strings.forEach(System.out::println);
	}

	
}
