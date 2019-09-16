package demo

class Person {
    String firstName
    String lastName

    static hasMany = [phoneNumber:PhoneNumber, email:Email, address:Address]

    static constraints = {
        firstName nullable: false
        lastName nullable: false
    }
}

