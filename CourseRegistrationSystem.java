import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class StudentCourseRegistrationSystem {
    private String courseCode;
    private String title;
    private int capacity;
    private int enrolledStudents;

    public StudentCourseRegistrationSystem(String courseCode, String title, int capacity) {
        this.courseCode = courseCode;
        this.title = title;
        this.capacity = capacity;
        this.enrolledStudents = 0;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public String getTitle() {
        return title;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getEnrolledStudents() {
        return enrolledStudents;
    }

    public boolean enrollStudent() {
        if (enrolledStudents < capacity) {
            enrolledStudents++;
            return true;
        } else {
            return false;
        }
    }

    public boolean dropStudent() {
        if (enrolledStudents > 0) {
            enrolledStudents--;
            return true;
        } else {
            return false;
        }
    }
}

class Student {
    private String studentID;
    private String name;
    private List<StudentCourseRegistrationSystem> registeredCourses;

    public Student(String studentID, String name) {
        this.studentID = studentID;
        this.name = name;
        this.registeredCourses = new ArrayList<>();
    }

    public String getStudentID() {
        return studentID;
    }

    public String getName() {
        return name;
    }

    public List<StudentCourseRegistrationSystem> getRegisteredCourses() {
        return registeredCourses;
    }

    public void registerCourse(StudentCourseRegistrationSystem course) {
        if (course.enrollStudent()) {
            registeredCourses.add(course);
            System.out.println("Registered for course: " + course.getTitle());
        } else {
            System.out.println("Course is full.");
        }
    }

    public void dropCourse(StudentCourseRegistrationSystem course) {
        if (registeredCourses.contains(course)) {
            course.dropStudent();
            registeredCourses.remove(course);
            System.out.println("Dropped course: " + course.getTitle());
        } else {
            System.out.println("You are not registered for this course.");
        }
    }
}

public class CourseRegistrationSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<StudentCourseRegistrationSystem> courses = new ArrayList<>();
        List<Student> students = new ArrayList<>();

        courses.add(new StudentCourseRegistrationSystem("CS101", "Introduction to Computer Science", 3));
        courses.add(new StudentCourseRegistrationSystem("MATH101", "Calculus I", 2));

        Student student = new Student("123", "John Doe");
        students.add(student);

        int choice;
        do {
            System.out.println("\n1. List Courses");
            System.out.println("2. Register for Course");
            System.out.println("3. Drop Course");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Available Courses:");
                    for (StudentCourseRegistrationSystem course : courses) {
                        System.out.println(course.getCourseCode() + ": " + course.getTitle() +
                                " (Capacity: " + course.getCapacity() + ", Enrolled: " + course.getEnrolledStudents() + ")");
                    }
                    break;
                case 2:
                    System.out.print("Enter course code to register: ");
                    String courseCode = scanner.next();
                    StudentCourseRegistrationSystem courseToRegister = null;
                    for (StudentCourseRegistrationSystem course : courses) {
                        if (course.getCourseCode().equals(courseCode)) {
                            courseToRegister = course;
                            break;
                        }
                    }
                    if (courseToRegister != null) {
                        student.registerCourse(courseToRegister);
                    } else {
                        System.out.println("Course not found.");
                    }
                    break;
                case 3:
                    System.out.print("Enter course code to drop: ");
                    String courseToDropCode = scanner.next();
                    StudentCourseRegistrationSystem courseToDrop = null;
                    for (StudentCourseRegistrationSystem course : student.getRegisteredCourses()) {
                        if (course.getCourseCode().equals(courseToDropCode)) {
                            courseToDrop = course;
                            break;
                        }
                    }
                    if (courseToDrop != null) {
                        student.dropCourse(courseToDrop);
                    } else {
                        System.out.println("Course not found.");
                    }
                    break;
                case 4:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid option.");
            }
        } while (choice != 4);
    }
}
