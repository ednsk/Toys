package Tester.intermediateCertification.toyStore.model;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class FileOperationToy {

    private String fileName;
    public Logger logger;

    public FileOperationToy(String fileName, Logger logger) throws SecurityException, IOException {
        this.logger = logger;

        this.fileName = fileName;
        try (FileWriter writer = new FileWriter(fileName, true)) {
            writer.flush();
            this.logger.info("Filewriter sucsessful init.");
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
            this.logger.warning(ex.getMessage());
        }
    }

    public List<String> readAllLines() {
        List<String> lines = new ArrayList<>();
        try {
            File file = new File(fileName);
            //создаем объект FileReader для объекта File
            FileReader fr = new FileReader(file);
            //создаем BufferedReader с существующего FileReader для построчного считывания
            BufferedReader reader = new BufferedReader(fr);
            // считаем сначала первую строку
            String line = reader.readLine();
            if (line != null) {
                lines.add(line);
            }
            while (line != null) {
                // считываем остальные строки в цикле
                line = reader.readLine();
                if (line != null) {
                    lines.add(line);
                }
            }
            fr.close();
            this.logger.info("All lines are readed.");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            this.logger.warning("File not found.");
        } catch (IOException e) {
            e.printStackTrace();
            this.logger.warning("Error.");
        }
        return lines;
    }

    public void saveAllLines(List<String> lines) {
        try (FileWriter writer = new FileWriter(fileName, false)) {
            for (String line : lines) {
                // запись всей строки
                writer.write(line);
                // запись по символам
                writer.append('\n');
            }
            writer.flush();
            this.logger.info("All lines are saved.");
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
            this.logger.warning(ex.getMessage());
        }
    }
}
