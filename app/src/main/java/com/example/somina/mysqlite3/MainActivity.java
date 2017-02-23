package com.example.somina.mysqlite3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

   TextView Text1, Text2 ;
    ImageView imageView;
    Employee employee;
    private DataBase dataBase;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = (ImageView)findViewById(R.id.imageView);
        Text1 = (TextView) findViewById(R.id.name);
        Text2 = (TextView) findViewById(R.id.age);

        Log.d("Insert: ", "Inserting ..");
       dataBase = new DataBase(this);
        if(dataBase.numberOfRows()>0){
            Log.e("MA ","Database already exist.");
        }

        else {
            saveImageInDB();
            Log.e("MA ", "Image Loaded from Database.");
        }

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (loadImageFromDB()) {
                    Log.e("MA ","Image Loaded from Database.");
                }
            }
        }, 0);

    }

    Boolean saveImageInDB() {
        employee = new Employee();
        employee.setEmployeeName("Subhrajyoti Brahma");
        employee.setEmployeeAge("26");

        Bitmap bitmapImage = BitmapFactory.decodeResource(getResources(),R.drawable.userimage);
        // convert bitmap to byte
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bitmapImage.compress(Bitmap.CompressFormat.PNG, 100, stream);
        byte imageInByte[] = stream.toByteArray();
        employee.employeeimageInByte = imageInByte;


        Log.d("Insert: ", "Inserting ..");
        dataBase.insertEmployee(employee);
        return true;
}

    Boolean loadImageFromDB() {
        try {
            ArrayList array_list = dataBase.getAllEmployee();
            Log.e("Employee Size ", String.valueOf(array_list.size()));

            if(!array_list.isEmpty()){
                Employee employee1 = (Employee) array_list.get(0);

                Text1.setText(employee1.employeeName);
                Text2.setText(employee1.employeeAge);
                imageView.setImageBitmap(Util.getImage(employee1.getEmployeeimageInByte()));

            }else {
                Log.e("MA ", "No Employee available ");
            }

            return true;
        } catch (Exception e) {
            Log.e("MA ", "<loadImageFromDB> Error : " + e.getLocalizedMessage());

            return false;
        }
    }

}
