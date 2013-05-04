package test;

import javax.swing.JTree;
import java.awt.dnd.DragGestureListener;
import java.awt.dnd.DragSourceListener;
import java.awt.dnd.DragSourceDragEvent;
import java.awt.dnd.DragSourceEvent;
import java.awt.dnd.DragSourceDropEvent;
import java.awt.dnd.DragGestureEvent;
import java.awt.dnd.DragSource;
import javax.swing.tree.DefaultMutableTreeNode;
import java.awt.datatransfer.StringSelection;


public class DragSourceTree
    extends JTree
    implements DragGestureListener, DragSourceListener {
  private DragSource dragSource = null;
  /**
   * Construct the source tree
   */
  public DragSourceTree() {
    super();
    dragSource = DragSource.getDefaultDragSource();
    dragSource.createDefaultDragGestureRecognizer(this,
                                                  java.awt.dnd.DnDConstants.
                                                  ACTION_COPY_OR_MOVE, this);
  }
  /**
   * Construct the source tree
   * @param treeNode DefaultMutableTreeNode
   */
  public DragSourceTree(DefaultMutableTreeNode treeNode) {
    super(treeNode);
    dragSource = DragSource.getDefaultDragSource();
    dragSource.createDefaultDragGestureRecognizer(this,
                                                  java.awt.dnd.DnDConstants.
                                                  ACTION_COPY_OR_MOVE, this);
  }

  /**
   * dragGestureRecognized
   *
   * @param dge DragGestureEvent
   */
  public void dragGestureRecognized(DragGestureEvent dge) {
    java.awt.Cursor cursor = null;
    cursor = DragSource.DefaultCopyDrop; //set cursor
    java.awt.Point jap = dge.getDragOrigin(); //drag point
    int x = (int) jap.getX();
    int y = (int) jap.getY();
    javax.swing.tree.TreePath tp = this.getPathForLocation(x, y); //get drag node path
    if (tp != null) {
      DefaultMutableTreeNode node1 = (DefaultMutableTreeNode)
          tp.getLastPathComponent(); //get drag node
      serializableNode(node1); //Serializable node object
    }
    //event start    
    dge.startDrag(cursor, new StringSelection("drag"), this);

  }

  /**
   * dragEnter
   *
   * @param dsde DragSourceDragEvent
   */
  public void dragEnter(DragSourceDragEvent dsde) {
  }

  /**
   * dragOver
   *
   * @param dsde DragSourceDragEvent
   */
  public void dragOver(DragSourceDragEvent dsde) {
  }

  /**
   * dropActionChanged
   *
   * @param dsde DragSourceDragEvent
   */
  public void dropActionChanged(DragSourceDragEvent dsde) {
  }

  /**
   * dragDropEnd
   *
   * @param dsde DragSourceDropEvent
   */
  public void dragDropEnd(DragSourceDropEvent dsde) {
  }

  /**
   * dragExit
   *
   * @param dse DragSourceEvent
   */
  public void dragExit(DragSourceEvent dse) {
  }
  /**
   *Serializable node 
   *
   * @param node DefaultMutableTreeNode
   */
  private void serializableNode(DefaultMutableTreeNode node) {
    try {
      java.io.FileOutputStream objfile = new java.io.FileOutputStream(
          "DragNode.OBJ");
      java.io.ObjectOutputStream p = new java.io.ObjectOutputStream(objfile);
      p.writeObject(node);
      p.flush();
      objfile.close();
    }
    catch (java.io.IOException e) {
      System.out.println(e.toString());
    }

  }
}