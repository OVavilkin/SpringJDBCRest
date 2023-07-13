package com.epam.esm.services.daos;

import com.epam.esm.services.models.GiftCertificate;
import java.util.List;

public interface GiftCertificateDAO {

  GiftCertificate getGiftCertificateById(Long id);

  List<GiftCertificate> getAllGiftCertificates();

  int deleteGiftCertificate(Long id);

  int updateGiftCertificate(GiftCertificate giftCertificate);

  Long createGiftCertificate(GiftCertificate giftCertificate);
}
