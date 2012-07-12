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
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * <p>Java class for VisualImpairmentType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="VisualImpairmentType">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:tva:mpeg21:2011}UserCharacteristicBaseType">
 *       &lt;sequence>
 *         &lt;element name="Blindness" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;attribute name="eyeSide" use="required">
 *                   &lt;simpleType>
 *                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}NMTOKEN">
 *                       &lt;enumeration value="both"/>
 *                       &lt;enumeration value="left"/>
 *                       &lt;enumeration value="right"/>
 *                     &lt;/restriction>
 *                   &lt;/simpleType>
 *                 &lt;/attribute>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="LowVisionSymptoms" type="{urn:tva:mpeg21:2011}LowVisionImpairmentType" minOccurs="0"/>
 *         &lt;element name="ColorVisionDeficiency" type="{urn:tva:mpeg21:2011}ColorVisionDeficiencyType" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="rightSight" type="{http://www.w3.org/2001/XMLSchema}float" />
 *       &lt;attribute name="leftSight" type="{http://www.w3.org/2001/XMLSchema}float" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "VisualImpairmentType", propOrder = {
    "blindness",
    "lowVisionSymptoms",
    "colorVisionDeficiency"
})
public class VisualImpairmentType
    extends UserCharacteristicBaseType
{

    @XmlElement(name = "Blindness")
    protected VisualImpairmentType.Blindness blindness;
    @XmlElement(name = "LowVisionSymptoms")
    protected LowVisionImpairmentType lowVisionSymptoms;
    @XmlElement(name = "ColorVisionDeficiency")
    protected ColorVisionDeficiencyType colorVisionDeficiency;
    @XmlAttribute(name = "rightSight")
    protected Float rightSight;
    @XmlAttribute(name = "leftSight")
    protected Float leftSight;

    /**
     * Gets the value of the blindness property.
     * 
     * @return
     *     possible object is
     *     {@link VisualImpairmentType.Blindness }
     *     
     */
    public VisualImpairmentType.Blindness getBlindness() {
        return blindness;
    }

    /**
     * Sets the value of the blindness property.
     * 
     * @param value
     *     allowed object is
     *     {@link VisualImpairmentType.Blindness }
     *     
     */
    public void setBlindness(VisualImpairmentType.Blindness value) {
        this.blindness = value;
    }

    /**
     * Gets the value of the lowVisionSymptoms property.
     * 
     * @return
     *     possible object is
     *     {@link LowVisionImpairmentType }
     *     
     */
    public LowVisionImpairmentType getLowVisionSymptoms() {
        return lowVisionSymptoms;
    }

    /**
     * Sets the value of the lowVisionSymptoms property.
     * 
     * @param value
     *     allowed object is
     *     {@link LowVisionImpairmentType }
     *     
     */
    public void setLowVisionSymptoms(LowVisionImpairmentType value) {
        this.lowVisionSymptoms = value;
    }

    /**
     * Gets the value of the colorVisionDeficiency property.
     * 
     * @return
     *     possible object is
     *     {@link ColorVisionDeficiencyType }
     *     
     */
    public ColorVisionDeficiencyType getColorVisionDeficiency() {
        return colorVisionDeficiency;
    }

    /**
     * Sets the value of the colorVisionDeficiency property.
     * 
     * @param value
     *     allowed object is
     *     {@link ColorVisionDeficiencyType }
     *     
     */
    public void setColorVisionDeficiency(ColorVisionDeficiencyType value) {
        this.colorVisionDeficiency = value;
    }

    /**
     * Gets the value of the rightSight property.
     * 
     * @return
     *     possible object is
     *     {@link Float }
     *     
     */
    public Float getRightSight() {
        return rightSight;
    }

    /**
     * Sets the value of the rightSight property.
     * 
     * @param value
     *     allowed object is
     *     {@link Float }
     *     
     */
    public void setRightSight(Float value) {
        this.rightSight = value;
    }

    /**
     * Gets the value of the leftSight property.
     * 
     * @return
     *     possible object is
     *     {@link Float }
     *     
     */
    public Float getLeftSight() {
        return leftSight;
    }

    /**
     * Sets the value of the leftSight property.
     * 
     * @param value
     *     allowed object is
     *     {@link Float }
     *     
     */
    public void setLeftSight(Float value) {
        this.leftSight = value;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;attribute name="eyeSide" use="required">
     *         &lt;simpleType>
     *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}NMTOKEN">
     *             &lt;enumeration value="both"/>
     *             &lt;enumeration value="left"/>
     *             &lt;enumeration value="right"/>
     *           &lt;/restriction>
     *         &lt;/simpleType>
     *       &lt;/attribute>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class Blindness {

        @XmlAttribute(name = "eyeSide", required = true)
        @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
        protected String eyeSide;

        /**
         * Gets the value of the eyeSide property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getEyeSide() {
            return eyeSide;
        }

        /**
         * Sets the value of the eyeSide property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setEyeSide(String value) {
            this.eyeSide = value;
        }

    }

}
