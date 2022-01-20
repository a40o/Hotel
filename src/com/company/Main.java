package com.company;

import java.util.Scanner;

public class Main {

    private static boolean SubMenu = true;


    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        Room[] hotel = new Room[20];
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
        hotel[10] = new Room();
        hotel[11] = new Room();
        hotel[12] = new Room();
        hotel[13] = new Room();
        hotel[14] = new Room();
        hotel[15] = new Room();
        hotel[16] = new Room();
        hotel[17] = new Room();
        hotel[18] = new Room();
        hotel[19] = new Room();

        Initialise(hotel);

        for (int i = 1; i == 1; ) {
            loop1:
            while (true) {

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
                            break loop1;
                        }
                        default -> System.out.println("Invalid Selection");
                    }

                    System.out.println("Would you like to Select another Option\n1 ) Yes\n2 ) No");

                    String menuChoice = input.next();
                    try {
                        if (Integer.parseInt(menuChoice) == 1) {
                            SubMenu = true;
                        } else if (Integer.parseInt(menuChoice) == 2) {
                            break loop1;
                        } else {
                            System.out.println("Invalid");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Error!\nPlease select again.");
                    }
                }
            }

            SubMenu = true;

            System.out.println("Would You Like To Continue With The Program\n1 ) Yes\n2 ) No");

            String exitChoice = input.next();
            try {
                if (Integer.parseInt(exitChoice) == 1) {
                    System.out.println("Good");
                } else if (Integer.parseInt(exitChoice) == 2) {
                    System.out.println("Goodbye!");
                    i = 2;
                } else {
                    System.out.println("Invalid");
                }
            } catch (NumberFormatException e) {
                System.out.println("Error!\nPlease select again.");
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
            System.out.println("Enter room number (1-20):");

            String roomNum = input.nextLine();
            try {
                if (Integer.parseInt(roomNum) > 20 || Integer.parseInt(roomNum) < 1) {
                    System.out.println("Invalid option");
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input");
                break;
            }
            Features(Integer.parseInt(roomNum));

            System.out.println("Would you still want to book this room?\n1) Yes\n2) No");
            String choice = input.nextLine();
            try {
                if (Integer.parseInt(choice) == 2) {
                    break;
                }
                System.out.println("Enter name for room " + (roomNum) + " :");
                roomName = input.next();
                myHotel[Integer.parseInt(roomNum) - 1].setName(roomName);
                i++;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input");
                break;
            }
        }
    }

    static void Features(int i) {
        System.out.println("Room №: " + i + " features:");

        switch (i) {
            case 1 -> System.out.println("Number of beds : 1\nAC : Yes\nFree breakfast : No\nBaby bed : No\n");
            case 2 -> System.out.println("Number of beds : 2\nAC : No\nFree breakfast : Yes\nBaby bed : Yes\n");
            case 3 -> System.out.println("Number of beds : 3\nAC : Yes\nFree breakfast : Yes\nBaby bed : No\n");
            case 4 -> System.out.println("Number of beds : 2\nAC : Yes\nFree breakfast : No\nBaby bed : Yes\n");
            case 5 -> System.out.println("Number of beds : 1\nAC : No\nFree breakfast : No\nBaby bed : No\n");
            case 6 -> System.out.println("Number of beds : 1\nAC : No\nFree breakfast : Yes\nBaby bed : Yes\n");
            case 7 -> System.out.println("Number of beds : 3\nAC : No\nFree breakfast : Yes\nBaby bed : No\n");
            case 8 -> System.out.println("Number of beds : 4\nAC : No\nFree breakfast : No\nBaby bed : No\n");
            case 9 -> System.out.println("Number of beds : 4\nAC : Yes\nFree breakfast : No\nBaby bed : No\n");
            case 10 -> System.out.println("Number of beds : 3\nAC : Yes\nFree breakfast : No\nBaby bed : No\n");
            case 11 -> System.out.println("Number of beds : 3\nAC : No\nFree breakfast : No\nBaby bed : Yes\n");
            case 12 -> System.out.println("Number of beds : 2\nAC : Yes\nFree breakfast : Yes\nBaby bed : No\n");
            case 13 -> System.out.println("Number of beds : 5\nAC : No\nFree breakfast : No\nBaby bed : No\n");
            case 14 -> System.out.println("Number of beds : 1\nAC : No\nFree breakfast : Yes\nBaby bed : No\n");
            case 15 -> System.out.println("Number of beds : 1\nAC : Yes\nFree breakfast : Yes\nBaby bed : No\n");
            case 16 -> System.out.println("Number of beds : 1\nAC : Yes\nFree breakfast : No\nBaby bed : Yes\n");
            case 17 -> System.out.println("Number of beds : 3\nAC : Yes\nFree breakfast : No\nBaby bed : Yes\n");
            case 18 -> System.out.println("Number of beds : 5\nAC : No\nFree breakfast : Yes\nBaby bed : No\n");
            case 19 -> System.out.println("Number of beds : 4\nAC : Yes\nFree breakfast : Yes\nBaby bed : No\n");
            case 20 -> System.out.println("Number of beds : 3\nAC : No\nFree breakfast : No\nBaby bed : No\n");
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

    private static void DeleteCustomerFromRoom(Room[] myHotel) {
        Scanner input = new Scanner(System.in);
        int i = 1;
        while (i == 1) {
            System.out.println("Enter room number to delete(1-20):");
            String roomNum = input.nextLine(); //-1 !!!!!!!

            try {
                if (Integer.parseInt(roomNum) > 20 || Integer.parseInt(roomNum) < 1) {
                    System.out.println("Invalid option");
                    break;
                }
                myHotel[Integer.parseInt(roomNum) - 1].setName("nobody");
                System.out.println("Room deleted :)");
                i++;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input");
                break;
            }
        }
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
