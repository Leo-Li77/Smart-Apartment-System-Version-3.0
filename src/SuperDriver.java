import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

public class SuperDriver {

    /*
    Part1:
        Fields
    */

    ArrayList<StudentApartment> studentStore = new ArrayList<>();
    Scanner input = new Scanner(System.in);


    /*
    Part2:
        Validations
    */

    // Validation for Name
    protected boolean judgeName(String name) {
        boolean flag = true;
        if (name.length() < 2 || name.trim().isEmpty()) {
            flag = false;
        }
        return flag;
    } // End of JudgeName


    // Validation1 for studentID (To see whether all of which is number and have 12 elements)
    protected boolean judgeID(String studentID) {
        boolean flag = true;
        if (studentID.length() != 12) {
            flag = false;
        }
        try {
            Long.parseLong(studentID);
        } catch (NumberFormatException e) {
            flag = false;
        }
        return flag;
    } // End of JudgeID


    // Validation2 of studentID (To see whether there has a student has the same studentID as the new added one.)
    protected String readUniqueStudentID(Scanner input, List<StudentApartment> store) {
        while (true) {
            String id = input.nextLine();
            if (!judgeID(id)) {
                System.out.print("\033[33m[Student ID must be exactly 12 digits] \033[0m");
                continue;
            }
            if (store.stream().anyMatch(s -> s.getStudentID().equals(id))) {
                System.out.print("\033[33m[This student ID is already registered] \033[0m");
                continue;
            }
            return id;
        }
    } // End of ReadUniqueStudentID


    // Validation for Phone Number
    protected boolean judgePhoneNumber(String telephoneNumber) {
        boolean flag = true;
        if (telephoneNumber.length() != 11) {
            flag = false;
        }
        try {
            Long.parseLong(telephoneNumber);
        } catch (NumberFormatException e) {
            flag = false;
        }
        return flag;
    } // End of JudgePhoneNumber


    /*
    Part3:
        Methods
     */

    // The option 1 : Add New Student and Start Iterm
    protected void addAndStart() {

        System.out.println("\033[33m\n---------------\033[0m");
        System.out.println("\033[33m Start Project \033[0m");
        System.out.println("\033[33m---------------\033[0m");

        // input and validate the name
        System.out.print("\033[33m[Enter name]         \033[0m");
        String name = input.nextLine();
        while (!(judgeName(name))) {
            System.out.print("\033[33m[Please enter a valid student name] \033[0m");
            name = input.nextLine();
        }

        // input and validate studentID
        System.out.print("\033[33m[Enter student ID]   \033[0m");
        // Validation of StudentID
        String studentID = readUniqueStudentID(input, studentStore);

        // The first version of studentID's validation.
//        String studentID = input.nextLine();
//        boolean flag = true;
//        for (int i = 0; i < studentStore.size(); i++) {
//            if (studentStore.get(i).getStudentID().equals(studentID)) {
//                flag = false;
//                break;
//            }
//        }
//        while (!(judgeID(studentID)) || !flag) {
//            System.out.print("\033[33m[Please enter a valid student ID]   \033[0m");
//            studentID = input.nextLine();
//            flag = true;
//            for (int i = 0; i < studentStore.size(); i++) {
//                if (studentStore.get(i).getStudentID().equals(studentID)) {
//                    flag = false;
//                    break;
//                }
//            }
//
//        }

        // input and validate phone number
        System.out.print("\033[33m[Enter phone number] \033[0m");
        String phoneNumber = input.nextLine();
        while (!(judgePhoneNumber(phoneNumber))) {
            System.out.print("\033[33m[Please enter a valid phone number] \033[0m");
            phoneNumber = input.nextLine();
        }

        StudentApartment newStudent = new StudentApartment(name, studentID, phoneNumber);
        studentStore.add(newStudent);

        System.out.print("""
                \033[33m-----------------------
                 Choose Iterm to Start
                -----------------------
                1) Accommodation Application
                2) Check-out Application
                3) Accommodation Transfer Application
                4) Apply Early
                5) Apply Late
                6) Item Borrowing Application
                7) Activity Room Borrowing Application
                8) Accommodation Notice\033[0m
                """);
        System.out.print("\033[33m[Enter your iterm number to start] \033[0m");
        int startProjectNumber = input.nextInt();
        input.nextLine();


        boolean flag1 = false;
        for (int i = 0; i < studentStore.size(); i++) {
            if (studentStore.get(i).getStudentID().equals(studentID)) {
                studentStore.get(i).iterms.set(startProjectNumber - 1, 1);
                flag1 = true;
                break;
            }
        }
        if (!flag1) {
            System.out.println("\033[33m<Please enter a valid student ID!>\033[0m");
        }


    } // End of AddAndStart


