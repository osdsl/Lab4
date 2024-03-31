package com.example.demo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * Сервис для работы с телевизорами
 */
@Service
public class TvService {
    /**
     * Объект класса для работы с базой данных
     */
    @Autowired
    private TvControl tvControl;

    /**
     * Добавляет новый телевизор
     * @param tv предмет для добавления
     */
    public void addTv(Tv tv) {
        tvControl.addTv(tv);
    }

    /**
     * Возвращает список всех телевизоров из базы данных
     * @return список телевизоров
     */
    public List<Tv> getAllTv() {
        return tvControl.getAllTv();
    }

    /**
     * Обновляет данные о телевизоре
     * @param id идентификатор предмета
     * @param updatedTv данные для обновления
     */
    public void updateTv(Integer id, Tv updatedTv) {
        tvControl.updateTv(id, updatedTv);
    }

    /**
     * Удаляет телевизор из базы данных по идентификатору.
     * @param id идентификатор телевизора для удаления.
     */
    public void deleteTv(Integer id) {
        tvControl.deleteTv(id);
    }

    /**
     * Осуществляет поиск телевизора по заданному полю и значению.
     * @param field поле для поиска.
     * @param value значение для поиска.
     * @return список предметов, соответствующих критериям поиска.
     */
    public List<Tv> searchTv(String field, String value) {
        return tvControl.searchTv(field, value);
    }
}
