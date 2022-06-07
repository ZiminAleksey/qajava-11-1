package ru.netology.manager.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ru.netology.domain.PurchaseFilm;
import ru.netology.manager.PosterManager;
import ru.netology.repository.FilmRepository;

import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;

public class PosterManagerTestNoEmpty {

    private FilmRepository repository = Mockito.mock(FilmRepository.class);

    private PosterManager manager = new PosterManager(repository);

    private PurchaseFilm first = new PurchaseFilm(1, 1, "Бладшот", 300, 120);
    private PurchaseFilm second = new PurchaseFilm(2, 2, "Отбитые", 400, 180);
    private PurchaseFilm third = new PurchaseFilm(3, 3, "Третий", 300, 120);
    private PurchaseFilm four = new PurchaseFilm(4, 4, "Четвертый", 400, 180);
    private PurchaseFilm five = new PurchaseFilm(5, 5, "Пятый", 300, 120);
    private PurchaseFilm six = new PurchaseFilm(6, 6, "Шестой", 400, 180);

    @Test
    public void firstMockitoTest() {
        PurchaseFilm[] returned = {first, second, third};
        doReturn(returned).when(repository).findAll();

        PurchaseFilm[] expected = manager.findAll();
        PurchaseFilm[] actual = {first, second, third};
        Assertions.assertArrayEquals(expected, actual);

        verify(repository).findAll();
    }


    @Test
    public void secondMockitoTest() {
        PurchaseFilm[] returned = {second, third, four, five, six};
        doReturn(returned).when(repository).findAll();

        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(four);
        manager.add(five);
        manager.add(six);
        repository.removeById(1);
        PurchaseFilm[] expected = manager.findAll();
        PurchaseFilm[] actual = {second, third, four, five, six};
        Assertions.assertArrayEquals(expected, actual);

        verify(repository).findAll();
    }
}
