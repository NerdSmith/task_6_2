package ru.vsu.cs;

import java.io.File;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import static ru.vsu.cs.HashAlgorithms.getMD5;

public class FileUtils {
    public static void printDuplicateFiles(Map<String, List<String>> duplicateFilesMap) {
        for (String key: duplicateFilesMap.keySet()) {
            List<String> files = duplicateFilesMap.get(key);
            if (files.size() > 1) {
                System.out.println(files);
            }
        }
    }

    public static List<List<String>> getDuplicateFiles(Map<String, List<String>> duplicateFilesMap) {
        List<List<String>> duplicates = new ArrayList<>();
        for (Map.Entry<String, List<String>> entry: duplicateFilesMap.entrySet()) {
            if (entry.getValue().size() > 1) {
                duplicates.add(entry.getValue());
            }
        }
        return duplicates;
    }

    public static void fillMapWithDuplicatedFiles(File dir, Map<String, List<String>> duplicateFilesMap) {
        File[] dirFiles = dir.listFiles();
        if (dirFiles != null) {
            for (File file: dirFiles) {
                if (file.isDirectory()) {
                    fillMapWithDuplicatedFiles(file, duplicateFilesMap);
                }
                else {
                    String fileMD5 = null;
                    try {
                        fileMD5 = getMD5(file.getAbsolutePath());
                    } catch (IOException e) {
                        System.out.println("Can't read file: " + file.getAbsolutePath());
                        e.printStackTrace();
                    } catch (NoSuchAlgorithmException e) {
                        System.out.println("Can't find algorithm");
                        e.printStackTrace();
                    }
                    if (duplicateFilesMap.containsKey(fileMD5)) {
                        duplicateFilesMap.get(fileMD5).add(file.getAbsolutePath());
                    }
                    else {
                        duplicateFilesMap.put(fileMD5, new ArrayList<>(Collections.singletonList(file.getAbsolutePath())));
                    }
                }
            }
        }
    }
}
