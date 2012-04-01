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
 *         &lt;element ref="{http://www.dvb.org/pcf/pcf}DateTime" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{http://www.dvb.org/pcf/pcf}DateTimeArray" maxOccurs="unbounded" minOccurs="0"/>
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
    "dateTime",
    "dateTimeArray"
})
public class DateTimeArray
    extends PcfItemArrayType
{

    @XmlElement(name = "DateTime", nillable = true)
    protected List<DateTime> dateTime;
    @XmlElement(name = "DateTimeArray", nillable = true)
    protected List<DateTimeArray> dateTimeArray;

    /**
     * Gets the value of the dateTime property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the dateTime property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDateTime().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DateTime }
     * 
     * 
     */
    public List<DateTime> getDateTime() {
        if (dateTime == null) {
            dateTime = new ArrayList<DateTime>();
        }
        return this.dateTime;
    }

    /**
     * Gets the value of the dateTimeArray property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the dateTimeArray property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDateTimeArray().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DateTimeArray }
     * 
     * 
     */
    public List<DateTimeArray> getDateTimeArray() {
        if (dateTimeArray == null) {
            dateTimeArray = new ArrayList<DateTimeArray>();
        }
        return this.dateTimeArray;
    }

}
