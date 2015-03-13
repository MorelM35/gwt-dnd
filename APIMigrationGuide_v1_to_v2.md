### ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------ ###
## // PLEASE NOTE: A lot has changed from 1.x to 2.x // ##
  * If you are starting a new project, please use the latest gwt-dnd 2.x APIs so that you benefit from all the latest features and fixes.
  * If you have an existing project on gwt-dnd 1.x, you may wish to remain on gwt-dnd 1.x until you have a pressing need to migrate to gwt-dnd 2.x, such as the requirement to be able to drag multiple widgets at once.
  * If you plan on migrating from 1.x to 2.x, you may do so all at once, or one `DragController` at a time by temporarily including both APIs in your project.

### ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------ ###
# Changes for `gwt-dnd-2.0.2.jar` #

  * ### Feature Highlights ###
    * Select multiple widgets for dragging via `CTRL`/`META`-click.
    * Drop target selection and drop positioning are based on the current mouse location rather than current draggable location/center. This has been much requested, and makes gwt-dnd more consistent with traditional desktop drag-and-drop behavior.
    * Drag behavior is more configurable via various `getBehavior*()` and `setBehavior*()` methods.
    * Distinct Java packages for 1.x and 2.x API to allow your projects to temporarily include both APIs during the migration process.


  * ### General Changes ###
    * Version bumped from 1.x to 2.x to highlight behavioral and API changes (see below).
    * The default text "this is a Drag Proxy" has been removed.
    * As a workaround for a [bug that causes IE6 to crash](http://groups.google.com/group/gwt-dnd/browse_thread/thread/9efbb5494871e35b), mouse events are internally tracked on a separate capturing widget, rather than on the panel being dragged.
    * Updated javadoc.
    * New and updated [demos](http://allen-sauer.com/com.allen_sauer.gwt.dnd.demo.DragDropDemo/DragDropDemo.html).
    * Significant API refactoring and restructuring, affecting client code with custom drag and drop controllers.


  * ### Packaging and Naming Changes ###
| **Category** | **1.x API** | **2.x API** | **Comments** |
|:-------------|:------------|:------------|:-------------|
| Java pacakges | `com.allen_sauer.gwt.dragdrop.client.`... | `com.allen_sauer.gwt.dnd.client.`... | Allows for coexistance of 1.x and 2.x APIs in a single project. |
| Jar file | `gwt-dragdrop-<version>.jar` | `gwt-dnd-<version>.jar` | Consistency with `gwt-dnd` project name. |
| GWT Module name | `com.allen_sauer.gwt.dragdrop.DragAndDrop` | `com.allen_sauer.gwt.dnd.gwt-dnd` | Consistency with `gwt-dnd` project name. |
| Your GWT Module XML File | `<inherits name='com.allen_sauer.gwt.dragdrop.DragAndDrop'/>` | `<inherits name='com.allen_sauer.gwt.dnd.gwt-dnd'/>` | Reflects new module name. |

  * ### Removed CSS Style Names ###
| **Class** | **CSS Style Name** | **Comments** |
|:----------|:-------------------|:-------------|
| `AbstractDropController` | `dragdrop-engage` | The legacy CSS style name `dragdrop-engage` is no longer applied. However, `dragdrop-dropTarget` and `dragdrop-dropTarget-engage` are still applied. |
| `AbsolutePositionDropController` | `dragdrop-absolute-positioning-drop-target` | No longer applied. |
| `GridConstrainedDropController` | `dragdrop-grid-constrained-drop-target` | No longer applied. |
| `NoOverlapDropController` | `dragdrop-no-overlap-drop-target` | No longer applied. |




  * ### New Methods of Interest ###
| **Class** | **Method Signature** | **Comments** |
|:----------|:---------------------|:-------------|
| `DragController` interface | `void resetCache()` |  Reset the internal drop controller (drop target) cache which is initialized by `dragStart(Widget)`. This method should be called when a drop target's size and/or location changes, or when drop target eligibility changes. |
| `DragController` interface | `boolean getBehaviorBoundaryPanelDrop()`, `void setBehaviorBoundaryPanelDrop(boolean)` | Whether dropping on the boundary panel is permitted. Was `setConstrainWidgetToBoundaryPanel(boolean)` in previously releases. |
| `DragController` interface | `boolean getBehaviorConstrainedToBoundaryPanel()`, `void setBehaviorConstrainedToBoundaryPanel(boolean)` | Whether the draggable should be constrained to the boundary panel during dragging. |
| `DragController` interface | `int getBehaviorDragStartSensitivity()`, `void setBehaviorDragStartSensitivity(int)` | Number of pixels the mouse must be moved either horizontally or vertically before dragging begins. |
| `DragController` interface | `boolean getBehaviorMultipleSelection()`, `setBehaviorMultipleSelection(boolean)`, `void clearSelection()`, `void toggleSelection(Widget)` | Enabled/Disable/control multiple selections via `CTRL`/`META`-click. |
| `DragController` interface | `void dragMove()` | Called during dragging when the mouse is moved. |
| `PickupDragController` | `boolean getBehaviorDragProxy()`, `void setBehaviorDragProxy(boolean)` | Whether a drag proxy should be used. |
| `AbstractIndexedDropController` | `protected abstract LocationWidgetComparator getLocationWidgetComparator()` | See implementing classes for examples. |




  * ### Breaking API Changes - Modified Method Signatures ###
_Where possible, the old method has been marked as `deprecated`, then implementation in the first implementing abstract base class has been made `final`, and the method body throws `UnsupportedOperationException`. The latter ensures that existing subclasses are updated to use the new 2.x API._

| **Class** | **Old Signature** | **New Signature** | **Comments** |
|:----------|:------------------|:------------------|:-------------|
| `DragController` interface | `void previewDragStart(Widget)` | `void previewDragStart()` | Information is available via the current `DragContext`. |
| `DragController` interface | `void dragStart(Widget)` | `void dragStart()` | Information is available via the current `DragContext`. |
| `DragController` interface | `void previewDragEnd(Widget, Widget)` | `void previewDragEnd()` | Information is available via the current `DragContext`. |
| `DragController` interface | `void dragEnd(Widget, Widget)` | `void dragEnd()` | Information is available via the current `DragContext`. |
| `PickupDragController` | `Widget maybeNewDraggableProxy(Widget)` | `Widget newDragProxy(DragContext)` | Now only called when `getBehaviorDragProxy()` returns `true`. |
| `DropControler` interface | `void onEnter(Widget, Widget, DragController)` | `void onEnter(DragContext)` | Information is available via the current `DragContext`. |
| `DropControler` interface | `void onMove(Widget, Widget, DragController)` | `void onMove(DragContext)` | Information is available via the current `DragContext`. |
| `DropControler` interface | `void onPreviewDrop(Widget, Widget, DragController)` | `void onPreviewDrop(DragContext)` | Information is available via the current `DragContext`. |
| `DropControler` interface | `void onDrop(Widget, Widget, DragController)` | `void onDrop(DragContext)` | Information is available via the current `DragContext`. |
| `DropControler` interface | `void onLeave(Widget, DragController)` | `void onLeave(DragContext)` | Information is available via the current `DragContext`. |




  * ### Breaking API Changes - Methods Relocated within Class Hierarchy ###
| **Old Location** | **New Location** | **Old Signature** | **New Signature** | **Comments** |
|:-----------------|:-----------------|:------------------|:------------------|:-------------|
| `DragController` interface | `PickupDragController` | `BoundaryDropController newBoundaryDropController(AbsolutePanel, boolean)` | `protected BoundaryDropController newBoundaryDropController(AbsolutePanel, boolean)` | Note: Method **visibility changed** in addition to the relocation. |
| `DragController` interface | `PickupDragController` | `void registerDropController(DropController)` | (unchanged) | Drag-and-drop behavior is represented by `PickupDragController` whereas `DragController` may be used for resizing of widgets, activating slider widgets, etc. |
| `DragController` interface | `PickupDragController` | `void unregisterDropController(DropController)` | (unchanged) | Drag-and-drop behavior is represented by `PickupDragController` whereas `DragController` may be used for resizing of widgets, activating slider widgets, etc. |
| `DragController` interface | `PickupDragController` | `void restoreDraggableLocation(Widget)` | `protected void restoreSelectedWidgetsLocation()` | New method restores locations of all currently selected widgets. |
| `DragController` interface | `PickupDragController` | `void restoreDraggableStyle(Widget)` | `protected void restoreSelectedWidgetsStyle()` | New method restores style for all currently selected widgets. |
| `DragController` interface | `PickupDragController` | `void saveDraggableLocationAndStyle(Widget)` | `protected void saveSelectedWidgetsLocationAndStyle()` | New method saves information for all currently selected widgets. |



  * ### Breaking API Changes - Removed Methods ###
| **Class** | **Method Signature** | **Comments** |
|:----------|:---------------------|:-------------|
| `DragController` interface | `Widget getMovableWidget()` | No longer part of the API due to much of the `MouseDragHandler` implementation having moved to `PickupDragController`. |
| `DragController` interface | `void notifyDragEnd(DragEndEvent)` | No longer part of the API. Notifications are now sent directly by `AbstractDragController#dragEnd`. |
| `DragController` interface | `DropController getIntersectDropController(Widget)` | This implementation detail is no longer exposed. |
| `AbstractDragController` | `protected DropControllerCollection getDropControllerCollection()` | This implementation detail is no longer exposed. To alter drop target selection behavior, subclasses should override `registerDropController(DropController)`, `unregisterDropController(DropController)`, `resetCache()`. They may wish to implement their own version of a `DropControllerCollection`, to be used in these overridden methods. |
| `DropController` interface | `String getDropTargetStyleName()` | No longer part of the API. Selectively apply your own CSS style names instead. |
| `AbstractDropController` | `public DragController getCurrentDragController()` | No longer part of the API. See the current `DragContext` for this information. |
| `AbstractDropController` | `DragEndEvent makeDragEndEvent(Widget, Widget, DragController)` | No longer part of the API as `DragEndEvent` now always simply wraps the current `DragContext`. |
| `AbstractPositioningDropController` | `Widget getPositioner()` | No longer a part of the API. Multiple positioners are handled internally by the `DropController`. |
| `AbstractPositioningDropController` | `Widget newPositioner(Widget)` | No longer a part of the API. Multiple positioners are handled internally by the `DropController`. |
| `AbsolutePositionDropController` | `DropTargetInfo getDropTargetInfo()` | No longer part of the API. You may find the current `DragContext` useful. |
| `AbsolutePositionDropController` | `Location getConstrainedLocation(Widget, Widget, Widget)` | This implementation detail is no longer part of the API.|


  * ### Breaking API Changes - Removed Classes ###
| **Class** | **Comments** |
|:----------|:-------------|
| `IndexedDragEndEvent` | Use `DragEndEvent` instead. |
| `AbsolutePositionDragEndEvent` | Use `DragEndEvent` instead. |
| `MouseDragHandler` | Implemention class is no longer exposed. |
| `DeferredMoveCommand` | Implemention class is no longer exposed. |
| `DropControllerCollection` | Implemention class is no longer exposed. |
| `DropTargetInfo` | Obsolete implementation class. |
| `NoOverlapDropController` | This somewhat contrived example has been removed. |
| `VetoDropException` | Use `VetoDragException` instead. |



  * ### Deprecated Constants ###
_Use cases involving these deprecated constants probably included selectively removing selected CSS style names at runtime under specific drag conditions. The recommended alternative approach is to selectively add your own CSS style names at runtime._

| **Class** | **Constant** | **Comments** |
|:----------|:-------------|:-------------|
| `AbstractDragController` | `protected static final String CSS_DRAGGABLE = "dragdrop-draggable"` | This constant is now deprecated and will no longer be exposed in a future release. |
| `AbstractDragController` | `protected static final String CSS_DRAGGING = "dragdrop-dragging"` | This constant is now deprecated and will no longer be exposed in a future release. |
| `AbstractDragController` | `protected static final String CSS_HANDLE = "dragdrop-handle"` | This constant is now deprecated and will no longer be exposed in a future release. |
| `AbstractDropController` | `protected static final String CSS_DROP_TARGET_ENGAGE = "dragdrop-dropTarget-engage"` | This constant is now deprecated and will no longer be exposed in a future release. |
| `PickupDragController` | `protected static final String CSS_MOVABLE_PANEL = "dragdrop-movable-panel"` | This constant is now deprecated and will no longer be exposed in a future release. |
| `PickupDragController` | `protected static final String CSS_PROXY = "dragdrop-proxy"` | This constant is now deprecated and will no longer be exposed in a future release. |



  * ### Deprecated Methods ###
_These methods have been deprecated and delegate to their new counterparts._

| **Class** | **Old Method (deprecated)** | **New Method** | **Comments** |
|:----------|:----------------------------|:---------------|:-------------|
| `DragController` interface | `void setConstrainWidgetToBoundaryPanel(boolean)` | `void setBehaviorConstrainedToBoundaryPanel(boolean)` | Modified method name to align multiple `setBehavior*()` configuration methods.  |
| `PickupDragController` | `public boolean isDragProxyEnabled()` | `public boolean getBehaviorDragProxy()` | Modified method name to align multiple `getBehvaior*()` configuration methods. |
| `PickupDragController` | `public void setDragProxyEnabled(boolean)` | `public void setBehaviorDragProxy(boolean)` | Modified method name to align multiple `setBehvaior*()` configuration methods. |



  * ### New Classes of Interest ###
    * `DragContext`