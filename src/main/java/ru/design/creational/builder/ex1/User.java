package ru.design.creational.builder.ex1;

public class User {
    private String name;
    private byte age;
    private String login;

    private String password;

    static class Builder {
        private String name;
        private byte age;
        private String login;

        private String password;

        Builder setName(String name) {
            this.name = name;
            return this;
        }

        Builder setAge(byte age) {
            this.age = age;
            return this;
        }

        Builder setLogin(String login) {
            this.login = login;
            return this;
        }

        Builder setPassword(String password) {
            this.password = password;
            return this;
        }

        User build() {
            User user = new User();
            user.name = name;
            user.age = age;
            user.login = login;
            user.password = password;
            return user;
        }
    }
}
