
package com.datamify.development.ci;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ElementTest {

    @Test
    void shouldTestAddElement() {
        final Element firstElement = new Element(5);
        final Element secondElement = new Element(7);
        final helloworld hello = new helloworld();  

        boolean resultElement = hello.a();
        assertEquals(resultElement, true);
    }

}
