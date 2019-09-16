package demo

import grails.gorm.transactions.Transactional

@Transactional
class AddressService {
    Address save(String address, Person person){
        Address addressData = new Address(
                address: address,
                person: person
        ).save(flush: true, failOnError: true)
        return addressData
    }

    def update(String address, Person person){
        Address addressData = Address.findByAddressAndPerson(address, person)
        if (!addressData){
            //Create a new address
            save(address, person)
        } else {
            //Update address
            addressData.address = address
            addressData.save()
        }
    }
    def delete(String addressId, String personId){
        Long prsnId = personId as Long
        Person person = Person.get(prsnId)

        if(person){
            Address addrss = Address.findByAddressAndPerson(addressId, person)
            if(addrss){
                addrss.delete(flush: true, failOnError: true)
            }
        }
    }

//    def getAddress (List addressList){
//        List address = addressList.collect {
//            it as Long
//        }
//
//        def addressData = Address.createCriteria()
//        def results = addressData.list {
//            'in'("id", address)
//        }
//
//        return results
//    }
}
