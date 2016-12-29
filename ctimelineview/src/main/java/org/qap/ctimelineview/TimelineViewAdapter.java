package org.qap.ctimelineview;


import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;


public class TimelineViewAdapter extends ArrayAdapter<TimelineRow> {

    private String YEAR, YEARS , MONTH , MONTHS , DAY , DAYS , HOUR , HOURS , MINUTE , MINUTES , SECOND , SECONDS , AND;

    private Context context;
    private List<TimelineRow> RowDataList;


    public TimelineViewAdapter(Context context, int resource, ArrayList<TimelineRow> objects, boolean orderTheList) {
        super(context, resource, objects);
        this.context = context;
        if (orderTheList)
            this.RowDataList = rearrangeByDate(objects);
        else
            this.RowDataList = objects;

        YEAR = context.getResources().getString(R.string.YEAR);
        YEARS = context.getResources().getString(R.string.YEARS);
        MONTH = context.getResources().getString(R.string.MONTH);
        MONTHS = context.getResources().getString(R.string.MONTHS);
        DAY = context.getResources().getString(R.string.DAY);
        DAYS = context.getResources().getString(R.string.DAYS);
        HOUR = context.getResources().getString(R.string.HOUR);
        HOURS = context.getResources().getString(R.string.HOURS);
        MINUTE = context.getResources().getString(R.string.MINUTE);
        MINUTES = context.getResources().getString(R.string.MINUTES);
        SECOND = context.getResources().getString(R.string.SECOND);
        SECONDS = context.getResources().getString(R.string.SECONDS);
        AND = context.getResources().getString(R.string.AND);
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        TimelineRow row = RowDataList.get(position);

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.ctimeline_row, null);

        TextView rowDate = (TextView) view.findViewById(R.id.crowDate);
        TextView rowTitle = (TextView) view.findViewById(R.id.crowTitle);
        TextView rowDescription = (TextView) view.findViewById(R.id.crowDesc);
        ImageView rowImage = (ImageView) view.findViewById(R.id.crowImg);
        View rowUpperLine = (View) view.findViewById(R.id.crowUpperLine);
        View rowLowerLine = (View) view.findViewById(R.id.crowLowerLine);


        final float scale = getContext().getResources().getDisplayMetrics().density;


        if (position == 0 && position == RowDataList.size()-1) {
            rowUpperLine.setVisibility(View.INVISIBLE);
            rowLowerLine.setVisibility(View.INVISIBLE);
        }
        else if(position==0) {
            int pixels = (int) (row.getBellowLineSize() * scale + 0.5f);

            rowUpperLine.setVisibility(View.INVISIBLE);
            rowLowerLine.setBackgroundColor(row.getBellowLineColor());
            rowLowerLine.getLayoutParams().width = pixels;
        }
        else if(position == RowDataList.size()-1) {
            int pixels = (int) (RowDataList.get(position-1).getBellowLineSize() * scale + 0.5f);

            rowLowerLine.setVisibility(View.INVISIBLE);
            rowUpperLine.setBackgroundColor(RowDataList.get(position-1).getBellowLineColor());
            rowUpperLine.getLayoutParams().width = pixels;
        }
        else {
            int pixels = (int) (row.getBellowLineSize() * scale + 0.5f);
            int pixels2 = (int) (RowDataList.get(position-1).getBellowLineSize() * scale + 0.5f);

            rowLowerLine.setBackgroundColor(row.getBellowLineColor());
            rowUpperLine.setBackgroundColor(RowDataList.get(position-1).getBellowLineColor());
            rowLowerLine.getLayoutParams().width = pixels;
            rowUpperLine.getLayoutParams().width = pixels2;
        }


        rowDate.setText(getPastTime(row.getDate()));
        if (row.getTitle() == null)
            rowTitle.setVisibility(View.GONE);
        else
            rowTitle.setText(row.getTitle());
        if (row.getDescription() == null)
            rowDescription.setVisibility(View.GONE);
        else
            rowDescription.setText(row.getDescription());


        if (row.getImage() !=null) {
            int imageID = context.getResources().getIdentifier(row.getImage(), "drawable", context.getPackageName());
            if (imageID != 0)
                rowImage.setImageResource(imageID);
        }

        int pixels = (int) (row.getImageSize() * scale + 0.5f);
        rowImage.getLayoutParams().width = pixels;
        rowImage.getLayoutParams().height = pixels;

        ViewGroup.MarginLayoutParams marginParams = (ViewGroup.MarginLayoutParams) rowImage.getLayoutParams();
        marginParams.setMargins(0, (int) (pixels/2)*-1, 0, (pixels/2)*-1);


        return view;
    }
    


    private String getPastTime(Date date) {

        if (date == null) return "";
        String dateText = "";
        Date today = new Date ();
        long diff = (today.getTime() - date.getTime()) / 1000;

        long years = diff / (60*60*24*30*12);
        long months = (diff / (60*60*24*30)) % 12;
        long days = (diff / (60*60*24)) %30;
        long hours = (diff / (60*60)) %24;
        long minutes = (diff / 60) % 60;
        long seconds = diff % 60;

        if (years  > 0) {
            if (years == 1) dateText += years + " " + YEAR;
            else dateText += years + " " + YEARS;
            if (months > 0 && months == 1) dateText += " " +  AND + " " + months + " " + MONTH;
            else if (months > 0) dateText += " " +  AND + " " + months + " " + MONTHS;
        }

        else if (months > 0 ) {
            if (months == 1) dateText += months + " " + MONTH;
            else dateText += months + " " + MONTHS;
            if (days > 0 && days == 1) dateText += " " +  AND + " " + days + " " + DAY;
            else if (days > 0) dateText += " " + AND + " " + days + " " + DAYS;
        }

        else if (days > 0) {
            if (days == 1) dateText += days + " " + DAY;
            else dateText += days + " " + DAYS;
            if (hours > 0 && hours == 1) dateText += " " +  AND + " " + hours + " " + HOUR;
            else if (hours > 0) dateText += " " +  AND + " " + hours + " " + HOURS;
        }

        else if (hours > 0) {
            if (hours == 1) dateText += hours + " " + HOUR;
            else dateText += hours + " " + HOURS;
            if (minutes > 0 && minutes == 1) dateText += " " +  AND + " " + minutes + " " + MINUTE;
            else if (minutes > 0) dateText += " " +  AND + " " + minutes + " " + MINUTES;
        }

        else if (minutes > 0) {
            if (minutes == 1) dateText += minutes + " " + MINUTE;
            else dateText += minutes + " " + MINUTES;
            if (seconds > 0 && seconds == 1) dateText += " " +  AND + " " + seconds + " " + SECOND;
            else if (seconds > 0) dateText += " " +  AND + " " + seconds + " " + SECONDS;
        }

        else if (seconds >= 0) {
            if (seconds == 1 || seconds ==0) dateText += seconds + " " + SECOND;
            else dateText += seconds + " " + SECONDS;
        }


        return dateText;
    }


    private ArrayList<TimelineRow> rearrangeByDate (ArrayList<TimelineRow> objects) {
        int size = objects.size();
        for (int i = 0; i< size-1; i++) {
            for (int j = i+1; j < size ; j++) {
                if (objects.get(i).getDate().compareTo(objects.get(j).getDate()) <= 0)
                    Collections.swap(objects, i, j);
            }

        }
        return objects;
    }

}
