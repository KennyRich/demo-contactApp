package demo

import grails.gorm.transactions.Transactional

@Transactional
class PersonController {
    //This is a dependency injection:A bean is created so as to access the methods and properties of the bean
    PersonService personService
    AddressService addressService
    PhoneNumberService phoneNumberService
    EmailService emailService

    def index() {
        redirect action : "list"
    }

    def create(){
        String firstName = params?.firstName
        String lastName = params?.lastName
        String email = params?.email
        String phoneNumber = params?.phoneNumber
        String address = params?.address

        /**
         * Check whether params are null
         */
        if(!firstName && !lastName && !email && !phoneNumber && !address) {
            return null
        }

        Person person = Person.findByFirstNameAndLastName(firstName, lastName)

        if(!person){
            //Create a new person
            personService.save(firstName, lastName, phoneNumber, email, address)
        } else{
            //Update person
            personService.update(person, phoneNumber, email, address)
        }

        render(view: 'create')
    }

    def save(){
        def contact= new Person(params)
        contact.save flush:true, failOnError: true
        redirect action: "show", id: contact.id
    }

    def update(){
        def person = Person.get(params.id)

//        println personio
//        println params


        if (params.submitting == 'phone'){
            phoneNumber.properties=params
            phoneNumber.save(flush: true, failOnError: true)
            redirect(action: "show", id:params.id)
        }
        if (params.submitting == 'addresses'){
            address.properties = params
            address.save(flush: true, failOnError: true)
            redirect(action: "show", id: params.id)
        }
        if (params.submitting == 'emails'){
            email.properties = params
            email.save(flush: true, failOnError: true)
            redirect(action: "show", id: params.id)
        }
        if(person){
            person.properties = params
            person.save(flush: true, failOnError: true)
            redirect(action: "show", id:params.id)
        }
    }

    def list(){
        List<Person> contactList = Person.findAll()

        render(view: 'list', model: [
                contacts: contactList
        ])
    }
    def show(Person person) {
        render(view: 'show', model: [
                person: person
        ])
    }

    def edit(Person person){
        render(view:'edit', model:[
                person: person,
                editing: params.editing
        ])

//        return



//        String personId = params?.person
//        def address = params?.address
//        def email = params?.email
//        def phoneNumber = params?.phoneNumber
//
//        List addressList = []
//        List emailList = []
//        List phoneNumberList = []
//        List resultList = []
//
//        if(address){
//            addressList.addAll(address)
//            resultList = addressService.getAddress(addressList)
//        }
//        if(email){
//            emailList.addAll(email)
//            resultList = emailService.getEmail(emailList)
//        }
//
//        if(phoneNumber){
//            phoneNumberList.addAll(phoneNumber)
//            resultList = phoneNumberService.getPhoneNumber(phoneNumberList)
//        }
//
//        Person personData = personService.getPerson(personId)
//
//        render(view:'edit', model:[
//                person: personData,
//                results: resultList
//        ])
    }

    def delete(){
        String personId = params.person as String

        if(personId){
            personService.delete(personId)
        }

        redirect(controller:"person", action:"list")
    }
}
