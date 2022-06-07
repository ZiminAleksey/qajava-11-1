package ru.netology.repository.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.domain.PurchaseFilm;
import ru.netology.repository.FilmRepository;

public class FilmRepositoryTest {

    PurchaseFilm first = new PurchaseFilm(1, 1, "Бладшот", 300, 120);
    PurchaseFilm second = new PurchaseFilm(2, 2, "Отбитые", 400, 180);
    PurchaseFilm third = new PurchaseFilm(3, 3, "Третий", 300, 120);
    PurchaseFilm four = new PurchaseFilm(4, 4, "Четвертый", 400, 180);
    PurchaseFilm five = new PurchaseFilm(5, 5, "Пятый", 300, 120);
    PurchaseFilm six = new PurchaseFilm(6, 6, "Шестой", 400, 180);

    @Test
    void repoFirstTest() {
        FilmRepository repo = new FilmRepository();
        repo.save(first);
        repo.save(second);
        repo.save(third);
        repo.findById(2);
        repo.removeById(2);
        repo.removeAll();
        repo.save(first);
        repo.findAll();

        PurchaseFilm[] actual = repo.findAll();
        PurchaseFilm[] expected = { first };
        Assertions.assertArrayEquals(expected, actual);
    }
}
