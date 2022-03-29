package library.repository;

import java.util.logging.Logger;

public aspect ManageDatabaseConnectionAspect {
    private static final Logger LOGGER = Logger.getLogger(ManageDatabaseConnectionAspect.class.getName());

    private static final String URL = "jdbc:postgresql:librarydb";
    private static final String USER = "libraryapp";
    private static final String PASSWORD = "password";

    pointcut applicationStart() : call(public void library.controller.MainController.run());

    before() : applicationStart() {
        LOGGER.info("APP START: open database");
        DatabaseConnection.initConnection();
    }

    after() : applicationStart() {
        LOGGER.info("APP EXIT: close database");
        DatabaseConnection.closeConnection();
    }
}
