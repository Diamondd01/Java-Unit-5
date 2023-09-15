import org.junit.Rule;
import org.mockito.Mock;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import java.util.Arrays;
import java.util.List;


public class EducationServiceTest {
    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    @Mock
    private StudentDataObject studentDataObject;

    @Mock
    private InstructorDataObject instructorDataObject;

    @Mock
    private ClassDataObject classDataObject;

    @InjectMocks
    private ClientBusinessObjectImpl clientBusinessObjectImpl;
    @Test
    public void testStudentsByClass() {
        // Given
        Student studentJM = new Student("Joy Ma", "Spanish");
        Student studentJH = new Student("Julio Hernandez", "Algebra");
        Student studentJJ = new Student("Jenny Jones", "Calculus");
        List<Student> allStudents = Arrays.asList(studentJM, studentJH, studentJJ);

        given(studentDataObject.getAllStudents()).willReturn(allStudents);

        // When
        List<String> mathStudents = clientBusinessObjectImpl.getAllStudentsBySubject("math");

        // Then
        assertThat(mathStudents.size(), is(2));
        assertThat(mathStudents, hasItems("Jenny Jones", "Julio Hernandez"));
}
        // Given
        @Test
        public void testMarkInactive() {
            // Given
            Class geometry = new Class("Geometry", "Summer 2022");
            Class envSci = new Class("Environmental Science", "Fall 2022");
            Class compLit = new Class("Comparative Literature", "Spring 2023");
            List<Class> allClasses = Arrays.asList(geometry, envSci, compLit);

            given(classDataObject.getAllClasses()).willReturn(allClasses);

            // When
            clientBusinessObjectImpl.markCurrentClassesInactive();

            // Then
            verify(classDataObject).markInactive(geometry);
        }

        //Answer to part 5 We use the @Mock annotation to create mock objects for instructorDataObject and classDataObject.
//We use the @InjectMocks annotation to inject the mocks into the businessLogic instance.
//In the test methods, we specify the expected behavior of the mock objects using given(...).willReturn(...).
// For example, in testGetClassesByInstructor, we mock the behavior of instructorDataObject to return a list of classes \
// when getClassesByInstructor is called.
//We then call the corresponding methods in the businessLogic instance and assert the expected results.