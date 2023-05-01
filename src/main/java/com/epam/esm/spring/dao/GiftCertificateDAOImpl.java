package com.epam.esm.spring.dao;

import com.epam.esm.model.GiftCertificateMapper;
import com.epam.esm.model.GiftSertificate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.List;

@Component
public class GiftCertificateDAOImpl implements GiftCertificateDAO {

    JdbcTemplate jdbcTemplate;

    private final String SQL_FIND_GIFTCERTIFICATE = "select * from giftCertificate where id = ?";
    private final String SQL_DELETE_GIFTCERTIFICATE = "delete from giftCertificate where id = ?";
    private final String SQL_UPDATE_GIFTCERTIFICATE =
            "update giftCertificate set name = ?, description = ?, price = ?, duration = ?, createDate = ?, lastUpdateDate  = ? where id = ?";
    private final String SQL_GET_ALL_GIFTCERTIFICATES = "select * from giftCertificate";
    private final String SQL_INSERT_GIFTCERTIFICATE =
            "insert into giftCertificate(name, description, price, duration, createDate, lastUpdateDate) values(?, ?, ?, ?, ?, ?)";

    @Autowired
    public GiftCertificateDAOImpl(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public GiftSertificate getGiftCertificateById(Long id) {
        return jdbcTemplate.queryForObject(SQL_FIND_GIFTCERTIFICATE, new GiftCertificateMapper(), id);
    }

    @Override
    public List<GiftSertificate> getAllGiftCertificates() {
        return jdbcTemplate.query(SQL_GET_ALL_GIFTCERTIFICATES, new GiftCertificateMapper());
    }

    @Override
    public int deleteGiftCertificate(Long id) {
        return jdbcTemplate.update(SQL_DELETE_GIFTCERTIFICATE, id);
    }

    @Override
    public int updateGiftCertificate(GiftSertificate giftSertificate) {
        return jdbcTemplate.update(
                SQL_UPDATE_GIFTCERTIFICATE,
                giftSertificate.getName(),
                giftSertificate.getDescription(),
                giftSertificate.getPrice(),
                giftSertificate.getDuration(),
                giftSertificate.getCreateDate(),
                giftSertificate.getLastUpdateDate(),
                giftSertificate.getId()
                );
    }

    @Override
    public int createGiftCertificate(GiftSertificate giftSertificate) {
        return jdbcTemplate.update(
                SQL_INSERT_GIFTCERTIFICATE,
                giftSertificate.getName(),
                giftSertificate.getDescription(),
                giftSertificate.getPrice(),
                giftSertificate.getDuration(),
                giftSertificate.getCreateDate(),
                giftSertificate.getLastUpdateDate()
        );
    }
}
