package com.kittu.javatutor;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class ChapterActivity extends AppCompatActivity {
TextView tvChapter;
    FloatingActionButton fabNext,fabPrev;
    static int cp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chapter);

        tvChapter=(TextView)findViewById(R.id.tvChapter);
        fabNext=(FloatingActionButton)findViewById(R.id.fabNext);
        fabPrev=(FloatingActionButton)findViewById(R.id.fabPrev);
        Intent a=getIntent();
        int i=a.getIntExtra("i",0);
cp=i;
        final Map<Integer,String> map=new HashMap<>();
        map.put(0,"c1.txt");
        map.put(1,"c2.txt");
        map.put(2,"c3.txt");
        String fn=map.get(i);
        try {
            InputStreamReader isr = new InputStreamReader(getAssets().open(fn));
            BufferedReader br = new BufferedReader(isr);
            String line;
            StringBuffer sb = new StringBuffer();
            while ((line = br.readLine()) != null)
            {
                sb.append(line+"\n");

            }
            br.close();
            tvChapter.setText(sb.toString());
        }catch (IOException e)
        {
           e.printStackTrace();

        }

        fabNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(cp==map.size()-1){
                    Toast.makeText(getApplicationContext(),"Last Chapter",Toast.LENGTH_SHORT).show();
                }
                else{
                    String fn=map.get(++cp);
                    try {
                        InputStreamReader isr = new InputStreamReader(getAssets().open(fn));
                        BufferedReader br = new BufferedReader(isr);
                        String line;
                        StringBuffer sb = new StringBuffer();
                        while ((line = br.readLine()) != null)
                        {
                            sb.append(line+"\n");

                        }
                        br.close();
                        tvChapter.setText(sb.toString());
                    }catch (IOException e)
                    {
                        e.printStackTrace();

                    }

                }
            }
        });
        fabPrev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(cp==0){
                    Toast.makeText(getApplicationContext(),"First Chapter",Toast.LENGTH_SHORT).show();
                }
                else{
                    String fn=map.get(--cp);
                    try {
                        InputStreamReader isr = new InputStreamReader(getAssets().open(fn));
                        BufferedReader br = new BufferedReader(isr);
                        String line;
                        StringBuffer sb = new StringBuffer();
                        while ((line = br.readLine()) != null)
                        {
                            sb.append(line+"\n");

                        }
                        br.close();
                        tvChapter.setText(sb.toString());
                    }catch (IOException e)
                    {
                        e.printStackTrace();

                    }

                }
            }
        });


    }
}
