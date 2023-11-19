import java.util.Scanner;

class TaskTwo {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfSubjects;
        
        do {
            System.out.println("Enter the number of subjects (more than 0):");
            numberOfSubjects = scanner.nextInt();
            if (numberOfSubjects <= 0) {
                System.out.println("Invalid input. The number of subjects must be greater than 0.");
            }
        } while (numberOfSubjects <= 0);
        
        int[] marks = new int[numberOfSubjects];
        int totalMarks = 0;
        
        for (int i = 0; i < numberOfSubjects; i++) {
            int mark;
            do {
                System.out.println("Enter marks out of 100 for subject " + (i + 1) + ":");
                mark = scanner.nextInt();
                if (mark < 0 || mark > 100) {
                    System.out.println("Invalid input. Marks should be between 0 and 100.");
                }
            } while (mark < 0 || mark > 100);
            
            marks[i] = mark;
            totalMarks += mark;
        }
        
        double averagePercentage = (double) totalMarks / numberOfSubjects;
        char grade = calculateGrade(averagePercentage);
        
        displayResults(totalMarks, averagePercentage, grade);
        scanner.close();
    }
    
    public static char calculateGrade(double averagePercentage) {
        if (averagePercentage >= 90) {
            return 'A';
        } else if (averagePercentage >= 80) {
            return 'B';
        } else if (averagePercentage >= 70) {
            return 'C';
        } else if (averagePercentage >= 60) {
            return 'D';
        } else {
            return 'F';
        }
    }
    
    public static void displayResults(int totalMarks, double averagePercentage, char grade) {
        System.out.println("Total Marks: " + totalMarks);
        System.out.printf("Average Percentage: %.2f%%\n", averagePercentage);
        System.out.println("Grade: " + grade);
    }
}
