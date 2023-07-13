install:
mvn compile clean

get all certificates:
curl -X GET "http://localhost:8080/SpringJDBCRest/giftCertificate"

get specific certificate:
curl -X GET "http://localhost:8080/SpringJDBCRest/giftCertificate/2"

create a certificate:
curl -X POST "http://localhost:8080/SpringJDBCRest/giftCertificate" -H 'Content-type: application/json' -d '{"name":"name01","description":"description01","price":1.01,"duration":1}'

update a certificate:
curl -X PUT "http://localhost:8080/SpringJDBCRest/giftCertificate" -H 'Content-type: application/json' -d '{"id":1,"name":"name01","description":"description01","price":1.01,"duration":1,"createDate":[2001,1,1],"lastUpdateDate":[2001,1,11]}'

delete a certificate:
curl -X DELETE "http://localhost:8080/SpringJDBCRest/giftCertificate/3"


produce a handled exception:
curl -X GET "http://localhost:8080/SpringJDBCRest/handled"

produce undhandled exception:
curl -X GET "http://localhost:8080/SpringJDBCRest/unhandled"
