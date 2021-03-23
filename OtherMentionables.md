# Other Mentionables

## Static Factory Method
A static factory method is a public static method on the object that returns a new instance of the object.
These type of methods share the same benefits as the traditional factory method design pattern.
This is especially useful for value objects that don't have a separate interface and implementation class.

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

## Avoiding Object Creation
We should consider reusing an expensive object to avoid creating it multiple times. This can drastically improve performance.
Likewise, we should avoid unnecessary boxing of primitives in repetitive operations to avoid repeated creation of their wrapper variants.

## Cleaning Objects
An Object that has been created during the program execution is automatically removed by Garbage Collector (GC).
When an object not referenced by any thread and when JVM determines that this object can't be accessed, then it can be eligible for garbage collection.

Finalize() is an object method, which is automatically called by the garbage collector before it attempts to remove the object from the heap.
In Java 9, finalize() has been deprecated. A new class java.lang.ref.CleaningObjects was added to garbage collection management.
An object of CleaningObjects class gets notified automatically when an object becomes eligible for garbage collection.
An object that is being garbage collected needs to be registered with the cleaner object by using the register() method.

Usually the use of a cleaner is unnecessary. We only use it in specific situations, for example when we want to make sure sensitive information doesn't stay in memory.
