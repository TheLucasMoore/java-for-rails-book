---
layout: post
title:  "Chapter One - Comparing and Contrasting"
date:   2018-01-24 21:40:08 -0700
---

## Chapter One: Comparing and Contrasting

This book rests on the notion that the prior knowledge you possess as a Rubyist can be leveraged to accelerate your mastery of Java. In learning a new language, whether coding or speaking, the first and most important concepts to get a grasp on are the grammar and syntax. A high level understanding of attributes of the language will build deeper understanding in your mind. As a Rubyist, you should already be quite familiar with Object Oriented Design, so many of the concepts in Java will be easy to pick up here. For the rest of this book we will use analogies that compare Ruby and Rails concepts to their Java counterparts. Let's begin!

## Language attributes: Ruby and Java

Both Ruby and Java are designed around objects. In both languages, each object is called a `class`. Within a class we have actions, which are called methods in both Ruby and Java. In Ruby we know the inputs given to a method as `arguments`. In Java we call method inputs `parameters`, but in general the terms are interchangeable.

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
    # the return value is not required in Ruby.
    # This implicitly returns the product of our two numbers.
  end
end
```

When running this code, we can interact with it as follows:

```ruby
### Ruby ###
> calculator1 = Calculator.new(2, 3)
 => #<Calculator:0x007fce50a6ee08 @number_one=2, @number_two=3>
> calculator1.multiply
 => 6
```

In the next code example, when we initialize a new object, notice how it has a different class identifier of `Calculator:0x007fce50a4f530`. This is a new *instance* of the same `Calculator` class.

```ruby
### Ruby ###
> calculator2 = Calculator.new(10, 10)
 => #<Multiply:0x007fce50a4f530 @number_one=10, @number_two=10>
> calculator2.multiply
 => 100
```

If we try to initialize this object with the wrong number of arguments, the class will *raise an error* in the `<main>` part of our program. This error is specifically an `ArgumentError`.

```ruby
### Ruby ###
> Calculator.new
ArgumentError: wrong number of arguments (0 for 2)
	from (irb):5:in 'initialize'
	from (irb):16:in 'new'
	from (irb):16
	from /Users/ruby-2.2.3/bin/irb:15:in '<main>'
```

In Ruby, we just built a new object by defining and initializing a class. We passed arguments into the initializer, which set them as class variables. Then we called a method that executed some math on that instance or object. Let's do the same thing in Java now.

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
  public static void(int numberOne, int numberTwo) {
    this.numberOne = numberOne;
    this.numberTwo = numberTwo;
  }

  // lastly, the method to execute the math will return an integer (int)
  public int multiply() {
    return this.numberOne * this.numberTwo;
    // Unlike in Ruby, which has an implicit return, in Java we MUST have a return statement
  }
}

```

Now, lets make two instances of the `Calculator` class we defined above, just like we did in our previous Ruby example. Notice how the variable declarations all have the `Type`, which is `Calculator` in this example (more on Typing in the next section).

```java
//// Java ////
Calculator firstCalculator = new Calculator(2, 3);
Calculator secondCalculator = new Calculator(10, 10);
```

Then to execute the math function `multiply`, we could call it with the `()` at the end, which executes the function.

```java
//// Java ////
firstCalculator.multiply(); // returns 6
firstCalculator.multiply(); // returns 100
```

## Comparing Ruby & Java Classes

This Java example should feel very familiar to what we are used to in Ruby, with a few notable differences. First, in Java we prefer name variables and methods in `camelCase` rather than  `snake_case`. Also, every line of Java code must end with a semicolon `;`.

What we know as `instance variables` or `ivars` in Ruby, are are called *member variables* or *fields* in Java.

Method inputs, called "arguments" in Ruby, are known as *parameters* in Java.

In Ruby, we built a new object by defining and initializing a class. We passed arguments into the initializer, which set them as instance variables. Then we called a method that executed some math on that instance or object.

In Java, we built a new object by defining and initializing a class. We passed parameters into the constructor, which set them as member variables. Then we called a method that executed some math on that instance or object!

## Typing
Ruby is a *dynamically typed* language, which means that it will implicitly infer the data types described in code. On the other hand, Java is a *statically typed* language. Java will not guess that your variable is an integer. In fact, you must tell Java the variable type upon declaring it. Both languages share many of the same data types like `Boolean`, `Float` and `String`, so just because Java's approach is more prescriptive does not mean your knowledge of data types in Ruby goes to waste. We'll go in depth with types in Chapter Two.

These differences are revealed in the grammar of the languages. It's also worth noting that dynamic and static typing is about whether the types are checked at run time or compile time.

Terms like *weakly typed* and *strongly typed* refer to whether a language will implicitly try to infer data types and how the language will handle doing silly things like adding strings to numbers (see this famous [JavaScript Wat Talk](https://www.destroyallsoftware.com/talks/wat)). I've heard the phrases used interchangeably in casual work settings, but it's worth knowing the difference, especially if it comes up in a technical interview.

### Ruby Typing
Ruby is *dynamically typed* because the data types are established at run time and NOT during compilation because Ruby is not compiled. Java is compile and Java is not.

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

While dynamic typing may seem easier at first, with the growing complexity of Ruby programs your team might start hitting type errors at run time, especially if the codebase is not well tested. I've found that the dynamic typing in Ruby means that our team must rely on tests more to ensure bug-free code and also serve as documentation of how the code runs.

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

Another difference between Ruby and Java is that Java must be compiled. When you want to run Ruby code, you can just fire up a console session and play around with code. Type `ruby my_great_ruby_file.rb` and it just runs. With Java, there is an extra step of compiling your code.

To understand this, let's talk about the Java ecosystem.

#### The JVM

Java is designed to run everywhere on the *Java Virtual Machine*, most often called the JVM. Java code is compiled into *bytecode* and saved as `.class` files. Then Java's *"Just in Time Compiler"* (JIT) will load bytecode into memory as it is needed by the program.

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

# Ruby on Rails & Java Spring
One final thing to note is the most popular frameworks in the Ruby and Java worlds. Ruby on Rails is the most popular framework for Ruby in the United States.

Spring is the most popular framework for Java. At this point we won't be explaining all the ins and outs of Spring.

This is intentional.

It's crucial to have a strong understanding of Ruby before jumping into Rails, which accomplishes lots of convenient features through abstraction. To jump right into Rails would mean loosing the hands-on experience of Ruby. We'll touch on Spring after getting a stronger hold on Java as a language. This is the topic we'll address in Chapter Two.

### Chapter One Sources
* [Wikibooks on Compiling](https://en.wikibooks.org/wiki/Java_Programming/Compilation)
* [Oracle](http://www.oracle.com/technetwork/java/javase/downloads/index.html)
