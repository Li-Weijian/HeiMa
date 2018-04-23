package com.liweijian.luncene;

import org.apache.commons.io.FileUtils;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.*;
import org.apache.lucene.index.*;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TermQuery;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.Version;
import org.junit.Test;
import org.wltea.analyzer.lucene.IKAnalyzer;

import java.io.File;
import java.io.IOException;

public class TestLuncene {

    @Test
    public void testCreateIndex() throws IOException {
//      第一步：创建一个java工程，并导入jar包。
//      第二步：创建一个indexwriter对象。
//      1）指定索引库的存放位置Directory对象
        Directory directory = FSDirectory.open(new File("F:\\Code\\HeiMa\\LunceneSolr\\temp\\index"));
//      2）指定一个分析器，对文档内容进行分析。
//        Analyzer analyzer = new StandardAnalyzer();
        Analyzer analyzer = new IKAnalyzer();
        IndexWriterConfig config = new IndexWriterConfig(Version.LATEST,analyzer);
        IndexWriter indexWriter = new IndexWriter(directory,config);

        File file = new File("F:\\Code\\HeiMa\\LunceneSolr\\searchsource");
        File[] files = file.listFiles();
        for(File f: files) {
//          第二步：创建document对象。
            Document document = new Document();
//          第三步：创建field对象
            //文件名称域
            String fileName = f.getName();
            Field file_name = new TextField("fileName",fileName,Field.Store.YES);
            //文件大小域
            long fileSize = FileUtils.sizeOf(f);
            Field file_size = new LongField("fileSize",fileSize,Field.Store.YES);
            //文件路径域
            String filePath = f.getPath();
            Field file_path = new StringField("filePath",filePath,Field.Store.YES);
            //文件内容域
            String fileContent = FileUtils.readFileToString(f);
            Field file_content = new TextField("fileContent",fileContent,Field.Store.YES);

//          将field添加到document对象中。
            document.add(file_name);
            document.add(file_size);
            document.add(file_path);
            document.add(file_content);

//          第四步：使用indexwriter对象将document对象写入索引库，此过程进行索引创建。并将索引和document对象写入索引库。
            indexWriter.addDocument(document);
        }

//      第五步：关闭IndexWriter对象。
        indexWriter.close();
    }

    @Test
    public void testSerachIndex() throws IOException {
//      第一步：创建一个Directory对象，也就是索引库存放的位置。
        Directory directory = FSDirectory.open(new File("F:\\Code\\HeiMa\\LunceneSolr\\temp\\index"));
//      第二步：创建一个indexReader对象，需要指定Directory对象。
        IndexReader indexReader = DirectoryReader.open(directory);
//      第三步：创建一个indexsearcher对象，需要指定IndexReader对象
        IndexSearcher indexSearcher = new IndexSearcher(indexReader);
//      第四步：创建一个TermQuery对象，指定查询的域和查询的关键词。
        TermQuery query = new TermQuery(new Term("fileName","apache"));
//      第五步：执行查询。
        TopDocs topDocs = indexSearcher.search(query, 2);
        ScoreDoc[] docs = topDocs.scoreDocs;
//      第六步：返回查询结果。遍历查询结果并输出。
        for (ScoreDoc doc: docs) {
            int index = doc.doc;
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

//      第七步：关闭IndexReader对象
        indexReader.close();
    }


}
