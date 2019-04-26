package thinking.preparing.hostelapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class NewEmployeeCreation extends Activity {

    TextView newEmployeeName,newEmployeeaddress,newEmployeePhone;
    EditText newEmployeeNameInput,newEmployeeAddressInput,newEmployeePhoneInput;
    Button submittButton,getDataButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_employee_layout);
        newEmployeeName = findViewById(R.id.new_employee_name);
        newEmployeeaddress = findViewById(R.id.new_employee_address_text_view);
        newEmployeePhone = findViewById(R.id.new_employee_phone_textview);
        newEmployeeNameInput = findViewById(R.id.new_employee_name_inputfield);
        newEmployeeAddressInput = findViewById(R.id.new_address_input);
        newEmployeePhoneInput = findViewById(R.id.new_employee_phone_inputtextview);
        submittButton = findViewById(R.id.submitt_button);
        getDataButton = findViewById(R.id.getDataButton);
        submittButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DBClass.dataBaseInstance(getApplicationContext()).insetDataIntoDatabase(newEmployeeNameInput.getText().toString(),newEmployeeAddressInput.getText().toString(),newEmployeePhoneInput.getText().toString());
            }
        });
        getDataButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
            }
        });

    }
}
