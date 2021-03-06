//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.5 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2012.05.23 at 05:28:03 PM COT 
//


package tva.metadata.extended._2011;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ApplicationContextAttributesType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ApplicationContextAttributesType">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:tva:metadata:extended:2011}ContextAttributesType">
 *       &lt;sequence>
 *         &lt;element name="Freeware" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="Uninstall" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ApplicationContextAttributesType", propOrder = {
    "freeware",
    "uninstall"
})
public class ApplicationContextAttributesType
    extends ContextAttributesType
{

    @XmlElement(name = "Freeware", defaultValue = "true")
    protected Boolean freeware;
    @XmlElement(name = "Uninstall", defaultValue = "false")
    protected Boolean uninstall;

    /**
     * Gets the value of the freeware property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isFreeware() {
        return freeware;
    }

    /**
     * Sets the value of the freeware property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setFreeware(Boolean value) {
        this.freeware = value;
    }

    /**
     * Gets the value of the uninstall property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isUninstall() {
        return uninstall;
    }

    /**
     * Sets the value of the uninstall property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setUninstall(Boolean value) {
        this.uninstall = value;
    }

}
