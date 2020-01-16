package raum.muchbeer.stackoverflowrecyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;

import static java.sql.Types.NULL;

public class MainActivity extends AppCompatActivity implements RemoveClickListner{

    private RecyclerView mRecyclerView;
    private Adapter mRecyclerAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    Button btnAddItem;
    ArrayList<RecyclerData> myList = new ArrayList<>();
    EditText etTitle;
    String title = "";
    ImageView crossImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = findViewById(R.id.recyclerView);
        mRecyclerAdapter = new Adapter(myList,this);

       /* mRecyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        mRecyclerView.setLayoutManager(mLayoutManager);
*/

        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(getApplicationContext(), 2);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mRecyclerAdapter);

        etTitle = (EditText) findViewById(R.id.editTitle);

               if (mRecyclerAdapter.getItemCount() == 0 || mRecyclerAdapter.getItemCount() == NULL){
            Toast.makeText(getApplicationContext(),"ZERO ITEMS LISTED",Toast.LENGTH_SHORT).show();
        }

        btnAddItem = (Button) findViewById(R.id.btnSave);

        btnAddItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                title = etTitle.getText().toString();

                if (title.matches("")) { Toast.makeText(view.getContext(), "You did not enter a Title", Toast.LENGTH_SHORT).show();
                                      return;
                                  }
               RecyclerData mLog = new RecyclerData();
                mLog.setTitle(title);

                myList.add(mLog);
                mRecyclerAdapter.notifyData(myList);
                etTitle.setText("");

            }
        });
    }

    @Override
    public void OnRemoveClick(int index) {
        myList.remove(index);
        mRecyclerAdapter.notifyData(myList);
    }
}
