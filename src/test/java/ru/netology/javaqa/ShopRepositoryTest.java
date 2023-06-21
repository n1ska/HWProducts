package ru.netology.javaqa;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ShopRepositoryTest {

    @Test
    void add() {
        ShopRepository repo = new ShopRepository();
        repo.add(new Product(1, "Bread", 100));

        int actual = repo.findAll().length;
        int expected = 1;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void findAll() {
        ShopRepository repo = new ShopRepository();
        repo.add(new Product(1, "Bread", 100));
        repo.add(new Product(2, "Butter", 200));


        Product[] actual = repo.findAll();
        Product[] expected = new Product[]{new Product(1, "Bread", 100),
                new Product(2, "Butter", 200)};

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    void removeByIdThrowNotExistedExceptio() {
        ShopRepository repo = new ShopRepository();
        repo.add(new Product(1, "Bread", 100));
        repo.add(new Product(2, "Butter", 200));

        Assertions.assertThrows(NotFoundException.class, () -> repo.removeById(12));
    }

    @Test
    void removeById() {
        ShopRepository repo = new ShopRepository();
        repo.add(new Product(1, "Bread", 100));
        repo.add(new Product(2, "Butter", 200));

        repo.removeById(2);
        Product[] actual = repo.findAll();
        Product[] expected = new Product[]{new Product(1, "Bread", 100)};

        Assertions.assertArrayEquals(expected, actual);
    }


    @Test
    void remove() {
        ShopRepository repo = new ShopRepository();
        repo.add(new Product(1, "Bread", 100));
        repo.add(new Product(2, "Butter", 200));

        repo.remove(2);
        Product[] actual = repo.findAll();
        Product[] expected = new Product[]{new Product(1, "Bread", 100)};

        Assertions.assertArrayEquals(expected, actual);
    }
}