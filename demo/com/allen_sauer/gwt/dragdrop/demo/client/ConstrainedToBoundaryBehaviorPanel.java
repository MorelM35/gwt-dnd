/*
 * Copyright 2007 Fred Sauer
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
package com.allen_sauer.gwt.dragdrop.demo.client;

import com.google.gwt.user.client.ui.ClickListener;
import com.google.gwt.user.client.ui.RadioButton;
import com.google.gwt.user.client.ui.Widget;

import com.allen_sauer.gwt.dragdrop.client.DragController;

class ConstrainedToBoundaryBehaviorPanel extends BehaviorPanel {
  public ConstrainedToBoundaryBehaviorPanel(final DragController dragController) {
    super("Drag Operations", "getBehaviorConstrainedToBoundaryPanel() / setBehaviorConstrainedToBoundaryPanel(boolean)");

    final RadioButton constrainedButton = newButton("Constrained by Boundary",
        "DragController#setBehaviorConstrainedToBoundaryPanel(true)");
    final RadioButton unconstrainedButton = newButton("Unconstrained",
        "DragController#setBehaviorConstrainedToBoundaryPanel(false)");

    add(constrainedButton);
    add(unconstrainedButton);

    if (dragController.getBehaviorConstrainedToBoundaryPanel()) {
      constrainedButton.setChecked(true);
    } else {
      unconstrainedButton.setChecked(true);
    }

    ClickListener listener = new ClickListener() {
      public void onClick(Widget sender) {
        dragController.setBehaviorConstrainedToBoundaryPanel(constrainedButton.isChecked());
      }
    };

    constrainedButton.addClickListener(listener);
    unconstrainedButton.addClickListener(listener);
  }
}
