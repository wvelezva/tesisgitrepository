//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.5 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2012.05.23 at 05:28:03 PM COT 
//


package tva.rmpi._2011;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ReceivingDomainRightsType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ReceivingDomainRightsType">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:tva:rmpi:2011}BasicSetOfRightsType">
 *       &lt;sequence>
 *         &lt;element name="SinglePointOfControl" type="{urn:tva:rmpi:2011}SinglePointOfControlType" minOccurs="0"/>
 *         &lt;element name="PhysicalProximityFlag" type="{urn:tva:rmpi:2011}ControlType" minOccurs="0"/>
 *         &lt;element name="SimultaneousRendering" type="{urn:tva:rmpi:2011}SimultaneousRenderingType" minOccurs="0"/>
 *         &lt;element name="DomainId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ReceivingDomainRightsType", propOrder = {
    "singlePointOfControl",
    "physicalProximityFlag",
    "simultaneousRendering",
    "domainId"
})
public class ReceivingDomainRightsType
    extends BasicSetOfRightsType
{

    @XmlElement(name = "SinglePointOfControl")
    protected SinglePointOfControlType singlePointOfControl;
    @XmlElement(name = "PhysicalProximityFlag")
    protected ControlType physicalProximityFlag;
    @XmlElement(name = "SimultaneousRendering")
    protected SimultaneousRenderingType simultaneousRendering;
    @XmlElement(name = "DomainId")
    protected String domainId;

    /**
     * Gets the value of the singlePointOfControl property.
     * 
     * @return
     *     possible object is
     *     {@link SinglePointOfControlType }
     *     
     */
    public SinglePointOfControlType getSinglePointOfControl() {
        return singlePointOfControl;
    }

    /**
     * Sets the value of the singlePointOfControl property.
     * 
     * @param value
     *     allowed object is
     *     {@link SinglePointOfControlType }
     *     
     */
    public void setSinglePointOfControl(SinglePointOfControlType value) {
        this.singlePointOfControl = value;
    }

    /**
     * Gets the value of the physicalProximityFlag property.
     * 
     * @return
     *     possible object is
     *     {@link ControlType }
     *     
     */
    public ControlType getPhysicalProximityFlag() {
        return physicalProximityFlag;
    }

    /**
     * Sets the value of the physicalProximityFlag property.
     * 
     * @param value
     *     allowed object is
     *     {@link ControlType }
     *     
     */
    public void setPhysicalProximityFlag(ControlType value) {
        this.physicalProximityFlag = value;
    }

    /**
     * Gets the value of the simultaneousRendering property.
     * 
     * @return
     *     possible object is
     *     {@link SimultaneousRenderingType }
     *     
     */
    public SimultaneousRenderingType getSimultaneousRendering() {
        return simultaneousRendering;
    }

    /**
     * Sets the value of the simultaneousRendering property.
     * 
     * @param value
     *     allowed object is
     *     {@link SimultaneousRenderingType }
     *     
     */
    public void setSimultaneousRendering(SimultaneousRenderingType value) {
        this.simultaneousRendering = value;
    }

    /**
     * Gets the value of the domainId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDomainId() {
        return domainId;
    }

    /**
     * Sets the value of the domainId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDomainId(String value) {
        this.domainId = value;
    }

}