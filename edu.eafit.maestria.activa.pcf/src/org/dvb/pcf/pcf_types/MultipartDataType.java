//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.5 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2012.03.27 at 06:52:02 AM COT 
//


package org.dvb.pcf.pcf_types;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlElementRefs;
import javax.xml.bind.annotation.XmlType;


/**
 * Data encodes multiple content items
 * 
 * <p>Java class for multipartDataType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="multipartDataType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence maxOccurs="unbounded" minOccurs="0">
 *         &lt;group ref="{http://www.dvb.org/pcf/pcf-types}octetDataContainer"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "multipartDataType", propOrder = {
    "metaPropertyAndPlainTextDataOrBase64Data"
})
public class MultipartDataType {

    @XmlElementRefs({
        @XmlElementRef(name = "MultipartData", namespace = "http://www.dvb.org/pcf/pcf-types", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "QuotedPrintableData", namespace = "http://www.dvb.org/pcf/pcf-types", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "HexBinaryData", namespace = "http://www.dvb.org/pcf/pcf-types", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "ExternalBody", namespace = "http://www.dvb.org/pcf/pcf-types", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "PlainTextData", namespace = "http://www.dvb.org/pcf/pcf-types", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "MetaProperty", namespace = "http://www.dvb.org/pcf/pcf-types", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "Base64Data", namespace = "http://www.dvb.org/pcf/pcf-types", type = Base64Data.class, required = false)
    })
    protected List<Object> metaPropertyAndPlainTextDataOrBase64Data;

    /**
     * Gets the value of the metaPropertyAndPlainTextDataOrBase64Data property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the metaPropertyAndPlainTextDataOrBase64Data property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getMetaPropertyAndPlainTextDataOrBase64Data().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link JAXBElement }{@code <}{@link ExternalBodyType }{@code >}
     * {@link JAXBElement }{@code <}{@link MultipartDataType }{@code >}
     * {@link JAXBElement }{@code <}{@link Object }{@code >}
     * {@link JAXBElement }{@code <}{@link Object }{@code >}
     * {@link JAXBElement }{@code <}{@link QuotedPrintableDataType }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link MetaPropertyType }{@code >}
     * {@link JAXBElement }{@code <}{@link Object }{@code >}
     * {@link JAXBElement }{@code <}{@link Object }{@code >}
     * {@link JAXBElement }{@code <}{@link Object }{@code >}
     * {@link JAXBElement }{@code <}{@link Object }{@code >}
     * {@link Base64Data }
     * {@link JAXBElement }{@code <}{@link HexBinaryDataType }{@code >}
     * 
     * 
     */
    public List<Object> getMetaPropertyAndPlainTextDataOrBase64Data() {
        if (metaPropertyAndPlainTextDataOrBase64Data == null) {
            metaPropertyAndPlainTextDataOrBase64Data = new ArrayList<Object>();
        }
        return this.metaPropertyAndPlainTextDataOrBase64Data;
    }

}
