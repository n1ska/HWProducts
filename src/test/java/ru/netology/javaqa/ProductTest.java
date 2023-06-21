package ru.netology.javaqa;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Objects;

class ProductTest {

    @Test
    public void equals() {
        Product product = new Product(1, "Bread", 100);
        Product product2 = new Product(1, "Bread", 100);

        boolean actual = product.equals(product2);
        boolean expected = true;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void NotEquals() {
        Product product = new Product(1, "Bread", 100);
        Product product2 = new Product(2, "Bread", 100);

        boolean actual = product.equals(product2);
        boolean expected = false;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void NotEqualsWithDifferentTitle() {
        Product product = new Product(1, "Bread", 100);
        Product product2 = new Product(1, "Bread2", 100);

        boolean actual = product.equals(product2);
        boolean expected = false;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void NotEqualsWithDifferentPrice() {
        Product product = new Product(1, "Bread", 100);
        Product product2 = new Product(1, "Bread", 102);

        boolean actual = product.equals(product2);
        boolean expected = false;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void equalsTheSameObject() {
        Product product = new Product(1, "Bread", 100);

        boolean actual = product.equals(product);
        boolean expected = true;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void NotEqualsWithNull() {
        Product product = new Product(1, "Bread", 100);

        boolean actual = product.equals(null);
        boolean expected = false;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void NotEqualsWithAnotherObject() {
        Product product = new Product(1, "Bread", 100);
        FakeProduct fakeProduct = new FakeProduct();

        boolean actual = product.equals(fakeProduct);
        boolean expected = false;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void hashCodeEqual() {
        Product product = new Product(1, "Bread", 100);

        int actual = product.hashCode();
        int expected = Objects.hash(1, "Bread", 100);

        Assertions.assertEquals(expected, actual);
    }

}