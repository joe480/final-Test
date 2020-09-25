
package com.com470.pregunta2.service;

import com.com470.pregunta2.service.Triangulo;
import java.util.List;
import org.assertj.core.util.Arrays;
import org.junit.Test;
import org.hamcrest.Matchers;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

/**
 *
 * @author User
 */
@RunWith(Parameterized.class)
public class TrianguloTest {

    @Parameterized.Parameters
    public static List<Object> datos() {
        //devolvera una lista
        return Arrays.asList(new Object[][]{
            {5, 5, 5}, {3, 3,5}, {5,6,7}, {3, 3,3},{1,2,3},{8,6,8},{4,4,4},{4,7,6},{8,8,3},{2,2,2}
        });
    }
    public int n1, n2, n3;

    public TrianguloTest(int n1, int n2, int n3) {
        this.n1 = n1;
        this.n2 = n2;
        this.n3 = n3;
    }
    Triangulo instance = new Triangulo();

    @Test
    public void testTipoTriangulo() {
        System.out.println("tipoTriangulo");
        String resultados[] = {"Equilatero","Isoceles","Escaleno"};
        String result = instance.tipoTriangulo(n1, n2, n3);
        if (n1 == n2 && n2 == n3) {
            assertThat( result,Matchers.is(resultados[0]));
        } else if (n1 == n2 || n1 == n3 || n2 == n3) {
            assertThat(result,Matchers.is(resultados[1])  );
        } else if (n1 != n2 || n1 != n3 || n3 != n2) {
            assertThat(result,Matchers.is(resultados[2]) );
        }

    }

}
