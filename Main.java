import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Gradebook gradebook = new Gradebook();

        while (true) {
            System.out.println("\n===== STUDENT GRADE TRACKER =====");
            System.out.println("1. Add Student");
            System.out.println("2. Add Grade");
            System.out.println("3. View Students");
            System.out.println("4. Sort by Average");
            System.out.println("5. Save to File");
            System.out.println("6. Load from File");
            System.out.println("7. View Rankings (GPA)");
            System.out.println("8. Exit");

            System.out.print("Choose: ");
            int choice = input.nextInt();
            input.nextLine();

            if (choice == 1) {
                System.out.print("Enter student name: ");
                String name = input.nextLine();
                gradebook.addStudent(name);

            } else if (choice == 2) {
                System.out.print("Student name: ");
                String name = input.nextLine();

                Student s = gradebook.findStudent(name);

                if (s != null) {
                    double grade;

                    while (true) {
                        System.out.print("Enter grade (0-100): ");
                        grade = input.nextDouble();

                        if (grade >= 0 && grade <= 100) break;

                        System.out.println("Invalid grade.");
                    }

                    s.addGrade(grade);

                } else {
                    System.out.println("Student not found.");
                }

            } else if (choice == 3) {
                for (Student s : gradebook.getStudents()) {
                    System.out.println(s.getName() + " | Avg: " + s.getAverage() + " | Grade: " + s.getLetterGrade() + " | GPA: " + s.getGPA());
                }

            } else if (choice == 4) {
                gradebook.sortByAverage();
                System.out.println("Sorted by average.");

            } else if (choice == 5) {
                FileManager.saveToFile(gradebook.getStudents(), "grades.txt");

                System.out.println("Saved.");

            } else if (choice == 6) {
                gradebook = new Gradebook();

                ArrayList<Student> loaded = FileManager.loadFromFile("grades.txt");

                for (Student s : loaded) {
                    gradebook.getStudents().add(s);
                }

                System.out.println("Loaded.");

            } else if (choice == 7) {
                gradebook.displayRankings();

            } else if (choice == 8) {
                System.out.println("Goodbye!");
                break;
            }
        }
    }
}