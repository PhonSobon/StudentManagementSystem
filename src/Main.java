import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Student {
    int id;
    String name;
    String gender;
    int age;
    String classroom;
    float score;

    Student() {
    }

    Student(int id, String name, String gender,int age,String classroom,float score) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.age =age;
        this.classroom = classroom;
        this.score = score;

    }
    void outputInformation() {
        System.out.print("ID: "+id+"|Name: "+name+"|Gender: "+gender+"|Age: "+age+"|ClassRoom: "+classroom+"|Score: "+score+"\n");

    }

    void inputInformation(Scanner input) {
        boolean isIDValid = false;
        do {
            String strId;
            System.out.println("Enter ID : ");
            try {
                strId = input.next();
                id = Integer.parseInt(strId);
                isIDValid = true;
            } catch (Exception ex) {
                System.out.println(" Invalid ID format!! (Integer only! )");
            }
        } while (!isIDValid);

        System.out.println("Enter Name : ");
        input.nextLine();
        name = input.nextLine();
        System.out.println("Enter Gender : ");
        gender = input.nextLine();
        boolean isAgeValid = false;
        do {
            System.out.println("Enter Age : ");
            try {
                String strAge;
                strAge= input.next();
                age= Integer.parseInt(strAge);
                isAgeValid = true;
            } catch (Exception ex) {
                System.out.println(" Invalid Age format!! (Integer only! )");
            }
        } while (!isAgeValid);
        boolean isRoomValid = false;
        do {
            String strRoom;
            System.out.println("Enter Student ClassRoom : ");
            try {
                strRoom = input.next();
                classroom =String.format(strRoom);
                isRoomValid = true;
            } catch (Exception ex) {
                System.out.println(" Invalid ClassRoom format!! (Integer only! )");
            }
        } while (!isRoomValid);
        boolean isScoreValid = false;
        do {
            String strScore;
            System.out.println("Enter Student Score : ");
            try {
                strScore= input.next();
                score= Integer.parseInt(strScore);
                isScoreValid = true;
            } catch (Exception ex) {
                System.out.println(" Invalid Age format!! (Integer only! )");
            }
        } while (!isScoreValid);

    }

}

