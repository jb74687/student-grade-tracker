import java.util.ArrayList;

public class Student {
    private String name;
    private ArrayList<Double> grades;

    public Student(String name) {
        this.name = name;
        this.grades = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void addGrade(double grade) {
        grades.add(grade);
    }

    public ArrayList<Double> getGrades() {
        return grades;
    }

    public double getAverage() {
        if (grades.isEmpty()) return 0;

        double sum = 0;
        for (double g : grades) {
            sum += g;
        }
        return sum / grades.size();
    }

    public String getLetterGrade() {
        double avg = getAverage();

        if (avg >= 90) return "A";
        else if (avg >= 80) return "B";
        else if (avg >= 70) return "C";
        else if (avg >= 60) return "D";
        else return "F";
    }

    public double getGPA() {
        double avg = getAverage();

        if (avg >= 90) return 4.0;
        else if (avg >= 80) return 3.0;
        else if (avg >= 70) return 2.0;
        else if (avg >= 60) return 1.0;
        else return 0.0;
    }

    public double getHighest() {
        double max = 0;
        for (double g : grades) {
            if (g > max) max = g;
        }
        return max;
    }

    public double getLowest() {
        if (grades.isEmpty()) return 0;

        double min = grades.get(0);
        for (double g : grades) {
            if (g < min) min = g;
        }
        return min;
    }
}