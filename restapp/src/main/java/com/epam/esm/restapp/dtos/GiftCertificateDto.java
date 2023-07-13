package com.epam.esm.restapp.dtos;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class GiftCertificateDto {

  private static final DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");
  private Long id;
  private String name;
  private String description;
  private Double price;
  private Integer duration;
  private String createDate;
  private String lastUpdateDate;

  public LocalDate getCreateDate() throws ParseException {
    return Objects.isNull(this.createDate)
            ? null
            : LocalDate.parse(this.createDate, dateFormat);
  }

  public void setCreateDate(LocalDate date) {
    this.createDate = dateFormat.format(date);
  }

  public LocalDate getLastUpdateDate() throws ParseException {
    return Objects.isNull(this.lastUpdateDate)
        ? null
        : LocalDate.parse(this.lastUpdateDate, dateFormat);
  }

  public void setLastUpdateDate(LocalDate date) {
    this.lastUpdateDate = dateFormat.format(date);
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Double getPrice() {
    return price;
  }

  public void setPrice(Double price) {
    this.price = price;
  }

  public Integer getDuration() {
    return duration;
  }

  public void setDuration(Integer duration) {
    this.duration = duration;
  }
}
