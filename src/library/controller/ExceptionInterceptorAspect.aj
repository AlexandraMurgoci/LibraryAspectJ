package library.controller;

public aspect ExceptionInterceptorAspect {

    pointcut applicationRunning(MainController mainController) : execution(public void library.controller.MainController.runMenu()) && target(mainController);

    void around(MainController mainController): applicationRunning(mainController) {
        try {
            proceed(mainController);
        }
        catch (Exception e) {
            //keep program running regardless of exceptions
            System.out.println("An exception occured: " + e.getMessage());
//            proceed(mainController);
            mainController.runMenu();
        }
    }
}
