package com.example.manikyapavan.listadapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
//To display a more custom view for each item in your dataset, implement a ListAdapter.
// For example, extend BaseAdapter and create and configure the view for each data item in getView(...):

public class PersonListAdapter extends ArrayAdapter<Person> {
    private static final String TAG = "PersonListAdapter";

    private Context mContext;
    private int mResource;


    /**
     * Default constructor for the PersonListAdapter
     * @param context
     * @param resource
     * @param objects
     */
    public PersonListAdapter(Context context, int resource, ArrayList objects) {
        super(context, resource, objects);
        mContext = context;
        mResource = resource;
    }
/* The LayoutInflater takes your layout XML-files and creates different View-objects from its contents.

2: The adapters are built to reuse Views, when a View is scrolled so that is no longer visible, it can be used for one of the new Views appearing. This reused View is the convertView. If this is null it means that there is no recycled View and we have to create a new one, otherwise we should use it to avoid creating a new.

3: The parent is provided so you can inflate your view into that for proper layout parameters.

All these together can be used to effectively create the view that will appear in your list (or other view that takes an adapter):*/


    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //get the persons information
        String name = getItem(position).getName();
        String birthday = getItem(position).getBirthday();
        String sex = getItem(position).getSex();

        //Create the person object with the information
        Person person = new Person(name,birthday,sex);

        LayoutInflater inflater = LayoutInflater.from(mContext);
        convertView = inflater.inflate( mResource,parent,false );

        TextView tvName = (TextView) convertView.findViewById(R.id.textView1);
        TextView tvBirthday= (TextView) convertView.findViewById(R.id.textView2);
        TextView tvSex= (TextView) convertView.findViewById(R.id.textView3);


        tvName.setText(person.getName());
        tvBirthday.setText(person.getBirthday());
        tvSex.setText(person.getSex());


        return convertView;
    }
   //The main purpose of CustomList tehn we need to use
   //ListView attempts to reuse view objects in order to improve performance and avoid a lag in response to user scrolls
        // To take advantage of this feature, check if the convertView provided to getView(...) is null before
        // creating or inflating a new view object.
        // See Making ListView Scrolling Smooth for more ways to ensure a smooth user experience.




    }



