package com.example.sainikhil.smartcartproject;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import static android.R.attr.filter;


class NovelGridAdapter extends BaseAdapter {
    Context context;
    ArrayList<ImageClick> imageClickListNovel;
    ArrayList<ImageClick>filterlist;
    CustomFilter1 filter;
    public NovelGridAdapter() {
    }

    public NovelGridAdapter(Context context, ArrayList<ImageClick> imageClickListNovel) {
        this.context = context;
        this.imageClickListNovel = imageClickListNovel;
        this.filterlist=imageClickListNovel;
    }

    @Override
    public int getCount() {
        return imageClickListNovel.size();
    }

    @Override
    public Object getItem(int position) {
        return imageClickListNovel.get(position);
    }

    @Override
    public long getItemId(int position) {
        return imageClickListNovel.indexOf(getItem(position));
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
        imageview.setImageResource(imageClickListNovel.get(position).getImageid());
        textview.setText(imageClickListNovel.get(position).getImageName());
        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s=getString(position);
                Toast.makeText(context,"you clicked on "+imageClickListNovel.get(position).getImageName(),Toast.LENGTH_SHORT).show();
                if(s=="The Boy on the Wooden Box") {
                    Intent i = new Intent(v.getContext(),NovelActivity2.class);
                    context.startActivity(i);
                }
                else if(s=="The Life we Bury") {
                    Intent i = new Intent(v.getContext(),NovelActivity3.class);
                    context.startActivity(i);
                }
                else if(s=="Beneath a Scarlet Sky") {
                    Intent i = new Intent(v.getContext(),NovelActivity1.class);
                    context.startActivity(i);
                }
            }
        });
        return convertView;
    }

    public String getString(int position)
    {
        return imageClickListNovel.get(position).getImageName();
    }
    public Filter getNovelFilter()
    {
        if(filter==null)
        {
            filter=new CustomFilter1();
        }
        return filter;
    }
    class CustomFilter1 extends Filter
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
            imageClickListNovel=(ArrayList<ImageClick>)results.values;
            notifyDataSetChanged();
        }
    }

}
