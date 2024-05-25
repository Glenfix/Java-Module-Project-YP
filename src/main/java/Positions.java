import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Positions {
    public static int userInput;

    public static Scanner scanner = new Scanner(System.in);
    public static ArrayList<Item> positions = new ArrayList<>();

    public static void addPosition(String name, double price) {
        Item position = new Item(name, price);
        positions.add(position);
    }

    public static void addPositionAndPrice() {
        System.out.println("Пожалуйста введите название товара:");
        String name = scanner.next();
        double price;
        System.out.println("Пожалуйста введите цену:");
        do {
            while (!scanner.hasNextDouble()) {
                System.out.println("Ошибка! Введите цену:");
                scanner.next();
            }
            price = scanner.nextDouble();
            if (price <= 0) {
                System.out.println("Цена должна быть больше нуля. Укажите цену заново:");
            }
        } while (price <= 0);
        addPosition(name, price);
        System.out.println("Продолжить добавление товаров? (введите Продолжить/Завершить):");
    }

    public static boolean continueAddPositions() {
        while (true) {
            String userInput = scanner.next().trim().toLowerCase();

            if (userInput.equals("завершить")) {
                return false;
            } else if (userInput.equals("продолжить")) {
                repeatAddPositionAndPrice();
            } else {
                System.out.println("Пожалуйста, выберите ОДНУ из ДОСТУПНЫХ команд (введите Продолжить/Завершить):");
            }
        }
    }

    public static void cheque() {
        System.out.println("Добавленные товары:");
        for (Item cheque : positions) {
            System.out.println("Товар: " + "'" + cheque.name + "' " + "за " + cheque.price + " " + rublesFormat(cheque.price) + ".");
        }
    }


    public static void conclusion() {
        double sum = 0.0;
        for (Item cheque : positions) {
            double price = cheque.price;
            sum += price;
        }
        double sharePrice = sum / userInput;
        String printPrice = String.format("%.2f", sharePrice);
        String rubles = rublesFormat(sharePrice);
        System.out.println("Каждый человек должен заплатить: " + printPrice + " " + rubles);
    }

    private static String rublesFormat(double amount) {
        int sum = (int) Math.floor(amount);
        if (sum % 100 >= 11 && sum % 100 <= 19) {
            return "рублей";
        }
        return switch (sum % 10) {
            case 1 -> "рубль";
            case 2, 3, 4 -> "рубля";
            default -> "рублей";
        };
    }

    public static void repeatAddPositionAndPrice() {
        addPositionAndPrice();
    }

    public static void theQuestion() {
        while (true) {
            try {
                userInput = scanner.nextInt();

                if (userInput == 1) {
                    System.out.println("Должно быть как минимум 2 человека, для разделения счёта. Пожалуйста, укажите число:");
                } else if (userInput > 1) {
                    break;

                } else if (userInput <= 0) {
                    System.out.println("Пожалуйста, укажите число больше нуля:");
                } else {
                    System.out.println("Пожалуйста, укажите число:");
                }
            } catch (InputMismatchException e) {
                System.out.println("Ошибка! укажите число:");
                scanner.next();
            }
        }
    }
}
