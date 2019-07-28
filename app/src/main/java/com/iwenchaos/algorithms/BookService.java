package com.iwenchaos.algorithms;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.annotation.Nullable;

import com.iwenchaos.algorithms.aidl.Book;
import com.iwenchaos.algorithms.aidl.IBookManager;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Created by chaos
 * on 2019/1/11. 15:06
 * 文件描述：
 */
public class BookService extends Service {

    private CopyOnWriteArrayList<Book> mBooks = new CopyOnWriteArrayList<>();

    private Binder mBinder = new IBookManager.Stub(){

        @Override
        public List<Book> getBookList() throws RemoteException {
            return mBooks;
        }

        @Override
        public void addBook(Book book) throws RemoteException {
            mBooks.add(book);
        }
    };

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return mBinder;
    }



}
