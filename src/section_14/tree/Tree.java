package section_14.tree;

public class Tree {
    private String key;
    private int val;
    private Tree left, right;
    public Tree(String k, int v, Tree l, Tree r) {
        key = k;
        val = v;
        left = l;
        right = r;
    }

    public String getKey() {
        return key;
    }

    public int getVal() {
        return val;
    }

    public Tree getLeft() {
        return left;
    }

    public Tree getRight() {
        return right;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public void setLeft(Tree left) {
        this.left = left;
    }

    public void setRight(Tree right) {
        this.right = right;
    }
}
