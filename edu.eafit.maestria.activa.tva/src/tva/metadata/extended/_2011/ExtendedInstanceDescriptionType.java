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
import tva.metadata._2011.InstanceDescriptionType;


/**
 * <p>Java class for ExtendedInstanceDescriptionType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ExtendedInstanceDescriptionType">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:tva:metadata:2011}InstanceDescriptionType">
 *       &lt;sequence>
 *         &lt;element name="ContentProperties" type="{urn:tva:metadata:extended:2011}ContentPropertiesType" minOccurs="0"/>
 *         &lt;element name="TargetingInformation" type="{urn:tva:metadata:extended:2011}TargetingInformationType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ExtendedInstanceDescriptionType", propOrder = {
    "contentProperties",
    "targetingInformation"
})
public class ExtendedInstanceDescriptionType
    extends InstanceDescriptionType
{

    @XmlElement(name = "ContentProperties")
    protected ContentPropertiesType contentProperties;
    @XmlElement(name = "TargetingInformation")
    protected TargetingInformationType targetingInformation;

    /**
     * Gets the value of the contentProperties property.
     * 
     * @return
     *     possible object is
     *     {@link ContentPropertiesType }
     *     
     */
    public ContentPropertiesType getContentProperties() {
        return contentProperties;
    }

    /**
     * Sets the value of the contentProperties property.
     * 
     * @param value
     *     allowed object is
     *     {@link ContentPropertiesType }
     *     
     */
    public void setContentProperties(ContentPropertiesType value) {
        this.contentProperties = value;
    }

    /**
     * Gets the value of the targetingInformation property.
     * 
     * @return
     *     possible object is
     *     {@link TargetingInformationType }
     *     
     */
    public TargetingInformationType getTargetingInformation() {
        return targetingInformation;
    }

    /**
     * Sets the value of the targetingInformation property.
     * 
     * @param value
     *     allowed object is
     *     {@link TargetingInformationType }
     *     
     */
    public void setTargetingInformation(TargetingInformationType value) {
        this.targetingInformation = value;
    }

}
