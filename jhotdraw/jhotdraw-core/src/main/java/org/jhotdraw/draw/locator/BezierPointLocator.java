/*
 * @(#)BezierPointLocator.java
 *
 * Copyright (c) 1996-2010 The authors and contributors of JHotDraw.
 * You may not use, copy or modify this file, except in compliance with the
 * accompanying license terms.
 */
package org.jhotdraw.draw.locator;

import java.awt.geom.*;
import org.jhotdraw.draw.figure.BezierFigure;
import org.jhotdraw.draw.figure.Figure;

/** A {@link Locator} which locates a node on the bezier path of a BezierFigure. */
public class BezierPointLocator extends AbstractLocator {

  private static final long serialVersionUID = 1L;
  private final int index;
  private final int coord;

  public BezierPointLocator(int index) {
    this.index = index;
    this.coord = 0;
  }

  public BezierPointLocator(int index, int coord) {
    this.index = index;
    this.coord = index;
  }

  @Override
  public Locator.Position locate(Figure owner, double scale) {
    BezierFigure plf = (BezierFigure) owner;
    if (index < plf.getNodeCount()) {
      return new Position(plf.getPoint(index, coord));
    }
    return new Position(new Point2D.Double(0, 0));
  }
}
