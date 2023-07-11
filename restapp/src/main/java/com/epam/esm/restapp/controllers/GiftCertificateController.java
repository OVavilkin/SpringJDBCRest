package com.epam.esm.restapp.controllers;

import com.epam.esm.services.models.GiftSertificate;
import com.epam.esm.services.services.GiftCertificateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
public class GiftCertificateController {

    @Autowired
    private GiftCertificateService giftCertificateService;

    @RequestMapping("/")
    public String showMyFirstView() {
        return "hello.jsp";
    }


    @RequestMapping(value = "/giftCertificate", method = RequestMethod.GET)
    public List<GiftSertificate> giftCertificateAll() {
        return giftCertificateService.getAllGiftCertificates();
    }

    @RequestMapping(value = "/giftCertificate/{id}", method = RequestMethod.GET)
    public GiftSertificate giftCertificateAll(@PathVariable("id") Long id) {
        return giftCertificateService.getById(id);
    }

    @RequestMapping(value = "/giftCertificate", method = RequestMethod.POST)
    public GiftSertificate createGiftCertificate(@RequestBody GiftSertificate giftSertificate) {
        giftSertificate.setCreateDate(LocalDate.now());
        giftSertificate.setLastUpdateDate(LocalDate.now());
        long id = giftCertificateService.addGiftCertificate(giftSertificate);
        return giftCertificateService.getById(id);
    }

    @RequestMapping(value = "/giftCertificate/{id}", method = RequestMethod.DELETE)
    public int deleteGiftSertificate(@PathVariable("id") Long id) {
        return giftCertificateService.deleteGiftCertificate(id);
    }

}
