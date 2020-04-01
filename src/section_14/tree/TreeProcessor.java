package section_14.tree;

public class TreeProcessor {

    public static void main(String[] args) {
        Tree c = new Tree("c", 98, null, null);
        Tree d = new Tree("d", 99, null, null);
        Tree b = new Tree("b", 100, c, d);

        Tree f = new Tree("f", 922, null, null);
        Tree e = new Tree("e", 981, f, null);

        Tree a = new Tree("a", 97, b, e);

        System.out.println(lookup("e", 4, a));

        update("e", 0, a);
        System.out.println(lookup("e", 4, a));
    }

    public static int lookup(String k, int defaultVal, Tree t) {
        if (t == null) return defaultVal;
        if (k.equals(t.getKey())) return t.getVal();
        return lookup(k, defaultVal, k.compareTo(t.getKey()) < 0 ? t.getLeft() : t.getRight());
    }

    public static Tree update(String k, int newval, Tree t) {
        if (t == null)
            t = new Tree(k, newval, null, null);
        else if (k.equals(t.getKey()))
            t.setVal(newval);
        else if (k.compareTo(t.getKey()) < 0)
            t.setLeft(update(k, newval, t.getLeft()));
        else
            t.setRight(update(k, newval, t.getRight()));

        return t;
    }

    public static Tree fupdate(String k, int newval, Tree t) {
        return (t == null) ?
                new Tree(k, newval, null, null) :
                k.equals(t.getKey()) ?
                        new Tree(k, newval, t.getLeft(), t.getRight()) :
                        k.compareTo(t.getKey()) < 0 ?
                                new Tree(t.getKey(), t.getVal(), fupdate(k, newval, t.getLeft()), t.getRight()) :
                                new Tree(t.getKey(), t.getVal(), t.getLeft(), fupdate(k, newval, t.getRight()));
    }
}
