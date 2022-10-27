import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

public class Workers implements Serializable {
    private static final long serialVersionUD = 1L;

    public ArrayList<Worker> getWorkers() {
        return workers;
    }

    public void setWorkers(ArrayList<Worker> workers) {
        this.workers = workers;
    }

    private ArrayList<Worker> workers;


    /**
     * метод возвращающий индекс работника с наименьшим возрастом
     **/
    public int getMinAge(int N) {
        int[] age = new int[N];
        for (int i = 0; i < N; i++) {
            age[i] = Period.between(this.workers.get(i).getBirthday(), LocalDate.now()).getYears();
        }
        int min_index = 0;
        for (int i = 0; i < this.workers.size() - 1; i++) {
            if (age[min_index] > age[i + 1]) min_index = (i + 1);
        }
        return min_index;
    }

    public void add(Worker worker) {
        this.workers.add(worker);
    }

    public void remove(Worker worker) {
        this.workers.remove(worker);
    }

    public void removeByIndex(int index) {
        this.workers.remove(index);
    }

    /**
     * метод возвращающий строку информации о сотруднике по id
     **/
    public String getInfo(int id) {
        return "Worker is " + workers.get(id).toString();
    }

}
