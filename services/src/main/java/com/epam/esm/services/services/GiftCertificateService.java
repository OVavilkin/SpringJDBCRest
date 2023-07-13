package com.epam.esm.services.services;

import com.epam.esm.services.models.GiftCertificate;
import java.util.List;

public interface GiftCertificateService {
  List<GiftCertificate> getAllGiftCertificates();

  GiftCertificate getById(Long id);

  int addGiftCertificate(GiftCertificate giftCertificate);

  int updateGiftCertificate(GiftCertificate giftCertificate);

  int deleteGiftCertificate(Long id);

  void throwExceptionExample();
}
