package com.cosmos.hack.controller.document;

import com.cosmos.hack.controller.AbstractController;
import com.cosmos.hack.model.document.Bol;
import com.cosmos.hack.repository.document.BolRepository;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/bol")
public class BolController extends AbstractController<Bol,String> {
    @Autowired
    public BolController(BolRepository repo) {
        super(repo);
    }

    @GetMapping("/search/{bolid}")
    public List<String> getBolLocation(@PathVariable String bolid) throws IOException {
        String url = "https://wheremy.com/bill-of-lading-tracking/show-tracking-info/mscgva/"+ bolid;
        Connection.Response resp = Jsoup.connect(url) //
                .timeout(30000) //
                .method(Connection.Method.GET) //
                .execute();

// * Find the form
        Document responseDocument = resp.parse();

// * Extract results (entity numbers in this sample code)
        List<String> resultSet = new ArrayList<>();
        for (Element entityNumber : responseDocument.select("item")) {
            resultSet.add(entityNumber.text());
        }
        Collections.reverse(resultSet);
        return resultSet;
    }
}
