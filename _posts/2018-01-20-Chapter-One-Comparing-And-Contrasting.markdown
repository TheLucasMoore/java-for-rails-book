---
layout: post
title:  "Chapter One - Comparing and Contrasting"
date:   2018-01-24 21:40:08 -0700
---

## Chapter One: Comparing and Contrasting

In learning a new language, whether coding or speaking, the first and most important concepts to get a grasp on are the grammar and syntax. A high level understanding of attributes of the language will build deeper understanding in your mind. As a Rubyist, you should already be quite familiar with Object Oriented Design, so many of the concepts in Java will be easy to pick up here.

## Language attributes

Both Ruby and Java are designed around objects, where each object is called a `class`. Within those classes or objects, we have actions, which are called methods in both Ruby and Java. Those methods have inputs, called arguments in Ruby and *parameters* in Java. So far, most of the vocabulary we use to talk about Ruby will apply to Java.

## Initializing a Class

To see how similar Ruby and Java are, let's run through an example `Multiply` object which will take two inputs of numbers. It also has an method of `do_the_math`, which will execute the simple math of multiplying our two numbers.

# Ruby
```ruby
### Ruby ###
# let's declare a class
class Multiply

  # the initialize methods lets us call Multiply.new() with two arguments,
  # which will instantiate a new instance of the Multiply class
  def initialize(number_one, number_two)
    # our instance has the following instance variables
    @number_one = number_one
    @number_two = number_two
  end

  # this method can be called on each instance
  def do_the_math
    @number_one * @number_two
    # this implicitly returns the product of our two numbers
  end
end
```

When running this code, we would interact with it as follows:

```ruby
### Ruby ###
> first_multiplier = Multiply.new(2, 3)
 => #<Multiply:0x007fce50a6ee08 @number_one=2, @number_two=3>
> first_multiplier.do_the_math
 => 6
```

When we initialize a new object, notice how it has a different class identifier of `Multiply:0x007fce50a4f530`. This is a new instance of the same `Multiply` class.

```ruby
### Ruby ###
> second_multiplier = Multiply.new(10, 10)
 => #<Multiply:0x007fce50a4f530 @number_one=10, @number_two=10>
> second_multiplier.do_the_math
 => 100
 ```

If we try to initialize this object with the wrong number of arguments, the class will *raise an error* in the `<main>` part of our program, specifically an `ArgumentError`.

```ruby
### Ruby ###
> Multiply.new
ArgumentError: wrong number of arguments (0 for 2)
	from (irb):5:in `initialize'
	from (irb):16:in `new'
	from (irb):16
	from /Users/ruby-2.2.3/bin/irb:15:in `<main>'
```

In Ruby, we just built a new object by defining and initializing a class. We passed arguments into the initializer, which set them as class variables. Then we called a method that executed some math on that instance or object. Let's do the same thing in Java now.

# Java

Java is more verbose, so don't worry much about the extra elements you see here. Those will be covered in depth in Chapter Two.

```java
//// Java ////
// let's declare a class again, which is public
public class Multiply {

  // our member variables of type int
  public int numberOne;
  public int numberTwo;

  // here is our constructor, which returns nothing ("void") but
  // will set our member variables with the parameters we pass in
  public void multiply(int numberOne, int numberTwo) {
    this.numberOne = numberOne;
    this.numberTwo = numberTwo;
  }

  // lastly, the method to execute the math will return an integer (int)
  public int doTheMath() {
    return this.numberOne * this.numberTwo;
    // we MUST have a return statement
  }
}

```

We would then instantiate or create two similar instances to those we made in Ruby above. Notice how the variable declarations all have the Type, which is `Multiply` in this example (more on Typing in the next section).

```java
//// Java ////
Multiply firstMultiplier = new Multiply(2, 3);
Multiply secondMultiplier = new Multiply(10, 10);
```

Then to execute the math function `doTheMath`, we could call it with the `()` at the end, which executes the function.

```java
//// Java ////
firstMultiplier.doTheMath(); // returns 6
secondMultiplier.dotheMath(); // returns 100
```

## Comparing Ruby & Java Classes

This Java example is mostly identical to Ruby, except a few vocabulary terms and conventions. First, you'll notice Java conventions prefer `camelCase` instead of `snake_case` for the naming of variables and methods. Every line of Java code must end with a semicolon `;`.

Variables on an instance are called *member variables* or *fields* instead of "instance variables" like in Ruby.

The data we pass into a method are called "arguments" in Ruby, but *parameters* in Java.

In Ruby, we built a new object by defining and initializing a class. We passed arguments into the initializer, which set them as class variables. Then we called a method that executed some math on that instance or object.

In Java, we built a new object by defining and initializing a class. We passed parameters into the constructor, which set them as member variables. Then we called a method that executed some math on that instance or object!

## Typing

Ruby is a *dynamically typed* language and Java is a *statically typed* language. Here the `typing` of course refers to data types, not the act of typing. Both languages share many of the same data types like `Boolean`, `Float` and `String`.

These differences are revealed in the grammar of the languages. It's also worth noting that dynamic and static typing is about whether the types are checked at run time or compile time.

Terms like *weakly typed* and *strongly typed* refer to whether a language will implicitly try to infer the types and do silly things like adding strings to numbers (like [in JavaScript](https://www.destroyallsoftware.com/talks/wat)). I've heard the phrases used interchangeably, but it's worth knowing the difference, especially if it comes up in a technical interview.

Here's some examples so this idea should be more clear.

### Ruby Typing
Ruby is *dynamically typed* because the data types are established at run time and NOT during compilation because Ruby is not compiled.

```ruby
#### Ruby ####
# if we declare a variable, Ruby infers the type at run time
> my_integer = 5
 => 5
