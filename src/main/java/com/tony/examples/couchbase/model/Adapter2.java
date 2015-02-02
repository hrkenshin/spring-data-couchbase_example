
package com.tony.examples.couchbase.model;

import java.util.Date;
import javax.xml.bind.annotation.adapters.XmlAdapter;

public class Adapter2
    extends XmlAdapter<String, Date>
{


    public Date unmarshal(String value) {
        return (org.apache.cxf.xjc.runtime.DataTypeAdapter.parseDateTime(value));
    }

    public String marshal(Date value) {
        return (org.apache.cxf.xjc.runtime.DataTypeAdapter.printDateTime(value));
    }

}
