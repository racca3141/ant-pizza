
![image](https://user-images.githubusercontent.com/31526815/38764139-112a74fa-3f5e-11e8-8df3-b9aa9a0b3a95.png)

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

![image](https://user-images.githubusercontent.com/31526815/38764203-a25f5ebc-3f5f-11e8-886e-e97ab7734e65.png)

But the truth is that I wanted to be able to do justice (pun intended) to Superman's cape and logo.  Instead of using rectangles, I could then draw movable triangle objects.

Design

The Triangle Class is more complicated to implement than both the Rectangle and Circle Classes.  Checking to determine if a point clicked is within the shape of the triangle involves the following --  Starting at the point clicked, move right.  If you encounter one side of the triangle, then you're inside of it.  Zero or more indicates that you're outside of its area.  Sounds simple enough, right?  Please check out the code.

---

This was created for College of the Sequoias' (Tulare, CA) COMP 008 - Programming Concepts.

