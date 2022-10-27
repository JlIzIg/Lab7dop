import java.io.IOException;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        /**демонстрация класса Worker**/
        System.out.println("Демонстрация класса Worker");
        Worker[] work = new Worker[5];
        work[0] = new Worker(0, "Bob", "Jacobs", "John", Worker.Post.master.toString(), 50000, LocalDate.of(1978, Month.AUGUST, 30));
        work[1] = new Worker(1, "Sam", "Potter", "Phillip", Worker.Post.counter.toString(), 45000, LocalDate.of(1979, Month.OCTOBER, 5));
        work[2] = new Worker(2, "Diana", "Clark", "Josephine", Worker.Post.seller.toString(), 46000, LocalDate.of(1990, Month.DECEMBER, 3));
        work[3] = new Worker(3, "Sara", "James", "Mary", Worker.Post.programmer.toString(), 44000, LocalDate.of(2004, Month.OCTOBER, 1));
        work[4] = new Worker(4, "Tom", "Coder", "Smith", Worker.Post.worker.toString(), 44000, LocalDate.of(2003, Month.APRIL, 4));
        Workers workers = new Workers();
        ArrayList<Worker> workers1 = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            workers1.add(work[i]);
        }
        workers.setWorkers(workers1);
        System.out.println(workers.getInfo(workers.getMinAge(workers.getWorkers().size())));
        workers.removeByIndex(workers.getMinAge(workers.getWorkers().size()));
        System.out.println(workers.getInfo(workers.getMinAge(workers.getWorkers().size())));
        workers1.remove(workers.getMinAge(workers.getWorkers().size()));
        System.out.println(workers.getInfo(workers.getMinAge(workers.getWorkers().size())));


/**демонстрация класса Market**/
        System.out.println("");
        System.out.println("Демонстрация класса Market");
        Market[] market = new Market[11];
        market[0] = new Market(Market.Name_sal.ИВАНОВ.toString(), Market.Product_NAME.КНИГА.toString(), 5, 200, LocalDate.of(2022, Month.APRIL, 1));
        market[1] = new Market(Market.Name_sal.ИВАНОВ.toString(), Market.Product_NAME.КНИГА.toString(), 5, 200, LocalDate.of(2022, Month.APRIL, 2));
        market[2] = new Market(Market.Name_sal.ИВАНОВ.toString(), Market.Product_NAME.КОМПЬЮТЕР.toString(), 1, 10000, LocalDate.of(2022, Month.APRIL, 3));
        market[3] = new Market(Market.Name_sal.ЧАЙКОВСКИЙ.toString(), Market.Product_NAME.ЖУРНАЛ.toString(), 5, 50, LocalDate.of(2022, Month.APRIL, 4));
        market[4] = new Market(Market.Name_sal.ИВАНОВ.toString(), Market.Product_NAME.ПРИНТЕР.toString(), 5, 2000, LocalDate.of(2022, Month.APRIL, 5));
        market[5] = new Market(Market.Name_sal.ПЕТРОВ.toString(), Market.Product_NAME.КНИГА.toString(), 4, 250, LocalDate.of(2022, Month.APRIL, 6));
        market[6] = new Market(Market.Name_sal.ИВАНОВ.toString(), Market.Product_NAME.МЫШЬ.toString(), 5, 250, LocalDate.of(2022, Month.APRIL, 7));
        market[7] = new Market(Market.Name_sal.ПЕТРОВ.toString(), Market.Product_NAME.КНИГА.toString(), 5, 200, LocalDate.of(2022, Month.APRIL, 8));
        market[8] = new Market(Market.Name_sal.ИВАНОВ.toString(), Market.Product_NAME.ПУЗЫРИ.toString(), 2, 20, LocalDate.of(2022, Month.APRIL, 9));
        market[9] = new Market(Market.Name_sal.ЛЕРМОНТОВ.toString(), Market.Product_NAME.КНИГА.toString(), 5, 200, LocalDate.of(2022, Month.APRIL, 10));
        market[10] = new Market(Market.Name_sal.ИВАНОВ.toString(), Market.Product_NAME.КНИГА.toString(), 5, 100, LocalDate.of(2022, Month.APRIL, 10));
        Markets markets = new Markets();
        ArrayList<Market> markets1 = new ArrayList<>();
        for (int i = 0; i < 11; i++) {
            markets1.add(market[i]);
        }
        markets.setMarkets(markets1);
        String nameSeller = Market.Name_sal.ИВАНОВ.toString();
        int quantitySold = markets.getInfoNumberOfSellingProducts(nameSeller)[0];
        int quantityTypes = markets.getInfoNumberOfSellingProducts(nameSeller)[1];
        System.out.println("Продавец " + nameSeller + " продал " + quantityTypes + " типов продуктов. Всего продал " + quantitySold + " продуктов");
        System.out.println("Информация о проданных товарах данным продавцом:\n " + markets.getSoldProducts(nameSeller));
        System.out.println("Информация о самом дорогом товаре проданным данным продавцом:\n " + markets.getExpensiveProd(nameSeller));


        ArrayList<Worker> workers2 = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            workers2.add(work[i]);
        }
        ArrayList<Market> markets2 = new ArrayList<>();
        for (int i = 0; i < 11; i++) {
            markets2.add(market[i]);
        }
        SerializeDeserialize serializeDeserialize = new SerializeDeserialize();
        serializeDeserialize.Serialize("file1.bin", workers2);
        serializeDeserialize.Serialize("file2.bin", markets2);

        serializeDeserialize.Clear(workers2);
        serializeDeserialize.Clear(markets2);

        System.out.println("Объекты после очистки: \n " + workers2 + "\n" + markets2);

        workers2 = serializeDeserialize.Deserialize("file1.bin");
        markets2 = serializeDeserialize.Deserialize("file2.bin");

        System.out.println("Объекты после десериализации: \n " + workers2 + "\n" + markets2);

    }
}

