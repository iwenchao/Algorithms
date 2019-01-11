package com.iwenchaos.algorithms;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.iwenchaos.algorithms.aidl.Book;
import com.iwenchaos.algorithms.aidl.IBookManager;

public class MainActivity extends AppCompatActivity {

    private IBookManager mBookManager = null;

    ServiceConnection mServiceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            mBookManager = IBookManager.Stub.asInterface(service);
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    };
    private int count;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent bind = new Intent(MainActivity.this, BookService.class);
        bindService(bind, mServiceConnection, Context.BIND_AUTO_CREATE);


        final TextView tv = findViewById(R.id.addBtn);
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mBookManager != null) {
                    try {
                        mBookManager.addBook(new Book(count++, "新书" + (count - 1)));
                        tv.setText(String.format(getString(R.string.add_and_count), mBookManager.getBookList().size()));
                    } catch (RemoteException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

    }


    @Override
    protected void onResume() {
        super.onResume();


    }
}
