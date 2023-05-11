import org.junit.jupiter.api.Test;

import static com.google.common.truth.Truth.assertThat;
import static com.google.common.truth.Truth.assertWithMessage;

public class ArrayDequeTest {
    @Test
    public void addFirstCheck()
    {
        Deque <String> ad = new ArrayDeque<>();
        ad.addFirst("Hello");
        assertThat(ad.toList()).containsExactly("Hello").inOrder();
        ad.addLast("world");
        assertThat(ad.toList()).containsExactly("Hello","world").inOrder();
    }

}
