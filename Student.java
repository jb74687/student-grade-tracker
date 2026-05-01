import java.util.ArrayList;

public class Student {
    private String name;
    private ArrayList<Double> grades;

    public Student(String name) {
        this.name = name;
        grades = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public ArrayList<Double> getGrades() {
        return grades;
    }

    public void addGrade(double grade) {
        grades.add(grade);
    }

    public double getAverage() {
        double sum = 0;

        for (double g : grades) {
            sum += g;
        }

        return grades.size() > 0 ? sum / grades.size() : 0;
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
        double min = 100;

        for (double g : grades) {
            if (g < min) min = g;
        }

        return min;
    }

    public String getStanding() {
        double gpa = getGPA();

        if (gpa == 4.0) return "High Honors";
        else if (gpa >= 3.0) return "Honors";
        else if (gpa >= 2.0) return "Good Standing";
        else return "Needs Improvement";
    }
}