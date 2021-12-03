package list;

import java.util.concurrent.ThreadLocalRandom;

class Skiplist {
    private static int DEFAULT_MAX_LEVEL = 12;
    private static int BRANCHING_FACTOR = 4;
    Node head = new Node(null, DEFAULT_MAX_LEVEL);
    int currentLevel = 0;

    public boolean search(int target) {
        Node searchNode = head;
        for (int i = currentLevel; i >= 0; i--) {
            searchNode = findLevel(searchNode, i, target);
            if (searchNode.next[i] != null && searchNode.next[i].value == target) {
                return true;
            }
        }
        return false;
    }

    public void add(int num) {
        int level = randomLevel();
        Node updateNode = head;
        Node newNode = new Node(num, level + 1);
        // 计算出当前num 索引的实际层数，从该层开始添加索引
        for (int i = currentLevel; i >= 0; i--) {
            //找到本层最近离num最近的list
            updateNode = findLevel(updateNode, i, num);
            if (updateNode.next[i] != null && updateNode.next[i].value == num) {
                break;
            }
            if (i <= level) {
                if (updateNode.next[i] == null) {
                    updateNode.next[i] = newNode;
                } else {
                    Node temp = updateNode.next[i];
                    updateNode.next[i] = newNode;
                    newNode.next[i] = temp;
                }
            }
        }
        if (level > currentLevel) {
            for (int i = currentLevel + 1; i <= level; i++) {
                head.next[i] = newNode;
            }
            currentLevel = level;
        }
    }

    public boolean del(int num) {
        boolean flag = false;
        Node searchNode = head;
        for (int i = currentLevel; i >= 0; i--) {
            searchNode = findLevel(searchNode, i, num);
            if (searchNode.next[i] != null && searchNode.next[i].value == num) {
                //找到该层中该节点
                searchNode.next[i] = searchNode.next[i].next[i];
                flag = true;
                continue;
            }
        }
        return flag;
    }

    private Node findLevel(Node node, int level, int value) {
        while ((node.next[level]) != null && node.next[level].value < value) {
            node = node.next[level];
        }
        return node;
    }

    private static int randomLevel() {
        int level = 0;
        while (ThreadLocalRandom.current().nextInt() % BRANCHING_FACTOR == 0 && level < DEFAULT_MAX_LEVEL - 1) {
            level++;
        }
        return level;
    }

    class Node {
        Integer value;
        Node[] next;

        public Node(Integer value, int size) {
            this.value = value;
            this.next = new Node[size];
        }
    }

    @Override
    public String toString() {
        StringBuffer buffer = new StringBuffer();
        for (int i = currentLevel; i >= 0; i--) {
            buffer.append("level:" + i);
            Node node = head.next[i];
            while (node != null) {
                buffer.append(" ");
                buffer.append(node.value);
                buffer.append(",");
                node = node.next[i];
            }
            buffer.deleteCharAt(buffer.length() - 1);
            buffer.append("\n");
        }
        return buffer.toString();
    }

    public static void main(String[] args) {
        Skiplist sp = new Skiplist();
        for (int i = 0; i < 100; i++) {
            sp.add(ThreadLocalRandom.current().nextInt(10000));
        }
        System.out.println(sp);
    }
}
