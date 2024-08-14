package ru.design.creational.builder.ex1;

import java.util.LinkedHashMap;

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
            LinkedHashMap<String, String> map = new LinkedHashMap<>();
            StringBuilder y = new StringBuilder();
            y.append(new String("fsdlfk"));
            User user = new User();
            user.name = name;
            user.age = age;
            user.login = login;
            user.password = password;
            return user;
        }
    }
}
