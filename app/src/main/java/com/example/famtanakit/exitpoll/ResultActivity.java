package com.example.famtanakit.exitpoll;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.famtanakit.exitpoll.adapter.PollAdapter;
import com.example.famtanakit.exitpoll.db.DatabaseHelper;
import com.example.famtanakit.exitpoll.model.Pollitem;

import java.util.ArrayList;
import java.util.List;

import static com.example.famtanakit.exitpoll.db.DatabaseHelper.COL_ID;
import static com.example.famtanakit.exitpoll.db.DatabaseHelper.COL_IMAGE;
import static com.example.famtanakit.exitpoll.db.DatabaseHelper.COL_NUM;
import static com.example.famtanakit.exitpoll.db.DatabaseHelper.TABLE_NAME;

public class ResultActivity extends AppCompatActivity {


    private DatabaseHelper mHelper;
    private SQLiteDatabase mDb;
    private List<Pollitem> mPollItemList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        mHelper = new DatabaseHelper(ResultActivity.this);
        mDb = mHelper.getWritableDatabase();
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();

        loadPhoneData();
        setupListView();
    }

    private void loadPhoneData() {
        Cursor c = mDb.query(TABLE_NAME, null, null, null, null, null, null);

        mPollItemList = new ArrayList<>();
        while (c.moveToNext()) {
            long id = c.getLong(c.getColumnIndex(COL_ID));
            String num_poll = c.getString(c.getColumnIndex(COL_NUM));
            String image = c.getString(c.getColumnIndex(COL_IMAGE));

            Pollitem item = new Pollitem(id, num_poll, image);
            mPollItemList.add(item);
        }
        c.close();
    }

    private void setupListView() {
        PollAdapter adapter = new PollAdapter(
                ResultActivity.this,
                R.layout.item_poll,
                mPollItemList
        );
        ListView lv = findViewById(R.id.result_list_view);
        lv.setAdapter(adapter);

    }
}
/*public class ResultActivity extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
    }

}*/