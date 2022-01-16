package com.company;

import java.util.Scanner;

public class Main {

    private static boolean MainMenu = true;
    private static boolean SubMenu = true;


    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);


        Room[] hotel = new Room[10];
        hotel[0] = new Room();
        hotel[1] = new Room();
        hotel[2] = new Room();
        hotel[3] = new Room();
        hotel[4] = new Room();
        hotel[5] = new Room();
        hotel[6] = new Room();
        hotel[7] = new Room();
        hotel[8] = new Room();
        hotel[9] = new Room();

        Initialise(hotel);

        loop1:
        while (MainMenu) {
            while (SubMenu) {

                System.out.println("Hello and Welcome to our Hotel Program");
                System.out.println("Please select one of the options:");

                System.out.println("A: Book A New Room.");
                System.out.println();

                System.out.println("E: Display Empty Rooms.");
                System.out.println();

                System.out.println("V: View all Rooms.");
                System.out.println();

                System.out.println("D: Delete customer from room.");
                System.out.println();

                System.out.println("X Exit");

                String Selection = input.next();
                Selection = Selection.toUpperCase();

                switch (Selection) {

                    case "A" -> BookARoom(hotel);
                    case "E" -> CheckIfEmpty(hotel);
                    case "V" -> ViewAllRooms(hotel);
                    case "D" -> DeleteCustomerFromRoom(hotel);
                    case "X" -> {
                        System.out.println("Goodbye!");
                        break loop1;
                    }
                    default -> System.out.println("Invalid Selection");
                }

                System.out.println("Would you like to Select another Option\n1 ) Yes\n2 ) No");


                SubMenu = input.nextInt() == 1;
            }

            SubMenu = true;

            System.out.println("Would You Like To Continue With The Program\n1 ) Yes\n2 ) No");

            if (input.nextInt() == 1) {
                MainMenu = true;
            } else {
                System.out.println();
                System.exit(0);

            }
        }

    }

    private static void Initialise(Room[] myHotel) {
//      (int x = 0; x < myHotel.length; x++)
        for (Room room : myHotel) {
            room.setName("nobody");
        }
    }

    private static void BookARoom(Room[] myHotel) {
        int i = 1;

        while (i == 1) {
            String roomName;
            Scanner input = new Scanner(System.in);
            System.out.println("Enter room number (1-10):");
            int roomNum = input.nextInt() - 1;
            Features(roomNum);
            System.out.println("Would you still want to book this room?\n1) Yes\n2) No");
            int choice = input.nextInt();
            if (choice == 2){
                break;
            }
            System.out.println("Enter name for room " + (roomNum + 1) + " :");
            roomName = input.next();
            myHotel[roomNum].setName(roomName);
            i++;
        }
    }

    static void Features(int i) {
        System.out.println("Room features:");

        switch (i) {
            case 1 -> System.out.println("Number of double beds : 1\nAC : Yes\nFree breakfast : Yes\nBaby bed : No\n");
            case 2 -> System.out.println("Number of double beds : 2\nAC : No\nFree breakfast : Yes\nBaby bed : Yes\n");
            case 3 -> System.out.println("Number of single beds : 3\nAC : Yes\nFree breakfast : Yes\nBaby bed : No\n");
            case 4, 9 -> System.out.println("Number of single beds : 2\nAC : No\nFree breakfast : Yes\nBaby bed : Yes\n");
            case 5 -> System.out.println("Number of single beds : 1\nAC : No\nFree breakfast : Yes\nBaby bed : No\n");
            case 6 -> System.out.println("Number of single beds : 1\nAC : No\nFree breakfast : Yes\nBaby bed : Yes\n");
            case 7 -> System.out.println("Number of single beds : 3\nAC : No\nFree breakfast : Yes\nBaby bed : No\n");
            case 8 -> System.out.println("Number of single beds : 4\nAC : No\nFree breakfast : Yes\nBaby bed : No\n");
            case 10 -> System.out.println("Number of single beds : 5\nAC : No\nFree breakfast : Yes\nBaby bed : No\n");
            default -> System.out.println("Enter valid option");
        }
    }

    private static void ViewAllRooms(Room[] myHotel) {
        for (int x = 0; x < myHotel.length; x++) {
            System.out.println("room " + (x + 1) + " occupied by " + myHotel[x].getName());
        }
    }

    private static void CheckIfEmpty(Room[] myHotel) {
        for (int x = 0; x < myHotel.length; x++) {
            if (myHotel[x].getName().equals("nobody")) {
                System.out.println("room " + (x + 1) + " is empty");
            }
        }
    }

    //TODO add invalid oprions

    private static void DeleteCustomerFromRoom(Room[] myHotel) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter room number to delete(1-10):");
        int roomNum = input.nextInt() - 1;
        myHotel[roomNum].setName("nobody");
        System.out.println("Room deleted :)");
    }

    public static class Room {

        private String mainName;

        public void setName(String aName) {
            mainName = aName;
        }

        public String getName() {
            return mainName;
        }
    }
}
