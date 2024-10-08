package Lambda;



public class GFG2 {

	static void fun(TestInterface2 t) {
		t.print();
		
	}
	static void printMessage() {
		System.out.println("Hello");
	}
	public static void main(String[] args) {
		// fun method takes functional interface as an argument, therefore we can use lambda expression: 
		
		fun(() -> System.out.println("Hello"));
		
		// method reference
		fun(GFG2::printMessage);
	}	
	
}
