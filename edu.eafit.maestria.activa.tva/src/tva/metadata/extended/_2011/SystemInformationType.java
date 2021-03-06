//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.5 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2012.05.23 at 05:28:03 PM COT 
//


package tva.metadata.extended._2011;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlElementRefs;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for SystemInformationType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SystemInformationType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence maxOccurs="unbounded" minOccurs="0">
 *         &lt;element name="SupportingOS" type="{urn:tva:metadata:extended:2011}VersionedControlledTermType" minOccurs="0"/>
 *         &lt;element name="MiddleWare" type="{urn:tva:metadata:extended:2011}VersionedControlledTermType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="VirtualMachine" type="{urn:tva:metadata:extended:2011}VersionedControlledTermType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="OtherSystemSW" type="{urn:tva:metadata:extended:2011}VersionedControlledTermType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="CPU" type="{urn:tva:metadata:extended:2011}CPUType" minOccurs="0"/>
 *         &lt;element name="RAM" type="{urn:tva:metadata:extended:2011}RAMType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SystemInformationType", propOrder = {
    "supportingOSAndMiddleWareAndVirtualMachine"
})
public class SystemInformationType {

    @XmlElementRefs({
        @XmlElementRef(name = "CPU", namespace = "urn:tva:metadata:extended:2011", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "OtherSystemSW", namespace = "urn:tva:metadata:extended:2011", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "RAM", namespace = "urn:tva:metadata:extended:2011", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "VirtualMachine", namespace = "urn:tva:metadata:extended:2011", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "MiddleWare", namespace = "urn:tva:metadata:extended:2011", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "SupportingOS", namespace = "urn:tva:metadata:extended:2011", type = JAXBElement.class, required = false)
    })
    protected List<JAXBElement<?>> supportingOSAndMiddleWareAndVirtualMachine;

    /**
     * Gets the value of the supportingOSAndMiddleWareAndVirtualMachine property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the supportingOSAndMiddleWareAndVirtualMachine property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSupportingOSAndMiddleWareAndVirtualMachine().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link JAXBElement }{@code <}{@link VersionedControlledTermType }{@code >}
     * {@link JAXBElement }{@code <}{@link CPUType }{@code >}
     * {@link JAXBElement }{@code <}{@link VersionedControlledTermType }{@code >}
     * {@link JAXBElement }{@code <}{@link VersionedControlledTermType }{@code >}
     * {@link JAXBElement }{@code <}{@link RAMType }{@code >}
     * {@link JAXBElement }{@code <}{@link VersionedControlledTermType }{@code >}
     * 
     * 
     */
    public List<JAXBElement<?>> getSupportingOSAndMiddleWareAndVirtualMachine() {
        if (supportingOSAndMiddleWareAndVirtualMachine == null) {
            supportingOSAndMiddleWareAndVirtualMachine = new ArrayList<JAXBElement<?>>();
        }
        return this.supportingOSAndMiddleWareAndVirtualMachine;
    }

}