    // The option 2 : Start Iterm
    protected void startIterm() {

        System.out.println("\033[32m\n-------------\033[0m");
        System.out.println("\033[32m Start Iterm \033[0m");
        System.out.println("\033[32m-------------\033[0m");

        System.out.print("\033[32m[Enter student ID to start iterm] \033[0m");
        String studentID = input.nextLine();

        System.out.print("""
                \033[32m
                -----------------------
                 Choose Iterm to Start
                -----------------------
                1) Accommodation Application
                2) Check-out Application
                3) Accommodation Transfer Application
                4) Apply Early
                5) Apply Late
                6) Item Borrowing Application
                7) Activity Room Borrowing Application
                8) Accommodation Notice
                \033[0m""");
        System.out.print("\033[32m[Enter your iterm number] \033[0m");
        int option = input.nextInt();
        input.nextLine();

        boolean flag = false;
        for (int i = 0; i < studentStore.size(); i++ ) {
            if (studentStore.get(i).getStudentID().equals(studentID)) {
                studentStore.get(i).iterms.set(option - 1, 1);
                flag = true;
                break;
            }
        }
        if  (!flag) {
            System.out.println("\033[32m<You have not been added to the student list yet!>\033[0m");
        }

    } // End of StartIterm


    // The option 3 : Update Iterm Status
    protected void updateStatus() {

        System.out.println("\033[35m\n---------------\033[0m");
        System.out.println("\033[35m Update Status \033[0m");
        System.out.println("\033[35m---------------\033[0m");

        System.out.print("\033[35m[Enter your studentID] \033[0m");
        String studentID = input.nextLine();
        while (!(judgeID(studentID))) {
            System.out.println("\033[35m[Please enter a valid student ID] \033[0m");
            studentID = input.nextLine();
        }

        System.out.print("""
                \033[35m------------------------
                 Choose Iterm to Update
                ------------------------
                1) Accommodation Application
                2) Check-out Application
                3) Accommodation Transfer Application
                4) Apply Early
                5) Apply Late
                6) Item Borrowing Application
                7) Activity Room Borrowing Application
                8) Accommodation Notice\033[0m
                """);
        System.out.print("\033[35m[Enter your iterm number to update] \033[0m");
        int itermNumber = input.nextInt();
        input.nextLine();

        System.out.print("""
                \n\033[35m----------------
                 Update Options
                ----------------
                1) Cancel the Application
                2) Application Succeeded
                3) Application Failed\033[0m
                """);
        System.out.print("\033[35mEnter your update option: \033[0m");
        int option = input.nextInt();
        input.nextLine();

        boolean flag = false;
        for (int i = 0; i < studentStore.size(); i++) {
            if (studentStore.get(i).getStudentID().equals(studentID)) {
                switch (option) {
                    case 1:
                        studentStore.get(i).cancelTerm(itermNumber - 1);
                        flag = true;
                        break;
                    case 2:
                        studentStore.get(i).applicationSuccess(itermNumber - 1);
                        flag = true;
                        break;
                    case 3:
                        studentStore.get(i).applicationFailed(itermNumber - 1);
                        flag = true;
                        break;
                    default:
                        System.out.println("\033[35m<Please enter a valid option!>\033[0m");
                        break;
                }
                break;
            }
        }
        if (!flag) {
            System.out.println("\033[35m<Please enter a valid term number!>\033[0m");
        }

    } // End of UpdateStatus