> my_integer.class
 => Fixnum

> my_float = 7.0
 => 7.0
> my_float.class
 => Float

# We can also change the type of the variable easily
# from Fixnum to String
> my_integer.to_s
 => "5"
 # from Float to String
> my_float.to_s
 => "7.0"
 # from Float to Fixnum (and many more examples)
> my_float.to_i
 => 7

 # we cannot mix complex types like Strings and Fixnums
> variable = "3" + 4
 => TypeError: no implicit conversion of Fixnum into String

# but we CAN reassign a variable to have a new type with no problems
# again, this is because types are established at run time
> my_float = 9.0
> my_float.class
 => Float
> my_float = 9
> my_float.class
 => Fixnum
```

While dynamic typing may seem easier at first, with the growing complexity of Ruby programs your team might start hitting type errors at run time.

Trying to pass a `Boolean` into a method as an argument when it is expecting a `String` will cause run time errors or unexpected behavior, leading to more bugs and more difficult debugging. That's why the strong typing in Java can be an asset to you and your team.

### Java Typing
Unlike Ruby, Java is *statically typed* because the types are checked at compile time (more on compiling in the next section). The data types must be declared throughout the writing of code so that the compiler can check them. This means you'll have nice highlighting and autocomplete in most integrated development environments (IDE) and you'll notice type errors popping up while writing code instead of hitting them when it comes time to run your program.

```java
//// Java ////
// the syntax is always
// Type variableName = value;
Int myInteger = 5;
Double myDouble = 7.0;
String helloWorld = "Hello World";

// if we tried to set a new variable with the wrong type...
Int seven = 7.0; // the complier will fail here
```

We can *cast* types into other types. This conversion is considered to be a *widening conversion* or a *narrowing conversion*, depending on if information will be lost.

```java
//// Java ////
// the compiler will allow widening conversions like converting int to a double
Double bestNumber = (double) 7;
// bestNumber is 7.0

// here the float 7.0 is narrowed to 7 by casting it to an integer
Int seven = (int) 7.0;
// the compiler might warn you about this loss of data
```

### Run Time Language vs. Compile Time Language

Another difference between Ruby and Java is that Java must be compiled.
When you want to run Ruby code, you can just fire up a console session and play around with code. It just runs. With Java, there is an extra step of compiling your code.

Before diving into that, let's talk about the Java ecosystem.

Java is designed to run everywhere on the *Java Virtual Machine*, most often called the JVM. Java code is compiled into *bytecode* and saved as the `.class` files. Then Java's *"Just in Time Compiler"* (JIT) will load bytecode into memory as it is needed by the program.

To compile code on your computer, you'll need the *Java Development Kit* or JDK. You can download the JDK, which includes tools for developing, debugging and monitoring your Java applications from [Oracle's Website](http://www.oracle.com/technetwork/java/javase/downloads/index.html). We'll need this to compile and execute our code.

Most Java developers work in IDEs which do many nice things for us like compile code, run tests and check for errors during development. We'll cover the two most popular IDEs in Chapter Three. For now, let's compile the classic `HelloWorld` program you'll find in the Chapter One file set.

After installing the latest JDK, open up terminal and `cd` into the Chapter One files.

```bash
$ cd /path/to/ChapterOneFiles
```

The HelloWorld.java file looks like this:
```java
// we've talked about classes already
public class HelloWorld {

  // this is a classic Java line that basically means
  // run this at the top of the program automatically
  public static void main(String[] args) {
    System.out.println("Hello World! Java is easy!");
  }
}
```

We'll use `javac` to compile our HelloWorld.java file.

```bash
$ javac HellowWorld.java
```

After running this command, you'll notice a new file called `HelloWorld.class` in the folder with the compiled byte code inside. It's mostly not human readable, but this compiled code will run on the JVM on any operating system.

Finally, we can run our compiled Java code with the `java` command.

```
$ java HelloWorld
Hello World! Java is easy!
```  

Notice that `javac` will compile code and `java` will execute compiled code. This differs from Ruby, where we can run code in an interactive console quite simply.

### Chapter One Sources
* [Wikibooks on Compiling](https://en.wikibooks.org/wiki/Java_Programming/Compilation)
* [Oracle](http://www.oracle.com/technetwork/java/javase/downloads/index.html)
