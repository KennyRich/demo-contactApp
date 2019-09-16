package demo

import grails.gorm.transactions.Transactional

@Transactional
class EmailService {
    Email save(String email, Person person){
        Email emailAddress = new Email(
                email: email,
                person: person
        ).save(flush:true, failOnError:true)
        return emailAddress
    }

    def update(String email, Person person){
        Email emailData = Email.findByEmailAndPerson(email, person)
        if (!emailData){
            //Create a new email
            save(email, person)
        } else {
            //Update email
            emailData.email = email
            emailData.save()
        }
    }
    def delete(String emailId, String personId) {
        Long prsnId = personId as Long
        Person person = Person.get(prsnId)

        if (person) {
            Email emails = Email.findByEmailAndPerson(emailId, person)
            if(emails){
                emails.delete(flush: true, failOnError: true)
            }
        }
    }

//    def getEmail(List emailList){
//        List email = emailList.collect{
//            it as Long
//        }
//
//        def emailData = Email.createCriteria()
//        def results = emailData.list {
//            'in'('id', email)
//        }
//        return results
//    }
}