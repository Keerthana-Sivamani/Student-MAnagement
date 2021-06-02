import java.io.BufferedReader;
//import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
//import java.io.PrintWriter;
//import java.nio.Buffer;
import java.util.*;

import java.io.FileWriter;
import java.lang.NumberFormatException;

public class code {

    static String filename = "C:\\Users\\SHIVAMANI\\Desktop\\StudentRecords1.csv";

    public static class Student {
        public int roll_no;
        public String name;
        public int english, tamil, maths, science, social;
        public float percentage;

    }

    public static void handleChoice(int ch) {
        switch (ch) {
            case 1:

                Student student = new Student();
                Scanner sc = new Scanner(System.in);

                System.out.println("Enter roll_no");
                student.roll_no = sc.nextInt();
                System.out.println("Enter name");
                student.name = sc.next();
                System.out.println("Enter english");
                student.english = sc.nextInt();
                System.out.println("Enter tamil");
                student.tamil = sc.nextInt();
                System.out.println("Enter maths");
                student.maths = sc.nextInt();
                System.out.println("Enter science");
                student.science = sc.nextInt();
                System.out.println("Enter social");
                student.social = sc.nextInt();
                student.percentage = (student.english + student.tamil + student.maths + student.science
                        + student.social) / 5;

                add(filename, student, 1, true);
                break;
            case 2:
                view(filename);
                break;
            case 3:
                delete(0);
                break;
            case 4:
                delete(1);
                break;
            default:
                System.out.printf("Bye Bye!!\n");
                break;
        }
    }

