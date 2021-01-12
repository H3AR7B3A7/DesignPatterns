# Java Design patterns
Design patterns...
- Are reusable in multiple projects.
- Provide the solutions that help to define the system architecture.
- Capture the software engineering experiences.
- Provide transparency to the design of an application.
- Are well-proved and testified solutions since they have been built upon the knowledge and experience of expert software developers.
- Don't guarantee an absolute solution to a problem. They provide clarity to the system architecture and the possibility of building a better system.

Design patterns can be divided in:
- Creational Design Patterns
- Structural Design Patterns
- Behavioral Design Patterns

# Creational Design Patterns

## Singleton Pattern
The singleton pattern is a software design pattern that restricts the instantiation of a class to one "single" instance. 
This is useful when we need exactly one object to coordinate actions across the system. The term comes from the mathematical concept of a singleton.
Critics consider the singleton to be an anti-pattern in that it is frequently used in scenarios where it is not beneficial, creating unnecessary 
restrictions in situations where we do not require a sole instance of a class, which constitutes a global state in the application.

### Different approaches: Pros and Cons

#### Eager Initialization
Pro:
 - Lower latency when using the singleton.
 - There is no need to synchronize the getInstance() method, meaning all threads will see the same instance, which requires no (expensive) locking.
 - The final keyword means that the instance cannot be redefined, ensuring that one (and only one) instance ever exists.

Con:
 - The JVM creates an instance even though the client application might not be using it. The application will take longer to boot.
 - Also, this method doesn't provide any options for exception handling.
 
#### Static Block Initialization
Pro:
 - Lower latency when using the singleton.
 - The final keyword means that the instance cannot be redefined, ensuring that one (and only one) instance ever exists.

Con:
 - The JVM creates an instance even though the client application might not be using it. The application will take longer to boot.
 - If multiple threads are inside the if loop at the same time, both threads will get a different instance of the singleton class.

#### Lazy Initialization
Pro:
 - Shorter boot time of application.

Con:
 - Higher latency when using the singleton.
 - If multiple threads are inside the if loop at the same time, both threads will get a different instance of the singleton class.

#### Thread Safe Lazy Initialization
Pro:
 - It is thread safe.
 - Shorter boot time of application.

Con:
 - It reduces the performance because of cost associated with the synchronized method, although we need it only for the first few threads who might create the separate instances.
 - Unfortunately, synchronized methods run much slower — as much as 100 times slower — than ordinary asynchronous methods.

#### Double-Checked Locking
Pro:
 - It prevents the cost of calling a synchronized method everytime we need the singleton object.

Con:
 - It is synchronized for concurrent use and can still be slow.
 - Recognizing and reproducing failures can be difficult because of intermittent occurrence.
 
#### Bill Pugh's
Pro:
 - When the JVM loads the singleton class, it doesn't load the SingletonHelper class into memory. Only when someone calls the getInstance method, this class gets loaded and creates the Singleton class instance.
 - This is the most widely used approach for Singleton class as it doesn't require synchronization.
 - This solution is thread-safe without requiring special language constructs.

#### ENUM
Pro:
 - It is the only singleton that can handle reflection.
 - Very easy to read.

## Prototype Pattern
We use the prototype pattern when the type of objects to create is determined by a prototypical instance, which is cloned to produce new objects.  
We use this pattern to:
- Avoid subclasses of an object creator in the client application, like the factory method pattern does.
- Avoid the inherent cost of creating a new object in the standard way (e.g., using the 'new' keyword) when it is prohibitively expensive for a given application.

## (Abstract) Factory Pattern
The factory pattern uses factory methods to deal with the problem of creating objects without having to specify the exact class of the object that will be created. 
This is done by creating objects by calling a factory method. This can either be specified in an interface and implemented by child classes, or implemented in a base class and 
optionally overridden by derived classes, rather than by calling a constructor.

## Builder Pattern
We use the builder pattern to provide a flexible solution to various object creation problems in object-oriented programming. 
The intent of the Builder design pattern is to separate the construction of a complex object from its representation.

# Structural Design Patterns

## Adapter Pattern
We use the adapter pattern (also known as wrapper, an alternative naming shared with the decorator pattern) to allow the interface of an existing class to be used as another interface.
It is often used to make existing classes work with others without modifying their source code.
An example is an adapter that converts the interface of a Document Object Model of an XML document into a tree structure that can be displayed.

## Bridge Pattern
We use the bridge pattern to "decouple an abstraction from its implementation so that the two can vary independently". 
The bridge uses encapsulation, aggregation, and can use inheritance to separate responsibilities into different classes.

## Composite Pattern
We use the composite pattern to describe a group of objects that are treated the same way as a single instance of the same type of object. 
The intent of a composite is to "compose" objects into tree structures to represent part-whole hierarchies. 
Implementing the composite pattern lets clients treat individual objects and compositions uniformly.

## Decorator Pattern
We use the decorator pattern to allow behavior to be added to an individual object, dynamically, without affecting the behavior of other objects from the same class.
The decorator pattern is often useful for adhering to the Single Responsibility Principle, as it allows functionality to be divided between classes with unique areas of concern.
Decorator use can be more efficient than subclassing, because an object's behavior can be augmented without instantiating an entirely new object.

## Facade Pattern
The facade pattern serves as a front-facing interface masking more complex underlying or structural code.  
A facade can:
- Improve the readability and usability of a software library by masking interaction with more complex components behind a single (and often simplified) API
- Provide a context-specific interface to more generic functionality (complete with context-specific input validation)
- Serve as a launching point for a broader refactor of monolithic or tightly-coupled systems in favor of more loosely-coupled code

Developers often use the facade pattern when a system is very complex or difficult to understand because the system has many interdependent classes or because its source code is unavailable.
This pattern hides the complexities of the larger system and provides a simpler interface to the client. It typically involves a single wrapper class containing a set of members required by the client.
These members access the system on behalf of the facade client and hide the implementation details.

## Flyweight Pattern
A flyweight is an object that minimizes memory usage by sharing as much data as possible with other similar objects. It is a way to use objects in large numbers when a simple repeated representation would 
use an unacceptable amount of memory. Often some parts of the object state can be shared. The flyweight object holds the objects in an external data structure and passes them when they are needed.

A classic example usage of the flyweight pattern is the data structures for graphical representation of characters in a word processor. 
For each character in a document, it might be desirable to have a glyph object containing its font outline, font metrics, and other formatting data, but this would amount to hundreds or thousands of bytes for each character.
Instead, for every character there might be a reference to a flyweight glyph object shared by every instance of the same character in the document. Only the position of each character in the document would need to be stored internally.

## Proxy Pattern
A proxy is a class functioning as an interface to something else. The proxy could interface to anything: a network connection, a large object in memory, a file, or some other resource that is expensive or impossible to duplicate.
In short, a proxy is a wrapper or agent object that is being called by the client to access the real serving object behind the scenes. Use of the proxy can simply be forwarding to the real object, or can provide additional logic. 
In the proxy, extra functionality can be provided, for example caching when operations on the real object are resource intensive, or checking preconditions before invoking operations on the real object. 
For the client, usage of a proxy object is similar to using the real object, because both implement the same interface.

# Behavioral Design Patterns

...