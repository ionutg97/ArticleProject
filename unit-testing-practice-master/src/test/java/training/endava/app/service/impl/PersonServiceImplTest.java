package training.endava.app.service.impl;

import org.junit.Test;
import training.endava.app.domain.Person;
import training.endava.app.repository.PersonRepository;
import training.endava.app.repository.StubPersonRepository;
import training.endava.app.service.PersonService;
import training.endava.app.test.helpers.PersonTestHelper;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

/**
 * Write some more tests using the {@link StubPersonRepository}
 * <p/>
 * Try to identify where you can use Mockito for simpler test doubles
 * <p/>
 */
public class PersonServiceImplTest {

    @Test
    public void shouldReturnSamePeopleForUniquePersons() throws Exception {
        PersonService personService = getPersonService("unique-contacts-input.json");
        List<String> expectedPersonList = Arrays.asList("MARINESCU", "POPESCU", "IONESCU");

        List<String> actualPersonList = personService.getPeopleSurnamesByAge(50);

        assertThat("Expected to contain same people",
                actualPersonList, containsInAnyOrder(expectedPersonList.toArray()));
    }

    @Test
    public void shouldReturnUniqueNamesWhenPeopleHaveSameSurname() throws Exception {
        PersonService personService = getPersonService("duplicated-surnames-contacts-input.json");
        List<String> expectedPersonList = Arrays.asList("POPESCU", "MARINESCU", "IONESCU");

        List<String> actualPersonList = personService.getPeopleSurnamesByAge(50);

        assertThat("Expected to contain same people",
                actualPersonList, containsInAnyOrder(expectedPersonList.toArray()));
    }

    @Test
    public void shouldReturnEmptyListWhenPeopleAreYoungerThan50() throws Exception{
        PersonService personService = getPersonService("only-young-people-input.json");
        List<String> expectedPersonList = Arrays.asList();

        List<String> actualPersonList = personService.getPeopleSurnamesByAge(50);

        assertThat("Expected to contain same people",
                actualPersonList, containsInAnyOrder(expectedPersonList.toArray()));
    }

    @Test
    public void shouldReturnPeopleFromSecondPageWhenAreDuplicatePerson() throws Exception {

        PersonService personService = getPersonService("duplicated-surnames-contacts-input.json");

        List<String> expectedPersonList = Arrays.asList("POPESCU", "MARINESCU", "IONESCU");

        List<String> actualPersonList = personService.getPaginatedPeopleByAge(50,1);

        assertThat("Expected to contain same people",
                actualPersonList, containsInAnyOrder(expectedPersonList.toArray()));

    }

    @Test
    public void shouldshouldThrowExceptionWhenPageIsSmallerThan1() throws Exception {

        PersonService personService = getPersonService("duplicated-surnames-contacts-input.json");

        List<String> expectedPersonList = Arrays.asList();

        try {
            List<String> actualPersonList = personService.getPaginatedPeopleByAge(50, 0);
            fail("Should not get here");
        }
        catch (IllegalArgumentException e) {
            assertEquals("-3",e.getMessage());
        }

    }

    @Test
    public void shouldReturnEmptyListWhenPageIsGreatThanTotalNumberOfPages() throws Exception{
        PersonService personService = getPersonService("only-young-people-input.json");
        List<String> expectedPersonList = Arrays.asList();

        List<String> actualPersonList = personService.getPaginatedPeopleByAge(50,10);

        assertThat("Expected to contain same people",
                actualPersonList, containsInAnyOrder(expectedPersonList.toArray()));
    }


    private PersonService getPersonService(String fileName) throws Exception {
        List<Person> personList = PersonTestHelper.getPersonList(fileName);
        PersonRepository personRepository = new StubPersonRepository(personList);
        return new PersonServiceImpl(personRepository);
    }
}
