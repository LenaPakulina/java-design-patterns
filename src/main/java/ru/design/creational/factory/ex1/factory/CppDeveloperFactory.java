package ru.design.creational.factory.ex1.factory;

import ru.design.creational.factory.ex1.developer.CppDeveloper;
import ru.design.creational.factory.ex1.developer.Developer;

public class CppDeveloperFactory implements DeveloperFactory {
    @Override
    public Developer createDeveloper() {
        return new CppDeveloper();
    }
}
