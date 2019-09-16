package demo

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class PhoneNumberServiceSpec extends Specification {

    PhoneNumberService phoneNumberService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new PhoneNumber(...).save(flush: true, failOnError: true)
        //new PhoneNumber(...).save(flush: true, failOnError: true)
        //PhoneNumber phoneNumber = new PhoneNumber(...).save(flush: true, failOnError: true)
        //new PhoneNumber(...).save(flush: true, failOnError: true)
        //new PhoneNumber(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //phoneNumber.id
    }

    void "test get"() {
        setupData()

        expect:
        phoneNumberService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<PhoneNumber> phoneNumberList = phoneNumberService.list(max: 2, offset: 2)

        then:
        phoneNumberList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        phoneNumberService.count() == 5
    }

    void "test delete"() {
        Long phoneNumberId = setupData()

        expect:
        phoneNumberService.count() == 5

        when:
        phoneNumberService.delete(phoneNumberId)
        sessionFactory.currentSession.flush()

        then:
        phoneNumberService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        PhoneNumber phoneNumber = new PhoneNumber()
        phoneNumberService.save(phoneNumber)

        then:
        phoneNumber.id != null
    }
}
