package org.qap.timelineviewtest;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import org.qap.ctimelineview.TimelineRow;
import org.qap.ctimelineview.TimelineViewAdapter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class TimelineTest extends AppCompatActivity {

    //Create Timeline Rows List
    private ArrayList<TimelineRow> TimelineRowsList = new ArrayList<>();
    ArrayAdapter<TimelineRow> myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timeline_test);


        // Add Random Rows to the List
        for (int i=0; i<15; i++) {
            TimelineRowsList.add(
                    new TimelineRow(
                            //Row Id
                            i
                            //Row Date
                            ,getRandomDate()
                            //Row Title or null
                            ,"Title "+i
                            //Row Description or null
                            ,"Description " +i
                            //Row Image
                            ,"img_"+ getRandomNumber(0,9)
                            //Row Bellow Line Color
                            , getRandomColor()
                            //Row Bellow Line Size in dp
                            , getRandomNumber(2,25)
                            //Row Image Size in dp 
                            , getRandomNumber(25,40))
            );
        }

        //Create the Timeline Adapter to order the list by date
        myAdapter = new TimelineViewAdapter(this, 0, TimelineRowsList,
                //if true, list will be arranged by date
                true);



        //Get the ListView and Bind it with the Timeline Adapter
        ListView myListView = (ListView) findViewById(R.id.timelineListView2);
        myListView.setAdapter(myAdapter);



        myListView.setOnScrollListener(new AbsListView.OnScrollListener() {
                                           private int currentVisibleItemCount;
                                           private int currentScrollState;
                                           private int currentFirstVisibleItem;
                                           private int totalItem;
                                           private LinearLayout lBelow;


                                           @Override
                                           public void onScrollStateChanged(AbsListView view, int scrollState) {
                                               // TODO Auto-generated method stub
                                               this.currentScrollState = scrollState;
                                               this.isScrollCompleted();
                                           }

                                           @Override
                                           public void onScroll(AbsListView view, int firstVisibleItem,
                                                                int visibleItemCount, int totalItemCount) {
                                               // TODO Auto-generated method stub
                                               this.currentFirstVisibleItem = firstVisibleItem;
                                               this.currentVisibleItemCount = visibleItemCount;
                                               this.totalItem = totalItemCount;


                                           }

                                           private void isScrollCompleted() {
                                               if (totalItem - currentFirstVisibleItem == currentVisibleItemCount
                                                       && this.currentScrollState == SCROLL_STATE_IDLE) {
                                                   /** To do code here*/

                                                   for (int i=0; i<15; i++) {
                                                       myAdapter.add(
                                                               new TimelineRow(
                                                                       //Row Id
                                                                       i
                                                                       //Row Date
                                                                       ,getRandomDate()
                                                                       //Row Title or null
                                                                       ,"Title "+i
                                                                       //Row Description or null
                                                                       ,"Description " +i
                                                                       //Row Image
                                                                       ,"img_"+ getRandomNumber(0,9)
                                                                       //Row Bellow Line Color
                                                                       , getRandomColor()
                                                                       //Row Bellow Line Size in dp
                                                                       , getRandomNumber(2,25)
                                                                       //Row Image Size in dp
                                                                       , getRandomNumber(25,40))
                                                       );
                                                   }

                                               }
                                           }


                                       });

        //if you wish to handle the clicks on the rows
        AdapterView.OnItemClickListener adapterListener = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TimelineRow row = TimelineRowsList.get(position);
                Toast.makeText(TimelineTest.this, row.getTitle(), Toast.LENGTH_SHORT).show();
                myAdapter.insert(new TimelineRow(
                        //Row Id
                        TimelineRowsList.size()
                        //Row Date
                        ,new Date()
                        //Row Title or null
                        ,"Title "+TimelineRowsList.size()
                        //Row Description or null
                        ,"Description " +TimelineRowsList.size()
                        //Row Image
                        ,"img_"+ getRandomNumber(0,9)
                        //Row Bellow Line Color
                        , getRandomColor()
                        //Row Bellow Line Size in dp
                        , getRandomNumber(2,25)
                        //Row Image Size in dp
                        , getRandomNumber(25,40))
                        //insert position
                        ,0)
                ;
            }
        };
        myListView.setOnItemClickListener(adapterListener);


    }









    //Random Methods
    public int getRandomColor(){
        Random rnd = new Random();
        return Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
    }

    public int getRandomNumber(int min, int max){
        return  min + (int)(Math.random() * max);
    }



    public Date getRandomDate () {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date startDate = null;
        Date endDate = new Date();
        try {
            startDate = sdf.parse("02/09/2015");
            long random = ThreadLocalRandom.current().nextLong(startDate.getTime(), endDate.getTime());
            endDate = new Date(random);
        }
        catch (ParseException e) {
            e.printStackTrace();
        }
        return endDate;
    }

}
