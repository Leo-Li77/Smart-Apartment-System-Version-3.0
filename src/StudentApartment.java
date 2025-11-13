/**
 * Author: Leo (Jinyu Li)
 * Time: 2025-11-13
 */

import java.util.ArrayList;
import java.util.List;

public class StudentApartment {

    // Use ArrayList to simulate the dictionary (Use the first element in the arraylist as a key).
    // This list is created to store the objects.
    // Every person has 7 terms.
    /*
    Each term has 4 status:
      0: Not in Progress (before start but not succeeded or failed)
      1: In Progress
      2: Processing Succeeded
      3: Processing Failed
     */
    ArrayList<Integer> iterms = new ArrayList<>(List.of(0, 0, 0, 0, 0, 0, 0, 0));
    ArrayList<String> status = new ArrayList<>(List.of("<Not in Progress>", "<In Progress>", "<Processing Succeeded>", "<Processing Failed>"));

    private String name;
    private String studentID;
    private String phoneNumber;


    // Constructor without Parameter
    public StudentApartment() {
        this.name = "NAME";
        this.studentID = "000000000000";
        this.phoneNumber = "00000000000";
    }

    // Constructor with Parameters
    public StudentApartment(String name, String studentID, String phoneNumber) {
        setName(name);
        setStudentID(studentID);
        setPhoneNumber(phoneNumber);
    }


    // Validation for Name
    private boolean judgeName(String name) {
        boolean flag = true;
        if (name.length() < 2 || name.trim().isEmpty()) {
            flag = false;
        }
        return flag;
    }


    // Validation for studentID (whether all of which is number and have 12 elements)
    private boolean judgeID(String studentID) {
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
    }


    // Validation for Phone Number (whether all of which is number and have 11 elements)
    private boolean judgePhoneNumber(String telephoneNumber) {
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
    }



    // Setters and Getters
    public String getName() {
        return name;
    }
    public String getStudentID() {
        return studentID;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }


    public void setName(String name) {
        if (judgeName(name)) {
            this.name = name;
        }
    }
    public void setStudentID(String studentID) {
        if (judgeID(studentID)) {
            this.studentID = studentID;
        }
    }
    public void setPhoneNumber(String phoneNumber) {
        if (judgePhoneNumber(phoneNumber)) {
            this.phoneNumber = phoneNumber;
        }
    }


    public void cancelTerm(int serialNumber) {

        if (iterms.get(serialNumber) == 1) {
            iterms.set(serialNumber, 3);
        }

    } // End of cancelTerm()


    public void applicationSuccess(int serialNumber) {

        if (iterms.get(serialNumber) == 1) {
            iterms.set(serialNumber, 2);
        }

    } // End of applicationSuccess()


    public void applicationFailed(int serialNumber) {

        if (iterms.get(serialNumber) == 1) {
            iterms.set(serialNumber, 3);
        }

    } // End of applicationFailed()


    @Override
    public String toString() {

        return "\n{\n" +
                "\033[92m<Name>                                   \033[0m" + name + "\n" +
                "\033[92m<Student ID>                             \033[0m" + studentID + "\n" +
                "\033[92m<Phone Number>                           \033[0m" + phoneNumber + "\n" +
                "\033[92m<Iterms' Status>                         \033[0m" + "\n" +
                "\033[92m  [Accommodation Application]            \033[0m" + status.get(iterms.get(0)) + "\n" +
                "\033[92m  [Check-out Application]                \033[0m" + status.get(iterms.get(1)) + "\n" +
                "\033[92m  [Accommodation Transfer Application]   \033[0m" + status.get(iterms.get(2)) + "\n" +
                "\033[92m  [Apply Early]                          \033[0m" + status.get(iterms.get(3)) + "\n" +
                "\033[92m  [Apply Late]                           \033[0m" + status.get(iterms.get(4)) + "\n" +
                "\033[92m  [Item Borrowing Application]           \033[0m" + status.get(iterms.get(5)) + "\n" +
                "\033[92m  [Activity Room Borrowing Application]  \033[0m" + status.get(iterms.get(6)) + "\n" +
                "\033[92m  [Accommodation Notice]                 \033[0m" + status.get(iterms.get(7)) + "\n" +
                "}";

    } // End of toString()


} // End of StudentApartment Class