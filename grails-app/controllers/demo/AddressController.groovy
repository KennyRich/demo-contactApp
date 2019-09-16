package demo

import org.springframework.transaction.annotation.Transactional

@Transactional

class AddressController {
    AddressService addressService

    def delete() {
        String personId = params.person as String
        String addressId = params.address as String

        if (addressId && personId){
            addressService.delete(addressId, personId)
        }
        redirect(controller: 'person', action: 'list')
    }
}