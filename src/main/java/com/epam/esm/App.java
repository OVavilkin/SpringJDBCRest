package com.epam.esm;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        /*
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        GiftCertificateDAO giftCertificateDAO = context.getBean(GiftCertificateDAO.class);

        System.out.println("List of GiftCertificates:");

        for(GiftSertificate giftSertificate: giftCertificateDAO.getAllGiftCertificates()) {
            System.out.println(giftSertificate);
        }

        giftCertificateDAO.createGiftCertificate(
                new GiftSertificate(
                        "newName",
                        "newDescription",
                        3.14,
                        42,
                        LocalDate.now(),
                        LocalDate.now()
                )
        );

        for(GiftSertificate giftSertificate: giftCertificateDAO.getAllGiftCertificates()) {
            System.out.println(giftSertificate);
        }

        GiftCertificateClient giftCertificateClient = context.getBean(GiftCertificateClient.class);

        System.out.println("List of certificates (from REST service):");

        for(GiftSertificate giftSertificate: giftCertificateClient.getAllGiftCertificates()) {
            System.out.println(giftSertificate);
        }

        context.close();

         */
    }
}
