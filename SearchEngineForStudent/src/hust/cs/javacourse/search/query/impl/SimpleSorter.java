package hust.cs.javacourse.search.query.impl;

import hust.cs.javacourse.search.index.AbstractPosting;
import hust.cs.javacourse.search.index.AbstractTerm;
import hust.cs.javacourse.search.query.AbstractHit;
import hust.cs.javacourse.search.query.Sort;

import java.util.Collections;
import java.util.List;
import java.util.Map;

public class SimpleSorter implements Sort {
    @Override
    public void sort(List<AbstractHit> hits) {
        Collections.sort(hits);
    }

    @Override
    public double score(AbstractHit hit) {
        Map<AbstractTerm, AbstractPosting> map = hit.getTermPostingMapping();
        double docScore = 0;
        for(AbstractPosting posting : map.values()){
            docScore -= posting.getFreq();
        }
        return docScore;
    }
}
