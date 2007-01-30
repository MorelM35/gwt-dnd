/*
 * Copyright 2006 Fred Sauer
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package com.allen_sauer.gwt.dragdrop.client.drop;

import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Widget;

import com.allen_sauer.gwt.dragdrop.client.DragAndDropController;
import com.allen_sauer.gwt.dragdrop.client.util.Area;
import com.allen_sauer.gwt.dragdrop.client.util.Location;

import java.util.Iterator;

/**
 * A {@link com.allen_sauer.gwt.dragdrop.demo.client.drop.DropController} which
 * constrains prevents draggable widgets from overlapping.
 * 
 * TODO handle drop() and onDrop() with overlapping coordinates properly
 */
public class NoOverlapDropController extends AbsolutePositionDropController {

  private AbsolutePanel dropTargetPanel;

  public NoOverlapDropController(AbsolutePanel dropTargetPanel) {
    super(dropTargetPanel);
    this.dropTargetPanel = dropTargetPanel;
  }

  public void drop(DragAndDropController dragAndDropController, int left, int top) {
    // allow any programatic drop location; disregard overlapping
    this.dropTargetPanel.add(dragAndDropController.getDraggable(), left, top);
  }

  public String getDropTargetStyleName() {
    return "dragdrop-drop-target dragdrop-no-overlap-drop-target";
  }

  public void onEnter(DragAndDropController dragAndDropController) {
    // TODO Auto-generated method stub
    super.onEnter(dragAndDropController);
  }

  // TODO attempt to move as close to desired location as possible rather than
  // simply try current desired location
  protected boolean constrainedWidgetMove(DragAndDropController dragAndDropController, Widget widget) {
    AbsolutePanel boundryPanel = dragAndDropController.getBoundryPanel();
    Area dropArea = new Area(this.dropTargetPanel, boundryPanel);

    Area draggableArea = new Area(dragAndDropController.getDraggable(), boundryPanel);
    Location location = new Location(dragAndDropController.getDraggable(), this.dropTargetPanel);
    location.constrain(0, 0, dropArea.getWidth() - draggableArea.getWidth(), dropArea.getHeight() - draggableArea.getHeight());
    // Determine where draggableArea would be if it were constrained the dropArea
    // Also causes draggableArea to become relative to dropTargetPanel
    draggableArea.moveTo(location);
    if (!collision(dragAndDropController, dragAndDropController.getDraggable(), draggableArea)) {
      this.dropTargetPanel.add(widget, location.getLeft(), location.getTop());
      return true;
    }
    if (widget != dragAndDropController.getPostioningBox()) {
      Area dropTargetArea = new Area(this.dropTargetPanel, boundryPanel);
      Area positioningBoxArea = new Area(dragAndDropController.getPostioningBox(), boundryPanel);
      if (dropTargetArea.contains(positioningBoxArea)) {
        location = new Location(dragAndDropController.getPostioningBox(), this.dropTargetPanel);
        this.dropTargetPanel.add(widget, location.getLeft(), location.getTop());
        return true;
      }
    }
    return false;
  }

  private boolean collision(DragAndDropController dragAndDropController, Widget widget, Area area) {
    for (Iterator iterator = this.dropTargetPanel.iterator(); iterator.hasNext();) {
      Widget w = (Widget) iterator.next();
      if ((w == widget) || (w == dragAndDropController.getPostioningBox())) {
        continue;
      }
      if ((new Area(w, this.dropTargetPanel)).intersects(area)) {
        return true;
      }
    }
    return false;
  }

}
