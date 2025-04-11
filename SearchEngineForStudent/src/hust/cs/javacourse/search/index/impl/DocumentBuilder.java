package hust.cs.javacourse.search.index.impl;

import hust.cs.javacourse.search.index.AbstractDocument;
import hust.cs.javacourse.search.index.AbstractDocumentBuilder;
import hust.cs.javacourse.search.parse.AbstractTermTupleStream;

import java.io.File;

public class DocumentBuilder extends AbstractDocumentBuilder {

    public DocumentBuilder() {
    }

    @Override
    public AbstractDocument build(int docId, String docPath, File file) {

    }

    @Override
    public AbstractDocument build(int docId, String docPath, AbstractTermTupleStream termTupleStream) {
        Document document = new Document(docId,docPath,termTupleStream);


    }
}
