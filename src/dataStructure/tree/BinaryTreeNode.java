package dataStructure.tree;

/**
 * 
 * @Title: TreeNode.java
 * @Description: <br>
 * <br>
 *               二叉树节点数据结构
 * @Created on 2016年3月17日 下午3:57:42
 * @author yangkai
 * @version 1.0
 */
public class BinaryTreeNode {

    public int key; // 层次编码,树小标index

    public String data; // 数据域

    public boolean isVisted; // 节点是否被访问

    public BinaryTreeNode leftChild; // 左子节点

    public BinaryTreeNode rightChild; // 右子节点
    
    public int leftMax; //左子树最长距离
    public int rightMax; //右子树最长距离

    public BinaryTreeNode() {
        key = 0;
        data = null;
        isVisted = false;
        leftChild = null;
        rightChild = null;
    }

    public BinaryTreeNode(int key, String data) {
        this.key = key;
        this.data = data;
        this.isVisted = false;
        this.leftChild = null;
        this.rightChild = null;
    }

}
