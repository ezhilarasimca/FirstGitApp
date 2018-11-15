package com.bloby.blob.newkitfirstapplication;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class DummyExpandActivity extends AppCompatActivity {

    ExpandableListView expand;
    ArrayList<expand_list_model> list=new ArrayList<expand_list_model>();

    ArrayList<String> childList=new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dummy_expand);
        expand=(ExpandableListView)findViewById(R.id.expand);

        childList.add("Apple");
        childList.add("Apple");
        childList.add("Apple");
        childList.add("Apple");
        list.add(new expand_list_model("First",childList));
        childList=new ArrayList<>();
        childList.add("Banana");
        childList.add("Banana");
        childList.add("Banana");
        childList.add("Banana");
        list.add(new expand_list_model("Second",childList));
        childList=new ArrayList<>();
        childList.add("Cherry");
        childList.add("Cherry");
        childList.add("Cherry");
        childList.add("Cherry");
        list.add(new expand_list_model("Third",childList));

        AdapterExpand adapt=new AdapterExpand(DummyExpandActivity.this,list);
        expand.setAdapter(adapt);
        adapt.notifyDataSetChanged();

    }


    public class AdapterExpand extends BaseExpandableListAdapter{
        Context context;
        ArrayList<expand_list_model> adapt_list=new ArrayList<expand_list_model>();

        //here i=listposition i1=expandlistposition  listposition mean adapt_list position like o,1,2
        // expandlistposition mean adapt_list have another list to get that list by using position is expandlistpostion

        //listposition for get title and set as group and expandlistposition for get inner arraylist value and set as child



        public AdapterExpand(DummyExpandActivity context,ArrayList<expand_list_model> adapt_list){
            this.adapt_list=adapt_list;
            this.context=context;
        }

        @Override
        public int getGroupCount() {
            return adapt_list.size();
        }

        @Override
        public int getChildrenCount(int i) {
            //need to send child size
            return adapt_list.get(i).getChildren().size();
        }

        @Override
        public Object getGroup(int i) {
            //here need to get parent title
            return adapt_list.get(i).getParents();
        }

        @Override
        public Object getChild(int i, int i1) {
            //here need to get child each list value
            return adapt_list.get(i).getChildren().get(i1);
        }

        @Override
        public long getGroupId(int i) {
            return i;
        }

        @Override
        public long getChildId(int i, int i1) {
            return i1;
        }

        @Override
        public boolean hasStableIds() {
            return false;
        }

        @Override
        public View getGroupView(int i, boolean b, View convertView, ViewGroup viewGroup) {
            String listTitle = (String) getGroup(i);
            if (convertView == null) {
                LayoutInflater layoutInflater = (LayoutInflater) this.context.
                        getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                convertView = layoutInflater.inflate(R.layout.list_group, null);
            }
            TextView listTitleTextView = (TextView) convertView
                    .findViewById(R.id.listTitle);
            ImageView img_group=(ImageView)convertView.findViewById(R.id.img_group);

           /* if(isExpanded){
                img_group.setImageResource(R.drawable.up_arrow);
            }
            else{
                img_group.setImageResource(R.drawable.down_arrow);
            }*/
            listTitleTextView.setTypeface(null, Typeface.BOLD);
            listTitleTextView.setText(listTitle);
            return convertView;
        }

        @Override
        public View getChildView(int i, int i1, boolean b, View view, ViewGroup viewGroup) {
            final String expandedListText = (String) getChild(i, i1);
            if (view == null) {
                LayoutInflater layoutInflater = (LayoutInflater) this.context
                        .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                view = layoutInflater.inflate(R.layout.list_item, null);
            }
            TextView expandedListTextView = (TextView) view
                    .findViewById(R.id.expandedListItem);
            expandedListTextView.setText(expandedListText);
            return view;
        }

        @Override
        public boolean isChildSelectable(int i, int i1) {
            return true;
        }
    }


}
