package edu.zju.homework3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    private List<filelist> mDatas;
    private myRecycleradatper recycleAdapter;
    private Button bt_insert;
    Map<String, Integer> drawableMap = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mDatas = new ArrayList<filelist>();
        String zt="paris";
        filelist fl;
        for(int i=0;i<50;i++){
            zt="paris";
            fl=new filelist(zt);
            mDatas.add(fl);
            zt="beijing";
            fl=new filelist(zt);
            mDatas.add(fl);
            zt="london";
            fl=new filelist(zt);
            mDatas.add(fl);
        }


        recycleAdapter=new myRecycleradatper(this,mDatas);
        RecyclerView recyclerView=(RecyclerView) findViewById(R.id.mlist);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this );
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(recycleAdapter);
        recyclerView.setItemAnimator(new DefaultItemAnimator());



    }
    @SuppressLint("ResourceType")
    protected void onclick(View v){
        if (v.getId() >= 2000)
            if (v.getId() < 2300) {
                mDatas.remove(v.getId()-2000);
                recycleAdapter=new myRecycleradatper(this,mDatas);
                RecyclerView recyclerView=(RecyclerView) findViewById(R.id.mlist);
                LinearLayoutManager layoutManager = new LinearLayoutManager(this );
                recyclerView.setLayoutManager(layoutManager);
                recyclerView.setHasFixedSize(true);
                recyclerView.setAdapter(recycleAdapter);
                recyclerView.setItemAnimator(new DefaultItemAnimator());
            }
    }

}
