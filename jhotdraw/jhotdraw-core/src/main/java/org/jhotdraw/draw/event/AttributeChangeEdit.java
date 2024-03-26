/*
 * @(#)AttributeChangeEdit.java
 *
 * Copyright (c) 1996-2010 The authors and contributors of JHotDraw.
 * You may not use, copy or modify this file, except in compliance with the
 * accompanying license terms.
 */
package org.jhotdraw.draw.event;

import javax.swing.undo.*;
import org.jhotdraw.draw.*;
import org.jhotdraw.draw.figure.Figure;

/** An {@code UndoableEdit} event which can undo a change of a {@link Figure} attribute. */
public class AttributeChangeEdit<T> extends AbstractUndoableEdit {

  private static final long serialVersionUID = 1L;
  private Figure owner;
  private AttributeKey<T> name;
  private T oldValue;
  private T newValue;

  public AttributeChangeEdit(Figure owner, AttributeKey<T> name, T oldValue, T newValue) {
    this.owner = owner;
    this.name = name;
    this.oldValue = oldValue;
    this.newValue = newValue;
  }

  @Override
  public String getPresentationName() {
    // FIXME - Localize me
    return "Eigenschaft \u00e4ndern";
  }

  @Override
  public void redo() throws CannotRedoException {
    super.redo();
    owner.willChange();
    owner.attr().set(name, newValue);
    owner.changed();
  }

  @Override
  public void undo() throws CannotUndoException {
    super.undo();
    owner.willChange();
    owner.attr().set(name, oldValue);
    owner.changed();
  }
}
