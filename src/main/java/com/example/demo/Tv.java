package com.example.demo;

/**
 * Класс телевизора
 */
public class Tv {
    /**
     * Идентификатор предмета
     */
    private int id;
    /**
     * Название телевизора
     */
    private String name;
    /**
     * Тип телевизора
     */
    private String type;
    /**
     * Название бренда
     */
    private String brand;
    /**
     * Диагональ телевизора
     */
    private int size;
    /**
     * Цена товара
     */
    private double price;
    /**
     * Количество телевизоров
     */
    private int quantity;

    /**
     * Конструктор класса без параметров
     */
    public Tv(){
        this.name = "Default name";
        this.brand = "";
        this.price = 0;
        this.quantity = 1;
    }

    /**
     * Конструктор класса с параметрами
     * @param name название телевизора
     * @param type тип телевизора
     * @param brand бренд телевизора
     * @param size дигональ телевизора
     * @param price цена товара
     * @param quantity количество товара
     */
    public Tv(String name, String type, String brand, int size, double price, int quantity) {
        this.name = name;
        this.type = type;
        this.brand = brand;
        this.size = size;
        this.price = price;
        this.quantity = quantity;
    }

    /**
     * Получает индекс товара
     * @return индекс товара
     */
    public int getId() {
        return id;
    }

    /**
     * Устанавливает индекс товара
     * @param id индекс товара
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Получает название предмета
     * @return название предмета
     */
    public String getName() {
        return name;
    }

    /**
     * Устанавливает название телевизора
     * @param name название
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Получает тип телевизора
     * @return тип телевизора
     */
    public String getType() {
        return type;
    }

    /**
     * Устанавливает тип телевизора
     * @param type тип телевизора
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Получает бренд телевизора
     * @return название бренда
     */
    public String getBrand() {
        return brand;
    }

    /**
     * Устанавливает бренд  телевизора
     * @param brand название бренда
     */
    public void setBrand(String brand) {
        this.brand = brand;
    }

    /**
     * Получает диагональ телевизора
     * @return диагональ телевизора
     */
    public int getSize() {
        return size;
    }

    /**
     * Устанавливает диагональ телевизора
     * @param size диагональ телевизора
     */
    public void setSize(int size) {
        this.size = size;
    }

    /**
     * Получает текущую цену
     * @return цена товара
     */
    public double getPrice() {
        return price;
    }

    /**
     * Устанавливает цену товара
     * @param price цена товара
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * Получает количество товара
     * @return количество
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Устанавливает количество товара
     * @param quantity количество
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * Создаёт строковое представление объекта
     * @return строковое представление объекта
     */
    @Override
    public String toString() {
        return String.format(
                "ID: %d, Brand: %s, Type: %s, Product Name: %s, Screen diagonal: %d, Price: %.2f ₽, Quantity: %d",
                id, name, type, brand, size, price, quantity
        );
    }
}
