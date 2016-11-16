package demo

import grails.testing.web.controllers.ControllerUnitTest
import spock.lang.Specification

class ControllerTagLibMethodDispatchSpec extends Specification implements ControllerUnitTest<DemoController> {

    void setupSpec() {
        mockTagLibs FirstTagLib, SecondTagLib
    }

    void 'test controller which invokes a tag which invokes another tag'() {
        when:
        controller.invokeTagWhichInvokesTag()

        then:
        response.text == 'BEFORE Hello From SecondTagLib AFTER'
    }
}
