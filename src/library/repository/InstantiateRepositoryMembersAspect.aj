package library.repository;

import java.lang.reflect.Field;

public aspect InstantiateRepositoryMembersAspect {
    private BookRepository bookRepository = new BookRepository();

    pointcut bookServiceConstructor(Object service) : execution(library.service.book..new(..))  && !within(InstantiateRepositoryMembersAspect) && target(service);

    void around(Object service): bookServiceConstructor(service) {
        try {
            Field booksField = thisJoinPoint.getSignature().getDeclaringType().getDeclaredField("books");
            booksField.setAccessible(true);
            booksField.set(thisJoinPoint.getTarget(), bookRepository);
        } catch (Exception e) {
            e.printStackTrace();
        }
        proceed(service);
    }
}
