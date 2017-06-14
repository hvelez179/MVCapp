package com.example.android.userinfocall2;

import android.os.Looper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import com.example.android.userinfocall2.entities.User;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, UsersContract.View{

    private static final String TAG = "mainActivity";
    private Button user_bt;
    private ArrayList <User> userList;
    RecyclerView recyclerView;

    UserRecyclerAdapter adapter;
    UsersPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        user_bt = (Button) findViewById(R.id.get_user_bt);
        user_bt.setOnClickListener(this);
        userList = new ArrayList<>();

        recyclerView = (RecyclerView) findViewById(R.id.recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        presenter = new UsersPresenter(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        adapter = new UserRecyclerAdapter(userList, this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.get_user_bt:
                presenter.populateUserList();
                break;
        }
    }

    @Override
    public void showUserData(ArrayList<User> listInfo) {
        UserRecyclerAdapter adapter = new UserRecyclerAdapter(listInfo, this);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void showErrorMessage(String error) {
        Log.d(TAG, "showErrorMessage: " + error);
    }
}

