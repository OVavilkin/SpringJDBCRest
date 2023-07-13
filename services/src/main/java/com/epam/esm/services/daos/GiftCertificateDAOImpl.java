package com.epam.esm.services.daos;

import com.epam.esm.services.exceptions.DaoNotFoundException;
import com.epam.esm.services.models.GiftCertificate;
import com.epam.esm.services.models.GiftCertificateMapper;

import java.sql.Types;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.SqlUpdate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;

@Component
public class GiftCertificateDAOImpl implements GiftCertificateDAO {

  private final DataSource dataSource;
  private final JdbcTemplate jdbcTemplate;

  @Autowired
  public GiftCertificateDAOImpl(DataSource dataSource, JdbcTemplate jdbcTemplate) {
    this.dataSource = dataSource;
    this.jdbcTemplate = jdbcTemplate;
  }

  @Override
  public GiftCertificate getGiftCertificateById(Long id) {
    try {
      String sql = "select * from giftCertificate where id = ?";
      return jdbcTemplate.queryForObject(sql, new GiftCertificateMapper(), id);
    } catch (DataAccessException ex) {
      throw new DaoNotFoundException("Something wrong... no such certificate?", ex);
    }
  }

  @Override
  public List<GiftCertificate> getAllGiftCertificates() {
    String sql = "select * from giftCertificate";
    return jdbcTemplate.query(sql, new GiftCertificateMapper());
  }

  @Override
  public int deleteGiftCertificate(Long id) {
    String sql = "delete from giftCertificate where id = ?";
    return jdbcTemplate.update(sql, id);
  }

  @Override
  public int updateGiftCertificate(GiftCertificate giftCertificate) {
    String sql =
        "update giftCertificate set name = ?, description = ?, price = ?, duration = ?, createDate ="
            + " ?, lastUpdateDate  = ? where id = ?";
    return jdbcTemplate.update(
        sql,
        giftCertificate.getName(),
        giftCertificate.getDescription(),
        giftCertificate.getPrice(),
        giftCertificate.getDuration(),
        giftCertificate.getCreateDate(),
        giftCertificate.getLastUpdateDate(),
        giftCertificate.getId());
  }

  @Override
  @Transactional(propagation = Propagation.REQUIRES_NEW)
  public Long createGiftCertificate(GiftCertificate giftCertificate) {
    String sql =
        "insert into giftCertificate(name, description, price, duration, createDate, lastUpdateDate)"
            + " values(?, ?, ?, ?, ?, ?)";
    SqlUpdate sqlUpdate = new SqlUpdate(dataSource, sql);
    sqlUpdate.declareParameter(new SqlParameter("name", Types.VARCHAR));
    sqlUpdate.declareParameter(new SqlParameter("description", Types.VARCHAR));
    sqlUpdate.declareParameter(new SqlParameter("price", Types.DOUBLE));
    sqlUpdate.declareParameter(new SqlParameter("duration", Types.INTEGER));
    sqlUpdate.declareParameter(new SqlParameter("createDate", Types.DATE));
    sqlUpdate.declareParameter(new SqlParameter("lastUpdateDate", Types.DATE));
    sqlUpdate.setReturnGeneratedKeys(true);
    sqlUpdate.setGeneratedKeysColumnNames("id");
    sqlUpdate.compile();
    GeneratedKeyHolder keyHolder = new GeneratedKeyHolder();
    Object[] params =
        new Object[] {
          giftCertificate.getName(),
          giftCertificate.getDescription(),
          giftCertificate.getPrice(),
          giftCertificate.getDuration(),
          giftCertificate.getCreateDate(),
          giftCertificate.getLastUpdateDate()
        };
    sqlUpdate.update(params, keyHolder);

    return Objects.requireNonNull(keyHolder.getKey()).longValue();
  }
}
