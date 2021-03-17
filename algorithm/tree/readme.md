树相关文章
1. 二叉搜索树
2. AVL树
3. 2-3树
4. 红黑树

相关问题以及解析
1. 二叉树的先序非递归遍历
思路：
如果当前节点p不为空，访问结点p，并将结点p入栈，并继续访问左子树(直到左子树为空)；
如果当前结点为空，将栈顶元素出栈，并访问栈顶的元素的右子树
```java
static void iterativePre(Node root) {
    Stack<Node> s = new Stack();
    Node p = root;
    while (!s.empty() || p != null) {
        while (p != null) {
            s.push(p);
            System.out.print(p.val + " ");
            p = p.left;
        }
        p = s.pop();
        p = p.right;
    }
}
```
中序遍历和前序遍历基本上类似，后续遍历稍微复杂一点，和前序遍历类似，先用一个栈得到前序的顺序，然后在加入到另一个栈中。
```java
static void iterativePos(Node root) {
    Stack<Node> temp = new Stack(), print = new Stack();
    Node p;
    temp.push(root);
    while (!temp.empty()) {
        p = temp.pop();
        print.push(p);
        if (p.left != null) temp.push(p.left); 
        if (p.right != null) temp.push(p.right);
    }
    while (!print.empty())
        System.out.print(print.pop().val + " ");
}
```
2. 二叉树的层级遍历
思路：从root结点开始，加入队列，访问其左右孩子，同时加入队列，直至队列为空。
```java
static void levelOrder(Node root) {
    if (root == null)
        return;
    Queue<Node> queue = new LinkedList();
    queue.add(root);
    while (!queue.isEmpty()) {
        Node now = queue.poll();
        System.out.print(now.val + " ");
        if (now.left != null) queue.add(now.left);
        if (now.right != null) queue.add(now.right);
    }
}
```
3. 二叉树的镜像
思路：递归
```java
public static void mirror(Node node) {
    if(node != null) {
        Node temp = node.left;
        node.left = node.right;
        node.right = temp;
        mirror(node.left);
        mirror(node.right);
    }
}
```
