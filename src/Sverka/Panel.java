package Sverka;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class Panel extends JPanel { //Создаем панель
    private Font font = new Font("SansSerif", Font.BOLD, 14); //Тип шрифта, стиль и размер
    private Font font2 = new Font("SansSerif", Font.BOLD, 10); //Тип шрифта, стиль и размер
    private JTextField pathFileBefore = new JTextField("Указать путь целевой папке \"было\", напр, \"C:\\1\\1\""); //Тип шрифта, стиль и размер
    private JTextField pathFileAfter = new JTextField("Указать путь целевой папке \"стало\", напр, \"C:\\1\\2\""); //Тип шрифта, стиль и размер
    private JTextField pathToCreateFile = new JTextField("Укажите путь куда сохранить инфо о сверке, напр, \"C:\\1\""); //Тип шрифта, стиль и размер
    public Panel() {
        setLayout(null); //Это позволит нам размещать элементы по любым координатам

        pathFileBefore.setBounds(6,5,330,25); //Создаем инфополе
        pathFileBefore.setEditable(true); //Указываем на воможность изменения
        add(pathFileBefore); //Добавляем на экран

        pathFileAfter.setBounds(6,35,330,25); //Создаем инфополе
        pathFileAfter.setEditable(true); //Указываем на воможность изменения
        add(pathFileAfter); //Добавляем на экран

        pathToCreateFile.setBounds(6,65,330,25); //Создаем инфополе
        pathToCreateFile.setEditable(true); //Указываем на воможность изменения
        add(pathToCreateFile); //Добавляем на экран

        JButton b1 = new JButton("Что прибавилось"); //Создаем кнопку и рисваиваем ей имя
        b1.setBounds(5,95,195,30); //Задаем распооложение кнопки иразмер
        b1.setFont(font); //Определяем шрифт кнопки
        add(b1); //Добавляем кнопку

        JButton b2 = new JButton("Что убавилось"); //Создаем кнопку и рисваиваем ей имя
        b2.setBounds(205,95,175,30); //Задаем распооложение кнопки иразмер
        b2.setFont(font); //Определяем шрифт кнопки
        add(b2); //Добавляем кнопку

        JButton b3 = new JButton("..."); //Создаем кнопку и рисваиваем ей имя
        b3.setBounds(345,5,35,24); //Задаем распооложение кнопки иразмер
        b3.setFont(font2); //Определяем шрифт кнопки
        add(b3); //Добавляем кнопку

        JButton b4 = new JButton("..."); //Создаем кнопку и рисваиваем ей имя
        b4.setBounds(345,35,35,24); //Задаем распооложение кнопки иразмер
        b4.setFont(font2); //Определяем шрифт кнопки
        add(b4); //Добавляем кнопку

        JButton b5 = new JButton(":/"); //Создаем кнопку и рисваиваем ей имя
        b5.setBounds(345,65,35,24); //Задаем распооложение кнопки иразмер
        b5.setFont(font2); //Определяем шрифт кнопки
        add(b5); //Добавляем кнопку

        ActionListener actLis1 = (ActionEvent e) -> {
            try { Sverka.getAfter(pathFileBefore.getText(), pathFileAfter.getText(), pathToCreateFile.getText()); } catch (IOException ex) { } };
        b1.addActionListener(actLis1);

        ActionListener actLis2 = (ActionEvent e) -> {
            try { Sverka.findDeletedFiles(pathFileBefore.getText(), pathFileAfter.getText(), pathToCreateFile.getText()); } catch (IOException ex) { } };
        b2.addActionListener(actLis2);

        ActionListener actLis3 = (ActionEvent e) -> { Okno o = new Okno(); pathFileBefore.setText(o.getPath()); };
        b3.addActionListener(actLis3);

        ActionListener actLis4 = (ActionEvent e) -> { Okno o = new Okno(); pathFileAfter.setText(o.getPath()); };
        b4.addActionListener(actLis4);

        ActionListener actLis5 = (ActionEvent e) -> { Okno o = new Okno(); pathToCreateFile.setText(o.getPath()); };
        b5.addActionListener(actLis5);
    } }
