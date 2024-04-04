package JavaEx.Model;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BaiTapModel {
    public String loadFile(File file) {
        StringBuilder content = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            content.append(reader.lines().collect(Collectors.joining("\n")));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return content.toString();
    }

    public void saveFile(File file, String text) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            writer.write(text);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<File> getAllFiles(File directory) {
        List<File> fileList = new ArrayList<>();
        getAllFilesRecursive(directory, fileList);
        return fileList;
    }

    private void getAllFilesRecursive(File directory, List<File> fileList) {
        if (directory.isDirectory()) {
            File[] files = directory.listFiles();
            if (files != null) {
                for (File file : files) {
                    if (file.isDirectory()) {
                        getAllFilesRecursive(file, fileList);
                    } else {
                        fileList.add(file);
                    }
                }
            }
        }
    }
}
