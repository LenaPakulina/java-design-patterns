package ru.design.structural.decorator.ex2;

public class Task {
    public static void main(String[] args) {
        Developer developer = new JavaTeamLead(new SeniorJavaDeveloper(new JavaDeveloper()));

        System.out.println(developer.makeJob());
    }
}
