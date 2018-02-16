---
layout: post
title:  "Chapter One - Comparing and Contrasting"
date:   2018-01-24 21:40:08 -0700
---

## Chapter One: Comparing and Contrasting

This book rests on the notion that the prior knowledge you possess as a Rubyist can be leveraged to accelerate your mastery of Java. For example, you are probably quite familiar with Objected Oriented Design in a Ruby context. When switching to Java, the basic design principles are the same, but the grammar and syntax are different. For the rest of this book we will use analogies that compare Ruby and Rails concepts to their Java counterparts. Let's begin!

## Language attributes: Ruby and Java

Ruby and Java are designed around objects. In both languages, an object is called a `class`. Within a class we have actions, which are called `methods`. In Ruby we know the inputs given to a method as `arguments`. In Java we call method inputs `parameters`.

## Initializing a Class

To see how similar classes and methods are in Ruby and Java are, let's run through an example `Calculator` object which will take two numbers as inputs. Our `Calculator` will start with one method, `multiply`, which will execute the simple calculation of multiplying our two numerical inputs.

# Ruby
```ruby
### Ruby ###
# let's declare a class
class Calculator

  # the initialize method lets us call Calculator.new() with two arguments,
  # which will instantiate a new instance of the Calculator class
  def initialize(number_one, number_two)
    # our instance has the following instance variables
    @number_one = number_one
    @number_two = number_two
  end

  # this method can be called on each instance
  def multiply
    @number_one * @number_two
    # a return statement is not required since
    # this implicitly returns the product of our two numbers
  end
end
```

When running this code, we can interact with it as follows:

```ruby
### Ruby ###
> calculator_1 = Calculator.new(2, 3)
 => #<Calculator:0x007fce50a6ee08 @number_one=2, @number_two=3>
> calculator_1.multiply
 => 6
```

In the next code example, when we initialize a new object, notice how it has a different class identifier of `Calculator:0x007fce50a4f530` as opposed to `Calculator:0x007fce50a6ee08`. This is a new instance of the same `Calculator` class.

```ruby
### Ruby ###
> calculator_2 = Calculator.new(10, 10)
 => #<Multiply:0x007fce50a4f530 @number_one=10, @number_two=10>
> calculator_2.multiply
 => 100
 ```

If we try to initialize this object with the wrong number of arguments, the class will *raise an error* in the `<main>` part of our program called an `ArgumentError`.

```ruby
### Ruby ###
> Multiply.new
ArgumentError: wrong number of arguments (0 for 2)
	from (irb):5:in 'initialize'
	from (irb):16:in 'new'
	from (irb):16
	from /Users/ruby-2.2.3/bin/irb:15:in '<main>'
```

In Ruby, we just built a new object by defining a class and then initializing it. We passed arguments into the initializer method `new`, which set them as instance variables (sometimes called ivars). Then we called the method `multiply` that executed some calculation on that instance.

Let's do the same thing in Java!

# Java

Java is more verbose, but don't worry much about the extra elements you see here. Those will be covered in depth in Chapter Two.

```java
//// Java ////
// let's declare a class again, which is public
public class Calculator {

  // our member variables of type int
  public int numberOne;
  public int numberTwo;

  // here is our constructor, which returns nothing ("void") but
  // will set our member variables with the parameters we pass in
  public void multiply(int numberOne, int numberTwo) {
    this.numberOne = numberOne;
    this.numberTwo = numberTwo;
  }

  // lastly, the method to execute the calculation will return an integer (int)
  public int calculate() {
    return this.numberOne * this.numberTwo;
    // Unlike in Ruby, which has an implicit return, in Juava we MUST
    // explicitly have a return statement
  }
}

```

Now, lets make two instances of the `Calculator` class we defined above, just like we did in our previous Ruby example. Notice how the variable declarations all have the `Type`, which is `Calculator` in this example (more on Typing in the next section).

```java
//// Java ////
Calculator firstCalculator = new Calculator(2, 3);
Calculator secondCalculator = new Calculator(10, 10);
```

Then to execute the function `multiply`, we could call it with `()` at the end, which executes the function.

```java
//// Java ////
firstCalculator.multiply(); // returns 6
secondCalculator.multiply(); // returns 100
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

```bash
$ java HelloWorld
Hello World! Java is easy!
```

Notice that `javac` will compile code and `java` will execute compiled code. This differs from Ruby, where we can run code in an interactive console quite simply.

# WHAT IS LEFT TO WRITE
* [ ] Rails and Spring (too early for that I think?)
* [ ] Inheritance?

### Chapter One Sources
* [Wikibooks on Compiling](https://en.wikibooks.org/wiki/Java_Programming/Compilation)
* [Oracle](http://www.oracle.com/technetwork/java/javase/downloads/index.html)
