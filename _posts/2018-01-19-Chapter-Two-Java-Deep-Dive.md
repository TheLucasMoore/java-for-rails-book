# JFR: Chapter Two
---
layout: post
title:  "Chapter One - Comparing and Contrasting"
date:   2018-02-14 21:40:08 -0700
---

# Chapter Two: A Deep Dive into Java
So now that we've established how similar Java and Ruby are, lets talk about some of the specifics of the Java language and programming environment.

## Java, the JVM, and Jars

This book covers Java 8, but this is technically Java 1.8. It's kind of a long story.

...

OK, there's your fun fact for talking shop with a Java nerds. Just like you'd crack a joke about DHH and Basecamp, right?

Java code compiles and runs on the Java Virtual Machine or JVM. The compiled and executable package of Java code is called a JAR. One of the appeals of writing Java is actually a tagline of Sun Microsystems - "Write Once. Run Anywhere."

Whether you're on Mac, Linux or Windows, your compiled jar will run the same on the JVM.

# Java Syntax: The Basics
## Printing Output
Let's start from the beginning. How should we print out some text from our Java program?

```java
// JAVA //
// to print new lines
System.out.println("Check it out!");
System.out.println("Another new line");

// to print with no new line
System.out.print("Just printing something inline.");

// and printing formatted output
System.out.printf("pi = %.5f", Math.PI); // => pi = 3.14159
```

## Data Types and Variables Declaration
At a high level, we can declare a variable with the *type* followed by a *variable name*. We can intialize a variable and its value all at one. We can also set its value with an equals `=` after declaring it.

```java
// JAVA //
// do it all at once
String foo = "le foo";

// or break it up
String foo;
foo = "le foo!";

// declare many variables of one type
int first, second, third;

// then assign their value later
first = 1;
second = 2;
third = 4
// just making sure you're reading carefully ;-)
```

To create a variable which cannot be assigned to a new value, we can make a `final` variable.  This acts much like a frozen constant in Ruby.

```ruby
## Ruby ##
STATE = "Colorado".freeze
```

```java
// Java //
final String STATE = "Colorado";
```

Since types are so important in declaring variables, lets cover the types in Java. For the rest of this chapter, all code snippets are Java code, unless specifically stated.

## Text Types

### Char
A char is a 16-bit Unicode character.

```java
char ohYeah = 'o';
```

### String
Strings are almost exactly the same as in Ruby.

```java
String cupcakes = "I would like a cupcake right now.";

// new lines are created with an escaped \n
String recipe = "Cupcake Recipe:\n";

// tabs are created with a \t
String indented = "\tStep One: Add crisco in the bowl.";
```

String can also be *concatenated* or joined together with the `+` operator.  

```java
String concat = "Strings are " + "easy!";
System.out.println(concat);
// => "Strings are easy!"
```

## Number Types
Numbers in Java are designed around the maximum size of memory that can be allocated to store that number. As a Rubyist it may seem daunting to have so much choice, but you’ll get the hang of it.

In most cases, `int` and `double` will work for what are `integer` and `float` in Ruby. The rational around all these number data types in Java is to optimize your program to use the least amount of memory where possible.

All number types in Java are *signed*, meaning they can be positive and negative.

### Byte
A byte is an 8-bit signed number. The range a byte can be is between -128 and 127. That's it.

```java
byte fourteeen = 14;
```

### Short
A short is a signed 16-bit number between -32,768 and 32,767.

```java
short tenK = 10,000;
```

### Int
An integer is an 32-bit signed integer between -2,147,483,648 and 2,147,483,647.

```java
int oneHundoThousand = 100,000;
```

