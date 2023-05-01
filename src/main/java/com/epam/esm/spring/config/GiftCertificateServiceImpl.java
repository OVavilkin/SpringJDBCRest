package com.epam.esm.spring.config;

import com.epam.esm.model.GiftSertificate;
import com.epam.esm.spring.dao.GiftCertificateDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
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
