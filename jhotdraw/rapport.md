https://gitlab-etu.fil.univ-lille.fr/maya.aityahia.etu/projet_gl

## 6

### 6.1 Renaming a class, method, or variable:

- Rename the `FigureComposite` class to `CompositeFigure` to follow the naming convention used in the rest of the codebase.
- Rename the `FigureFactory` interface to `DrawingFactory` to better reflect its purpose.
- Rename the `Figure` class to `DrawingObject` to better reflect its purpose.

### 6.2 Changing the type or number of parameters of a method:

- Change the `FigureFactory.createFigure(Figure)` method to `FigureFactory.createFigure(Drawing)` to better reflect the purpose of the method.
- Change the `Figure.getBounds()` method to return a Rectangle2D object instead of a Rectangle object to improve type consistency.

### 6.3 Creating variables for magic numbers:

- Create a constant variable for the default zoom level of 1.0 in the DrawingEditor class.
- Create a constant variable for the default grid size of 10 in the DrawingEditor class.

### 6.4 Removing dead code:

- Remove the unused `FigureComposite.getSubFigures()` method.
- Remove the unused `FigureComposite.removeSubFigure(Figure)` method.

### 6.5 Reorganizing a class for better structure:

- Move the instance variables to the top of the `DrawingEditor` class.
- Move the public methods to the top of the `DrawingEditor` class, followed by the private methods.
