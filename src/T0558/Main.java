package T0558;

public class Main {
    public static void main(String[] args) {

    }
}

class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;

    public Node() {
    }

    public Node(boolean _val, boolean _isLeaf, Node _topLeft, Node _topRight, Node _bottomLeft, Node _bottomRight) {
        val = _val;
        isLeaf = _isLeaf;
        topLeft = _topLeft;
        topRight = _topRight;
        bottomLeft = _bottomLeft;
        bottomRight = _bottomRight;
    }
}

class Solution {
    public Node intersect(Node quadTree1, Node quadTree2) {
        return intersectCore(quadTree1, quadTree2);
    }

    public Node intersectCore(Node t1, Node t2) {
        if (t1.isLeaf && t2.isLeaf) {
            return new Node(t1.val || t2.val, true, null, null, null, null);
        }

        if (!t1.isLeaf && !t2.isLeaf) {
            Node tmp = new Node(false, false,
                    intersectCore(t1.topLeft, t2.topLeft),
                    intersectCore(t1.topRight, t2.topRight),
                    intersectCore(t1.bottomLeft, t2.bottomLeft),
                    intersectCore(t1.bottomRight, t2.bottomRight));
            if (tmp.topLeft.isLeaf
                    && tmp.topRight.isLeaf
                    && tmp.bottomLeft.isLeaf
                    && tmp.bottomRight.isLeaf) {
                if (tmp.topLeft.val
                        && tmp.topRight.val
                        && tmp.bottomLeft.val
                        && tmp.bottomRight.val) {
                    return new Node(true, true, null, null, null, null);
                }
                if (!tmp.topLeft.val
                        && !tmp.topRight.val
                        && !tmp.bottomLeft.val
                        && !tmp.bottomRight.val) {
                    return new Node(false, true, null, null, null, null);
                }
            }
            return tmp;
        }

        if (t1.isLeaf && t1.val) {
            return new Node(true, true, null, null, null, null);
        }
        if (t2.isLeaf && t2.val) {
            return new Node(true, true, null, null, null, null);
        }
        return t1.isLeaf ? t2 : t1;
    }
}

/*
    不知道为什么就是错的，不想在修正这份代码了
 */
class Solution2 {
    public Node intersect(Node quadTree1, Node quadTree2) {
        return intersectCore(quadTree1, quadTree2);
    }

    private Node intersectCore(Node tree1, Node tree2) {
        if (!tree1.isLeaf && !tree2.isLeaf) {
            Node tmp = new Node();
            tmp.topLeft = intersectCore(tree1.topLeft, tree2.topLeft);
            tmp.topRight = intersectCore(tree1.topRight, tree2.topRight);
            tmp.bottomLeft = intersectCore(tree1.bottomLeft, tree2.bottomLeft);
            tmp.bottomRight = intersectCore(tree1.bottomRight, tree2.bottomRight);
            if (tmp.topLeft.isLeaf && tmp.topRight.isLeaf && tmp.bottomLeft.isLeaf && tmp.bottomRight.isLeaf) {
                if (tmp.topLeft.val && tmp.topRight.val && tmp.bottomLeft.val && tmp.bottomRight.val) {
                    tmp = new Node();
                    tmp.isLeaf = true;
                    tmp.val = true;
                    return tmp;
                }
                if (!tmp.topLeft.val && !tmp.topRight.val && !tmp.bottomLeft.val && !tmp.bottomRight.val) {
                    tmp = new Node();
                    tmp.isLeaf = true;
                    tmp.val = false;
                    return tmp;
                }
            }
            return tmp;
        }

        if (tree1.isLeaf && tree2.isLeaf) {
            Node node = new Node();
            node.isLeaf = true;
            node.val = tree1.val || tree2.val;
            return node;
        }

        if (tree1.isLeaf) {
            if (tree1.val = true) {
                Node node = new Node();
                node.isLeaf = true;
                node.val = true;
                return node;
            } else {
                return tree1;
            }
        }

        if (tree2.val = true) {
            Node node = new Node();
            node.isLeaf = true;
            node.val = true;
            return node;
        } else {
            return tree2;
        }
    }

    private Node intersectCore(Node tree) {
        if (tree.isLeaf) {
            Node node = new Node();
            node.isLeaf = true;
            node.val = tree.val;
            return node;
        } else {
            Node tmp = new Node();
            tmp.isLeaf = false;
            tmp.topLeft = intersectCore(tree);
            tmp.topRight = intersectCore(tree);
            tmp.bottomLeft = intersectCore(tree);
            tmp.bottomRight = intersectCore(tree);
            if (tmp.topLeft.isLeaf) {
                if (tmp.topLeft.val && tmp.topRight.val && tmp.bottomLeft.val && tmp.bottomRight.val) {
                    tmp = new Node();
                    tmp.isLeaf = true;
                    tmp.val = true;
                    return tmp;
                }
                if (!tmp.topLeft.val && !tmp.topRight.val && !tmp.bottomLeft.val && !tmp.bottomRight.val) {
                    tmp = new Node();
                    tmp.isLeaf = true;
                    tmp.val = false;
                    return tmp;
                }
            }
            return tmp;
        }
    }
}