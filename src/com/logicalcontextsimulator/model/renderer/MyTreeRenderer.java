/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.logicalcontextsimulator.model.renderer;

import com.logicalcontextsimulator.model.context.AbstractContext;
import java.awt.Component;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;

/**
 * Class provides different Icons for the Tree for different context types.
 * @author MHL
 */
public class MyTreeRenderer extends DefaultTreeCellRenderer {
    /**
	 * 
	 */
	private static final long serialVersionUID = -7933837893159876268L;
	private DefaultMutableTreeNode node;

    public MyTreeRenderer() {
    }

    @Override
    public Component getTreeCellRendererComponent(
                        JTree tree,
                        Object value,
                        boolean sel,
                        boolean expanded,
                        boolean leaf,
                        int row,
                        boolean hasFocus) {

        super.getTreeCellRendererComponent(
                        tree, value, sel,
                        expanded, leaf, row,
                        hasFocus);
        
        node = (DefaultMutableTreeNode) value;

        if(node.getUserObject() instanceof AbstractContext){
            setIcon(((AbstractContext) node.getUserObject()).getLeafIcon());
            setText(((AbstractContext) node.getUserObject()).getName());
        }else{
            super.getTreeCellRendererComponent(
                        tree, value, sel,
                        expanded, leaf, row,
                        hasFocus);
        }
        
        
        return this;
    }
}
