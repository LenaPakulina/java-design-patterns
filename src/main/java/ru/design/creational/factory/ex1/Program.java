package ru.design.creational.factory.ex1;

import ru.design.creational.factory.ex1.developer.Developer;
import ru.design.creational.factory.ex1.factory.CppDeveloperFactory;
import ru.design.creational.factory.ex1.factory.DeveloperFactory;
import ru.design.creational.factory.ex1.factory.JavaDeveloperFactory;
import ru.design.creational.factory.ex1.factory.PhpDeveloperFactory;

public class Program {
    public static void main(String[] args) {
        DeveloperFactory developerFactory = createDeveloperBySpeciality("php");
        Developer developer = developerFactory.createDeveloper();
        developer.writeCode();
    }

    static DeveloperFactory createDeveloperBySpeciality(String special) {
        if ("java".equalsIgnoreCase(special)) {
            return new JavaDeveloperFactory();
        } else if ("php".equalsIgnoreCase(special)) {
            return new PhpDeveloperFactory();
        }
        return new CppDeveloperFactory();
    }
}
