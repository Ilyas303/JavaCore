package homeworks.homework12;


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class App {


    public static void main(String[] args) {
        Person person = new Person();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите данные в произвольном порядке, разделенные пробелом: " +
                "Фамилия Имя Отчество дата-рождения номер-телефона пол возраст");

        String input = scanner.nextLine();
        String[] fields = input.split(" ");

        if (fields.length != 7) {
            throw new CheckingLengthException(("Ошибка: количество введенных данных " + fields.length + ", ожидаем 7."));

        }

        try {
            person.setSurname(fields[0]);
            person.setName(fields[1]);
            person.setPatronymic(fields[2]);
            person.setBirthDate(LocalDate.parse(fields[3], DateTimeFormatter.ofPattern("dd.MM.yyyy")));
            person.setPhoneNumber(fields[4]);
            person.setGender(fields[5]);
            person.setAge(Integer.parseInt(fields[6]));


            String fileName = person.getName() + ".txt";


            try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
                writer.write(person.toString());
                writer.newLine();
            } catch (IOException e) {
                System.err.println("Ошибка при записи в файл: " + e.getMessage());
                e.printStackTrace();
            }

            System.out.println("Данные успешно сохранены в файл: " + fileName);
        } catch (DateTimeParseException e) {
            System.out.println("Ошибка: неверный формат даты. Ожидается dd.MM.yyyy.");
        } catch (NumberFormatException e) {
            System.out.println("Ошибка: неверный формат телефона или возраста.");
        } catch (Exception e) {
            System.out.println("Ошибка: " + e.getMessage());
            e.printStackTrace();
        } finally {
            scanner.close();
        }

    }
}