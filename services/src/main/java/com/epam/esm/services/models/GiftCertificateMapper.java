package com.epam.esm.services.models;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class GiftCertificateMapper implements RowMapper<GiftSertificate> {

    @Override
    public GiftSertificate mapRow(ResultSet rs, int rowNum) throws SQLException {
        GiftSertificate giftSertificate = new GiftSertificate();
        giftSertificate.setId(rs.getLong("id"));
        giftSertificate.setName(rs.getString("name"));
        giftSertificate.setDescription(rs.getString("description"));
        giftSertificate.setPrice(rs.getDouble("price"));
        giftSertificate.setDuration(rs.getInt("duration"));
        giftSertificate.setCreateDate(rs.getDate("createDate").toLocalDate());
        giftSertificate.setLastUpdateDate(rs.getDate("lastUpdateDate").toLocalDate());
        return giftSertificate;
    }
}
