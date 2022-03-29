package library.security;

import library.exception.NotAuthorizedException;

public aspect SecureServicesAspect {

//    pointcut callToSecureAdminService(Object service) : within(library.security.AllowAdminOnly+) && execution(public * library.service..*(..)) && target(service);
    pointcut callToSecureAdminService(Object service) : target(service) &&
            (execution(public * library.service.book.AddBook.*(..)) || execution(public * library.service.book.GetAllBooks.*(..)));

    Object around(Object service) : callToSecureAdminService(service) {
        if(SessionData.getActiveRole() == null || SessionData.getActiveRole() != Role.ADMIN) {
            throw new NotAuthorizedException();
        }
        else {
            return proceed(service);
        }
    }

    declare precedence: library.repository.InstantiateRepositoryMembersAspect, library.security.SecureServicesAspect, *;
}
