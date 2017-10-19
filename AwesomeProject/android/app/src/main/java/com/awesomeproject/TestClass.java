
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;

public class TestClass extends ReactContextBaseJavaModule {
    public TestClass(ReactApplicationContext context) {
        super(context);
    }

    @Override
    public String getName() {
        return "TestClass";
    }

    @ReactMethod
    public void show(String message, Callback call) {
        Call.invoke("test  "+ message +"  test");
    }
}