package com.aifred.idp;

import org.apache.tika.Tika;
import org.apache.tika.config.TikaConfig;
import org.apache.tika.detect.Detector;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.mime.MediaType;
import org.apache.tika.mime.MimeTypes;
import org.apache.tika.parser.AutoDetectParser;
import org.apache.tika.sax.BodyContentHandler;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

public class ApacheTikaExecutor {

    public void example01() {
        System.out.println("### exmaple01 start ###");

        AutoDetectParser parser = new AutoDetectParser();
        BodyContentHandler handler = new BodyContentHandler();
        Metadata metadata = new Metadata();

        String path = "";
        path = "/Users/passion1014/project/aifred/demoCore/doc/samsung_tooth_terms.pdf";
        // path = "/Users/passion1014/Downloads/Sin-Grace.pdf";
        // path = "/Users/passion1014/Documents/private/Lee Seong Uk_eng_20180203.doc";

        try (InputStream stream = new FileInputStream(new File(path))) {
            parser.parse(stream, handler, metadata);
            System.out.println("### 011 = " + handler.toString());
            System.out.println("### 012 = " + metadata.toString());

        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("### exmaple01 end ###");
    }

    public void example02() throws Exception {
        Tika tika = new Tika();
        String text = tika.parseToString(new File("/Users/passion1014/project/aifred/demoCore/doc/samsung_tooth_terms.pdf"));

        System.out.println("### 02 = " + text);
    }

    public void example03() throws Exception {

    }

    public static void main(String[] args) throws Exception {
        ApacheTikaExecutor executor = new ApacheTikaExecutor();
        executor.example01();


    }
}
