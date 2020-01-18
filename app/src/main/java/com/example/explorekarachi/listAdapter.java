package com.example.explorekarachi;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class listAdapter extends RecyclerView.Adapter<listAdapter.locationVH> {

    Context cx;
    private static final String TAG = "MovieAdapter";
    //List<location> locationList;

    ArrayList<example_item> locationList = new ArrayList<example_item>();
    //ArrayList<location> locationList = new ArrayList<location>();

    public listAdapter(ArrayList<example_item> locationList,Context context) {
        cx = context;
        this.locationList = locationList;
    }
    private ExampleAdapter.OnItemClickListener mListener;


    public void setOnItemClickListener(ExampleAdapter.OnItemClickListener listener) {
        mListener = listener;

    }


    @Override
    public void onBindViewHolder(@NonNull final locationVH holder, final int position) {

        //location l = locationList.get(position);
        final example_item l= locationList.get(position);
        holder.placeTextView.setText(l.getDescription());
        holder.descriptionTextView.setText(l.getLatitude());
     String timer;
     double timex = 74;
        //Shopping
        //Entertainment
        //Food

        if(l.getText1().equals("Shopping"))
        {
            timex = 60;
            if(Data.people.equals("1 person"))
            {
               timex = timex * 1.2;
            }
            if(Data.people.equals("3 or less"))
            {
                timex = timex * 1.4;
            }
            if(Data.people.equals("5 or less"))
            {
                timex = timex * 1.6;
            }
            if(Data.people.equals("more than 5"))
            {
                timex = timex * 1.9;
            }
        }
        else if(l.getText1().equals("Entertainment"))
        {
            timex = 30;
            if(Data.people.equals("1 person"))
            {
                timex = timex * 1.2;
            }
            if(Data.people.equals("3 or less"))
            {
                timex = timex * 1.4;
            }
            if(Data.people.equals("5 or less"))
            {
                timex = timex * 1.6;
            }
            if(Data.people.equals("more than 5"))
            {
                timex = timex * 1.9;
            }
        }
        else if(l.getText1().equals("Food"))
        {
            timex = 50;
            if(Data.people.equals("1 person"))
            {
                timex = timex * 1.2;
            }
            if(Data.people.equals("3 or less"))
            {
                timex = timex * 1.4;
            }
            if(Data.people.equals("5 or less"))
            {
                timex = timex * 1.6;
            }
            if(Data.people.equals("more than 5"))
            {
                timex = timex * 1.9;
            }
        }
        else
        {
            timex = 30;
            if(Data.people.equals("1 person"))
            {
                timex = timex * 1.2;
            }
            if(Data.people.equals("3 or less"))
            {
                timex = timex * 1.4;
            }
            if(Data.people.equals("5 or less"))
            {
                timex = timex * 1.6;
            }
            if(Data.people.equals("more than 5"))
            {
                timex = timex * 1.9;
            }
        }
        holder.timeTextview.setText(""+timex+" mins");
        holder.image.setImageResource(l.getImageResource());
//
//        holder.addmap.setOnItemClickListener(new ExampleAdapter.OnItemClickListener() {
//            @Override
//            public void onItemClick(final int position) {
//
//            }
//        });

        holder.addmap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Data.latitude = locationList.get(position).getLongitude();
                Data.longituide = locationList.get(position).getLocation();
                Intent i = new Intent(cx,ViewMap.class);
                cx.startActivity(i);
            }
        });


        holder.addlist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(cx, "Added to List", Toast.LENGTH_SHORT).show();
                Data.mylist.add(locationList.get(position));
            }
        });
        boolean isExpanded = locationList.get(position).isExpanded();
        holder.expandableLayout.setVisibility(isExpanded ? View.VISIBLE : View.GONE);


    }


    @NonNull
    @Override
    public locationVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_list_item,parent,false);
        return new locationVH(view);



    }



    @Override
    public int getItemCount() {
        return locationList.size();
    }


    class locationVH extends RecyclerView.ViewHolder {

        private static final String TAG = "MovieVH";

        //ConstraintLayout expandableLayout;
        RelativeLayout expandableLayout;
        TextView titleTextView, yearTextView, ratingTextView, plotTextView;
        TextView placeTextView;
        TextView descriptionTextView;
        TextView timeTextview;
        ImageView image;
        FloatingActionButton addmap;
        FloatingActionButton addlist;

        public locationVH(@NonNull final View itemView) {
            super(itemView);

            addmap =itemView.findViewById(R.id.viewOnnmap);
            addlist = itemView.findViewById(R.id.addToList);
            image = itemView.findViewById(R.id.image123);
            placeTextView = itemView.findViewById(R.id.title);
            descriptionTextView = itemView.findViewById(R.id.description);
            timeTextview = itemView.findViewById(R.id.time);
            expandableLayout = itemView.findViewById(R.id.expandableLayout);
            placeTextView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    example_item loc = locationList.get(getAdapterPosition());
                    loc.setExpanded(!loc.isExpanded());
                    notifyItemChanged(getAdapterPosition());

                }
            });
        }
    }



}

