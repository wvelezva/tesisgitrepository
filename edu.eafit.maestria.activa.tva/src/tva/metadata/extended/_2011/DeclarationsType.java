//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.5 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2012.05.23 at 05:28:03 PM COT 
//


package tva.metadata.extended._2011;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for DeclarationsType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DeclarationsType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;choice maxOccurs="unbounded">
 *         &lt;element name="Item" type="{urn:tva:metadata:extended:2011}ItemType"/>
 *         &lt;element name="Descriptor" type="{urn:tva:metadata:extended:2011}DescriptorType"/>
 *         &lt;element name="Component" type="{urn:tva:metadata:extended:2011}ComponentType"/>
 *         &lt;element name="Anchor" type="{urn:tva:metadata:extended:2011}AnchorType"/>
 *       &lt;/choice>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DeclarationsType", propOrder = {
    "itemOrDescriptorOrComponent"
})
public class DeclarationsType {

    @XmlElements({
        @XmlElement(name = "Item", type = ItemType.class),
        @XmlElement(name = "Descriptor", type = DescriptorType.class),
        @XmlElement(name = "Component", type = ComponentType.class),
        @XmlElement(name = "Anchor", type = AnchorType.class)
    })
    protected List<Object> itemOrDescriptorOrComponent;

    /**
     * Gets the value of the itemOrDescriptorOrComponent property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the itemOrDescriptorOrComponent property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getItemOrDescriptorOrComponent().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ItemType }
     * {@link DescriptorType }
     * {@link ComponentType }
     * {@link AnchorType }
     * 
     * 
     */
    public List<Object> getItemOrDescriptorOrComponent() {
        if (itemOrDescriptorOrComponent == null) {
            itemOrDescriptorOrComponent = new ArrayList<Object>();
        }
        return this.itemOrDescriptorOrComponent;
    }

}