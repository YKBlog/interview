package dataStructure.tree;

import java.util.Stack;

public class BinaryTree {

    public BinaryTreeNode root = null;

    public BinaryTree() {
        root = createTreeNodeFactory(30, "root:A");
    }

    /**
     * 创建二叉树的工厂方法
     * 
     * @param key
     * @param data
     * @return
     */
    public BinaryTreeNode createTreeNodeFactory(int key, String data) {
        BinaryTreeNode node = new BinaryTreeNode(key, data);
        return node;
    }

    /**
     * 创建一个二叉树
     * 
     * <pre>
     *         root:A
     *     B          C
     * D      E           F
     * </pre>
     * 
     * @param root
     *            根节点
     */
    public void createTree(BinaryTreeNode root) {
        root.leftChild = createTreeNodeFactory(20, "B");
        root.rightChild = createTreeNodeFactory(40, "C");
        root.leftChild.leftChild = createTreeNodeFactory(10, "D");
        root.leftChild.rightChild = createTreeNodeFactory(25, "E");
        root.rightChild.rightChild = createTreeNodeFactory(45, "F");
    }

    /**
     * 判断是否为空树
     * 
     * @return
     */
    public boolean isEmpty() {
        return isEmpty(root);
    }

    /**
     * 获取树的高度
     * 
     * @return
     */
    public int height() {
        return height(root);
    }

    /**
     * 获取树节点个数
     * 
     * @return
     */
    public int size() {
        return size(root);
    }

    /**
     * 判断子树是否为空
     * 
     * @return
     */
    public boolean isEmpty(BinaryTreeNode subTree) {
        return subTree == null;
    }

    /**
     * 递归子树，获取整棵树的高度
     * 
     * @param subTree
     * @return
     */
    public int height(BinaryTreeNode subTree) {
        if (isEmpty(subTree))
            return 0;
        int left = height(subTree.leftChild);
        int right = height(subTree.rightChild);
        return left < right ? (left + 1) : (right + 1);
    }

    /**
     * 递归子树，获取整棵树的节点数量
     * 
     * @param subTree
     * @return
     */
    public int size(BinaryTreeNode subTree) {
        if (isEmpty(subTree))
            return 0;
        return 1 + size(subTree.leftChild) + size(subTree.rightChild);
    }

    /**
     * <pre>
     * -----------------------------获取二叉树的各个节点--------------------------------------
     * </re>
     */
    /**
     * 获取root节点
     * 
     * @return
     */
    public BinaryTreeNode getRootNode() {
        return root;
    }

    /**
     * 获取指定node的左子节点
     * 
     * @param node
     * @return
     */
    public BinaryTreeNode getLeftChildNode(BinaryTreeNode node) {
        return isEmpty(node) ? null : node.leftChild;
    }

    /**
     * 获取指定node的右子节点
     * 
     * @param node
     * @return
     */
    public BinaryTreeNode getRightChildNode(BinaryTreeNode node) {
        return isEmpty(node) ? null : node.rightChild;
    }

    /**
     * 获取当前节点的父节点
     * 
     * @param node
     * @return
     */
    public BinaryTreeNode getParentNode(BinaryTreeNode node) {
        return (isEmpty(root) || root == node) ? null : parent(root, node);
    }

    private BinaryTreeNode parent(BinaryTreeNode subTree, BinaryTreeNode node) {
        if (isEmpty(subTree))
            return null;
        if (subTree.leftChild == node || subTree.rightChild == node)
            return subTree;
        BinaryTreeNode parent;
        // 先在左子树查找parent，没有再去右子树查找
        if (isEmpty(parent = parent(subTree.leftChild, node))) // 递归左子树搜索
            return parent;
        else
            return parent(subTree.rightChild, node);
    }

    /**
     * <pre>
     *  -----------------------------递归和非递归遍历二叉树--------------------------------------
     * 一棵非空的二叉树由根结点及左、右子树这三个基本部分组成。因此，在任一给定结点上，可以按某种次序执行三个操作：
     *      　（1）访问结点本身(N)，
     *      　（2）遍历该结点的左子树(L)，
     *      　（3）遍历该结点的右子树(R)。
     *  以上三种操作有六种执行次序：
     *      　NLR、LNR、LRN、NRL、RNL、RLN。
     *  注意：
     *      前三种次序与后三种次序对称，故只讨论先左后右的前三种次序。
     *  　　 由于被访问的结点必是某子树的根，所以N(Node)、L(Left subtlee)和R(Right subtree)又可解释为根、根的左子树和根的右子树。
     *       NLR、LNR和LRN分别又称为先根(序)遍历、中根(序)遍历和后根(序)遍历
     * </re>
     */

    public void visted(BinaryTreeNode subTree) {
        System.out.println("key:" + subTree.key + " --- data:" + subTree.data);
    }

    /**
     * 递归实现 前序遍历
     * 
     * @param subTree
     */
    public void frontOrder(BinaryTreeNode subTree) {
        if (!isEmpty(subTree)) {
            visted(subTree);
            frontOrder(subTree.leftChild);
            frontOrder(subTree.rightChild);
        }
    }

    /**
     * 递归实现 中序遍历
     * 
     * @param subTree
     */
    public void middleOrder(BinaryTreeNode subTree) {
        if (!isEmpty(subTree)) {
            middleOrder(subTree.leftChild);
            visted(subTree);
            middleOrder(subTree.rightChild);
        }
    }

    /**
     * 递归实现 后序遍历
     * 
     * @param subTree
     */
    public void backOrder(BinaryTreeNode subTree) {
        if (!isEmpty(subTree)) {
            backOrder(subTree.leftChild);
            backOrder(subTree.rightChild);
            visted(subTree);
        }
    }

