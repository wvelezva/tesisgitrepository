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
 * <p>Java class for LowVisionImpairmentType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="LowVisionImpairmentType">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:tva:mpeg21:2011}DIABaseType">
 *       &lt;sequence>
 *         &lt;element name="LossOfFineDetail" type="{urn:tva:mpeg21:2011}VisualImpairmentDegreeType" minOccurs="0"/>
 *         &lt;element name="LackOfContrast" type="{urn:tva:mpeg21:2011}VisualImpairmentDegreeType" minOccurs="0"/>
 *         &lt;element name="LightSensitivity" type="{urn:tva:mpeg21:2011}VisualImpairmentDegreeType" minOccurs="0"/>
 *         &lt;element name="NeedOfLight" type="{urn:tva:mpeg21:2011}VisualImpairmentDegreeType" minOccurs="0"/>
 *         &lt;element name="CenterVisionLoss" type="{urn:tva:mpeg21:2011}VisualImpairmentDegreeType" minOccurs="0"/>
 *         &lt;element name="PeripheralVisionLoss" type="{urn:tva:mpeg21:2011}VisualImpairmentDegreeType" minOccurs="0"/>
 *         &lt;element name="Hemianopia" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;attribute name="side" use="required">
 *                   &lt;simpleType>
 *                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}NMTOKEN">
 *                       &lt;enumeration value="left"/>
 *                       &lt;enumeration value="right"/>
 *                     &lt;/restriction>
 *                   &lt;/simpleType>
 *                 &lt;/attribute>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LowVisionImpairmentType", propOrder = {
    "lossOfFineDetail",
    "lackOfContrast",
    "lightSensitivity",
    "needOfLight",
    "centerVisionLoss",
    "peripheralVisionLoss",
    "hemianopia"
})
public class LowVisionImpairmentType
    extends DIABaseType
{

    @XmlElement(name = "LossOfFineDetail")
    protected VisualImpairmentDegreeType lossOfFineDetail;
    @XmlElement(name = "LackOfContrast")
    protected VisualImpairmentDegreeType lackOfContrast;
    @XmlElement(name = "LightSensitivity")
    protected VisualImpairmentDegreeType lightSensitivity;
    @XmlElement(name = "NeedOfLight")
    protected VisualImpairmentDegreeType needOfLight;
    @XmlElement(name = "CenterVisionLoss")
    protected VisualImpairmentDegreeType centerVisionLoss;
    @XmlElement(name = "PeripheralVisionLoss")
    protected VisualImpairmentDegreeType peripheralVisionLoss;
    @XmlElement(name = "Hemianopia")
    protected LowVisionImpairmentType.Hemianopia hemianopia;

    /**
     * Gets the value of the lossOfFineDetail property.
     * 
     * @return
     *     possible object is
     *     {@link VisualImpairmentDegreeType }
     *     
     */
    public VisualImpairmentDegreeType getLossOfFineDetail() {
        return lossOfFineDetail;
    }

    /**
     * Sets the value of the lossOfFineDetail property.
     * 
     * @param value
     *     allowed object is
     *     {@link VisualImpairmentDegreeType }
     *     
     */
    public void setLossOfFineDetail(VisualImpairmentDegreeType value) {
        this.lossOfFineDetail = value;
    }

    /**
     * Gets the value of the lackOfContrast property.
     * 
     * @return
     *     possible object is
     *     {@link VisualImpairmentDegreeType }
     *     
     */
    public VisualImpairmentDegreeType getLackOfContrast() {
        return lackOfContrast;
    }

    /**
     * Sets the value of the lackOfContrast property.
     * 
     * @param value
     *     allowed object is
     *     {@link VisualImpairmentDegreeType }
     *     
     */
    public void setLackOfContrast(VisualImpairmentDegreeType value) {
        this.lackOfContrast = value;
    }

    /**
     * Gets the value of the lightSensitivity property.
     * 
     * @return
     *     possible object is
     *     {@link VisualImpairmentDegreeType }
     *     
     */
    public VisualImpairmentDegreeType getLightSensitivity() {
        return lightSensitivity;
    }

    /**
     * Sets the value of the lightSensitivity property.
     * 
     * @param value
     *     allowed object is
     *     {@link VisualImpairmentDegreeType }
     *     
     */
    public void setLightSensitivity(VisualImpairmentDegreeType value) {
        this.lightSensitivity = value;
    }

    /**
     * Gets the value of the needOfLight property.
     * 
     * @return
     *     possible object is
     *     {@link VisualImpairmentDegreeType }
     *     
     */
    public VisualImpairmentDegreeType getNeedOfLight() {
        return needOfLight;
    }

    /**
     * Sets the value of the needOfLight property.
     * 
     * @param value
     *     allowed object is
     *     {@link VisualImpairmentDegreeType }
     *     
     */
    public void setNeedOfLight(VisualImpairmentDegreeType value) {
        this.needOfLight = value;
    }

    /**
     * Gets the value of the centerVisionLoss property.
     * 
     * @return
     *     possible object is
     *     {@link VisualImpairmentDegreeType }
     *     
     */
    public VisualImpairmentDegreeType getCenterVisionLoss() {
        return centerVisionLoss;
    }

    /**
     * Sets the value of the centerVisionLoss property.
     * 
     * @param value
     *     allowed object is
     *     {@link VisualImpairmentDegreeType }
     *     
     */
    public void setCenterVisionLoss(VisualImpairmentDegreeType value) {
        this.centerVisionLoss = value;
    }

    /**
     * Gets the value of the peripheralVisionLoss property.
     * 
     * @return
     *     possible object is
     *     {@link VisualImpairmentDegreeType }
     *     
     */
    public VisualImpairmentDegreeType getPeripheralVisionLoss() {
        return peripheralVisionLoss;
    }

    /**
     * Sets the value of the peripheralVisionLoss property.
     * 
     * @param value
     *     allowed object is
     *     {@link VisualImpairmentDegreeType }
     *     
     */
    public void setPeripheralVisionLoss(VisualImpairmentDegreeType value) {
        this.peripheralVisionLoss = value;
    }

    /**
     * Gets the value of the hemianopia property.
     * 
     * @return
     *     possible object is
     *     {@link LowVisionImpairmentType.Hemianopia }
     *     
     */
    public LowVisionImpairmentType.Hemianopia getHemianopia() {
        return hemianopia;
    }

    /**
     * Sets the value of the hemianopia property.
     * 
     * @param value
     *     allowed object is
     *     {@link LowVisionImpairmentType.Hemianopia }
     *     
     */
    public void setHemianopia(LowVisionImpairmentType.Hemianopia value) {
        this.hemianopia = value;
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
     *       &lt;attribute name="side" use="required">
     *         &lt;simpleType>
     *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}NMTOKEN">
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
    public static class Hemianopia {

        @XmlAttribute(name = "side", required = true)
        @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
        protected String side;

        /**
         * Gets the value of the side property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getSide() {
            return side;
        }

        /**
         * Sets the value of the side property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setSide(String value) {
            this.side = value;
        }

    }

}
