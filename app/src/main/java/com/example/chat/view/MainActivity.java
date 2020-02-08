package com.example.chat.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

import com.example.chat.MainController;
import com.example.chat.R;
import com.example.chat.model.Message;
import com.example.chat.presenter.MessagePresenter;
import com.example.chat.adapter.AdapterMessage;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements MainController.View {

    private String TAG = "View";
    private EditText edit;
    private ImageButton imageButton;
    private RecyclerView recyclerView;

    private MainController.Presenter messagePresenter;

    private AdapterMessage adapterMessage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edit = findViewById(R.id.editmessage);
        imageButton = findViewById(R.id.send);
        recyclerView = findViewById(R.id.recycleviewmessagepole);

        messagePresenter = new MessagePresenter(this);

        adapterMessage = new AdapterMessage(messagePresenter.getListMessage());

        createRecycleView();

    }

    private void createRecycleView()
    {
        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        recyclerView.setAdapter(adapterMessage);
    }

   //Нажатие на кнопку отправить
    public void onSend(View view) {
        String message = edit.getText().toString().trim();
        if (!message.equals(""))
        messagePresenter.onSend(message);
        edit.setText("");
        Log.d(TAG,"onSend");
    }

    @Override
    public void updateMessages() {
        adapterMessage.notifyDataSetChanged();
        recyclerView.smoothScrollToPosition(messagePresenter.getListMessage().size());
        Log.d(TAG,"updateMessages");
    }
}
