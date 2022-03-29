package library.logging;


import java.util.logging.Logger;

public aspect LoggingRequestsAspect {
    private static final Logger LOGGER = Logger.getLogger(LoggingRequestsAspect.class.getName());

    pointcut httpRequest() : call(public * library.controller.HelloWorld.displayHelloWorldText());

    before() : httpRequest() {
        System.out.println("!!!!!!!!!!!!!");
        LOGGER.info("Http request intercepted");
    }
}
