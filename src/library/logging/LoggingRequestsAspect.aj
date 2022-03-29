package library.logging;


import java.util.logging.Logger;

public aspect LoggingRequestsAspect {
    private static final Logger LOGGER = Logger.getLogger(LoggingRequestsAspect.class.getName());

    pointcut httpRequest() : call(public * library.controller..*(..));

    before() : httpRequest() {
        LOGGER.info("Request for " + thisJoinPoint.getSignature().getDeclaringTypeName() + " for method " + thisJoinPoint.getSignature().getName());
    }
}
