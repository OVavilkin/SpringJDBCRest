package com.epam.esm.restapp.controllers;

import com.epam.esm.restapp.dtos.GiftCertificateDto;
import com.epam.esm.services.models.GiftCertificate;
import com.epam.esm.services.services.GiftCertificateService;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class GiftCertificateController {

  @Autowired private GiftCertificateService giftCertificateService;

  @Autowired private ModelMapper modelMapper;

  @RequestMapping("/")
  public String showMyFirstView() {
    return "hello.jsp";
  }

  @RequestMapping(value = "/giftCertificate", method = RequestMethod.GET)
  public List<GiftCertificateDto> getGiftCertificates() {
    return giftCertificateService.getAllGiftCertificates().stream()
        .map(this::convertToDto)
        .collect(Collectors.toList());
  }

  @RequestMapping(value = "/giftCertificate/{id}", method = RequestMethod.GET)
  public GiftCertificateDto getGiftCertificate(@PathVariable("id") Long id) {
    return convertToDto(giftCertificateService.getById(id));
  }

  @RequestMapping(value = "/giftCertificate", method = RequestMethod.POST)
  public GiftCertificateDto createGiftCertificate(
      @RequestBody GiftCertificateDto giftCertificateDto) {
    GiftCertificate giftCertificate = convertToModel(giftCertificateDto);
    giftCertificate.setCreateDate(LocalDate.now());
    giftCertificate.setLastUpdateDate(LocalDate.now());
    long id = giftCertificateService.addGiftCertificate(giftCertificate);
    return convertToDto(giftCertificateService.getById(id));
  }

  @RequestMapping(value = "/giftCertificate", method = RequestMethod.PUT)
  public GiftCertificateDto updateGiftCertificate(
      @RequestBody GiftCertificateDto giftCertificateDto) {
    GiftCertificate giftCertificate = convertToModel(giftCertificateDto);
    long id = giftCertificateService.addGiftCertificate(giftCertificate);
    return convertToDto(giftCertificateService.getById(id));
  }

  @RequestMapping(value = "/giftCertificate/{id}", method = RequestMethod.DELETE)
  public int deleteGiftCertificate(@PathVariable("id") Long id) {
    return giftCertificateService.deleteGiftCertificate(id);
  }

  @RequestMapping(value = "/unhandled", method = RequestMethod.GET)
  public void throwUnhandledException() {
    throw new RuntimeException("Unhandled Exception");
  }

  @RequestMapping(value = "/handled", method = RequestMethod.GET)
  public void throwHandledException() {
    giftCertificateService.throwExceptionExample();
  }

  private GiftCertificateDto convertToDto(GiftCertificate giftCertificate) {
    return modelMapper.map(giftCertificate, GiftCertificateDto.class);
  }

  private GiftCertificate convertToModel(GiftCertificateDto giftCertificateDto) {
    return modelMapper.map(giftCertificateDto, GiftCertificate.class);
  }
}
