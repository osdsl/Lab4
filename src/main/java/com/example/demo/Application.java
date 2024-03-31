package com.example.demo;

import org.springframework.stereotype.Component;
import java.util.List;
import java.util.Scanner;

/**
 * Консольное приложение для работы с бд
 */
@Component
public class Application {
    /**
     * Сервис для работы с телевизорами
     */
    private final TvService tvService;

    /**
     * Конструктор приложения
     * @param tvService сервис для работы с телевизорами
     */
    public Application(TvService tvService) {
        this.tvService = tvService;
    }

    /**
     * Метод запуска консольного приложения
     */
    public void run() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("1 - Add New brand of TV");
            System.out.println("2 - Show information about TV");
            System.out.println("3 - Change information about TV");
            System.out.println("4 - Find a TV");
            System.out.println("5 - Delete information about the TV");
            System.out.println("6 - Exit");
            // другие опции...
            String choice = scanner.nextLine();
            switch (choice) {
                case "1" -> addTv(scanner);
                case "2" -> showAllTv();
                case "3" -> editTv(scanner);
                case "4" -> searchTv(scanner);
                case "5" -> deleteTv(scanner);
                case "6" -> {
                    System.out.println("Exit from Program");
                    return;
                }
                default -> System.out.println("Error! Incorrect command!");
            }
        }
    }

    /**
     * Считывает данные объекта из коммандной строки
     * @param scanner объект класса Scanner
     * @return новый телевизор
     */
    private Tv getTv(Scanner scanner){
        System.out.println("Enter the brand name of TV:");
        String name = scanner.nextLine();
        System.out.println("Enter the type of TV:");
        String color = scanner.nextLine();
        System.out.println("Enter the product name of TV:");
        String brand = scanner.nextLine();
        System.out.println("Enter the diagonal of the TV screen:");
        int size = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter the price:");
        double price = Double.parseDouble(scanner.nextLine());
        System.out.println("Enter the quantity of the product:");
        int quantity = Integer.parseInt(scanner.nextLine());
        return new Tv(name, color, brand, size, price, quantity);
    }

    /**
     * Добавляет новый телевизор в базу
     * @param scanner объект класса Scanner
     */
    private void addTv(Scanner scanner) {
        Tv tv = getTv(scanner);
        tvService.addTv(tv);
        System.out.println("The new TV has been successfully added!");
    }

    /**
     * Выводит в консоль информацию обо всех объектах
     */
    private void showAllTv() {
        List<Tv> furnitureList = tvService.getAllTv();
        if (furnitureList.isEmpty()) {
            System.out.println("Product not found.");
        } else {
            for (Tv furniture : furnitureList) {
                System.out.println(furniture);
            }
        }
    }

    /**
     * Редактирует информацию о Телевизорах
     * @param scanner объект класса Scanner
     */
    private void editTv(Scanner scanner) {
        showAllTv();
        System.out.println("Enter the ID of the object to edit:");
        int id = Integer.parseInt(scanner.nextLine());
        Tv updatedTv = getTv(scanner);
        tvService.updateTv(id, updatedTv);
        System.out.println("The list of TVs has been successfully updated!");
    }

    /**
     * Удаляет телевизор по id
     * @param scanner объект класса Scanner
     */
    private void deleteTv(Scanner scanner) {
        System.out.println("Enter the TV ID to delete:");
        int id = Integer.parseInt(scanner.nextLine());
        tvService.deleteTv(id);
        System.out.println("The TV has been successfully deleted!");
    }

    /**
     * Ищет телевизор по одному из полей
     * @param scanner объект класса Scanner
     */
    private void searchTv(Scanner scanner) {
        System.out.println("Select the search criteria:");
        System.out.println("1 - Brand");
        System.out.println("2 - Type");
        System.out.println("3 - Product name");
        String field;
        switch (scanner.nextLine()) {
            case "1" -> field = "brand";
            case "2" -> field = "type";
            case "3" -> field = "brand";
            default -> {
                System.out.println("Wrong command, try again");
                return;
            }
        }
        System.out.println("Enter a value to search:");
        String value = scanner.nextLine();
        List<Tv> tvList = tvService.searchTv(field, value);
        if (tvList.isEmpty()) {
            System.out.println("TV not found");
        } else {
            for (Tv tv : tvList) {
                System.out.println(tv);
            }
        }
    }
}
