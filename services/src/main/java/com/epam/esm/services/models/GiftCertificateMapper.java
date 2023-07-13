package com.epam.esm.services.models;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class GiftCertificateMapper implements RowMapper<GiftCertificate> {

  @Override
  public GiftCertificate mapRow(ResultSet rs, int rowNum) throws SQLException {
    GiftCertificate giftCertificate = new GiftCertificate();
    giftCertificate.setId(rs.getLong("id"));
    giftCertificate.setName(rs.getString("name"));
    giftCertificate.setDescription(rs.getString("description"));
    giftCertificate.setPrice(rs.getDouble("price"));
    giftCertificate.setDuration(rs.getInt("duration"));
    giftCertificate.setCreateDate(rs.getDate("createDate").toLocalDate());
    giftCertificate.setLastUpdateDate(rs.getDate("lastUpdateDate").toLocalDate());
    return giftCertificate;
  }
}
