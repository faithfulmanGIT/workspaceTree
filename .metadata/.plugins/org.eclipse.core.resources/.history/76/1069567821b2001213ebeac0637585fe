package test;
import javax.swing.JTree;
import java.awt.dnd.DropTargetListener;
import java.awt.dnd.DropTargetDragEvent;
import java.awt.dnd.DropTargetDropEvent;
import java.awt.dnd.DropTargetEvent;
import java.awt.dnd.DropTarget;
import java.io.*;
import java.io.*;
import javax.swing.tree.DefaultMutableTreeNode;



public class DragTargetTree
    extends JTree
    implements DropTargetListener {
  /**
   * Construct the target tree
   */
  public DragTargetTree() {
    super();
    DropTarget dropTarget = new DropTarget(this,
                                           java.awt.dnd.DnDConstants.
                                           ACTION_COPY_OR_MOVE, this);
  }
  /**
   *  Construct the target tree
   * @param treeNode DefaultMutableTreeNode
   */
  public DragTargetTree(DefaultMutableTreeNode treeNode) {
    super(treeNode);
    DropTarget dropTarget = new DropTarget(this,
                                           java.awt.dnd.DnDConstants.
                                           ACTION_COPY_OR_MOVE, this);
  }


  /**  
   * dragEnter
   *
   * @param dtde DropTargetDragEvent
   */
  public void dragEnter(DropTargetDragEvent dtde) {
  }

  /**
   * dragOver
   *
   * @param dtde DropTargetDragEvent
   */
  public void dragOver(DropTargetDragEvent dtde) {
  }

  /**
   * dropActionChanged
   *
   * @param dtde DropTargetDragEvent
   */
  public void dropActionChanged(DropTargetDragEvent dtde) {
  }

  /**
   * drop
   *
   * @param dtde DropTargetDropEvent
   */
  public void drop(DropTargetDropEvent dtde) {
    dtde.acceptDrop(java.awt.dnd.DnDConstants.ACTION_COPY); //accept drop
    java.awt.Point ap = dtde.getLocation(); // get event point
    int x = (int) ap.getX();
    int y = (int) ap.getY();
    javax.swing.tree.DefaultMutableTreeNode parnode;
    javax.swing.tree.TreePath tp = this.getPathForLocation(x, y);
    if (tp != null) {
        try {
        //get drop tree node with treepath
        javax.swing.tree.DefaultMutableTreeNode no1 =
            (javax.swing.tree.DefaultMutableTreeNode) tp.getLastPathComponent();
        parnode = no1;
        int index = parnode.getChildCount();
        // get drop tree mode
        javax.swing.tree.DefaultTreeModel tm =
            (javax.swing.tree.DefaultTreeModel)this.getModel();
        javax.swing.tree.DefaultMutableTreeNode node2 =
            new javax.swing.tree.DefaultMutableTreeNode();
        node2 = readNode();
        tm.insertNodeInto(node2, parnode, index);
      }
      catch (java.lang.Exception e) {
        System.out.println(e.toString());
      }
    }

  }

  /**
   * dragExit
   *
   * @param dte DropTargetEvent
   */
  public void dragExit(DropTargetEvent dte) {
  }

  /**
   * 
   * read the node
   * @return DefaultMutableTreeNode
   */ 
  private DefaultMutableTreeNode readNode() {

    FileInputStream objfile = null;
    try {
      objfile = new java.io.FileInputStream("DragNode.OBJ");
      ObjectInputStream q = new ObjectInputStream(objfile);
      DefaultMutableTreeNode node = (DefaultMutableTreeNode) q.readObject();
      return node;
    }
    catch (Exception ex) {
      return null;
    }
  }
}