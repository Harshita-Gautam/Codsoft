import java.util.*;
public class StudentGradeCalculator {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int English, Mathematics, Science, SocialScience, Computer;
        float TotalMarks, Percentage;

        System.out.println("Enter marks obtanined in English : ");
        English = sc.nextInt();
        System.out.println("Enter marks obtanined in Mathematics : ");
        Mathematics = sc.nextInt();
        System.out.println("Enter marks obtanined in Science : ");
        Science = sc.nextInt();
        System.out.println("Enter marks obtanined in SocialScience : ");
        SocialScience = sc.nextInt();
        System.out.println("Enter marks obtanined in Computer : ");
        Computer = sc.nextInt();

        TotalMarks = English + Mathematics + Science + SocialScience + Computer;
        System.out.println("Total Marks obtained out of 500 = " + TotalMarks);

        Percentage = (TotalMarks/500) * 100;
        System.out.println("Percentage obtained = " + Percentage);

        if(Percentage >= 95){
            System.out.println("Grade A+");
        }
        else if(Percentage >= 90){
            System.out.println("Grade A");
        }
        else if(Percentage >= 85){
            System.out.println("Grade B+");
        }
        else if(Percentage >= 80){
            System.out.println("Grade B");
        }
        else if(Percentage >= 70){
            System.out.println("Grade C+");
        }
        else if(Percentage >= 60){
            System.out.println("Grade C");
        }
        else if(Percentage >= 50){
            System.out.println("Grade D");
        }
        else if(Percentage >= 33){
            System.out.println("Grade E");
        }
        else{
            System.out.println("Fail");
        }
    }
}
