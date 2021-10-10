package toby.reactor.practice;

import java.util.Iterator;

public class IterableTest {
    // Iterable <---> Observable (duality)
    // Pull           Push

    public static void main(String[] args) {
        java.lang.Iterable<Integer> iter = () ->
                new Iterator<>() {

                    int i=0;
                    final static int MAX = 10;

                    @Override
                    public boolean hasNext() {
                        return i < MAX;
                    }

                    @Override
                    public Integer next() {
                        return ++i;
                    }
                };

        for (Integer i: iter) {
            System.out.println(i);
        }

        for (Iterator<Integer> it = iter.iterator(); it.hasNext();) {
            System.out.println(it.next());
        }
    }
}
