package demo

import grails.gorm.transactions.Transactional

@Transactional
class PersonService {
    PhoneNumberService phoneNumberService
    EmailService emailService
    AddressService addressService

    Person save(String firstName, String lastName, String phoneNumber, String email, String address){
        Person person = new Person(
                firstName: firstName,
                lastName: lastName
        ).save(flush: true, failOnError: true)

        if(person){
            phoneNumberService.save(phoneNumber, person)
            emailService.save(email, person)
            addressService.save(address, person)
        }

        return person
    }

    def update(Person person, String phoneNumber, String email, String address){
        Person personData = Person.get(person.id)

        phoneNumberService.update(phoneNumber, personData)
        emailService.update(email, personData)
        addressService.update(address, personData)
    }

    def delete(personId){
        Long prsnId = personId as Long
        Person person = Person.get(prsnId)

        if(person){
            person.delete(flush: true, failOnError: true)
        }
    }

//    Person getPerson (String personId){
//        Long prsnId = personId as Long
//        Person person = Person.get(prsnId)
//
//        if(!person){
//            return null
//        }
//
//        return person
//    }
}
