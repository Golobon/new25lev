package Sverka;

/*
This programm made by Golobon
All rights defends (C)(R)
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class Panel extends JPanel { //Создаем панель
    private Font font = new Font("SansSerif", Font.BOLD, 18); //Тип шрифта, стиль и размер
    private JTextField pathFileBefore = new JTextField("Здесь указать путь к папке \"было\""); //Тип шрифта, стиль и размер
    private JTextField pathFileAfter = new JTextField("Здесь указать путь к папке \"стало\""); //Тип шрифта, стиль и размер
    private JTextField pathToCreateFile = new JTextField("Укажите путь куда сохранить файл с информацией о сверке"); //Тип шрифта, стиль и размер
    public Panel() {
        setLayout(null); //Это позволит нам размещать элементы по любым координатам

        pathFileBefore.setBounds(6,35,375,25); //Создаем инфополе
        pathFileBefore.setEditable(true); //Указываем на воможность изменения
        add(pathFileBefore); //Добавляем на экран

        pathFileAfter.setBounds(6,65,375,25); //Создаем инфополе
        pathFileAfter.setEditable(true); //Указываем на воможность изменения
        add(pathFileAfter); //Добавляем на экран

        pathToCreateFile.setBounds(6,95,375,25); //Создаем инфополе
        pathToCreateFile.setEditable(true); //Указываем на воможность изменения
        add(pathToCreateFile); //Добавляем на экран

        JButton b1 = new JButton("Что прибавилось"); //Создаем кнопку и рисваиваем ей имя
        b1.setBounds(5,150,195,30); //Задаем распооложение кнопки иразмер
        b1.setFont(font); //Определяем шрифт кнопки
        add(b1); //Добавляем кнопку

        JButton b2 = new JButton("Что убавилось"); //Создаем кнопку и рисваиваем ей имя
        b2.setBounds(205,150,175,30); //Задаем распооложение кнопки иразмер
        b2.setFont(font); //Определяем шрифт кнопки
        add(b2); //Добавляем кнопку

        ActionListener actLis1 = (ActionEvent e) -> {
            try { Sverka.getAfter(pathFileBefore.getText(), pathFileAfter.getText(), pathToCreateFile.getText()); } catch (IOException ex) { } };
        b1.addActionListener(actLis1);

        ActionListener actLis2 = (ActionEvent e) -> {
            try { Sverka.findDeletedFiles(pathFileBefore.getText(), pathFileAfter.getText(), pathToCreateFile.getText()); } catch (IOException ex) { } };
        b2.addActionListener(actLis2);
    } }
