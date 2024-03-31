package com.example.demo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Класс для работы с таблицей бд
 */
@Repository
public class TvControl {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    /**
     * Добавляет новую строку в базу данных
     * @param tv телевизор для добавления
     */
    public void addTv(Tv tv) {
        String sql = "INSERT INTO tv (brand, type, product_name, screen_diagonal, price, quantity) " +
                "VALUES (?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, tv.getName(), tv.getType(), tv.getBrand(), tv.getSize(),
        tv.getPrice(), tv.getQuantity());
    }

    /**
     * Считывает все строки из базы данных
     * @return  строк
     */
    public List<Tv> getAllTv() {
        String sql = "SELECT * FROM tv";
        return jdbcTemplate.query(sql, new TvRowMapper());
    }

    /**
     * Обновляет строку данных в таблице
     * @param id идентификатор записи
     * @param updatedTv новые данные для записи
     */
    public void updateTv(Integer id, Tv updatedTv) {
        String sql = "UPDATE tv SET brand=?, type=?, product_name=?, screen_diagonal=?, price=?, quantity=? WHERE id=?";
        jdbcTemplate.update(sql, updatedTv.getName(),updatedTv.getType(), updatedTv.getBrand(),
                updatedTv.getSize(), updatedTv.getPrice(), updatedTv.getQuantity(), id);
    }

    /**
     * Удаляет строку в таблице
     * @param id идентификатор строки
     */
    public void deleteTv(Integer id) {
        String sql = "DELETE FROM tv WHERE id=?";
        jdbcTemplate.update(sql, id);
    }

    /**
     * Ищет запись в таблице по значению одного из полей
     * @param field название поля
     * @param value значение поля
     * @return найденная строка
     */
    public List<Tv> searchTv(String field, String value) {
        String sql = "SELECT * FROM tv WHERE LOWER(" + field + ") LIKE ?";
        return jdbcTemplate.query(connection -> {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, "%" + value.toLowerCase() + "%");
            return ps;
        }, new TvRowMapper());
    }

    /**
     * Преобразует результат запроса в объект класса tv
     */
    private static class TvRowMapper implements RowMapper<Tv> {
        @Override
        public Tv mapRow(ResultSet rs, int rowNum) throws SQLException {
            Tv tv = new Tv();
            tv.setId(rs.getInt("id"));
            tv.setName(rs.getString("brand"));
            tv.setType(rs.getString("type"));
            tv.setBrand(rs.getString("product_name"));
            tv.setSize(rs.getInt("screen_diagonal"));
            tv.setPrice(rs.getDouble("price"));
            tv.setQuantity(rs.getInt("quantity"));
            return tv;
        }
    }
}
