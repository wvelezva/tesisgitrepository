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
import tva.metadata._2011.ServiceInformationType;


/**
 * <p>Java class for ExtendedServiceInformationType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ExtendedServiceInformationType">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:tva:metadata:2011}ServiceInformationType">
 *       &lt;sequence>
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
@XmlType(name = "ExtendedServiceInformationType", propOrder = {
    "targetingInformation"
})
public class ExtendedServiceInformationType
    extends ServiceInformationType
{

    @XmlElement(name = "TargetingInformation")
    protected TargetingInformationType targetingInformation;

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
