//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.5 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2012.03.27 at 06:52:02 AM COT 
//


package org.dvb.pcf.x_dvb_pcf;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlElementRefs;
import javax.xml.bind.annotation.XmlMixed;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence maxOccurs="unbounded" minOccurs="0">
 *         &lt;group ref="{http://www.dvb.org/pcf/x-dvb-pcf}inlineGroup"/>
 *       &lt;/sequence>
 *       &lt;attGroup ref="{http://www.dvb.org/pcf/x-dvb-pcf}font_properties"/>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "content"
})
@XmlRootElement(name = "span")
public class Span {

    @XmlElementRefs({
        @XmlElementRef(name = "br", namespace = "http://www.dvb.org/pcf/x-dvb-pcf", type = Br.class, required = false),
        @XmlElementRef(name = "strong", namespace = "http://www.dvb.org/pcf/x-dvb-pcf", type = Strong.class, required = false),
        @XmlElementRef(name = "a", namespace = "http://www.dvb.org/pcf/x-dvb-pcf", type = A.class, required = false),
        @XmlElementRef(name = "span", namespace = "http://www.dvb.org/pcf/x-dvb-pcf", type = Span.class, required = false),
        @XmlElementRef(name = "img", namespace = "http://www.dvb.org/pcf/x-dvb-pcf", type = Img.class, required = false),
        @XmlElementRef(name = "small", namespace = "http://www.dvb.org/pcf/x-dvb-pcf", type = Small.class, required = false),
        @XmlElementRef(name = "em", namespace = "http://www.dvb.org/pcf/x-dvb-pcf", type = Em.class, required = false),
        @XmlElementRef(name = "big", namespace = "http://www.dvb.org/pcf/x-dvb-pcf", type = Big.class, required = false)
    })
    @XmlMixed
    protected List<Object> content;
    @XmlAttribute(name = "font-family")
    protected String fontFamily;
    @XmlAttribute(name = "generic-family")
    protected String genericFamily;
    @XmlAttribute(name = "font-size")
    protected String fontSize;
    @XmlAttribute(name = "font-size-adjust")
    protected String fontSizeAdjust;
    @XmlAttribute(name = "font-stretch")
    protected String fontStretch;
    @XmlAttribute(name = "font-variant")
    protected String fontVariant;
    @XmlAttribute(name = "font-style")
    protected String fontStyle;
    @XmlAttribute(name = "font-weight")
    protected String fontWeight;
    @XmlAttribute(name = "textcolor")
    protected String textcolor;
    @XmlAttribute(name = "textcolor-focus")
    protected String textcolorFocus;
    @XmlAttribute(name = "textcolor-disabled")
    protected String textcolorDisabled;
    @XmlAttribute(name = "textcolor-active")
    protected String textcolorActive;
    @XmlAttribute(name = "textcolor-idle")
    protected String textcolorIdle;
    @XmlAttribute(name = "textcolor-shadow")
    protected String textcolorShadow;
    @XmlAttribute(name = "textcolor-highlight")
    protected String textcolorHighlight;
    @XmlAttribute(name = "textcolor-rendering-intent")
    protected String textcolorRenderingIntent;

    /**
     * Gets the value of the content property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the content property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getContent().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Br }
     * {@link Strong }
     * {@link String }
     * {@link A }
     * {@link Span }
     * {@link Img }
     * {@link Small }
     * {@link Em }
     * {@link Big }
     * 
     * 
     */
    public List<Object> getContent() {
        if (content == null) {
            content = new ArrayList<Object>();
        }
        return this.content;
    }

    /**
     * Gets the value of the fontFamily property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFontFamily() {
        return fontFamily;
    }

    /**
     * Sets the value of the fontFamily property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFontFamily(String value) {
        this.fontFamily = value;
    }

    /**
     * Gets the value of the genericFamily property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGenericFamily() {
        return genericFamily;
    }

    /**
     * Sets the value of the genericFamily property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGenericFamily(String value) {
        this.genericFamily = value;
    }

    /**
     * Gets the value of the fontSize property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFontSize() {
        return fontSize;
    }

    /**
     * Sets the value of the fontSize property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFontSize(String value) {
        this.fontSize = value;
    }

    /**
     * Gets the value of the fontSizeAdjust property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFontSizeAdjust() {
        return fontSizeAdjust;
    }

    /**
     * Sets the value of the fontSizeAdjust property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFontSizeAdjust(String value) {
        this.fontSizeAdjust = value;
    }

    /**
     * Gets the value of the fontStretch property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFontStretch() {
        if (fontStretch == null) {
            return "normal";
        } else {
            return fontStretch;
        }
    }

    /**
     * Sets the value of the fontStretch property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFontStretch(String value) {
        this.fontStretch = value;
    }

    /**
     * Gets the value of the fontVariant property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFontVariant() {
        if (fontVariant == null) {
            return "normal";
        } else {
            return fontVariant;
        }
    }

    /**
     * Sets the value of the fontVariant property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFontVariant(String value) {
        this.fontVariant = value;
    }

    /**
     * Gets the value of the fontStyle property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFontStyle() {
        if (fontStyle == null) {
            return "normal";
        } else {
            return fontStyle;
        }
    }

    /**
     * Sets the value of the fontStyle property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFontStyle(String value) {
        this.fontStyle = value;
    }

    /**
     * Gets the value of the fontWeight property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFontWeight() {
        if (fontWeight == null) {
            return "normal";
        } else {
            return fontWeight;
        }
    }

    /**
     * Sets the value of the fontWeight property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFontWeight(String value) {
        this.fontWeight = value;
    }

    /**
     * Gets the value of the textcolor property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTextcolor() {
        return textcolor;
    }

    /**
     * Sets the value of the textcolor property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTextcolor(String value) {
        this.textcolor = value;
    }

    /**
     * Gets the value of the textcolorFocus property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTextcolorFocus() {
        return textcolorFocus;
    }

    /**
     * Sets the value of the textcolorFocus property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTextcolorFocus(String value) {
        this.textcolorFocus = value;
    }

    /**
     * Gets the value of the textcolorDisabled property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTextcolorDisabled() {
        return textcolorDisabled;
    }

    /**
     * Sets the value of the textcolorDisabled property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTextcolorDisabled(String value) {
        this.textcolorDisabled = value;
    }

    /**
     * Gets the value of the textcolorActive property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTextcolorActive() {
        return textcolorActive;
    }

    /**
     * Sets the value of the textcolorActive property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTextcolorActive(String value) {
        this.textcolorActive = value;
    }

    /**
     * Gets the value of the textcolorIdle property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTextcolorIdle() {
        return textcolorIdle;
    }

    /**
     * Sets the value of the textcolorIdle property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTextcolorIdle(String value) {
        this.textcolorIdle = value;
    }

    /**
     * Gets the value of the textcolorShadow property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTextcolorShadow() {
        return textcolorShadow;
    }

    /**
     * Sets the value of the textcolorShadow property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTextcolorShadow(String value) {
        this.textcolorShadow = value;
    }

    /**
     * Gets the value of the textcolorHighlight property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTextcolorHighlight() {
        return textcolorHighlight;
    }

    /**
     * Sets the value of the textcolorHighlight property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTextcolorHighlight(String value) {
        this.textcolorHighlight = value;
    }

    /**
     * Gets the value of the textcolorRenderingIntent property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTextcolorRenderingIntent() {
        return textcolorRenderingIntent;
    }

    /**
     * Sets the value of the textcolorRenderingIntent property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTextcolorRenderingIntent(String value) {
        this.textcolorRenderingIntent = value;
    }

}
