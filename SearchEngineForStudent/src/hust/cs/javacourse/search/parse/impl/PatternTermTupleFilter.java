package hust.cs.javacourse.search.parse.impl;

import hust.cs.javacourse.search.index.AbstractTermTuple;
import hust.cs.javacourse.search.parse.AbstractTermTupleFilter;
import hust.cs.javacourse.search.parse.AbstractTermTupleStream;
import hust.cs.javacourse.search.util.Config;

import java.util.regex.Pattern;

public class PatternTermTupleFilter extends AbstractTermTupleFilter {
    private Pattern pattern = Pattern.compile(Config.TERM_FILTER_PATTERN);


    public PatternTermTupleFilter(AbstractTermTupleStream input)
    {
        super(input);
    }

    public PatternTermTupleFilter(AbstractTermTupleStream input,String regex){
        super(input);
        pattern = Pattern.compile(regex);
    }


    @Override
    public AbstractTermTuple next() {
        AbstractTermTuple termTuple = input.next();
        if(termTuple == null)
            return null;

        while (!termTuple.term.getContent().matches(Config.TERM_FILTER_PATTERN))
        {
            termTuple = input.next();
            if(termTuple == null)
                return null;

        }
        return termTuple;
    }


}
