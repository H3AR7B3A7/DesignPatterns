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
 - Unfortunately, synchronized methods run much slower than ordinary asynchronous methods.

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

Con:
 - Just like all the previous patterns, it also can't handle reflection.

#### ENUM
Pro:
 - It is the only singleton that can handle reflection.
 - Very easy to read.

Con:
 - Can't inherit from a super class. However, enums can implement interfaces.

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

## Chain Of Responsibility Pattern
The chain-of-responsibility pattern consists of a source of command objects, and a series of processing objects. Each processing object contains logic that defines the types of command objects that it can handle. 
The rest it will pass to the next processing object in the chain. A mechanism also exists for adding new processing objects to the end of this chain.

In a variation of the standard chain-of-responsibility model, some handlers may act as dispatchers, capable of sending commands out in a variety of directions, forming a tree of responsibility.
In some cases, this can occur recursively, with processing objects calling higher-up processing objects with commands that attempt to solve some smaller part of the problem.
When this is the case, recursion continues until the handler finishes processing the command, or the entire tree has been explored. For example, an XML interpreter might work in this manner.

This pattern promotes the idea of loose coupling.

The chain-of-responsibility pattern is structurally nearly identical to the decorator pattern. 
The difference is that for the decorator, all classes handle the request, while for the chain of responsibility, exactly one of the classes in the chain handles the request.
This is a strict definition of the Responsibility concept in the GoF book. However, many implementations (such as loggers, or UI event handling, or servlet filters, etc.) allow several elements in the chain to take responsibility.

## Command Pattern
In the command pattern, we use an object to encapsulate all information needed to perform an action or trigger an event at a later time. This information includes the method name, the object that owns the method and values for the 
method parameters.

Four terms always associated with the command pattern are command, receiver, invoker and client. A command object knows about the receiver and invokes its method. We store values for parameters of the receiver method in the command.
We store the receiver object to execute these methods in the command object by aggregation. The receiver then does the work when we call the execute-method in command. 
An invoker object knows how to execute a command, and optionally does bookkeeping about the command execution. The invoker does not know anything about a concrete command, it knows only about the command interface. 
A client object holds the invoker object(s), command objects and receiver objects. The client decides which receiver objects it assigns to the command objects, and which commands it assigns to the invoker.
The client decides which commands to execute at which points. To execute a command, it passes the command object to the invoker object.

Using command objects makes it easier to construct general components that need to delegate, sequence or execute method calls at a time of their choosing without the need to know the class of the method or the method parameters. 
Using an invoker object allows bookkeeping about command executions to be conveniently performed, as well as implementing different modes for commands, which are managed by the invoker object, without the need for the client to 
be aware of the existence of bookkeeping or modes.

The central ideas of this design pattern closely mirror the semantics of first-class functions and higher-order functions in functional programming languages. Specifically, the invoker object is a higher-order function of which 
the command object is a first-class argument.

## Interpreter Pattern
We use the interpreter pattern to specify how to evaluate sentences in a language. The basic idea is to have a class for each symbol (terminal or non-terminal) in a specialized computer language. 
The syntax tree of a sentence in the language is an instance of the composite pattern and is used to evaluate (interpret) the sentence for a client.

## Iterator Pattern
In the iterator pattern, an iterator is used to traverse a container and access the container's elements. The iterator pattern decouples algorithms from containers. 
In some cases, algorithms are necessarily container-specific and thus cannot be decoupled.

For example, the hypothetical algorithm SearchForElement can be implemented generally using a specified type of iterator rather than implementing it as a container-specific algorithm. 
This allows SearchForElement to be used on any container that supports the required type of iterator.

## Mediator Pattern
The mediator pattern defines an object that encapsulates how a set of objects interact. With the mediator pattern, we encapsulate communication between objects within a mediator object. 
Objects no longer communicate directly with each other, but instead communicate through the mediator. This reduces the dependencies between communicating objects, thereby reducing coupling.

## Memento Pattern
The memento pattern provides the ability to restore an object to its previous state (undo via a rollback).
We implement it with three objects: the originator, a caretaker and a memento. The originator is some object that has an internal state.
The caretaker is going to do something to the originator, but wants to be able to undo the change. 
The caretaker first asks the originator for a memento object. Then it does whatever operation (or sequence of operations) it was going to do. 
To roll back to the state before the operations, it returns the memento object to the originator. 
The memento object itself is an opaque object (one which the caretaker cannot, or should not, change). 
When using this pattern, care should be taken if the originator may change other objects or resources. The memento pattern operates on a single object.

## Observer Pattern
In the observer pattern, an object named the subject, maintains a list of its dependents, called observers, and notifies them automatically of any state changes,
usually by calling one of their methods. It is mainly used for implementing distributed event handling systems, in "event driven" software.

## State Pattern
The state pattern allows an object to alter its behavior when its internal state changes. This pattern is close to the concept of finite-state machines.
It can be interpreted as a strategy pattern, which is able to switch a strategy through invocations of methods defined in the pattern's interface.

## Strategy Pattern
The strategy pattern enables selecting an algorithm at runtime. Instead of implementing a single algorithm directly, code receives run-time instructions as to which in a family of algorithms to use.
For instance, a class performing validation on incoming data may use the strategy pattern to select a validation algorithm depending on the type of data, the source of the data, user choice, or other discriminating factors.
We don't know these factors until run-time and may require radically different validation to be performed. Other validating objects may use the validation algorithms (strategies) encapsulated separately from the validating object, 
in different areas of the system (or even different systems) without code duplication.

## Template Pattern
The template method is a method in a superclass, usually an abstract superclass, and defines the skeleton of an operation in terms of a number of high-level steps.
These steps are themselves implemented by additional helper methods in the same class as the template method.
The helper methods may be either abstract methods, requiring subclasses to provide concrete implementations, or hook methods, 
which have empty bodies in the superclass. Subclasses can (but are not required to) customize the operation by overriding the hook methods. 
The intent of the template method is to define the overall structure of the operation, while allowing subclasses to refine, or redefine, certain steps.


# Other Mentionables

## Static Factory Method
Pro:
- They have names.
- They are not required to create a new object each time they’re invoked.
- They can return an object of any subtype of their return type.
- The class of the returned object can vary from call to call as a function of the input parameters.
- The returned object need not exist when writing the class containing the method.

Con:
- Classes without public or protected constructors can't be subclassed.
- Harder to find for programmers, so it will require some naming conventions.

## Dependency Injection
Dependency injection is a technique in which an object receives other objects that it depends on. 
These other objects are called dependencies. In the typical "using" relationship the receiving object
is called a client, and the passed (that is, "injected") object is called a service.