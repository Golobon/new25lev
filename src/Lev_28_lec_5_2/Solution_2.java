package Lev_28_lec_5_2;

import java.io.*;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/*
Добавление файла в архив
*/

public class Solution_2 {
    public static void main(String[] args) throws IOException {
        // файл который надо добавить в архив
        // Список для сохранения текущих данных массива
        List<Context> entries = new ArrayList<>();
        // сохраняем данные
        // Пока есть файлы, копируем поочередно в лист
        try (ZipInputStream zis = new ZipInputStream(new FileInputStream(args[1]))) {
            ZipEntry entry;
            while ((entry = zis.getNextEntry()) != null) {
                byte[] buffer = new byte[2048];
                ByteArrayOutputStream output = new ByteArrayOutputStream();
                int count = 0;
                while (zis.available() > 0) {
                    count = zis.read(buffer);
                    output.write(buffer, 0, count);
                }
                entries.add(new Context(entry.getName(), output.toByteArray()));
            }
        }
        // Используй имя архива для создания потока вывода. Затем создай ZipOutputStream
        // и передай в конструктор созданный поток вывода.
        // А я что блин сделал???????
        FileOutputStream fos = new FileOutputStream(args[1]);
        ZipOutputStream zos = new ZipOutputStream(fos);
        File file = new File(args[0]);
        zos.putNextEntry(new ZipEntry("new/" + file.getName()));
        // Для записи файла в поток архива используй метод Files.copy(Path, OutputStream).
        // А это что??????
        Files.copy(file.toPath(), zos);

        // А теперь записываем данные которые раньше были в архиве
        for (Context context : entries) {
            // если имя старого файла совпадает с именем нового, то мы его не пишем
            if (file.getName().equals(context.fileName)) continue;
            // записываем данные, Зипентри закрываем
            zos.putNextEntry(new ZipEntry(context.fileName));
            zos.write(context.bytes);
            zos.closeEntry();
        }
        // Потом финальный закрывается
        zos.close();
    }
    public static class Context {
        String fileName;
        byte[] bytes;

        public Context(String fileName, byte[] bytes) {
            this.fileName = fileName;
            this.bytes = bytes;
        }
    }
}
