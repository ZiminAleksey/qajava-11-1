package ru.netology.repository;

import ru.netology.domain.PurchaseFilm;

public class FilmRepository {

    private PurchaseFilm[] films = new PurchaseFilm[0];

    public void save(PurchaseFilm film) {
        int length = films.length + 1;
        PurchaseFilm[] tmp = new PurchaseFilm[length];
        System.arraycopy(films, 0, tmp, 0, films.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = film;
        films = tmp;
    }

    public PurchaseFilm[] findAll() {
        return films;
    }

    public PurchaseFilm[] findById(int id) {
        int length = 1;
        PurchaseFilm[] tmp = new PurchaseFilm[1];
        int index = 0;
        for (PurchaseFilm film : films) {
            if (film.getId() == id) {
                tmp[index] = film;
            }
        }
        return tmp;
    }

    public void removeById(int id) {
        int length = films.length - 1;
        PurchaseFilm[] tmp = new PurchaseFilm[length];
        int index = 0;
        for (PurchaseFilm film : films) {
            if (film.getId() != id) {
                tmp[index] = film;
                index++;
            }
        }
        films = tmp;
    }

    public void removeAll() {
        int length = 0;
        PurchaseFilm[] tmp = new PurchaseFilm[length];
        films = tmp;
    }
}
