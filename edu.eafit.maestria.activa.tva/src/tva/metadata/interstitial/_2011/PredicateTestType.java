//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.5 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2012.05.23 at 05:28:03 PM COT 
//


package tva.metadata.interstitial._2011;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PredicateTestType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="PredicateTestType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="equals"/>
 *     &lt;enumeration value="not_equals"/>
 *     &lt;enumeration value="contains"/>
 *     &lt;enumeration value="greater_than"/>
 *     &lt;enumeration value="greater_than_or_equals"/>
 *     &lt;enumeration value="less_than"/>
 *     &lt;enumeration value="less_than_or_equals"/>
 *     &lt;enumeration value="exists"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "PredicateTestType")
@XmlEnum
public enum PredicateTestType {

    @XmlEnumValue("equals")
    EQUALS("equals"),
    @XmlEnumValue("not_equals")
    NOT_EQUALS("not_equals"),
    @XmlEnumValue("contains")
    CONTAINS("contains"),
    @XmlEnumValue("greater_than")
    GREATER_THAN("greater_than"),
    @XmlEnumValue("greater_than_or_equals")
    GREATER_THAN_OR_EQUALS("greater_than_or_equals"),
    @XmlEnumValue("less_than")
    LESS_THAN("less_than"),
    @XmlEnumValue("less_than_or_equals")
    LESS_THAN_OR_EQUALS("less_than_or_equals"),
    @XmlEnumValue("exists")
    EXISTS("exists");
    private final String value;

    PredicateTestType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static PredicateTestType fromValue(String v) {
        for (PredicateTestType c: PredicateTestType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
