# PortalTech Reply - REST API Test

## Summary
* Project uses [cucumber-java8](https://cucumber.io/docs/reference/jvm#step-definitions)
* The Maven [failsafe](http://maven.apache.org/surefire/maven-failsafe-plugin/) plugin has been used as the main test runner.
* The project takes advantage of DI in the form of the [Pico Container](https://github.com/cucumber/cucumber-jvm/tree/master/picocontainer) project.
* Reports are generated using the [cucumber-reporting](https://github.com/damianszczepanik/cucumber-reporting) plugin and can be found in the `target` directory after running `mvn verify`.
* Feature files are in the `test/resources` directory.

## Running

You can run it simple by using `mvn verify`. Alternatively you should can import it into your IDE and run it from there.