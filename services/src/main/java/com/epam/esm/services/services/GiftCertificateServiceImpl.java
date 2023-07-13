package com.epam.esm.services.services;

import com.epam.esm.services.daos.GiftCertificateDAO;
import com.epam.esm.services.exceptions.DaoException;
import com.epam.esm.services.models.GiftCertificate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GiftCertificateServiceImpl implements GiftCertificateService {

  @Autowired GiftCertificateDAO giftCertificateDAO;

  @Override
  public List<GiftCertificate> getAllGiftCertificates() {
    return giftCertificateDAO.getAllGiftCertificates();
  }

  @Override
  public GiftCertificate getById(Long id) {
    return giftCertificateDAO.getGiftCertificateById(id);
  }

  @Override
  public Long addGiftCertificate(GiftCertificate giftCertificate) {
    return giftCertificateDAO.createGiftCertificate(giftCertificate);
  }

  @Override
  public int updateGiftCertificate(GiftCertificate giftCertificate) {
    return giftCertificateDAO.updateGiftCertificate(giftCertificate);
  }

  @Override
  public int deleteGiftCertificate(Long id) {
    return giftCertificateDAO.deleteGiftCertificate(id);
  }

  @Override
  public void throwExceptionExample() {
    throw new DaoException(
        "Example of exception being thrown", new Exception("Original fake exception"));
  }
}
