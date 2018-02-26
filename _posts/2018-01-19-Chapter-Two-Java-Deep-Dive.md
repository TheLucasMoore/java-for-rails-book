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

Syntax (expanded)

## Data Types

String
Int
Boolean

Float
Double

## Variables

## Operators

## Methods

## Loops

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

# now each type of sandwich will implement the Sandwich interface
class PBJ < Sandwich
  def bread
    # more complex code surely...
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
class Sandwich interface {
  public String bread();
  public String filling();
  public String eat();
}

class PBJ implements Sandwich {

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
