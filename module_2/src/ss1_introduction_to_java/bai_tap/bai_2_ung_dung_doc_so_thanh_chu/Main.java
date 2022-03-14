package ss1_introduction_to_java.bai_tap.bai_2_ung_dung_doc_so_thanh_chu;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number, hundreds, dozen, unit;
        String read = "";
        System.out.println(" Enter the number that you want to read: ");
        number = scanner.nextInt();
        hundreds = number / 100;
        dozen = (number / 10) % 10;
        unit = number % 10;
        if (number >= 0 && number < 10000) {
            switch (hundreds) {
                case 1:
                    read += "one hundreds and ";
                    break;
                case 2:
                    read += "two hundreds and ";
                    break;
                case 4:
                    read += "four hundreds and ";
                    break;
                case 5:
                    read += "five hundreds and ";
                    break;
                case 6:
                    read += "six hundreds and ";
                    break;
                case 7:
                    read += "seven hundreds and ";
                    break;
                case 8:
                    read += "eight hundreds and ";
                    break;
                case 9:
                    read += "nine hundreds and ";
                    break;
            }

            if (dozen == 1 && unit >= 0) {
                switch (unit) {
                    case 0:
                        read += "ten ";
                        break;
                    case 1:
                        read += "eleven ";
                        break;
                    case 2:
                        read += "twelve ";
                        break;
                    case 3:
                        read += "thirteen ";
                        break;
                    case 4:
                        read += "fourteen ";
                        break;
                    case 5:
                        read += "fifteen ";
                        break;
                    case 6:
                        read += "sixteen ";
                        break;
                    case 7:
                        read += "seventeen ";
                        break;
                    case 8:
                        read += "eighteen ";
                        break;
                    case 9:
                        read += "nineteen ";
                        break;
                }
            } else if (dozen > 1) {

                switch (dozen) {
                    case 2:
                        read += "twenty ";
                        break;
                    case 3:
                        read += "thirty ";
                        break;
                    case 4:
                        read += "forty ";
                        break;
                    case 5:
                        read += "fifty ";
                        break;
                    case 6:
                        read += "sixty ";
                        break;
                    case 7:
                        read += "seventy ";
                        break;
                    case 8:
                        read += "eighty ";
                        break;
                    case 9:
                        read += "ninety ";
                        break;

                }
            } else if (dozen == 0 && unit == 0) {
                read += "zero";
            }
            switch (unit) {
                case 1:
                    read += "one";
                    break;
                case 2:
                    read += "two";
                    break;
                case 3:
                    read += "three";
                    break;
                case 4:
                    read += "four";
                    break;
                case 5:
                    read += "five";
                    break;
                case 6:
                    read += "six";
                    break;
                case 7:
                    read += "seven";
                    break;
                case 8:
                    read += "eight";
                    break;
                case 9:
                    read += "nine";
                    break;

            }
        } else {
            read += "out of ability";
        }

        System.out.println(number + ":" + read);
    }
}



