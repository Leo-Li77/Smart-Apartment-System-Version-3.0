/**
 * Update (Compared to Version 2.5)
 * 1. Add the SuperDriver Class to store the methods and the arrayList "studentStore".
 * 2. The Driver Class is only used to interact with the user (to show menu and get options from user).
 * 3. Add the option 8 to delete a student from the arrayList "studentStore".

 * Points to Note
 * 1. Check-out Application: It is necessary to check that there are successfully completed accommodation applications before processing the check-out application.
 * 2. Accommodation Transfer Application: It is necessary to check whether there are successfully completed accommodation applications and unsuccessful check-out applications.
 * 3. Item Borrowing Application: Check if the previous item borrowing application was successfully completed.
 * 4. Activity Room Borrowing Application: Check if the previous activity room borrowing application was successfully completed.
 */


public class Driver extends SuperDriver {

    public static void main(String[] args) {

        System.out.println("--------------------------------------");
        System.out.println(" Student Apartment System Version 3.0 ");
        System.out.println("--------------------------------------\n");

        Driver driver = new Driver();

    } // End of main()


    // The constructor of Driver Class
    Driver() {

        runMenu();

    }


    // Show the menu and get option from user.
    public int getOption() {

        System.out.print("""
                \033[34m\n--------------------
                 Operation Choosing
                --------------------
                0) Exit
                1) Add New Student and Start Iterm
                2) Start Iterm
                3) Update Iterm Status
                4) Display Your Projects
                5) Display Everyone's Projects
                6) Accommodation Notice
                7) Sort StudentsID and Display Everyone's Projects
                8) Delete Student from List
                <Before you choose other option, you should add a student at first (Option 1).>\033[0m
                """);
        System.out.print("\033[34m[Enter the number of option to handle] \033[0m");
        int getOperationNumber = input.nextInt();
        input.nextLine();
        return getOperationNumber;

    } // End of getOption()


    // Run methods depends on what option you get from your user.
    public void runMenu() {

        int option = getOption();
        while (option != 0) {
            switch (option) {
                case 1  ->  addAndStart();
                case 2  ->  startIterm();
                case 3  ->  updateStatus();
                case 4  ->  displayPersonalProject();
                case 5  ->  displayAllProjects();
                case 6  ->  accommodationNotice();
                case 7  ->  sortStudentID();
                case 8  ->  deleteStudent();
                default ->  System.out.println("\033[34m<Invalid option. Try again.>\033[0m");
            }
            System.out.println("\033[34m\n<Press Enter to continue...>\033[0m");
            input.nextLine();
            option = getOption();
        }

    } // End of runMenu()

} // End of Driver Class