//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.5 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2012.05.23 at 05:28:03 PM COT 
//


package tva.mpeg21._2011;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CodecParameterFillRateType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CodecParameterFillRateType">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:tva:mpeg21:2011}CodecParameterBaseType">
 *       &lt;sequence>
 *         &lt;element name="FillRate" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CodecParameterFillRateType", propOrder = {
    "fillRate"
})
public class CodecParameterFillRateType
    extends CodecParameterBaseType
{

    @XmlElement(name = "FillRate")
    protected BigInteger fillRate;

    /**
     * Gets the value of the fillRate property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getFillRate() {
        return fillRate;
    }

    /**
     * Sets the value of the fillRate property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setFillRate(BigInteger value) {
        this.fillRate = value;
    }

}
