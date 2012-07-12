//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.5 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2012.05.23 at 05:28:03 PM COT 
//


package tva.mpeg21._2011;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for GraphicsPresentationPreferencesType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GraphicsPresentationPreferencesType">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:tva:mpeg21:2011}UserCharacteristicBaseType">
 *       &lt;sequence>
 *         &lt;element name="GeometryEmphasis" type="{urn:tva:mpeg7:2008}zeroToOneType" minOccurs="0"/>
 *         &lt;element name="TextureEmphasis" type="{urn:tva:mpeg7:2008}zeroToOneType" minOccurs="0"/>
 *         &lt;element name="AnimationEmphasis" type="{urn:tva:mpeg7:2008}zeroToOneType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GraphicsPresentationPreferencesType", propOrder = {
    "geometryEmphasis",
    "textureEmphasis",
    "animationEmphasis"
})
public class GraphicsPresentationPreferencesType
    extends UserCharacteristicBaseType
{

    @XmlElement(name = "GeometryEmphasis")
    protected Float geometryEmphasis;
    @XmlElement(name = "TextureEmphasis")
    protected Float textureEmphasis;
    @XmlElement(name = "AnimationEmphasis")
    protected Float animationEmphasis;

    /**
     * Gets the value of the geometryEmphasis property.
     * 
     * @return
     *     possible object is
     *     {@link Float }
     *     
     */
    public Float getGeometryEmphasis() {
        return geometryEmphasis;
    }

    /**
     * Sets the value of the geometryEmphasis property.
     * 
     * @param value
     *     allowed object is
     *     {@link Float }
     *     
     */
    public void setGeometryEmphasis(Float value) {
        this.geometryEmphasis = value;
    }

    /**
     * Gets the value of the textureEmphasis property.
     * 
     * @return
     *     possible object is
     *     {@link Float }
     *     
     */
    public Float getTextureEmphasis() {
        return textureEmphasis;
    }

    /**
     * Sets the value of the textureEmphasis property.
     * 
     * @param value
     *     allowed object is
     *     {@link Float }
     *     
     */
    public void setTextureEmphasis(Float value) {
        this.textureEmphasis = value;
    }

    /**
     * Gets the value of the animationEmphasis property.
     * 
     * @return
     *     possible object is
     *     {@link Float }
     *     
     */
    public Float getAnimationEmphasis() {
        return animationEmphasis;
    }

    /**
     * Sets the value of the animationEmphasis property.
     * 
     * @param value
     *     allowed object is
     *     {@link Float }
     *     
     */
    public void setAnimationEmphasis(Float value) {
        this.animationEmphasis = value;
    }

}