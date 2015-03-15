
---

### _Note:_ ###
### _This document remains only as a reference for the old (deprecated) 1.x API._ ###

_Please refer to the the current [GettingStarted wiki](https://github.com/fredsa/gwt-dnd/blob/wiki/GettingStarted.md) if you are new to gwt-dnd_.


---

# Version Compatibility Matrix #

Please refer to the current [GettingStarted wiki](https://github.com/fredsa/gwt-dnd/blob/wiki/GettingStarted.md).

# Important GWT Bugs/Issues #

Please refer to the current [GettingStarted wiki](https://github.com/fredsa/gwt-dnd/blob/wiki/GettingStarted.md).

# Adding the gwt-dnd Module to your Eclipse Project (1.x API) #
  1. If for some reason you are still using GWT 1.3.3, then please review the issues below as they may affect you. I recommend you upgrade to at least GWT 1.4.61.
  1. Download the latest [gwt-dragdrop-&lt;version&gt;.jar](https://github.com/fredsa/gwt-dnd/blob/wiki/Downloads.md) and place it in a convenient location.
  1. (Optional) if you want to play with the demo (examples), you'll need to grab that from the [Subversion 1.x branch](https://github.com/fredsa/gwt-dnd/tree/DragDrop1x/demo) as there is no jar file for the demos (i.e. the `com.allen_sauer.gwt.dragdrop.demo` package).
  1. Create a GWT Eclipse project as instructed here: http://www.gwtproject.org/gettingstarted.html#NewEclipse

    ```bash
    mkdir MyProject
    cd MyProject
    projectCreator -eclipse MyProject
    applicationCreator -eclipse MyProject com.mycompany.client.MyApplication
    ```

  1. Import your new project via 'File > Import > Existing Project into Workspace'. Specify the `MyProject` directory you created in a previous step.
  1. To allow the GWT command line scripts to continue to work, modify the `-cp` parameter value in both `MyApplication-shell.cmd` and `MyApplication-compile.cmd` to include the path to `gwt-dragdrop-<version>.jar`. You can add it just before the path to `gwt-user.jar`. Don't forget the path separator ';' or ':', depending on your platform.
  1. Right-click on the project node in the Package Explorer and select 'Build Path > Add External Archives...'. Select `gwt-dragdrop-<version>.jar`.
  1. Make sure GWT can find the gwt-dnd module at runtime. Modify `MyProject/src/com/mycompany/MyApplication.gwt.xml` to include these lines:

    ```XML
    <!-- Inherit gwt-dnd 1.x support                        -->
    <inherits name='com.allen_sauer.gwt.dragdrop.DragAndDrop'/>
    ```

# A Quick Test (1.x API) #
  1. Add this CSS to the HTML or CSS file in your project:

    ```CSS
    .dragdrop-dropTarget-engage {
      background-color: #E0E8FF;
    }

    .getting-started-label {
      border: 1px solid #99AACC;
      background-color: #AACCFF;
      padding: 0.1em;
    }

    .getting-started-blue {
      border: 1px solid blue;
    }
    ```

  1. Use this code in your `EntryPoint` class:

    ```Java
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
    package com.mycompany.client;

    import com.google.gwt.core.client.EntryPoint;
    import com.google.gwt.core.client.GWT;
    import com.google.gwt.user.client.Command;
    import com.google.gwt.user.client.DOM;
    import com.google.gwt.user.client.DeferredCommand;
    import com.google.gwt.user.client.Element;
    import com.google.gwt.user.client.Random;
    import com.google.gwt.user.client.ui.AbsolutePanel;
    import com.google.gwt.user.client.ui.DialogBox;
    import com.google.gwt.user.client.ui.Label;
    import com.google.gwt.user.client.ui.RootPanel;

    import com.allen_sauer.gwt.dragdrop.client.PickupDragController;
    import com.allen_sauer.gwt.dragdrop.client.drop.AbsolutePositionDropController;
    import com.allen_sauer.gwt.dragdrop.client.drop.DropController;
    import com.allen_sauer.gwt.dragdrop.client.util.DOMUtil;

    public class MyApplication implements EntryPoint {
      public void onModuleLoad() {

        // set uncaught exception handler
        GWT.setUncaughtExceptionHandler(new GWT.UncaughtExceptionHandler() {
          public void onUncaughtException(Throwable throwable) {
            String text = "Uncaught exception: ";
            while (throwable != null) {
              StackTraceElement[] stackTraceElements = throwable.getStackTrace();
              text += throwable.toString() + "\n";
              for (int i = 0; i < stackTraceElements.length; i++) {
                text += "    at " + stackTraceElements[i] + "\n";
              }
              throwable = throwable.getCause();
              if (throwable != null) {
                text += "Caused by: ";
              }
            }
            DialogBox dialogBox = new DialogBox(true);
            DOM.setStyleAttribute(dialogBox.getElement(), "backgroundColor", "#ABCDEF");
            System.err.print(text);
            text = text.replaceAll(" ", "&nbsp;");
            dialogBox.setHTML("<pre>" + text + "</pre>");
            dialogBox.center();
          }
        });

        // use a deferred command so that the handler catches onModuleLoad2() exceptions
        DeferredCommand.addCommand(new Command() {
          public void execute() {
            onModuleLoad2();
          }
        });
      }

      private void onModuleLoad2() {
        // create a boundary panel to constrain all drag operations
        AbsolutePanel boundaryPanel = new AbsolutePanel();
        boundaryPanel.setPixelSize(400, 300);
        boundaryPanel.addStyleName("getting-started-blue");

        // create a drop target on which we can drop labels
        AbsolutePanel targetPanel = new AbsolutePanel();
        targetPanel.setPixelSize(300, 200);
        targetPanel.addStyleName("getting-started-blue");

        // add both panels to the root panel
        RootPanel.get().add(boundaryPanel);
        boundaryPanel.add(targetPanel, 10, 10);

        // create a DragController for each logical area where a set of draggable
        // widgets and drop targets will be allowed to interact with one another.
        PickupDragController dragController = new PickupDragController(boundaryPanel, true);

        // Positioner is always constrained to the boundary panel
        // Use 'true' to also constrain the draggable or drag proxy to the boundary panel
        dragController.setConstrainWidgetToBoundaryPanel(false);

        // create a DropController for each drop target on which draggable widgets
        // can be dropped
        DropController dropController = new AbsolutePositionDropController(targetPanel);

        // Don't forget to register each DropController with a DragController
        dragController.registerDropController(dropController);

        // create a few randomly placed draggable labels
        for (int i = 1; i <= 5; i++) {
          // create a label and give it style
          Label label = new Label("Label #" + i, false);
          label.addStyleName("getting-started-label");

          // add it to the DOM so that offset width/height becomes available
          targetPanel.add(label, 0, 0);

          // determine random label location within target panel
          int left = Random.nextInt(DOMUtil.getClientWidth(targetPanel.getElement()) - label.getOffsetWidth());
          int top = Random.nextInt(DOMUtil.getClientHeight(targetPanel.getElement()) - label.getOffsetHeight());

          // move the label
          targetPanel.setWidgetPosition(label, left, top);

          // make the label draggable
          dragController.makeDraggable(label);
        }
      }
    }
    ```

# Working Examples (1.x API) #

There are some [working examples](http://allen-sauer.com/com.allen_sauer.gwt.dnd.demo.DragDropDemo/DragDropDemo.html) along with the [demo source code (1.x branch)](https://github.com/fredsa/gwt-dnd/tree/DragDrop1x/demo) for you to look at.

There's also the [library source code (1.x branch)](https://github.com/fredsa/gwt-dnd/tree/DragDrop1x/src) if you want to see what makes it tick.

## Minor Issues to Consider for GWT 1.3.3 ##

If you begin your drag operation and you find that the draggable widget jumps one or more pixels, you may be seeing the effects of the following GWT issues. Your choices are a) live it for now, or b) use the [gwt-dragdrop-patches-*.jar](https://github.com/fredsa/gwt-dnd/blob/wiki/Downloads.md) as part of your project until the bugs are fixed. Please note that this patch jar is specific to a particular release of GWT. Do not mix patch and release versions or you will have problems. The issues are:
  * [GWT Issue 243](http://code.google.com/p/google-web-toolkit/issues/detail?id=243) FireFox doesn't fire ONMOUSEUP after a ONMOUSEDOWN when the pointer is outside the browser's window
  * [GWT Issue 286](http://code.google.com/p/google-web-toolkit/issues/detail?id=286) `onMouseMove()` coordinates account for parent `ScrollPanel`(s) but not a scrolled client area
  * [GWT Issue 601](http://code.google.com/p/google-web-toolkit/issues/detail?id=601) Different mouse event coordinates Firefox/IE due to sender having borders
  * [GWT Issue 602](http://code.google.com/p/google-web-toolkit/issues/detail?id=602) `MouseListener` x and y coordinates wrong by (2,2) in IE due `eventGetClientX()`/`eventGetClientY()`
  * [GWT Issue 616](http://code.google.com/p/google-web-toolkit/issues/detail?id=616) Generalize insert-before functionality to IndexedPanel but at least FlowPanel, StackPanel, TabPanel
  * [GWT Issue 626](http://code.google.com/p/google-web-toolkit/issues/detail?id=626) AbsolutePanel does not remove child CSS position attributes on disown()
  * [GWT Issue 634](http://code.google.com/p/google-web-toolkit/issues/detail?id=634) `getAbsoluteLeft()`/`getAbsoluteTop()` wrong when ancestor has borders and CSS `overflow` != `'visible'`
  * [GWT Issue 693](http://code.google.com/p/google-web-toolkit/issues/detail?id=693) Adding widget to AbsolutePanel in FireFox causes flickering
  * [GWT Issue 718](http://code.google.com/p/google-web-toolkit/issues/detail?id=718) VerticalPanel cannot add() already attached widget
  * [GWT Issue 757](http://code.google.com/p/google-web-toolkit/issues/detail?id=757) AbsolutePanel getWidgetLeft/getWidgetTop off by parent borders in FF
  * [GWT Issue 871](http://code.google.com/p/google-web-toolkit/issues/detail?id=871) IE getAbsoluteLeft/Top() wrong when BODY has borders

## Major Issues to Consider for GWT 1.3.3 (Mac/Safari) ##
  * [GWT Issue 724](http://code.google.com/p/google-web-toolkit/issues/detail?id=724) Safari getAbsoluteLeft() / getAbsoluteTop() return NaN for detached or hidden elements, which causes [issue #1](https://github.com/fredsa/gwt-dnd/issues/1) Drag and Drop does not work on Safari. Use the [gwt-dragdrop-patches-*.jar](https://github.com/fredsa/gwt-dnd/blob/wiki/Downloads.md) for an patched version of `DOMImplSafari`.











