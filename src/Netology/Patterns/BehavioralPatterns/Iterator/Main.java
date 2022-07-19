package Netology.Patterns.BehavioralPatterns.Iterator;

public class Main {
    public static void main(String[] args) {
        TodoList todoList = new TodoList()
                .addPrimary("Пробежка")
                .addSecondary("Завтрак")
                .addPrimary("Обед")
                .addPrimary("Сон")
                .addSecondary("Ужин");

        for (String task : todoList) {
            System.out.println(task);
        }
    }
}
