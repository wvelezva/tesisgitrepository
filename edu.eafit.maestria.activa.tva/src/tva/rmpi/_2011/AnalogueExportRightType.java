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
 * <p>Java class for AnalogueExportRightType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AnalogueExportRightType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;choice>
 *           &lt;element name="AnalogueExportRightFlagNotGranted" type="{urn:tva:rmpi:2011}NotGrantedType"/>
 *           &lt;sequence>
 *             &lt;element name="AnalogueExportRightFlagGranted" type="{urn:tva:rmpi:2011}GrantedType"/>
 *             &lt;element name="AnalogueExportSignalling" type="{urn:tva:rmpi:2011}AnalogueExportSignallingType" minOccurs="0"/>
 *             &lt;element name="AnalogueExportSDControl" type="{urn:tva:rmpi:2011}ControlType" minOccurs="0"/>
 *           &lt;/sequence>
 *         &lt;/choice>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AnalogueExportRightType", propOrder = {
    "analogueExportRightFlagNotGranted",
    "analogueExportRightFlagGranted",
    "analogueExportSignalling",
    "analogueExportSDControl"
})
public class AnalogueExportRightType {

    @XmlElement(name = "AnalogueExportRightFlagNotGranted")
    protected NotGrantedType analogueExportRightFlagNotGranted;
    @XmlElement(name = "AnalogueExportRightFlagGranted")
    protected GrantedType analogueExportRightFlagGranted;
    @XmlElement(name = "AnalogueExportSignalling")
    protected AnalogueExportSignallingType analogueExportSignalling;
    @XmlElement(name = "AnalogueExportSDControl")
    protected ControlType analogueExportSDControl;

    /**
     * Gets the value of the analogueExportRightFlagNotGranted property.
     * 
     * @return
     *     possible object is
     *     {@link NotGrantedType }
     *     
     */
    public NotGrantedType getAnalogueExportRightFlagNotGranted() {
        return analogueExportRightFlagNotGranted;
    }

    /**
     * Sets the value of the analogueExportRightFlagNotGranted property.
     * 
     * @param value
     *     allowed object is
     *     {@link NotGrantedType }
     *     
     */
    public void setAnalogueExportRightFlagNotGranted(NotGrantedType value) {
        this.analogueExportRightFlagNotGranted = value;
    }

    /**
     * Gets the value of the analogueExportRightFlagGranted property.
     * 
     * @return
     *     possible object is
     *     {@link GrantedType }
     *     
     */
    public GrantedType getAnalogueExportRightFlagGranted() {
        return analogueExportRightFlagGranted;
    }

    /**
     * Sets the value of the analogueExportRightFlagGranted property.
     * 
     * @param value
     *     allowed object is
     *     {@link GrantedType }
     *     
     */
    public void setAnalogueExportRightFlagGranted(GrantedType value) {
        this.analogueExportRightFlagGranted = value;
    }

    /**
     * Gets the value of the analogueExportSignalling property.
     * 
     * @return
     *     possible object is
     *     {@link AnalogueExportSignallingType }
     *     
     */
    public AnalogueExportSignallingType getAnalogueExportSignalling() {
        return analogueExportSignalling;
    }

    /**
     * Sets the value of the analogueExportSignalling property.
     * 
     * @param value
     *     allowed object is
     *     {@link AnalogueExportSignallingType }
     *     
     */
    public void setAnalogueExportSignalling(AnalogueExportSignallingType value) {
        this.analogueExportSignalling = value;
    }

    /**
     * Gets the value of the analogueExportSDControl property.
     * 
     * @return
     *     possible object is
     *     {@link ControlType }
     *     
     */
    public ControlType getAnalogueExportSDControl() {
        return analogueExportSDControl;
    }

    /**
     * Sets the value of the analogueExportSDControl property.
     * 
     * @param value
     *     allowed object is
     *     {@link ControlType }
     *     
     */
    public void setAnalogueExportSDControl(ControlType value) {
        this.analogueExportSDControl = value;
    }

}
