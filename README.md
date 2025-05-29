# antikythera-test-helper
A set of classes to help with the antikythera test suites.

These classes should be compiled and imported into the main antikythera project. While antikythera is mostly 
about working with java source code, a class that's available in source form can and will extend classes that are available 
only in binary form. These need to be handled properly by the expression evaluation engine and therefore need to be tested as well.

In many situations we need to generate dynamic classes using ByteBuddy from these sources. If the sources were part of the
main project, the java class loader would load them as well leading to conflicts between the default class and the class 
generate by byte buddy. Additionally, the `Class.forName()` and `ClassLoader.loadClass()` methods would 
incorrectly return classes when they should not.

This project should be checked out into a separate directory. Your folder structure should look like this:

```
-- antikythera-test-helper
   |-- src
-- antikythera
   |-- src
-- antikythera-sample-project
   |-- src
```
