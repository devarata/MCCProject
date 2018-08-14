package ethered.mcc_project;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Firstpage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firstpage);
        TextView attendtrack = (TextView) findViewById(R.id.attendtrack);
        attendtrack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),MainActivity2.class);
                startActivity(i);
            }
        });

        TextView note = (TextView) findViewById(R.id.assigntrack);
        note.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),Simple_NotepadActivity.class);
                startActivity(i);
            }
        });

    }

     private void testupload()
     {
         int i = 1+1;
         int j = 2+2;
         int ii = i+j;
     }
}
