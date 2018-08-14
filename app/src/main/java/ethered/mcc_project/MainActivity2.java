package ethered.mcc_project;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.provider.ContactsContract;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import static ethered.mcc_project.R.id.sub;
import static java.lang.Math.round;

public class MainActivity2 extends AppCompatActivity {
    int bunkilec=3;
    int currlec=7;
    ImageButton addlec;
    ImageButton bunklec;
    TextView currbunk;
    TextView curratt;
    TextView minreq;
    TextView circtext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        final Vector<Form> vform = new Vector<Form>();
        //final String f1[][] =new String[50][4];
        TextView add = (TextView)findViewById(R.id.addsubject);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity2.this);
                LayoutInflater layoutInflater = getLayoutInflater();
                final View Dialogview = layoutInflater.inflate(R.layout.alertform,null);
                builder.setView(Dialogview);
                //EditText editText = (EditText)Dialogview.findViewById()
                AlertDialog alertDialog = builder.create();
                alertDialog.show();

                TextView done = (TextView) Dialogview.findViewById(R.id.done);
                done.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //added dialogview here
                EditText e = (EditText) Dialogview.findViewById(sub);
                String subname = e.getText().toString();
                e= Dialogview.findViewById(R.id.attendance);
                String attendreq = e.getText().toString();
                e = Dialogview.findViewById(R.id.bunked);
                String bunked =e.getText().toString();
                e= Dialogview.findViewById(R.id.attended);
                String attended =e.getText().toString();
                //Form f = new Form(subname,attendreq,attended,bunked);
                //form.add()
                Form f = new Form();
                f.Form(subname,attendreq,attended,bunked);
                /*f1[0][0] = subname;
                f1[0][1] = attendreq;
                        f1[0][2] = attended;
                        f1[0][3] = bunked;

Log.v("form",f1[0][0]);
                        Log.v("form",f1[0][1]);
                        Log.v("form",f1[0][2]);
                        Log.v("form",f1[0][3]);

*/

                vform.addElement(f);
/*                Log.v("user",vform.get(0).subname);
                        Log.v("user",vform.get(0).attendreq);
                        Log.v("user",vform.get(0).attended);
                        Log.v("user",vform.get(0).bunked);

*/

                        SharedPreferences settings=getSharedPreferences("PREFS",0);
                        SharedPreferences.Editor editor= settings.edit();
                        //editor.putString("form",)




                                    }
                });

            }
        });


        addlec = (ImageButton)findViewById(R.id.addlec);
        bunklec = (ImageButton)findViewById(R.id.addbunk);
       curratt = (TextView)findViewById(R.id.curratt);
         currbunk = (TextView)findViewById(R.id.currbunk);

         circtext = (TextView)findViewById(R.id.circletext);
         minreq = (TextView)findViewById(R.id.minrequired);
        addlec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              // currlec[0] = Integer.parseInt(curratt.getText().toString());
                currlec++;
               String i = ""+currlec;
                curratt.setText(i);
                String t =""+ cal(currlec,bunkilec);
            circtext.setText(t);





            }
        });

        bunklec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // bunkilec = Integer.parseInt(currbunk.getText().toString());

                bunkilec++;
                String i = ""+bunkilec;

                currbunk.setText(i);
                float at=cal(currlec,bunkilec);

                String t =""+at;
                circtext.setText(t);

            }
        });


    }

public static int minlec(int t,int b)
{
    return 3*b-t;
}
    public float cal(int att,int bunk)
    {
        int b=att+bunk;
        float a;
        a=(float) (100*1.0*att/b);
        a=round(a*100/100);
        return a;
    }

    public static float calfloat(int att,int bunk)
    {
        return (float)(1.0*att/(att+bunk));
    }


}

class Form
{


    String subname,attendreq,attended,bunked;
    public void Form(){}
    public void Form(String sub, String attreq, String attended,String bunked)
    {
        subname= sub;
        attendreq=attreq;
        this.attended=attended  ;
        this.bunked=bunked ;
    }
}

