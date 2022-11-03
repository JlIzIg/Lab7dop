import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws IOException {
        Worker[] work = new Worker[6];
        work[0] = new Worker(0, "Bob", "Jacobs", "John", Worker.Post.master.toString(), 50000, LocalDate.of(1978, Month.AUGUST, 30));
        work[1] = new Worker(1, "Sam", "Potter", "Phillip", Worker.Post.counter.toString(), 45000, LocalDate.of(1979, Month.OCTOBER, 5));
        work[2] = new Worker(2, "Diana", "Clark", "Josephine", Worker.Post.seller.toString(), 46000, LocalDate.of(1990, Month.DECEMBER, 3));
        work[3] = new Worker(3, "Sara", "James", "Mary", Worker.Post.programmer.toString(), 44000, LocalDate.of(2004, Month.OCTOBER, 1));
        work[4] = new Worker(4, "Tom", "Coder", "Smith", Worker.Post.worker.toString(), 44000, LocalDate.of(2003, Month.APRIL, 4));
        work[5] = new Worker(5, "Edgard", "Smith", "Bob", Worker.Post.seller.toString(), 45000, LocalDate.of(2002, Month.AUGUST, 4));

        Workers workers = new Workers();
        ArrayList<Worker> workers1 = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            workers1.add(work[i]);
        }
        workers.setWorkers(workers1);
        SaveLoad files = new SaveLoad();
        files.setArrayList(workers1);
        File fl = new File("file.bin");
        files.saveObject(fl);
        files.Clear();
        System.out.println("After clear " +  files.getArrayList());
        files.load(fl);
        System.out.println("After loading " +  files.getArrayList());

    }
}
