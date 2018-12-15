package br.com.philippesis.spinnersearchable;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import in.galaxyofandroid.spinerdialog.OnSpinerItemClick;
import in.galaxyofandroid.spinerdialog.SpinnerDialog;

public class MainActivity extends AppCompatActivity {

    private Button mbtnMain;
    private ArrayList<String> mList;
    private SpinnerDialog mspDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mList = new ArrayList<>();
        mList.add("Batman");
        mList.add("Superman");
        mList.add("Spiderman");
        mList.add("Greenarrow");

        mbtnMain = (Button) findViewById(R.id.idbtnMain);

        mspDialog = new SpinnerDialog(MainActivity.this, mList, "Selecione um heroi");
        mspDialog.bindOnSpinerListener(new OnSpinerItemClick() {
            @Override
            public void onClick(String item, int position) {
                Toast.makeText(MainActivity.this, "Selecionado: "+item, Toast.LENGTH_SHORT).show();
            }
        });

        mbtnMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mspDialog.showSpinerDialog();
            }
        });

    }
}
