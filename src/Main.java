import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[][] board = new String[][]{{" ", " ", " "}, {" ", " ", " "}, {" ", " ", " "}};
        didyouWin(board);

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {

                System.out.print("\t" + board[i][j] + " | ");

            }
            System.out.println();
            System.out.println();
        }


        for (int w = 0; w < board.length; w++) {


            while (board[w][w].contains(" ") && didyouWin(board) == false) {

                System.out.println("Kolej gracza X");
                String sign = scanner.nextLine();
                if (sign.contains("X")){

                    System.out.println("Podaj lokalizację");
                } else {
                    System.out.println("Podano nieprawidlowy znak");
                    continue;
                }
                int lokalizacjaX = scanner.nextInt();
                int lokalizacjaY = scanner.nextInt();
                scanner.nextLine();
                if (board[lokalizacjaX][lokalizacjaY].contains(" ")) {
                    for (int i = 0; i < board.length; i++) {
                        for (int j = 0; j < board.length; j++) {
                            board[lokalizacjaX][lokalizacjaY] = sign;
                            System.out.print("\t" + board[i][j] + " | ");

                        }

                        System.out.println();
                    }

                } else {
                    System.out.println("To pole jest już zajęte");

                    while (board[lokalizacjaX][lokalizacjaY].contains("X") ||
                            board[lokalizacjaX][lokalizacjaY].contains("O")){

                        System.out.println("Podaj inną lokalizację");
                        lokalizacjaX = scanner.nextInt();
                        lokalizacjaY = scanner.nextInt();
                        scanner.nextLine();
                    }

                    for (int i = 0; i < board.length; i++) {
                        for (int j = 0; j < board.length; j++) {
                            board[lokalizacjaX][lokalizacjaY] = sign;
                            System.out.print("\t" + board[i][j] + " | ");

                        }

                        System.out.println();
                    }
                }

                if (didyouWin(board) == true) {
                    break;
                }
                System.out.println("Kolej gracza O");
                sign = scanner.nextLine();
                if (sign.contains("O")){

                    System.out.println("Podaj lokalizację");
                } else {
                    System.out.println("Podano nieprawidlowy znak");
                    while (!sign.contains("O")){
                        System.out.println("Podaj prawidlowy znak");
                        sign = scanner.nextLine();

                    }
                    System.out.println("Podaj lokalizację");

                }
                lokalizacjaX = scanner.nextInt();
                lokalizacjaY = scanner.nextInt();
                scanner.nextLine();
                if (board[lokalizacjaX][lokalizacjaY].contains(" ")) {
                    for (int i = 0; i < board.length; i++) {
                        for (int j = 0; j < board.length; j++) {
                            board[lokalizacjaX][lokalizacjaY] = sign;
                            System.out.print("\t" + board[i][j] + " | ");

                        }

                        System.out.println();
                    }

                } else {
                    System.out.println("To pole jest już zajęte");
                    while (board[lokalizacjaX][lokalizacjaY].contains("X") ||
                            board[lokalizacjaX][lokalizacjaY].contains("O")){

                        System.out.println("Podaj inną lokalizację");
                        lokalizacjaX = scanner.nextInt();
                        lokalizacjaY = scanner.nextInt();
                        scanner.nextLine();
                    }
                    for (int i = 0; i < board.length; i++) {
                        for (int j = 0; j < board.length; j++) {
                            board[lokalizacjaX][lokalizacjaY] = sign;
                            System.out.print("\t" + board[i][j] + " | ");

                        }

                        System.out.println();
                    }

                }
                if (didyouWin(board) == true) {
                    break;
                }



            }

        }
    }



    public static boolean didyouWin(String[][] check) {
        boolean didWin = false;

        for (int i = 0; i < 1; i++) {
            for (int j = 0; j < 1; j++) {
                if (check[i][j].contains("X") && check[i + 1][j].contains("X") && check[i + 2][j].contains("X")
                        || check[i][j].contains("O") && check[i + 1][j].contains("O") && check[i + 2][j].contains("O")) {
                    System.out.println("Wygrana");
                    didWin = true;
                    break;

                }
                if (check[i + 1][j].contains("X") && check[i + 1][j + 1].contains("X") && check[i + 1][j + 2].contains("X") ||
                        check[i + 1][j].contains("O") && check[i + 1][j + 1].contains("O") && check[i + 1][j + 2].contains("O")) {
                    System.out.println("Wygrana");
                    didWin = true;
                    break;
                }
                if (check[i + 2][j].contains("X") && check[i + 2][j + 1].contains("X") && check[i + 2][j + 2].contains("X") ||
                        check[i + 2][j].contains("O") && check[i + 2][j + 1].contains("O") && check[i + 2][j + 2].contains("O")) {
                    System.out.println("Wygrana");
                    didWin = true;
                    break;


                }
                if (check[i][j].contains("X") && check[i + 1][j + 1].contains("X") && check[i + 2][j + 2].contains("X") ||
                        check[i][j].contains("O") && check[i + 1][j + 1].contains("O") && check[i + 2][j + 2].contains("O")) {
                    System.out.println("Wygrana");
                    didWin = true;
                    break;


                }
                if (check[i][j + 2].contains("X") && check[i + 1][j + 1].contains("X") && check[i + 2][j].contains("X") ||
                        check[i][j + 2].contains("O") && check[i + 1][j + 1].contains("O") && check[i + 2][j].contains("O")) {
                    System.out.println("Wygrana");
                    didWin = true;
                    break;


                }

                if (check[i][j].contains("X") && check[i][j + 1].contains("X") && check[i][j + 2].contains("X") ||
                        check[i][j].contains("O") && check[i][j + 1].contains("O") && check[i][j + 2].contains("O")) {
                    System.out.println("Wygrana");
                    didWin = true;
                    break;


                }

                if (check[i][j + 1].contains("X") && check[i + 1][j + 1].contains("X") && check[i + 2][j + 1].contains("X") ||
                        check[i][j + 1].contains("O") && check[i + 1][j + 1].contains("O") && check[i + 2][j + 1].contains("O")) {
                    System.out.println("Wygrana");
                    didWin = true;
                    break;


                }
                if (check[i][j + 2].contains("X") && check[i + 1][j + 2].contains("X") && check[i + 2][j + 2].contains("X") ||
                        check[i][j + 2].contains("O") && check[i + 1][j + 2].contains("O") && check[i + 2][j + 2].contains("O")) {
                    System.out.println("Wygrana");
                    didWin = true;
                    break;


                }
            }

        }
        return didWin;
    }



}

