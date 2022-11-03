import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

public class Workers implements Serializable {

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
        return "Worker is " + workers.get(id).getName() + " " + workers.get(id).getSurname() + " " + workers.get(id).getFather_name() + ". Post is " + workers.get(id).getPost() + ". Salaries is " + workers.get(id).getSalaries() + ". Date of birthday is " + workers.get(id).getBirthday();
    }


    public ArrayList getFromString(String[] str) {
        ArrayList<Worker> workers1 = new ArrayList<>();
        for (int i = 0; i < str.length; i++) {
            String[] tempStrings = str[i].split("/");
            int k = 0;
            int id = Integer.parseInt(tempStrings[k].replace("[", "").strip());
            String name = tempStrings[k + 1];
            String fatherName = tempStrings[k + 2];
            String surname = tempStrings[k + 3];
            String post = tempStrings[k + 4];
            int salary = Integer.parseInt(tempStrings[k + 5]);
            LocalDate birthday = LocalDate.parse(tempStrings[k + 6].replace("]", ""));
            Worker worker1 = new Worker(id, name, surname, fatherName, post, salary, birthday);
            workers1.add(worker1);
        }

        return workers1;

    }

}
