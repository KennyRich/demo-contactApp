package demo

import org.springframework.transaction.annotation.Transactional

@Transactional
class EmailController {
    EmailService emailService

    def delete(){
        String personId = params.person as String
        String emailId = params.email as String
        if (emailId && personId){
            emailService.delete(emailId, personId)
        }
        redirect(controller:"person", action:"list")
    }
}
