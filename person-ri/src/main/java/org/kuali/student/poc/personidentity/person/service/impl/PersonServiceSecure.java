package org.kuali.student.poc.personidentity.person.service.impl;

import javax.jws.WebService;

import org.springframework.transaction.annotation.Transactional;


@WebService(endpointInterface="org.kuali.student.poc.personidentity.person.service.PersonService",
        name="PersonServiceSecure",
        serviceName="PersonServiceSecure",
        portName="PersonServiceSecure",
        targetNamespace="http://student.kuali.org/poc/wsdl/personidentity/person")
@Transactional
public class PersonServiceSecure extends PersonServiceImpl {

}