

import static junit.framework.TestCase.assertEquals;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import lombok.SneakyThrows;
import org.junit.Before;
import org.testng.annotations.Test;

public class RecordsTest {


    private Records records;

    @Before
    public void init() {
        records = getRecords();
    }

    @Test
    public void shouldReturnClassName() {
        assertEquals("Records", records.getClass().getSimpleName());
    }

    @Test
    public void shouldShowConstructorParams() {
        for (Constructor constructor : records.getClass().getConstructors()) {
            System.out.println(constructor);
        }
    }

    @Test
    public void shouldReturnClassModifier() {
        assertEquals("public", Modifier.toString(records.getClass().getModifiers()));
    }


    @Test
    @SneakyThrows
    public void shouldInvokeMethod() throws InvocationTargetException, IllegalAccessException {
        for (Method method : records.getClass().getMethods()) {
            if (method.isAnnotationPresent(Annotation.class)) {
                method.invoke(records);
            }
        }
    }

    private Records getRecords() {

        return Records.builder()
                .firstName("Андрій")
                .secondName("Миколайович")
                .lastName("Антонюк")
                .phone("0981155452")
                .day(20)
                .month(1)
                .year(200)
                .build();

    }
}