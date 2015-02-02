package com.tony.examples.couchbase;

import com.couchbase.client.java.Bucket;
import com.couchbase.client.java.Cluster;
import com.couchbase.client.java.CouchbaseCluster;
import com.couchbase.client.java.document.JsonDocument;
import com.couchbase.client.java.document.json.JsonArray;
import com.couchbase.client.java.document.json.JsonObject;
import com.couchbase.client.java.view.ViewQuery;
import com.couchbase.client.java.view.ViewResult;
import com.couchbase.client.java.view.ViewRow;

import java.util.List;

/**
 * com.couchbase.client 2.0.3 Example
 */
public class ClientTest {
    public static void main(String[] args) {
        Cluster cluster = CouchbaseCluster.create("10.24.101.128", "10.24.101.129", "10.24.101.130");

        Bucket bucket = cluster.openBucket("default");

        // ex 1
        JsonObject user = JsonObject.empty()
                .put("firstname", "Walter")
                .put("lastname", "White")
                .put("job", "chemistry teacher")
                .put("age", 50);

        JsonDocument doc = JsonDocument.create("walter", user);
        JsonDocument response = bucket.upsert(doc);

        JsonDocument walter = bucket.get("walter");
        System.out.println("Found: " + walter);
        System.out.println("Found: " + walter.content());

        // ex 2
        ViewResult result = bucket.query(
                ViewQuery
                        .from("entity", "byType")
                        .key(JsonArray.from("user_info", "TESTER"))
                        .descending()
                        .limit(10)
        );

        List<ViewRow> viewRows = result.allRows();

        JsonArray value = (JsonArray) viewRows.get(0).value();
        JsonDocument resultDoc = viewRows.get(0).document();

        System.out.println(value);
        System.out.println(resultDoc);

        cluster.disconnect();

    }
}