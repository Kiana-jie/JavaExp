package hust.cs.javacourse.search.index.impl;

import hust.cs.javacourse.search.index.AbstractTermTuple;

public class TermTuple extends AbstractTermTuple {
    public TermTuple(){};

    @Override
    public boolean equals(Object obj) {
        if(obj == this) return true;
        if(obj == null || getClass()!=obj.getClass()) return false;

        TermTuple termTuple = (TermTuple) obj;
        return this.curPos == termTuple.curPos &&
                this.freq == termTuple.freq &&
                this.term == termTuple.term;
    }

    @Override
    public String toString() {
        return " curPos: " + curPos + ", freq: "+ freq + ", term: " + term;
    }
}
