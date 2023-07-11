package com.epam.esm.services.services;

import com.epam.esm.services.models.GiftSertificate;
import com.epam.esm.services.daos.GiftCertificateDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GiftCertificateServiceImpl implements GiftCertificateService {

    @Autowired
    GiftCertificateDAO giftCertificateDAO;

    @Override
    public List<GiftSertificate> getAllGiftCertificates() {
        return giftCertificateDAO.getAllGiftCertificates();
    }

    @Override
    public GiftSertificate getById(Long id) {
        return giftCertificateDAO.getGiftCertificateById(id);

    }

    @Override
    public int addGiftCertificate(GiftSertificate giftSertificate) {
        return giftCertificateDAO.createGiftCertificate(giftSertificate);
    }

    @Override
    public int updateGiftCertificate(GiftSertificate giftSertificate) {
        return giftCertificateDAO.updateGiftCertificate(giftSertificate);
    }

    @Override
    public int deleteGiftCertificate(Long id) {
        return giftCertificateDAO.deleteGiftCertificate(id);
    }
}
