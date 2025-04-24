package hust.cs.javacourse.search.parse.impl;

import hust.cs.javacourse.search.index.AbstractTerm;
import hust.cs.javacourse.search.index.AbstractTermTuple;
import hust.cs.javacourse.search.index.impl.Term;
import hust.cs.javacourse.search.index.impl.TermTuple;
import hust.cs.javacourse.search.parse.AbstractTermTupleScanner;
import hust.cs.javacourse.search.util.Config;
import hust.cs.javacourse.search.util.StringSplitter;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TermTupleScanner extends AbstractTermTupleScanner {
    private int postion = 0;
    private List<String> buf;
    private StringSplitter stringSplitter = new StringSplitter();

    public TermTupleScanner(){
        buf = new ArrayList<>();
        stringSplitter.setSplitRegex(Config.STRING_SPLITTER_REGEX);
    }

    @Override
    public AbstractTermTuple next() {
        try{
            if(buf.isEmpty()){
                String s;
                StringBuilder sb = new StringBuilder();
                while((s = input.readLine()) != null){
                    sb.append(s).append("\n");
                }
                s = sb.toString().trim();
                s = s.toLowerCase();
                buf = stringSplitter.splitByRegex(s);
            }
            if(buf.size() == 0)
                return null;
            AbstractTerm term = new Term(buf.get(0));
            buf.remove(0);
            return new TermTuple(term,postion++);
        } catch (IOException e){
            e.printStackTrace();
        }
        return null;
    }

    public void close() {
        super.close();
    }

    /**
     * 构造函数
     *
     * @param input ：指定输入流对象，应该关联到一个文本文件
     */
    public TermTupleScanner(BufferedReader input) {
        super(input);
        buf = new ArrayList<>();
        stringSplitter.setSplitRegex(Config.STRING_SPLITTER_REGEX);
    }
}
