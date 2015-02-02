
package com.tony.examples.couchbase.model;

import java.util.Date;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.tony.examples.couchbase.model package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _Entity_QNAME = new QName("", "_Entity");
    private final static QName _UserInfo_QNAME = new QName("", "user_info");
    private final static QName _LogGame_QNAME = new QName("", "log_game");
    private final static QName _LogGameMsg_QNAME = new QName("", "msg");
    private final static QName _LogGameRegdt_QNAME = new QName("", "regdt");
    private final static QName _LogGameMoney_QNAME = new QName("", "money");
    private final static QName _LogGameType_QNAME = new QName("", "type");
    private final static QName _LogGameUserid_QNAME = new QName("", "userid");
    private final static QName _LogGameFsno_QNAME = new QName("", "fsno");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.tony.examples.couchbase.model
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link LogGame }
     * 
     */
    public LogGame createLogGame() {
        return new LogGame();
    }

    /**
     * Create an instance of {@link UserInfo }
     * 
     */
    public UserInfo createUserInfo() {
        return new UserInfo();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Entity }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "_Entity")
    public JAXBElement<Entity> createEntity(Entity value) {
        return new JAXBElement<Entity>(_Entity_QNAME, Entity.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UserInfo }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "user_info", substitutionHeadNamespace = "", substitutionHeadName = "_Entity")
    public JAXBElement<UserInfo> createUserInfo(UserInfo value) {
        return new JAXBElement<UserInfo>(_UserInfo_QNAME, UserInfo.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LogGame }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "log_game", substitutionHeadNamespace = "", substitutionHeadName = "_Entity")
    public JAXBElement<LogGame> createLogGame(LogGame value) {
        return new JAXBElement<LogGame>(_LogGame_QNAME, LogGame.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "msg", scope = LogGame.class, defaultValue = "0")
    public JAXBElement<String> createLogGameMsg(String value) {
        return new JAXBElement<String>(_LogGameMsg_QNAME, String.class, LogGame.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Date }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "regdt", scope = LogGame.class)
    @XmlJavaTypeAdapter(Adapter1 .class)
    public JAXBElement<Date> createLogGameRegdt(Date value) {
        return new JAXBElement<Date>(_LogGameRegdt_QNAME, Date.class, LogGame.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "money", scope = LogGame.class, defaultValue = "0")
    public JAXBElement<Integer> createLogGameMoney(Integer value) {
        return new JAXBElement<Integer>(_LogGameMoney_QNAME, Integer.class, LogGame.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "type", scope = LogGame.class, defaultValue = "0")
    public JAXBElement<Integer> createLogGameType(Integer value) {
        return new JAXBElement<Integer>(_LogGameType_QNAME, Integer.class, LogGame.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "userid", scope = LogGame.class)
    public JAXBElement<String> createLogGameUserid(String value) {
        return new JAXBElement<String>(_LogGameUserid_QNAME, String.class, LogGame.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "fsno", scope = LogGame.class, defaultValue = "0")
    public JAXBElement<String> createLogGameFsno(String value) {
        return new JAXBElement<String>(_LogGameFsno_QNAME, String.class, LogGame.class, value);
    }

}
