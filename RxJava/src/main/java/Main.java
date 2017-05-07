import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

import java.util.concurrent.TimeUnit;

import static com.sun.activation.registries.LogSupport.log;

/**
 * Created by bigme on 30.04.2017.
 */
public class Main {
    public static void main(String[] args) {
        longRX ();
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

    public static void longRX(){
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

}
