package portaltech.test.acceptance.stepdefs;

import cucumber.api.DataTable;
import cucumber.api.java8.En;
import portaltech.test.domain.Country;

import java.util.Arrays;
import java.util.List;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static java.util.stream.Collectors.toList;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;

public class CountryStepDefs implements En {
    public CountryStepDefs(APIStepDefs apiStepDefs) {
        And("^the response returned should adhere to the countries JSON schema$", () ->
            apiStepDefs.response
                .then()
                    .assertThat().body(matchesJsonSchemaInClasspath("json-schema/countries.json"))
        );
        And("^there should be (\\d+) countries returned$", (Integer countryCount) ->
            apiStepDefs.response
                .then()
                    .assertThat().body("size()", is(countryCount))
        );
        And("^the country named \"([^\"]*)\" should have the following values:$", (String countryName, DataTable expectedCountries) -> {
            List<Country> actualCountries = Arrays.stream(
                apiStepDefs.response.getBody().as(Country[].class)
            ).filter(
                country -> country.getName().equals(countryName)
            ).collect(toList());

            assertEquals("Count for country: " + countryName + " wasn't as expected!", 1, actualCountries.size());

            assert expectedCountries.asList(Country.class).size() == 1;
            Country expectedCountry = expectedCountries.asList(Country.class).get(0);

            // I believe that step definitions should have verbose assertions, you could use the
            // comparable interface on country and either assert in there or pass back true or false
            // but I think this way is more appropriate when testing as it delegates the concept of
            // validity to the context that's checking it (e.g. just because it's valid/invalid in this context
            // that doesn't mean that's fair to say globally).
            actualCountries.forEach(actualCountry -> {
                assertEquals(actualCountry.getName(), expectedCountry.getName());
                assertEquals(actualCountry.getCapital(), expectedCountry.getCapital());
                assertEquals(actualCountry.getRegion(), expectedCountry.getRegion());
                assertEquals(actualCountry.getSubregion(), expectedCountry.getSubregion());
                assertEquals(actualCountry.getDemonym(), expectedCountry.getDemonym());
            });
        });
    }
}
