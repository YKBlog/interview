package dataStructure.tree;

/**
 * 
 * @Title: BinaryTreeTest.java
 * @Description: <br>
 * <br>
 *               二叉树测试
 * @Created on 2016年3月17日 下午5:45:59
 * @author yangkai
 * @version 1.0
 */
public class BinaryTreeTest {

    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();
        bt.createTree(bt.root);
        System.out.println("tree size:" + bt.size());
        System.out.println("tree height:" + bt.height());
        // testTraverse(bt);
        //testSearch(bt, 20);
        int result = bt.getMaxSide1(bt.root);
        System.out.println(result);
        //bt.getMaxSide(bt.root);
        System.out.println(bt.maxSide);
        
    }

    /**
     * 测试遍历
     * 
     * @param bt
     */
    public static void testTraverse(BinaryTree bt) {
        System.out.println("---------递归遍历------");
        System.out.println("**********[ABDECF]前序遍历*********");
        bt.frontOrder(bt.root);
        System.out.println("**********[DBEACF]中序遍历*********");
        bt.middleOrder(bt.root);
        System.out.println("**********[DEBFCA]后序遍历*********");
        bt.backOrder(bt.root);

        System.out.println("tree root:" + bt.getRootNode().data);
        System.out.println("tree root left child:" + bt.getLeftChildNode(bt.root).data);
        System.out.println("tree root right right child:" + bt.getRightChildNode(bt.root).rightChild.data);

        System.out.println("---------非递归遍历------");
        System.out.println("**********[ABDECF]前序遍历*********");
        bt.preOrder(bt.root);
        System.out.println("**********[DBEACF]中序遍历*********");
        bt.inOrder(bt.root);
        System.out.println("**********[DEBFCA]后序遍历*********");
        bt.postOrder(bt.root);
    }

    /**
     * 测试查找
     * 
     * @param bt
     */
    public static void testSearch(BinaryTree bt, int key) {
        BinaryTreeNode node1 = bt.searchNode(key);
        System.out.println("非递归："+(node1 != null ? node1.key + "--" + node1.data : null));
        BinaryTreeNode node2 = bt.searchNodeForRecursion(key);
        System.out.println("递归："+(node2 != null ? node2.key + "--" + node2.data : null));
    }
}
