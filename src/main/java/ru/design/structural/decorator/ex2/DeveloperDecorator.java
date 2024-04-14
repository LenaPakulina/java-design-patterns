package ru.design.structural.decorator.ex2;

public class DeveloperDecorator implements Developer {
    Developer developer;

    public DeveloperDecorator(Developer developer) {
        this.developer = developer;
    }

    @Override
    public String makeJob() {
        return developer.makeJob();
    }
}
