//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.09.17 at 04:44:06 PM EDT 
//


package org.xframium.driver.xsd;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Defines a single function
 * 
 * <p>Java class for xFunction complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="xFunction">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="description" type="{http://www.xframium.org/xFramiumDriver}xDescription" minOccurs="0"/>
 *         &lt;element name="parameter" type="{http://www.xframium.org/xFramiumDriver}xParameter" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="step" type="{http://www.xframium.org/xFramiumDriver}xStep" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *       &lt;attribute name="name" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="dataProvider" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="linkId" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="active" type="{http://www.w3.org/2001/XMLSchema}boolean" default="true" />
 *       &lt;attribute name="mode" default="function">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *             &lt;enumeration value="function"/>
 *             &lt;enumeration value="module"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *       &lt;attribute name="inputPage" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="outputPage" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="operations" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "xFunction", propOrder = {
    "description",
    "parameter",
    "step"
})
public class XFunction {

    protected XDescription description;
    protected List<XParameter> parameter;
    @XmlElement(required = true)
    protected List<XStep> step;
    @XmlAttribute(name = "name", required = true)
    protected String name;
    @XmlAttribute(name = "dataProvider")
    protected String dataProvider;
    @XmlAttribute(name = "linkId")
    protected String linkId;
    @XmlAttribute(name = "active")
    protected Boolean active;
    @XmlAttribute(name = "mode")
    protected String mode;
    @XmlAttribute(name = "inputPage")
    protected String inputPage;
    @XmlAttribute(name = "outputPage")
    protected String outputPage;
    @XmlAttribute(name = "operations")
    protected String operations;

    /**
     * Gets the value of the description property.
     * 
     * @return
     *     possible object is
     *     {@link XDescription }
     *     
     */
    public XDescription getDescription() {
        return description;
    }

    /**
     * Sets the value of the description property.
     * 
     * @param value
     *     allowed object is
     *     {@link XDescription }
     *     
     */
    public void setDescription(XDescription value) {
        this.description = value;
    }

    /**
     * Gets the value of the parameter property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the parameter property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getParameter().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link XParameter }
     * 
     * 
     */
    public List<XParameter> getParameter() {
        if (parameter == null) {
            parameter = new ArrayList<XParameter>();
        }
        return this.parameter;
    }

    /**
     * Gets the value of the step property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the step property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getStep().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link XStep }
     * 
     * 
     */
    public List<XStep> getStep() {
        if (step == null) {
            step = new ArrayList<XStep>();
        }
        return this.step;
    }

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the dataProvider property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDataProvider() {
        return dataProvider;
    }

    /**
     * Sets the value of the dataProvider property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDataProvider(String value) {
        this.dataProvider = value;
    }

    /**
     * Gets the value of the linkId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLinkId() {
        return linkId;
    }

    /**
     * Sets the value of the linkId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLinkId(String value) {
        this.linkId = value;
    }

    /**
     * Gets the value of the active property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public boolean isActive() {
        if (active == null) {
            return true;
        } else {
            return active;
        }
    }

    /**
     * Sets the value of the active property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setActive(Boolean value) {
        this.active = value;
    }

    /**
     * Gets the value of the mode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMode() {
        if (mode == null) {
            return "function";
        } else {
            return mode;
        }
    }

    /**
     * Sets the value of the mode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMode(String value) {
        this.mode = value;
    }

    /**
     * Gets the value of the inputPage property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInputPage() {
        return inputPage;
    }

    /**
     * Sets the value of the inputPage property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInputPage(String value) {
        this.inputPage = value;
    }

    /**
     * Gets the value of the outputPage property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOutputPage() {
        return outputPage;
    }

    /**
     * Sets the value of the outputPage property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOutputPage(String value) {
        this.outputPage = value;
    }

    /**
     * Gets the value of the operations property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOperations() {
        return operations;
    }

    /**
     * Sets the value of the operations property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOperations(String value) {
        this.operations = value;
    }

}
