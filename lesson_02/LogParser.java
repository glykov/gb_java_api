/**
 * 3. Распарсить файл с логами из заданий, выполненных на семинаре, найти записи уровня INFO/DEBUG.
 * проверял на файлах sort.log и calc.log
 * вместо DEBUG искал FINE
 */
import java.io.*;
import java.nio.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.*;

public class LogParser {
    public static ArrayList<String> parse(String fileName, String level) throws IOException {
        ArrayList<String> result = new ArrayList<>();
        for (String line : Files.readAllLines(Paths.get(fileName), StandardCharsets.UTF_8)) {
            if (line.contains(level.toUpperCase())) {
                result.add(line);
            }
        }
        return result;
    }
    public static void main(String[] args) throws IOException {        
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите название файла: ");
        String fileName = scanner.nextLine();
        System.out.print("Введите уровень логгирования: ");
        String loggingLevel = scanner.nextLine();

        // проверено на 
        // List<String> result = parse("sort.log", "info");
        // List<String> result = parse("sort.log", "fine");
        List<String> result = parse(fileName, loggingLevel);

        System.out.println("Найдены следующие записи:");
        for (String s : result) {
            System.out.println(s);
        }
    }
}