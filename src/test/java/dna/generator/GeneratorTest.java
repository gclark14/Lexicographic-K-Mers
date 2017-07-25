package dna.generator;

import org.junit.Test;


import static org.junit.Assert.*;

/**
 * @author gabe.clark
 * @since 7/24/17
 */
public class GeneratorTest {
    Generator generator = new Generator();

    @Test
    public void generate(){
        generator.generate();
        generator.pad();
        generator.printList();
    }

    @Test
    public void pad(){
    }
}