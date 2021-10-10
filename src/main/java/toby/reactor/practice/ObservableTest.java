package toby.reactor.practice;

import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ObservableTest {

    // 기존 Observer 패턴의 문제점
    // 1. Complete : notifyObservers의 끝??
    // 2. Error : error를 핸들링할 수 없다.

    static class IntObservable extends Observable implements Runnable {

        @Override
        public void run() {
            for(int i=1; i<=10; i++) {
                setChanged();
                notifyObservers(i);    //push
                // int i = it.next();  //pull
            }
        }
    }

    // observable -> observer
    // subject -> observer
    // publisher -> subscriber
    // observable -> subscriber
    public static void main(String[] args) {
        Observer ob = new Observer() {
            @Override
            public void update(Observable o, Object arg) {
                System.out.println(Thread.currentThread().getName() + " " + arg);
            }
        };

        IntObservable io = new IntObservable();
        io.addObserver(ob);

        ExecutorService es = Executors.newSingleThreadExecutor();
        es.execute(io);

        System.out.println(Thread.currentThread().getName() + " EXIT");
        es.shutdown();
    }
}
