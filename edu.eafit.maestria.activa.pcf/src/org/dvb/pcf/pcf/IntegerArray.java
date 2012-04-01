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
 *         &lt;element ref="{http://www.dvb.org/pcf/pcf}Integer" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{http://www.dvb.org/pcf/pcf}IntegerArray" maxOccurs="unbounded" minOccurs="0"/>
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
    "integer",
    "integerArray"
})
public class IntegerArray
    extends PcfItemArrayType
{

    @XmlElement(name = "Integer", nillable = true)
    protected List<Integer> integer;
    @XmlElement(name = "IntegerArray", nillable = true)
    protected List<IntegerArray> integerArray;

    /**
     * Gets the value of the integer property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the integer property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getInteger().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Integer }
     * 
     * 
     */
    public List<Integer> getInteger() {
        if (integer == null) {
            integer = new ArrayList<Integer>();
        }
        return this.integer;
    }

    /**
     * Gets the value of the integerArray property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the integerArray property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getIntegerArray().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link IntegerArray }
     * 
     * 
     */
    public List<IntegerArray> getIntegerArray() {
        if (integerArray == null) {
            integerArray = new ArrayList<IntegerArray>();
        }
        return this.integerArray;
    }

}
