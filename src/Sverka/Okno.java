package Sverka;

import javax.swing.*;

class Okno extends JFrame {
    private String path;
    public Okno() {
        JFileChooser fc = new JFileChooser();
        fc.setDialogTitle("Выберите папку в которой будут документы, которые нужно сравнить"); // Заголовок
        fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        if (fc.showSaveDialog(null) == JFileChooser.APPROVE_OPTION){ // showOpenDialog - будет кнопка с надписью "Open", showSaveDialog - "Save"
            path = fc.getSelectedFile() + ""; }
        else { path = ""; } }

    public void setPath(String path) { this.path = path; }
    public String getPath() { return path; } }