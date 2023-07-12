package com.epam.esm.services.services;

import com.epam.esm.services.models.GiftSertificate;
import java.util.List;

public interface GiftCertificateService {
  List<GiftSertificate> getAllGiftCertificates();

  GiftSertificate getById(Long id);

  int addGiftCertificate(GiftSertificate giftSertificate);

  int updateGiftCertificate(GiftSertificate giftSertificate);

  int deleteGiftCertificate(Long id);

  void throwExceptionExample();
}
