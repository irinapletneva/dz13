import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ShopRepositoryTest {

    @Test
    public void testProductExist() {
        ShopRepository shopRepository = new ShopRepository();
        Product product1 = new Product(1, "Хлеб", 100);
        Product product2 = new Product(2, "Молоко", 120);
        Product product3 = new Product(3, "Кофе", 400);
        shopRepository.add(product1);
        shopRepository.add(product2);
        shopRepository.add(product3);
        shopRepository.remove(2);
        Product[] expected = {product1, product3};
        Product[] actual = shopRepository.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testProductNotExist() {
        ShopRepository shopRepository = new ShopRepository();
        Product product1 = new Product(1, "Хлеб", 100);
        Product product2 = new Product(2, "Молоко", 120);
        Product product3 = new Product(3, "Кофе", 400);
        shopRepository.add(product1);
        shopRepository.add(product2);
        shopRepository.add(product3);
        Assertions.assertThrows(RuntimeException.class,
                () -> shopRepository.remove(5)
        );
    }
}