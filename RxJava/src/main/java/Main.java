import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

import static com.sun.activation.registries.LogSupport.log;

/**
 * Created by bigme on 30.04.2017.
 */
public class Main {
    public static void main(String[] args) {
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
}
