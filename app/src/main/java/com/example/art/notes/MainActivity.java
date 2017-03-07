package com.example.art.notes;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageButton mShowDialog = (ImageButton) findViewById(R.id.addItemBtn);
        mShowDialog.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                AlertDialog.Builder mBuilder = new AlertDialog.Builder(MainActivity.this);
                View mView = getLayoutInflater().inflate(R.layout.adding_dialog, null);
                final EditText mText = (EditText) mView.findViewById(R.id.newNoteTextView);
                Button mAdd = (Button) mView.findViewById(R.id.noteAddButton);
                mAdd.setOnClickListener(new View.OnClickListener(){
                    @Override
                    public void onClick(View view){
                        if(mText.getText().toString().isEmpty()){ //(!mText.getText veliau perdaryt kad atvirksciai butu
                            Toast.makeText(MainActivity.this,
                                    "neivestas tekstas",
                                    Toast.LENGTH_SHORT).show();
                        }
                        else{ //idet i duomenu baze veliau
                            Toast.makeText(MainActivity.this,
                                    "ivestas tekstas",
                                    Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                mBuilder.setView(mView);
                AlertDialog dialog = mBuilder.create();
                dialog.show();
            }
        });
    }
}
