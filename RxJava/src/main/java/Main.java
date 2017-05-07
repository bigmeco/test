import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static com.sun.activation.registries.LogSupport.log;

/**
 * Created by bigme on 30.04.2017.
 */
public class Main {
    public static void main(String[] args) {
        filter ();
    }

    public void strinRX (){
        Observable<String> observable = Observable.just("one", "two", "three");
        Observer<String> observer = new Observer<String>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(String s) {
                System.out.println("onNext: " + s);
            }

            @Override
            public void onError(Throwable e) {
                System.out.println("onError: " + e);
            }

            @Override
            public void onComplete() {
                System.out.println("onCompleted");
            }


        };
      observable.subscribe(observer);
    }

    public static void intRX(){
        Observable<Integer> observable = Observable.range(10, 4);
        Observer<Integer> observer = new Observer<Integer>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(Integer s) {
                System.out.println("onNext: " + s);
            }

            @Override
            public void onError(Throwable e) {
                System.out.println("onError: " + e);
            }

            @Override
            public void onComplete() {
                System.out.println("onCompleted");
            }


        };
        observable.subscribe(observer);
    }

    public void longRX(){
        Observable<Long> observable = Observable.interval(500, TimeUnit.MILLISECONDS);
        Observer<Long> observer = new Observer<Long>() {


            @Override
            public void onSubscribe(Disposable d) {
                System.out.println("onSubscribe: " + d);
            }

            @Override
            public void onNext(Long aLong) {
                System.out.println("onNext: " + aLong);
            }

            @Override
            public void onError(Throwable e) {
                System.out.println("onError: " + e);
            }

            @Override
            public void onComplete() {
                System.out.println("onCompleted");
            }


        };
        observable.subscribe(observer);
    }

    public static void map(){
        Observable<Integer> observable = Observable
                .just("1", "2", "3", "4", "5", "6")
                .map(S->Integer.parseInt(S));
/*
       Реализация одного и того же
        .map(S->Integer.parseInt(S));
        и
Func1<String, Integer> stringToInteger = new Func1<String, Integer>() {
    @Override
    public Integer call(String s) {
        return Integer.parseInt(s);
    }
};

 */

// create observer
        Observer<Integer> observer = new Observer<Integer>() {

            @Override
            public void onError(Throwable e) {
                System.out.println("onError: " + e);
            }

            @Override
            public void onComplete() {
                System.out.println("onCompleted");
            }

            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(Integer s) {
                System.out.println("onNext: " + s);
            }
        };

// subscribe
        observable.subscribe(observer);

    }

    public static void  buffer (){
        Observable<List<Integer>> observable = Observable
                .just(1,2,3,4,5,6,7,8)
                .buffer(3);
        Observer<List<Integer>> observer = new Observer<List<Integer>>() {
        @Override
        public void onError(Throwable e) {
            System.out.println("onError: " + e);
        }

        @Override
        public void onComplete() {
            System.out.println("onCompleted");
        }

        @Override
        public void onSubscribe(Disposable d) {

        }

        @Override
        public void onNext(List<Integer> s) {
            System.out.println("onNext: " + s);
        }
    };
        observable.subscribe(observer);
    }

    public static void  filter (){
        Observable<String> observable = Observable
                .just("15", "27", "34", "46", "52", "63")
                .filter(s -> s.contains("5"));

        Observer<String> observer = new Observer<String>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(String s) {
                System.out.println("onNext: " + s);
            }

            @Override
            public void onError(Throwable e) {
                System.out.println("onError: " + e);
            }

            @Override
            public void onComplete() {
                System.out.println("onCompleted");
            }


        };
        observable.subscribe(observer);
    }






}
