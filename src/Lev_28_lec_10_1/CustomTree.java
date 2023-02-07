package Lev_28_lec_10_1;

import java.io.Serializable;
import java.util.*;

/*
Построй дерево(1)
*/

public class CustomTree extends AbstractList <String> implements Cloneable, Serializable {
    //Для создания дерева используем ArrayList
    List<Entry<String>> entryList;

    Entry<String> root;

    public CustomTree() {
        //Инициализируем лист
        entryList = new ArrayList<>();
        //Задаем имя корню
        this.root = new Entry<>("0");
        //Задаем корневой папке флаг, что она является root
        root.isRoot = true;
        //Добавляем root в ArrayList (entryList)
        entryList.add(root);
    }

    @Override
    public String get(int index) { throw new UnsupportedOperationException(); }

    @Override
    public int size() { return entryList.size() - 1; }

    @Override
    public boolean add(String s) {

        //Используем ForEach для пробежки по всем элементам древа
        for (Entry<String> x : entryList) {

            //Если у родителя есть свободное место под левого или правого
            //потомка двигаемся дальше, чтобы определить куда "вставить"
            //нового потомка
            if (x.isAvailableToAddChildren()) {

                //Если у родителя "свободен" левый потомок, "заполняем" его
                if (x.availableToAddLeftChildren) {
                    //Создаем левого потомка и присваиваем ему имя,
                    //переданное агрументом (s)
                    x.leftChild = new Entry<>(s);
                    //Указываем программе родителя левого потомка
                    x.leftChild.parent = x;
                    //Указываем программе, что у родителя есть левый потомок
                    x.hasLeftChild = true;
                    //Указываем программе, что потомок является левым
                    x.leftChild.isLeftChild = true;
                    //Добавляем левого потомка в лист
                    entryList.add(x.leftChild);
                    //Закрываем родителю возможность создавать левых потомков
                    x.availableToAddLeftChildren = false;
                    return true; }

                //Здесь логика та же, только с правым потомком
                if (x.availableToAddRightChildren) {
                    x.rightChild = new Entry<>(s);
                    x.rightChild.parent = x;
                    x.hasRightChild = true;
                    x.rightChild.isRightChild = true;
                    entryList.add(x.rightChild);
                    x.availableToAddRightChildren = false;
                    return true; } } }

        //До сюда программа дойдет только если не окажется родителей,
        //способных иметь левого или правого потомка. Делаем так, чтобы все родители,
        //лишившиеся потомков погли их иметь.

        for (Entry<String> x : entryList) {
            //Если ролитель не имеет левого потомка, говорим, что он может его иметь.
            //Указание на то, что родитель не имеет потомка появляется после удаления
            //элемента в методе remove (строки 117 и 119)
            if (!x.hasLeftChild) { x.availableToAddLeftChildren = true; }
            //Аналогично
            if (!x.hasRightChild) { x.availableToAddRightChildren = true; } }

        //Используем рекурсию, чтобы создать потомка в порядке
        //указанном в коде выше

        return add(s); }

    @Override
    public void add(int index, String element) { throw new UnsupportedOperationException(); }

    @Override
    public String set(int index, String element) { throw new UnsupportedOperationException(); }


    @Override
    public boolean remove(Object o) {
        //Для удаления используем чередь, куда будем класть всех потомков
        //удаляемого родителя. ArrayDeque позволяет пробежаться по всем
        //потомкам в глубину.
        Queue<Entry<String>> fileTree = new ArrayDeque<>();
        //Всех выявленных потомков удляемого родителя вносим в список.
        //По нему потом будем удалять через сравнение сех потомков
        //удаленного родителя
        List<Entry<String>> e = new ArrayList<>();

        //Если введенное в качестве аргумента имя удаляемого элемента
        //не является строкой, кидаем ошибку UnsupportedOperationException
        if (!o.getClass().toString().equals("".getClass().toString())) { throw new UnsupportedOperationException(); }
        //Иначе ищем нужный элемент с именем, введенным в качестве аргумента метода remove.
        else for (int i = 0; i < entryList.size(); i++) {
            //Сравниваем имя с именами всех элементов
            if (entryList.get(i).elementName.equals(o)) {
                //Если находми совпадение, кладем его в очередь
                fileTree.add(entryList.get(i));

                //Ищем потомков пока они есть и кладем их в очередь
                while (!fileTree.isEmpty()) {

                    //Присваиваем entry имя оъекта и сразу удаляем его
                    Entry<String> entry = fileTree.remove();

                    //если у объекта был левый потомок, добавляем его в очередь
                    //и в список потомков, которые нужно будет удалить
                    if (entry.leftChild != null) {
                        fileTree.add(entry.leftChild);
                        e.add(entry.leftChild); }

                    //Аналогично для правого потомка
                    if (entry.rightChild != null) {
                        fileTree.add(entry.rightChild);
                        e.add(entry.rightChild); } }

                //Если удаляемый элемент является левым потомком, указываем программе, что у
                //его родителя больше нет левого потомка
                if (entryList.get(i).isLeftChild) entryList.get(i).parent.hasLeftChild = false;

                //То же и для ситуации, если удаляемый элемент - правый потомок
                if (entryList.get(i).isRightChild) entryList.get(i).parent.hasRightChild = false;

                //Удаляем элемент
                entryList.remove(i); break; } }

        //Сравниваем в нашем дереве все объекты с объектами, которые добавили в список для удаления и
        //удаляем их, если есть совпадение. Так мы удаляем всех потомков удаляемого элемента
        for (int i = 0; i < entryList.size(); i++) {
            for (int j = 0; j < e.size(); j++) {
                if (!entryList.get(i).isRoot && entryList.get(i).equals(e.get(j))) {
                    entryList.remove(entryList.get(i)); i--; } } }
        //Обнуляем ссылки на наш лист с удаляемыми объектами и на очередь
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
        boolean isLeftChild = false;
        boolean isRightChild = false;
        boolean hasLeftChild = false;
        boolean hasRightChild = false;
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
