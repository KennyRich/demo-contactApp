package demo

class Address {
    String address
    static belongsTo = [person:Person]

    static constraints = {
        address nullable: true
    }
}
