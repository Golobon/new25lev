package Lev_28_lec_10_1;

import java.io.Serializable;
import java.util.*;

/*
Построй дерево(1)
*/

public class CustomTree extends AbstractList <String> implements Cloneable, Serializable {

    List<Entry<String>> entryList;

    Entry<String> root;

    public CustomTree() {
        entryList = new ArrayList<>();
        this.root = new Entry<>("0");
        root.isRoot = true;
        entryList.add(root);
    }

    @Override
    public String get(int index) { throw new UnsupportedOperationException(); }

    @Override
    public int size() { return entryList.size() - 1; }

    @Override
    public boolean add(String s) {

        boolean canChild = false;

        for (Entry<String> x : entryList) {

            if (x.isAvailableToAddChildren()) {

                if (x.availableToAddLeftChildren) {
                    x.leftChild = new Entry<>(s);
                    x.leftChild.parent = x;
                    entryList.add(x.leftChild);
                    x.availableToAddLeftChildren = false;
                    canChild = true;
                    return canChild; }

                if (x.availableToAddRightChildren) {
                    x.rightChild = new Entry<>(s);
                    x.rightChild.parent = x;
                    entryList.add(x.rightChild);
                    x.availableToAddRightChildren = false;
                    canChild = true;
                    return canChild; } } }

        if (!canChild) {
            root.leftChild.availableToAddLeftChildren = true;
            root.leftChild.availableToAddRightChildren = true;
            root.rightChild.availableToAddLeftChildren = true;
            root.rightChild.availableToAddRightChildren = true;
        }

        return false; }

    @Override
    public void add(int index, String element) { throw new UnsupportedOperationException(); }

    @Override
    public String set(int index, String element) { throw new UnsupportedOperationException(); }


    @Override
    public boolean remove(Object o) {
        Queue<Entry<String>> fileTree = new ArrayDeque<>();
        List<Entry<String>> e = new ArrayList<>();

        if (!o.getClass().toString().equals("".getClass().toString())) { throw new UnsupportedOperationException(); }
        else for (int i = 0; i < entryList.size(); i++) {
            if (entryList.get(i).elementName.equals(o)) {
                fileTree.add(entryList.get(i));

                while (!fileTree.isEmpty()) {

                    Entry<String> entry = fileTree.remove();

                    if (entry.leftChild != null) {
                        fileTree.add(entry.leftChild);
                        e.add(entry.leftChild); }

                    if (entry.rightChild != null) {
                        fileTree.add(entry.rightChild);
                        e.add(entry.rightChild); } }

                entryList.remove(i); break; } }

        for (int i = 0; i < entryList.size(); i++) {
            for (int j = 0; j < e.size(); j++) {
                if (!entryList.get(i).isRoot && entryList.get(i).equals(e.get(j))) {
                    entryList.remove(entryList.get(i)); i--; } } }

        fileTree = null;
        e = null;

        return true;
    }

    @Override
    public String remove(int index) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean addAll(int index, Collection<? extends String> c) { throw new UnsupportedOperationException(); }

    @Override
    public List<String> subList(int fromIndex, int toIndex) { throw new UnsupportedOperationException(); }

    @Override
    protected void removeRange(int fromIndex, int toIndex) { throw new UnsupportedOperationException(); }

    public String getParent(String s) {
        for (Entry<String> x : entryList) {
            if (x.isRoot && x.elementName.equals(s)) return "It is the root directory without parent";
            if (x.parent != null && x.elementName.equals(s)) return x.parent.elementName; }
        return "null"; }

    static class Entry<String> implements Serializable {
        boolean isRoot = false;
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
