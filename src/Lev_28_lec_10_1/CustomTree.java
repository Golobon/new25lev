package Lev_28_lec_10_1;

import java.io.Serializable;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/*
Построй дерево(1)
*/

public class CustomTree extends AbstractList <String> implements Cloneable, Serializable {

    List<Entry<String>> entryList;

    Entry<String> root;

    public CustomTree() {
        entryList = new ArrayList<>();
        this.root = new Entry<>("0");
        entryList.add(root);
    }

    @Override
    public String get(int index) { throw new UnsupportedOperationException(); }

    @Override
    public int size() { return entryList.size() - 1; }

    @Override
    public boolean add(String s) {
        for (Entry<String> x : entryList) {

            if (x.isAvailableToAddChildren()) {

                if (x.availableToAddLeftChildren) {
                    x.leftChild = new Entry<>(s);
                    x.leftChild.parent = x;
                    entryList.add(x.leftChild);
                    x.availableToAddLeftChildren = false;
                    return true; }

                if (x.availableToAddRightChildren) {
                    x.rightChild = new Entry<>(s);
                    x.rightChild.parent = x;
                    entryList.add(x.rightChild);
                    x.availableToAddRightChildren = false;
                    return true; } } }

        return false; }

    @Override
    public void add(int index, String element) { throw new UnsupportedOperationException(); }

    @Override
    public String set(int index, String element) { throw new UnsupportedOperationException(); }

    @Override
    public String remove(int index) { throw new UnsupportedOperationException(); }

    @Override
    public boolean addAll(int index, Collection<? extends String> c) { throw new UnsupportedOperationException(); }

    @Override
    public List<String> subList(int fromIndex, int toIndex) { throw new UnsupportedOperationException(); }

    @Override
    protected void removeRange(int fromIndex, int toIndex) { throw new UnsupportedOperationException(); }

    public String getParent(String s) {
        for (Entry<String> x : entryList) {
            if (x.parent != null && x.elementName.equals(s)) return x.parent.elementName; }
        return "It is the root directory without parent"; }

    static class Entry<String> implements Serializable {
        String elementName;
        boolean availableToAddLeftChildren;
        boolean availableToAddRightChildren;
        Entry<java.lang.String> parent;
        Entry<java.lang.String> leftChild;
        Entry<java.lang.String> rightChild;

        public Entry(String s) {
            elementName = s;
            availableToAddLeftChildren = true;
            availableToAddRightChildren = true;
        }

        public boolean isAvailableToAddChildren () {
            return availableToAddLeftChildren | availableToAddRightChildren; } } }
