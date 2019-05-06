package courseinfo;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CourseInfo {

    public static void main(String[] args) {
        BinarySearchTree courses = new BinarySearchTree();

//        courses.insert("DA3018", "Computer Science", 7.5);
//        courses.insert("MM2001", "Matematik I", 30.0);
//        courses.insert("DA2004", "Programmeringsteknik", 7.5);
//
//        int n = courses.size();
//        System.out.printf("There are %d courses in the database.\n", n);
//
//        String name = null;
//        try {
//            name = courses.find("MM2001").getCourseName();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        System.out.printf("Name: %s\n", name);
//
//        System.out.println();
//        System.out.println("New tests");
//        System.out.println();
//        courses.inOrderPrint();
//        System.out.println("Size = " + courses.size());
//        System.out.println();
//        courses.insert("ABC123", "Course1", 7.5);
//        courses.insert("CCB111", "Course2", 7.5);
//        courses.insert("BBB213", "Course3", 7.5);
//        courses.insert("BAB112", "Course4", 7.5);
//        courses.insert("CCC222", "Course5", 7.5);
//        courses.insert("AAC333", "Course6", 7.5);
//        courses.insert("AAC345", "Course7", 7.5);
//        courses.insert("BAA345", "Course8", 7.5);
//        courses.insert("AAA111", "Course9", 7.5);
//        courses.insert("AAA121", "Course10", 7.5);
//        courses.insert("AAA233", "Course11", 7.5);
//        courses.insert("AAA231", "Course12", 7.5);
//        courses.insert("CCC323", "Course13", 7.5);
//        courses.insert("CCE500", "Course14", 7.5);
//        courses.insert("CCC211", "Course15", 7.5);
//        courses.insert("XYZ100", "Course16", 7.5);
//        courses.inOrderPrint();
//        System.out.println("Size = " + courses.size());
//        System.out.println();
//        System.out.println("Overwrite AAC333");
//        courses.insert("AAC333", "Course600", 70.5);
//        courses.inOrderPrint();
//        System.out.println("Size = " + courses.size());
//        System.out.println();
//        System.out.println("Remove CCE500");
//        try {
//            courses.remove("CCE500");
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        courses.inOrderPrint();
//        System.out.println("Size = " + courses.size());
//        System.out.println();
//        System.out.println("Remove AAA121");
//        try {
//            courses.remove("AAA121");
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        courses.inOrderPrint();
//        System.out.println("Size = " + courses.size());
//        System.out.println();
//        System.out.println("Remove CCB111");
//        try {
//            courses.remove("CCB111");
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        courses.inOrderPrint();
//        System.out.println("Size = " + courses.size());
//        System.out.println();
//        System.out.println("Test iterator");
//        for (BinarySearchTree.BSTNode node: courses) {
//            System.out.println(node.getCourseCode());
//        }

        // read data into BST
        try (Scanner fileScanner = new Scanner(new File(args[0]))) {
            while (fileScanner.hasNextLine()) {
                String[] line = fileScanner.nextLine().split(",");
                String courseCode = line[0];
                String courseName = line[1];
                double credits  = Double.parseDouble(line[2]);
                courses.insert(courseCode, courseName, credits);
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
        // list data for single key
        if (args.length > 1) {
            String courseCode = args[1];
            BinarySearchTree.BSTNode node = courses.find(courseCode);
            System.out.println(node.getCourseCode() + "\t" + node.getCourseName() + "\t\t" + node.getCredits());
            return;
        }
        // list data for each node in BST, sorted by key
        double sum = 0;
        for (BinarySearchTree.BSTNode node: courses) {
            System.out.println(node.getCourseCode() + "\t" + node.getCourseName() + "\t\t" + node.getCredits());
            sum += node.getCredits();
        }
        System.out.println("Summa" + "\t\t\t\t" + sum);
    }

}
