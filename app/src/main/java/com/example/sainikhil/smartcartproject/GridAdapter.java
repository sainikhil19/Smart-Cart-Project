package com.example.sainikhil.smartcartproject;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

class GridAdapter extends BaseAdapter implements Filterable {
    Context context;
    ArrayList<ImageClick> imageClickList;
    ArrayList<ImageClick>filterlist;
    CustomFilter filter;
    public GridAdapter( Context context, ArrayList<ImageClick> imageClickList) {
        this.context = context;
        this.imageClickList = imageClickList;
        this.filterlist=imageClickList;
    }

    @Override
    public int getCount() {
        return imageClickList.size();
    }

    @Override
    public Object getItem(int position) {
        return imageClickList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return imageClickList.indexOf(getItem(position));
    }

    public View getView(final int position, View convertView, ViewGroup parent)
    {
        LayoutInflater layoutinflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if(convertView==null)
        {
            convertView=layoutinflater.inflate(R.layout.single_item,null);

        }
        ImageView imageview=(ImageView)convertView.findViewById(R.id.image);
        TextView textview=(TextView)convertView.findViewById(R.id.imageName);
        imageview.setImageResource(imageClickList.get(position).getImageid());
        textview.setText(imageClickList.get(position).getImageName());
        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str=getString(position);
                Toast.makeText(context,"you clicked on "+imageClickList.get(position).getImageName(),Toast.LENGTH_SHORT).show();
                if(str=="Spinner") {
                    Intent i = new Intent(v.getContext(),FidgetActivity.class);
                    context.startActivity(i);
                }
                else if(str=="Novel") {
                    Intent i = new Intent(v.getContext(),NovelActivity.class);
                    context.startActivity(i);
                }
                else if(str=="Puzzle")
                {
                    Intent i = new Intent(v.getContext(),PuzzleActivity.class);
                    context.startActivity(i);
                }
                else if(str=="Shirts for men")
                {
                    Intent i = new Intent(v.getContext(),ShirtActivity.class);
                    context.startActivity(i);
                }
                else if(str=="Graduate cap")
                {
                    Intent i = new Intent(v.getContext(),CapActivity.class);
                    context.startActivity(i);
                }
                else if(str=="Guitar")
                {
                    Intent i = new Intent(v.getContext(),GuitarActivity.class);
                    context.startActivity(i);
                }
                else if(str=="Pens")
                {
                    Intent i = new Intent(v.getContext(),PenActivity.class);
                    context.startActivity(i);
                }
                else if(str=="Stationary Items")
                {
                    Intent i = new Intent(v.getContext(),StationaryActivity.class);
                    context.startActivity(i);
                }
            }
        });
        return convertView;
    }

    public String getString(int position)
    {
        return imageClickList.get(position).getImageName();
    }
    public Filter getFilter()
    {
        if(filter==null)
        {
            filter=new CustomFilter();
        }
        return filter;
    }
    class CustomFilter extends Filter
    {

        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            FilterResults results=new FilterResults();
            if(constraint != null && constraint.length() > 0)
            {
                constraint=constraint.toString().toUpperCase();
                ArrayList<ImageClick> filters=new ArrayList<ImageClick>();
                for( int i=0;i<filterlist.size();i++)
                {
                    if(filterlist.get(i).getImageName().toUpperCase().contains(constraint))
                    {
                        ImageClick imageClick=new ImageClick(filterlist.get(i).getImageName(),filterlist.get(i).getImageid());
                        filters.add(imageClick);
                    }
                }
                results.count=filters.size();
                results.values=filters;
            }
            else
            {
                results.count=filterlist.size();
                results.values=filterlist;
            }
            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            imageClickList=(ArrayList<ImageClick>)results.values;
            notifyDataSetChanged();
        }
    }

}
