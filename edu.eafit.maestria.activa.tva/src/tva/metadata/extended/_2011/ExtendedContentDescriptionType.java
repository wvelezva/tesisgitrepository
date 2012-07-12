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
import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlList;
import javax.xml.bind.annotation.XmlType;
import org.w3c.dom.Element;
import tva.metadata._2011.BasicContentDescriptionType;
import tva.metadata._2011.BroadcastEventType;
import tva.metadata._2011.CRIDRefType;
import tva.metadata._2011.OnDemandProgramType;
import tva.metadata._2011.ServiceInformationType;


/**
 * <p>Java class for ExtendedContentDescriptionType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ExtendedContentDescriptionType">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:tva:metadata:2011}BasicContentDescriptionType">
 *       &lt;sequence>
 *         &lt;element name="ContentProperties" type="{urn:tva:metadata:extended:2011}ContentPropertiesType" minOccurs="0"/>
 *         &lt;element name="SourceLocation" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;choice>
 *                     &lt;element name="BroadcastEvent" type="{urn:tva:metadata:2011}BroadcastEventType" maxOccurs="unbounded" minOccurs="0"/>
 *                     &lt;element name="OnDemandProgram" type="{urn:tva:metadata:2011}OnDemandProgramType" maxOccurs="unbounded" minOccurs="0"/>
 *                     &lt;sequence>
 *                       &lt;element name="ContentIdRef" type="{urn:tva:metadata:2011}CRIDRefType" minOccurs="0"/>
 *                       &lt;element name="imi" type="{urn:tva:metadata:extended:2011}InstanceMetadataIdListType" minOccurs="0"/>
 *                     &lt;/sequence>
 *                   &lt;/choice>
 *                   &lt;element name="ServiceInformation" type="{urn:tva:metadata:2011}ServiceInformationType" maxOccurs="unbounded" minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;choice maxOccurs="unbounded" minOccurs="0">
 *           &lt;element name="TargetingInformation" type="{urn:tva:metadata:extended:2011}TargetingInformationType"/>
 *           &lt;element name="TargetingInformationRef" type="{urn:tva:metadata:2011}TVAIDRefType"/>
 *         &lt;/choice>
 *         &lt;element name="MaterialForPrinting" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;any processContents='lax' minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ExtendedContentDescriptionType", propOrder = {
    "contentProperties",
    "sourceLocation",
    "targetingInformationOrTargetingInformationRef",
    "materialForPrinting"
})
public class ExtendedContentDescriptionType
    extends BasicContentDescriptionType
{

    @XmlElement(name = "ContentProperties")
    protected ContentPropertiesType contentProperties;
    @XmlElement(name = "SourceLocation")
    protected ExtendedContentDescriptionType.SourceLocation sourceLocation;
    @XmlElements({
        @XmlElement(name = "TargetingInformation", type = TargetingInformationType.class),
        @XmlElement(name = "TargetingInformationRef", type = String.class)
    })
    protected List<Object> targetingInformationOrTargetingInformationRef;
    @XmlElement(name = "MaterialForPrinting")
    protected ExtendedContentDescriptionType.MaterialForPrinting materialForPrinting;

    /**
     * Gets the value of the contentProperties property.
     * 
     * @return
     *     possible object is
     *     {@link ContentPropertiesType }
     *     
     */
    public ContentPropertiesType getContentProperties() {
        return contentProperties;
    }

    /**
     * Sets the value of the contentProperties property.
     * 
     * @param value
     *     allowed object is
     *     {@link ContentPropertiesType }
     *     
     */
    public void setContentProperties(ContentPropertiesType value) {
        this.contentProperties = value;
    }

    /**
     * Gets the value of the sourceLocation property.
     * 
     * @return
     *     possible object is
     *     {@link ExtendedContentDescriptionType.SourceLocation }
     *     
     */
    public ExtendedContentDescriptionType.SourceLocation getSourceLocation() {
        return sourceLocation;
    }

    /**
     * Sets the value of the sourceLocation property.
     * 
     * @param value
     *     allowed object is
     *     {@link ExtendedContentDescriptionType.SourceLocation }
     *     
     */
    public void setSourceLocation(ExtendedContentDescriptionType.SourceLocation value) {
        this.sourceLocation = value;
    }

    /**
     * Gets the value of the targetingInformationOrTargetingInformationRef property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the targetingInformationOrTargetingInformationRef property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTargetingInformationOrTargetingInformationRef().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TargetingInformationType }
     * {@link String }
     * 
     * 
     */
    public List<Object> getTargetingInformationOrTargetingInformationRef() {
        if (targetingInformationOrTargetingInformationRef == null) {
            targetingInformationOrTargetingInformationRef = new ArrayList<Object>();
        }
        return this.targetingInformationOrTargetingInformationRef;
    }

    /**
     * Gets the value of the materialForPrinting property.
     * 
     * @return
     *     possible object is
     *     {@link ExtendedContentDescriptionType.MaterialForPrinting }
     *     
     */
    public ExtendedContentDescriptionType.MaterialForPrinting getMaterialForPrinting() {
        return materialForPrinting;
    }

    /**
     * Sets the value of the materialForPrinting property.
     * 
     * @param value
     *     allowed object is
     *     {@link ExtendedContentDescriptionType.MaterialForPrinting }
     *     
     */
    public void setMaterialForPrinting(ExtendedContentDescriptionType.MaterialForPrinting value) {
        this.materialForPrinting = value;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;any processContents='lax' minOccurs="0"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "any"
    })
    public static class MaterialForPrinting {

        @XmlAnyElement(lax = true)
        protected Object any;

        /**
         * Gets the value of the any property.
         * 
         * @return
         *     possible object is
         *     {@link Element }
         *     {@link Object }
         *     
         */
        public Object getAny() {
            return any;
        }

        /**
         * Sets the value of the any property.
         * 
         * @param value
         *     allowed object is
         *     {@link Element }
         *     {@link Object }
         *     
         */
        public void setAny(Object value) {
            this.any = value;
        }

    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;choice>
     *           &lt;element name="BroadcastEvent" type="{urn:tva:metadata:2011}BroadcastEventType" maxOccurs="unbounded" minOccurs="0"/>
     *           &lt;element name="OnDemandProgram" type="{urn:tva:metadata:2011}OnDemandProgramType" maxOccurs="unbounded" minOccurs="0"/>
     *           &lt;sequence>
     *             &lt;element name="ContentIdRef" type="{urn:tva:metadata:2011}CRIDRefType" minOccurs="0"/>
     *             &lt;element name="imi" type="{urn:tva:metadata:extended:2011}InstanceMetadataIdListType" minOccurs="0"/>
     *           &lt;/sequence>
     *         &lt;/choice>
     *         &lt;element name="ServiceInformation" type="{urn:tva:metadata:2011}ServiceInformationType" maxOccurs="unbounded" minOccurs="0"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "broadcastEvent",
        "onDemandProgram",
        "contentIdRef",
        "imi",
        "serviceInformation"
    })
    public static class SourceLocation {

        @XmlElement(name = "BroadcastEvent")
        protected List<BroadcastEventType> broadcastEvent;
        @XmlElement(name = "OnDemandProgram")
        protected List<OnDemandProgramType> onDemandProgram;
        @XmlElement(name = "ContentIdRef")
        protected CRIDRefType contentIdRef;
        @XmlList
        protected List<String> imi;
        @XmlElement(name = "ServiceInformation")
        protected List<ServiceInformationType> serviceInformation;

        /**
         * Gets the value of the broadcastEvent property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the broadcastEvent property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getBroadcastEvent().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link BroadcastEventType }
         * 
         * 
         */
        public List<BroadcastEventType> getBroadcastEvent() {
            if (broadcastEvent == null) {
                broadcastEvent = new ArrayList<BroadcastEventType>();
            }
            return this.broadcastEvent;
        }

        /**
         * Gets the value of the onDemandProgram property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the onDemandProgram property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getOnDemandProgram().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link OnDemandProgramType }
         * 
         * 
         */
        public List<OnDemandProgramType> getOnDemandProgram() {
            if (onDemandProgram == null) {
                onDemandProgram = new ArrayList<OnDemandProgramType>();
            }
            return this.onDemandProgram;
        }

        /**
         * Gets the value of the contentIdRef property.
         * 
         * @return
         *     possible object is
         *     {@link CRIDRefType }
         *     
         */
        public CRIDRefType getContentIdRef() {
            return contentIdRef;
        }

        /**
         * Sets the value of the contentIdRef property.
         * 
         * @param value
         *     allowed object is
         *     {@link CRIDRefType }
         *     
         */
        public void setContentIdRef(CRIDRefType value) {
            this.contentIdRef = value;
        }

        /**
         * Gets the value of the imi property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the imi property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getImi().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link String }
         * 
         * 
         */
        public List<String> getImi() {
            if (imi == null) {
                imi = new ArrayList<String>();
            }
            return this.imi;
        }

        /**
         * Gets the value of the serviceInformation property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the serviceInformation property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getServiceInformation().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link ServiceInformationType }
         * 
         * 
         */
        public List<ServiceInformationType> getServiceInformation() {
            if (serviceInformation == null) {
                serviceInformation = new ArrayList<ServiceInformationType>();
            }
            return this.serviceInformation;
        }

    }

}