public class Main {
    static void pressEnterKey(){
        Scanner scanner = new Scanner(System.in);
        System.out.println(" ========================Press Enter to continue========================");
        scanner.nextLine();
    }
    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<>();
        Scanner input = new Scanner(System.in);
        Student newStudent = new Student();
        boolean isStudentExist = false;
        int option = 0;
        do {
            System.out.println("--------------- Student Information ------------------");
            System.out.println("1. insert Student information");
            System.out.println("2. Edit Student information ");
            System.out.println("3. Delete student infomartion");
            System.out.println("4. Search student information");
            System.out.println("5. Show student information ");
            System.out.println("6. Exit");

            String strOption;
            System.out.print(">>> Choose option from 1 - 6 : ");
            strOption = input.nextLine();
            try {
                option = Integer.parseInt(strOption);
            } catch (Exception ex) {
                option=0;
                System.out.println("Error !!Invalid input-----!Try again");
                pressEnterKey();
            }
            if(option<0){
                System.out.println("Wrong Option! Choose again Form (1-6)");
            }
            switch (option) {
                case 1:
                    System.out.println("******************Add Student********************** ");
                    Student addStudent = new Student();
                    addStudent.inputInformation(input);
                    students.add(addStudent);
                    System.out.println("Successfully added.....!");
                    input.nextLine();
                    break;
                case 2:
                    System.out.println("********************update student information****************");
                    int editId;
                    System.out.println("Enter student Id:");
                    editId = input.nextInt();
                    for(int i = 0; i < students.size(); i++){
                        if(editId == students.get(i).id){
                            // student exist
                            isStudentExist = true;
                            Student student =new Student();
                            student.inputInformation(input);
                            students.set(i,student);
                            System.out.println("Successfully updated.....!");
                        }
                    }
                    if(!isStudentExist){
                        System.out.println("students with ID = " + editId + " doesn't exist !!!");
                    }
                    input.nextLine();
                    break;
                case 3:
                    int deleteId;
                    System.out.println("*****************Delete student information********************");
                    System.out.println("Enter student Id:");
                    deleteId = input.nextInt();
                    for(int i = 0; i < students.size(); i++){
                        if(deleteId == students.get(i).id){
                            // student exist
                            isStudentExist = true;
                            students.remove(i);
                            System.out.println("Successfully deleted.....!");
                        }
                    }
                    if(!isStudentExist){
                        System.out.println("students with ID = " + deleteId + " doesn't exist !!!");
                    }
                    input.nextLine();
                    break;
                case 4 :
                    label:
                   do {
                       int searchOption=0;
                       System.out.println("************ Search Student***********");
                       System.out.println("1. Search By ID ");
                       System.out.println("2. Search By Name ");
                       System.out.println("3. search By Gender");
                       System.out.println("4. search By ClassRoom");
                       System.out.println("5. exist to search!");
                       System.out.print(">>>>Choose option 1 - 4 : ");
                       try{
                           searchOption=input.nextInt();
                       }catch (Exception ex){
                           System.out.println("Error !!Invalid input-----!Try again");
                           pressEnterKey();
                       }
                       switch(searchOption){
                           case 1 :
                               int searchID;
                               System.out.println("*********** Search By ID *********** ");
                               System.out.println("Enter ID to search : ");
                               searchID = input.nextInt();
                               for(int i = 0; i < students.size(); i++){
                                   if(searchID== students.get(i).id){
                                       isStudentExist = true;
                                       students.get(i).outputInformation();
                                   }
                               }
                               if(!isStudentExist){
                                   System.out.println("students with ID = "+searchID+" doesn't exist !!!");
                               }
                               pressEnterKey();
                               break;
                           case 2 :
                               System.out.println("*********** Search By Name *********** ");
                               String searchName ;
                               isStudentExist=false;
                               System.out.println("Enter name to search : ");
                               input.nextLine();
                               searchName = input.nextLine();
                               for(int i =0; i < students.size(); i++){
                                   if(searchName.equals(students.get(i).name)){
                                       isStudentExist = true;
                                       students.get(i).outputInformation();
                                   }
                               }
                               if(!isStudentExist){
                                   System.out.println("Student with name = "+searchName+" doesn't exist !!!");
                               }
                               pressEnterKey();
                               break;
                           case 3:
                               System.out.println("*********** Search By Gender *********** ");
                               input.nextLine();
                               String searchGender;
                               System.out.println("Enter gender to search : ");
                               searchGender = input.nextLine();
                               isStudentExist = false;
                               for(int i = 0; i < students.size(); i++){
                                   if(searchGender.equalsIgnoreCase(students.get(i).gender)){
                                       isStudentExist = true;
                                       students.get(i).outputInformation();
                                   }
                               }
                               if(!isStudentExist){
                                   System.out.println("Student with gender = "+searchGender+" doesn't exist !!!");
                               }
                               pressEnterKey();
                               break;
                           case 4:
                               System.out.println("*********** Search By ClassRoom *********** ");
                               input.nextLine();
                               String searchClassRoom;
                               System.out.println("Enter class room to search : ");
                               searchClassRoom = input.nextLine();
                               isStudentExist = false;
                               for(int i = 0; i < students.size(); i++) {
                                   if (searchClassRoom.equalsIgnoreCase(students.get(i).classroom)) {
                                       isStudentExist = true;
                                       students.get(i).outputInformation();
                                   }
                               }
                               if(!isStudentExist){
                                   System.out.println("Student with classroom = "+searchClassRoom+" doesn't exist !!!");
                               }
                               pressEnterKey();
                               break;
                           case 5: break label;
                       }
                   }while (true);
                    break;

                case 5:
                    if (students.isEmpty()) {
                        System.out.println("No student information to show !");
                    } else {
                        System.out.println(" *************** Student Information ******************");
                        for (int i = 0; i < students.size(); i++) {
                            students.get(i).outputInformation();
                        }
                    }
                    pressEnterKey();
                    break;
                case 6:
                    System.out.println("Exit the program...!!");
                    break;
            }
            System.out.println("press enter agin to continue...");
            input.nextLine();
        } while (option != 6);

    }
}