    /**
     * 非递归实现 前序遍历
     * 
     * @param subTree
     */
    public void preOrder(BinaryTreeNode subTree) {
        Stack<BinaryTreeNode> stack = new Stack<BinaryTreeNode>();
        if (!isEmpty(subTree)) {
            stack.push(subTree);
            while (!stack.empty()) {
                subTree = stack.pop();
                visted(subTree);
                // 利用stack后入先出的原理 先压入右子节点，这样取出的时候就可以先取出左子节点了
                if (!isEmpty(subTree.rightChild))
                    stack.push(subTree.rightChild);
                if (!isEmpty(subTree.leftChild))
                    stack.push(subTree.leftChild);
            }
        }
    }

    /**
     * 非递归实现 中序遍历
     * 
     * @param subTree
     */
    public void inOrder(BinaryTreeNode subTree) {
        Stack<BinaryTreeNode> stack = new Stack<BinaryTreeNode>();
        BinaryTreeNode node = subTree;
        while (node != null || stack.size() > 0) {
            while (node != null) { // 存在左子树
                stack.push(node);
                node = node.leftChild;
            }
            node = stack.pop();
            visted(node); // 出栈后输出，肯定是先入后出，即root
            node = node.rightChild;
        }
    }

    /**
     * 非递归实现 后序遍历
     * 
     * @param subTree
     */
    public void postOrder(BinaryTreeNode subTree) {
        Stack<BinaryTreeNode> stack = new Stack<BinaryTreeNode>();
        BinaryTreeNode node = subTree, pre = subTree;
        while (!isEmpty(node) || stack.size() > 0) {
            while (!isEmpty(node)) { // 存在左子树
                stack.push(node);
                node = node.leftChild;
            }
            if (stack.size() > 0) { // 栈非空
                BinaryTreeNode temp = stack.peek().rightChild;
                if (isEmpty(node) || temp == pre) {
                    node = stack.pop();
                    visted(node);
                    pre = node;
                    node = null;
                } else {
                    node = temp;
                }
            }
        }
    }

    /**
     * 非递归<br>
     * 根据指定key查找node；key相当于二叉树排好序的数字值属性
     * 
     * @param key
     * @return
     */
    public BinaryTreeNode searchNode(int key) {
        return searchNode(key, root);
    }

    /**
     * 非递归<br>
     * 根据给定key和root查找node
     * 
     * @param key
     * @param root
     * @return
     */
    public BinaryTreeNode searchNode(int key, BinaryTreeNode root) {
        BinaryTreeNode node = root;
        while (!isEmpty(node)) {
            if (key > node.key)
                node = node.rightChild;
            else if (key < node.key)
                node = node.leftChild;
            else
                return node;
        }
        return node;
    }

    /**
     * 递归<br>
     * 根据指定key查找node；key相当于二叉树排好序的数字值属性
     * 
     * @param key
     * @return
     */
    public BinaryTreeNode searchNodeForRecursion(int key) {
        return searchNodeForRecursion(key, root);
    }

    /**
     * 递归<br>
     * 根据指定key查找node；key相当于二叉树排好序的数字值属性
     * 
     * @param key
     * @return
     */
    public BinaryTreeNode searchNodeForRecursion(int key, BinaryTreeNode root) {
        if (key > root.key) {
            if (!isEmpty(root.rightChild))
                return searchNodeForRecursion(key, root.rightChild);
            else
                return null;
        } else if (key < root.key && !isEmpty(root.leftChild)) {
            if (!isEmpty(root.leftChild))
                return searchNodeForRecursion(key, root.leftChild);
            else
                return null;
        } else {
            return root;
        }
    }


    /**
     * 方法一： <br>
     * 获取最大边长(距离)
     * 
     * @param tree
     * @param maxSide
     *            最大边长(距离)
     * @return
     */
    public int getMaxSide1(BinaryTreeNode tree) {
        int maxSide = 0;
        if (!isEmpty(tree)) {
            maxSide = height(tree.leftChild) + height(tree.rightChild);
            int leftMax = getMaxSide1(tree.leftChild);
            int rightMax = getMaxSide1(tree.rightChild);
            maxSide = leftMax > maxSide ? leftMax : maxSide;
            maxSide = rightMax > maxSide ? rightMax : maxSide;
        }
        return maxSide;
    }

    /**
     * <br>
     * 获取最大边长 <br>
     * 方法二： <br>
     * 缺点：侵入tree结构；在tree上添加左右最大边长
     * 
     * @return
     */

    int maxSide = 0; // 最长边长（距离）

    public void getMaxSide(BinaryTreeNode tree) {
        if (isEmpty(tree))
            return;
        if (isEmpty(tree.leftChild)) {
            tree.leftMax = 0;
        } else {
            getMaxSide(tree.leftChild);
            int temp = 0;
            if (tree.leftChild.leftMax > tree.leftChild.rightMax)
                temp = tree.leftChild.leftMax;
            else
                temp = tree.leftChild.rightMax;
            tree.leftMax = temp + 1;
        }
        if (isEmpty(tree.rightChild)) {
            tree.rightMax = 0;
        } else {
            getMaxSide(tree.rightChild);
            int temp = 0;
            if (tree.rightChild.leftMax > tree.rightChild.rightMax)
                temp = tree.rightChild.leftMax;
            else
                temp = tree.rightChild.rightMax;
            tree.rightMax = temp + 1;
        }
        if ((tree.leftMax + tree.rightMax) > maxSide)
            maxSide = tree.leftMax + tree.rightMax;
    }

}
