package com.epam.esm.spring.dao;


import com.epam.esm.model.GiftSertificate;

import java.util.List;

public interface GiftCertificateDAO {

    GiftSertificate getGiftCertificateById(Long id);

    List<GiftSertificate> getAllGiftCertificates();

    int deleteGiftCertificate(Long id);

    int updateGiftCertificate(GiftSertificate giftSertificate);

    int createGiftCertificate(GiftSertificate giftSertificate);
}
