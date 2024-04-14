package ru.design.creational.factory.ex1.factory;

import ru.design.creational.factory.ex1.developer.Developer;
import ru.design.creational.factory.ex1.developer.JavaDeveloper;

public class JavaDeveloperFactory implements DeveloperFactory {
    @Override
    public Developer createDeveloper() {
        return new JavaDeveloper();
    }
}
