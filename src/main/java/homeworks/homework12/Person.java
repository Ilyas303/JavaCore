package homeworks.homework12;


import java.time.LocalDate;
import java.util.Objects;

public class Person {
    private String surname;
    private String name;
    private String patronymic;
    private LocalDate birthDate;
    private String phoneNumber;
    private String gender;
    private Integer age;



    public Person() {
    }

    public Person(String surname, String name, String patronymic, LocalDate birthDate, String phoneNumber, String gender, Integer age) {
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        this.birthDate = birthDate;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
        this.age = age;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        if (surname == null || surname.isEmpty()) {
            throw new IllegalArgumentException(" фамилимя,имя и отчетсво не может быть пустым и должно быть строкой.");
        }
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("фамилимя,имя и отчетсво не может быть пустым и должно быть строкой");
        }
        this.name = name;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        if (patronymic == null || patronymic.isEmpty()) {
            throw new IllegalArgumentException("фамилимя,имя и отчетсво не может быть пустым и должно быть строкой");
        }
        this.patronymic = patronymic;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        if (birthDate == null || birthDate.isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("Дата рождения не может быть в будущем.");
        }
        this.birthDate = birthDate;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        if (phoneNumber == null || !phoneNumber.matches("\\d{10}")) {
            throw new IllegalArgumentException("Номер телефона должен состоять из 10 цифр.");
        }
        this.phoneNumber = phoneNumber;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        if (!Objects.equals(gender, "f") && !Objects.equals(gender, "m")) {
            throw new IllegalArgumentException("Пол может быть только 'f' или 'm'.");
        }
        this.gender = gender;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        if (age < 0) {
            throw new IllegalArgumentException("Возраст не может быть отрицательным.");
        }
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "surname='" + surname + '\'' +
                ", name='" + name + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", birthDate=" + birthDate +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", gender='" + gender + '\'' +
                ", age=" + age +
                '}';
    }
}