import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;
import java.util.Arrays;

/**
 * Средний уровень.
 * Вариант 1
 * Поля класса:
 * Фамилия
 * Имя
 * Отчество
 * Должность
 * Зарплата
 * Дата рождения
 **/

public class Worker implements Serializable {
    /**
     * поле id ведено для удобства
     **/
    private int id;
    /**
     * поле имя
     **/
    private String name;
    /**
     * поле фамилия
     **/
    private String surname;
    /**
     * поле отчество
     **/
    private String father_name;
    /**
     * поле должность
     **/
    private String post;
    /**
     * поле з/п
     **/

    private int salaries;
    /**
     * поле день рождения. по умолчанию будет текущая дата
     **/
    private LocalDate birthday = LocalDate.now();
    /**
     * константы класса
     **/
    public static final int MIN_AGE = 18;
    public static final int MAX_AGE = 90;
    public static final LocalDate MAX_DATA = LocalDate.of(LocalDate.now().getYear() - MIN_AGE, LocalDate.now().getMonth(), LocalDate.now().getDayOfMonth());
    public static final LocalDate MIN_DATA = LocalDate.of(LocalDate.now().getYear() - MAX_AGE, LocalDate.now().getMonth(), LocalDate.now().getDayOfMonth());
    public static int MIN_SALARIES = 10000;

    /**
     * геттер для id
     **/

    public int getId() {
        return id;
    }

    /**
     * сеттер для id
     **/

    public void setId(int id) {
        this.id = id;
    }

    /**
     * геттер для name
     **/
    public String getName() {
        return name;
    }

    /**
     * сеттер для name
     **/
    public void setName(String name) {
        this.name = name;
    }

    /**
     * геттер для surname
     **/
    public String getSurname() {
        return surname;
    }

    /**
     * сеттер для surname
     **/
    public void setSurname(String surname) {
        this.surname = surname;
    }

    /**
     * геттер для father_name
     **/
    public String getFather_name() {
        return father_name;
    }

    /**
     * сеттер для father_name
     **/
    public void setFather_name(String father_name) {
        this.father_name = father_name;
    }

    /**
     * геттер для post
     **/
    public String getPost() {
        return post;
    }

    /**
     * сеттер для post
     **/
    public void setPost(String post) {
        this.post = post;
    }

    /**
     * геттер для salaries
     **/
    public int getSalaries() {
        return salaries;
    }

    /**
     * сеттер для salaries
     **/
    public void setSalaries(int salaries) {
        if (salaries < MIN_SALARIES)
            this.salaries = MIN_SALARIES;
        else this.salaries = salaries;
    }

    /**
     * геттер для birthday
     **/
    public LocalDate getBirthday() {
        return birthday;
    }

    /**
     * сеттер для birthday
     **/
    public void setBirthday(LocalDate birthday) {
        if (birthday.isAfter(MAX_DATA))
            this.birthday = MAX_DATA;
        else if (birthday.isBefore(MIN_DATA))
            this.birthday = MIN_DATA;
        else
            this.birthday = birthday;
    }

    /**
     * конструктор класса
     **/
    public Worker() {
    }

    /**
     * параметризированный конструктор класса
     **/
    public Worker(int id, String name, String surname, String father_name, String post, int salaries, LocalDate birthday) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.father_name = father_name;
        this.post = post;
        this.setSalaries(salaries);
        this.setBirthday(birthday);
    }


    /**
     * enum для поля пост, то есть возможные значения для должности
     **/
    enum Post {
        master,
        counter,
        seller,
        programmer,
        worker

    }

    @Override
    public String toString() {
        String str = getId() + "/" + getName() + "/" + getFather_name() + "/" + getSurname() + "/" + getPost() + "/" + getSalaries() + "/" + getBirthday();
        return str;
    }
}