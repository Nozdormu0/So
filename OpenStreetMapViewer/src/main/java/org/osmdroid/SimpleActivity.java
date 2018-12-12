package org.osmdroid;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.view.View.OnClickListener;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class SimpleActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    public static final String TAG = "k";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
        // Generate a ListView with Sample Maps
        final ArrayList<String> list = new ArrayList<>();

        list.add("show location");
        list.add("back");

        ListView lv = (ListView) findViewById(R.id.activitylist);
        ArrayAdapter adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, list);

        lv.setAdapter(adapter);
        lv.setOnItemClickListener(this);
    }

    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        switch (position) {
            case 0:

                showDialog();
                break;
            case 1:
                this.startActivity(new Intent(this, MainActivity.class));
                break;
        }
    }

    private void showDialog(){
        AlertDialog.Builder builder=new AlertDialog.Builder(this);

        builder.setTitle("Your Location");
        builder.setMessage("NJU Xian Lin campus");
        builder.setPositiveButton("OK",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
        AlertDialog dialog=builder.create();
        dialog.show();

    }



}
