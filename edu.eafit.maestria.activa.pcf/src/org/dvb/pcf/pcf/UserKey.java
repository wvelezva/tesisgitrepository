//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.5 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2012.03.27 at 06:52:02 AM COT 
//


package org.dvb.pcf.pcf;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;
import org.dvb.pcf.pcf_types.PcfItemType;
import org.dvb.pcf.pcf_types.Userkey;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.dvb.org/pcf/pcf-types}pcfItemType">
 *       &lt;attGroup ref="{http://www.dvb.org/pcf/pcf}propertyAttrs"/>
 *       &lt;attribute name="value" type="{http://www.dvb.org/pcf/pcf-types}userkey" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
public class UserKey
    extends PcfItemType
{

    @XmlAttribute(name = "value")
    protected Userkey value;
    @XmlAttribute(name = "exact")
    protected java.lang.Boolean exact;

    /**
     * Gets the value of the value property.
     * 
     * @return
     *     possible object is
     *     {@link Userkey }
     *     
     */
    public Userkey getValue() {
        return value;
    }

    /**
     * Sets the value of the value property.
     * 
     * @param value
     *     allowed object is
     *     {@link Userkey }
     *     
     */
    public void setValue(Userkey value) {
        this.value = value;
    }

    /**
     * Gets the value of the exact property.
     * 
     * @return
     *     possible object is
     *     {@link java.lang.Boolean }
     *     
     */
    public boolean isExact() {
        if (exact == null) {
            return false;
        } else {
            return exact;
        }
    }

    /**
     * Sets the value of the exact property.
     * 
     * @param value
     *     allowed object is
     *     {@link java.lang.Boolean }
     *     
     */
    public void setExact(java.lang.Boolean value) {
        this.exact = value;
    }

}