    // The option 4 : Display Your Projects
    protected void displayPersonalProject() {

        System.out.println("\033[36m\n--------------------------\033[0m");
        System.out.println("\033[36m Display Personal Project \033[0m");
        System.out.println("\033[36m--------------------------\033[0m");

        System.out.print("\033[36m[Enter your studentID] \033[0m");
        String studentID = input.nextLine();
        while (studentID.length() != 12) {
            System.out.println("\033[36m[Please enter a valid student ID] \033[0m");
            studentID = input.nextLine();
        }

        boolean flag = false;
        for (int i = 0; i < studentStore.size(); i++) {
            if (studentStore.get(i).getStudentID().equals(studentID)) {
                System.out.println(studentStore.get(i));
                flag = true;
                break;
            }
        }
        if (!flag) {
            System.out.println("\033[36m<Student ID does not exist!>\033[0m");
        }

    } // End of DisplayPersonalProject


    // The option 5 : Display Everyone's Projects
    protected void displayAllProjects() {

        System.out.println("\033[94m\n---------------------\033[0m");
        System.out.println("\033[94m Display All Project \033[0m");
        System.out.println("\033[94m---------------------\033[0m");

        if (!studentStore.isEmpty()) {
            for (int i = 0; i < studentStore.size(); i++) {
                System.out.println(studentStore.get(i));
            }
        } else {
            System.out.println("\033[94m<Empty>\033[0m");
        }

    } // End of DisplayAllProjects


    // The option 6 : Accommodation Notice
    protected void accommodationNotice() {
        System.out.println(
                """
                               \033[96m\n-----------------------
                                 Accommodation Notice
                               -----------------------
                               1. Keep Quiet: Do not make loud noises after 23:30, open and close doors softly.
                               2. Shared Hygiene: take turns cleaning, clean up garbage daily, and arrange items neatly.
                               3. Save Resources: Turn off the lights and water at will, and use electrical appliances reasonably.
                               4. Friendship and Mutual Assistance: Respect differences, get along harmoniously, and communicate minor conflicts in a timely manner.
                               5. Safety First: Do not use illegal electrical appliances and lock doors and windows when leaving the dormitory.\033[0m
                               """
        );
    }


    // The option 7 : (To Sort in Ascending Order by StudentID)
    protected void sortStudentID() {

        int min;
        for (int i = 0; i < studentStore.size() - 1; i++) {
            min = i;
            for (int j = i + 1; j < studentStore.size(); j++) {
                if (Long.parseLong(studentStore.get(j).getStudentID()) < Long.parseLong(studentStore.get(min).getStudentID())) {
                    min = j;
                }
            }
            if (min != i) {
                StudentApartment temp = studentStore.get(min);
                studentStore.set(min, studentStore.get(i));
                studentStore.set(i,temp);
            }
        }
        displayAllProjects();

    } // End of sortStudentID


    // The option 8 : Delete Student from List
    protected void deleteStudent() {

        System.out.println("\033[35m\n----------------\033[0m");
        System.out.println("\033[35m Delete Student \033[0m");
        System.out.println("\033[35m----------------\033[0m");

        System.out.print("\033[35m[Enter studentID to delete] \033[0m");
        String studentID = input.nextLine();
        while (!(judgeID(studentID))) {
            System.out.println("\033[35m[Please enter a valid student ID] \033[0m");
            studentID = input.nextLine();
        }

        for (int i = 0; i < studentStore.size(); i++) {
            if (studentStore.get(i).getStudentID().equals(studentID)) {
                studentStore.remove(i);
            } else {
                System.out.println("\033[35m<StudentID Not Found>\033[0m");
            }
        }

    } // End of deleteStudent()

}
