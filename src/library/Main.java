package library;

import library.controller.HelloWorld;

public class Main {

    static HelloWorld helloWorld = new HelloWorld();
    public static void main(String[] args) {
        helloWorld.displayHelloWorldText();
    }
}
