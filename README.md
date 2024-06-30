# Lambda-Expression-and-Stream-JAVA
## FUNCTIONAL INTERFACE

* Functional interface is an interface with only 1 abstract method and >=0 default/static methods. 
* E.g., interface Predicate<T> is a functional interface with only 1 abstract method void test(). 
* With functional interface, we jsut need to provide implementation for 1 method then a class can implement the interface. Instead of creating a class and method inside the class for implementation, we can use Lambda expression to make it the code more concise

## From implementation class to Anonymous class to Lambda Expression
In this example, we will see how lambda expression makes the code more concise compared to anonymous class and traditional implementation class

* Question: Write a program that returns all even elements of a list using Predicative interface

* SOLUTION:
1. Implementation class
- First, we need a class to provide implementation for the abstract method:
```java
class MyPredicateEven implements Predicate<Integer>{
		public boolean test(Integer x) {
			return (x % 2 == 0);
		}
	}
```
- Next, in main method, we call an instance of the the class and use that instance to call test() method of Predicative in each iteration:
```java
public static void main(String[] args) {
	List<Integer> al = new ArrayList<>(Arrays.asList(10,5,20,7,30));
	MyPredicateEven p = new MyPredicateEven();
	
	for(Integer x : al) {
		if (p.test(x)) {
			System.out.println(x+" ");
		}
	}
```

2. Anonymous class
Instead of creating a separate class for implementing test() method, we can create an anonymous class inside main method: 

```java
Predicate<Integer> p1 = new Predicate<Integer>() {
		public boolean test(Integer x) {
			return (x % 2 == 0);
		}
	};
```
Remaining is similar to previous approach

3. Lambda expression
- Lambda expression must be used in places that expect Functional Interface type of argument. We cannot use Lambda expression directly inside if() condition but we have to assign the Lambda expression to a variable before we can use it to call test() method inside if();
```java
Predicate<Integer> p2 = x -> x%2 == 0;
	
	for(Integer x:al) {
		if(p2.test(x)) {
			System.out.println(x+" ");
		}
	}
```
- Places that expect a Funcitonal interface type of instance can be return, or argument of a method, or internal operation of a method

-- return a Functional Interface type of data
```java
public interface Hello {
	public void sayHello();
}
public class HelloHelper {
public static Hello helperFunction() {
	return ()-> System.out.println("Hello");
}
}
```
-- argument of functional interface type
```java
public class Point {
int x,y;
Point (int x, int y){
	this.x = x;
	this.y = y;
	
}
}
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
```
-- use functional interface in method's body

In the previous example, we assign lambda expression to a functional interface type of variable and pass it into if() condition

## Lambda Expression syntax for single line expression where return type is void
```java
// No parameter
// interface Test1{ void print()};
() -> System.out.println("Hello");
// One parameter
// interface Test2{void print(Integer x)};
x -> System.out.println(x);
// multiple parameter
// interface Test3{void print(Integer x1,Integer x2)};
(x1,x2)-> System.out.println(p1 + " " + p2);
```
## Multiple line Lambda expression
```java
p -> { if(p % 2 == 0)
        { System.out.println("Even"); } 
        else {System.out.println("Odd");}
    }
```
## Lambda expression which return a value
* Boolean
```java
p -> { if(p%2 ==0) return true; else return false;}
```
* Return type is the same as input type
```java
p -> p +2 ;
```

## Advantages of Lambda Expression

1. With Lambda expression, you dont nee to specify data type. When you use for a functional interface, thisngs like return types, parameter type are automatically inferred by Lambda Expression
2. We can assign lambda experssion to a variable of functional interface type and pass it to use in other methods/classes
3. We can also assign lambda expression with void return type to a variable of Runnable interface
```java
Runnable task = () -> System.out.println("Hello");
```
NOTE: Lambda expression is recommended to use with short functions only

## METHOD REFERENCES
- Lambda expression provide a specific implementation for the abstract method of a functional interface
- Method reference refers to an existing implemtation of a class/interface. It does not execute immediately like a lambda expression but it provides a way to refer to an existing method by its name.
- We frequently see lambda expression being replaced with a method reference in .forEach operation. For example:

```java
public class MethodReferenceDemo {
	public static void main(String[] args) {
		List<String> strings = Arrays.asList("apple","banana","cherry");
		
		strings.forEach(System.out::println);

        //OR we can use lambda expression
        strings.forEach(x -> System.out.println(x));
	}
}
```
We say that the lambda expression is shorthanded as a method reference
- This only happens when the implementation expressed by lambda expression is matching to the implemntation of the existing method in terms of return type + number of arguments and argument types (the method's signature). 
- In the code above, .forEach method takes an instance of Consumer<String> - a functional interface that acceps a single input argument of type String and return Void - as its argument. The orginal form of .forEach is:
```java
forEach(Consumer<?superT>action)
```
Consumer functional interface has an abstract method called accept(). Accept() method defines the target that action is applied to, for example, accept (String s) means the action will be performed on a string that accepts takes in. Accept() method return's type is Void. 

Since method reference matching argument type of forEach() method in both parameters and return, we can use it in place of a lambda expression.

## Syntax of method references
1. Instance method reference of a particular object
```java
strings.forEach(System.out::println);
```
Above expression is an example of an instance method reference. In java, the original System class is: 
```java
...
public final class System{
    publi static final PrintStream out;
    static{
        //Initialize the standard output stream
        out = new PrintStream(new FileOutputStream(FileDescriptor.out));
    }
    // Other fields and methods
}
```
Hence, System.out is actually an instance of PrintStream class. The println() in PrintStream class is an instance method ( not a static method). It takes a String as its argument and return Void

2. Static method reference
When you have a static method, you can pass a method reference using the class name

For example: 
```java
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
```
## Why can't we use PrintStream :: println but we have to use System.out::println

Syntax of method reference has another special type. It is an instance method reference, but it has ClassName::methodName structure as how static method reference does. An example of this type is  String::toUpperCase. 

**So when we can use ClassName in an instance method reference?**

Unlike String::toUpperCase, every instance of PrintStream is created by taking an instance of OutputStream as its argument. Without the instance of OutputStream class, instance of PrintStream cannot be created. In plain language, we need to know where/location we are going to print to. Using System.out, we tell JVM that the location to print to is the console screen. If we use just PrintStream::println, we will not know where to print the output of print(), hence must specify a specific location by call an instance of OutputStream. This is different to String class, because an instance of String does not need any other argument but the string itself. 


