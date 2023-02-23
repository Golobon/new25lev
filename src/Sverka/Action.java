package Sverka;

/*
This programm made by Golobon
All rights defends (C)(R)
 */

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class Action {

    private JFrame window;

    public Action() {
        window = new JFrame("Сверка 2.0"); //Создаем окно и задаем ему имя
        window.setSize(400,250); //Размер окна
        window.setLocationRelativeTo(null); //Чтобы окно было в центе экрана
        window.setResizable(false); //Чтобы нельзя бло изменить размер окна
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Выход и остановка программы
        window.setVisible(true);
        window.add(new Panel());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Action();
            }
        });
    }
}
