package hust.cs.javacourse.search.index.impl;

import hust.cs.javacourse.search.index.AbstractTerm;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Term extends AbstractTerm {
    public Term(){}
    public Term(String content){this.content = content;}

    //Compareable接口实现
    @Override
    public int compareTo(AbstractTerm o) {
        if(o == null) return 1;

        return content.compareTo(o.getContent());
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) return true;
        if(obj == null || getClass()!=obj.getClass()) return false;

        Term term = (Term) obj;
        return content == term.content;
    }

    @Override
    public String getContent() {
        return this.content;
    }

    @Override
    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {//还要返回其他信息？
        return this.content;
    }

    @Override
    public void writeObject(ObjectOutputStream out) {
        try{
            out.writeObject(content);
        } catch (IOException e1){}
    }

    @Override
    public void readObject(ObjectInputStream in) {
        try{
            content = (String) in.readObject();
        } catch (IOException e1) {
        } catch (ClassNotFoundException e2){}
        }

}
