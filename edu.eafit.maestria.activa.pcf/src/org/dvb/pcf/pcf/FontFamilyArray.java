//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.5 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2012.03.27 at 06:52:02 AM COT 
//


package org.dvb.pcf.pcf;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import org.dvb.pcf.pcf_types.PcfItemArrayType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.dvb.org/pcf/pcf-types}pcfItemArrayType">
 *       &lt;choice>
 *         &lt;element ref="{http://www.dvb.org/pcf/pcf}FontFamily" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{http://www.dvb.org/pcf/pcf}FontFamilyArray" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/choice>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "fontFamily",
    "fontFamilyArray"
})
public class FontFamilyArray
    extends PcfItemArrayType
{

    @XmlElement(name = "FontFamily")
    protected List<FontFamily> fontFamily;
    @XmlElement(name = "FontFamilyArray")
    protected List<FontFamilyArray> fontFamilyArray;

    /**
     * Gets the value of the fontFamily property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the fontFamily property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getFontFamily().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link FontFamily }
     * 
     * 
     */
    public List<FontFamily> getFontFamily() {
        if (fontFamily == null) {
            fontFamily = new ArrayList<FontFamily>();
        }
        return this.fontFamily;
    }

    /**
     * Gets the value of the fontFamilyArray property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the fontFamilyArray property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getFontFamilyArray().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link FontFamilyArray }
     * 
     * 
     */
    public List<FontFamilyArray> getFontFamilyArray() {
        if (fontFamilyArray == null) {
            fontFamilyArray = new ArrayList<FontFamilyArray>();
        }
        return this.fontFamilyArray;
    }

}
