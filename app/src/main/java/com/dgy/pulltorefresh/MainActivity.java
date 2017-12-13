package com.dgy.pulltorefresh;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import me.dgy.pulltorefreshlibrary.MaterialRefreshLayout;
import me.dgy.pulltorefreshlibrary.MaterialRefreshListener;

public class MainActivity extends AppCompatActivity {

    private MaterialRefreshLayout materialRefreshLayout;
    private ListView listView ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview);
        initpulltorefresh();
        initlistview();
    }

    private void initpulltorefresh(){
        materialRefreshLayout= (MaterialRefreshLayout) findViewById(R.id.refresh);
        materialRefreshLayout.setMaterialRefreshListener(new MaterialRefreshListener() {
            @Override
            public void onRefresh(final MaterialRefreshLayout materialRefreshLayout) {
                materialRefreshLayout.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        materialRefreshLayout.finishRefresh();

                    }
                }, 3000);
            }
            @Override
            public void onRefreshLoadMore(final MaterialRefreshLayout materialRefreshLayout){
                materialRefreshLayout.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        materialRefreshLayout.finishRefreshLoadMore();

                    }
                }, 3000);
            }
        });
    }

    private void initlistview(){
        listView= (ListView) findViewById(R.id.lv);
        String[] array = new String[50];
        for (int i = 0; i < array.length; i++) {
            array[i] = "啊哈哈哈哈哈 s" + i;
        }
        listView.setAdapter(new android.widget.ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, array));
    }
}
