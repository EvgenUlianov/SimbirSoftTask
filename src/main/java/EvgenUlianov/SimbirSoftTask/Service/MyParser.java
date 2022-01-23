package EvgenUlianov.SimbirSoftTask.Service;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class MyParser {

    @Autowired
    private MyStringDelimiter myDelimiter;

    public List<String> parse(String url) throws IOException {
        final List<String> result = new ArrayList<>(10000);
        Document doc = Jsoup.connect(url)
                .get();
        String nextString = doc.text().toLowerCase().trim();
        if (!nextString.isEmpty())
            result.addAll(myDelimiter.split(nextString));

        return result;
    }

}
