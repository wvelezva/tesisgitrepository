//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.5 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2012.05.23 at 05:28:03 PM COT 
//


package tva.mpeg21._2011;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ThreeDBenchmarkType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ThreeDBenchmarkType">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:tva:mpeg21:2011}DeviceBenchmarkBaseType">
 *       &lt;attribute name="name" use="required" type="{urn:tva:mpeg7:2008}termReferenceType" />
 *       &lt;attribute name="meanValue" use="required" type="{http://www.w3.org/2001/XMLSchema}float" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ThreeDBenchmarkType")
public class ThreeDBenchmarkType
    extends DeviceBenchmarkBaseType
{

    @XmlAttribute(name = "name", required = true)
    protected String name;
    @XmlAttribute(name = "meanValue", required = true)
    protected float meanValue;

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
     * Gets the value of the meanValue property.
     * 
     */
    public float getMeanValue() {
        return meanValue;
    }

    /**
     * Sets the value of the meanValue property.
     * 
     */
    public void setMeanValue(float value) {
        this.meanValue = value;
    }

}
