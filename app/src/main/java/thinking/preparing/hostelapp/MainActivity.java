package thinking.preparing.hostelapp;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView employeeListView;
    ArrayAdapter listAdapter;
    CustomAdapter customAdapter;
    ArrayList<EmployeeModel> employeeList;
    DBClass dbClass;
    EditText name,phone,email;
    EmployeeModel employeeModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        employeeList = new ArrayList<>();
        EmployeeModel employeeModel = new EmployeeModel("1","siva","8354");
        employeeList.add(employeeModel);

        employeeListView = findViewById(R.id.employee_list_view);

        customAdapter = new CustomAdapter(this,R.layout.activity_main,employeeList);
        employeeListView.setAdapter(customAdapter);


        dbClass = DBClass.dataBaseInstance(getApplicationContext());

    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();

    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Cursor cursor = dbClass.getDataLines();
        if (cursor.getCount() == 0){

        }
        else {
            StringBuffer stringBuffer = new StringBuffer();
            while(cursor.moveToNext()){
                employeeModel = new EmployeeModel();
                employeeModel.setName(cursor.getString(1));
                employeeModel.setPhone(cursor.getString(2));
                employeeModel.setPhone(cursor.getString(3));
                employeeList.add(employeeModel);
            }
        }

    }
}
