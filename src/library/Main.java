package library;

import library.controller.HelloWorld;
import library.controller.MainController;

public class Main {

    static HelloWorld helloWorld = new HelloWorld();
    static MainController mainController = new MainController();
    public static void main(String[] args) {
//        helloWorld.displayHelloWorldText();
        mainController.run();
    }
}
