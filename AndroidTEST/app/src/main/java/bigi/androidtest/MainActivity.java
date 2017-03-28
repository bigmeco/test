package bigi.androidtest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
   private ListView listView;
    private ListAdapter listAdapter;
    List<ListFail> data = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        List<ListFail> AdapData = getDataList();
        listAdapter = new ListAdapter(this,AdapData);
        listView = (ListView)findViewById(R.id.listV);
       listView.setAdapter(listAdapter);
    }
    private List<ListFail> getDataList(){
data.add(new ListFail("FGRS","21"));
data.add(new ListFail("ERTS","43"));
data.add(new ListFail("THBN","235"));
    return data;
    }
}
