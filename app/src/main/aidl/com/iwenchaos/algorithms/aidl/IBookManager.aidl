// IBookManager.aidl
package com.iwenchaos.algorithms.aidl;

// Declare any non-default types here with import statements

import com.iwenchaos.algorithms.aidl.Book;

interface IBookManager {


        List<Book> getBookList();

        void addBook(in Book book);

}
