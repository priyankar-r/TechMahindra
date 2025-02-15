package week3task1;
import java.util.*;
public class studentMarksheet {
	String name;
    List<Integer> marks;
    int totalMarks;
    double averageMarks;

    // constructor
    public studentMarksheet(String name, List<Integer> marks) {
        this.name = name;
        this.marks = marks;
        calculateTotalAndAverage();
    }

    // method to calculate total and average marks
    private void calculateTotalAndAverage() {
        this.totalMarks = marks.stream().mapToInt(Integer::intValue).sum();
        this.averageMarks = (double) totalMarks / marks.size();
    }

    // Override toString() to display student details
    @Override
    public String toString() {
        return "Name: " + name + ", Marks: " + marks + ", Total: " + totalMarks + ", Average: " + averageMarks;
    }
}

