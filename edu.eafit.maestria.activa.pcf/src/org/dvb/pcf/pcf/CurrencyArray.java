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
 *         &lt;element ref="{http://www.dvb.org/pcf/pcf}Currency" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{http://www.dvb.org/pcf/pcf}CurrencyArray" maxOccurs="unbounded" minOccurs="0"/>
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
    "currency",
    "currencyArray"
})
public class CurrencyArray
    extends PcfItemArrayType
{

    @XmlElement(name = "Currency", nillable = true)
    protected List<Currency> currency;
    @XmlElement(name = "CurrencyArray", nillable = true)
    protected List<CurrencyArray> currencyArray;

    /**
     * Gets the value of the currency property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the currency property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCurrency().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Currency }
     * 
     * 
     */
    public List<Currency> getCurrency() {
        if (currency == null) {
            currency = new ArrayList<Currency>();
        }
        return this.currency;
    }

    /**
     * Gets the value of the currencyArray property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the currencyArray property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCurrencyArray().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CurrencyArray }
     * 
     * 
     */
    public List<CurrencyArray> getCurrencyArray() {
        if (currencyArray == null) {
            currencyArray = new ArrayList<CurrencyArray>();
        }
        return this.currencyArray;
    }

}