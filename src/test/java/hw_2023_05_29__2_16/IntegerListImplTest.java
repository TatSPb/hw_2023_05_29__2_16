package hw_2023_05_29__2_16;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.stream.Stream;

public class IntegerListImplTest {
    private final IntegerList integerList = new IntegerListImpl();

    @AfterEach
    public void afterEach() {
        integerList.clear();
    }

    @Test
    void addTest() {
        Integer[] elements = {5, 4, 1, 3, 2};
        add(elements);

        for (int i = 0; i < elements.length; i++) {
            Assertions.assertThat(integerList.get(i)).isEqualTo(elements[i]);
            Assertions.assertThat(integerList.contains(elements[i])).isTrue();
            Assertions.assertThat(integerList.indexOf(elements[i])).isEqualTo(i);
            Assertions.assertThat(integerList.lastIndexOf(elements[i])).isEqualTo(i);
        }
        Assertions.assertThat(integerList.toArray()).hasSize(elements.length);
        Assertions.assertThat(integerList.toArray()).containsExactly(elements);
    }

    @Test
    void addByIndexTest() {
        Integer[] elements = {1, 2, 3, 4, 5};
        add(elements);

        integerList.add(0, 6);
        Assertions.assertThat(integerList.size()).isEqualTo(elements.length + 1);
        Assertions.assertThat(integerList.get(0)).isEqualTo(6);

        integerList.add(3, 7);
        Assertions.assertThat(integerList.size()).isEqualTo(elements.length + 2);
        Assertions.assertThat(integerList.get(3)).isEqualTo(7);
        Assertions.assertThat(integerList.lastIndexOf(7)).isEqualTo(3);
        Assertions.assertThat(integerList.lastIndexOf(7)).isEqualTo(3);

        integerList.add(7, 9);
        Assertions.assertThat(integerList.size()).isEqualTo(elements.length + 3);
        Assertions.assertThat(integerList.get(7)).isEqualTo(9);
        Assertions.assertThat(integerList.lastIndexOf(9)).isEqualTo(7);
        Assertions.assertThat(integerList.lastIndexOf(9)).isEqualTo(7);
    }

    private void add(Integer[] elements) {
        Assertions.assertThat(integerList.isEmpty()).isTrue();
        Stream.of(elements).forEach(integerList::add);
        Assertions.assertThat(integerList.size()).isEqualTo(elements.length);
    }
}
