package ru.netology.manager.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import ru.netology.domain.PurchaseFilm;
import ru.netology.manager.PosterManager;
import ru.netology.repository.FilmRepository;

import java.util.Arrays;

public class PosterManagerTest {
    PurchaseFilm first = new PurchaseFilm(1, 1, "Бладшот", 300, 120);
    PurchaseFilm second = new PurchaseFilm(2, 2, "Отбитые", 400, 180);
    PurchaseFilm third = new PurchaseFilm(3, 3, "Третий", 300, 120);
    PurchaseFilm four = new PurchaseFilm(4, 4, "Четвертый", 400, 180);
    PurchaseFilm five = new PurchaseFilm(5, 5, "Пятый", 300, 120);
    PurchaseFilm six = new PurchaseFilm(6, 6, "Шестой", 400, 180);


    @Test
    void firstTest() {

        FilmRepository repo = new FilmRepository();
        PosterManager manager = new PosterManager(5, (repo));
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(four);
        manager.add(five);
        manager.add(six);
        manager.findAll();
        manager.findLast();

        PurchaseFilm[] actual = manager.findLast();
        PurchaseFilm[] expected = {six, five, four, third, second};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void secondTest() {
        FilmRepository repo = new FilmRepository();
        PosterManager manager = new PosterManager(repo);
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(four);
        manager.add(five);
        manager.add(six);
        manager.findAll();

        PurchaseFilm[] actual = manager.findAll();
        PurchaseFilm[] expected = {first, second, third, four, five, six};
        Assertions.assertArrayEquals(expected, actual);

        FilmRepository repo1 = new FilmRepository();
        PosterManager manager1 = new PosterManager(repo1);
        manager1.add(first);
        manager1.add(second);
        manager1.add(third);
        manager1.add(four);
        manager1.add(five);
        manager1.add(six);
        manager1.findLast();

        PurchaseFilm[] actual1 = manager1.findLast();
        PurchaseFilm[] expected1 = {six, five, four, third, second, first};
        Assertions.assertArrayEquals(expected1, actual1);
    }
}
