package demo

import grails.gorm.transactions.Transactional

@Transactional
class PhoneNumberService {

    PhoneNumber save(String phoneNumber, Person person){
        PhoneNumber phone = new PhoneNumber(
                phoneNumber: phoneNumber,
                person: person
        ).save(flush: true, failOnError: true)

        return phone
    }

    def update(String phoneNumber, Person person){
        PhoneNumber phoneNumberData = PhoneNumber.findByPhoneNumberAndPerson(phoneNumber, person)
        if(!phoneNumberData){
            save(phoneNumber, person)
        }else{
            phoneNumberData.phoneNumber = phoneNumber
            phoneNumberData.person = person
            phoneNumberData.save()
        }
    }

    def delete(String phoneNumberId, String personId){
        Long prsnId = personId as Long
        Person person = Person.get(prsnId)

        if(person){
            PhoneNumber phoneNum = PhoneNumber.findByPhoneNumberAndPerson(phoneNumberId, person)
            if(phoneNum){
                phoneNum.delete(flush: true, failOnError: true)
            }
        }
    }

//    def getPhoneNumber(List phoneNumberList){
//        List phoneNumber = phoneNumberList.collect {
//            it as Long
//        }
//
//        def phoneData = PhoneNumber.createCriteria()
//        def results = phoneData.list {
//            "in"('id', phoneNumber)
//        }
//        return results
//    }

}
