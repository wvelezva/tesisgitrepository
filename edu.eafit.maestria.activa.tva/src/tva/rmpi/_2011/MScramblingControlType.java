//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.5 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2012.05.23 at 05:28:03 PM COT 
//


package tva.rmpi._2011;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for MScramblingControlType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="MScramblingControlType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="maintained"/>
 *     &lt;enumeration value="changed"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "MScramblingControlType")
@XmlEnum
public enum MScramblingControlType {

    @XmlEnumValue("maintained")
    MAINTAINED("maintained"),
    @XmlEnumValue("changed")
    CHANGED("changed");
    private final String value;

    MScramblingControlType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static MScramblingControlType fromValue(String v) {
        for (MScramblingControlType c: MScramblingControlType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
