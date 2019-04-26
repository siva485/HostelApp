package thinking.preparing.hostelapp;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class CustomAdapter extends ArrayAdapter {

    ArrayList<EmployeeModel> employeeList;
    public Context context;
    public int resourceLayout;
    LayoutInflater layoutInflater;

    public CustomAdapter(MainActivity mainActivity, int activity_main, ArrayList<EmployeeModel> employeeList) {
        super(mainActivity,activity_main);
        context = mainActivity;
        resourceLayout = activity_main;
        this.employeeList = employeeList;
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    @Override
    public int getCount() {
        return employeeList.size();
    }

    @Override
    public Object getItem(int i) {
        return employeeList.get(i);
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
       view = layoutInflater.inflate(R.layout.custom_list_view,null);
       TextView nameTextView = view.findViewById(R.id.name_text_view);
       TextView idTextView = view.findViewById(R.id.id_text_view);
       TextView phoneTextView = view.findViewById(R.id.phone_text_view);
        ImageView imageView = view.findViewById(R.id.image_button);
        nameTextView.setText(employeeList.get(i).getName().toString());
        idTextView.setText(String.valueOf(employeeList.get(i).getId()));
        phoneTextView.setText(employeeList.get(i).getPhone().toString());
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context,"hello world",Toast.LENGTH_LONG).show();
                Intent newEmployeeIntent = new Intent(context,NewEmployeeCreation.class);
                context.startActivity(newEmployeeIntent);

            }
        });

        return view;
    }


}
