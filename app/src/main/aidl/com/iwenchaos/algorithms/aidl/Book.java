package com.iwenchaos.algorithms.aidl;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by chaos
 * on 2019/1/11. 14:39
 * 文件描述：
 */
public class Book implements Parcelable {

    private int bookId;
    private String bookName;

    public Book() {
    }

    public Book(int bookId, String bookName) {
        this.bookId = bookId;
        this.bookName = bookName;
    }

    protected Book(Parcel in) {
        bookId = in.readInt();
        bookName = in.readString();
    }

    public static final Creator<Book> CREATOR = new Creator<Book>() {
        @Override
        public Book createFromParcel(Parcel in) {
            return new Book(in);
        }

        @Override
        public Book[] newArray(int size) {
            return new Book[size];
        }
    };

    /**
     * 如果该对象里面存在文件描述符，则返回1
     * 否则 返回0
     * @return
     */
    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(bookId);
        dest.writeString(bookName);
    }
}
