package ethered.mcc_project;



import android.app.Dialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;    //
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;


import java.util.List;

public class MainDatabase extends AppCompatActivity implements View.OnClickListener {

    private static MainDatabase activityInstance;
    Button add, delete, edit, showList;
    ListView myListView;
    static MyDatabase myDatabase;
    List<MyData> myDatas;
    Dialog dialog;
    public EditText editSubName, editAttreq,editAttended,editBunked;
    private Button buttonOk, buttonCancel;
    int tagPosition;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        activityInstance = this;
        //initiate values
        add = (Button) findViewById(R.id.addsubject);
        delete = (Button) findViewById(R.id.delsubject);

        editSubName = (EditText)findViewById(R.id.sub);
        editAttended = (EditText)findViewById(R.id.attended);
        editBunked = (EditText)findViewById(R.id.bunked);
        editAttreq = (EditText)findViewById(R.id.attendance);
        //add Click Listener
        add.setOnClickListener(this);
        delete.setOnClickListener(this);


        myListView = (ListView) findViewById(R.id.list_data);

        //added longClickListener for edit data
        myListView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {

                LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.ll_main);
                int i = (int) linearLayout.getTag();
                /*
                * getDialog method ised for adding records as well as edit records  by adding integer as
                * "id" to edit record*/
                getDialog("Edit Record", i).show();

                Log.e("58 ", "" + i);
                return false;
            }
        });


        //added click listener for delete record
        myListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.ll_main);
                //just taken id to delete record
                tagPosition = (int) linearLayout.getTag();


            }
        });
        myDatabase = new MyDatabase(getInstance());
        showList();
    }

    public static MainDatabase getInstance() {
        return activityInstance;
    }


    private void showList() {
        myDatas = myDatabase.getAllDataFromTable();
        if (myDatas != null) {
            myListView.setAdapter(new MyListAdapter(this, R.layout.activity_main2, myDatas));
        } else {
            Toast.makeText(this, "NO record found!!!", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.addsubject:
Toast.makeText(getApplicationContext(),"Add sub",Toast.LENGTH_SHORT).show();
                getDialog("Add Record", 0).show();

                break;



            case R.id.delsubject:
                if (tagPosition != 0) {
                    myDatabase.deleteData(tagPosition);
                    showList();
                } else {
                    Toast.makeText(this, "Select record to delete!!!", Toast.LENGTH_SHORT).show();
                }
                break;

            /*case R.id.show_list:
                showList();
                break;
*/
            case R.id.done:
                String tag = (String) v.getTag();
                Toast.makeText(getApplicationContext(),""+tag,Toast.LENGTH_SHORT).show();

                /*

                int id = (int) v.getTag(R.string.app_name);
                if (tag.contains("Add")) {        switch (item.getItemId()) {

                    Toast.makeText(getApplicationContext(),"Done clicked",Toast.LENGTH_SHORT).show();
                    long i = myDatabase.insertData(editSubName.getText().toString(), editAttreq.getText().toString(),editAttended.getText().toString(),editBunked.getText().toString());
                    Log.e("102 -->", "No. of inserted  row : " + i);
                } else {
                    myDatabase.updateTable(id, editSubName.getText().toString(), editAttreq.getText().toString(),editAttended.getText().toString(),editBunked.getText().toString());
                    Log.e("102 -->", "updated  row : ");
                }
                showList();
                dialog.dismiss();
*/
                break;

            //case R.id.btn_cancel:
               // dialog.dismiss();

                //break;
        }

    }

    private Dialog getDialog(String title, int i) {
        dialog = new Dialog(this);
        dialog.setContentView(this.getLayoutInflater().inflate(R.layout.layout, null, false));
        dialog.setTitle(title);
        editSubName = (EditText) dialog.findViewById(R.id.sub);
        editAttreq = (EditText) dialog.findViewById(R.id.attendance);
        editAttended = (EditText) dialog.findViewById(R.id.attended);
        editBunked = (EditText)dialog.findViewById(R.id.bunked);

        buttonOk = (Button) dialog.findViewById(R.id.done);
        buttonOk.setTag(title);
        buttonOk.setTag(R.string.app_name, i);
        //buttonCancel = (Button) dialog.findViewById(R.id.btn_cancel);

        buttonOk.setOnClickListener(this);
        //buttonCancel.setOnClickListener(this);
        return dialog;
    }
}
