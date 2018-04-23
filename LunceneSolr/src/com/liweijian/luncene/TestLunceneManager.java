package com.liweijian.luncene;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.FieldType;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.*;
import org.apache.lucene.search.*;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.Version;
import org.junit.Test;
import org.wltea.analyzer.lucene.IKAnalyzer;

import java.io.File;
import java.io.IOException;

public class TestLunceneManager {


    //删除全部索引
    @Test
    public void testDeleteAll() throws IOException {
        IndexWriter indexWriter = getIndexWriter();
        indexWriter.deleteAll();
        //关闭流才会提交?
        indexWriter.close();
    }

    //按条件删除
    @Test
    public void testDeleteIndexByQuery() throws IOException {
        IndexWriter indexWriter = getIndexWriter();
        indexWriter.deleteDocuments(new Term("fileName","apache"));
        indexWriter.close();
    }

    //更新索引
    @Test
    public void testUpdateIndex() throws IOException {
        IndexWriter indexWriter = getIndexWriter();

        Document document = new Document();
        document.add(new TextField("fileN","testFileN",Field.Store.YES));
        document.add(new TextField("fileC","testFileC",Field.Store.YES));

        indexWriter.updateDocument(new Term("fileName","lucene"),document,new IKAnalyzer());
        indexWriter.close();
    }

    //查询所有 MatchAllDocsQuery
    @Test
    public void testMatchAllDocsQuery() throws IOException {
        IndexSearcher indexSearcher = getIndexSearcher();

        Query query = new MatchAllDocsQuery();

        printResult(query,indexSearcher);
    }

    //TermQuery
    @Test
    public void testTermQuery() throws IOException {
        IndexSearcher indexSearcher = getIndexSearcher();

        Query query = new TermQuery(new Term("fileName","java"));
        printResult(query,indexSearcher);

    }


    //组合查询BooleanQuery
    @Test
    public void testBooleanQuery() throws IOException {
        IndexSearcher indexSearcher = getIndexSearcher();

        BooleanQuery query = new BooleanQuery();
        Query query1 = new TermQuery(new Term("fileName","serving"));
        Query query2 = new TermQuery(new Term("fileName","web"));

        query.add(query1,BooleanClause.Occur.MUST);
        query.add(query2,BooleanClause.Occur.MUST);
        printResult(query,indexSearcher);

    }


    //按范围查询NumericRangeQuery
    @Test
    public void testNumericRangeQuery() throws IOException {
        IndexSearcher indexSearcher = getIndexSearcher();

        Query query = NumericRangeQuery.newLongRange("fileSize",1L,1000L,true,true);
        printResult(query,indexSearcher);

    }


    public IndexWriter getIndexWriter() throws IOException {
        Directory directory = FSDirectory.open(new File("F:\\Code\\HeiMa\\LunceneSolr\\temp\\index"));
//        Analyzer analyzer = new StandardAnalyzer();
        Analyzer analyzer = new IKAnalyzer();
        IndexWriterConfig config = new IndexWriterConfig(Version.LATEST,analyzer);
        IndexWriter indexWriter = new IndexWriter(directory,config);
        return indexWriter;
    }

    public IndexSearcher getIndexSearcher() throws IOException {
        Directory directory = FSDirectory.open(new File("F:\\Code\\HeiMa\\LunceneSolr\\temp\\index"));
        IndexReader indexReader = DirectoryReader.open(directory);
        IndexSearcher indexSearcher = new IndexSearcher(indexReader);
        return indexSearcher;
    }

    public void printResult(Query query, IndexSearcher indexSearcher) throws IOException {

        TopDocs topDocs = indexSearcher.search(query, 20);
        ScoreDoc[] scoreDocs = topDocs.scoreDocs;
        for (ScoreDoc scoreDoc: scoreDocs) {
            int index = scoreDoc.doc;
            Document document = indexSearcher.doc(index);
            //文件名称
            String fileName = document.get("fileName");
            System.out.println(fileName);
            //文件大小
            String fileSize = document.get("fileSize");
            System.out.println(fileSize);
            String fileContent = document.get("fileContent");
            System.out.println(fileContent);
            String filePath = document.get("filePath");
            System.out.println(filePath);
            System.out.println("-------------------------");
        }
    }



}
