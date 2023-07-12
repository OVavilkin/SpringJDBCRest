package com.epam.esm.services.daos;

import com.epam.esm.services.models.GiftSertificate;
import java.util.List;

public interface GiftCertificateDAO {

  GiftSertificate getGiftCertificateById(Long id);

  List<GiftSertificate> getAllGiftCertificates();

  int deleteGiftCertificate(Long id);

  int updateGiftCertificate(GiftSertificate giftSertificate);

  int createGiftCertificate(GiftSertificate giftSertificate);
}
