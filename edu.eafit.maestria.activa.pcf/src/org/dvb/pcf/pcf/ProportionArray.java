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
 *         &lt;element ref="{http://www.dvb.org/pcf/pcf}Proportion" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{http://www.dvb.org/pcf/pcf}ProportionArray" maxOccurs="unbounded" minOccurs="0"/>
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
    "proportion",
    "proportionArray"
})
public class ProportionArray
    extends PcfItemArrayType
{

    @XmlElement(name = "Proportion", nillable = true)
    protected List<Proportion> proportion;
    @XmlElement(name = "ProportionArray", nillable = true)
    protected List<ProportionArray> proportionArray;

    /**
     * Gets the value of the proportion property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the proportion property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getProportion().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Proportion }
     * 
     * 
     */
    public List<Proportion> getProportion() {
        if (proportion == null) {
            proportion = new ArrayList<Proportion>();
        }
        return this.proportion;
    }

    /**
     * Gets the value of the proportionArray property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the proportionArray property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getProportionArray().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ProportionArray }
     * 
     * 
     */
    public List<ProportionArray> getProportionArray() {
        if (proportionArray == null) {
            proportionArray = new ArrayList<ProportionArray>();
        }
        return this.proportionArray;
    }

}
