# shapes_java
College 3rd year project in java for creating classes and objects in order to create shapes and their corresponding calculations.

Given a solid body, the net torque, about its centroidal axis of rotation is related to the moment of inertia, I, and the angular acceleration acc(rad/s2), according to the formula for the conservation of angular momentum:
T = I × acc

The moment of inertia depends on the shape of the body:
Solid
Moment of Inertia
Cone
0.3 ×mass × r2, r is the radius of the cone’s base
Sphere
0.4 ×mass × r2, r is the radius of the sphere
Disk
0.5 ×mass × r2, r is the radius of the disk


Define a super class (Solid) that contains data fields for angular acceleration, mass, radius, and then three subclasses (Cone, Sphere, and Disk) that contain five constants associated with each shape: one constant from the formula in the preceding table, plus the four limits from the following table:

Solid
Correct r values (m)
Correct mass values (kg)
Cone
0.024 <= r <= 0.070
0.23 < mass <= 9.7
Sphere
0.015 <= r <= 0.045
0.11 < mass <= 10
Disk
0.093 <= r <= 0.207
0.088 < mass <= 11


The classes should have the constructors, mutators, and accessors.  In the constructors and corresponding mutators, make sure to screen out values of r and mass outside the ranges listed.  Also, all classes should include the following methods:
A method that computes the moment of inertia 
A method that computes the torque.

Then write a program in Java which asks for the radii, mass, and angular acceleration of 5 solids.  The data of 5 solids should be stored in an array.  The program then sorts the solids according to the torque, and then stores the data read, the moment of inertia, and the torque into database in the sorted order.

What to submit:
Source files – only .JAVA files will be accepted
Supporting document – only DOC/DOCX or PDF file will be accepted; and it must include:
Test Plan – include test cases for normal, boundary, huge, and invalid data. 
Sample screenshots of program execution for each type of data in the test plan
