package ru.design.creational.builder.ex1;

public class Demo {
    public static void main(String[] args) {
        User user = new User.Builder()
                .setName("Villy")
                .setAge((byte) 23)
                .setLogin("login")
                .setPassword("login2")
                .build();
        System.out.println(user);
    }
}
