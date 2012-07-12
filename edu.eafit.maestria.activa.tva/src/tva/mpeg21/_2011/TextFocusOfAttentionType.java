//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.5 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2012.05.23 at 05:28:03 PM COT 
//


package tva.mpeg21._2011;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import tva.mpeg7._2008.TextualType;


/**
 * <p>Java class for TextFocusOfAttentionType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TextFocusOfAttentionType">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:tva:mpeg21:2011}DIABaseType">
 *       &lt;sequence>
 *         &lt;element name="Keyword" maxOccurs="unbounded" minOccurs="0">
 *           &lt;complexType>
 *             &lt;simpleContent>
 *               &lt;extension base="&lt;urn:tva:mpeg7:2008>TextualType">
 *                 &lt;attribute name="preferenceValue" type="{urn:tva:mpeg7:2008}preferenceValueType" default="10" />
 *               &lt;/extension>
 *             &lt;/simpleContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="Font" type="{urn:tva:mpeg21:2011}FontType" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="textPresentationSpeed" type="{urn:tva:mpeg7:2008}nonNegativeReal" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TextFocusOfAttentionType", propOrder = {
    "keyword",
    "font"
})
public class TextFocusOfAttentionType
    extends DIABaseType
{

    @XmlElement(name = "Keyword")
    protected List<TextFocusOfAttentionType.Keyword> keyword;
    @XmlElement(name = "Font")
    protected FontType font;
    @XmlAttribute(name = "textPresentationSpeed")
    protected Double textPresentationSpeed;

    /**
     * Gets the value of the keyword property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the keyword property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getKeyword().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TextFocusOfAttentionType.Keyword }
     * 
     * 
     */
    public List<TextFocusOfAttentionType.Keyword> getKeyword() {
        if (keyword == null) {
            keyword = new ArrayList<TextFocusOfAttentionType.Keyword>();
        }
        return this.keyword;
    }

    /**
     * Gets the value of the font property.
     * 
     * @return
     *     possible object is
     *     {@link FontType }
     *     
     */
    public FontType getFont() {
        return font;
    }

    /**
     * Sets the value of the font property.
     * 
     * @param value
     *     allowed object is
     *     {@link FontType }
     *     
     */
    public void setFont(FontType value) {
        this.font = value;
    }

    /**
     * Gets the value of the textPresentationSpeed property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getTextPresentationSpeed() {
        return textPresentationSpeed;
    }

    /**
     * Sets the value of the textPresentationSpeed property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setTextPresentationSpeed(Double value) {
        this.textPresentationSpeed = value;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;simpleContent>
     *     &lt;extension base="&lt;urn:tva:mpeg7:2008>TextualType">
     *       &lt;attribute name="preferenceValue" type="{urn:tva:mpeg7:2008}preferenceValueType" default="10" />
     *     &lt;/extension>
     *   &lt;/simpleContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class Keyword
        extends TextualType
    {

        @XmlAttribute(name = "preferenceValue")
        protected Integer preferenceValue;

        /**
         * Gets the value of the preferenceValue property.
         * 
         * @return
         *     possible object is
         *     {@link Integer }
         *     
         */
        public int getPreferenceValue() {
            if (preferenceValue == null) {
                return  10;
            } else {
                return preferenceValue;
            }
        }

        /**
         * Sets the value of the preferenceValue property.
         * 
         * @param value
         *     allowed object is
         *     {@link Integer }
         *     
         */
        public void setPreferenceValue(Integer value) {
            this.preferenceValue = value;
        }

    }

}