//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.10.18 at 09:24:44 PM EDT 
//


package org.xframium.terminal.driver.screen.model;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the org.xframium.terminal.driver.screen.model package. 
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

    private final static QName _ElementDefinition_QNAME = new QName("http://www.xframium.org/terminal-screen-model", "elementDefinition");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.xframium.terminal.driver.screen.model
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link RegistryRoot }
     * 
     */
    public RegistryRoot createRegistryRoot() {
        return new RegistryRoot();
    }

    /**
     * Create an instance of {@link Field }
     * 
     */
    public Field createField() {
        return new Field();
    }

    /**
     * Create an instance of {@link Action }
     * 
     */
    public Action createAction() {
        return new Action();
    }

    /**
     * Create an instance of {@link Screen }
     * 
     */
    public Screen createScreen() {
        return new Screen();
    }

    /**
     * Create an instance of {@link Application }
     * 
     */
    public Application createApplication() {
        return new Application();
    }

    /**
     * Create an instance of {@link Link }
     * 
     */
    public Link createLink() {
        return new Link();
    }

    /**
     * Create an instance of {@link Location }
     * 
     */
    public Location createLocation() {
        return new Location();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RegistryRoot }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.xframium.org/terminal-screen-model", name = "elementDefinition")
    public JAXBElement<RegistryRoot> createElementDefinition(RegistryRoot value) {
        return new JAXBElement<RegistryRoot>(_ElementDefinition_QNAME, RegistryRoot.class, null, value);
    }

}
