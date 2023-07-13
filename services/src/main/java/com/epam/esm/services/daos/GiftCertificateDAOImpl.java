package com.epam.esm.services.daos;

import com.epam.esm.services.exceptions.DaoNotFoundException;
import com.epam.esm.services.models.GiftCertificate;
import com.epam.esm.services.models.GiftCertificateMapper;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class GiftCertificateDAOImpl implements GiftCertificateDAO {

  JdbcTemplate jdbcTemplate;

  private final String SQL_FIND_GIFTCERTIFICATE = "select * from giftCertificate where id = ?";
  private final String SQL_DELETE_GIFTCERTIFICATE = "delete from giftCertificate where id = ?";
  private final String SQL_UPDATE_GIFTCERTIFICATE =
      "update giftCertificate set name = ?, description = ?, price = ?, duration = ?, createDate ="
          + " ?, lastUpdateDate  = ? where id = ?";
  private final String SQL_GET_ALL_GIFTCERTIFICATES = "select * from giftCertificate";
  private final String SQL_INSERT_GIFTCERTIFICATE =
      "insert into giftCertificate(name, description, price, duration, createDate, lastUpdateDate)"
          + " values(?, ?, ?, ?, ?, ?)";

  @Autowired
  public GiftCertificateDAOImpl(DataSource dataSource) {
    jdbcTemplate = new JdbcTemplate(dataSource);
  }

  @Override
  public GiftCertificate getGiftCertificateById(Long id) {
    try {
      return jdbcTemplate.queryForObject(SQL_FIND_GIFTCERTIFICATE, new GiftCertificateMapper(), id);
    } catch (DataAccessException ex) {
      throw new DaoNotFoundException("Something wrong... no such certificate?", ex);
    }
  }

  @Override
  public List<GiftCertificate> getAllGiftCertificates() {
    return jdbcTemplate.query(SQL_GET_ALL_GIFTCERTIFICATES, new GiftCertificateMapper());
  }

  @Override
  public int deleteGiftCertificate(Long id) {
    return jdbcTemplate.update(SQL_DELETE_GIFTCERTIFICATE, id);
  }

  @Override
  public int updateGiftCertificate(GiftCertificate giftCertificate) {
    return jdbcTemplate.update(
        SQL_UPDATE_GIFTCERTIFICATE,
        giftCertificate.getName(),
        giftCertificate.getDescription(),
        giftCertificate.getPrice(),
        giftCertificate.getDuration(),
        giftCertificate.getCreateDate(),
        giftCertificate.getLastUpdateDate(),
        giftCertificate.getId());
  }

  @Override
  public int createGiftCertificate(GiftCertificate giftCertificate) {
    return jdbcTemplate.update(
        SQL_INSERT_GIFTCERTIFICATE,
        giftCertificate.getName(),
        giftCertificate.getDescription(),
        giftCertificate.getPrice(),
        giftCertificate.getDuration(),
        giftCertificate.getCreateDate(),
        giftCertificate.getLastUpdateDate());
  }
}
