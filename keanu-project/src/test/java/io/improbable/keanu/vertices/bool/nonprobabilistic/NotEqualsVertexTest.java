package io.improbable.keanu.vertices.bool.nonprobabilistic;

import io.improbable.keanu.vertices.bool.nonprobabilistic.operators.binary.compare.NotEqualsVertex;
import io.improbable.keanu.vertices.generic.nonprobabilistic.ConstantVertex;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class NotEqualsVertexTest {

    @Test
    public void comparesIntegers() {
        equals(1, 1, false);
        equals(1, 0, true);
    }

    @Test
    public void comparesDoubles() {
        equals(1.0, 1.0, false);
        equals(1.0, 0.0, true);
    }

    @Test
    public void comparesObjects() {
        Object obj = new Object();
        equals(obj, obj, false);

        equals("test", "otherTest", true);
    }

    private <T> void equals(T a, T b, boolean expected) {
        NotEqualsVertex<T> vertex = new NotEqualsVertex<>(new ConstantVertex<>(a), new ConstantVertex<>(b));
        assertEquals(expected, vertex.lazyEval());
    }
}
