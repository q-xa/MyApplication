package com.example.sj3;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ListUserActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_user);
        DBHelper dbHelper = new DBHelper(ListUserActivity.this);
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery("select username,major from user", null);
        List<Map<String, String>> userlist = new ArrayList<Map<String, String>>();
        while(cursor.moveToNext()){
            Map<String, String> item = new HashMap<String, String>();
            String username = cursor.getString(0);
            String major = cursor.getString(1);
            item.put("username", username);
            item.put("major", major);
            userlist.add(item);
        }
        cursor.close();
        SimpleAdapter adapter = new SimpleAdapter(this, userlist, R.layout.useritem,
                new String[] {"username", "major"}, new int[] {R.id.username, R.id.major});
        ListView userListView = (ListView) this.findViewById(R.id.userListView);
        userListView.setAdapter(adapter);
        }
}
