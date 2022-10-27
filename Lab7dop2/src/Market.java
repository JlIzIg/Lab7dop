import java.io.Serializable;
import java.time.LocalDate;
import java.util.Comparator;

/**
 * Базовый уровень.
 * Вариант 1
 * Поля класса:
 * Продавец
 * Наименование
 * Количество
 * Цена
 * Дата продажи
 **/
public class Market implements Serializable {
    private static final long serialVersionUD = 1L;
    /**
     * поле продавец
     **/
    private String salesman;
    /**
     * поле наименование
     **/
    private String name_product;
    /**
     * поле количество
     **/
    private int quantity;
    /**
     * поле цена
     **/
    private int price;
    /**
     * поле дата продажи
     **/
    private LocalDate date_seller = LocalDate.now();
    /**
     * константы класса
     **/
    public static final LocalDate MAX_DATA = LocalDate.now();
    public static int MIN_PRICE = 1;
    public static int MIN_QUANTITY = 1;

    /**
     * геттед для salesman
     **/
    public String getSalesman() {
        return salesman;
    }

    /**
     * сеттер для salesman
     **/
    public void setSalesman(String salesman) {
        this.salesman = salesman;
    }

    /**
     * геттер для name_product
     **/
    public String getName_product() {
        return name_product;
    }

    /**
     * сеттер для name_product
     **/

    public void setName_product(String name_product) {
        this.name_product = name_product;
    }

    /**
     * геттер для quantity
     **/

    public int getQuantity() {
        return quantity;
    }

    /**
     * сеттер для quantity
     **/

    public void setQuantity(int quantity) {
        if (quantity < MIN_QUANTITY)
            this.quantity = MIN_QUANTITY;
        else
            this.quantity = quantity;
    }

    /***геттер для price*/

    public int getPrice() {
        return price;
    }

    /**
     * сеттер для price
     **/

    public void setPrice(int price) {
        if (price < MIN_PRICE)
            this.price = MIN_PRICE;
        else
            this.price = price;
    }

    /**
     * геттер для date_seller
     **/

    public LocalDate getDate_seller() {
        return date_seller;
    }

    /**
     * сеттер для date_seller
     **/

    public void setDate_seller(LocalDate date_seller) {

        if (date_seller.isAfter(MAX_DATA))
            this.date_seller = MAX_DATA;
        else
            this.date_seller = date_seller;
    }

    /**
     * конструктор класса
     **/
    public Market() {
    }

    /**
     * параметризированный конструктор класса
     **/

    public Market(String salesman, String name_product, int quantity, int price, LocalDate date_seller) {
        this.salesman = salesman;
        this.name_product = name_product;
        this.setQuantity(quantity);
        this.setPrice(price);
        this.setDate_seller(date_seller);
    }


    /**
     * enum для поля salesman, то есть возможные значения имён продавцов
     **/

    enum Name_sal {
        ИВАНОВ,
        ПЕТРОВ,
        СИДОРОВ,
        ПУШКИН,
        ЛЕРМОНТОВ,
        ЧАЙКОВСКИЙ
    }

    /**
     * enum для поля name_product, то есть возможные значения названий товаров
     **/
    enum Product_NAME {
        ТЕЛЕФОН,
        КОМПЬЮТЕР,
        ТЕЛЕВИЗОР,
        ХОЛОДИЛЬНИК,
        МЫШЬ,
        ПРИНТЕР,
        ПОДСТАВКА,
        КНИГА,
        ЖУРНАЛ,
        ТАБЛЕТКИ,
        ТЕРМОПАСТА,
        ЛУЧ,
        ПУЗЫРИ
    }

    @Override
    public String toString() {
        String str = "Продал: " + getSalesman() + ". Товар: " + getName_product() + ". Штук: " + getQuantity() + ". Цена: " + getPrice() + ". Дата продажи " + getDate_seller();
        return str;

    }

    /**
     * Компаратор по полю цена
     **/
    public static Comparator<Market> byPrice = (o1, o2) -> o1.getPrice() < o2.getPrice() ? 1 : o1.getPrice() > o2.getPrice() ? -1 : 0;
}