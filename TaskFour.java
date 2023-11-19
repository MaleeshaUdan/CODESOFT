import java.util.Scanner;
import java.util.concurrent.*;

class QuizQuestion {
    String question;
    String[] options;
    char correctAnswer;

    public QuizQuestion(String question, String[] options, char correctAnswer) {
        this.question = question;
        this.options = options;
        this.correctAnswer = correctAnswer;
    }

    public boolean checkAnswer(char answer) {
        return answer == correctAnswer;
    }
}

public class TaskFour {
    private static final int TIME_LIMIT_SECONDS = 10;
    private static final ExecutorService executor = Executors.newSingleThreadExecutor();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        QuizQuestion[] questions = new QuizQuestion[] {
            new QuizQuestion("What is the capital of France?", new String[]{"A) London", "B) Paris", "C) Rome", "D) Madrid"}, 'B'),
            new QuizQuestion("Which planet is known as the Red Planet?", new String[]{"A) Earth", "B) Mars", "C) Jupiter", "D) Venus"}, 'B'),
            new QuizQuestion("What is the largest ocean on Earth?", new String[]{"A) Atlantic", "B) Pacific", "C) Indian", "D) Arctic"}, 'B'),
            new QuizQuestion("Who wrote 'Romeo and Juliet'?", new String[]{"A) Geoffrey Chaucer", "B) John Keats", "C) William Shakespeare", "D) Charles Dickens"}, 'C'),
            new QuizQuestion("What is the chemical symbol for gold?", new String[]{"A) Ag", "B) Au", "C) Fe", "D) O"}, 'B'),
            new QuizQuestion("In computer science, what does 'CPU' stand for?", new String[]{"A) Central Process Unit", "B) Central Processing Unit", "C) Computer Personal Unit", "D) Central Processor Unit"}, 'B')
            //here i have added these questions only
        };

        int score = 0;

        for (QuizQuestion question : questions) {
            System.out.println(question.question);
            for (String option : question.options) {
                System.out.println(option);
            }

            Future<String> future = executor.submit(() -> {
                System.out.print("Enter your answer (A, B, C, or D): ");
                return scanner.next();
            });

            try {
                System.out.println("You have " + TIME_LIMIT_SECONDS + " seconds to answer.");
                String answer = future.get(TIME_LIMIT_SECONDS, TimeUnit.SECONDS).trim().toUpperCase();
                if (answer.length() == 1 && question.checkAnswer(answer.charAt(0))) {
                    System.out.println("Correct!");
                    score++;
                } else {
                    System.out.println("Wrong or invalid answer. The correct answer was " + question.correctAnswer);
                }
            } catch (InterruptedException | ExecutionException | TimeoutException e) {
                future.cancel(true);
                System.out.println("Failed to answer in time. The correct answer was " + question.correctAnswer);
            }
        }

        executor.shutdown();
        System.out.println("\nQuiz complete! Your final score is: " + score + "/" + questions.length);
        scanner.close();
    }
}
