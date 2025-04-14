package hust.cs.javacourse.search.index.impl;

import hust.cs.javacourse.search.index.AbstractPosting;
import hust.cs.javacourse.search.index.AbstractPostingList;


import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Comparator;
import java.util.List;

public class PostingList extends AbstractPostingList {
    public PostingList(){}

    @Override
    public void add(AbstractPosting posting) {
        if(!list.contains(posting)){
            list.add( posting);
        }
    }

    @Override
    public void add(List<AbstractPosting> postings) {
        for(AbstractPosting posting : postings)
        {
            if(!list.contains(posting)){
                list.add(posting);
            }
        }
    }

    @Override
    public void clear() {
        list.clear();
    }

    @Override
    public boolean contains(AbstractPosting posting) {
        return list.contains(posting);
    }

    @Override
    public AbstractPosting get(int index) {
        return list.get(index);
    }

    @Override
    public int indexOf(AbstractPosting posting) {
        for(int i = 0; i<list.size();i++){
            if(list.get(i) == posting)  return i;
        }
        return -1;
    }

    @Override
    public int indexOf(int docId) {
        for(int i = 0;i< list.size();i++){
            if(list.get(i).getDocId()==docId){
                return i;
            }
        }
        return -1;
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public void remove(AbstractPosting posting) {
            list.remove(posting);

    }

    @Override
    public void remove(int index) {
        list.remove(index);
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public void sort() {
        list.sort(new Comparator<AbstractPosting>() {
            @Override
            public int compare(AbstractPosting o1, AbstractPosting o2) {
                return o1.compareTo(o2);
            }
        });
    }

    @Override
    public String toString() {
        return list.toString();
    }

    @Override
    public void writeObject(ObjectOutputStream out) {
        try{
            out.writeObject(list);
        } catch (IOException e1){}
    }

    @Override
    public void readObject(ObjectInputStream in) {
        try{
            list = (List<AbstractPosting>) in.readObject();
        } catch (IOException e1){

        } catch (ClassNotFoundException e2){

        }

    }
}
