import java.util.ArrayList;

public class Gradebook {
    private ArrayList<Student> students;

    public Gradebook() {
        students = new ArrayList<>();
    }

    public void addStudent(String name) {
        students.add(new Student(name));
    }

    public Student findStudent(String name) {
        for (Student s : students) {
            if (s.getName().equalsIgnoreCase(name)) {
                return s;
            }
        }
        return null;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public void sortByAverage() {
        students.sort((a, b) ->
            Double.compare(b.getAverage(), a.getAverage())
        );
    }

    public void displayRankings() {
        students.sort((a, b) -> Double.compare(b.getGPA(), a.getGPA()));

        System.out.println("\n--- CLASS RANKINGS ---");

        int rank = 1;
        for (Student s : students) {
            System.out.println(rank + ". " + s.getName() + " | GPA: " + s.getGPA() + " | Avg: " + s.getAverage() + " | " + s.getLetterGrade());
            rank++;
        }
    }
}