package Lev_28_lec_5_2;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public class Solution {
    public static void main(String[] args) throws IOException {

        //Создаем map, где ключ это объект ZipEntry с именем заархивированного файла,
        // а значение -- это копия файла из набора байт ByteArrayOutputStream

        Map<ZipEntry, ByteArrayOutputStream> listZipFiles = new HashMap<>();

        //Получаем путь к новому файлу, который будем добавлять в архив

        Path fileName = Paths.get(args[0]);

        //Получаем структуру папок, где будет размещен новый файл

        Path pathToZip = Paths.get("new" + "\\" + fileName.getFileName());

        //Далее разархивируем zip архив, достаем из него текущие файлы и сохраняем их
        //во временные файлы. Сохраняем в Map ZipEntry с именем каждого файла и копию
        //байт каждого файла в виде ByteArrayOutputStream. Его мы и будем потом копировать
        //новый zip архив

        try (ZipInputStream zIS = new ZipInputStream(new FileInputStream(args[1]))) {
            ZipEntry zentry;
            byte[] buffer;
            int byteSize;
            while ((zentry = zIS.getNextEntry()) != null) {
                buffer = new byte[4096];
                Path nameZipFile = Paths.get(zentry.getName());

                //Если в zip архиве уже есть файл, одноименный файлу
                //который идет первым параментов не добавляем его в будущий архив
                if (!nameZipFile.getFileName().toString().equals(pathToZip.getFileName().toString())) {
                    ByteArrayOutputStream bAIS = new ByteArrayOutputStream();
                    while ((byteSize = zIS.read(buffer)) > 0) { bAIS.write(buffer, 0, byteSize); }
                    listZipFiles.put(new ZipEntry(zentry.getName()), bAIS); } } }

        //Копируем новый файл, который идет первым параметром в папку "new" в архиве согласно условию задачи

        try (ZipOutputStream zOS = new ZipOutputStream(new FileOutputStream(args[1]))) {
            zOS.putNextEntry(new ZipEntry(pathToZip.toString()));
            Files.copy(Paths.get(args[0]), zOS);

            //Проходимся по Map и добавляем в архив все файлы, который были в архиве изначально

            for (Map.Entry <ZipEntry, ByteArrayOutputStream> entry : listZipFiles.entrySet()) {
                zOS.putNextEntry(entry.getKey());
                entry.getValue().writeTo(zOS); } } } }
