Java Triangle Class

This application demonstrates the use of the Triangle Class.

It's designed based on the Circle and Rectangle Classes that were introduced, created, and used in Chapter 6.6. of Kenneth Lambert's book, Fundamentals of Java: AP Computer Science Essentials.  The following entry from the book explains why I created the Triangle Class:

"Graphics examples in earlier chapters displayed geometric shapes such as rectangles and
ovals by running the corresponding drawing or filling methods of the Graphics class. There are
several reasons why it will now be useful to implement each shape as a distinct object with its
own methods:
1. A shape has its own attributes, such as a color, a position, and a size. Defining a class for a
shape allows a user to manipulate it by changing its color, position, or size.
2. Defining shape classes allows us to program with more specific shapes than those implied by
the drawing methods of the Graphics class. For example, a circle is a specific type of oval,
but we usually think of a circle in terms of its center point and radius rather than a corner
point, width, and height. Similar remarks also hold true for triangles and other more complex
shapes.
3. If a shape already knows about its own attributes, it just needs a graphics context in order
to display itself. Users can then more easily display shapes by asking them to display them-
selves, using a single draw(aGraphicsObject) or fill(aGraphicsObject) method.
4. Programs that use multiple shapes in complex arrangements can more easily compose these
and manipulate them by using instances of shape classes."

Design

The Triangle Class is more complicated to implement than both the Rectangle and Circle Classes.  Checking to determine if a point clicked is within the shape of the triangle involves the following --  Starting at the point clicked, move right.  If you encounter one side of the triangle, then you're inside of it.  Zero or more indicates that you're outside of its area.  Sounds simple enough, right?  Please check out the code.

