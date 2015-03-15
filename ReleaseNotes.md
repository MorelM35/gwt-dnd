
---

# What's brewing in gwt-dnd `trunk` #
  * Stay tuned. More to come.

# What's new in `gwt-dnd-3.3.3.jar` (requires GWT 2.6.1 or newer) #
  * **Changes in this release**
    * Fix for for [issue 183](https://github.com/fredsa/gwt-dnd/issues/183), remove unnecessary escaping from css. Thanks Daniel Kurka!


---

# What's new in `gwt-dnd-3.3.2.jar` (requires GWT 2.6.1 or newer) #
  * **Changes in this release**
    * Fix bad `@external` annotation in `gwt-dnd.css`. Thanks Daniel Kurka!


---

# What's new in `gwt-dnd-3.3.1.jar` (requires GWT 2.6.1 or newer) #
  * **Changes in this release**
    * Java 7, GWT 2.6.1
    * Restored support for `ie6`. Thanks adekyn!


---

# What's new in `gwt-dnd-3.3.0.jar` (requires GWT 2.6.0 or newer) #
  * **Changes in this release**
    * Removed support for `ie6`
    * Added support for `ie10`


---

# What's new in `gwt-dnd-3.2.3.jar` (requires GWT 2.5.0 or newer) #
  * **Changes in this release**
    * Support for [right-to-left](http://en.wikipedia.org/wiki/Right-to-left) languages! This means supporting drop targets which have `direction:rtl` applied to them.
  * **Bug fixes**
    * Fix for [issue 168](https://github.com/fredsa/gwt-dnd/issues/168) RTL issues in `FlowPanelDropController` and other panels extending `AbstractIndexedDropController`


---

# What's new in `gwt-dnd-3.2.2.jar` (requires GWT 2.5.0 or newer) #
  * **Bug fixes**
    * Fix for [issue 147](https://github.com/fredsa/gwt-dnd/issues/147) `NullPointerException` in `MouseDragHandler.makeNotDraggable`. Thanks erik.sperling.johansen.ESJ, mmagdy!


---

# What's new in `gwt-dnd-3.2.1.jar` (requires GWT 2.5.0 or newer) #
  * **Bug fixes**
    * Fix for [issue 52](https://github.com/fredsa/gwt-dnd/issues/52) can't catch click & double-click events in a draggable: only call `event.preventDefault()` in `onMouseMove()` when mouse down widget is a instance of `Image`. Thanks georgopoulos.georgios, Andigator, srki.mit!
  * **New in this release**
    * Support for GWT 2.5.1
    * Support [Chromebook Pixel](http://www.google.com/intl/en/chrome/devices/chromebook-pixel/), which allows for both touch and mouse based events
  * **Other changes in this release**
    * Synthetic touch up and mouse up events for draggables
    * Remove unnecessary cancellations of document selection
    * Removed obsolete workarounds for very old Safari 1.3.2
    * Remove unnecessary onTouchStart sanity check
    * New [ClickTouchExample](https://gwt-dnd.appspot.com/#ClickTouchExample) demo


---

# What's new in `gwt-dnd-3.2.0.jar` (requires GWT 2.5.0 or newer) #
  * **New in this release**
    * Support for GWT 2.5.0


---

# What's new in `gwt-dnd-3.1.2.jar` (requires GWT 2.4.0 or newer) #
  * **New in this release**
    * Releases are now also deployed to Sonatype OSS Maven repository and sync to [Maven Central](http://search.maven.org/#search%7Cga%7C1%7Ccom.allen-sauer.gwt.dnd) with groupId `com.allen-sauer.gwt.dnd` and artifact `gwt-dnd`
  * **Changes in this release**
    * gwt-dnd now requires Java 1.6 / GWT 2.4.0 or newer


---

# What's new in `gwt-dnd-3.1.1.jar` (requires GWT 2.3.0 or newer) #
  * **New in this release**
    * Add explicit support for `ie9` `user.agent` property value, to get rid of those annoying warnings about GWT having to use a fallback value.
    * Also removed obsolete `gecko` `user.agent` property.


---

# What's new in `gwt-dnd-3.1.0.jar` (requires GWT 2.2.0 or newer) #
  * **Bug Fixes**
    * Delay full page transparent `DIV` from appearing until dragging has started, so that mouse clicks can be detected within `DragHandle` when drag sensitivity > 0. Thanks, Tom Stamm!
    * No more window scrollbars due to client window having been resized after the first user drag operation. Thanks, jwwagner!
    * Fix for [issue 106](https://github.com/fredsa/gwt-dnd/issues/106) - `VetoDragException` from `onPreviewDragStart()` can prevent all future dragging. Thanks, swilber!
    * Fixed capturing overlay widget size: window / browser viewport size -> full document / page size
    * Better fix for [issue 29](https://github.com/fredsa/gwt-dnd/issues/29) - Dragged widget not following fast drag over `IFrame`. Thanks, paulisio!
    * Fix for [issue 123](https://github.com/fredsa/gwt-dnd/issues/123) -  Cannot drag >2 proxy items to the end of panel using `AbstractInsertPanelDropController`. Thanks, cknowles!
    * Prevent `NullPointerException` when effective style is `null`. Thanks, Carl!
  * **New in this release**
    * Draggables (or their `DragHandle`s), no longer need to implement `MouseOutHandler`, `MouseMoveHandler` and `MouseUpHandler`. Thanks, bblain7!
      * It's easier to construct a draggable or `DragHandle` since you only need to implement `MouseDownHandler`.
      * Your browser will no longer be unnecessarily firing mouse events when your mouse moves over draggables and you are not dragging.
    * [Issue 64](https://github.com/fredsa/gwt-dnd/issues/64) - **Add touch support (single finger dragging) for mobile webkit devices (Android, iOS)**. Draggables (or their `DragHandle`s) may implement `HasMouseDownHandler`s and/or `HasTouchStartHandler`s in order to be draggable by mouse and touch events respectively. Thanks, me3xik!
  * **Other changes in this release**
    * `UncaughtExceptionHandler` popup in sample code should not steal keyboard events, e.g. `CMD-R`/`CTRL-R` to refresh page.
    * [Issue 134](https://github.com/fredsa/gwt-dnd/issues/134) - `MouseDragHandler#onMouseDown` fails faster for multiple mouse clicks (or touches) on the same draggable. Thanks, Lars.Grammel!
    * Updates for GWT 2.1, e.g. replaced deprecated `DeferredCommand` with `Scheduler`


---

# What's new in `gwt-dnd-3.0.1.jar` #
  * **Bug Fixes**
    * Fix for [issue 100](https://github.com/fredsa/gwt-dnd/issues/100). No longer obfuscate `dragdrop-positioner` and `dragdrop-draggable` CSS stylenames. Thanks christoph.dietze!
    * Fix for assertion error in AbsolutePositionDropController on drag after a vetoed drag which involved a drag proxy. Thanks chi at chi.ca!
  * **Other changes in this release**
    * Prevent gwt-dnd complaining about lack of `position:relative` ([GWT issue 1813](http://code.google.com/p/google-web-toolkit/issues/detail?id=1813)) in IE standards mode when boundary panel is `RootPanel.get()` because IE says offset parent is HTML element but parent in BODY element
    * Warn that `PopupPanel` and its subclasses are not really draggable
    * Remove IE6 IFRAME workaround as it no longer appears to be a problem. In practice, IFRAME dragging behaves differently accross browsers, and so this was fairly useless anyway
    * Remove @Strict annotation now that it is the default and deprecated
    * Improve ant build prompts


---

# What's new in `gwt-dnd-3.0.0.jar` #
  * **Bug Fixes**
    * Fix for [issue 92](https://github.com/fredsa/gwt-dnd/issues/92) When opening the context menu while dragging a `DragProxy`, the dragging doesn't work after releasing both mouse buttons. Thanks kacper.grubalski!
    * Fix for [issue 73](https://github.com/fredsa/gwt-dnd/issues/73) Dragging a widget with drag handle clears the selection. Thanks phillip.walter!
    * Fix for [issue 83](https://github.com/fredsa/gwt-dnd/issues/83) index panel drop restoring widgets to the wrong position when a `VetoDragException` is thrown to prevent the drop. Thanks jimblackler!
    * Fix for [issue 29](https://github.com/fredsa/gwt-dnd/issues/29) (Dragged Widget Not Following Fast Drag Over Iframe). Thanks kaaloo!
    * Fix for [issue 81](https://github.com/fredsa/gwt-dnd/issues/81) (Problems using a DnD boundary panel within a scroll panel) items 1 and 3. Due to `scrollIntoView()`, developer driven changes and user scrolling, gwt-dnd will call `resetCache()` in `PickupDragController` for each mouse movement if it has been at least 100ms since the last `resetCache()`. Thanks m...@coware.de!
    * Fix for [issue 80](https://github.com/fredsa/gwt-dnd/issues/80) item 1, draggables contained inside other draggables cannot be separated if the draggables use separate drag controllers (and thus separate `MouseDragHandlers`). This is a more general issue comparable to [issue 65](https://github.com/fredsa/gwt-dnd/issues/65) (`dragStartSensitivity > 0` causes draggable droptargets to "fuse" together) which involved only a single drag controller. Thanks m...@coware.de!
    * Fix for [issue 80](https://github.com/fredsa/gwt-dnd/issues/80) item #2. Global sorting of drop target candidates incorrect due to naive `compareTo()` implementation. Thanks ma!
    * Fix for [issue 79](https://github.com/fredsa/gwt-dnd/issues/79); TEXTAREA in `WindowExample` not editable when clicked in some browsers. Also prevent `TextArea` in `WindowExample` from growing with each click on Chrome. Thanks mw!
    * Fix for overly aggressive clipping of `WidgetArea` when offsetParent(s) effectively have 'overflow:visible'. Thanks Dominik Steiner!
    * Fix for [gwt-mosaic issue 59](http://code.google.com/p/gwt-mosaic/issues/detail?id=59) and [gwt-dnd issue 84](https://github.com/fredsa/gwt-dnd/issues/84) to prevent drag handle widgets from jumping when drag sensitivity > 0 by ensuring that `context.desiredDraggableX/Y` is correct when the first `dragMove()` call is made. Thanks a\_inan...@yahoo.com, georgopoulos.georgios, ro...@softaria.com!
    * Fix for [issue 53](https://github.com/fredsa/gwt-dnd/issues/53) - Demo 6 Uncaught Exception. Thanks bblain7!
  * **New features**
    * New `DragController` methods `getBehaviorScrollIntoView()` and `setBehaviorScrollIntoView()`.
    * [Issue 85](https://github.com/fredsa/gwt-dnd/issues/85) - `LocationWidgetComparator` is now an interface. Thanks pmuetschard@google.com!
    * [Issue 82](https://github.com/fredsa/gwt-dnd/issues/82) - new `PickupDragController` method `getSelectedWidgets()`. Thanks bblain7!
    * Deprecating `InsertPanelDropController` in favor if new `VerticalPanelDropController` and `HorizontalPanelDropController`
    * New `PickupDragController` method `unregisterDropControllers()`. Thanks m...@coware.de!
  * **Changes in this release**
    * In the `InsertPanelExample` demo replace `NoInsertAtEndInsertPanelDropController` solution with `VerticalPanelWithSpacer` solution.
    * Removed unnecessary code. Thanks 4ruggi!
    * Deprecated `IndexedDropController` and `AbstractIndexedDropController`.
    * Code cleanup now the [GWT issue 1112](http://code.google.com/p/google-web-toolkit/issues/detail?id=1112) provides an `InsertPanel` interface.
      * `IndexedPanel` -> `InsertPanel`
      * `IndexedDropController` -> `InsertPanelDropController`
      * `AbstractIndexedDropController` -> `AbstractInsertPanelDropController`
    * Ant build changes
      * Fix for [issue 86](https://github.com/fredsa/gwt-dnd/issues/86) lack of SVN permissions prevents clean build for users. Thanks ro...@softaria.com!
      * Miscellaneous cleanup
    * Use the last selected widget (when multiple widgets are selected) as the `scrollIntoView()` widget. This improves scrolling since the last selected widget is the widget under the mouse cursor.
    * No longer warn for zero height drop targets; too many valid reasons for this to be the case, e.g. widgets hidden in a `DeckPanel`
    * Add additional debug colors in `DropControllerCollection` when `DOMUtil.DEBUG = true` (for those of you hacking gwt-dnd source)
    * Removed performance workaround for Firefox on Linux
    * `gwt-dnd.css` is now injected via `ClientBundle` rather than requiring an extra HTTP roundtrip
    * Addressed [Issue 69](https://github.com/fredsa/gwt-dnd/issues/69) - `DeferredMoveCommand` may cause unexpected problems when trying to access native events. Thanks mark.renouf!



---

# What's new in `gwt-dnd-2.6.5.jar` #
  * **Bug Fixes**
    * Fix for widgets which have a non-zero `offsetLeft` or `offsetTop` (due to another widget with the same offset parent) with a scrolling offset parent. Thanks Pierre-Emmanuel!


---

# What's new in `gwt-dnd-2.6.4.jar` #
  * **Changes in this release**
    * Provide automatic `scrollIntoView()` in the `AbsolutePositionDropController` which provides the automatic scrolling of scroll panels which most people need.
    * Add deferred binding property for GWT's new user-agent value `ie8`
  * **Bug Fixes**
    * Fix for [issue 65](https://github.com/fredsa/gwt-dnd/issues/65) (dragStartSensitivity > 0 causes draggable droptargets to "fuse" together). Thanks hansson!
    * Fix for [issue 59](https://github.com/fredsa/gwt-dnd/issues/59) (`MouseDragHandler`: Incorrect mouse position in context, when dragStartSensitivity > 0). Thanks mark.renouf!
    * Fix for [issue 56](https://github.com/fredsa/gwt-dnd/issues/56) (Able to drag widgets onto portion of drop target that is outside of `ScrollPanel`'s viewport), which is a regression of [issue 24](https://github.com/fredsa/gwt-dnd/issues/24) (multiple draggables inside scroll panels overlap). Thanks jeremiah.boyle! [Issue 24](https://github.com/fredsa/gwt-dnd/issues/24) wasn't fixed properly and was thus eventually reverted in r744 and r828 because of an issue identified by markwmccall.
    * Fix for [issue 71](https://github.com/fredsa/gwt-dnd/issues/71) - scrolling of boundary panel causes widget drag position to be off by scrolled amount. Thanks Fabrice!


---

# What's new in `gwt-dnd-2.6.2.jar` #
  * **Changes in this version**
    * GWT 1.6 support, i.e.
      * GWT 1.5 Listeners -> GWT 1.6 Handlers
      * Launches: GWTShell -> HostedMode
      * Better use of 1.6 project / war structure
      * Refactored project for new eclipse plugin
  * **Bug Fixes**
    * [Issue 55](https://github.com/fredsa/gwt-dnd/issues/55) - Dragging does not work if client code calls `RootPanel.get().clear()`. Thanks david.nouls!
    * Removed zero height check for boundary panels that are (non-BODY) AbsolutePanels as the existing test is not reliable in IE as confirmed by `DualListBoxExample`. Thanks max.tomlinson!
  * **Other updates**
    * Slight cleanup to take advantage of [GWT issue 3428](http://code.google.com/p/google-web-toolkit/issues/detail?id=3428)


---

# What's new in `gwt-dnd-2.5.6.jar` #
  * **Bug Fixes**
    * Removing final scroll panel workarounds which have been obsoleted by recent GWT 1.5 coordinate system fixes. Thanks Carolin Nolte!


---

# What's new in `gwt-dnd-2.5.5.jar` #
  * **Useful hosted mode checks that tend to bite a lot of developers**
    * Add boundary panel `clientHeight == 0` check in hosted mode, mostly to catch standards rendering mode BODY client height == 0
    * Add hosted mode check for [GWT issue 1813](http://code.google.com/p/google-web-toolkit/issues/detail?id=1813) `RootPanel.get("id")` does not apply `position: relative` to element


---

# What's new in `gwt-dnd-2.5.4.jar` #
  * **Bug Fixes**
    * Fix for [issue 45](https://github.com/fredsa/gwt-dnd/issues/45), correcting problems with draggable images in IE when drag sensitivity > 5. Thanks Tim Valenzuela!
  * **Other updates**
    * Corrected exception message in PickupDragController#saveSelectedWidgetsLocationAndStyle(), as reported in [issue 41](https://github.com/fredsa/gwt-dnd/issues/41). Thanks ToonTalk!



---

# What's new in `gwt-dnd-2.5.3.jar` #
  * **Bug Fixes**
    * Correctly handle `VetoDragException` in `onPreviewDragStart()`. Thanks yogesh17.patel!
    * Correct `ScrollPanel` offsets for drop target inside a split panel. Thanks Markus (coware.de)!
    * Fixed width of spacer in [IndexedPanelExample](https://gwt-dnd.appspot.com/#IndexedPanelExample) demo so you can more easily drop on an "empty" column. Thanks Vitaly.Sazanovich!

  * **API additions**
    * Added `DragController#getBehaviorCancelDocumentSelections` and `DragController#setBehaviorCancelDocumentSelections`

  * **Other updates**
    * Add history token support to demo



---

# What's new in `gwt-dnd-2.5.2.jar` #
  * **Bug Fixes**
    * Corrected handling of `ScrollPanel` calculations for indexed panels. If you wrap your drop targets in scroll panels, this fix is for you. Thanks markwmccall!

  * **Other updates**
    * Ant build script fixes. Thanks A.A.Vasiljev!




---

# What's new in `gwt-dnd-2.5.0.jar` #

  * **Changes in this release**
    * Java 1.5 / GWT 1.5 support
    * Removed previously deprecated methods

  * **Bug Fixes**
    * `FlowPanelDropController`, with a `PickupDragController` and no drag proxy, dragging a widget to the same `FlowPanel` that it started in. If you then throw a `VetoDragException` from a `FlowPanelDropController` the widgets are restored to the wrong location. Thanks dunhamsteve!
    * [Issue 24](https://github.com/fredsa/gwt-dnd/issues/24): Scroll panels (actually any offset parent elements are now taken into account when considering drop target intersection with the mouse cursor.
    * When dragging quickly with non-zero drag sensitivity, drag may not start until mouse later wandered back over widget. Thanks amralam!
    * Once multiple widgets have been selected, clicking on one, without the `CTRL`/`meta` key, removed the remaining widget, if an `AbstractIndexedDropController` was in use. Thanks bosco!
    * Dragging multiple widgets from a flow or indexed panel, caused them to be dragged with incorrect relative positions. Thanks bosco!
    * Indexed panel draggable swapping positions with next widget at the start of a drag. Thanks aholub & bosco!

  * **Other updates**
    * Ant build changes. Thanks janek.bogucki!
    * Added a [NOTICE](hhttps://github.com/fredsa/gwt-dnd/blob/master/DragDrop/NOTICE) file; See this project's [Apache 2.0 License](http://www.apache.org/licenses/LICENSE-2.0) for what this means if you want to redistribute gwt-dnd
    * Removed workarounds for issues resolved in the 1.5 milestone
    * Javadoc updates
    * Optional debug code for `DOMUtil#findIntersect`, which can be enabled by setting `DOMUtil.DEBUG` to `true`

        ```Java
        public static final boolean DEBUG = true;
        ```

    * Minor updates to online demos





---

# What's new in `gwt-dnd-2.0.7.jar` #

  * **Bug Fixes**
    * Fixed drop target eligibility sorting, especially for more complex client applications, especially if your application has a mixture of drop targets that have ancestor/descendant DOM relationships, and drop targets that do not
    * Workaround to prevent the occasional "Unknown runtime error" in IE at the start of a drag
    * `DragEndEvent#getDropTarget()` would throw `NullPointerException` when referenced from `DragHandler#onDragEnd()`. Thanks sfranciscus!

  * **Changes in this release**
    * Drag Handlers will now have `onPreviewDragEnd()` called, even if a drop controller already vetoed the drag operation
    * Drag handlers will now see the same `DragEndEvent` instance in `onPreviewDragEnd()` and `onDragEnd()`, and the same `DragStartEvent` instance in `onPreviewDragStart()` and `onDragStart()`
    * Cleaned up `DragEndEvent#toString()` and `DragStartEvent#toString()` output
    * CSS `margin: 0px` is now always set during dragging so that stylesheet based margins are also overridden; previously only margins set explicitly on the DOM element would be overridden
    * `context.draggable` is now reset to `null` after drag operations end
    * `DragController#resetCache()` may now be called when no drag is currently underway, allowing for simplified client code in some use cases

  * **Other updates**
    * New [PaletteExample demo](https://gwt-dnd.appspot.com/#PaletteExample)
    * Implementation changes, moved some cleanup code from `MouseDragHandler` to `DragContext`
    * Modified implementation of `DragHandlerCollection`
    * Updated ant build file and other Eclipse project files




---

# What's new in `gwt-dnd-2.0.5.jar` #

  * **Bug Fixes**
    * [Issue 21](https://github.com/fredsa/gwt-dnd/issues/21) Mac users can use the option/meta key for multi-select. Thanks binduwavell!

  * **Changes in this version**
    * `AbstractIndexedDropController#newPositioner(DragContext)` access changed from default to `protected` to allow subclasses to override the default implementation. Thanks martijn.spronk!





---

# What's new in `gwt-dnd-2.0.4.jar` #

  * **Changes in this version**
    * Rebuilt jar file to target JDK 1.4 (Java `*.class` file version `48.0`). Previous jar was inadvertently packaged with version `50.0` (Java 6) `*.class` files.





---

# What's new in `gwt-dnd-2.0.3.jar` #

  * **Changes in this version**
    * The `AbstractDragController` constructor no longer accepts `null` as a value for the `boundaryPanel` parameter. Client code must instead pass in `RootPanel.get()` explicitly. Tis is actually a documentation change, as `null` did not work in gwt-dnd 2.0.2 either.
    * The current gwt-dnd version is available via `$GWT_DND_VERSION`, once the gwt-dnd classes have been (statically) initialized. This also means you can `grep` the JavaScript compiled output for `GWT_DND_VERSION`.
    * Added two `!important` CSS rules for the HTML element, ` HTML { margin: 0px !important; border: none !important; } `, as a workaround for [GWT Issue 1932](http://code.google.com/p/google-web-toolkit/issues/detail?id=1932).

  * **Bug Fixes**
    * Corrected dragging positions when the document BODY (`RootPanel.get()`) has non-zero CSS margins/borders and is used as the drag controller boundary panel.





---

# What's new in `gwt-dnd-2.0.2.jar` #


  * **Feature Highlights**
    * Select multiple widgets for dragging via `CTRL`/`META`-click. Use `DragController#setBehaviorMultipleSelection(true)` to enable this functionality.
    * Drop target selection and drop positioning are based on the current mouse location rather than current draggable location/center. This has been much requested, and makes gwt-dnd more consistent with traditional desktop drag-and-drop behavior.
    * Drag behavior is more configurable.
    * An updated API (to support the above).

  * **API Considerations**
    * If you are starting a new project, please use the latest gwt-dnd 2.x APIs so that you benefit from all the latest features and fixes.
    * If you have an existing project using gwt-dnd 1.x, you may wish to remain on gwt-dnd 1.x until you have a pressing need to migrate to gwt-dnd 2.x, such as the requirement to be able to drag multiple widgets at once.
    * If you plan on migrating from 1.x to 2.x, please see the [APIMigrationGuide\_v1\_to\_v2](https://github.com/fredsa/gwt-dnd/blob/wiki/APIMigrationGuide_v1_to_v2.md) wiki for details.

  * **Bug Fixes**
    * As a workaround for a [bug that causes IE6 to crash](http://groups.google.com/group/gwt-dnd/browse_thread/thread/9efbb5494871e35b), mouse events are internally tracked on a separate capturing widget, rather than on the panel being dragged.




---

# What's New in `gwt-dragdrop-1.2.6.jar` #

  * **Bug Fixes**
    * Fix for `Error: TYPE_MISMATCH_ERR: DOM Exception 17` with Safari 3.0.4 (5523.10) on Mac OS X Version 10.5 (Leopard). This was caused by the code to cancel the current text selection at the start of each drag operation.




---

# What's New in `gwt-dragdrop-1.2.5.jar` #

  * **Bug Fixes**
    * When two draggables were in close proximity one could sometimes mouse down on one widget, but move quickly enough that the second widget received the first mouse move event. This would cause the second widget to be dragged instead of the first. Fixed so that the widget on which you mouse down is always the one that is dragged.

  * **New Features**
    * While the positioner (usually the dashed light blue rectangle) was always constrained to the boundary panel, the draggable or its drag proxy could be dragged outside of these borders. One can now call `DragController#setConstrainWidgetToBoundaryPanel(true)` to change this behavior.

  * **Other Changes**
    * Eligible drop targets are once again sorted based on their relationship in the DOM, rather than on their relative size, this time using the suggestion in [GWT issue 1218](https://code.google.com/p/google-web-toolkit/issues/detail?id=1218).
    * Demo classes no longer depend on gwt-log as this was throwing a few too many people off. A light weight replacement `UnCaughtExceptionHandler` is used instead.
    * Some of the online demos have been updated

  * **Other Changes from earlier releases**
    * See the git commit log for all the details. Thanks Conzar, Michael Speth and Stephen Sanders of opnet.com, fameeda.tamboli (synerzip.com), buelltm, jonathan.dudley, jsjenkins168, iamroberthanson, rohitsghatol, ryan.detert, Peter.Dobratz, mwaschkowski, Marcos, matt.andruff, skaflotten, Peter.Dobratz, matthiasthoma, boscomonkey and Mario Zenadocchio!





---

# What's New in `gwt-dragdrop-1.2.4.jar` #

  * Release 1.2.4 is not new. It's old :).




---
