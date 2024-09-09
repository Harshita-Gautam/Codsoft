import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

class Quiz {
    private final String[] questions = {
            "What is the capital of France?",
            "Which planet is known as the Red Planet?",
            "Who wrote 'Hamlet'?"
    };

    private final String[][] options = {
            {"1. Paris", "2. Berlin", "3. Madrid", "4. Rome"},
            {"1. Earth", "2. Mars", "3. Jupiter", "4. Saturn"},
            {"1. Charles Dickens", "2. William Shakespeare", "3. Mark Twain", "4. J.K. Rowling"}
    };

    private int[] correctAnswers = {1, 2, 2};
    private int score = 0;

    public void startQuiz() {
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < questions.length; i++) {
            System.out.println("\n"+questions[i]);
            for (String option : options[i]) {
                System.out.println(option);
            }

            Timer timer = new Timer();
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    System.out.println("\nTime's up!");
                }
            }, 5000);

            System.out.print("Your answer: ");
            int answer = scanner.nextInt();
            timer.cancel();

            if (answer == correctAnswers[i]) {
                score++;
            }
        }

        System.out.println("Quiz finished! Your score: " + score + "/" + questions.length);
    }
}

public class QuizApplication {
    public static void main(String[] args) {
        Quiz quiz = new Quiz();
        quiz.startQuiz();
    }
}

