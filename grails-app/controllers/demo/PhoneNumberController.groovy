package demo

import org.springframework.transaction.annotation.Transactional

@Transactional

class PhoneNumberController {
    PhoneNumberService phoneNumberService

    def delete() {
        String personId = params.person as String
        String phoneNumberId = params.phoneNumber as String

        if (phoneNumberId && personId){
            phoneNumberService.delete(phoneNumberId, personId)
        }
        redirect(controller: 'person', action: 'list')
    }
}
