package it.giobr.jogogourmet;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TreeTests {

    private Tree tree;

    @BeforeEach
    public void initialValues() {
        tree = new Tree();
    }

    @Test
    public void testIfInitialValueOfTheRootIsCorrect(){
        Assertions.assertEquals(tree.getCurrentLabel(), "massa");
    }

    @Test
    public void testIfInitialValueOfTheLeftIsCorrect(){
        tree.goLeft();

        Assertions.assertEquals(tree.getCurrentLabel(), "Lasanha");
    }

    @Test
    public void testIfInitialValueOfTheRightIsCorrect(){
        tree.goRight();

        Assertions.assertEquals(tree.getCurrentLabel(), "Bolo de Chocolate");
    }

    @Test
    public void testAddAtLeft(){
        tree.goLeft();
        tree.add("redonda", "Pizza");
        tree.reset();

        tree.goLeft();
        Assertions.assertEquals(tree.getCurrentLabel(), "redonda");
        tree.goLeft();
        Assertions.assertEquals(tree.getCurrentLabel(), "Pizza");

        tree.reset();
        tree.goLeft();
        tree.goRight();
        Assertions.assertEquals(tree.getCurrentLabel(), "Lasanha");
    }


    @Test
    public void testAddAtRight(){
        tree.goRight();
        tree.add("frito", "Arroz");
        tree.reset();

        tree.goRight();
        Assertions.assertEquals(tree.getCurrentLabel(), "frito");
        tree.goLeft();
        Assertions.assertEquals(tree.getCurrentLabel(), "Arroz");

        tree.reset();
        tree.goRight();
        tree.goRight();
        Assertions.assertEquals(tree.getCurrentLabel(), "Bolo de Chocolate");
    }
}
