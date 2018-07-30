package org.master.utils.bldeapplication;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

public class TestDemo extends AppCompatActivity {

    Button alert,toast,notification;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_demo);

        alert = findViewById(R.id.alert);
        toast = findViewById(R.id.toast);
        notification = findViewById(R.id.notification);

        alert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder builder = new AlertDialog.Builder(TestDemo.this);
                View view = LayoutInflater.from(TestDemo.this).inflate(R.layout.item_view,
                        (ViewGroup)findViewById(R.id.toastDemo));
                builder.setView(view);
                builder.setTitle("Alert Dialog box");
                builder.setMessage("Are you Sure, You want delete?");
                builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(TestDemo.this, "You clicked Ok button", Toast.LENGTH_SHORT).show();
                        dialog.dismiss();
                    }
                });
                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });

                AlertDialog alertDialog = builder.create();
                alertDialog.show();

            }
        });

        toast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast toast = new Toast(TestDemo.this);
                View view = LayoutInflater.from(TestDemo.this).inflate(R.layout.item_view,
                        (ViewGroup)findViewById(R.id.toastDemo));
                toast.setView(view);
                toast.show();
            }
        });


        notification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}
