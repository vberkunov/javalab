import com.company.ServiceSystem;
import com.company.Сoefficient;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class ServiceSystemTest {
    private ServiceSystem serviceSystem;

@BeforeAll
public void init() {
    serviceSystem = new ServiceSystem();
}

@Test
public void ShouldReturnTwoSolutions() {
    Сoefficient equation = new Сoefficient();

    double[][] value = new double[][]{
            {1, 0, -9},
            {-1, 5, 0},
            {3, -14, -5},
            {1, -70, 600}
    };

    double[][] expected = new double[][]{
            {3.0, -3.0},
            {-0., 5.},
            {5, -1d / 3d},
            {60, 10}
    };

    for (int i = 0; i < value.length; i++) {
        equation.setA(value[i][0]);
        equation.setB(value[i][1]);
        equation.setC(value[i][2]);
        serviceSystem.setEquation(equation);
        assertArrayEquals(expected[i], serviceSystem.getResultofEquation());
    }

}

@Test
public void ShouldReturnOneSolution() {
    Сoefficient equation = new Сoefficient();

    double[][] value = new double[][]{
            {0, 12, 24},
            {4, 4, 1},
            {3, 6, 3}
    };

    double[][] expected = new double[][]{
            {-2},
            {-0.5},
            {-1},
    };

    for (int i = 0; i < value.length; i++) {
        equation.setA(value[i][0]);
        equation.setB(value[i][1]);
        equation.setC(value[i][2]);
        serviceSystem.setEquation(equation);
        assertArrayEquals(expected[i], serviceSystem.getResultofEquation());
    }
}

@Test
public void shouldReturnEmptyArray() {
    Сoefficient equation = new Сoefficient();

    double[][] value = new double[][]{
            {-9, -1, -1},
            {2, -1, 3.5},
            {2, -6, 6},
            {2, -7, 7}
    };

    double[] expected = new double[]{};

    for (double[] doubles : value) {
        equation.setA(doubles[0]);
        equation.setB(doubles[1]);
        equation.setC(doubles[2]);
        serviceSystem.setEquation(equation);
        assertArrayEquals(expected, serviceSystem.getResultofEquation());
    }
}
}