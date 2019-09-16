package demo

class PhoneNumber {
    String phoneNumber
    static belongsTo = [person: Person]

    static constraints = {
        phoneNumber nullable : false

    }
}
