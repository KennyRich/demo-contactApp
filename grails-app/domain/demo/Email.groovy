package demo

class Email {
    String email
    static belongsTo = [person:Person]

    static constraints = {
        email nullable: true
    }

}