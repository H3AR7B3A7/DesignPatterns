Java Singleton Patterns
=======================
Listing pro's and con's of different approaches to create a Singleton Pattern.

Eager Initialization
--------------------
Pro:
 - The instance is not constructed until the class is used.
 - There is no need to synchronize the getInstance() method, meaning all threads will see the same instance and no (expensive) locking is required.
 - The final keyword means that the instance cannot be redefined, ensuring that one (and only one) instance ever exists.

Con:
 - The instance is created even though client application might not be using it.
 - Also, this method doesn’t provide any options for exception handling.
 
Static Block Initialization
---------------------------
(Similar to Eager Initialization)

Con:
 - If multiple threads are inside the if loop at the same time. It will destroy the singleton pattern and both threads will get the different instances of singleton class.

Lazy Initialization
-------------------
Pro:
 - Faster startup time of application for the user to start interacting.

Con:
 - Higher latency at the time the singleton is used.
 - If multiple threads are inside the if loop at the same time. It will destroy the singleton pattern and both threads will get the different instances of singleton class.

Thread Safe Lazy Initialization
-------------------------------
Pro:
 - It is thread safe.

Con:
 - It reduces the performance because of cost associated with the synchronized method, although we need it only for the first few threads who might create the separate instances.
 - Unfortunately, synchronized methods run much slower — as much as 100 times slower — than ordinary unsynchronized methods.

Double-Checked Locking
----------------------
Pro:
 - It prevents the cost of a synchronized method being called everytime we need the singleton object.

Con:
 - It is also synchronized for concurrent use and can be slow too.
 - Recognizing and reproducing failures can be difficult because of intermittent occurrence.
 
Bill Pugh's
-----------
Pro:
 - When the singleton class is loaded, SingletonHelper class is not loaded into memory and only when someone calls the getInstance method, this class gets loaded and creates the Singleton class instance.
 - This is the most widely used approach for Singleton class as it doesn’t require synchronization.
 - The nested class is referenced no earlier (and therefore loaded no earlier by the class loader) than the moment that getInstance() is called. Thus, this solution is thread-safe without requiring special language constructs.

ENUM
----
Pro:
 - Only singleton that can handle reflection.
 - Very easy to read.