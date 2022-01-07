package com.company;

import java.util.Scanner;

public class Main {

    private static boolean MainMenu = true;
    private static boolean SubMenu = true;


    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
//
        //TODO use String instead of Room

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

        int roomNum = 0;

        initialise(hotel);

        loop:
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

                    case "A" -> BookARoom(hotel, roomNum);
                    case "E" -> CheckIfEmpty(hotel);
                    case "V" -> ViewAllRooms(hotel);
                    case "D" -> DeleteCustomerFromRoom(hotel, roomNum);
                    case "X" -> {
                        break loop;
                    }
                    default -> System.out.println("Invalid Selection");
                }

                System.out.println("Would you like to Select another Option\n1 ) Yes\n2 ) No");


                if (input.nextInt() == 1) {
                    SubMenu = true;
                } else {
                    SubMenu = false;
                }
            }

            SubMenu = true;

            System.out.println("Would You Like To Continue With The Program\n1 ) Yes\n2 ) No");

            if (input.nextInt() == 1) {
                MainMenu = true;
            } else {
                System.out.println("");
                System.exit(0);

            }
        }

    }

    private static void initialise(Room[] myHotel) {
        for (int x = 0; x < myHotel.length; x++) {
            myHotel[x].setName("nobody");
        }
    }

    private static void CheckIfEmpty(Room[] myHotel) {
        for (int x = 0; x < myHotel.length; x++) {
            if (myHotel[x].getName().equals("nobody")) {
                System.out.println("room " + (x + 1) + " is empty");
            }
        }
    }

    private static void BookARoom(Room[] myHotel, int roomNum) {
        String roomName;
        Scanner input = new Scanner(System.in);
        System.out.println("Enter room number (1-10):");
        roomNum = input.nextInt() - 1;
        System.out.println("Enter name for room " + (roomNum + 1) + " :");
        roomName = input.next();
        myHotel[roomNum].setName(roomName);
    }

    private static void ViewAllRooms(Room[] myHotel) {
        for (int x = 0; x < myHotel.length; x++) {
            System.out.println("room " + (x + 1) + " occupied by " + myHotel[x].getName());
        }
    }

    private static void DeleteCustomerFromRoom(Room[] myHotel, int roomNum) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter room number to delete(1-10):");
        roomNum = input.nextInt() - 1;
        myHotel[roomNum].setName("nobody");
        System.out.println("Room deleted :)");
    }

    public static class Room {

        private String mainName;

        public Room() {
            mainName = "k";

        }

        public void setName(String aName) {
            mainName = aName;
        }

        public String getName() {
            return mainName;
        }
    }
}
