package hust.cs.javacourse.search.index.impl;

import hust.cs.javacourse.search.index.AbstractPosting;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Comparator;
import java.util.List;

public class Posting extends AbstractPosting {
    public Posting(){}
    public Posting(int docId, int freq, List<Integer> positions)
    {
        this.docId = docId;
        this.freq = freq;
        this.positions = positions;
    }

    @Override
    public int compareTo(AbstractPosting o) {
        if(o == null) return docId;
        return this.docId - o.getDocId();
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) return true;
        if(obj == null || getClass()!=obj.getClass()) return false;

        Posting posting = (Posting) obj;
        return this.docId == posting.docId &&
                this.freq == posting.freq &&
                this.positions == posting.positions;
    }

    @Override
    public String toString() {
        return " docId: " + docId + " freq: " + freq + " positions:" + positions;
    }

    @Override
    public int getDocId() {
        return this.docId;
    }

    @Override
    public void setDocId(int docId) {
        this.docId = docId;
    }

    @Override
    public int getFreq() {
        return this.freq;
    }

    @Override
    public void setFreq(int freq) {
        this.freq = freq;
    }

    @Override
    public List<Integer> getPositions() {
        return this.positions;
    }

    @Override
    public void setPositions(List<Integer> positions) {
        this.positions = positions;
    }

    @Override
    public void sort() {
        positions.sort(Comparator.naturalOrder());
    }

    @Override
    public void readObject(ObjectInputStream in) {
        try{
            docId = (int) in.readObject();
            freq = (int) in.readObject();
            positions = (List<Integer>) in.readObject();
        } catch (IOException e1){

        } catch (ClassNotFoundException e2){

        }
    }


    @Override
    public void writeObject(ObjectOutputStream out) {
        try{out.writeInt(docId);
            out.writeInt(freq);
            out.writeObject(positions);} catch(IOException e1) {}

    }


}
