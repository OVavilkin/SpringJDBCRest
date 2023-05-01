package com.epam.esm.spring.config;

import com.epam.esm.model.GiftSertificate;
import org.springframework.http.HttpStatus;

import java.util.List;

public interface GiftCertificateService {
    List<GiftSertificate> getAllGiftCertificates();
    GiftSertificate getById(Long id);
    int addGiftCertificate(GiftSertificate giftSertificate);
    int updateGiftCertificate(GiftSertificate giftSertificate);
    int deleteGiftCertificate(Long id);
}
