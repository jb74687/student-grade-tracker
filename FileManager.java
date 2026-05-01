import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class FileManager {
    public static void saveToFile(ArrayList<Student> students, String filename) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {

            for (Student s : students) {
                writer.print(s.getName());

                for (double g : s.getGrades()) {
                    writer.print("," + g);
                }

                writer.println();
            }

        } catch (IOException e) {
            System.out.println("Error saving file.");
        }
    }

    public static ArrayList<Student> loadFromFile(String filename) {
        ArrayList<Student> students = new ArrayList<>();

        try (Scanner fileScanner = new Scanner(new File(filename))) {

            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                String[] parts = line.split(",");

                Student s = new Student(parts[0]);

                for (int i = 1; i < parts.length; i++) {
                    s.addGrade(Double.parseDouble(parts[i]));
                }

                students.add(s);
            }

        } catch (Exception e) {
            System.out.println("Error loading file.");
        }

        return students;
    }
}