package hust.cs.javacourse.search.parse.impl;

import hust.cs.javacourse.search.index.AbstractTermTuple;
import hust.cs.javacourse.search.parse.AbstractTermTupleFilter;
import hust.cs.javacourse.search.parse.AbstractTermTupleStream;
import hust.cs.javacourse.search.util.StopWords;

import java.util.Arrays;
import java.util.Arrays;
import java.util.List;

public class StopWordTermTupleFilter extends AbstractTermTupleFilter {
    private List<String> stopWords = Arrays.asList(StopWords.STOP_WORDS);

    public StopWordTermTupleFilter(AbstractTermTupleStream input){
        super(input);
    }

    public void setStopWords(String[] stopWords){
        this.stopWords = Arrays.asList(stopWords);
    }

    public AbstractTermTuple next()
    {
        AbstractTermTuple termTuple = input.next();
        if(termTuple == null)
            return null;
        while(stopWords.contains(termTuple.term.getContent()))
        {
            termTuple = input.next();
            if(termTuple == null)
                return null;
        }
        return termTuple;
    }
}