    public static void add(String fa_name, Student sa, int flag, boolean mode) {

        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(fa_name, mode);
            if (flag == 0)
                fileWriter.append("Roll_no, Name, English, Tamil, Maths, Science, Social, Percentage\n");

            System.out.println(sa.name + ' ');
            fileWriter.append(String.valueOf(sa.roll_no));
            fileWriter.append(",");
            fileWriter.append(sa.name);
            fileWriter.append(",");
            fileWriter.append(String.valueOf(sa.english));
            fileWriter.append(",");
            fileWriter.append(String.valueOf(sa.tamil));
            fileWriter.append(",");
            fileWriter.append(String.valueOf(sa.maths));
            fileWriter.append(",");
            fileWriter.append(String.valueOf(sa.science));
            fileWriter.append(",");
            fileWriter.append(String.valueOf(sa.social));
            fileWriter.append(",");
            fileWriter.append(String.valueOf(sa.percentage));
            fileWriter.append("\n");

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                fileWriter.flush();
                fileWriter.close();

                System.out.println("**********");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    public static void view(String fv_name) {

        BufferedReader reader = null;
        try {
            List<Student> students = new ArrayList<Student>();
            String line = "";
            reader = new BufferedReader(new FileReader(fv_name));
            reader.readLine();

            while ((line = reader.readLine()) != null) {
                String[] fields = line.split(",");
                if (fields.length > 0) {
                    Student student = new Student();
                    try {
                        student.roll_no = Integer.parseInt(fields[0]);
                    } catch (NumberFormatException ex) { // handle your exception
                        // ex.printStackTrace();
                    }

                    student.name = fields[1];
                    try {
                        student.english = Integer.parseInt(fields[2]);
                    } catch (NumberFormatException ex) { // handle your exception
                        // ex.printStackTrace();
                    }
                    try {
                        student.tamil = Integer.parseInt(fields[3]);
                    } catch (NumberFormatException ex) { // handle your exception
                        // ex.printStackTrace();
                    }
                    try {
                        student.maths = Integer.parseInt(fields[4]);
                    } catch (NumberFormatException ex) { // handle your exception
                        // ex.printStackTrace();
                    }
                    try {
                        student.science = Integer.parseInt(fields[5]);
                    } catch (NumberFormatException ex) { // handle your exception
                        // ex.printStackTrace();
                    }
                    try {
                        student.social = Integer.parseInt(fields[6]);
                    } catch (NumberFormatException ex) { // handle your exception
                        // ex.printStackTrace();
                    }
                    try {
                        student.percentage = Float.parseFloat(fields[7]);
                    } catch (NumberFormatException ex) { // handle your exception
                        // ex.printStackTrace();
                    }

                    students.add(student);

                }
            }

            for (Student sv : students) {
                System.out.println(sv.roll_no);
                System.out.println(sv.name);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                reader.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    public static void delete(int k) {

        Scanner sc = new Scanner(System.in);
        int r_no;
        System.out.println("Enter the roll no");
        r_no = sc.nextInt();

        BufferedReader reader = null;
        try {
            List<Student> students = new ArrayList<Student>();
            String line = "";
            reader = new BufferedReader(new FileReader(filename));
            reader.readLine();

            while ((line = reader.readLine()) != null) {
                String[] fields = line.split(",");
                if (fields.length > 0) {
                    Student student = new Student();
                    try {
                        student.roll_no = Integer.parseInt(fields[0]);
                    } catch (NumberFormatException ex) { // handle your exception
                        // ex.printStackTrace();
                    }

                    student.name = fields[1];
                    try {
                        student.english = Integer.parseInt(fields[2]);
                    } catch (NumberFormatException ex) { // handle your exception
                        // ex.printStackTrace();
                    }
                    try {
                        student.tamil = Integer.parseInt(fields[3]);
                    } catch (NumberFormatException ex) { // handle your exception
                        // ex.printStackTrace();
                    }
                    try {
                        student.maths = Integer.parseInt(fields[4]);
                    } catch (NumberFormatException ex) { // handle your exception
                        // ex.printStackTrace();
                    }
                    try {
                        student.science = Integer.parseInt(fields[5]);
                    } catch (NumberFormatException ex) { // handle your exception
                        // ex.printStackTrace();
                    }
                    try {
                        student.social = Integer.parseInt(fields[6]);
                    } catch (NumberFormatException ex) { // handle your exception
                        // ex.printStackTrace();
                    }
                    try {
                        student.percentage = Float.parseFloat(fields[7]);
                    } catch (NumberFormatException ex) { // handle your exception
                        // ex.printStackTrace();
                    }

                    students.add(student);

                }
            }
            int first = 0;

            for (Student s : students) {
                if (s.roll_no == r_no && k == 1) {
                    Scanner sd = new Scanner(System.in);

                    System.out.println("Enter roll_no");
                    s.roll_no = sd.nextInt();
                    System.out.println("Enter name");
                    s.name = sd.next();
                    System.out.println("Enter english");
                    s.english = sd.nextInt();
                    System.out.println("Enter tamil");
                    s.tamil = sd.nextInt();
                    System.out.println("Enter maths");
                    s.maths = sd.nextInt();
                    System.out.println("Enter science");
                    s.science = sd.nextInt();
                    System.out.println("Enter social");
                    s.social = sd.nextInt();
                    s.percentage = (s.english + s.tamil + s.maths + s.science + s.social) / 5;
                    if (first == 0) {
                        add(filename, s, 0, false);
                        first = 1;

                    } else
                        add(filename, s, 1, true);

                } else if (s.roll_no != r_no && first == 0) {
                    add(filename, s, 0, false);
                    first = 1;
                }

                else if (s.roll_no != r_no)
                    add(filename, s, 1, true);
                else
                    continue;
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                reader.close();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    public static void main(String[] args) {

        int ch;
        Scanner scan = new Scanner(System.in);
        System.out.printf("\n*********************************************************************************\n");
        System.out.printf("\n\n1. Add a record\n2. List Students\n3. Delete Student\n4. Edit Student\n5. Quit\n");
        System.out.printf("What is your choice? : ");
        ch = scan.nextInt();
        System.out.printf("\n*********************************************************************************\n");
        handleChoice(ch);
    }

}