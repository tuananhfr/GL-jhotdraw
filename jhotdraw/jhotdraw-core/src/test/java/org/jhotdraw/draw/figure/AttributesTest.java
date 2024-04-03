/*
 * Copyright (C) 2023 JHotDraw.
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston,
 * MA 02110-1301  USA
 */

package org.jhotdraw.draw.figure;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.awt.Color;
import org.jhotdraw.draw.AttributeKeys;
import org.junit.jupiter.api.Test;

/**
 * @author tw
 */
public class AttributesTest {
  @Test
  public void testBackupRestore() {
    Attributes attr = new Attributes();
    attr.set(AttributeKeys.STROKE_WIDTH, 1.5);

    Object backup = attr.getAttributesRestoreData();

    Attributes attrRestored = new Attributes();
    assertThat(attrRestored.getAttributes()).isEmpty();

    attrRestored.restoreAttributesTo(backup);

    assertEquals(1.5, attrRestored.get(AttributeKeys.STROKE_WIDTH).doubleValue());
    assertEquals(
        attr.get(AttributeKeys.STROKE_WIDTH).doubleValue(),
        attrRestored.get(AttributeKeys.STROKE_WIDTH).doubleValue());
  }

  @Test
  public void testSetAndGetAttribute() {
    Attributes attr = new Attributes();
    attr.set(AttributeKeys.FILL_COLOR, Color.RED);

    assertEquals(Color.RED, attr.get(AttributeKeys.FILL_COLOR));
  }

  @Test
  public void testRemoveAttribute() {
    Attributes attr = new Attributes();
    attr.set(AttributeKeys.STROKE_COLOR, Color.BLUE);
    attr.removeAttribute(AttributeKeys.STROKE_COLOR);

    assertThat(attr.hasAttribute(AttributeKeys.STROKE_COLOR)).isFalse();
  }

  @Test
  public void testAttributeEnabled() {
    Attributes attr = new Attributes();
    attr.setAttributeEnabled(AttributeKeys.FILL_COLOR, true);
    attr.setAttributeEnabled(AttributeKeys.STROKE_COLOR, false);

    assertTrue(attr.isAttributeEnabled(AttributeKeys.FILL_COLOR));
    assertFalse(attr.isAttributeEnabled(AttributeKeys.STROKE_COLOR));
  }
}