### Long
A long is a signed 64-bit integer between -9,223,372,036,854,775,808 and 9,223,372,036,854,775,807. This is similar to Ruby’s `BigInt`. This is a good data type to use on the `id` column of your tables from the start. You can avoid an [Int-pocalypes](http://www.mccartie.com/2016/12/05/rails-5.1.html).

```java
long aJillionish = 5,123,125,865,235,122,000
```

### Float
A float is a 32-bit floating point number. We use `f`to denote a floating point number. Without it, numbers with decimals are treated as doubles.

```java
float fooFloat = 1.5f;
```

### Double
A double is a 64-bit double-precision floating point number. It’s more precise, so you should prefer Double when possible.

```java
double soPrecise = 1.2345678543256785432567
```

## Arrays
Array declaration in Java is much more strict than in Ruby. Let’s look at a ruby example first. We’ll create an array, then push in various types and access.

```ruby
## Ruby ##
2.2.3 :001 > a = []
 => []
2.2.3 :002 > a.push("string")
 => ["string"]
2.2.3 :003 > a.push(1)
 => ["string", 1]
2.2.3 :004 > a.push(true)
 => ["string", 1, true]
2.2.3 :005 > a[0]
 => "string"
2.2.3 :006 > a[1]
 => 1
2.2.3 :007 > a[2]
 => true
```

## Java Arrays
In Java, we need to declare the type of the data in the array. The above Ruby example with a mixing of types inside an array is not possible, or at least considered an anti-pattern in Java.  Java Arrays can store primitive data types (integers, floats, strings) as well as Java Objects (instances of Java classes).

With Java arrays, we need to declare the size of the array. The pattern to declare an array is either:

1. `type[] name = new type[size]`  
2. `type varName[] = new type[size]`

```java
// java
int[] myFavNumbers = new int[100];

// to add a number at a certain index
myFavNumbers[0] = 13;
```

We can also declare an array and its contents all at one.

```java
String tacoFlavors[] = {"Good", "Better", "Best"};
boolean answers[] = {false, false, true};
```

Arrays in Java are *zero-indexed*, meaning that the first element of the array is accessibile at `[0]` instead of `[1]` . I’m sure you knew that, as it’s the same in Ruby.

## Java ArrayLists
An ArrayList is like an array, but it allows dynamic sizing of the array and has a different interface to interact with the array.

```java
// this array is dynamically sized
ArrayList<String> myFriends = new ArrayList<>();

// we can add elements to the ArrayList
myFriends.add("Rumi");
myFriends.add("Calvin");
myFriends.add("Hobbes");

// we can access certain parts of the array
System.out.println(myFriends.get(0));
// this will output "Rumi"
```

ArrayLists can hold only Java Objects, not primitive data. If we `.add()`an integer into an ArrayList, it actually converts it into an instance of the Integer class under the hood.

# Other Data Types
## LinkedList
Java comes with a default linked list type and behavior. This is something Ruby is lacking.

## Map
A map is much like a hash in Ruby, a set of keys that mapped to a value. When creating a new map, again we must think of the types. There is no way to have duplicate keys.

## HashMap
A map, but more performant?

## TreeMap
A map, but the keys are sorted. It’s slower at first, but if you need to take advantage of the sorting, this is a good fit.

# Operators
## Basic Math
add, subtract, divide, multiply, exponents
increment

## Modulo
## Comparisons

# Flow Control and Loops
if / else

For Loop

while loops

# Conversion of Types
# Methods
## Initializers
In Ruby, we define how a class should initialize with the `def initialize` method. There, we set the traits that should exist on the object.

In Java, the initialization configuration exists within a function of the same name as the class. Public Static Void too?

## Classes and Subclasses
### Abstract Classes
### Final Classes
### Interfaces
Interfaces are a concept that does not exist directly in Ruby, but it's something that is *technically* possible to do in Ruby, as we'll see. An interface is a class declaration which outlines the methods needed by any other class. It cannot be used directly, but rather other classes will *implement* the interface. Code will raise an error if the class that implements the interface lacks any of the required functions.

Lets first look at what this would possibly be in Ruby and then it will be clear how much more clear this gets in Java.

```ruby
# ruby
class Sandwich # this will act like an interface class

  # by default we'll raise an error on each of these methods
  def bread
    raise NotImplementedError
  end

  # silly, I know, but you will write much more complex code
  def filling
    raise NotImplementedError
  end

  def eat
    raise NotImplementedError
  end
end

# now each type of sandwich will "implement" the Sandwich "interface"
class PBJ < Sandwich
	# this method is being over-loaded
  def bread
    "white bread"
  end

  def filling
    "peanut butter, jelly"
  end
end
```

If we were to define defined a new instance of a Peanut Butter and Jelly sandwich now, it would go something like this:

```ruby
# ruby
> sammy = PBJ.new
 => #<PBJ:0x007f8bc4af5760>
> sammy.bread
 => "white bread"
> sammy.filling
 => "peanut butter, jelly"
> sammy.eat
NotImplementedError: NotImplementedError
```

Uh oh, an error! We can't treat this PBJ like a sandwich because it does not implement all of the methods required by the `Sandwich` class. Now this is a slightly convoluted example to demonstrate how this works in Java. The error is there because we put it there ourselves. When we create a new type of `Sandwich` class by inheriting from it, we'll override each method with the specifics of what composes that sandwich.

I wouldn't recommend using this in your production applications. In fact, if you are doing things like this, perhaps consider switching to Java. There are obvious downsides in the readability and writability of this code. We're defining methods and then overriding them, which would make a bug in our code harder to trace.

```java
public class Sandwich interface {
  public String bread();
  public String filling();
  public String eat();
}

public class PBJ implements Sandwich {

  @Override
  public String bread() {
    return "white bread";
  }

  @Override
  public String filling() {
    return "peanut butter, jelly";
  }
}
```

Now, when we compile this code, we'll see the following error.

```
PBJ implements the Sandwich interface, but no method EAT is defined
```



## Threads
Java has much better support for multithreaded operations. Thread safe (meaning code that can run well in parallel) concurrent code is a huge performance advantage of Java over Ruby.

# Conclusion
By now, I hope you can see how important types are in Java. By this point, I hope you’re thinking in Java and considering the types of things before writing them.

# Sources
[Array vs. ArrayList](https://www.geeksforgeeks.org/array-vs-arraylist-in-java/)
