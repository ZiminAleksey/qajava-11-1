package ru.netology.manager;

import ru.netology.domain.PurchaseFilm;
import ru.netology.repository.FilmRepository;

public class PosterManager {

    private FilmRepository repository;


    private int resultLength = 10;

    public PosterManager(FilmRepository repository) {
        this.repository = repository;
    }

    public PosterManager(int resultLength, FilmRepository repository) {
        this.resultLength = resultLength;
        this.repository = repository;
    }

    public void add(PurchaseFilm film) {
        repository.save(film);
    }

    public PurchaseFilm[] findAll() {
        PurchaseFilm[] films = repository.findAll();
        return films;
    }

    public PurchaseFilm[] findLast() {
        PurchaseFilm[] films = repository.findAll();
        if (films.length > resultLength) {
            resultLength = resultLength;
        } else {
            resultLength = films.length;
        }
        PurchaseFilm[] result = new PurchaseFilm[resultLength];
        for (int i = 0; i < result.length; i++) {
            int index = films.length - i - 1;
            result[i] = films[index];
        }
        return result;
    }
}
